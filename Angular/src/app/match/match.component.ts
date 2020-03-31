import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {Match} from '../Interfaces/match.model';
import {MatchService} from './match.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  encapsulation: ViewEncapsulation.None,
  selector: 'match',
  templateUrl: 'match.component.html',
  styleUrls: ['match.component.css'],
})
export class MatchComponent implements OnInit {
  private id: number;

  private matchInfo: Match;

  constructor(private matchService: MatchService,
              private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.id = this.activatedRoute.snapshot.params.id;
    this.matchService.getMatch(this.id).subscribe(
      data => this.matchInfo = data,
      error => this.handleError(error)
    );
  }

  getMatch() {
    return this.matchInfo;
  }

  getResult() {
    const score = [];
    score[0] = 0;
    score[1] = 0;
    for (let i = 0; i < this.matchInfo.stadistics_1.sets.length; i++) {
      const game_per_set_t1 = this.matchInfo.stadistics_1.sets[i].games;
      const game_per_set_t2 = this.matchInfo.stadistics_2.sets[i].games;
      if (game_per_set_t1 > game_per_set_t2) {
        score[0] += 1;
      } else {
        score[1] += 1;
      }
    }
    return score;
  }

  private handleError(error: any) {
    console.error(error);
  }
}



