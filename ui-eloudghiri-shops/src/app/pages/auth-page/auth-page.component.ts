import { Component, OnInit } from '@angular/core';
import {SessionStorageService} from 'angular-web-storage';
import {Router} from '@angular/router';

@Component({
  selector: 'app-auth-page',
  templateUrl: './auth-page.component.html',
  styleUrls: ['./auth-page.component.css']
})
export class AuthPageComponent implements OnInit {

  private wantToRegister = false;

  constructor(private session: SessionStorageService, private router: Router) { }

  ngOnInit() {
    if (this.session.get('currentUser')) {
      this.router.navigate(['/']);
    }
  }

  public wantToResigterHandler() {
    this.wantToRegister = !this.wantToRegister;
  }

}
