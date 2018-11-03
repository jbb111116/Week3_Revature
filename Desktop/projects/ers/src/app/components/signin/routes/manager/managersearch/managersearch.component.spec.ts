import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagersearchComponent } from './managersearch.component';

describe('ManagersearchComponent', () => {
  let component: ManagersearchComponent;
  let fixture: ComponentFixture<ManagersearchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagersearchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagersearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
