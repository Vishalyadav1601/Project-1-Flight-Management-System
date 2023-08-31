import { Component } from '@angular/core';

@Component({
  selector: 'app-update-flight',
  templateUrl: './update-flight.component.html',
  styleUrls: ['./update-flight.component.css']
})
export class UpdateFlightComponent {
  flightId: string = '';
  flightModel: string = '';
  carrierName: string = '';
  seatCapacity: number = 0;

  updateFlight() {
    // You can use the entered data to perform the update
    console.log('Flight updated:', {
      id: this.flightId,
      model: this.flightModel,
      carrier: this.carrierName,
      capacity: this.seatCapacity
    });
  }
}
