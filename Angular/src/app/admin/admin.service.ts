import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

import {catchError, map} from 'rxjs/operators';
import {throwError} from 'rxjs';

import {Tournament} from "../Interfaces/tournament.model";
import {MatchAdmin} from "../Interfaces/matchAdmin.model";
import {Match} from "../Interfaces/match.model";

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  private adminUrl : string;

  constructor(private http: HttpClient) {
    this.adminUrl = 'https://localhost:8443/api/tournaments/'
  }

  getTournaments() {
    return this.http.get<Tournament[]>(this.adminUrl).pipe(
      map(response => response),
      catchError(err => this.handleError(err))
    );
  }

  getMatchAdmin(){
    return this.http.get<Match[]>("https://localhost:8443/api/matches/?played=false").pipe(
      map(response => response),
      catchError(err => this.handleError(err))
    );
  }
  private handleError(error: any) {
    console.error(error);
    return throwError('Server error (' + error.status + '): ' + error);
  }

}
