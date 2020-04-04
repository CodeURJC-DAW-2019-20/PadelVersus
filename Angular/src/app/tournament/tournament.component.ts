import {Component, OnInit, ViewChild, ViewEncapsulation} from '@angular/core';
import {TournamentService} from './tournament.service';
import {Tournament} from '../Interfaces/tournament.model';


@Component({
  selector: 'app-tournaments',
  templateUrl: './tournament.component.html',
  styleUrls: ['./tournament.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class TournamentComponent implements OnInit {

  private tournaments: Tournament[] = [];
  showPdf: boolean;

  constructor(private tournamentService: TournamentService) {
  }

  ngOnInit(): void {
    this.tournamentService.getTournaments().subscribe(
      data => {
        this.tournaments = data;
        console.log('Tournaments: ', data);
      },
      error => this.handleError(error)
    );
  }

  getTournaments() {
    return this.tournaments;
  }

  downloadPdf() {
    console.log('Download pdf');
    this.tournamentService.getPdf().subscribe(
      x => {
        const newBlob = new Blob([x], {type: 'application/pdf'});

        if (window.navigator && window.navigator.msSaveOrOpenBlob) {
          window.navigator.msSaveOrOpenBlob(newBlob);
          return;
        }

        const data = window.URL.createObjectURL(newBlob);

        const link = document.createElement('a');
        link.href = data;
        link.download = 'Ranking.pdf';

        link.dispatchEvent(new MouseEvent('click', {bubbles: true, cancelable: true, view: window}));

        setTimeout(() => {
          window.URL.revokeObjectURL(data);
          link.remove();
        }, 100);
      },
      error => this.handleError(error)
    );
  }

  private handleError(error: any) {
    console.error(error);
  }

  onLoaded($event: boolean) {
    console.log('Me llega: ' + $event);
    this.showPdf = $event;
  }
}
