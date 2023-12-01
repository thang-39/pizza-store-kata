import { Component, EventEmitter, Input, Output } from '@angular/core';
import { OrderItemService } from '../service/order-item.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {
  @Output() featureSelected = new EventEmitter<string>();

  constructor(private orderItemService: OrderItemService) {}

  onSelect(feature: string) {
    this.featureSelected.emit(feature);
  }

  public getSelectedList(): number {
    return this.orderItemService.getSelectedList().length;
  }
}
