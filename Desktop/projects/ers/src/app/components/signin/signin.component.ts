import { Component, OnInit } from '@angular/core';
import { CommunicationsService } from '../../services/communications.service';
// import { routerLink } from '@angular/router';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {

  inputValue: string;

  constructor(private communicationsService: CommunicationsService ) { }

  ngOnInit() {
  }

  submit() {
    if (!this.inputValue) {
      return;
    }
  this.communicationsService.submitNewValue(this.inputValue);
  this.inputValue = '';
  }

  ESubmit() {
    // routerLink='/employee';
  }

}
