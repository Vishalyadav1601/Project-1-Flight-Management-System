import { HttpResponse } from '@angular/common/http';
import { Token } from '@angular/compiler';
import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { login } from 'src/app/model/login.component';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
  credentials={
    userName:'',
    userPassword:''
  }

  constructor(private loginService:LoginService){
    
  }

  ngOnInit(): void {
  }

  onSubmit(){
    
    if((this.credentials.userName!='' && this.credentials.userPassword!='') && (this.credentials.userName!=null && this.credentials.userPassword!=null))
    {
      console.log("Form needs submission")
      this.loginService.generateToken(this.credentials).subscribe(
        (response:any)=>{
          console.log(response.jwtToken)
          this.loginService.loginUser(response.jwtToken);
          window.location.href="/custDashboard"
        },
        error=>{
          console.log(error)
        }
      )
    }
    else
    {
      console.log("username or password are empty")
    }
  }
}
