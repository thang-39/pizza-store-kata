import { Component } from '@angular/core';
import { Product } from './product';
import { ProductService } from './product.service';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  public products: Product[] = [];
  constructor(private productService: ProductService) {}
  ngOnInit(): void {
    this.getProducts();
  }
  public getProducts(): void {
    this.productService.getProducts().subscribe(
      (response: Product[]) => {
        this.products = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onAddProduct(addForm: NgForm): void {
    document.getElementById('add-employee-form').click();
    this.productService.addProduct(addForm.value).subscribe(
      (response: Product) => {
        console.log(response);
        this.getProducts();
        
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      },
    )
  }

  public searchProducts(key: string) {
    const results: Product[] = [];
    for (const product of this.products) {
      if (product.name.toLowerCase().indexOf(key.toLowerCase()) !== -1 ||
        product.description.toLowerCase().indexOf(key.toLowerCase()) !== -1
        ) {
        results.push(product)
      }
    }
    this.products = results;
    if (results.length === 0 || !key) {
      this.getProducts();
    }
  }

  // if model is addProduct - it will show add product model
  public onOpenModal(product: Product, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');

    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');

    if (mode === 'add') {
      button.setAttribute('data-target', '#addEmployeeModal');
    }

    if (mode === 'edit') {
      button.setAttribute('data-target', '#updateProductModal');
    }

    if (mode === 'delete') {
      button.setAttribute('data-target', '#deleteProductModal');
    }

    container.appendChild(button);
    button.click();
  }
}
