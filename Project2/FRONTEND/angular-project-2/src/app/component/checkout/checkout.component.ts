import { HttpClient, HttpHeaders} from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Form, ReactiveFormsModule, FormBuilder } from '@angular/forms';
import { CartService } from 'src/app/service/cart/cart.service';
import { CheckoutService } from 'src/app/service/checkout/checkout.service';

const httpOptions   = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    'Access-Control-Allow-Headers': 'Content-type:application/json',
    'Access-Control-Allow-Methods': 'GET',
    'Access-Control-Allow-Origin': '*'
  })
};

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {
  public plants : any = [];
  public grandTotal !: number;
  private checkoutService!: CheckoutService;
  checkoutForm = this.formBuilder.group({
    name:"",
    address:""
  });

  constructor(private cartService: CartService, private _http: HttpClient, private formBuilder: FormBuilder, private reactive: ReactiveFormsModule) { }

  ngOnInit(): void {
    this.cartService.getProducts()
    .subscribe(res=>{
      this.plants = res;
      this.grandTotal = this.cartService.getTotalPrice();
    })
  }

  onSubmit(): void {
    this.plants = this.cartService.clearCart();
    console.warn('Your order has been submitted!', this.checkoutForm.value);
    this.checkoutForm.reset();
  }
  
}




