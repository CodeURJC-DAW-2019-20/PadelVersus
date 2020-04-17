import {Component, OnInit, ViewChild} from '@angular/core';
import {MatchesService} from './matches.service';
import {Match} from '../Interfaces/match.model';
import {MatchesOnDate} from '../Interfaces/matchesOnDate.model';
import {NextMatchesDateComponent} from './next-matches-date/next-matches-date.component';

@Component({
  selector: 'app-matches',
  templateUrl: './matches.component.html',
  styleUrls: ['./matches.component.css']
})
export class MatchesComponent implements OnInit {
  @ViewChild(NextMatchesDateComponent)
  private nextMatchesDateComponent: NextMatchesDateComponent;

  private lastMatches: Match[];
  public matchesByDateGlobal: MatchesOnDate [] = [];

  constructor(private matchesService: MatchesService) {
  }

  ngOnInit(): void {
    this.matchesService.getLastMatches().subscribe(
      data => {
        this.lastMatches = data;
        console.log('Last Matches: ', data);
      },
      error => this.handleError(error)
    );
    this.matchesService.getDates().subscribe(
      data => {
        const matchesByDate: MatchesOnDate[] = [];
        for (const date of data) {
          this.matchesService.getMatchesByDate(date).subscribe(
            dataOnDate => {
              const obj: MatchesOnDate = {
                date,
                matches: dataOnDate
              };
              matchesByDate.push(obj);
              console.log('Matches not played on ' + date + ': ', dataOnDate);
              console.log(obj);
              if (data.indexOf(date) === (data.length - 1)) {
                this.matchesByDateGlobal = matchesByDate;
              }
            },
            error => this.handleError(error)
          );
        }
        console.log('Not played dates: ', data);
      },
      error => this.handleError(error)
    );
  }

  getlastMatches() {
    return this.lastMatches;
  }

  private handleError(error: any) {
    console.error(error);
  }

  public getMatchesByDate() {
    return this.matchesByDateGlobal;
  }

}
