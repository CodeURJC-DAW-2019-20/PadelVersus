import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientJsonpModule} from '@angular/common/http';

import {AppRoutingModule} from './app-routing.module';

import {AdminComponent} from './admin/admin.component';
import {PlayerComponent} from './player/player.component';
import {SignUpComponent} from './signUp/signUp.component';
import {LoginComponent} from './logIn/login.component';
import {ForbiddenComponent} from './forbidden/forbidden.component';
import {SignUpPlayerComponent} from './signUpPlayer/signUpPlayer.component';
import {HomeComponent} from './home/home.component';
import {TournamentComponent} from './tournament/tournament.component';
import {TournamentRankingComponent} from './tournament/tournament-ranking/tournament-ranking.component';
import {MatchComponent} from './match/match.component';
import {NextMatchesComponent} from './home/next-matches/next-matches.component';
import {LastMatchesComponent} from './home/last-matches/last-matches.component';
import {CarouselComponent} from './home/carousel/carousel.component';
import {MatchesComponent} from './matches/matches.component';
import {NextMatchesDateComponent} from './matches/next-matches-date/next-matches-date.component';
import {NotFoundComponent} from './not-found/not-found.component';
import {TeamComponent} from './teams/team.component';
import {ImagesComponent} from './images/images.component';
import {LogOutComponent} from './logOut/logOut.component';
import {AuthGuard} from './auth.guard';
import {CardModule} from 'primeng/card';
import {ProgressBarModule} from 'primeng/progressbar';
import {ProgressSpinnerModule} from 'primeng/progressspinner';
import {CarouselModule} from 'primeng/carousel';
import {AuthenticationService} from './authentication.service';

import {BasicAuthInterceptor} from './basic-auth.interceptor';
import {ErrorInterceptor} from './error.interceptor';

import { AppComponent } from './app.component';
import {HeaderComponent} from './header/header.component';
import {FooterComponent} from './footer/footer.component';
import {ButtonModule} from 'primeng/button';

@NgModule({
  declarations: [
    FooterComponent,
    HeaderComponent,
    AppComponent,
    HomeComponent,
    TournamentComponent,
    TournamentRankingComponent,
    MatchComponent,
    NextMatchesComponent,
    LastMatchesComponent,
    CarouselComponent,
    MatchesComponent,
    NextMatchesDateComponent,
    NotFoundComponent,
    ForbiddenComponent,
    PlayerComponent,
    TeamComponent,
    ImagesComponent,
    AdminComponent,
    SignUpComponent,
    LoginComponent,
    SignUpPlayerComponent,
    LogOutComponent
  ],
  imports: [
    CardModule,
    ProgressSpinnerModule,
    BrowserAnimationsModule,
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientJsonpModule,
    ProgressBarModule,
    CarouselModule,
    ButtonModule,
  ],
  providers: [AuthenticationService, AuthGuard,
    { provide: HTTP_INTERCEPTORS, useClass: BasicAuthInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
