import { Component } from '@angular/core';

interface Passenger {
  name: string;
  flightId: string;
  date: string;
  age: number;
  gender: string;
  mobile: string;
}

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent {
  passengers: Passenger[] = [];

  constructor() { }

  addPassenger() {
    this.passengers.push({
      name: '',
      flightId: '',
      date: '',
      age: 0,
      gender: '',
      mobile: ''
    });
  }

  removePassenger(index: number) {
    this.passengers.splice(index, 1);
  }

  confirmBooking() {
    const validPassengers = this.passengers.filter(
      passenger =>
        passenger.name.trim() !== '' &&
        passenger.flightId.trim() !== '' &&
        passenger.date.trim() !== '' &&
        passenger.age > 0 &&
        passenger.gender.trim() !== '' &&
        passenger.mobile.trim() !== ''
    );

    if (validPassengers.length === this.passengers.length) {
      // Implement booking confirmation logic here
      alert('Booking confirmed for all passengers.');
    } else {
      alert('Please fill in all details for each passenger.');
    }
  }
}
