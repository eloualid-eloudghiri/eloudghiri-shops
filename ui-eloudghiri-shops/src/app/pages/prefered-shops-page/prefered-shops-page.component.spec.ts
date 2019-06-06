import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PreferedShopsPageComponent } from './prefered-shops-page.component';

describe('PreferedShopsPageComponent', () => {
  let component: PreferedShopsPageComponent;
  let fixture: ComponentFixture<PreferedShopsPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PreferedShopsPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PreferedShopsPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
