import { Component, OnInit } from '@angular/core';

import {Router} from "@angular/router";
import {AuthService} from "../auth.service";
import {User} from "../Interfaces/user.model";
@Component({
  selector: 'app-log-in',
  templateUrl: './logIn.component.html',
  styleUrls: ['./logIn.component.css']
})
export class LogInComponent implements OnInit {

  name: string;
  password: string;
  user: User;
  constructor(private auth: AuthService,private router: Router) { }

  ngOnInit() {
  }

  loginUser () {
    console.log(this.name.toString());
    console.log(this.password.toString());
    this.auth.getUser(this.name).subscribe(
      data => {
        this.auth.loginUser(data).subscribe(
          res => {
            //localStorage.setItem('token', res.token);
            this.router.navigate(['/home']);
            console.log('USER LOGGED:', res);
          },
          error => this.handleError(error)
        )
        /*this.user = data;
        console.log('UserPatata', this.getUser());*/
      },
      error => this.handleError(error)
    );
   /* console.log('User to login user:'+this.getUser());
    this.auth.loginUser(this.user).subscribe(
        res => {
          //localStorage.setItem('token', res.token);
          this.router.navigate(['/home']);
          console.log('USER LOGGED:', res);
        },
        error => this.handleError(error)
      )*/
  }
  getUser(){
    return this.user;
  }
  private handleError(error: any) {
    console.error(error);
  }

}
