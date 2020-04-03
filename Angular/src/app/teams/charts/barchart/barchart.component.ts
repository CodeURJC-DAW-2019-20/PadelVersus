import {Component, Input, OnInit, ViewEncapsulation} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {Team} from "../../../Interfaces/team.model";
import {TeamService} from "../../team.service";

@Component({
  selector: 'app-barchart',
  templateUrl: './barchart.component.html',
  styleUrls: ['./barchart.component.css']
})
export class BarchartComponent implements OnInit {
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
          let avgStats = this.parseStats();

          this.data = {
            labels: ["Accuracy", "Eficciency", "Unforced errors"],
            datasets: [
              {
                data: avgStats,
                fill: false,
                backgroundColor: '#ffc107'

              }
            ]
          };

          this.options = {
            legend: {
              display:false
            }
          }
        }
      );

  }

  parseStats() {
    const avgStats: number[] = [];
    const totalGames = this.team.teamStatistics.totalGames;
    const avgAcc = this.team.teamStatistics.totalAcurracy / totalGames;
    const avgEff = this.team.teamStatistics.totalEffectiveness / totalGames;
    const avgForced = this.team.teamStatistics.totalUnforcedErrors / totalGames;

    avgStats.push(avgAcc);
    avgStats.push(avgEff);
    avgStats.push(avgForced);

    return avgStats;
  }
}
