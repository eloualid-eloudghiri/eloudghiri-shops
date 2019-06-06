import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AuthPageComponent} from './pages/auth-page/auth-page.component';
import {NearByShopPageComponent} from './pages/near-by-shop-page/near-by-shop-page.component';
import {PreferedShopsPageComponent} from './pages/prefered-shops-page/prefered-shops-page.component';
import {ErrorPageComponent} from './pages/error-page/error-page.component';

const routes: Routes = [
  {path: 'auth', component: AuthPageComponent},
  {path: 'nearbyshops', component: NearByShopPageComponent},
  {path: 'preferedshops', component: PreferedShopsPageComponent},
  {path: '', redirectTo: '/nearbyshops', pathMatch: 'full'},
  { path: '**', component: ErrorPageComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
