import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../authentication.service';
import { Router, ActivatedRoute } from '@angular/router';
import {User} from '../Interfaces/user.model';
import {Player} from '../Interfaces/player.model';
import {PlayerService} from "../player/player.service";

class Image {
  constructor(public src: string, public file: File) {
  }
}

@Component({
  selector: 'app-player',
  templateUrl: './signUpPlayer.component.html',
  styleUrls: [
    './signUpPlayer.component.css'
  ]
})

export class SignUpPlayerComponent {
  private idUser: number;
  player: Player;
  error: boolean;
  public newImagePlayer: Image;
  private playerId: number;

  constructor(private router: Router, private activatedRoute: ActivatedRoute, private service: AuthenticationService, private playerService: PlayerService) {
    this.player = { age: 0, countryBirth: '', endurance: 0, height: 0, weight: 0, speed: 0, accuaracy: 0, strength: 0, aceleration: 0, pace: 0 };
    this.error = false;
  }
  ngOnInit(): void {
    this.idUser = this.activatedRoute.snapshot.params.id;
    console.error(this.idUser);
  }

  cancel() {
    window.history.back();
  }

  save() {
    console.log('aceleration:' + this.player.aceleration);
    this.player.idUser = this.idUser;
    console.log('player user id:' + this.player.idUser);
    this.service.savePlayer(this.player).subscribe(
      data => {
        console.error(data);
        // GO TO THE LAST PAGE
        this.playerId = data.id;
        this.error = false;
        this.router.navigate(['/signupplayerimage/' + data.id]);


        //this.router.navigate(['']);
        // location.assign('http://localhost:4200/');
        // window.history.back();
      },
      (error: Error) => {
        // location.reload(true),
        console.error('Error creating new player: ' + error);
        // this.error = true;
        this.error = true;
      },
      // console.error('Error creating new user: ' + error),
    );

  }

}
