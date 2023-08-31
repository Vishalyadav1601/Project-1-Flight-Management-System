import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../model/users.component';
import { Observable, catchError, retry, throwError } from 'rxjs';
import { ResponseError } from '../dto/response-error';

const httpOptions = {
  headers: new HttpHeaders(
    {
      'Content-Type' : 'application/json'
    }
   )
 }

@Injectable({
  providedIn: 'root'
})
export class UserService {

  baseUrl = "http://localhost:8080/api/auth";

 registrationUrl = "/register"

 constructor(

  private http: HttpClient

 ) { }

 register(requestReg: User): Observable<String> {

  return this.http.post<String>(

   this.baseUrl+this.registrationUrl,

   requestReg,

   httpOptions

   ).pipe(

     retry(1),

     catchError(this.handleError)

   )

 }

 handleError(error:ResponseError) {

  let errorMessage = `Error Code: ${error.status} - ${error.error} \nMessage: ${error.message}`;

  window.alert(errorMessage);

  return throwError(errorMessage);

 }
}


