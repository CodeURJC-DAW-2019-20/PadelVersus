import { Injectable } from '@angular/core';
import{HttpClient,HttpHeaders} from "@angular/common/http";
import {catchError, map} from 'rxjs/operators';
import {throwError} from 'rxjs';
import {Match} from "../Interfaces/match.model";

@Injectable({
  providedIn: 'root'
})
export class PlayerService {

  private playerUrls:string;

  constructor(private http:HttpClient) {
    this.playerUrls = 'https://localhost:8443/api/player/';
  }

  getPlayer() {
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
