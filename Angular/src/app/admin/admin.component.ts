import {Component, OnInit} from '@angular/core';

import {Tournament} from '../Interfaces/tournament.model'
import {AdminService} from "./admin.service";

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  private tournamentList: Tournament[] = [];

  constructor(private  adminService: AdminService) {
  }

  ngOnInit(): void {
    this.adminService.getTournaments().subscribe(
      data => {
        this.tournamentList = data;
        console.log('Tournaments', data);
      },
      error => this.handleError(error)
    );
  }

  getTournaments(){
    return this.getTournaments();
  }

  private handleError(error: any) {
    console.error(error);
  }
}
