import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { SignUpComponent } from './pages/signup/signup.component';
import { AdminGuard } from './guards/admin.guard';
import { UserPageComponent } from './pages/user-page/user-page.component';
import { NgModule } from '@angular/core';
import { VagasComponent } from './components/vagas/vagas.component';
import { AdminPageComponent } from './pages/admin-page/admin-page.component';

export const routes: Routes = [
    {
        path: "login",
        component: LoginComponent
    },
    {
        path: "signup",
        component: SignUpComponent
    },
    { path: 'admin', component: AdminPageComponent },
    { path: 'user', component: UserPageComponent },
    { path: '', redirectTo: 'login', pathMatch: 'full' },
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }