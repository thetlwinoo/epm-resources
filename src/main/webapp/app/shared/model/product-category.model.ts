export interface IProductCategory {
  id?: number;
  name?: string;
  shortLabel?: string;
  photoContentType?: string;
  photo?: any;
  parentName?: string;
  parentId?: number;
}

export class ProductCategory implements IProductCategory {
  constructor(
    public id?: number,
    public name?: string,
    public shortLabel?: string,
    public photoContentType?: string,
    public photo?: any,
    public parentName?: string,
    public parentId?: number
  ) {}
}
