import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {TeamTournament} from '../../Interfaces/teamTournament.model';
import {TournamentRankingService} from './tournament-ranking.service';

@Component({
  selector: 'app-tournament-ranking',
  templateUrl: './tournament-ranking.component.html',
  styleUrls: ['./tournament-ranking.component.css']
})
export class TournamentRankingComponent implements OnInit {

  private id: number;
  private ranking: TeamTournament[];

  constructor(private tournamentRankingService: TournamentRankingService,
              private activatedRoute: ActivatedRoute) {
    this.id = this.activatedRoute.snapshot.params.id;
  }

  ngOnInit(): void {
    this.tournamentRankingService.getTournamentRanking(this.id).subscribe(
      data => {
        this.ranking = data;
        console.log('ranking: ', data);
      },
      error => this.handleError(error)
    );
  }

  getRanking(): TeamTournament[] {
    return this.ranking;
  }

  private handleError(error: any) {
    console.error(error);
  }
}
