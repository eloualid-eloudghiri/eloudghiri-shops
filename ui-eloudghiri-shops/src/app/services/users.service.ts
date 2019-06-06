import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable, Subscription} from 'rxjs';
import {environment} from '../../environments/environment';
import {User} from '../shared/models/user.model';
import {UserAuthentification} from '../shared/models/user-authentification.model';
import {Router} from '@angular/router';
import {SessionStorageService} from 'angular-web-storage';

@Injectable({
    providedIn: 'root'
})
export class UsersService {

    public constructor(private http: HttpClient, private router: Router, private session: SessionStorageService) {
    }

    private actionRegister = 'register/';
    private actionLogin = 'login/';


    public register(user: User): Observable<any> {
        console.table(user);
        return this.http.post(environment.backendEndPoint + this.actionRegister, user);
    }

    public login(userAuthentification: UserAuthentification): Subscription {
        const currentUser = this.session.get('currentUser');
        if (currentUser == null || currentUser.id == null) {
            console.log(environment.backendEndPoint + this.actionLogin +
                '?' +
                'email=' + userAuthentification.email +
                '&' +
                'password=' + userAuthentification.password);
            return this.http.get(
                environment.backendEndPoint +
                this.actionLogin +
                '?' +
                'email=' + userAuthentification.email +
                '&' +
                'password=' + userAuthentification.password
            ).subscribe(
                (newData: User) => {
                    console.log(newData);
                    this.session.set('currentUser', newData);
                    this.router.navigate(['/nearbyshops']);
                }
            );
        } else {
            this.router.navigate(['/nearbyshops']);
        }
    }
}
