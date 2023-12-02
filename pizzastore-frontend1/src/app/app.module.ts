import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ProductService } from './service/product.service';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { HeaderComponent } from './header/header.component';
import { OrderedListComponent } from './ordered-list/ordered-list.component';
import { OrderAndDeliveryComponent } from './order-and-delivery/order-and-delivery.component';
import { ProductComponent } from './product/product.component';
import { ProductsComponent } from './products/products.component';
import { DropdownDirective } from './dropdown.directive';
import { LoginComponent } from './login/login.component';
import { HttpInterceptorService } from './login/httpInterceptor.service';
import { AppRoutingModule } from './app-routing.module';
import { Routes , RouterModule} from '@angular/router';



@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    OrderedListComponent,
    OrderAndDeliveryComponent,
    ProductComponent,
    ProductsComponent,
    DropdownDirective,
    LoginComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
  ],
  providers: [
    ProductService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: HttpInterceptorService,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
