import { Component, OnInit } from '@angular/core';
import { CommunicationsService } from '../../../../services/communications.service';

// manager = first
// managersearch = second
// managerresult = movie

@Component({
  selector: 'app-manager',
  templateUrl: './manager.component.html',
  styleUrls: ['./manager.component.css']
})

export class ManagerComponent implements OnInit {

  inputValue: string;

  constructor(private communicationService: CommunicationsService ) { }

  ngOnInit() {
  }

  submit() {
    if (!this.inputValue) {
      return;
    }
  this.communicationService.submitNewValue(this.inputValue);
  this.inputValue = '';
  }

}


