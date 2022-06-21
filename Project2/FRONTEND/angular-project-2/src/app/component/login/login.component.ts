import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { catchError } from 'rxjs';
import { Observable } from 'rxjs';
import { HttpHeaders } from '@angular/common/http';
import { of } from 'rxjs';
import { Router } from '@angular/router';
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type' : 'application/json',
    'Access-Control-Allow-Headers' : 'Content-type: application/json',
    'Access-Control-Allow-Methods' : 'POST',
    'Access-Control-Allow-Origin' : '*'
  })
};

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username!: string;
  password!: String;
  result!: boolean;
  user = {username : String, password:String};
  Credentials = {withCredentials: true};
  response : any;
  msgError = "";
  constructor(private _http : HttpClient, private router : Router) { }

  ngOnInit(): void {
  }

  Loginuser()
  {
    let user = {username: this.username,
                password : this.password};
    let Credentials = {withCredentials:true};
    console.log(this.username);
    console.log(this.password);            
    console.log(user);
    console.log(Credentials);

    let response = this._http.post<any>("http://localhost:3000/rainforest/user/login",user,httpOptions).subscribe(
      {
        next : (v) => this.router.navigate(['/plants']),
        error : (e) => console.error(this.msgError = "Invalid Credentials, Please Enter a valid user name or password"),
        complete: () => window.localStorage.setItem("username", this.username)
      }
      );
  }
}
