import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CommunicationsService {

  $listItems = new Subject<string>();

  constructor() { }

  submitNewValue(value: string) {
    // this is us putting a new value into our pipe
    this.$listItems.next(value);
  }
}
