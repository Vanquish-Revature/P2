import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { HttpClient, HttpResponse } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  

constructor(private http : HttpClient) { }

getPlants(){
  return this.http.get<any>("http://localhost:7100/rainforest/product")
  .pipe(map((res:any)=>{
    return res;
  }))
}

getPlantDetail(id:any){
  return this.http.get("http://localhost:7100/rainforest/product/productID/"+id)
  .pipe(map(res=>
  {
    return res;
  }
  ))
  
}


}