import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

import {Match} from '../Interfaces/match.model';

import {catchError, map} from 'rxjs/operators';
import {throwError} from 'rxjs';
import {Tournament} from '../Interfaces/tournament.model';


@Injectable({
  providedIn: 'root'
})
export class MatchesService {

  private matchesUrl: string;
  private datesUrl: string;
  private tournamentMatchUrl: string;

  constructor(private http: HttpClient) {
    this.matchesUrl = '/api/matches/';
    this.datesUrl = '/api/dates';
    this.tournamentMatchUrl = '/api/tournaments/?matchId=';
  }

  getNextMatches() {
    return this.http.get<Match[]>(this.matchesUrl + '?played=false').pipe(
      map(response => {
        for (const match of response) {
          console.log('matchId: ' + match.id);
          this.getTournamentOfMatch(match.id).subscribe(
            data => {
              match.tournammentName = data[0].name;
            },
            error => this.handleError(error)
          );
        }
        return response;
      }),
      catchError(err => this.handleError(err))
    );
  }

  getLastMatches() {
    return this.http.get<Match[]>(this.matchesUrl + '?played=true').pipe(
      map(response => {
        for (const match of response) {
          console.log('matchId: ' + match.id);
          this.getTournamentOfMatch(match.id).subscribe(
            data => {
              match.tournammentName = data[0].name;
            },
            error => this.handleError(error)
          );
        }
        return response;
      }),
      catchError(err => this.handleError(err))
    );
  }

  getDates() {
    return this.http.get<string[]>(this.datesUrl).pipe(
      map(response => response),
      catchError(err => this.handleError(err))
    );
  }

  getMatchesByDate(date: string) {
    return this.http.get<Match[]>(this.matchesUrl + '?date=' + date).pipe(
      map(response => response),
      catchError(err => this.handleError(err))
    );
  }

  getTournamentOfMatch(id: number) {
    console.log('Get to: ' + this.tournamentMatchUrl + id);
    return this.http.get<Tournament>(this.tournamentMatchUrl + id).pipe(
      map(response => response),
      catchError(err => this.handleError(err))
    );
  }

  private handleError(error: any) {
    console.error(error);
    return throwError('Server error (' + error.status + '): ' + error);
  }

}
