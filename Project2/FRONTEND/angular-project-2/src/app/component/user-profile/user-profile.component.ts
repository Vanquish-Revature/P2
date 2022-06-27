import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { ActivatedRoute, Router,ParamMap } from '@angular/router';
import { observable, Observable } from 'rxjs';
import { catchError} from 'rxjs';
import { of } from 'rxjs';
import { User } from 'src/app/models/user';
import { Location } from '@angular/common';
import {UserServiceService} from 'src/app/service/user-service/user-service.service';
import { LocalStorageService } from 'src/app/service/localStorage/local-storage.service';



const httpOptions= {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    'Access-Control-Allow-Headers': 'Content-type:application/json',
    'Access-Control-Allow-Methods': 'GET',
    'Access-Control-Allow-Origin': '*'
  })
};
@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {
  user_ID!: String;
  username!: String;
  password!: String;
  firstname!: String;
  lastname!: String;
  userget = { user_ID : String, username : String, password : String , firstname : String, lastname : String};
  response : any ;
  test : any;
  msgError ="";
  Credentials = {withCredentials: true};
  profile: any;
  collection : User[] = [];
  found: boolean = false;

  public usrID = window.localStorage.getItem("username");
  // public usrsID = window.localStorage.getItem('user_id');
  // s_username: any;

  constructor(private _http : HttpClient, private apis: UserServiceService, private activatedRoute : ActivatedRoute, private router: Router
    , private location: Location) { 

  }
  ngOnInit(): void {
    // this.getUsers();
    this.username = this.activatedRoute.snapshot.params['username']
    console.log(this.usrID);
    this.getUser();
    

  }

  getUsers()
  {
    this.apis.getUsers()
    .subscribe(
      response =>
      {
        console.log(response);
        this.collection = response;
      }
    )
  }

  getUser(){  
    
    this.apis.getUser(this.usrID)
    .subscribe
      (data  =>
      {
        console.log(data)
        this.profile = data;
      }
    );
   }
   update()
   {
     
      let userget = 
      {
        user_ID : this.user_ID,
        username : this.username,
        password : this.password,
        firstname : this.firstname,
        lastName : this.lastname
      };
      console.log(this.user_ID);
      console.log(this.username);
      console.log(this.password);
      console.log(this.firstname);
      console.log(this.lastname);
      console.log(this.userget);

      let Credentials = {withCredentials: true};
      let response = this._http.put<any>("http://localhost:3000/rainforest/user/updateUser",userget,httpOptions).subscribe(
        {
          next: (v) => this.router.navigate(['/login']),  
          error: (e) => console.error(this.msgError="User name or email  is alredy registred"),
          complete: () => console.info('Complete')
        }
      );
        console.log(response);
   }
}
