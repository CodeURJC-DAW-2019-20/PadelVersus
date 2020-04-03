import {Component, Input, OnInit, ViewEncapsulation} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {Team} from "../../../Interfaces/team.model";
import {TeamService} from "../../team.service";
import {Game} from "../../../Interfaces/game.model";

@Component({
  selector: 'app-linechart',
  templateUrl: './linechart.component.html',
  styleUrls: ['./linechart.component.css']
})
export class LinechartComponent implements OnInit {
  data: any;
  options: any;
  @Input() private idTeam: number;
  private team: Team;

  constructor(private activatedRoute: ActivatedRoute,private teamService:TeamService) {
    this.idTeam = activatedRoute.snapshot.params.id;
  }


  ngOnInit(): void {
    this.teamService.getTeam(this.idTeam)
      .subscribe(data => {
          this.team = data;

          let games = this.parseGames();
          let yaxis :  string[] = []
          for (const i in games) {
            yaxis.push("Game " + String(Number(i)+1))
          }

          console.log("yaxis:", yaxis);

          this.data = {
            labels: yaxis,
            datasets: [
              {
                label:'Games won',
                data: games,
                fill: false,
                borderColor: '#ffc107'

              }
            ]

          };
          this.options ={
            legend: {
              display:false
            },

            scales: {
              yAxes: [{
                ticks: {
                  stepSize: 2,
                  beginAtZero: true
                }
              }]
            }
          };
        }
      );

  }

  parseGames() {
    const gamesParsed: number[] = [];
    const games: Game[] = this.team.teamStatistics.gamesPerMatch;
    for (const i in games) {
      gamesParsed.push(games[i].games);
    }
    console.log('Games: ', gamesParsed);
    return gamesParsed;
  }
}
