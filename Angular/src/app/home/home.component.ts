import {Component, OnInit} from '@angular/core';

import {Match} from '../Interfaces/match.model';
import {MatchesService} from '../matches/matches.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  private nextMatches: Match[] = [];
  private lastMatches: Match[] = [];

  private slides: any [] = [];

  constructor(private matchesService: MatchesService) {
  }

  ngOnInit(): void {
    this.matchesService.getNextMatches().subscribe(
      data => {
        this.nextMatches = data;
        console.log('Next Matches: ', data);
      },
      error => this.handleError(error)
    );
    this.matchesService.getLastMatches().subscribe(
      data => {
        this.lastMatches = data;
        console.log('Last Matches: ', data);
      },
      error => this.handleError(error)
    );
  }


  getSlides() {
    this.slides = [];
    for (const match of this.nextMatches) {
      this.slides.push({
        text: match.teams[0].name + ' vs ' + match.teams[1].name,
        date: match.date
      });
    }
    return this.slides;
  }

  getNextMatches() {
    return this.nextMatches;
  }

  getlastMatches() {
    return this.lastMatches;
  }


  private handleError(error: any) {
    console.error(error);
  }
}
