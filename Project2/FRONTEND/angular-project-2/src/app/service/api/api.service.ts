import { Injectable } from '@angular/core';
import { map } from 'rxjs';
import { HttpClient } from '@angular/common/http';

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

getPlantDetail(id : string){
  return this.http.get("http://localhost:7100/rainforest/product/productID/{$id}/")
  .pipe(map((res:any)=>{
    return res;
  }))

}
}