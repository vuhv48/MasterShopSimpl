import { createRequestOption } from './../../core/request/request-util';
import { ICartItem } from './cart.model';
import { ApplicationConfigService } from './../../core/config/application-config.service';
import { HttpClient, HttpParams, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
export type EntityResponseType = HttpResponse<ICartItem>;
export type EntityArrayResponseType = HttpResponse<ICartItem[]>;

@Injectable({
  providedIn: 'root',
})
export class CartService {
  protected resourceUrlCartItem = this.applicationConfigService.getEndpointFor('api/cart/addToCart');
  protected resourceUrlCartItem2 = this.applicationConfigService.getEndpointFor('api/cart');
  constructor(protected http: HttpClient, protected applicationConfigService: ApplicationConfigService) {}

  addToCartTest(req?: any): Observable<EntityResponseType> {
    const options = createRequestOption(req);
    return this.http.get<ICartItem>(this.resourceUrlCartItem, { params: options, observe: 'response' });
  }

  addToCart(id: number, total: string): Observable<EntityResponseType> {
    console.log('add to cart backend cua fontend service...');
    let params = new HttpParams();
    params = params.append('id', id.toString());
    params = params.append('total', total.toString());
    return this.http.post<ICartItem>(this.resourceUrlCartItem, params, { observe: 'response' });
  }

  getDataInCart(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    console.log('cart service .....');
    return this.http.get<ICartItem[]>(this.resourceUrlCartItem2, { params: options, observe: 'response' });
  }
}
