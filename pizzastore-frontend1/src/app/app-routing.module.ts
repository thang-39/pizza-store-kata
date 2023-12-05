import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProductsComponent } from './products/products.component';
import { LoginComponent } from './login/login.component';
import { OrderAndDeliveryComponent } from './order-and-delivery/order-and-delivery.component';
import { OrderProcessComponent } from './order-process/order-process.component';
import { OrderChefComponent } from './order-chef/order-chef.component';
import { OrderShipperComponent } from './order-shipper/order-shipper.component';

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'logout', component: LoginComponent},
  {path: '', component: ProductsComponent, pathMatch: 'full', data: { category: 'pizza'}},
  {path: 'drink', component: ProductsComponent, data: { category: 'drink'}},
  {path: 'pizza', component: ProductsComponent, data: { category: 'pizza'}},
  {path: 'order', component: OrderAndDeliveryComponent},
  {path: 'receptionist', component: OrderProcessComponent, data: { status: 'PENDING'}},
  {path: 'chef', component: OrderChefComponent, data: { status: 'CONFIRMED'}},
  {path: 'delivery', component: OrderShipperComponent, data: { status: 'COOKED'}},
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})

export class AppRoutingModule { }