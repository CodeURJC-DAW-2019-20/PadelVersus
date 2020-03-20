import {Component, OnInit, ViewChild} from '@angular/core';

import {Team} from '../Interfaces/team.model';
import {TeamService} from "../teams/team.service";
import {ActivatedRoute} from "@angular/router";
import {Match} from "../Interfaces/match.model";
import {MatchService} from "../match/match.service";

@Component({
  selector: 'app-teams',
  templateUrl: './team.component.html',
  styleUrls: ['./team.component.css'],
})
export class TeamComponent implements OnInit {

  private id: number;
  private team: Team;
  private lastMatches: Match[];

  constructor(private activatedRoute: ActivatedRoute,
              private teamService: TeamService,
              private matchService: MatchService) {
    this.id = activatedRoute.snapshot.params.id;
  }

  ngOnInit(): void {
    this.teamService.getTeam(this.id).subscribe(
      data => {
        this.team = data;
        console.log('Team: ', data);
      },
      error => this.handleError(error)
    );

    this.matchService.getLastMatchesByTeam(this.id).subscribe(
      data =>{
        this.lastMatches = data
        console.log('Last matches of team: ', data)
      }
    )
  }

  private handleError(error: any) {
    console.error(error);
  }

  getTeam(){
    return this.team
  }

}
