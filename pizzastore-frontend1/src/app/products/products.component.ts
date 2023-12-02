import { Component, Input, OnInit } from '@angular/core';
import { Product } from '../model/product';
import { ActivatedRoute } from '@angular/router';
import { ProductService } from '../service/product.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrl: './products.component.css'
})
export class ProductsComponent {
  products: Product[];
  category: string;

  constructor(
    private route: ActivatedRoute,
    private productService: ProductService
  ) {}

  ngOnInit(): void {
    this.route.data.subscribe(data => {
      this.category = data.category;
      this.getProductsByCategory(this.category);
    });
  }

  getProductsByCategory(category: string): void {
    this.productService.getProductsByCategory(category).subscribe(
      (response) => {
        this.products = response;
      }
    );
  }
}
