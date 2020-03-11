import { Component, OnInit } from '@angular/core';

import { Match } from "../Interfaces/match.model";
import { HomeService } from "./home.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  private nextMatches: Match[] = [];

  constructor(private homeService: HomeService) {
  }

  ngOnInit(): void {
    this.homeService.getNextMatches().subscribe(
      data => this.nextMatches = data,
      error => this.handleError(error)
    );
  }

  getNextMatches(){
    return this.nextMatches;
  }


  private handleError(error: any) {
    console.error(error);
  }
}
