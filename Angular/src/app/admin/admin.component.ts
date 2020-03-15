import {Component, OnInit} from '@angular/core';

import {Tournament} from '../Interfaces/tournament.model'
import {AdminService} from "./admin.service";
import {Team} from '../Interfaces/team.model';
import {Match} from "../Interfaces/match.model";
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


  constructor(private  adminService: AdminService) {
  }

  ngOnInit(): void {
    this.adminService.getTournaments().subscribe(
      data => {
        this.tournamentList = data;
        console.log('Tournaments', data);
      },
      error => this.handleError(error)
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

}
