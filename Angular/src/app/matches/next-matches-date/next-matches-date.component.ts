import {Component} from '@angular/core';
import {MatchesOnDate} from '../../Interfaces/matchesOnDate.model';

@Component({
  selector: 'app-next-matches-date',
  templateUrl: './next-matches-date.component.html',
  styleUrls: ['./next-matches-date.component.css']
})
export class NextMatchesDateComponent {

  public matchesByDate: MatchesOnDate [] = [];
  private show = false;

  private dates: string[] = [];
  private dateShowing: number;


  constructor() {
    this.dateShowing = 0;
  }

  NextDate() {
    this.dateShowing++;
    if (this.dateShowing > (this.dates.length - 1)) {
      this.dateShowing -= this.dates.length;
    }
    console.log('dateShowing: ' + this.dateShowing);
  }

  PrevDate() {
    this.dateShowing--;
    if (this.dateShowing < 0) {
      this.dateShowing += this.dates.length;
    }
    console.log('dateShowing: ' + this.dateShowing);
  }


  getDate() {
    console.log('Date showing:' + this.dateShowing);
    return this.dates[this.dateShowing];
  }


  toggleShow() {
    this.show = !this.show;
    if (this.show) {
      this.updateDates();
    }
  }

  private updateDates() {
    this.dates = [];
    for (const obj of this.matchesByDate) {
      this.dates.push(obj.date);
    }
  }
}
