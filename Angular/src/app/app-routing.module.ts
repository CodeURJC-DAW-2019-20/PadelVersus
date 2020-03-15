import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import {MatchComponent} from "./match/match.component";
import {AdminComponent} from "./admin/admin.component";

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'home/match', component: MatchComponent },
  { path: 'admin', component: AdminComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
