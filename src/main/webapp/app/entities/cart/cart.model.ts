import { IProductUser } from '../product-user/product-user.model';

export interface ICartItem {
  productDTO?: IProductUser;
  total?: number;
  price?: number;
}
export class CartItem implements ICartItem {
  constructor(public productDTO?: IProductUser, public total?: number, public price?: number) {}
}
