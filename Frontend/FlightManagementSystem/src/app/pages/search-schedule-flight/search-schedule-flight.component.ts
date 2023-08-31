import { Component } from '@angular/core';

@Component({
  selector: 'app-search-schedule-flight',
  templateUrl: './search-schedule-flight.component.html',
  styleUrls: ['./search-schedule-flight.component.css']
})
export class SearchScheduleFlightComponent {
  flightId: string = '';
  scheduleFlightDetails: any = null;

  searchScheduleFlight() {
    // Perform the search logic and update scheduleFlightDetails
    // For now, we'll simulate a response
    this.scheduleFlightDetails = {
      flightId: this.flightId,
      source: 'New York',
      destination: 'Los Angeles',
      arrival: '2023-08-25T10:00',
      departure: '2023-08-25T12:00',
      cost: 250
    };
  }
}
