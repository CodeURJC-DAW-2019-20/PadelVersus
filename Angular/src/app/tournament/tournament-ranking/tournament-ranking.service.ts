import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {catchError, map} from 'rxjs/operators';
import {throwError} from 'rxjs';
import {TeamTournament} from '../../Interfaces/teamTournament.model';

@Injectable({
  providedIn: 'root'
})
export class TournamentRankingService {
  private readonly tournamentUrl: string;

  constructor(private http: HttpClient) {
    this.tournamentUrl = '/api/tournament/id/ranking';
  }

  getTournamentRanking(id: number) {
    const url = this.tournamentUrl.replace('id', (id as unknown as string));
    console.log('Get to: ' + url);
    return this.http.get<TeamTournament[]>(url).pipe(
      map(response => response),
      catchError(err => this.handleError(err))
    );
  }

  private handleError(error: any) {
    console.error(error);
    return throwError('Server error (' + error.status + '): ' + error);
  }
}
