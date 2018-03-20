import { Injectable } from '@angular/core';
import { Router, CanActivate } from '@angular/router';
import {  AuthserviceService } from './authservice.service'

@Injectable()
export class AuthguardService implements CanActivate {

  constructor(public auth: AuthserviceService, public router: Router) {}

  canActivate(): boolean {
    if (!this.auth.isAuthenticated()){
      this.router.navigate(['app-login-cmp']);
      return false;
    }
    return true;
  }

}
