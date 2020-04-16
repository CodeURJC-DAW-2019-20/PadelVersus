import {Component, OnInit} from '@angular/core';

import {Match} from '../Interfaces/match.model';
import {MatchesService} from '../matches/matches.service';
import {NavigationEnd, Router} from "@angular/router";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  private nextMatches: Match[] = [];
  private lastMatches: Match[] = [];

  private slides: any [] = [];
  private twitter: any;
  constructor(private matchesService: MatchesService, private router: Router) {
    this.initTwitterWidget();
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
  initTwitterWidget() {
    this.twitter = this.router.events.subscribe(val => {
      if (val instanceof NavigationEnd) {
        (<any>window).twttr = (function (d, s, id) {
          let js: any, fjs = d.getElementsByTagName(s)[0],
            t = (<any>window).twttr || {};
          if (d.getElementById(id)) return t;
          js = d.createElement(s);
          js.id = id;
          js.src = "https://platform.twitter.com/widgets.js";
          fjs.parentNode.insertBefore(js, fjs);

          t._e = [];
          t.ready = function (f: any) {
            t._e.push(f);
          };

          return t;
        }(document, "script", "twitter-wjs"));

        if ((<any>window).twttr.ready())
          (<any>window).twttr.widgets.load();

      }
    });
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
