import {Component, OnInit} from '@angular/core';
import {SessionStorageService} from 'angular-web-storage';
import {Router} from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'ui-eloudghiri-shops';

  constructor() { }

  ngOnInit(): void {
  }
}
