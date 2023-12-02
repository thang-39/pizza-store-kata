import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProductsComponent } from './products/products.component';
import { LoginComponent } from './login/login.component';
import { OrderAndDeliveryComponent } from './order-and-delivery/order-and-delivery.component';

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'logout', component: LoginComponent},
  {path: '', component: ProductsComponent, pathMatch: 'full'},
  {path: 'drink', component: ProductsComponent, data: { category: 'drink'}},
  {path: 'pizza', component: ProductsComponent, data: { category: 'pizza'}},
  {path: 'order', component: OrderAndDeliveryComponent},
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }