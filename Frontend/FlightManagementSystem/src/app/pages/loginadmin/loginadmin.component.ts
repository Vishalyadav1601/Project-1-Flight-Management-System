import { Component, OnInit } from '@angular/core';
import { LoginadminService } from 'src/app/services/loginadmin.service';

@Component({
  selector: 'app-loginadmin',
  templateUrl: './loginadmin.component.html',
  styleUrls: ['./loginadmin.component.css']
})
export class LoginadminComponent implements OnInit{
  adminCredentials={
    adminName:'',
    adminPassword:''
  }

  constructor(private loginAdminServie:LoginadminService){

  }

  ngOnInit(): void {
  }

  onSubmit(){
    if((this.adminCredentials.adminName!='' && this.adminCredentials.adminPassword!='') && (this.adminCredentials.adminName!=null && this.adminCredentials.adminPassword!=null))
    {
      console.log("Form needs submission")
      this.loginAdminServie.generateToken(this.adminCredentials).subscribe(
        (response:any)=>{
          console.log(response.jwtToken)
          this.loginAdminServie.loginAdmin(response.jwtToken);
          window.location.href="/adminDashboard"
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
