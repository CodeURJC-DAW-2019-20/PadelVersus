import {Component, OnInit, ViewChild} from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html'
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
