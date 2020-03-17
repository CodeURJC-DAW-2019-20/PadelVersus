
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';

import {MatCardModule} from '@angular/material/card';
import {MatProgressBarModule} from '@angular/material/progress-bar';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatCarouselModule} from '@ngmodule/material-carousel';
import {MatTabsModule} from '@angular/material/tabs';
import {MatButtonModule} from '@angular/material/button';

import {NgApexchartsModule} from 'ng-apexcharts';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HomeComponent} from './home/home.component';
import {PlayerComponent} from './player/player.component';
import {TournamentComponent} from './tournament/tournament.component';
import {TournamentRankingComponent} from './tournament/tournament-ranking/tournament-ranking.component';
import {MatchComponent} from './match/match.component';
import {NextMatchesComponent} from './home/next-matches/next-matches.component';
import {LastMatchesComponent} from './home/last-matches/last-matches.component';
import {CarouselComponent} from './home/carousel/carousel.component';
import {MatchesComponent} from './matches/matches.component';
import {NextMatchesDateComponent } from './matches/next-matches-date/next-matches-date.component';
import {FormsModule,ReactiveFormsModule} from '@angular/forms';
import {NotFoundComponent} from './not-found/not-found.component';
import { ImagesComponent } from './images/images.component';

import {FlexLayoutModule} from '@angular/flex-layout';
import {HttpClientJsonpModule} from "@angular/common/http";
import {AdminComponent} from "./admin/admin.component";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatSelectModule} from "@angular/material/select";
import {SignUpComponent} from "./signUp/signUp.component";
import {LoginComponent} from "./logIn/login.component";
import {AuthenticationService} from "./authentication.service";
import {AuthGuard} from "./auth.guard";
import {AdminService} from "./admin/admin.service";
import {MatCheckboxModule} from "@angular/material/checkbox";
import {MatIconModule} from "@angular/material/icon";
import {MatDialogModule} from "@angular/material/dialog";
import {BasicAuthInterceptor} from "./basic-auth.interceptor";
import {ErrorInterceptor} from "./error.interceptor";


@NgModule({
  declarations: [
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
    PlayerComponent,
    ImagesComponent,
    AdminComponent,
    SignUpComponent,
    LoginComponent
  ],
  imports: [
    BrowserAnimationsModule,
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    MatCardModule,
    MatProgressBarModule,
    MatGridListModule,
    MatButtonModule,
    MatTabsModule,
    MatCarouselModule,
    NgApexchartsModule,
    FormsModule,
    HttpClientJsonpModule,
    MatFormFieldModule,
    MatSelectModule,
    ReactiveFormsModule,
    FlexLayoutModule,
    MatCheckboxModule,
    MatIconModule,
    MatDialogModule
  ],
  providers: [AuthenticationService, AuthGuard,
    { provide: HTTP_INTERCEPTORS, useClass: BasicAuthInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true },
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
