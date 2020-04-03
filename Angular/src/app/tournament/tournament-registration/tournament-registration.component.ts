import {Component, OnInit} from '@angular/core';
import {TournamentService} from '../tournament.service';
import {Tournament} from '../../Interfaces/tournament.model';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {AuthenticationService} from '../../authentication.service';
import {PlayerService} from '../../player/player.service';
import {Player} from '../../Interfaces/player.model';
import {Router} from '@angular/router';

@Component({
  selector: 'app-tournament-registration',
  templateUrl: './tournament-registration.component.html',
  styleUrls: ['./tournament-registration.component.css']
})
export class TournamentRegistrationComponent implements OnInit {

  private tournaments: Tournament[] = [];
  public createTeamForm: FormGroup;
  public playerNames: string[] = [];
  public players: Player[] = [];

  public errorTeam: boolean;
  public errorUnexpected: boolean;

  constructor(private tournamentService: TournamentService,
              private formBuilder: FormBuilder,
              private authenticationService: AuthenticationService,
              private playerService: PlayerService,
              private router: Router) {
    this.errorTeam = false;
    this.errorUnexpected = false;
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
    this.playerService.getAllPlayers().subscribe(data => {
        this.players = data;
        for (const player of data) {
          this.playerNames.push(player.user.name);
        }
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
    console.log('Nombre del otro player: ' + this.f.SelectedPlayer.value);

    const nameSelectedTournament = this.f.SelectedTournament.value;
    let idTournament;
    for (const tournament of this.tournaments) {
      if (tournament.name === nameSelectedTournament) {
        idTournament = tournament.id;
      }
    }
    console.log('Id del torneo selecionado: ' + idTournament);

    const nameSelectedPlayer = this.f.SelectedPlayer.value;
    let idPlayer;
    for (const player of this.players) {
      if (player.user.name === nameSelectedPlayer) {
        idPlayer = player.id;
      }
    }
    console.log('Id del player seleccionado: ' + idPlayer);
    if (nameSelectedPlayer == null) {
      this.errorTeam = true;
    }
    this.tournamentService.saveTeam(idTournament, idPlayer, this.f.TeamName.value).subscribe(
      result => {
        console.log(result);
        this.router.navigate(['/tournament']);
      },
      (error: Error) => this.errorUnexpected = true
    );
  }

  public getLoggedUser() {
    return this.authenticationService.getUser();
  }

  public getLoggedUserPlayer() {
    return this.authenticationService.getUser().player;
  }
}
