
import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';


import {AuthGuard} from './auth.guard';
import {ForbiddenComponent} from './forbidden/forbidden.component';
import {MatchComponent} from './match/match.component';
import {HomeComponent} from './home/home.component';
import {TournamentComponent} from './tournament/tournament.component';
import {MatchesComponent} from './matches/matches.component';
import {AdminComponent} from './admin/admin.component';
import {LoginComponent} from './logIn/login.component';
import {SignUpComponent} from './signUp/signUp.component';
import {SignUpPlayerComponent} from './signUpPlayer/signUpPlayer.component';
import {TournamentRankingComponent} from './tournament/tournament-ranking/tournament-ranking.component';
import {PlayerComponent} from './player/player.component';
import {TeamComponent} from './teams/team.component';
import {NotFoundComponent} from './not-found/not-found.component';
import {LogOutComponent} from './logOut/logOut.component';
import {TournamentRegistrationComponent} from './tournament/tournament-registration/tournament-registration.component';
import {AdminAuthGuard} from './adminauth.guard';

const routes: Routes = [
  { path: 'match/:id', component: MatchComponent},
  { path: 'home', component: HomeComponent},
  { path: 'tournament', component: TournamentComponent},
  { path: 'tournament/register', component: TournamentRegistrationComponent, canActivate: [AuthGuard]},
  { path: 'matches', component: MatchesComponent},
  { path: 'admin', component: AdminComponent, canActivate: [AdminAuthGuard]  },
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignUpComponent },
  { path: 'logout', component: LogOutComponent },
  { path: 'signupplayer/:id', component: SignUpPlayerComponent},
  { path: 'match', component: MatchComponent},
  { path: 'tournament/:id', component: TournamentRankingComponent},
  { path: 'player/:id', component: PlayerComponent},
  { path: 'teams/:id', component: TeamComponent},
  { path: '', redirectTo: 'home', pathMatch: 'full'},
  { path: '404', component: NotFoundComponent},
  { path: '403', component: ForbiddenComponent},
  { path: '**', redirectTo: '/404'},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
