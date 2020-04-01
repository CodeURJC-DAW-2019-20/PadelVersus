import {Component, Input, OnInit, ViewEncapsulation} from '@angular/core';
import {Match} from '../../Interfaces/match.model';

@Component({
  selector: 'app-carousel',
  templateUrl: './carousel.component.html',
  styleUrls: ['./carousel.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class CarouselComponent implements OnInit {

  @Input()
  private slides: any [] = [];

  @Input()
  private nextMatches: Match[] = [];

  constructor() {
  }

  ngOnInit(): void {
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

}
