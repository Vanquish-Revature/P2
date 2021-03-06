import { Injectable } from '@angular/core';
import { map,Observable, of } from 'rxjs';
import {User} from 'src/app/models/user';
import { HttpClient, HttpHeaders, HttpResponse, HttpParams } from '@angular/common/http';
import { AppModule } from 'src/app/app.module';


const httpOptions   = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    'Access-Control-Allow-Headers': 'Content-type:application/json',
    'Access-Control-Allow-Methods': 'GET,POST,OPTIONS,DELETE,PUT',
    'Access-Control-Allow-Origin': '*'
  })
};

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {
  constructor(private Http: HttpClient) { }
  public url: string = "http://localhost:3000/rainforest/user";
  // public url2: string = "http://localhost:3000/rainforest/user/Username/?";
  getUsers(): Observable<User[]>
  {
    return this.Http.get<User[]>(this.url);
  }

  // getUser(id: number) : Observable<User>
  // {
  //   const user = User.find( u => u.id = id);
  // }
    getUser(username:any)
    {
      return this.Http.get( "http://localhost:3000/rainforest/user/Username/?username=" + username)
      .pipe(map(res=>
        {
          return res;
        }));
   
    }   
    // getUserByID(user_id: any)
    // {
    //   return this.Http.put("http://localhost:3000/rainforest/user/updateUser/" + user_id + "/")
    //   .pipe(map(
    //     res =>
    //     {
    //       return res;
    //     }
    //   ))
    // }

  
 
}
