import { Injectable } from '@angular/core';
import{HttpClient,HttpHeaders} from "@angular/common/http";
import {catchError, map} from 'rxjs/operators';
import {Observable, throwError} from 'rxjs';
import {Match} from "../Interfaces/match.model";
import {Player} from "../Interfaces/player.model";
import {Tournament} from "../Interfaces/tournament.model";
import {Team} from "../Interfaces/team.model";

@Injectable({
  providedIn: 'root'
})
export class PlayerService {

  private playerUrls:string;
  private tournamentsPlayerUrls:string;
  private teamsPlayerUrls:string;
  private imagePlayerUrl:string;

  constructor(private http:HttpClient) {
    this.playerUrls = 'https://localhost:8443/api/player/';
    this.tournamentsPlayerUrls = 'https://localhost:8443/api/tournaments/?playerId=';
    this.teamsPlayerUrls = 'https://localhost:8443/api/teams/?playerId=';
    this.imagePlayerUrl = 'https://localhost:8443/api/player/';
  }

  getPlayer(id:number) {
    return this.http.get<Player>(this.playerUrls + id).pipe(
      map(response => response),
      catchError(err => this.handleError(err))
    );
  }

  getTournamentsByPlayer(id:number){
    return this.http.get<Tournament[]>(this.tournamentsPlayerUrls + id).pipe(
      map(response => response),
      catchError(err => this.handleError(err))
    );
  }

  getTeamsByPlayer(id:number){
    return this.http.get<Team[]>(this.teamsPlayerUrls + id).pipe(
      map(response => response),
      catchError(err => this.handleError(err))
    );
  }

  getImageByPlayer(id:number):Observable<Blob>{
    return this.http.get(this.imagePlayerUrl + id+'/image', {responseType: 'blob'}).pipe(
      map(response => response),
      catchError(err => this.handleError(err))
    );
  }

  private handleError(error: any) {
    console.error(error);
    return throwError('Server error (' + error.status + '): ' + error);
  }
}
