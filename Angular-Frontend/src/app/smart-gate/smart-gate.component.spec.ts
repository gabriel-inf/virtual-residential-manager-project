import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SmartGateComponent } from './smart-gate.component';

describe('SmartGateComponent', () => {
  let component: SmartGateComponent;
  let fixture: ComponentFixture<SmartGateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SmartGateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SmartGateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
