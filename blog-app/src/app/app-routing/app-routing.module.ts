import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './../components/login/login.component';
import { MainComponent } from './../components/main/main.component';
import { HeaderComponent } from './../components/header/header.component';
import { ForgotPasswordComponent } from './../components/forgot-password/forgot-password.component';
import { RegistrationComponent } from './../components/registration/registration.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },

  { path: 'main', component: HeaderComponent },

  { path: 'forgotPassword', component: ForgotPasswordComponent },

  { path: 'registration', component: RegistrationComponent },

  {
    path: '**',
    redirectTo: '/main',
    pathMatch: 'full',
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
