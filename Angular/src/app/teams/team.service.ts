import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {catchError, map} from 'rxjs/operators';
import {Team} from '../Interfaces/team.model';
import {throwError} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TeamService {

  private teamxUrl: string;

  constructor(private http: HttpClient) {
    this.teamxUrl = 'https://localhost:8443/api/teamx/';
  }

  getTeam(id: number) {
    return this.http.get<Team>(this.teamxUrl + id).pipe(
      map(response => response),
      catchError(err => this.handleError(err))
    );
  }

  private handleError(error: any) {
    console.error(error);
    return throwError('Server error (' + error.status + '): ' + error);
  }
}

