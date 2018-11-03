import { Component, OnInit, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs';
import { CommunicationsService } from '../../../../../services/communications.service';
import { ReimbursementsService } from '../../../../../services/reimbursements.service';

@Component({
  selector: 'app-managerresult',
  templateUrl: './managerresult.component.html',
  styleUrls: ['./managerresult.component.css']
})
export class ManagerResultComponent implements OnInit, OnDestroy {
reimbursments;
  listItemSubscription: Subscription;

  constructor(private communicationService: CommunicationsService,
    private reimbursmentsService: ReimbursementsService) { }

  ngOnInit() {
    this.listItemSubscription = this.communicationService
    .$listItems.subscribe( (item) => {
        this.reimbursmentsService.queryReimbursements(item).subscribe( (payload) => {
          console.log(payload);
          this.reimbursments = payload;
        });
    });
  }

  ngOnDestroy() {
    if (this.listItemSubscription) {
      this.listItemSubscription.unsubscribe();
    }
  }

}



