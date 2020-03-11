import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {catchError, map} from 'rxjs/operators';
import {Observable, throwError} from 'rxjs';
import {Tournament} from '../Interfaces/tournament.model';

@Injectable({
  providedIn: 'root'
})
export class TournamentService {
  private readonly tournamentsUrl: string;

  constructor(private http: HttpClient) {
    this.tournamentsUrl = 'https://localhost:8443/api/tournaments/';
  }

  getTournaments() {
    console.log('Get to: ' + this.tournamentsUrl);
    return this.http.get<Tournament[]>(this.tournamentsUrl).pipe(
      map(response => response),
      catchError(err => this.handleError(err))
    );
  }

  private handleError(error: any) {
    console.error(error);
    return throwError('Server error (' + error.status + '): ' + error);
  }
}
