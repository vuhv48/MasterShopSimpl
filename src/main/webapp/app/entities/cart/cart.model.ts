export interface ICartItem {
  productDtoId?: number;
  total?: number;
}
export class CartItem implements ICartItem {
  constructor(public productDtoId?: number, public total?: number) {}
}
