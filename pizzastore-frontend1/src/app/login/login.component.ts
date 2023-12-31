import { Component, ElementRef, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from './auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  username: string;
  password : string;
  errorMessage = 'Invalid Credentials';
  successMessage: string;
  invalidLogin = false;
  loginSuccess = false;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private authenticationService: AuthService) {   }


  handleLogin() {
    this.authenticationService.authenticationService(this.username, this.password)
    .subscribe((result)=> {
      console.log(result);
      
      this.invalidLogin = false;
      this.loginSuccess = true;
      this.successMessage = 'Login Successful.';

      this.authenticationService.loginStatusChange.emit(true);
      this.authenticationService.rolesChange.emit(this.authenticationService.roles);
      
      this.router.navigate(['/pizza']);
    }, () => {
      this.invalidLogin = true;
      this.loginSuccess = false;
    });      
  }
}
