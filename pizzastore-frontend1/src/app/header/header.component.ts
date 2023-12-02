import { Component, EventEmitter, Input, Output } from '@angular/core';
import { OrderItemService } from '../service/order-item.service';
import { Router } from '@angular/router';
import { AuthService } from '../login/auth.service';
import { ProductService } from '../service/product.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {
  isLoggedIn = false;

  constructor(private orderItemService: OrderItemService,
              private router: Router,
              private authenticationService: AuthService,
              private productService: ProductService) {}

  ngOnInit() {
    this.isLoggedIn = this.authenticationService.isUserLoggedIn();
    console.log('menu -> ' + this.isLoggedIn);
  }

  handleLogout() {
    this.authenticationService.logout();
  }


  public getSizeSelectedList(): number {
    return this.orderItemService.getSelectedList().length;
  }
}
