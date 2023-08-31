import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';


@Injectable({
    providedIn: 'root'
})
export class LoginService{
    baseUrl = "http://localhost:8080/api/auth";
    
    constructor(private http: HttpClient) {
        
     }

    generateToken(credentials:any){
        //token generate
        return this.http.post(`${this.baseUrl}/login`,credentials)
     }

    loginUser(token:string)
    {
        localStorage.setItem("token",token)
        return true;
    }

    isLoggedIn()
    {
        let token=localStorage.getItem("token")
        if(token==undefined || token=='' || token==null)
        {
            return false;
        }
        else{
            return true;
        }
    }

    logout()
    {
        localStorage.removeItem('token')
        return true;
    }

    getToken()
    {
        return localStorage.getItem("token")
    }
}
