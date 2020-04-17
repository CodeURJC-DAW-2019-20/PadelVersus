import {Component, OnInit} from '@angular/core';
import {AuthenticationService} from '../authentication.service';
import {Router, ActivatedRoute} from '@angular/router';
import {User} from '../Interfaces/user.model';
import {Player} from '../Interfaces/player.model';
import {PlayerService} from "../player/player.service";

class Image {
  constructor(public src: string, public file: File) {
  }
}

@Component({
  selector: 'app-player',
  templateUrl: './signUpPlayerImage.component.html',
  styleUrls: [
    './signUpPlayer.component.css'
  ]
})

export class SignUpPlayerImageComponent {
  private playerId: number;
  error: boolean;
  public newImagePlayer: Image;
  public uploadButton = false;

  constructor(private router: Router, private activatedRoute: ActivatedRoute, private service: AuthenticationService, private playerService: PlayerService) {

  }

  ngOnInit(): void {
    this.playerId = this.activatedRoute.snapshot.params.id;
    console.error(this.playerId);
  }

  cancel() {
    window.history.back();
  }

  processFile(imageInput: any) {


    console.error('upload');
    const file: File = imageInput.files[0];
    const reader = new FileReader();

    reader.addEventListener('load', (eventListener: any) => {

        this.newImagePlayer = new Image(eventListener.target.result, file);

        this.playerService.uploadImage(this.newImagePlayer.file, this.playerId).subscribe(
          (res) => {

          },
          (err) => {

          });
      }
    );

    reader.readAsDataURL(file);
    this.uploadButton = true;
  }
  reload() {
    this.router.navigate(['']);
  }
}
