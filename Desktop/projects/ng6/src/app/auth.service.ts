import { Injectable } from '@angular/core';
import { HttpClient } from 'selenium-webdriver/http';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  loggedInStatus = false;

  constructor() { }

  // LoginEmployee(enployee) {
  //   return this.http.post<any>(this.loginEmployeeUrl, enployee);
  // }
  // LoginManager(manager) {
  //   return this.http.post<any>(this.loginManagerUrl, manager);
  // }
  loggedIn() {
    return localStorage.getItem('token');
  }

  // getUserDetails(username, password) {
  //   return this.http.post(
  //   username,
  //   password
  //   );
  // }
}
