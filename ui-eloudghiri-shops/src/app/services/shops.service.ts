import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable, Subscription} from 'rxjs';
import {environment} from '../../environments/environment';
import {UsersService} from './users.service';
import {Router} from '@angular/router';
import {User} from '../shared/models/user.model';
import {SessionStorageService} from 'angular-web-storage';
import {ShopApreciation} from '../shared/models/shop-apreciation.model';

@Injectable({
    providedIn: 'root'
})
export class ShopsService {

    private actionGetAll = 'Shop/all/';
    private actionGetLiked = 'Shop/liked/';
    private actionShop = 'Shop';

    constructor(private http: HttpClient, private router: Router, private session: SessionStorageService) {
    }

    private handleNotLoged() {
        const currentUser = this.session.get('currentUser');
        if (currentUser == null || currentUser.id == null) {
            this.router.navigate(['/auth']);
        }
    }

    private getCurrentUser(): User {
        return this.session.get('currentUser');
    }


    public getShops(): Observable<any> {
        this.handleNotLoged();
        const user: User = this.getCurrentUser();
        return this.http.get(
            environment.backendEndPoint +
            this.actionGetAll +
            '?' +
            'userId=' + user.id +
            '&' +
            'token=' + user.token
        );
    }

    public getLikedShops(): Observable<any> {
        this.handleNotLoged();
        const user: User = this.getCurrentUser();
        return this.http.get(
            environment.backendEndPoint +
            this.actionGetLiked +
            '?' +
            'userId=' + user.id +
            '&' +
            'token=' + user.token
        );
    }

    public postAppreciation(shopIdValue: number, statusValue: boolean) {
        this.handleNotLoged();
        const user: User = this.getCurrentUser();
        const requestBody: ShopApreciation = new ShopApreciation(
            shopIdValue,
            user.id,
            statusValue,
            user.token
        );
        console.log(environment.backendEndPoint +
            this.actionShop )
        console.table( requestBody);

        return this.http.post(
            environment.backendEndPoint +
            this.actionShop,
            requestBody
        ).subscribe(res => console.log('shop liked'));
    }
}
