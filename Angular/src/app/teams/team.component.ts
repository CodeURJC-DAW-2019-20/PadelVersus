import {Component, OnInit, ViewChild, ViewEncapsulation} from '@angular/core';

import {Team} from '../Interfaces/team.model';
import {TeamService} from "../teams/team.service";
import {ActivatedRoute} from "@angular/router";
import {Match} from "../Interfaces/match.model";
import {MatchesService} from "../matches/matches.service";
import {TeamStatistics} from "../Interfaces/teamStatistics.model";

import {
  ChartComponent,
  ApexAxisChartSeries,
  ApexChart,
  ApexXAxis,
  ApexDataLabels,
  ApexTitleSubtitle,
  ApexStroke,
  ApexGrid,
  ApexFill,
  ApexMarkers,
  ApexYAxis,
  ApexTooltip

} from "ng-apexcharts";
import {Game} from "../Interfaces/game.model";

export interface ChartOptions {
  series: ApexAxisChartSeries;
  chart: ApexChart;
  xaxis: ApexXAxis;
  dataLabels: ApexDataLabels;
  grid: ApexGrid;
  fill: ApexFill;
  markers: ApexMarkers;
  yaxis: ApexYAxis;
  stroke: ApexStroke;
  title: ApexTitleSubtitle;
  toolbar: ApexTooltip;
}

@Component({
  selector: 'app-teams',
  templateUrl: './team.component.html',
  styleUrls: ['./team.component.css'],
  encapsulation: ViewEncapsulation.None
})


export class TeamComponent implements OnInit {

  private id: number;
  private team: Team;
  private lastMatches: Match[];

  @ViewChild('chart') chartGPM: ChartComponent;
  public chartGPMOptions: Partial<ChartOptions>;

  constructor(private activatedRoute: ActivatedRoute,
              private teamService: TeamService,
              private matchesService: MatchesService) {
    this.id = activatedRoute.snapshot.params.id;
  }

  ngOnInit(): void {
    this.teamService.getTeam(this.id).subscribe(
      data => {
        this.team = data;
        this.setChartGPMOptions();
        console.log('Team: ', data);
      },
      error => this.handleError(error)
    );

    this.matchesService.getLastMatchesByTeam(this.id).subscribe(
      data => {
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

  getLastMatches(){
    return this.lastMatches
  }

  parseGames(){
    let gamesParsed: number[] = [];
    let games: Game[] = this.team.teamStatistics.gamesPerMatch;
    for (let i in games){
      gamesParsed.push(games[i].games);
    }
    console.log('Games: ',gamesParsed)
    return gamesParsed;
  }

  setChartGPMOptions(): void {
    let games = this.parseGames();
    this.chartGPMOptions = {
      series: [
        {
          name: "Games",
          data: games
        }
      ],
      chart: {
        height: 350,
        type: "line"
      },
      stroke: {
        width: 7,
        curve: "smooth"
      },
      title: {
        text: "GAMES PER MATCH",
        align: "center",
        style: {
          fontSize: "18px",
          color: "#141414"
        }
      },
      fill: {
        type: "gradient",
        gradient: {
          shade: "dark",
          gradientToColors: ["#FDD835"],
          shadeIntensity: 1,
          type: "horizontal",
          opacityFrom: 1,
          opacityTo: 1,
          stops: [0, 100, 100, 100]
        }
      },
      markers: {
        size: 4,
        colors: ["#FFA41B"],
        strokeColors: "#fff",
        strokeWidth: 2,
        hover: {
          size: 7
        }
      },
      yaxis: {
        min: 0,
        max: 20,
        title: {
          text: "Games"
        }
      },
      xaxis: {
        title: {
          text: "Match"
        }
      },
    };
  }
}
