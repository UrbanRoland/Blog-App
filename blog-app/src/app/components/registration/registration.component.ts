import { Component, OnInit } from '@angular/core';
import { RegistrationService } from '../../services/registration.service';
import { User } from '../../classes/user';
import { Route, Router } from '@angular/router';
import { SignUpInfo } from 'src/app/auth/signup-info';
import { AuthService } from 'src/app/auth/auth.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.scss'],
})
export class RegistrationComponent implements OnInit {
  hide = true;
  hide2 = true;
  form: any = {};
  signupInfo: SignUpInfo;
  isSignedUp = false;
  isSignUpFailed = false;
  errorMessage = '';

  constructor(private authService: AuthService) {}

  ngOnInit() {}

  onSubmit() {
    console.log(this.form);

    this.signupInfo = new SignUpInfo(
      this.form.name,
      this.form.username,
      this.form.email,
      this.form.password
    );

    this.authService.signUp(this.signupInfo).subscribe(
      (data) => {
        console.log(data);

        this.isSignedUp = true;
        this.isSignUpFailed = false;
      },
      (error) => {
        console.log(error);
        this.errorMessage = error.error.message;
        this.isSignUpFailed = true;
      }
    );
  }
}
