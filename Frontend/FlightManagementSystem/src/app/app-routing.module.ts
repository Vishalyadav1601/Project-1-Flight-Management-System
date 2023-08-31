import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { SignupComponent } from './pages/signup/signup.component';
import { CustomerDashboardComponent } from './pages/customer-dashboard/customer-dashboard.component';
import { FlightBookingComponent } from './pages/flight-booking/flight-booking.component';
import { FlightViewComponent } from './pages/flight-view/flight-view.component';
import { AdminDashboardComponent } from './pages/admin-dashboard/admin-dashboard.component';
import { LoginadminComponent } from './pages/loginadmin/loginadmin.component';

import { AddFlightComponent } from './pages/add-flight/add-flight.component';
import { DeleteFlightComponent } from './pages/delete-flight/delete-flight.component';
import { HomeComponent } from './pages/home/home.component';
import { SearchFlightComponent } from './pages/search-flight/search-flight.component';
import { DeleteScheduleComponent } from './pages/delete-schedule/delete-schedule.component';
import { FlightScheduleComponent } from './pages/flight-schedule/flight-schedule.component';
import { BookingConfirmedComponent } from './pages/booking-confirmed/booking-confirmed.component';
import { BookingComponent } from './pages/booking/booking.component';
import { UpdateFlightComponent } from './pages/update-flight/update-flight.component';
import { UpdateScheduleFlightComponent } from './pages/update-schedule-flight/update-schedule-flight.component';
import { SearchScheduleFlightComponent } from './pages/search-schedule-flight/search-schedule-flight.component';
import { AuthGuard } from './services/auth.guard';


const routes: Routes = [
  {
    path:"",
    component: HomeComponent,
    pathMatch:"full"
  },
  {
  path:"loginadmin",
  component: LoginadminComponent,
  pathMatch:"full"
},{
  path:"loginuser",
  component: LoginComponent,
  pathMatch:"full"
},{
  path:"signup",
  component:SignupComponent,
  pathMatch:"full"
},{
  path:"custDashboard",
  component:CustomerDashboardComponent,
  pathMatch:"full",
  canActivate:[AuthGuard]
},{
  path:"custBooking",
  component:FlightBookingComponent,
  pathMatch:"full"
},{
  path:"custView",
  component:FlightViewComponent,
  pathMatch:"full"
},{
  path:"adminDashboard",
  component:AdminDashboardComponent,
  pathMatch:"full"
},{
  path:"adminAddFlight",
  component:AddFlightComponent,
  pathMatch:"full"
},{
  path:"adminDeleteFlight",
  component:DeleteFlightComponent,
  pathMatch:"full"
},
{
  path:"adminViewFlight",
  component:FlightViewComponent,
  pathMatch:"full"
},
{
  path:"adminSearchFlight",
  component:SearchFlightComponent,
  pathMatch:"full"
},
{
  path:"adminSchDeleteFlight",
  component:DeleteScheduleComponent,
  pathMatch:"full"
}
,
{
  path:"flightSchedule",
  component:FlightScheduleComponent,
  pathMatch:"full"
}
,
{
  path:"bookingConfirmed",
  component:BookingConfirmedComponent,
  pathMatch:"full"
},
{
  path:"bookingDet",
  component:BookingComponent,
  pathMatch:"full"
},
{
  path:"adminUpdFlight",
  component:UpdateFlightComponent,
  pathMatch:"full"

}
,
{
  path:"adminUpdSchFlight",
  component:UpdateScheduleFlightComponent,
  pathMatch:"full"

},
{
  path:"searchSch",
  component:SearchScheduleFlightComponent,
  pathMatch:"full"

}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
