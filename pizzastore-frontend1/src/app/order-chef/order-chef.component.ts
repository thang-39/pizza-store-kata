import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Order } from '../model/order';
import { OrdersService } from '../service/orders.service';
import { OrderStatus } from '../model/orderStatus';
import { AuthService } from '../login/auth.service';

@Component({
  selector: 'app-order-chef',
  templateUrl: './order-chef.component.html',
  styleUrl: './order-chef.component.css'
})
export class OrderChefComponent {
  orderedList: Order[];
  roles: string[]

  constructor(
    private route: ActivatedRoute,
    private orderService: OrdersService) {}

  ngOnInit(): void {
    this.route.data.subscribe(data => {
      console.log(data.status);
      this.getOrdersByStatus(data.status);
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
