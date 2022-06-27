import { Component, OnInit } from '@angular/core';
import { Plant } from 'src/app/plant';
import { PlantService } from 'src/app/service/plant-service/plant.service'
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { ApiService } from 'src/app/service/api/api.service';
import { CartService } from 'src/app/service/cart/cart.service';

@Component({
  selector: 'app-plant-detail',
  templateUrl: './plant-detail.component.html',
  styleUrls: ['./plant-detail.component.css']
})
export class PlantDetailComponent implements OnInit {

  plant: any;
  // plants: Plant[] = [];
  public plantList: any;
  id!: any;
  data: any;
  public totalItem: any;
 
  constructor(
    private route: ActivatedRoute,
    private location: Location,
    private api: ApiService,
    private cartService: CartService

  ) { }

  ngOnInit(): void {
    this.id=this.route.snapshot.params['id']
    this.api.getPlantDetail(this.id)
    .subscribe((res: any)=>{
          this.plant=res;
          this.plant.forEach((a:any) => {
            Object.assign(a,{quantity:1,total:a.price});
          });
          console.log(this.plant);
        });
  

    this.cartService.getProducts()
    .subscribe(res=>{
      this.totalItem = res.length;
    })
  }


    
  goBack(): void {
    this.location.back();
  }

  addtocart(plant: any){
    this.cartService.addtoCart(plant);

  }


}




