import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { ActivatedRoute, Router,ParamMap } from '@angular/router';
import { observable, Observable } from 'rxjs';
import { catchError} from 'rxjs';
import { of } from 'rxjs';
import { User } from 'src/app/models/user';
import { Location } from '@angular/common';
import {UserServiceService} from 'src/app/service/user-service/user-service.service';



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
  // usrID!: Number;
  username!: String;
  // password!: String;
  // firstName!: String;
  // lastname!: String;
  userget = {username : String, password : String , firstName : String, lastname : String};
  response : any ;
  test : any;
  msgError ="";
  Credentials = {withCredentials: true};
  profile: any;
  // collection : User[] = [];
  found: boolean = false;

  usrID = localStorage.getItem('username');

  // s_username: any;

  constructor(private _http : HttpClient, private api: UserServiceService, private activatedRoute : ActivatedRoute, private router: Router, private location: Location) { 

  }
  // getUserByUserId(user_id : any):Observable<HttpResponse<User>>{
  //   return this._http.get("http://localhost:3000/user/userID/" +user_id+"/", {observe: "response"}) as Observable<HttpResponse<User>>
  //   }
  ngOnInit(): void {
    // this.getUsers();
    this.username = this.activatedRoute.snapshot.params['username']
    this.getUser();

  }

  // getUsers()
  // {
  //   this.api.getUsers()
  //   .subscribe(
  //     response =>
  //     {
  //       console.log(response);
  //       this.collection = response;
  //     }
  //   )
  // }
  onNameKeyUp(event:any)
  {
    this.username = event.target.value;
    this.found = false;
  }

  // getUser()
  // {
  //   // let usrget = {username: this.username};
  //    this._http.get<any>('http://localhost:3000/rainforest/user/Username/?username='+ this.usrID,httpOptions).subscribe(
  //       (data:User[]) => 
  //       { 
  //         if(data.length)
  //         {
  //           // this.profile = data;
  //           this.username = data[0].username;
  //           this.password = data[0].password;
  //           this.firstName = data[0].firstname;
  //           this.lastname = data[0].lastName;
  //           // console.log(response);
  //           console.log(data[2].firstname);
  //           this.found = true;
  //         }
  //       }
  //   );
  //     }  
  //   );
  getUser(){  
    this.api.getUser(this.usrID)
    .subscribe
      (data=>
      {
        console.log(data);
        this.profile = data;
      }
    );
   }

}
