import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './pages/login/login.component';
import { SignupComponent } from './pages/signup/signup.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CustomerDashboardComponent } from './pages/customer-dashboard/customer-dashboard.component';
import { NavbarComponent } from './pages/navbar/navbar.component';
import { FooterComponent } from './pages/footer/footer.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FlightViewComponent } from './pages/flight-view/flight-view.component';
import { FlightBookingComponent } from './pages/flight-booking/flight-booking.component';
import { AdminDashboardComponent } from './pages/admin-dashboard/admin-dashboard.component';
import {MatSelectModule} from '@angular/material/select';
import { HomeComponent } from './pages/home/home.component';
import { LoginadminComponent } from './pages/loginadmin/loginadmin.component';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import {MatDatepickerModule} from '@angular/material/datepicker';
import { AddFlightComponent } from './pages/add-flight/add-flight.component';
import { DeleteFlightComponent } from './pages/delete-flight/delete-flight.component';
import { BookingComponent } from './pages/booking/booking.component';
import { SearchFlightComponent } from './pages/search-flight/search-flight.component';
import { DeleteScheduleComponent } from './pages/delete-schedule/delete-schedule.component';

import { FlightScheduleComponent } from './pages/flight-schedule/flight-schedule.component';
import { BookingConfirmedComponent } from './pages/booking-confirmed/booking-confirmed.component';
import { UpdateFlightComponent } from './pages/update-flight/update-flight.component';
import { UpdateScheduleFlightComponent } from './pages/update-schedule-flight/update-schedule-flight.component';
import { SearchScheduleFlightComponent } from './pages/search-schedule-flight/search-schedule-flight.component';
import { MatButtonModule} from "@angular/material/button";
import { MatFormFieldModule } from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import { LoginService } from './services/login.service';
import { AuthGuard } from './services/auth.guard';




@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    CustomerDashboardComponent,
    NavbarComponent,
    FooterComponent,
    FlightViewComponent,
    FlightBookingComponent,
    AdminDashboardComponent,
    HomeComponent,
    LoginadminComponent,

    AddFlightComponent,
    DeleteFlightComponent,
    BookingComponent,
    SearchFlightComponent,
    DeleteScheduleComponent,
   
    FlightScheduleComponent,
        BookingConfirmedComponent,
        UpdateFlightComponent,
        UpdateScheduleFlightComponent,
        SearchScheduleFlightComponent,
       
       
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatSelectModule,
    MatDatepickerModule,
    HttpClientModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule
  ],
  providers: [LoginService,AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
