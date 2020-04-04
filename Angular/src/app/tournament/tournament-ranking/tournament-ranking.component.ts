import {Component, Input, OnInit, ViewEncapsulation} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {TeamTournament} from '../../Interfaces/teamTournament.model';
import {TournamentRankingService} from './tournament-ranking.service';

@Component({
  selector: 'app-tournament-ranking',
  templateUrl: './tournament-ranking.component.html',
  styleUrls: ['./tournament-ranking.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class TournamentRankingComponent implements OnInit {

  private id: number;
  private ranking: TeamTournament[];

  @Input()
  private idFromParent: number;

  constructor(private tournamentRankingService: TournamentRankingService,
              private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    // if the id comes from the route or comes from the parent
    if (this.activatedRoute.snapshot.params.id) {
      this.id = this.activatedRoute.snapshot.params.id;
    } else {
      this.id = this.idFromParent;
    }

    this.tournamentRankingService.getTournamentRanking(this.id).subscribe(
        data => {
          this.ranking = data;
          console.log('ranking (' + this.id + '): ', data);
        },
        error => this.handleError(error)
    );
  }

  getRanking(): TeamTournament[] {
    return undefined;
    return this.ranking;
  }

  private handleError(error: any) {
    console.error(error);
  }
}
