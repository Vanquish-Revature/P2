import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Plants } from 'src/app/mock-plants';
import { PlantService } from '../plant-service/plant.service';
import { Plant } from 'src/app/plant';
import { TitleStrategy } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  public cartItemList : any =[]
  public plantList = new BehaviorSubject<any>([]);
 

  constructor(private http : HttpClient) { }

  getProducts(){
    return this.plantList.asObservable();
  }

  setProduct(plant : any){
    this.cartItemList.push(...plant);
    this.plantList.next(plant);
  }

  addtoCart(plant : any) {
    // return this.http.get<any>("http://localhost:7100/rainforest/product/productID/"+ id +"/")
    this.cartItemList.push(plant);
    this.plantList.next(this.cartItemList);
    this.getTotalPrice();
    console.log(this.cartItemList);
  }

  getTotalPrice() : number{
    let grandTotal = 0;
    this.cartItemList.map((a:any)=>{
      grandTotal+=a.total;
    })
    return grandTotal;
  }

  // removeCartItem(product : any) {
  //   this.cartItemList.map((a:any, index:any)=>{
  //     if(plant.id== a.id) {
  //       this.cartItemList.splice(index,1);
  //     }
  //   })
  //   this.plantList.next(this.cartItemList);
  // }
}
