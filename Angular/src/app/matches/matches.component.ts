import {Component, OnInit} from '@angular/core';
import {MatchesService} from './matches.service';
import {Match} from '../Interfaces/match.model';

@Component({
  selector: 'app-matches',
  templateUrl: './matches.component.html',
  styleUrls: ['./matches.component.css']
})
export class MatchesComponent implements OnInit {
  private lastMatches: Match[];

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
  }

  getlastMatches() {
    return this.lastMatches;
  }


  private handleError(error: any) {
    console.error(error);
  }

}
