export interface IOrderItem {
  id?: number;
  quantity?: number;
  productId?: number;
  productPrice?: number;
  orderId?: number;
}

export class OrderItem implements IOrderItem {
  constructor(public id?: number, public quantity?: number, public productId?: number, public orderId?: number) {}
}

export function getOrderItemIdentifier(orderItemId: IOrderItem): number | undefined {
  return orderItemId.id;
}
