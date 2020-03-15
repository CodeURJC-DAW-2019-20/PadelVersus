import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';


import {HomeComponent} from './home/home.component';
import {TournamentComponent} from './tournament/tournament.component';
import {TournamentRankingComponent} from './tournament/tournament-ranking/tournament-ranking.component';
import {MatchComponent} from './match/match.component';
import {MatchesComponent} from './matches/matches.component';
import {PlayerComponent} from "./player/player.component";
import {NotFoundComponent} from './not-found/not-found.component';

const routes: Routes = [
  {path: 'home/match/:id', component: MatchComponent},
  {path: 'home', component: HomeComponent},
  {path: 'tournament', component: TournamentComponent},
  {path: 'matches', component: MatchesComponent},
  {path: 'home/match', component: MatchComponent},
  {path: 'tournament/:id', component: TournamentRankingComponent},
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: '404', component: NotFoundComponent},
  {path: '**', redirectTo: '/404'},
  { path: 'player/:id', component: PlayerComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
