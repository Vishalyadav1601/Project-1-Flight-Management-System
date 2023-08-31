import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-delete-flight',
  templateUrl: './delete-flight.component.html',
  styleUrls: ['./delete-flight.component.css']
})
export class DeleteFlightComponent {
  flightId: string = '';

 message: string = '';

 flights: any[] = [ // Simulated flight data

  {

   flightId: 'FL123',

   sourceAirport: 'City A',

   destinationAirport: 'City B',

   // Other flight properties

  },

  {

   flightId: 'FL456',

   sourceAirport: 'City C',

   destinationAirport: 'City D',

   // Other flight properties

  },

  // Add more flights as needed

 ];

 constructor() {}

 ngOnInit(): void {}

 deleteFlight() {

  if (this.flightId) {

   const index = this.flights.findIndex(flight => flight.flightId === this.flightId);

   if (index !== -1) {

    this.flights.splice(index, 1);

    this.message = `Flight with ID ${this.flightId} has been deleted.`;

   } else {

    this.message = `Flight with ID ${this.flightId} not found.`;

   }

  } else {

   this.message = 'Please enter a valid Flight ID.';

  }

 }
}















