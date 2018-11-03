import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ReimbursementsService {

  constructor(private httpClient: HttpClient) {

   }

   queryReimbursements(name) {
      const url = `http://www.omdbapi.com/?t=${name}&apikey=7f7fece3`;
      return this.httpClient.get(url);

   }

}
