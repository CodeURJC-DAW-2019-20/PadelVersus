import { Component, OnInit } from '@angular/core';

import{PlayerService} from "./player.service";
import {Player} from "../Interfaces/player.model";
import{ActivatedRoute} from "@angular/router";
import {isElementScrolledOutsideView} from "@angular/cdk/overlay/position/scroll-clip";


@Component({
  selector: 'app-player',
  templateUrl: './player.component.html',
  styleUrls: ['./player.component.css']
})
export class PlayerComponent implements OnInit {

  private player:Player;
  private id : number;

  constructor(private activatedRoute:ActivatedRoute, private playerService:PlayerService) {
    this.id = activatedRoute.snapshot.params['id'];
  }



  ngOnInit(): void {
    this.playerService.getPlayer(this.id).subscribe(
      data => {
        this.player = data;
        console.log('Player info: ', data);
      },
      error => this.handleError(error)
    );

  }

  getPlayer(){
    return this.player;
  }

  private handleError(error: any) {
    console.error(error);
  }



}
