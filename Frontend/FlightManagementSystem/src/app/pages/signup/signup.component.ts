import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/model/users.component';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-create-user',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  @Input() user:User;
  submitted=false;

  constructor(private regService: UserService, private router: Router) { 
    this.user = new User();
  }

  ngOnInit(): void {
  }

    newUser(): void{
      this.submitted=false;
      this.user=new User();
    }

    // save(){
    //   this.userService.createUser(this.user).subscribe(data => console.log(data), error => console.log(error));
    //   this.user = new User();
    //   this.gotoList();
    // }

    onSubmit(){
      console.log(this.user)
      this.regService.register(this.user).subscribe
      ((data: any) => {
        console.log("Response Data" + JSON.stringify(data));
      }), (error: string) => {
        console.log("An Error Ocurred " + error);
      };
    }

    gotoList(){
      this.router.navigate(['/addUser']);
    }

}
