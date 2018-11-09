import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string;
  password: string;

  constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit() {
  }

  EmpSubmit() {
    const credentials = {
      username: this.username,
      password: this.password
    };

    console.log(credentials);
    this.loginService.empLogin(credentials)
      .subscribe(
        (result) => {
          console.log(result);
          // Navigate to home route
          this.router.navigateByUrl('');
        },
        (error) => console.log(error)
      );
  }

  ManSubmit() {
    const credentials = {
      username: this.username,
      password: this.password
    };
    this.loginService.manLogin(credentials)
      .subscribe(
        (result) => {
          console.log(result);
          // Navigate to home route
          this.router.navigateByUrl('');
        },
        (error) => console.log(error)
      );
  }

}
