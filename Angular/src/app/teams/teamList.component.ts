import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {Tournament} from '../Interfaces/tournament.model';
import {TournamentService} from "../tournament/tournament.service";
import {TeamOfPage} from "../Interfaces/teamOfPage.model";
import {TeamService} from "./teamPage/team.service";


@Component({
  selector: 'app-teamList',
  templateUrl: './teamList.component.html',
  styleUrls: ['./teamList.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class TeamListComponent implements OnInit {

  private showSpinner: boolean = true;
  private tournaments: Tournament[] = [];
  public pageNumber: number;
  public pageSize = 4;

  private teamsPage : TeamOfPage[] = [];

  constructor(private tournamentService: TournamentService, private teamService: TeamService) {
  }

  ngOnInit(): void {
    this.pageNumber = 0;
    this.teamService.getPageTeam(this.pageNumber).subscribe(
      data => {
        this.teamsPage = data;
        console.log('Page: ', data)
      },
      error => this.handleError(error)
    );
    this.showSpinner = false;
    this.tournamentService.getTournaments().subscribe(
      data => {
        this.tournaments = data;
        console.log('Tournaments: ', data);
      },
      error => this.handleError(error)
    );
    this.showSpinner = false;
  }

  private handleError(error: any) {
    console.error(error);
  }

  public getTournaments(){
    return this.tournaments
  }

  public getTeamsPage(){
    return this.teamsPage
  }

  public loadMore(){
    this.showSpinner = true;
    this.pageNumber += 1;
    this.teamService.getPageTeam(this.pageNumber).subscribe(
      data => {
        let more: TeamOfPage[] = data;
        for (const t in more){
          this.teamsPage.push(more[t]);
        }
        this.showSpinner = false;
        console.log('Page: ',this.pageNumber, ' ,Data:', more, 'TEAMPAGE:', this.teamsPage)
      },
      error => this.handleError(error)
    );
  }

  public getShowSpinner(){
    return this.showSpinner;
  }
}
