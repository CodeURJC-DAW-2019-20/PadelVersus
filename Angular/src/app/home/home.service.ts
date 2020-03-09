import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Match } from '../Interfaces/match.model';

import { map } from 'rxjs/operators';
import { catchError } from 'rxjs/operators';
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
    return this.http.get<Match[]>(this.matchesUrl).pipe(
      map(response => response),
      catchError(err => this.handleError(err))
    );
  }

  private handleError(error: any) {
    console.error(error);
    return throwError('Server error (' + error.status + '): ' + error);
  }

}
