import { Component, OnInit } from '@angular/core';

import {Router} from "@angular/router";
import {AuthService} from "../auth.service";
@Component({
  selector: 'app-log-in',
  templateUrl: './logIn.component.html',
  styleUrls: ['./logIn.component.css']
})
export class LogInComponent implements OnInit {

  loginUserData = {};

  constructor(private _auth: AuthService,
              private _router: Router) { }

  ngOnInit() {
  }

  loginUser () {
    this._auth.loginUser(this.loginUserData)
      .subscribe(
        res => {
          localStorage.setItem('token', res.token);
          this._router.navigate(['/home'])
        },
        err => console.log(err)
      )
  }

}
