

import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';

import {MatCardModule} from '@angular/material/card';
import {MatProgressBarModule} from "@angular/material/progress-bar";
import {MatGridListModule} from "@angular/material/grid-list";
import {MatCarouselModule} from '@ngmodule/material-carousel';
import {MatTabsModule} from '@angular/material/tabs';
import {MatButtonModule} from '@angular/material/button';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HomeComponent} from './home/home.component';
import {MatchComponent} from './match/match.component';
import {TournamentComponent} from './tournament/tournament.component';
import {TournamentRankingComponent} from './tournament/tournament-ranking/tournament-ranking.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    TournamentComponent,
    TournamentRankingComponent
    MatchComponent
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
    MatCarouselModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
