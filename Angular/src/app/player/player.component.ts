import { Component, OnInit } from '@angular/core';

import{PlayerService} from "./player.service";
import {Player} from "../Interfaces/player.model";
import{ActivatedRoute} from "@angular/router";

import {isElementScrolledOutsideView} from "@angular/cdk/overlay/position/scroll-clip";
import {Tournament} from "../Interfaces/tournament.model";
import {Team} from "../Interfaces/team.model";


@Component({
  selector: 'app-player',
  templateUrl: './player.component.html',
  styleUrls: ['./player.component.css']
})
export class PlayerComponent implements OnInit {

  private player:Player;
  private id : number;
  private chartType: string;
  private chartDatasets: any;
  private tournaments:Tournament[] = [];
  private teams:Team[] = [];


  private chartLabels: string[];





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

  // events
  public chartClicked(e:any):void {
    console.log(e);
  }

  public chartHovered(e:any):void {
    console.log(e);
  }

  getPlayer(){
    return this.player;
  }

  getTournamentsByPlayer(){
    return this.tournaments;
  }

  getTeamsByPlayer(){
    return this.teams;
  }

  getChartType(){
    return this.chartType = 'radar';
  }

  getChartDataSets(){

    return this.chartDatasets = [{data: [this.player.height,this.player.weight,this.player.endurance,this.player.speed,this.player.accuaracy,this.player.aceleration,this.player.strength,this.player.pace],label: 'Player con id '+this.player.id} ];

  }

  getChartLabels(){
    return this.chartLabels=
      ['Height', 'Weight', 'Endurance', 'Speed', 'Accuaracy', 'Aceleration', 'Strenght','Pace'];
  }





  private handleError(error: any) {
    console.error(error);
  }



}
