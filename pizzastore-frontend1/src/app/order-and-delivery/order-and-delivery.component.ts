import { Component, Input } from '@angular/core';
import { OrderItem } from '../model/orderItem';
import { Order } from '../model/order';
import { HttpErrorResponse } from '@angular/common/http';
import { OrdersService } from '../service/orders.service';
import { OrderItemService } from '../service/order-item.service';

@Component({
  selector: 'app-order-and-delivery',
  templateUrl: './order-and-delivery.component.html',
  styleUrl: './order-and-delivery.component.css'
})
export class OrderAndDeliveryComponent {
  selectedList: OrderItem[] = [];
  finalAmount: number = 0;
  customerName: string = '';
  phoneNumber: string = '';
  deliveryTo: string = '';
  
  constructor(private orderService: OrdersService, 
    private orderItemService: OrderItemService) {}

  ngOnInit(): void {
    this.getSelectedList();
    this.calculateTotalAmount();
  }
  public getSelectedList(): void {
    this.selectedList = this.orderItemService.getSelectedList();
    console.log(this.selectedList);
  }

  calculateTotalAmount(): void {
    this.finalAmount = this.selectedList
      .reduce((total, orderItem) => total + orderItem.totalAmount, 0);
  }

  submitOrder() {
    const order = new Order(this.customerName, this.phoneNumber, 
      this.deliveryTo, this.finalAmount, this.selectedList);
    console.log(order);
    
    this.orderService.placeOrder(order).subscribe(
      (response: Order) => {
        
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
}
