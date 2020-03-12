import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';


import {catchError, map} from 'rxjs/operators';
import {throwError} from 'rxjs';
import {Match} from '../Interfaces/Match.model';


@Injectable({
  providedIn: 'root'
})
export class MatchService {

  private matchUrl: string;


  constructor(private http: HttpClient) {
    this.matchUrl = 'https://localhost:8443/api/match/1';
  }

  getMatch() {
    return this.http.get<Match>(this.matchUrl).pipe(
      map(response => response),
      catchError(err => this.handleError(err))
    );
  }

  private handleError(error: any) {
    console.error(error);
    return throwError('Server error (' + error.status + '): ' + error);
  }

}
