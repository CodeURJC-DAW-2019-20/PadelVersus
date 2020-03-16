import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http'
import { Router } from '@angular/router'
import {Tournament} from "./Interfaces/tournament.model";
import {catchError, map} from "rxjs/operators";
import {User} from "./Interfaces/user.model";
import {throwError} from "rxjs";

var headers_object = new HttpHeaders();
headers_object.append('Content-Type', 'application/json;charset=utf-8');

const httpOptions = {
  headers: headers_object
};
@Injectable()
export class AuthService {

  private registerUrl = "https://localhost:8443/api/user";
  private loginUrl = "https://localhost:8443/api/logIn";

  constructor(private http: HttpClient,
              private _router: Router) { }

  registerUser(user) {
    return this.http.post(this.registerUrl, user)
  }

  getUser(name: string){
    return this.http.get<User>(this.registerUrl+"/"+name).pipe(
      map(response => response),
      catchError(err => this.handleError(err))
    );
  }

  loginUser(user) {
     return this.http.post<User>(this.loginUrl,user,httpOptions).pipe(
      map(response => response),
      catchError(err => this.handleError(err))
    );
  }

  logoutUser() {
    localStorage.removeItem('token');
    this._router.navigate(['/home']);
  }

  getToken() {
    return localStorage.getItem('token');
  }

  loggedIn() {
    return !!localStorage.getItem('token');
  }

  private handleError(error: any) {
    console.error(error);
    return throwError('Server error (' + error.status + '): ' + error);
  }
}
