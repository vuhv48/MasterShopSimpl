import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ApplicationConfigService } from 'app/core/config/application-config.service';
import { Observable, of } from 'rxjs';
import { IOrder } from '../order.model';
export type EntityArrayResponseType = HttpResponse<IOrder[]>;
export type EntityArrayResponseTypeOrderItems = HttpResponse<IOrder[]>;

@Injectable({
  providedIn: 'root',
})
export class OrderService {
  protected resourceUrlOrder = this.applicationConfigService.getEndpointFor('/api/orders');
  protected test = false;
  constructor(protected http: HttpClient, protected applicationConfigService: ApplicationConfigService) {}

  getOrderItemsWithOrderIdAndOrdering(req?: any): Observable<any> {
    console.log('getOrderItemsWithOrderIdAndOrdering...');
    return this.http.post<any>(this.resourceUrlOrder + '/ordering', Boolean, { observe: 'response' });
  }

  getMyOrders(req?: any): Observable<EntityArrayResponseType> {
    console.log('get Orders...');
    return this.http.get<IOrder[]>(this.resourceUrlOrder, { observe: 'response' });
  }

  // getOrderItems() : Observable<EntityArrayResponseType>{

  // }

  testBackend(): Observable<any> {
    return this.http.get<any>(this.resourceUrlOrder, { observe: 'response' });
  }
}
