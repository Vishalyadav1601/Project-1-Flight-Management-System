import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Flight } from '../flight.model';

@Component({
  selector: 'app-add-flight',
  templateUrl: './add-flight.component.html',
  styleUrls: ['./add-flight.component.css']
})

export class AddFlightComponent implements OnInit {

  flightForm: FormGroup;
 constructor(private formBuilder: FormBuilder) {

  this.flightForm = this.formBuilder.group({

   flightId: ['', Validators.required],

   sourceAirport: ['', Validators.required],

   destinationAirport: ['', Validators.required],

   arrivalTime: ['', Validators.required],

   departureTime: ['', Validators.required],

   ticketCost: ['', [Validators.required, Validators.min(0)]]

  });

 }

 ngOnInit(): void {}

 onSubmit() {

  if (this.flightForm.valid) {

   const newFlight: Flight = this.flightForm.value;

   console.log('New Flight:', newFlight);

   // Here, you can add further logic to save the flight data (e.g., to a service or API)

  }

 }

}









