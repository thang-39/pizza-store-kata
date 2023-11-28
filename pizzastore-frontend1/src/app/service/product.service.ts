import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../model/product';
import { environment } from '../../environments/environment.development';
import { OrderItem } from '../model/orderItem';
import { Order } from '../model/order';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) {}

  public getProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(`${this.apiServerUrl}/product-list`);
  }

  public getProductsByCategory(category: string): Observable<Product[]> {
    return this.http.get<Product[]>(`${this.apiServerUrl}/product-list/${category}`);
  }

  public addProduct(product: Product): Observable<Product> {
    return this.http.post<Product>(`${this.apiServerUrl}/products`, product);
  }
  
}
