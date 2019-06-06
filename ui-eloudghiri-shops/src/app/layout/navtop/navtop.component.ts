import {Component, OnInit} from '@angular/core';
import {SessionStorageService} from 'angular-web-storage';
import {Router} from '@angular/router';

@Component({
    selector: 'app-nav-top',
    templateUrl: './navtop.component.html',
    styleUrls: ['./navtop.component.css']
})
export class NavtopComponent implements OnInit {

    constructor(private session: SessionStorageService, private router: Router) {
    }

    ngOnInit() {
    }

    logout() {
        this.session.clear();
        this.router.navigate(['/auth']);
    }
}
