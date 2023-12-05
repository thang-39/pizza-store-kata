import { Injectable } from '@angular/core';
import { Order } from '../model/order';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment.development';
import { HttpClient } from '@angular/common/http';
import { OrderStatus } from '../model/orderStatus';

@Injectable({
  providedIn: 'root'
})
export class OrdersService {
  private apiServerUrl = environment.apiBaseUrl;
  constructor(private http: HttpClient) { }

  public placeOrder(order: Order): Observable<Order> {
    return this.http.post<Order>(`${this.apiServerUrl}/orders/prepare`, order);
  }

  public getOrdersByStatus(status: string): Observable<Order[]> {
    return this.http.get<Order[]>(`${this.apiServerUrl}/orders/${status}`);
  }

  public changeOrderStatus(id: number, orderStatus: OrderStatus): Observable<Order> {
    return this.http.patch<Order>(`${this.apiServerUrl}/orders/change-status/${id}`, orderStatus)
  }
}
