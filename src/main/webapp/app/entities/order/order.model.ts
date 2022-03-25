export interface IOrder {
  id?: number;
  createTime?: string | null;
  updateTime?: string | null;
  orderNumber?: number;
  address?: string | null;
  phone?: string | null;
  code?: number;
  consignee?: string | null;
  payTime?: string | null;
  shipTime?: string | null;
  status?: number;
  finalPrice?: string | null;
  totalPrice?: string | null;
  userId?: number;
}

export class Order implements IOrder {
  constructor(
    public id?: number,
    public createTime?: string | null,
    public updateTime?: string | null,
    public orderNumber?: number,
    public address?: string | null,
    public phone?: string | null,
    public code?: number,
    public consignee?: string | null,
    public payTime?: string | null,
    public shipTime?: string | null,
    public status?: number,
    public finalPrice?: string | null,
    public totalPrice?: string | null,
    public userId?: number
  ) {}
}
export function getOrderIdentifier(orderId: IOrder): number | undefined {
  return orderId.id;
}

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
