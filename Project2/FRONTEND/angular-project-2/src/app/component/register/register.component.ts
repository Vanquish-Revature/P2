import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { catchError} from 'rxjs';
import { of } from 'rxjs';
import { Form, ReactiveFormsModule } from '@angular/forms';

const httpOptions   = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    'Access-Control-Allow-Headers': 'Content-type:application/json',
    'Access-Control-Allow-Methods': 'POST',
    'Access-Control-Allow-Origin': '*'
  })
};

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  username!: String;
  password!: String;
  firstName!: String;
  lastName!: String;
  user = {username : String , password : String , firstname : String, lastName : String};
  Credentials = {withCredentials: true};
  response : any;
  msgError = "";

  constructor(private _http: HttpClient , private router : Router) { }

  ngOnInit(): void {
  }

  registerusr()
  {
    let user = {username: this.username,
                password: this.password,
                firstname: this.firstName,
                lastName: this.lastName};
    console.log(this.username);
    console.log(this.password);
    console.log(this.firstName);
    console.log(this.lastName);
    console.log(user);
    let Credentials = {withCredentials: true};
    let response =this._http.post<any>("http://localhost:7100/rainforest/user/register",user ,httpOptions,).subscribe (
        {
          next: (v) => this.router.navigate(['/login']),  
          error: (e) => console.error(this.msgError="User name or email  is alredy registred"),
          complete: () => console.info('Complete')
        });
  }
}
