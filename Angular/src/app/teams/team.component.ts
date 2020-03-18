import {Component, OnInit, ViewChild} from '@angular/core';

import {Team} from '../Interfaces/team.model';
import {TeamPlayer} from "../Interfaces/teamplayer.model";
import {TeamService} from "../teams/team.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-teams',
  templateUrl: './team.component.html',
  styleUrls: ['./team.component.css'],
})
export class TeamComponent implements OnInit {

  private team: Team;
  private id: number;
  private players: TeamPlayer[];
  constructor(private activatedRoute: ActivatedRoute, private teamService: TeamService) {
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
  }

  private handleError(error: any) {
    console.error(error);
  }

  getTeam(){
    return this.team
  }

}
