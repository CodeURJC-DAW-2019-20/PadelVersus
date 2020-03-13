import {Component, OnInit} from '@angular/core';
import {MatchesService} from './matches.service';
import {Match} from '../Interfaces/match.model';
import {MatchesOnDate} from '../Interfaces/matchesOnDate.model';

@Component({
  selector: 'app-matches',
  templateUrl: './matches.component.html',
  styleUrls: ['./matches.component.css']
})
export class MatchesComponent implements OnInit {
  private lastMatches: Match[];
  private notPlayedDates: string[] = [];
  private matchesByDate: any[] = [];

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
        for (const date of data) {
          this.matchesService.getMatchesByDate(date).subscribe(
            dataOnDate => {
              const obj: MatchesOnDate = {
                date,
                matches: dataOnDate
              };
              this.matchesByDate.push(obj);
              console.log('Matches not played on ' + date + ': ', dataOnDate);
              console.log(obj);
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

  private getMatchesByDate() {
    return this.matchesByDate;
  }
}
