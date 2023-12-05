import { OrderItem } from "./orderItem";

export interface Order {
  // id: number;
  customerName: string;
  phoneNumber: string;
  deliveryTo: string;
  finalAmount: number;
  orderItems: OrderItem[];
  status: string;

  // constructor(customerName: string, phoneNumber: string, deliveryTo: string, finalAmount: number, orderItems: OrderItem[]) {
  //   this.customerName = customerName;
  //   this.phoneNumber = phoneNumber;
  //   this.deliveryTo = deliveryTo;
  //   this.finalAmount = finalAmount;
  //   this.orderItems = orderItems;
  // }
}