import {Component, OnInit, ViewChild, ViewEncapsulation} from '@angular/core';

import {PlayerService} from './player.service';
import {Player} from '../Interfaces/player.model';
import {ActivatedRoute} from '@angular/router';
import {Tournament} from '../Interfaces/tournament.model';
import {Team} from '../Interfaces/team.model';

@Component({
  selector: 'app-player',
  templateUrl: './player.component.html',
  styleUrls: ['./player.component.css'],
  encapsulation: ViewEncapsulation.None
})



export class PlayerComponent implements OnInit {



  constructor(private activatedRoute: ActivatedRoute, private playerService: PlayerService) {
    this.id = activatedRoute.snapshot.params.id;

  }

  private player: Player;
  private id: number;
  private tournaments: Tournament[] = [];
  private teams: Team[] = [];




  ngOnInit(): void {
    this.playerService.getPlayer(this.id).subscribe(
      data => {
        this.player = data;
        console.log('Player info: ', data);
      },
      error => this.handleError(error)
    );
    this.playerService.getTournamentsByPlayer(this.id).subscribe(
      data => {
        this.tournaments = data;
        console.log('Tournaments info: ', data);
      },
      error => this.handleError(error)
    );
    this.playerService.getTeamsByPlayer(this.id).subscribe(
      data => {
        this.teams = data;
        console.log('Teams info: ', data);
      },
      error => this.handleError(error)
    );





  }


  getPlayer() {
    return this.player;
  }

  getTournamentsByPlayer() {
    return this.tournaments;
  }

  getTeamsByPlayer() {
    return this.teams;
  }

  getId() {
    return this.id;
  }

  private handleError(error: any) {
    console.error(error);
  }

  public showMailAndButton() {
    if ( localStorage.getItem('currentUser') === null) {
      return false;
    }
    let nameStored = localStorage.getItem('currentUser').split(',')[1].split(':')[1];
    nameStored = nameStored.substr(1, nameStored.length - 2);
    return  nameStored === this.player.user.name;
  }







}
