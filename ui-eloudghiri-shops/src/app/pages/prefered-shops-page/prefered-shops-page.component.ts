import { Component, OnInit } from '@angular/core';
import {Shop} from '../../shared/models/shop.model';
import {ShopsService} from '../../services/shops.service';

@Component({
  selector: 'app-refered-shop-page',
  templateUrl: './prefered-shops-page.component.html',
  styleUrls: ['./prefered-shops-page.component.css']
})
export class PreferedShopsPageComponent implements OnInit {

  private shops: Array<Shop>;



  constructor(private shopsService: ShopsService) { }

  ngOnInit() {
    this.shopsService.getLikedShops().subscribe(
        (shops) => {
          this.shops = shops;
        }
    );
  }

}
