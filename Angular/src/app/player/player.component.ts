import {Component, OnInit, ViewChild} from '@angular/core';

import {PlayerService} from './player.service';
import {Player} from '../Interfaces/player.model';
import {ActivatedRoute} from '@angular/router';
import {Tournament} from '../Interfaces/tournament.model';
import {Team} from '../Interfaces/team.model';
import {ApexAxisChartSeries, ApexChart, ApexTitleSubtitle, ApexXAxis, ChartComponent} from 'ng-apexcharts';


export interface ChartOptions {
  series: ApexAxisChartSeries;
  chart: ApexChart;
  title: ApexTitleSubtitle;
  xaxis: ApexXAxis;
}

@Component({
  selector: 'app-player',
  templateUrl: './player.component.html',
  styleUrls: ['./player.component.css']
})
export class PlayerComponent implements OnInit {

  private player: Player;
  private id: number;
  private tournaments: Tournament[] = [];
  private teams: Team[] = [];
  private image:any;

  @ViewChild('chart') chart: ChartComponent;
  public chartOptions: Partial<ChartOptions>;

  constructor(private activatedRoute: ActivatedRoute, private playerService: PlayerService) {
    this.id = activatedRoute.snapshot.params.id;
  }


  ngOnInit(): void {
    this.playerService.getPlayer(this.id).subscribe(
      data => {
        this.player = data;
        console.log('Player info: ', data);
        this.setChartOptions();
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
    this.playerService.getImageByPlayer(this.id)
      .subscribe(data => {
          this.createImageFromBlob(data);
        }, error => {
          console.log(error);
        }
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

  getImageByPlayer(){
    return this.image;
  }

  setChartOptions(): void {
    this.chartOptions = {
      series: [
        {
          name: 'Series 1',
          data: [this.player.height * 10, this.player.endurance * 10, this.player.weight, this.player.speed * 10,
            this.player.accuaracy * 10, this.player.aceleration * 10, this.player.strength * 10, this.player.pace * 10]
        }
      ],
      chart: {
        height: 600,
        type: 'radar'
      },
      title: {
        text: 'Basic Radar Chart'
      },
      xaxis: {
        categories: ['Height', 'Endurance', 'Weight', 'Speed', 'Accuaracy', 'Aceleration', 'Strenght', 'Pace']
      }
    };
  }


  private handleError(error: any) {
    console.error(error);
  }

  createImageFromBlob(image: Blob) {
    let reader = new FileReader();
    reader.addEventListener("load", () => {
      this.image = reader.result;
    }, false);

    if (image) {
      reader.readAsDataURL(image);
    }
  }


}
