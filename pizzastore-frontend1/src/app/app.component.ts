import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Product } from './model/product';
import { ProductService } from './service/product.service';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { OrderItemService } from './service/order-item.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit{
  loadedFeature = 'pizza';
  selectedProduct: Product;
  pizzas: Product[];
  drinks: Product[];
  orderNumber: number = 0;

  constructor(private productService: ProductService,
              private orderItemService: OrderItemService) {}

  ngOnInit(): void {
    this.getPizzas();
    this.getDrinks();
    this.orderNumber = this.orderItemService.getSelectedList().length;

  }

  onNavigate(feature: string) {
    this.loadedFeature = feature;
  }

  public getPizzas(): void {
    this.productService.getProductsByCategory('pizza').subscribe(
      (response) => {
        this.pizzas = response;
      }
    );
  }

  public getDrinks(): void {
    this.productService.getProductsByCategory('drink').subscribe(
      (response) => {
        this.drinks = response;
      }
    );
  }
  
}
