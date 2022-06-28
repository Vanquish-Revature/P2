import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ApiService } from '../api/api.service';

@Injectable({
  providedIn: 'root'
})
export class CheckoutService {

  private purchaseUrl = 'http://localhost:7100/rainforest/order/checkout'; 


  constructor(private httpClient: HttpClient, private api: ApiService) { }

  // onSubmit(order: {
  //   quantity: number, 
  //   total: number
  // })
  // {
  //   this.httpClient.post<any>(this.purchaseUrl, order);
  // }
}
