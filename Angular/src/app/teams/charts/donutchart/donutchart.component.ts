import {Component, Input, OnInit, ViewEncapsulation} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {Team} from "../../../Interfaces/team.model";
import {TeamService} from "../../team.service";

@Component({
  selector: 'app-donutchart',
  templateUrl: './donutchart.component.html',
  styleUrls: ['./donutchart.component.css']
})
export class DonutchartComponent implements OnInit {
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

          let wl = this.parseWL();

          this.data = {
            datasets: [
              {
                label:'Games won',
                data: [1],
                fill: false,
                borderColor: '#ffc107'

              }
            ]

          };
          this.options ={
            legend: {
              display:false
            }
          };
        }
      );

  }

  parseWL() {
    const parsed: number[] = [];
    parsed.push(this.team.teamStatistics.totalWins);
    parsed.push(this.team.teamStatistics.totalDefeats);
    return parsed;
  }
}
