import {Component, OnInit} from '@angular/core';
import {Player} from '../Interfaces/player.model';
import {PlayerService} from '../player/player.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styles: [`
    .navbar-nav {
      width: 100%;
      display: flex;
      flex-wrap: nowrap;
      justify-content: space-between;
    }

    .navbar-nav > li {
      flex-grow: 1;
      text-align: center;
    }

    .item {
      font-family: Montserrat, sans-serif;
      font-size: 14px;
      line-height: normal;
      color: white !important;
      text-transform: uppercase;
    }

    .item:hover {
      color: rgb(255, 160, 0) !important;
      border-bottom: 2px solid rgb(255, 160, 0);
    }
  `
  ]
})
export class HeaderComponent implements OnInit {

  private players: Player[] = [];

  constructor(private playerService: PlayerService) {

  }

  ngOnInit(): void {
    this.playerService.getAllPlayers().subscribe(data => {
        this.players = data;
      },
      error => this.handleError(error));
  }

  private handleError(error: any) {
    console.error(error);
  }

  public islogged() {
    if (localStorage.getItem('currentUser') !== null) {
      return true;
    }
    return false;
  }

  public isAdmin() {
    if (localStorage.getItem('currentUser') !== null) {
      let nameStored = localStorage.getItem('currentUser').split(',')[1].split(':')[1];
      nameStored = nameStored.substr(1, nameStored.length - 2);
      if (nameStored === 'admin') {
        return true;
      }
    }
    return false;
  }

  getLogggedPlayerId() {
    let id: number;
    if (localStorage.getItem('currentUser') !== null) {
      let nameStored = localStorage.getItem('currentUser').split(',')[1].split(':')[1];
      nameStored = nameStored.substr(1, nameStored.length - 2);

      for (const player of this.players) {
        if (player.user.name === nameStored) {
          id = player.id;
        }
      }
    }
    return id;
  }
}
