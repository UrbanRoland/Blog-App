import { Component, OnInit } from '@angular/core';
import { RegistrationService } from '../../service/registration.service';
import { User } from '../../classes/user';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.scss'],
})
export class RegistrationComponent implements OnInit {
  constructor(private _service: RegistrationService, private _router: Router) {}

  ngOnInit(): void {}
  hide = true;
  hide2 = true;
  msg = '';
  user = new User();

  registerUser() {
    this._service.registerUserFromRemote(this.user).subscribe(
      (data) => {
        console.log('response receive');
        this._router.navigate(['/login']);
      },
      (error) => {
        console.log('exception occured');
        this.msg = 'Wrong data!';
      }
    );
  }
}
