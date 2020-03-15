import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-signUp',
  templateUrl: './signUp.component.html',
  styleUrls: ['./signUp.component.css']
})

export class SignUpComponent implements OnInit {

  Roles: any = ['Admin', 'Author', 'Reader'];
  selected: boolean;
  constructor() { }

  ngOnInit() {
  }

}
