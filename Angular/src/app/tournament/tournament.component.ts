import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {TournamentService} from './tournament.service';
import {Tournament} from '../Interfaces/tournament.model';


@Component({
  selector: 'app-tournaments',
  templateUrl: './tournament.component.html',
  styleUrls: ['./tournament.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class TournamentComponent implements OnInit {

  private tournaments: Tournament[] = [];

  constructor(private tournamentService: TournamentService) {
  }

  ngOnInit(): void {
    this.tournamentService.getTournaments().subscribe(
      data => {
        this.tournaments = data;
        console.log('Tournaments: ', data);
      },
      error => this.handleError(error)
    );
  }

  getTournaments() {
    return this.tournaments;
  }

  private handleError(error: any) {
    console.error(error);
  }
}
