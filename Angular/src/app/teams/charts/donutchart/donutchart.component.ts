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
            labels: ['Wins','Loses'],
            datasets: [
              {
                data: wl,
                backgroundColor: [
                  "#ffc107",
                  "#FFCE56"
                ],
              }]
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
