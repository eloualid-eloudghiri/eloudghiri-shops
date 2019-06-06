import { Component, OnInit } from '@angular/core';
import {Shop} from '../../shared/models/shop.model';
import {ShopsService} from '../../services/shops.service';

@Component({
  selector: 'app-near-by-shop-page',
  templateUrl: './near-by-shop-page.component.html',
  styleUrls: ['./near-by-shop-page.component.css']
})
export class NearByShopPageComponent implements OnInit {

  private shops: Array<Shop>;



  constructor(private shopsService: ShopsService) { }

  ngOnInit() {
    this.shopsService.getShops().subscribe(
        (shops) => {
          this.shops = shops;
        }
    );
  }

}
