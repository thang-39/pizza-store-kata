import { EventEmitter, Injectable } from '@angular/core';
import { environment } from '../../environments/environment.development';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { map } from 'rxjs';
// import { JwtHelperService } from '@auth0/angular-jwt';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiServerUrl = environment.apiBaseUrl;
  USERNAME_JWT_SESSION_PIZZA_STORE = 'pizzastorejwt'
  public username: string;
  public password: string;
  public jwtToken: string;
  public roles: string[];
  loginStatusChange: EventEmitter<boolean> = new EventEmitter<boolean>();
  rolesChange: EventEmitter<string[]> = new EventEmitter<string[]>();

  constructor(private http: HttpClient, ) {}

  authenticationService(username: string, password: string) {
    return this.http.get(`${this.apiServerUrl}/login`, {
      headers: {
        authorization: this.createBasicAuthToken(username, password)
      },
      observe: 'response'
    }).pipe(map((res: HttpResponse<any>) => {
      this.username = username;
      // this.password = password;
      this.jwtToken = res.headers.get('Authorization')?.split(' ')[1];
      console.log('in authService: ', this.jwtToken);
      this.roles = this.extractRolesFromToken(this.jwtToken);
      
      console.log('in authService: ', this.roles);
      this.registerSuccessfulLogin();
    }))
  }

  createBasicAuthToken(username: string, password: string) {
    return 'Basic ' + window.btoa(username + ":" + password)
  }


  registerSuccessfulLogin() {
    sessionStorage.setItem(this.USERNAME_JWT_SESSION_PIZZA_STORE, this.username + ' ' + this.jwtToken)
  }

  logout() {
    sessionStorage.removeItem(this.USERNAME_JWT_SESSION_PIZZA_STORE);
    this.username = null;
    this.roles = null;
    this.jwtToken = null;
    this.roles = null;
    // this.password = null;
  }

  getAuthToken(): string {
    let localStorageToken = sessionStorage.getItem(this.USERNAME_JWT_SESSION_PIZZA_STORE);
    if (localStorageToken) {
      let jwtTokenInLocalStorage = sessionStorage.getItem(this.USERNAME_JWT_SESSION_PIZZA_STORE).split(' ')[1];
      this.jwtToken = jwtTokenInLocalStorage;
    }
    return this.jwtToken;
  }

  extractRolesFromToken(token: string): string[] {
    if (token) {
      const decodedToken: any = JSON.parse(atob(token.split('.')[1]));
      console.log(decodedToken);
      console.log(decodedToken.roles);
      return decodedToken.roles || [];
    }
    return [];
  }

  extractRolesFromLocalStorage(token: string): string[] {
    let localStorageToken = sessionStorage.getItem(this.USERNAME_JWT_SESSION_PIZZA_STORE);
    if (localStorageToken) {
      const decodedToken: any = JSON.parse(atob(token.split(' ')[1].split('.')[1]));
      console.log(decodedToken);
      console.log(decodedToken.roles);
      return decodedToken.roles || [];
    }
    return [];
  }

  isUserLoggedIn() {
    let localStorageToken = sessionStorage.getItem(this.USERNAME_JWT_SESSION_PIZZA_STORE);
    if (localStorageToken) {
      this.jwtToken = localStorageToken.split(' ')[1];
      this.roles = this.extractRolesFromLocalStorage(localStorageToken);
      return true
    }
    return false;
  }

  getLoggedInUserName() {
    let user = sessionStorage.getItem(this.USERNAME_JWT_SESSION_PIZZA_STORE).split(' ')[0];
    if (user === null) return '';
    console.log('username: ' + user);
    return user
  }
}
