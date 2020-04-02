import {Component, OnInit, ViewChild} from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styles: [`
    .navbar-nav {
      width: 100%;
      display: flex;
      flex-wrap: nowrap;
      justify-content: space-between;
    }

    .navbar-nav > li {
      flex-grow: 1;
      text-align: center;
    }
    .item{
      font-family:Montserrat, sans-serif;
      font-size: 14px;
      line-height: normal;
      color: white !important;
      text-transform: uppercase;
    }
    .item:hover{
      color: rgb(255, 160, 0) !important;
      border-bottom: 2px solid rgb(255, 160, 0);
    }
  `
  ]
})
export class HeaderComponent implements OnInit {

  constructor() {
  }

  ngOnInit(): void {

  }

  private handleError(error: any) {
    console.error(error);
  }

}
