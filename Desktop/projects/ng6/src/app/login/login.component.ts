import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  posts$: Object;
  constructor(private data: DataService) { }

  ngOnInit() {
    this.data.getLogin().subscribe(
      data => this.posts$ = data
    );
  }

  // loginUser(event) {
  //   event.preventDefault()
  //   const target
  // }

}

