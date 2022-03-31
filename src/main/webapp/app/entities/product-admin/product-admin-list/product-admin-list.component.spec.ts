import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductAdminListComponent } from './product-admin-list.component';

describe('ProductAdminListComponent', () => {
  let component: ProductAdminListComponent;
  let fixture: ComponentFixture<ProductAdminListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ProductAdminListComponent],
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductAdminListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
