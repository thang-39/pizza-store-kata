import { Injectable } from '@angular/core';
import { OrderItem } from '../model/orderItem';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class OrderItemService {
  private selectedList: OrderItem[] = [];
  constructor() {
    console.log(1);
    
   }

  public addProductToSelectedList(orderItem: OrderItem) {
    const existingIndex = this.selectedList.findIndex(item => item.productId === orderItem.productId);
    if (existingIndex !== -1) {
      // If an orderItem with the same productId exists, remove it
      this.selectedList.splice(existingIndex, 1);
    }
    
    if (orderItem.quantity > 0) {
      this.selectedList = [...this.selectedList, orderItem];
    }
    console.log(this.selectedList);
  }

  public removeProductFromSelectedList(productId: string) {
    const index = this.selectedList.findIndex(item => item.productId === productId);
    if (index !== -1) {
      this.selectedList.splice(index, 1);
    }
    console.log(this.selectedList);
  }

  public getSelectedList() {
    return this.selectedList;
  }
}
