import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductUserListComponent } from './product-user-list.component';

describe('ProductUserListComponent', () => {
  let component: ProductUserListComponent;
  let fixture: ComponentFixture<ProductUserListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ProductUserListComponent],
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductUserListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
