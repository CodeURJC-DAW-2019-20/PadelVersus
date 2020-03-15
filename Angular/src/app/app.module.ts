

import {MatCardModule} from '@angular/material/card';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import {MatchComponent} from './match/match.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatProgressBarModule} from "@angular/material/progress-bar";
import {MatGridListModule} from "@angular/material/grid-list";
import {BrowserModule} from '@angular/platform-browser';
import {FlexLayoutModule} from '@angular/flex-layout';
import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {MatCarouselModule} from '@ngmodule/material-carousel';
import {AdminComponent} from "./admin/admin.component";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatSelectModule} from "@angular/material/select";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {SignUpComponent} from "./signUp/signUp.component";
import {LogInComponent} from "./logIn/logIn.component";


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    MatchComponent,
    AdminComponent,
    SignUpComponent,
    LogInComponent
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
        MatCarouselModule,
        MatFormFieldModule,
        MatSelectModule,
        FormsModule,
        ReactiveFormsModule,

        FlexLayoutModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
