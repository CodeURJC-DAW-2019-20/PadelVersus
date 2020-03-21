import {Component, OnInit, ViewChild, ViewEncapsulation} from '@angular/core';

import {Team} from '../Interfaces/team.model';
import {TeamService} from "../teams/team.service";
import {ActivatedRoute} from "@angular/router";
import {Match} from "../Interfaces/match.model";
import {MatchesService} from "../matches/matches.service";

import {
  ChartComponent,
  ApexAxisChartSeries,
  ApexNonAxisChartSeries,
  ApexChart,
  ApexXAxis,
  ApexDataLabels,
  ApexTitleSubtitle,
  ApexStroke,
  ApexGrid,
  ApexFill,
  ApexMarkers,
  ApexYAxis,
  ApexPlotOptions,
  ApexResponsive,
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
  plotOptions: ApexPlotOptions;
  responsive: ApexResponsive[];
  labels: any;
  colors: string[];
  seriesWL: ApexNonAxisChartSeries;
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

  @ViewChild('chart1') chartGPM: ChartComponent;
  public chartGPMOptions: Partial<ChartOptions>;

  @ViewChild('chart2') chartAVG: ChartComponent;
  public chartAVGOptions: Partial<ChartOptions>;

  @ViewChild('chart3') chartWL: ChartComponent;
  public chartWLOptions: Partial<ChartOptions>;

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
        this.setChartAVGOptions();
        this.setChartWLOptions();
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

  parseStats(){
    let avgStats : number[] = [];
    let totalGames = this.team.teamStatistics.totalGames;
    let avgAcc = this.team.teamStatistics.totalAcurracy/ totalGames;
    let avgEff = this.team.teamStatistics.totalEffectiveness/ totalGames;
    let avgForced = this.team.teamStatistics.totalUnforcedErrors/ totalGames;

    avgStats.push(avgAcc);
    avgStats.push(avgEff);
    avgStats.push(avgForced);

    return avgStats;
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
        curve: "smooth",
        colors: ["#ffa000"]
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

  setChartAVGOptions(): void{

    let avgStats = this.parseStats();

    this.chartAVGOptions = {
      series: [
        {
          name: "%",
          data: avgStats
        }
      ],

      colors: [
        "#ffa000",
        "#ffa000",
        "#ffa000",
      ],

      chart: {
        type: "bar",
        height: 350
      },

      plotOptions: {
        bar: {
          horizontal: true,
        }

      },
      dataLabels: {
        enabled: false
      },

      xaxis: {
        min: 0,
        max: 100,
        categories: [
          "Accuracy",
          "Effectiveness",
          "Unforced errors",
        ]
      },

      title: {
        text: "AVERAGE STATISTICS",
        align: "center",
        style: {
          fontSize: "18px",
          color: "#141414"
        }
      }
    };
  }


  parseWL(){
    let parsed: number[] = []
    parsed.push(this.team.teamStatistics.totalWins);
    parsed.push(this.team.teamStatistics.totalDefeats);
    return parsed;
  }

  setChartWLOptions(): void{
    let parsedWL = this.parseWL();
    this.chartWLOptions = {
      seriesWL: parsedWL,
      chart: {
        type: "donut",
        height: 600,
      },

      colors: [
        "#ffa000",
        "#e61c2d"
      ],

      title: {
        text: "W/L %",
        align: "center",
        style: {
          fontSize: "18px",
          color: "#141414"
        }
      },

      labels: ["Wins", "Loses"],

      responsive: [
        {
          breakpoint: 480,
          options: {
            chart: {
              width: 50
            },
            legend: {
              position: "bottom"
            }
          }
        }
      ],

    };
  }


}
