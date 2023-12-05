import { Component } from '@angular/core';
import { OrderStatus } from '../model/orderStatus';
import { ActivatedRoute } from '@angular/router';
import { OrdersService } from '../service/orders.service';
import { Order } from '../model/order';

@Component({
  selector: 'app-order-shipper',
  templateUrl: './order-shipper.component.html',
  styleUrl: './order-shipper.component.css'
})
export class OrderShipperComponent {
  orderedList: Order[];
  status: string;


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
