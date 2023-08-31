import { Component } from '@angular/core';

@Component({
  selector: 'app-flight-schedule',
  templateUrl: './flight-schedule.component.html',
  styleUrls: ['./flight-schedule.component.css']
})
export class FlightScheduleComponent {
  sourceAirport: string = '';
  destinationAirport: string = '';
  arrivalTime: string = '';
  departureTime: string = '';
  ticketCost: string = '';

  scheduleFlight() {
    // You can use the entered data to perform further actions
    console.log('Flight scheduled:', {
      source: this.sourceAirport,
      destination: this.destinationAirport,
      arrival: this.arrivalTime,
      departure: this.departureTime,
      cost: this.ticketCost
    });
  }
}
