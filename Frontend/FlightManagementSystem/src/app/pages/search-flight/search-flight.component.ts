import { Component } from '@angular/core';

@Component({
  selector: 'app-search-flight',
  templateUrl: './search-flight.component.html',
  styleUrls: ['./search-flight.component.css']
})
export class SearchFlightComponent {
  flightNumber: string = '';
  flightDetails: any = null;

  searchFlight() {
    // Replace this array with actual flight data
    const flights = [
      { flightNumber: 'F123', origin: 'New York', destination: 'Los Angeles' },
      { flightNumber: 'F456', origin: 'Chicago', destination: 'Miami' },
      // Add more flights
    ];

    this.flightDetails = flights.find(flight => flight.flightNumber === this.flightNumber);
  }
}
