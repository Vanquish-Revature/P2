import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/service/api/api.service';
import { CartService } from 'src/app/service/cart/cart.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
 
  // <div>
  // <input type="number" readonly [(ngModel)]="total"/>
  // </div>
  

  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  public plants : any = [];
  public grandTotal !: number;
  public plant: any;
  public total: any;
  
  
  constructor(private cartService : CartService, private api: ApiService) { }

  ngOnInit(): void {
    this.cartService.getProducts()
    .subscribe(res=>{
      this.plants = res;
      this.plant=res;
      this.grandTotal = this.cartService.getTotalPrice();
    })
    this.cartService.getCartItems()
    .subscribe(value => {
      this.total = value;
    })
  }

  increase(plant: any) {
    plant.quantity = plant.quantity+1;
    // console.log(plant.quantity);
    // this.cartService.updateCartItems(this.plant+1);
  }

  decrease(plant: any) {
    plant.quantity = plant.quantity-1;
    // console.log(plant.quantity);
    // this.cartService.updateCartItems(this.plant-1);
  }
  
  removeItem(index: number){
    this.cartService.removeCartItem(index);
  }

  emptycart(){
    this.cartService.removeAllCart();
  }




}
