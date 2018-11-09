import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';


@Injectable({
  providedIn: 'root'
})
export class LoginService {

  manLogin(credentials: any) {
    const url = `${environment.server}/manager/`;
    return this.httpClient.post(url, credentials, {
      observe: 'response'
    });
  }
  empLogin(credentials: any) {
    const url = `${environment.server}/employee/`;
    return this.httpClient.post(url, credentials, {
      observe: 'response'
    });
  }


  constructor(private httpClient: HttpClient) { }
}
