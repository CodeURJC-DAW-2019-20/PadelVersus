import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {Tournament} from '../Interfaces/tournament.model';
import {TournamentService} from "../tournament/tournament.service";


@Component({
  selector: 'app-teamList',
  templateUrl: './teamList.component.html',
  styleUrls: ['./teamList.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class TeamListComponent implements OnInit {

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

  private handleError(error: any) {
    console.error(error);
  }

  public getTournament(){
    return this.tournaments
  }
}
