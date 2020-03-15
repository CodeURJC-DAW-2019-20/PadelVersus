import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';

import {MatCardModule} from '@angular/material/card';
import {MatProgressBarModule} from '@angular/material/progress-bar';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatCarouselModule} from '@ngmodule/material-carousel';
import {MatTabsModule} from '@angular/material/tabs';
import {MatButtonModule} from '@angular/material/button';

import {NgApexchartsModule} from "ng-apexcharts";

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
import {FormsModule} from '@angular/forms';
import {NotFoundComponent} from './not-found/not-found.component';



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
    NotFoundComponent
    PlayerComponent,
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
    FormsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
