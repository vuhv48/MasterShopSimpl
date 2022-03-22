import { IProductUser } from '../product-user/product-user.model';

export interface ICartItem {
  productDto?: IProductUser;
  total?: number;
}
export class CartItem implements ICartItem {
  constructor(public productDto?: IProductUser, public total?: number, public totalTest?: number) {}
}
