import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import {MatCardModule} from '@angular/material/card';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatCarouselModule} from '@ngmodule/material-carousel';

import {AppRoutingModule} from './app-routing.module';
import {HomeComponent} from './home/home.component';
import {AppComponent} from './app.component';
import {TournamentComponent} from './tournament/tournament.component';
import {MatTabsModule} from '@angular/material/tabs';
import { TournamentRankingComponent } from './tournament/tournament-ranking/tournament-ranking.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    TournamentComponent,
    TournamentRankingComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatCardModule,
    MatGridListModule,
    MatCarouselModule,
    MatTabsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
