import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';


import {catchError, map} from 'rxjs/operators';
import {throwError} from 'rxjs';
import {Match} from '../Interfaces/match.model';


@Injectable({
  providedIn: 'root'
})
export class MatchService {

  private matchUrl: string;


  constructor(private http: HttpClient) {
    this.matchUrl = '/api/match/';
  }

  getMatch(id: number) {
    console.log('Voy a la URL:', this.matchUrl);
    return this.http.get<Match>(this.matchUrl + id).pipe(
      map(response => response),
      catchError(err => this.handleError(err))
    );
  }

  private handleError(error: any) {
    console.error(error);
    return throwError('Server error (' + error.status + '): ' + error);
  }

}
