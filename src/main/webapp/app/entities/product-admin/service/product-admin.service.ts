import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ApplicationConfigService } from 'app/core/config/application-config.service';
import { IProductUser } from 'app/entities/product-user/product-user.model';
export type EntityArrayResponseType = HttpResponse<IProductUser[]>;

@Injectable({
  providedIn: 'root',
})
export class ProductAdminService {
  protected resourceUrl = this.applicationConfigService.getEndpointFor('api/products');

  constructor(protected http: HttpClient, protected applicationConfigService: ApplicationConfigService) {}
}
