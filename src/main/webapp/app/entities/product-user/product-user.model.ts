export interface IProductUser {
  id?: number;
  createTime?: string | null;
  updateTime?: string | null;
  name?: string | null;
  point?: number;
  note?: string | null;
  code?: string | null;
  model?: string | null;
  stock?: number;
  userId?: number;
  masterPicId?: number;
}
export class Product implements IProductUser {
  constructor(
    public id?: number,
    public createTime?: string | null,
    public updateTime?: string | null,
    public name?: string | null,
    public point?: number,
    public note?: string | null,
    public code?: string | null,
    public model?: string | null,
    public stock?: number,
    public userId?: number,
    public masterPicId?: number
  ) {}
}

export function getProductIdentifier(product: IProductUser): number | undefined {
  return product.id;
}
