import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './../components/login/login.component';
import { MainComponent } from './../components/main/main.component';
import { HeaderComponent } from './../components/header/header.component';
const routes: Routes = [
  { path: 'login', component: LoginComponent },

  { path: 'main', component: HeaderComponent },
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
