import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { ActivatedRoute, Router,ParamMap } from '@angular/router';
import { observable, Observable } from 'rxjs';
import { catchError} from 'rxjs';
import { of } from 'rxjs';
import { User } from 'src/app/models/user';
import {UserServiceService} from 'src/app/service/user-service/user-service.service';


// const httpOptions   = {
//   headers: new HttpHeaders({
//     'Content-Type':  'application/json',
//     'Access-Control-Allow-Headers': 'Content-type:application/json',
//     'Access-Control-Allow-Methods': 'GET,POST,OPTIONS,DELETE,PUT',
//     'Access-Control-Allow-Origin': '*'
//   })
// };
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
  // uname!: String;
  userlist = {username : String , password : String , firstName : String, lastName : String};
  response : any ;
  test : any;
  msgError ="";
  Credentials = {withCredentials: true};
  profile: User[] = [];
  collection : User[] = [];

  public usrID= window.localStorage.getItem('username');

  // s_username: any;

  constructor(private _http : HttpClient, private api: UserServiceService, private activatedRoute : ActivatedRoute, private router: Router) { 

  }
  // getUserByUserId(user_id : any):Observable<HttpResponse<User>>{
  //   return this._http.get("http://localhost:3000/user/userID/" +user_id+"/", {observe: "response"}) as Observable<HttpResponse<User>>
  //   }
  ngOnInit(): void {
    this.getUsers();
    this.getUser();
  }

  getUsers()
  {
    this.api.getUsers()
    .subscribe(
      response =>
      {
        // console.log(response);
        this.collection = response;
      }
    )
  }

  getUser()
  {
    
    this.api.getUser(this.usrID)
    .subscribe(
      data =>
      {
        console.log(data);
        this.profile = data;
      }
    );
  }
  // getUser(): void
  // {
    // .subscribe(
    //   data =>
    //   {
    //     this.profile = data;
    //   }
    // )
  //   this.api.getUser(this.usrID)
  //   .subscribe(
  //     data =>
  //     {
  //       this.profile = data;
  //     }
  //   );
  // }
  

}
