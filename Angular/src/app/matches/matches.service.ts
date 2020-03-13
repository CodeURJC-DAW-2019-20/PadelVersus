import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

import {Match} from '../Interfaces/match.model';

import {catchError, map} from 'rxjs/operators';
import {throwError} from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class MatchesService {

  private matchesUrl: string;
  private datesUrl: string;

  constructor(private http: HttpClient) {
    this.matchesUrl = 'https://localhost:8443/api/matches/';
    this.datesUrl = 'https://localhost:8443/api/dates';
  }

  getNextMatches() {
    return this.http.get<Match[]>(this.matchesUrl + '?played=false').pipe(
      map(response => response),
      catchError(err => this.handleError(err))
    );
  }

  getLastMatches() {
    return this.http.get<Match[]>(this.matchesUrl + '?played=true').pipe(
      map(response => response),
      catchError(err => this.handleError(err))
    );
  }

  getDates() {
    return this.http.get<string[]>(this.datesUrl).pipe(
      map(response => response),
      catchError(err => this.handleError(err))
    );
  }

  getMatchesByDate(date: string) {
    return this.http.get<Match[]>(this.matchesUrl + '?date=' + date).pipe(
      map(response => response),
      catchError(err => this.handleError(err))
    );
  }

  private handleError(error: any) {
    console.error(error);
    return throwError('Server error (' + error.status + '): ' + error);
  }

}
