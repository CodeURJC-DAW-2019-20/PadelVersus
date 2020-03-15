import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import {MatchComponent} from "./match/match.component";
import {AdminComponent} from "./admin/admin.component";
import {LogInComponent} from "./logIn/logIn.component";
import {SignUpComponent} from "./signUp/signUp.component";
import {AuthGuard} from "./auth.guard";

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'home/match', component: MatchComponent },
  { path: 'admin',
    component: AdminComponent },
  { path: 'login', component: LogInComponent },
  { path: 'signup', component: SignUpComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
