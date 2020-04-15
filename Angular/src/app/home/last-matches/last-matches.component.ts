import {Component, Input, OnInit} from '@angular/core';
import {Match} from '../../Interfaces/match.model';
import {Router} from '@angular/router';

@Component({
  selector: 'app-last-matches',
  templateUrl: './last-matches.component.html',
  styleUrls: ['./last-matches.component.css']
})
export class LastMatchesComponent implements OnInit {

  @Input()
  private lastMatches: Match[] = [];

  constructor(private router: Router) {
  }

  ngOnInit(): void {
  }

  getlastMatches() {
    return this.lastMatches.reverse();
  }

  goToMatch(id: number) {
    this.router.navigate(['/match/' + id]);
  }
}
