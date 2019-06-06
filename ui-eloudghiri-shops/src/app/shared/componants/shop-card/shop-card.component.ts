import {Component, Input, OnInit} from '@angular/core';
import {Shop} from '../../models/shop.model';
import {ShopsService} from '../../../services/shops.service';

@Component({
    selector: 'app-shop-card',
    templateUrl: './shop-card.component.html',
    styleUrls: ['./shop-card.component.css']
})
export class ShopCardComponent implements OnInit {

    @Input() shop: Shop;

    @Input() isInLikedPage: boolean;

    constructor(private shopsService: ShopsService) {
    }

    ngOnInit() {
    }

    onLike() {
        this.shopsService.postAppreciation(this.shop.id, true);
        window.location.reload();
    }

    onDislike() {
        this.shopsService.postAppreciation(this.shop.id, false);
        window.location.reload();
    }
}
