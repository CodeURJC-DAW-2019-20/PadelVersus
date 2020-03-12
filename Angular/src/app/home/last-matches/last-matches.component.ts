import {Component, Input, OnInit} from '@angular/core';
import {Match} from '../../Interfaces/match.model';

@Component({
  selector: 'app-last-matches',
  templateUrl: './last-matches.component.html',
  styleUrls: ['./last-matches.component.css']
})
export class LastMatchesComponent implements OnInit {

  @Input()
  private lastMatches: Match[] = [];

  constructor() {
  }

  ngOnInit(): void {
  }

  getlastMatches() {
    return this.lastMatches;
  }

}
