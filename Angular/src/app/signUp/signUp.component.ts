import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../authentication.service';
import { Router, ActivatedRoute } from '@angular/router';
import {User} from '../Interfaces/user.model';
@Component({
  templateUrl: './signUp.component.html',
  styleUrls: [
    './signUp.component.css'
  ]
})

export class SignUpComponent {
  newUser: boolean;
  user: User;
  error: boolean;

  constructor(private router: Router, activatedRoute: ActivatedRoute, private service: AuthenticationService) {
    this.user = { name: '', passwordHash: '', mail: '', roles: ['ROLE_USER'], player: null };
    this.newUser = true;
    // this.error = false;
  }

  cancel() {
    //window.history.back();
    this.router.navigate(['/login'])
  }

  save() {
    console.log('user:' + this.user.name);
    console.log('user:' + this.user.passwordHash);
    console.log('user:' + this.user.mail);
    this.service.saveUser(this.user).subscribe(
      data => {
        console.error(data);
        // GO TO THE LAST PAGE
        this.error = false;
        this.service.login(this.user.name, this.user.passwordHash).subscribe(
          () => {
            location.assign('http://localhost:4200/signupplayer/' + data.id);
          }
      );
       // window.history.back();
      },
      (error: Error) => {
        // location.reload(true),
        this.error = true;
      },
      // console.error('Error creating new user: ' + error),
    );

  }


}
