import {Component, OnInit} from '@angular/core';
import {TournamentService} from '../tournament.service';
import {Tournament} from '../../Interfaces/tournament.model';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-tournament-registration',
  templateUrl: './tournament-registration.component.html',
  styleUrls: ['./tournament-registration.component.css']
})
export class TournamentRegistrationComponent implements OnInit {

  private tournaments: Tournament[] = [];
  public createTeamForm: FormGroup;


  constructor(private tournamentService: TournamentService,
              private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this.createTeamForm = this.formBuilder.group({
      SelectedTournament: ['', Validators.required],
      TeamName: ['', Validators.required]
    });
    this.tournamentService.getTournaments().subscribe(
      data => {
        this.tournaments = data;
        console.log('Tournaments: ', data);
        this.f.SelectedTournament.setValue(this.tournaments[0].name);
      },
      error => this.handleError(error)
    );

  }


  private handleError(error: any) {
    console.error(error);
  }

  public getTournaments() {
    return this.tournaments;
  }

  get f() {
    return this.createTeamForm.controls;
  }

  public saveTeam() {
    console.log('Torneo seleccionado: ' + this.f.SelectedTournament.value);
    console.log('Nombre del equipo: ' + this.f.TeamName.value);
  }
}
