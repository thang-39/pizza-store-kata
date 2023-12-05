import { Component, OnInit } from '@angular/core';
import { Order } from '../model/order';
import { OrdersService } from '../service/orders.service';
import { ActivatedRoute } from '@angular/router';
import { OrderStatus } from '../model/orderStatus';

@Component({
  selector: 'app-order-process',
  templateUrl: './order-process.component.html',
  styleUrl: './order-process.component.css'
})
export class OrderProcessComponent implements OnInit{
  orderedList: Order[];
  status: string;
  disabledButton: boolean = false;

  constructor(
    private route: ActivatedRoute,
    private orderService: OrdersService) {}

  ngOnInit(): void {
    this.route.data.subscribe(data => {
      this.status = data.status;
      console.log(data.status);
      this.getOrdersByStatus(this.status);
    })
  }

  getOrdersByStatus(status: string): void {
    this.orderService.getOrdersByStatus(status).subscribe(
      (res) => {
        this.orderedList = res;
      }
    );
  }

  changeOrderStatus(i: number, id: number, newStatus: string) {
    this.orderService.changeOrderStatus(id, new OrderStatus(newStatus)).subscribe(
      (res) => {
        this.orderedList[i] = {...this.orderedList[i], status: newStatus};
      }
    );
  }
 
}
