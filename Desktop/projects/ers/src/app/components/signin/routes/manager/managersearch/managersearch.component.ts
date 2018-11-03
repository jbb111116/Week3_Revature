import { Component, OnInit, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs';
import { CommunicationsService } from '../../../../../services/communications.service';

@Component({
  selector: 'app-managersearch',
  templateUrl: './managersearch.component.html',
  styleUrls: ['./managersearch.component.css']
})
export class ManagerSearchComponent implements OnInit, OnDestroy {

listItemSubscription: Subscription;

  items = new Array<string>();

  constructor(private communicationsService: CommunicationsService) { }

  ngOnInit() {
    this.listItemSubscription = this.communicationsService
    .$listItems.subscribe( (value) => {
      this.items.push(value);
    });
  }

  ngOnDestroy() {
    if (this.listItemSubscription) {
      this.listItemSubscription.unsubscribe();
    }
  }

}

