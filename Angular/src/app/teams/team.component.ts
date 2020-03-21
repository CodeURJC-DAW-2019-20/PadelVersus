import {Component, OnInit, ViewChild} from '@angular/core';

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
})


export class TeamComponent implements OnInit {

  private id: number;
  private team: Team;
  private lastMatches: Match[];
  private teamStatistics: TeamStatistics;

  @ViewChild('chart') chart: ChartComponent;
  public chartOptions: Partial<ChartOptions>;

  constructor(private activatedRoute: ActivatedRoute,
              private teamService: TeamService,
              private matchesService: MatchesService) {
    this.id = activatedRoute.snapshot.params.id;
  }

  ngOnInit(): void {
    this.teamService.getTeam(this.id).subscribe(
      data => {
        this.team = data;
        this.setChartOptions();
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
    let games: number[] = []
  }
  setChartOptions(): void {
    this.chartOptions = {
      series: [
        {
          name: "Likes",
          data: [this.team.teamStatistics.totalAcurracy, this.team.teamStatistics.totalDefeats, this.team.teamStatistics.totalGames]
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
      xaxis: {
        type: "datetime",
        categories: [
          "1/11/2000",
          "2/11/2000",
          "3/11/2000",
          "4/11/2000",
          "5/11/2000",
          "6/11/2000",
          "7/11/2000",
          "8/11/2000"
        ]
      },
      title: {
        text: "Games per match",
        align: "center",
        style: {
          fontSize: "16px",
          color: "#666"
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
          text: "Engagement"
        }
      },
    };
  }
}
