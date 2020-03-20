import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';


import {catchError, map} from 'rxjs/operators';
import {throwError} from 'rxjs';
import {Match} from '../Interfaces/match.model';


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

  getLastMatchesByTeam(id: number){
    return this.http.get<Match[]>(this.matchesUrl + '?played=true' + '?teamId=' + id).pipe(
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
  private handleError(error: any) {
    console.error(error);
    return throwError('Server error (' + error.status + '): ' + error);
  }

}
