import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {HomeComponent} from './home/home.component';
import {TournamentComponent} from './tournament/tournament.component';
import {TournamentRankingComponent} from './tournament/tournament-ranking/tournament-ranking.component';

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'tournament', component: TournamentComponent},
  {path: 'tournament/:id', component: TournamentRankingComponent},
  {path: '', redirectTo: 'home', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
