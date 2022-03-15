import { TestBed } from '@angular/core/testing';

import { ProductUserServiceService } from './product-user-service.service';

describe('ProductUserServiceService', () => {
  let service: ProductUserServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProductUserServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
