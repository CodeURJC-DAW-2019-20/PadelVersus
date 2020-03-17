import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { map } from 'rxjs/operators';
import {User} from "./Interfaces/user.model";
import {Observable} from "rxjs";

@Injectable()
export class AuthenticationService {
  isLogged = false;
  isAdmin = false;
  user: User;
  auth: string;

  constructor(private http: HttpClient) {
    let user = JSON.parse(localStorage.getItem('currentUser'));
    if (user) {
      this.setCurrentUser(user);
    }
  }

  login(user: string, pass: string) {
    console.log(user);
    console.log(pass);
    let auth = window.btoa(user + ':' + pass);
    const headers = new HttpHeaders({
      Authorization: 'Basic ' + auth,
      'X-Requested-With': 'XMLHttpRequest',
    });
    console.log(headers);
    return this.http.get<User>('/api/logIn', { headers }).pipe(map(user => {
      console.log(user);
      if (user) {
        this.setCurrentUser(user);
        user.authdata = auth;
        localStorage.setItem('currentUser', JSON.stringify(user));
      }
      return user;
    }));
  }

  logOut() {
    return this.http.get('/api/logOut').pipe(map(response => {
      this.removeCurrentUser();
      return response;
    }));
  }

  saveUser(user: User): Observable<User> {
    const formData = new FormData();
    formData.append('name', user.name);
    formData.append('authdata', user.authdata);
    return this.http.post<User>('https://localhost:8443/api/user/', formData);
  }

  private setCurrentUser(user: User) {
    this.isLogged = true;
    this.user = user;
    //this.isAdmin = this.user.roles.indexOf('ROLE_ADMIN') !== -1;
  }

  removeCurrentUser() {
    localStorage.removeItem('currentUser');
    this.isLogged = false;
    this.isAdmin = false;
  }
}
