import {Component, OnInit, ViewEncapsulation} from '@angular/core';

import {PlayerService} from './player.service';
import {Player} from '../Interfaces/player.model';
import {ActivatedRoute, Router} from '@angular/router';
import {Tournament} from '../Interfaces/tournament.model';
import {Team} from '../Interfaces/team.model';

class Image {
  constructor(public src: string, public file: File) {
  }
}

@Component({
  selector: 'app-player',
  templateUrl: './player.component.html',
  styleUrls: ['./player.component.css'],
  encapsulation: ViewEncapsulation.None
})


export class PlayerComponent implements OnInit {
  public fileInputShown = false;


  constructor(private activatedRoute: ActivatedRoute, private playerService: PlayerService, private router: Router) {
    this.id = activatedRoute.snapshot.params.id;

  }

  private player: Player;
  private id: number;
  private tournaments: Tournament[] = [];
  private teams: Team[] = [];
  public newImagePlayer: Image;
  public uploadButton = false;


  ngOnInit(): void {
    this.playerService.getPlayer(this.id).subscribe(
      data => {
        this.player = data;
        console.log('Player info: ', data);
      },
      error => this.handleError(error)
    );
    this.playerService.getTournamentsByPlayer(this.id).subscribe(
      data => {
        this.tournaments = data;
        console.log('Tournaments info: ', data);
      },
      error => this.handleError(error)
    );
    this.playerService.getTeamsByPlayer(this.id).subscribe(
      data => {
        this.teams = data;
        console.log('Teams info: ', data);
      },
      error => this.handleError(error)
    );

  }


  getPlayer() {
    return this.player;
  }

  getTournamentsByPlayer() {
    return this.tournaments;
  }

  getTeamsByPlayer() {
    return this.teams;
  }

  getId() {
    return this.id;
  }

  private handleError(error: any) {
    console.error(error);
  }

  public showMailAndButton() {
    if (localStorage.getItem('currentUser') === null) {
      return false;
    }
    let nameStored = localStorage.getItem('currentUser').split(',')[1].split(':')[1];
    nameStored = nameStored.substr(1, nameStored.length - 2);
    return nameStored === this.player.user.name;
  }

  processFile(imageInput: any) {


    console.error('upload');
    const file: File = imageInput.files[0];
    const reader = new FileReader();

    reader.addEventListener('load', (eventListener: any) => {

        this.newImagePlayer = new Image(eventListener.target.result, file);

        this.playerService.uploadImage(this.newImagePlayer.file, this.id).subscribe(
          (res) => {

          },
          (err) => {

          });
      }
    );

    reader.readAsDataURL(file);
    this.uploadButton = true;
  }

  getNewImagePlayer() {
    return this.newImagePlayer;
  }


  showFileInput() {
    this.fileInputShown = !this.fileInputShown;
  }

  reload() {
    this.router.navigate(['']).then(() => this.router.navigate(['/player', this.id]));
  }
}
