import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {NavtopComponent} from './layout/navtop/navtop.component';
import {AuthPageComponent} from './pages/auth-page/auth-page.component';
import { ShopCardComponent } from './shared/componants/shop-card/shop-card.component';
import { NearByShopPageComponent } from './pages/near-by-shop-page/near-by-shop-page.component';
import {AngularFontAwesomeModule} from 'angular-font-awesome';
import {HttpClientModule} from '@angular/common/http';
import { PreferedShopsPageComponent } from './pages/prefered-shops-page/prefered-shops-page.component';
import { RegisterComponent } from './pages/auth-page/register/register.component';
import { LoginComponent } from './pages/auth-page/login/login.component';
import {ReactiveFormsModule} from '@angular/forms';
import { ErrorPageComponent } from './pages/error-page/error-page.component';
import {AngularWebStorageModule} from 'angular-web-storage';

@NgModule({
    declarations: [
        AppComponent,
        NavtopComponent,
        AuthPageComponent,
        ShopCardComponent,
        NearByShopPageComponent,
        PreferedShopsPageComponent,
        RegisterComponent,
        LoginComponent,
        ErrorPageComponent
    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        AngularFontAwesomeModule,
        HttpClientModule,
        ReactiveFormsModule,
        AngularWebStorageModule
    ],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule {
}
