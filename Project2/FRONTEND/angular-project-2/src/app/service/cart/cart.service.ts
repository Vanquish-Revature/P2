import { Injectable } from '@angular/core';
import { Subject, BehaviorSubject } from 'rxjs';
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
  private totalItems: BehaviorSubject<number> = new BehaviorSubject<number>(0);
  // totalPrice: Subject<number> = new BehaviorSubject<number>(0);
  // totalQuantity: Subject<number> = new BehaviorSubject<number>(0);
 
  storage: Storage = sessionStorage;
  plant: any;
 

  constructor(private http : HttpClient) {
    
   }

  getProducts(){
    return this.plantList.asObservable();
  }

  setProduct(plant : any){
    this.cartItemList.push(...plant);
    this.plantList.next(plant);
  }

  updateCartItems(plants: number) {
    this.totalItems.next(plants);
  }

  getCartItems(){
    return this.totalItems.asObservable();
  }

  addtoCart(plant : any) {
    // let alreadyExistsInCart: boolean = false;
    // let existingCartItem: any = undefined;
    this.cartItemList.push(plant);
    this.plantList.next(this.cartItemList);
    this.getTotalPrice();
    console.log(this.cartItemList)
    
    // if (this.cartItemList.length > 0) {

    //   existingCartItem = this.cartItemList.find((tempCartItem: { id: any; }) => tempCartItem.id === plant.product_ID);


    //   // check if we found it
    //   alreadyExistsInCart = (existingCartItem != undefined);
    // // this.getTotalPrice();
    // // console.log(this.cartItemList);

    // if (alreadyExistsInCart) {
    //   // increment the quantity
    //   existingCartItem.quantity++;
    // } else {
    //   // just add the item to the array
    //   this.cartItemList.push(plant);
    // }
    // this.computeCartTotals();
  
}

  // computeCartTotals(){

  //   let totalPriceValue: number = 0;
  //   let totalQuantityValue: number = 0;

  //   for (let plant of this.cartItemList) {
  //     totalPriceValue += (plant.quantity * plant.price);
  //     totalQuantityValue += (plant.quantity);
  //   }

  //   // publish the new values ... all subscribers will receive the new data
  //   this.totalPrice.next(totalPriceValue);
  //   this.totalQuantity.next(totalQuantityValue);

    // Every time we manipulate this.cartItems variable 
    // we should update the sessionStorage variable value to reflect this.
  //   this.persistCartItems();
  // }


  getTotalPrice(){
    let grandTotal = 0;
    this.cartItemList.map((a:any)=>{
      grandTotal+=a.total * a.quantity;
    })
    return grandTotal;
  }

 
  removeCartItem(index: number) {
    // this.cartItemList.map((a:any, index:any)=>{
    //   if(product.id === a.id) {
        this.cartItemList.splice(index,1);
      
    
    this.plantList.next(this.cartItemList);
  }

  removeAllCart(){
    this.cartItemList = []
    this.plantList.next(this.cartItemList);
  }


  clearCart() {
    this.cartItemList = [];
    return this.cartItemList;
  }

  persistCartItems() {
    sessionStorage.setItem('cartItems', JSON.stringify(this.cartItemList));
  }
}
