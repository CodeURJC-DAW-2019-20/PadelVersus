import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {catchError, map} from 'rxjs/operators';
import {Team} from '../../Interfaces/team.model';
import {throwError} from 'rxjs';
import {TeamOfPage} from "../../Interfaces/teamOfPage.model";

@Injectable({
  providedIn: 'root'
})
export class TeamService {

  private teamxUrl: string;
  private teamListUrl:string;

  constructor(private http: HttpClient) {
    this.teamxUrl = '/api/teamx/';
    this.teamListUrl = 'api/teamsList/';
  }

  getTeam(id: number) {
    return this.http.get<Team>(this.teamxUrl + id).pipe(
      map(response => response),
      catchError(err => this.handleError(err))
    );
  }

  getPageTeam(){
    return this.http.get<TeamOfPage[]>(this.teamListUrl).pipe(
      map(response => response),
      catchError(err => this.handleError(err))
    );
  }

  private handleError(error: any) {
    console.error(error);
    return throwError('Server error (' + error.status + '): ' + error);
  }
}

