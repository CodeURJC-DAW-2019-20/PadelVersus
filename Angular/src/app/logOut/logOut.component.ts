import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
import {AuthenticationService} from "../authentication.service";

@Component({templateUrl: 'logOutButton.component.html',
  styleUrls: ['./logOut.component.css']})

export class LogOutComponent implements OnInit {
  loginForm: FormGroup;
  loading = false;
  submitted = false;
  returnUrl: string;
  error = '';

  constructor(
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private authenticationService: AuthenticationService) {}

  ngOnInit() {

  }

  onSubmit() {
    console.error("LOG OUT");
    this.authenticationService.logOut().subscribe(
      data => {
        console.error(data.toString());
        location.assign("");
      }
      );
  }
}
