import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';


@Injectable()
export class HttpInterceptorService implements HttpInterceptor {

    constructor(private authenticationService: AuthService) { }

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        const authToken = this.authenticationService.getAuthToken();
        console.log(authToken);
        
        if (authToken && !req.url.includes('basicauth')) {
          const authReq = req.clone({
            setHeaders: {
              Authorization: `Bearer ${authToken}`
            }
          });
          return next.handle(authReq);
        } else {
          return next.handle(req);
        }
      }

    // intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    //     if (this.authenticationService.isUserLoggedIn() && req.url.indexOf('basicauth') === -1) {
    //         const authReq = req.clone({
    //             headers: new HttpHeaders({
    //                 'Content-Type': 'application/json',
    //                 'Authorization': `Basic ${window.btoa(this.authenticationService.username + ":" + this.authenticationService.password)}`
    //             })
    //         });
    //         return next.handle(authReq);
    //     } else {
    //         return next.handle(req);
    //     }
    // }


}