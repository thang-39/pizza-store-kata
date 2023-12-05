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
  roles: string[];

  constructor(private orderItemService: OrderItemService,
              private router: Router,
              private authenticationService: AuthService,
              private productService: ProductService) {}

  ngOnInit() {
    this.isLoggedIn = this.authenticationService.isUserLoggedIn();
    console.log('menu -> ' + this.isLoggedIn);
    this.authenticationService.loginStatusChange.subscribe(
      (loggedIn: boolean) => {
        this.isLoggedIn = loggedIn;
      }
    )
    this.authenticationService.rolesChange.subscribe(
      (roles: string[]) => {
        this.roles = roles;
      }
    )
  }

  handleLogout() {
    this.authenticationService.logout();
    this.isLoggedIn = false;
  }


  public getSizeSelectedList(): number {
    return this.orderItemService.getSelectedList().length;
  }

  public hasRole(role: string): boolean {
    return this.authenticationService.roles && this.authenticationService.roles.includes(role);
  }
}
