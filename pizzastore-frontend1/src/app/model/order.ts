import { OrderItem } from "./orderItem";

export class Order {
  public id: number;
  public customerName: string;
  public phoneNumber: string;
  public deliveryTo: string;
  public finalAmount: number;
  public orderItems: OrderItem[];

  constructor(customerName: string, phoneNumber: string, deliveryTo: string, finalAmount: number, orderItems: OrderItem[]) {
    this.customerName = customerName;
    this.phoneNumber = phoneNumber;
    this.deliveryTo = deliveryTo;
    this.finalAmount = finalAmount;
    this.orderItems = orderItems;
  }

}