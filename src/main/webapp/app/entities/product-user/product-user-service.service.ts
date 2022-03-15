import { IProductUser } from './product-user.model';
import { createRequestOption } from 'app/core/request/request-util';
import { Observable } from 'rxjs';
import { ApplicationConfigService } from 'app/core/config/application-config.service';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';

export type EntityArrayResponseType = HttpResponse<IProductUser[]>;

@Injectable({
  providedIn: 'root',
})
export class ProductUserServiceService {
  protected resourceUrl = this.applicationConfigService.getEndpointFor('api/products');

  constructor(protected http: HttpClient, protected applicationConfigService: ApplicationConfigService) {}

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IProductUser[]>(this.resourceUrl, { params: options, observe: 'response' });
  }
}
