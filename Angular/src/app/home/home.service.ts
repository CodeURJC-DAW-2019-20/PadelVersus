import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

import {Match} from '../Interfaces/match.model';

import {catchError, map} from 'rxjs/operators';
import {throwError} from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class HomeService {

  private matchesUrl: string;


  constructor(private http: HttpClient) {
    this.matchesUrl = 'https://localhost:8443/api/matches/';
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

  private handleError(error: any) {
    console.error(error);
    return throwError('Server error (' + error.status + '): ' + error);
  }

}
