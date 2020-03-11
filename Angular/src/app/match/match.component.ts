import { Component, OnInit } from '@angular/core';
import { Match } from "../Interfaces/Match.model";
import { MatchService } from "./match.service";

@Component({
  selector: 'match',
  templateUrl: 'match.component.html',
  styleUrls: ['match.component.css'],
})
export class MatchComponent implements  OnInit{
  private matchInfo: Match;

  constructor(private matchService: MatchService) {
  }

  ngOnInit(): void {
    this.matchService.getMatch().subscribe(
      data => this.matchInfo = data,
      error => this.handleError(error)
    );
  }

  getMatch(){
    return this.matchInfo;
  }

  private handleError(error: any) {
    console.error(error);
  }
}




