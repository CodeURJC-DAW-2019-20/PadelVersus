import {Component, OnInit} from '@angular/core';
import {NavigationEnd, Router} from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'Angular';
  public headerFooter: boolean;

  constructor(private router: Router) {
  }

  ngOnInit() {
    this.router.events
      .subscribe((event) => {
        if (event instanceof NavigationEnd) {
          const noFooteerRoutes = [
            '/login',
            '/signup',
            '/signupplayer',
            '/logout',
            '/404',
            '/403'
          ];
          this.headerFooter = noFooteerRoutes.indexOf(event.url) === -1;
          console.error(event.url);
        }
      });
  }
}
