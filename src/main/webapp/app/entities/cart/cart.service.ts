import { createRequestOption } from './../../core/request/request-util';
import { ICartItem } from './cart.model';
import { Observable } from 'rxjs';
import { ApplicationConfigService } from './../../core/config/application-config.service';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
export type EntityResponseType = HttpResponse<ICartItem>;

@Injectable({
  providedIn: 'root',
})
export class CartService {
  protected resourceUrlCartItem = this.applicationConfigService.getEndpointFor('api/cart');

  constructor(protected http: HttpClient, protected applicationConfigService: ApplicationConfigService) {}

  addToCart(req?: any): Observable<EntityResponseType> {
    const options = createRequestOption(req);
    return this.http.get<ICartItem>(this.resourceUrlCartItem, { params: options, observe: 'response' });
  }
}
