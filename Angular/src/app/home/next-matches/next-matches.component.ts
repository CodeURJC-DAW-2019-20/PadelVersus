import {Component, Input, OnInit} from '@angular/core';
import {Match} from '../../Interfaces/match.model';

@Component({
  selector: 'app-next-matches',
  templateUrl: './next-matches.component.html',
  styleUrls: ['./next-matches.component.css']
})
export class NextMatchesComponent implements OnInit {

  @Input()
  private nextMatches: Match[] = [];

  constructor() {
  }

  ngOnInit(): void {
  }

  getNextMatches() {
    return this.nextMatches;
  }

}
