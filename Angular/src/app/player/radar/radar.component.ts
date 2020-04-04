import {Component, Input, OnInit, ViewEncapsulation} from '@angular/core';
import {PlayerComponent} from "../player.component";
import {ActivatedRoute} from '@angular/router';
import {Player} from "../../Interfaces/player.model";
import {PlayerService} from "../player.service";

@Component({
  selector: 'app-radar',
  templateUrl: './radar.component.html',
  styleUrls: ['./radar.component.css']
})
export class RadarComponent implements OnInit {
  data: any;
  @Input() private idPlayer: number;
  private player: Player;

  constructor(private activatedRoute: ActivatedRoute,private playerService:PlayerService) {
    this.idPlayer = activatedRoute.snapshot.params.id;

  }


  ngOnInit(): void {
    this.playerService.getPlayer(this.idPlayer)
      .subscribe(data => {
        this.player = data;
        this.data = {
          labels: ['Height', 'Weight', 'Endurance', 'Speed', 'Accuaracy', 'Aceleration', 'Strenght', 'Pace'],
          datasets: [
            {
              label:'',
              backgroundColor: 'rgb(248, 201, 78)',
              data: [this.player.height * 100, this.player.weight ,this.player.endurance * 100, this.player.speed * 100,
                this.player.accuaracy * 100, this.player.aceleration * 100, this.player.strength * 100, this.player.pace * 100],


            }
          ]
        };
        console.log('Player info: ', data);
        }
      );

  }





}
