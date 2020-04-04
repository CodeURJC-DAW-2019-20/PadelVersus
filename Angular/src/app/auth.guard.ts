import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from '@angular/router';

@Injectable({providedIn: 'root'})
export class AuthGuard implements CanActivate {

  constructor(private router: Router) {
  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    if (localStorage.getItem('currentUser')) {
      let nameStored = localStorage.getItem('currentUser').split(',')[1].split(':')[1];
      nameStored = nameStored.substr(1, nameStored.length - 2);
      if (nameStored === 'admin') {
        // logged in as admin so go /admin
        this.router.navigate(['/admin']);
      }
      // logged in so return true
      return true;

    }

    // not logged in so redirect to login page with the return url
    this.router.navigate(['/login'], {queryParams: {returnUrl: state.url}});
    return false;
  }
}
