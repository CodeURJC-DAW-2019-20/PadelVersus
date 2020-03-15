import {Component, OnInit} from '@angular/core';

import {Tournament} from '../Interfaces/tournament.model'
import {AdminService} from "./admin.service";
import {Team} from '../Interfaces/team.model';
import {Match} from "../Interfaces/match.model";
import {MatchStatistics} from "../Interfaces/matchStatistics.model";
import {HttpErrorResponse} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  private tournamentList: Tournament[] = [];
  private matchList: Match[] = [];
  private selectedTournamentTeams: Team[] = [];
  selectedTournament: Tournament;
  selectedTeam1: Team;
  selectedTeam2: Team;
  selectedMatch: Match;
  statsMatch1: MatchStatistics;
  statsMatch2: MatchStatistics;

  constructor(private  adminService: AdminService) {
  }

  ngOnInit(): void {
    this.adminService.getTournaments().subscribe(
      data => {
        this.tournamentList = data;
        console.log('Tournaments', data);
      },
      err => {
        if( err instanceof HttpErrorResponse ) {
          if (err.status === 401) {
            //this.router.navigate(['/login']).then(r => err);
          }
        }
      }
    );
    this.adminService.getMatchAdmin().subscribe(
      data => {
        this.matchList = data;
        console.log('Match', data);
      },
      error => this.handleError(error)
    );
  }

  getTournaments(){
    return this.tournamentList;
  }

  getMatchs(){
    return this.matchList;
  }
  getSelectedTournament(){
    return this.selectedTournament;
  }

  getTeamsOfTournaments(){
    this.selectedTournamentTeams = this.selectedTournament.teams;
    return this.selectedTournamentTeams;
  }

  private handleError(error: any) {
    console.error(error);
  }


  submitted = false;
  onSubmit() {
    this.submitted = true;
    this.statsMatch2 = this.statsMatch1;
    this.adminService.addStatsMatch(this.selectedMatch,this.statsMatch1,this.statsMatch2);
    console.log('Accuracy '+this.statsMatch1.acurracy);
  }
}
