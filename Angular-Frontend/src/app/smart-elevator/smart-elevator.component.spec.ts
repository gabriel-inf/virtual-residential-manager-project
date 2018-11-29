import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SmartElevatorComponent } from './smart-elevator.component';

describe('SmartElevatorComponent', () => {
  let component: SmartElevatorComponent;
  let fixture: ComponentFixture<SmartElevatorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SmartElevatorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SmartElevatorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
