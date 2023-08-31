import { Component } from '@angular/core';

@Component({
  selector: 'app-delete-schedule',
  templateUrl: './delete-schedule.component.html',
  styleUrls: ['./delete-schedule.component.css']
})
export class DeleteScheduleComponent {
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
}
