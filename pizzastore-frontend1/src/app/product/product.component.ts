import { Component, Input } from '@angular/core';
import { Product } from '../model/product';
import { OrderItem } from '../model/orderItem';
import { OrderItemService } from '../service/order-item.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrl: './product.component.css'
})
export class ProductComponent {
  @Input() product: Product;
  quantity: number = 0;

  constructor(private orderItemService: OrderItemService) {}

  decrementQuantity() {
    if (this.quantity > 0) {
      this.quantity--;
    } else {
      this.quantity = 0;
    }
  }

  incrementQuantity() {
    this.quantity++;
  }

  onAddToSelectedList() {
    const orderItem: OrderItem = {
      productId: this.product.id,
      productName: this.product.name,
      quantity: this.quantity,
      totalAmount: this.quantity * this.product.price,
    }
    this.orderItemService.addProductToSelectedList(orderItem);
  }

  onRemoveFromSelectedList() {
    this.orderItemService.removeProductFromSelectedList(this.product.id);
    this.quantity = 0;
  }
}
