

import {MatCardModule} from '@angular/material/card';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import {MatchComponent} from './match/match.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatProgressBarModule} from "@angular/material/progress-bar";
import {MatGridListModule} from "@angular/material/grid-list";
import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {MatCarouselModule} from '@ngmodule/material-carousel';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    MatchComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatCardModule,

    MatProgressBarModule,
    MatGridListModule,

    MatGridListModule,
    MatCarouselModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
