import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

import {catchError, map} from 'rxjs/operators';
import {Observable, throwError} from 'rxjs';

import {Tournament} from "../Interfaces/tournament.model";
import {Match} from "../Interfaces/match.model";
import {MatchStatistics} from "../Interfaces/matchStatistics.model";
var headers_object = new HttpHeaders();
headers_object.append('Content-Type', 'application/json');
headers_object.append("Authorization", "Basic " + btoa("admin:adminpass"));

const httpOptions = {
  headers: headers_object
};
@Injectable({
  providedIn: 'root'
})
export class AdminService {

  private adminUrl : string;
  private statMatch: MatchStatistics[];
  constructor(private http: HttpClient) {
    this.adminUrl = 'https://localhost:8443/api/tournaments/'
    this.statMatch[0] = null;
    this.statMatch[1] = null;
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

  /** POST: add a new stats match to the database */
  addStatsMatch (match: Match,statsMatch: MatchStatistics,statsMatch1: MatchStatistics): Observable<Match> {
    this.statMatch[0] = (statsMatch);
    this.statMatch[1] = (statsMatch1);
    console.log('ID: '+match.id)
    return this.http.post<Match>("https://localhost:8443/api/match/"+match.id, this.statMatch, httpOptions)
      .pipe(
        catchError(err=> this.handleError(err))
      );

  }


}
