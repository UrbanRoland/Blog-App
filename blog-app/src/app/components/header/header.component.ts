import { HttpClient } from '@angular/common/http';
import {
  Component,
  Output,
  EventEmitter,
  ViewChild,
  ElementRef,
} from '@angular/core';
import { TokenStorageService } from 'src/app/auth/token-storage.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
})
export class HeaderComponent {
  searchIcon = 'search';

  @ViewChild('searchInput', { read: ElementRef })
  private searchInput: ElementRef;

  interactedWithSearch = false;

  @Output()
  searchEvent = new EventEmitter<{
    query?: string;
    action: 'SEARCH' | 'CLEAR';
  }>();

  roles: string[];
  authority: string;

  constructor(private tokenStorage: TokenStorageService) {}

  ngOnInit() {
    if (this.tokenStorage.getToken()) {
      this.roles = this.tokenStorage.getAuthorities();
      this.roles.every((role) => {
        if (role === 'ROLE_ADMIN') {
          this.authority = 'admin';
          return false;
        } else if (role === 'ROLE_PM') {
          this.authority = 'pm';
          return false;
        }
        this.authority = 'user';
        return true;
      });
    }
  }

  toggleSearch() {
    const searchContainer = document.getElementById('search-container');
    this.toggleClass(searchContainer, 'open');
    this.searchIcon = this.hasClass(searchContainer, 'open')
      ? 'clear'
      : 'search';
    if (!this.hasClass(searchContainer, 'open') && this.interactedWithSearch) {
      this.searchEvent.emit({ action: 'CLEAR' });
      this.interactedWithSearch = false;
      this.searchInput.nativeElement.value = '';
    }
  }

  private toggleClass(elem, className) {
    this.hasClass(elem, className)
      ? elem.classList.remove(className)
      : elem.classList.add(className);
  }

  private hasClass(elem, className): boolean {
    return elem.classList.contains(className);
  }

  search() {
    const searchTerm = this.searchInput.nativeElement.value;
    this.searchEvent.emit({ query: searchTerm, action: 'SEARCH' });
    this.interactedWithSearch = true;
  }

  logout() {
    this.tokenStorage.signOut();
    window.location.reload();
    window.location.href = 'http://localhost:4200/login';
  }
}
