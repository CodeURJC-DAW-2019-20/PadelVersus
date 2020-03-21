import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {catchError, map} from 'rxjs/operators';
import {User} from "./Interfaces/user.model";
import {Observable, throwError} from "rxjs";
import {Player} from "./Interfaces/player.model";

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

  login(user: string, pass: string){
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
    console.log('userSave:'+user.name);
    console.log('userSave:'+user.passwordHash);
    console.log('userSave:'+user.mail);

    const body = JSON.stringify(user);
    console.log(body);
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
    });

    return this.http.post<User>('/api/user', body, {headers}).pipe(
      map(response => response)
      //catchError(err => this.handleError(err))
    );
  }
  savePlayer(player: Player): Observable<Player> {
    console.log('player:'+player.aceleration);
    console.log('userID:'+player.idUser);

    const body = JSON.stringify(player);
    console.log(body);
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
    });

    return this.http.post<Player>('/api/player', body, {headers}).pipe(
      map(response => response)
      //catchError(err => this.handleError(err))
    );
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
  private handleError(error: any) {
    console.error(error);
    return throwError('Server error (' + error.status + '): ' + error);
  }
}
