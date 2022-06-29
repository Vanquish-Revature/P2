import { HttpClient, HttpHeaders, HttpResponse} from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Form, ReactiveFormsModule, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Product } from 'src/app/models/product';
import { User } from 'src/app/models/user';
import { ApiService } from 'src/app/service/api/api.service';
import { CartService } from 'src/app/service/cart/cart.service';
import { CheckoutService } from 'src/app/service/checkout/checkout.service';
import { UserServiceService } from 'src/app/service/user-service/user-service.service';

const httpOptions   = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    'Access-Control-Allow-Headers': 'Content-type:application/json',
    'Access-Control-Allow-Methods': 'POST,GET', 
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
  id : any;
  username !: any;
  quantity!: any;
  total!: any;
  order_id!: any;
  Credentials = {withCredentials: true};
  response: any;
  msgError = "";
  user = User;
  product = Product;
  public usrID = window.localStorage.getItem('user_id');
  public productID = window.localStorage.getItem('product_ID');

  constructor(
    private cartService: CartService, 
    private _http: HttpClient, 
    private router: Router, 
    private api: ApiService, 
    private userService: UserServiceService) { }

    getUserByUserId(usrID: any){
      return this._http.get<any>(`http://localhost:7100/rainforest/user/userID/?usrID${usrID}`, {observe : "response"}) as Observable<HttpResponse<User>>
    }

    getProductByProductId(productID: any){
      return this._http.get<any>(`http://localhost:7100/rainforest/product/productID/?productID${productID}`, {observe : "response"}) as Observable<HttpResponse<Product>>
    }

  ngOnInit(): void {
    this.cartService.getProducts()
    .subscribe(res=>{
      this.plants = res;
      this.grandTotal = this.cartService.getTotalPrice();
    })
    console.log(this.plants);
      // console.log("session user..."+window.localStorage.getItem('usr_id'))
      // let uid = window.localStorage.getItem('usr_id');
      this.getUserByUserId(this.usrID)
      .subscribe((data:any)=>
      {
        this.user=data;
        console.log(this.user);
        this.user=data.body;
      })
      // console.log("session product ..." +window.localStorage.getItem('product_ID'))
      // let pid = window.localStorage.getItem('product_ID');
      this.getProductByProductId(this.productID).subscribe((plants:any)=>
      {
        this.product=plants;
        console.log(this.product);
      })
  
  }

  onSubmit()
  {
    let order = {
      user: User ,
      product: Product,
      order_id: this.order_id,
      quantity: this.quantity,
      total: this.total
    };
    console.log(this.user);
    console.log(this.product);
    console.log(this.quantity);
    console.log(this.total);
    let Credentials = {withCredentials: true};
    let response = this._http.post<any>("http://localhost:7100/rainforest/order/checkout", order, httpOptions).subscribe(
      {
        next: (v) => this.router.navigate(['/dashboard']),
        error: (e) => console.error(this.msgError="Order not submitted"),
        complete: () => console.info('Complete')
      }
    )
    this.plants = this.cartService.clearCart();
    };
    
    
    
    
  }
  





