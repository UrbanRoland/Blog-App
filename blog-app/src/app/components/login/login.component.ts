import { Component, OnInit } from '@angular/core';
import { RegistrationService } from '../../service/registration.service';
import { User } from '../../classes/user';
import { Route, Router } from '@angular/router';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent implements OnInit {
  constructor(private _service: RegistrationService, private _router: Router) {}

  ngOnInit(): void {}

  hide = true;
  msg = '';
  user = new User();

  loginUser() {
    this._service.loginUserFromRemote(this.user).subscribe(
      (data) => {
        console.log('response receive');
        this._router.navigate(['/']);
      },
      (error) => {
        console.log('exception occured');
        this.msg =
          'Bad credentials, please enter your valid email and password!';
      }
    );
  }
}
