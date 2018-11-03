import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerresultComponent } from './managerresult.component';

describe('ManagerresultComponent', () => {
  let component: ManagerresultComponent;
  let fixture: ComponentFixture<ManagerresultComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagerresultComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerresultComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
