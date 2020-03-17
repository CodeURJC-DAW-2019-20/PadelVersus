import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {PlayerService} from "../player/player.service";


@Component({
  selector: 'app-images',
  templateUrl: './images.component.html',
  styleUrls: ['./images.component.css']
})
export class ImagesComponent implements OnInit {

  private idPlayer:number;
  private imagePlayer:any;

  constructor(private activatedRoute: ActivatedRoute, private playerService: PlayerService) {
    this.idPlayer = activatedRoute.snapshot.params.id;
  }

  ngOnInit(): void {

    this.playerService.getImageByPlayer(this.idPlayer)
      .subscribe(data => {
          this.createImageFromBlob(data);
        }, error => {
          console.log(error);
        }
      );
  }


  private createImageFromBlob(image: Blob) {
    let reader = new FileReader();
    reader.addEventListener("load", () => {
      this.imagePlayer = reader.result;
    }, false);

    if (image) {
      reader.readAsDataURL(image);
    }
  }

  getImageByPlayer(){
    return this.imagePlayer;
  }

}
