import { Component } from '@angular/core';

@Component({
  selector: 'app-update-schedule-flight',
  templateUrl: './update-schedule-flight.component.html',
  styleUrls: ['./update-schedule-flight.component.css']
})
export class UpdateScheduleFlightComponent {
  flightId: string = '';
  sourceAirport: string = '';
  destinationAirport: string = '';
  arrivalTime: string = '';
  departureTime: string = '';
  ticketCost: number = 0;

  updateSchedule() {
    // You can use the entered data to perform the update
    console.log('Flight schedule updated:', {
      id: this.flightId,
      source: this.sourceAirport,
      destination: this.destinationAirport,
      arrival: this.arrivalTime,
      departure: this.departureTime,
      cost: this.ticketCost
    });
  }
}
