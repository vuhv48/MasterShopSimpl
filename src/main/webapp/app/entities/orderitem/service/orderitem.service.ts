import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ApplicationConfigService } from 'app/core/config/application-config.service';
import { Observable } from 'rxjs';
import { IOrderItem } from '../orderitem.model';
export type EntityArrayResponseType = HttpResponse<IOrderItem[]>;
@Injectable({
  providedIn: 'root',
})
export class OrderitemService {
  protected resourceUrl = this.applicationConfigService.getEndpointFor('/api/orders/itemview');
  constructor(protected http: HttpClient, protected applicationConfigService: ApplicationConfigService) {}

  getOrderItemWithId(orderId: number): Observable<EntityArrayResponseType> {
    return this.http.get<IOrderItem[]>(`${this.resourceUrl}/${orderId}`, { observe: 'response' });
  }
}
