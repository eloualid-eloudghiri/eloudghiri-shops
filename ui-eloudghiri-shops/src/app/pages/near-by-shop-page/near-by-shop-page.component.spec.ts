import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NearByShopPageComponent } from './near-by-shop-page.component';

describe('NearByShopPageComponent', () => {
  let component: NearByShopPageComponent;
  let fixture: ComponentFixture<NearByShopPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NearByShopPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NearByShopPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
