import {Component, Input, OnInit} from '@angular/core';
import {MatchesOnDate} from '../../Interfaces/matchesOnDate.model';

@Component({
  selector: 'app-next-matches-date',
  templateUrl: './next-matches-date.component.html',
  styleUrls: ['./next-matches-date.component.css']
})
export class NextMatchesDateComponent implements OnInit {

  @Input()
  private matchesByDate: MatchesOnDate [] = [];

  constructor() {
  }

  ngOnInit(): void {
  }

}
