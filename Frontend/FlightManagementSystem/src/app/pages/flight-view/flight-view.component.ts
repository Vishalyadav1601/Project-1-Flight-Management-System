import { Component } from '@angular/core';

@Component({
  selector: 'app-flight-view',
  templateUrl: './flight-view.component.html',
  styleUrls: ['./flight-view.component.css']
})
export class FlightViewComponent {
 flights = [
    { flightNumber: 'ABC123', departure: 'City A', arrival: 'City B', price: 200 },
    { flightNumber: 'DEF456', departure: 'City B', arrival: 'City C', price: 250 },
    { flightNumber: 'GHI789', departure: 'City A', arrival: 'City C', price: 220 },
    { flightNumber: 'ABC123', departure: 'City A', arrival: 'City B', price: 200 },
    { flightNumber: 'DEF456', departure: 'City B', arrival: 'City C', price: 250 },
    { flightNumber: 'GHI789', departure: 'City A', arrival: 'City C', price: 220 },
    // Add more flight data here
  ];
}

