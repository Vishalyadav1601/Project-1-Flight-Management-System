import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchScheduleFlightComponent } from './search-schedule-flight.component';

describe('SearchScheduleFlightComponent', () => {
  let component: SearchScheduleFlightComponent;
  let fixture: ComponentFixture<SearchScheduleFlightComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SearchScheduleFlightComponent]
    });
    fixture = TestBed.createComponent(SearchScheduleFlightComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
