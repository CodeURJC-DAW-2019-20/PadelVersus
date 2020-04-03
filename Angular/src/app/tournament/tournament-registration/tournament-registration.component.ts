import {Component, OnInit} from '@angular/core';
import {TournamentService} from '../tournament.service';
import {Tournament} from '../../Interfaces/tournament.model';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {AuthenticationService} from '../../authentication.service';
import {PlayerService} from '../../player/player.service';

@Component({
  selector: 'app-tournament-registration',
  templateUrl: './tournament-registration.component.html',
  styleUrls: ['./tournament-registration.component.css']
})
export class TournamentRegistrationComponent implements OnInit {

  private tournaments: Tournament[] = [];
  public createTeamForm: FormGroup;
  public playerNames: string[] = [];

  constructor(private tournamentService: TournamentService,
              private formBuilder: FormBuilder,
              private authenticationService: AuthenticationService,
              private playerService: PlayerService) {
  }

  ngOnInit(): void {
    this.createTeamForm = this.formBuilder.group({
      SelectedTournament: ['', Validators.required],
      TeamName: ['', Validators.required],
      UserLoggedName: ['', Validators.required],
      SelectedPlayer: ['', Validators.required],
    });
    this.tournamentService.getTournaments().subscribe(
      data => {
        this.tournaments = data;
        console.log('Tournaments: ', data);
        this.f.SelectedTournament.setValue(this.tournaments[0].name);
      },
      error => this.handleError(error)
    );
    this.playerService.getAllPlayersNames().subscribe(data => {
        this.playerNames = data;
        const index = this.playerNames.indexOf(this.getLoggedUser().name, 0);
        if (index > -1) {
          this.playerNames.splice(index, 1);
        }
        console.log('playerNames: ', data);
        this.f.SelectedPlayer.setValue(this.playerNames[0]);
      },
      error => this.handleError(error));
  }


  private handleError(error: any) {
    console.error(error);
  }

  public getTournaments() {
    return this.tournaments;
  }

  public getPlayerNames() {
    return this.playerNames;
  }

  get f() {
    return this.createTeamForm.controls;
  }

  public saveTeam() {
    console.log('Torneo seleccionado: ' + this.f.SelectedTournament.value);
    console.log('Nombre del equipo: ' + this.f.TeamName.value);
    console.log('Id del usuario registrado: ' + this.getLoggedUser().id);
    console.log('Nombre del player registrado: ' + this.getLoggedUserPlayer().age);
    console.log('Nombre del otro player' + this.f.SelectedPlayer.value);
  }

  public getLoggedUser() {
    return this.authenticationService.getUser();
  }

  public getLoggedUserPlayer() {
    return this.authenticationService.getUser().player;
  }
}
