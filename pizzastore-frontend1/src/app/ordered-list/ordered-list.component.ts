import { Component, Input, OnInit } from '@angular/core';
import { OrderItem } from '../model/orderItem';
import { ProductService } from '../service/product.service';

@Component({
  selector: 'app-ordered-list',
  templateUrl: './ordered-list.component.html',
  styleUrl: './ordered-list.component.css'
})
export class OrderedListComponent{
  @Input() selectedList: OrderItem[];
  
}
