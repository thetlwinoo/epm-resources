import { Moment } from 'moment';
import { IOrderLines } from 'app/shared/model/order-lines.model';
import { OrderStatus } from 'app/shared/model/enumerations/order-status.model';

export interface IOrders {
  id?: number;
  orderDate?: Moment;
  dueDate?: Moment;
  shipDate?: Moment;
  paymentStatus?: number;
  orderFlag?: number;
  orderNumber?: string;
  subTotal?: number;
  taxAmount?: number;
  frieight?: number;
  totalDue?: number;
  comments?: string;
  deliveryInstructions?: string;
  internalComments?: string;
  pickingCompletedWhen?: Moment;
  status?: OrderStatus;
  lastEditedBy?: string;
  lastEditedWhen?: Moment;
  orderOnReviewId?: number;
  orderLineLists?: IOrderLines[];
  customerId?: number;
  shipToAddressId?: number;
  billToAddressId?: number;
  shipMethodName?: string;
  shipMethodId?: number;
  currencyRateId?: number;
  paymentTransactionId?: number;
  specialDealsId?: number;
}

export class Orders implements IOrders {
  constructor(
    public id?: number,
    public orderDate?: Moment,
    public dueDate?: Moment,
    public shipDate?: Moment,
    public paymentStatus?: number,
    public orderFlag?: number,
    public orderNumber?: string,
    public subTotal?: number,
    public taxAmount?: number,
    public frieight?: number,
    public totalDue?: number,
    public comments?: string,
    public deliveryInstructions?: string,
    public internalComments?: string,
    public pickingCompletedWhen?: Moment,
    public status?: OrderStatus,
    public lastEditedBy?: string,
    public lastEditedWhen?: Moment,
    public orderOnReviewId?: number,
    public orderLineLists?: IOrderLines[],
    public customerId?: number,
    public shipToAddressId?: number,
    public billToAddressId?: number,
    public shipMethodName?: string,
    public shipMethodId?: number,
    public currencyRateId?: number,
    public paymentTransactionId?: number,
    public specialDealsId?: number
  ) {}
}
