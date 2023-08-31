import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateScheduleFlightComponent } from './update-schedule-flight.component';

describe('UpdateScheduleFlightComponent', () => {
  let component: UpdateScheduleFlightComponent;
  let fixture: ComponentFixture<UpdateScheduleFlightComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UpdateScheduleFlightComponent]
    });
    fixture = TestBed.createComponent(UpdateScheduleFlightComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
