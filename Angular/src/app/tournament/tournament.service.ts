import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {catchError, map} from 'rxjs/operators';
import {throwError} from 'rxjs';
import {Tournament} from '../Interfaces/tournament.model';


@Injectable({
  providedIn: 'root'
})
export class TournamentService {
  private readonly tournamentsUrl: string;
  private readonly tournamentUrl: string;

  constructor(private http: HttpClient) {
    this.tournamentsUrl = '/api/tournaments/';
    this.tournamentUrl = '/api/tournament/';
  }

  getTournaments() {
    console.log('Get to: ' + this.tournamentsUrl);
    return this.http.get<Tournament[]>(this.tournamentsUrl).pipe(
      map(response => response),
      catchError(err => this.handleError(err))
    );
  }

  getPdf() {
    let headers = new HttpHeaders();
    headers = headers.set('Accept', 'application/pdf');
    return this.http.get(this.tournamentsUrl + 'pdf', {headers, responseType: 'blob'}).pipe(
      map(response => response),
      catchError(err => this.handleError(err))
    );
  }

  saveTeam(tournamentId: number, playerId: number, teamName: string) {
    const body = '{"playerId":' + playerId + ', "teamName":"' + teamName + '"}';
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.put(this.tournamentUrl + tournamentId, body, {headers}).pipe(
      map(response => response),
      catchError(err => this.handleError(err))
    );
  }

  private handleError(error: any) {
    console.error(error);
    return throwError('Server error (' + error.status + '): ' + error);
  }
}
