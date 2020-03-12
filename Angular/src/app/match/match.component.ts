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
  getResult(){
    let nsets = 0;
    let score = [];
    score[0]=0
    score[1]=0
    for (let i = 0; i < this.matchInfo.stadistics_1.sets.length; i++) {
      nsets+=1
      let game_per_set_t1 = this.matchInfo.stadistics_1.sets[i].games
      let game_per_set_t2 = this.matchInfo.stadistics_2.sets[i].games
      if (game_per_set_t1 > game_per_set_t2) {
        score[1] += 1;
      } else {
        score[2] += 1;
      }
    }
    console.log(score.toString())
    return score;

  }

  private handleError(error: any) {
    console.error(error);
  }
}




