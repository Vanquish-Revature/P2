import { Component, OnInit } from '@angular/core';
import { CartService } from 'src/app/service/cart/cart.service';
import {UserServiceService} from 'src/app/service/user-service/user-service.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  public totalItem : number = 0;
  public usrID = window.localStorage.getItem("username");
  profile: any;
  constructor(private cartService: CartService, private usrServ : UserServiceService) { }

  ngOnInit(): void {
    this.cartService.getProducts()
    .subscribe(res=>{
      this.totalItem = res.length;
    });
    this.getUser();
    
  }
  getUser(){  
    
    this.usrServ.getUser(this.usrID)
    .subscribe
      (data  =>
      {
        console.log(data)
        this.profile = data;
      }
    );
   }

}
