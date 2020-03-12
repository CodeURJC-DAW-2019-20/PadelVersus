import { Injectable } from '@angular/core';
import{HttpClient,HttpHeaders} from "@angular/common/http";
import {catchError, map} from 'rxjs/operators';
import {throwError} from 'rxjs';
import {Match} from "../Interfaces/match.model";
import {Player} from "../Interfaces/player.model";

@Injectable({
  providedIn: 'root'
})
export class PlayerService {

  private playerUrls:string;
  private tournamentsPlayerUrls:string;
  private teamsPlayerUrls:string;

  constructor(private http:HttpClient) {
    this.playerUrls = 'https://localhost:8443/api/player/';
    this.tournamentsPlayerUrls = 'https://localhost:8443/api/tournaments/?playerId=';
  }

  getPlayer(id:number) {
    return this.http.get<Player>(this.playerUrls + id).pipe(
      map(response => response),
      catchError(err => this.handleError(err))
    );
  }

  getTournamentsByPlayer(id:number){
    return this.http.get<Tournament>(this.playerUrls + id).pipe(
      map(response => response),
      catchError(err => this.handleError(err))
    );
  }

  private handleError(error: any) {
    console.error(error);
    return throwError('Server error (' + error.status + '): ' + error);
  }
}
