import { Component, OnInit } from '@angular/core';
import { CartService } from 'src/app/service/cart/cart.service';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {
  public plants : any = [];
  public grandTotal !: number;

  constructor(private cartService: CartService) { }

  ngOnInit(): void {
    this.cartService.getProducts()
    .subscribe(res=>{
      this.plants = res;
      this.grandTotal = this.cartService.getTotalPrice();
    })
  }

}
