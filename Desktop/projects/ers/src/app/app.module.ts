import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { ButtonTestComponent } from './components/tests/button-test/button-test.component';
import { SigninComponent } from './components/signin/signin.component';
import { CommunicationsService } from './services/communications.service';
import { ReimbursementsService } from './services/reimbursements.service';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { EmployeeComponent } from './components/signin/routes/employee/employee.component';
import { ManagerComponent } from './components/signin/routes/manager/manager.component';
import { ManagerSearchComponent } from './components/signin/routes/manager/managersearch/managersearch.component';
import { ManagerResultComponent } from './components/signin/routes/manager/managerresult/managerresult.component';



@NgModule({
  declarations: [
    AppComponent,
    ButtonTestComponent,
    SigninComponent,
    EmployeeComponent,
    ManagerComponent,
    ManagerSearchComponent,
    ManagerResultComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    CommunicationsService,
    ReimbursementsService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
