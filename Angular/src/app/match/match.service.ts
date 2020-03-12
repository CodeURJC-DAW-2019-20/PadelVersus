import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';


import { map } from 'rxjs/operators';
import { catchError } from 'rxjs/operators';
import {throwError} from 'rxjs';
import {Match} from "../Interfaces/Match.model";


@Injectable({
  providedIn: 'root'
})
export class MatchService {

  private matchUrl: string;


  constructor(private http: HttpClient) {
      this.matchUrl = 'https://localhost:8443/api/match/';
  }

  getMatch(id:number) {
    this.matchUrl= this.matchUrl+id;
    console.log("Voy a la URL:",this.matchUrl)
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
