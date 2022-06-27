import { Component, OnInit } from '@angular/core';
import { Plant } from 'src/app/plant';
import { PlantService} from 'src/app/service/plant-service/plant.service';
import { CartService } from 'src/app/service/cart/cart.service';
import { BehaviorSubject } from 'rxjs';
import { ApiService } from 'src/app/service/api/api.service';

@Component({
  selector: 'app-plant',
  templateUrl: './plant.component.html',
  styleUrls: ['./plant.component.css']
})
export class PlantComponent implements OnInit {
  // plants: Plant[] = [];
  public plantList : any;
  public totalItem : number = 0;
 

  constructor(private cartService : CartService, private api: ApiService, private plantService: PlantService) { }

  ngOnInit(): void {
    this.api.getPlants()
    .subscribe((res: any)=>{
        this.plantList = res;
        this.plantList.forEach((a:any) => {
      Object.assign(a,{quantity:1,total:a.price});
    });
    console.log(this.plantList);
  });

  this.cartService.getProducts()
  .subscribe(res=>{
    this.totalItem = res.length;


  })
  }


  // getPlants(): void {
  //   this.plantService.getPlants()
  //   .subscribe(plants => this.plants = plants);
  // }

  addtocart(plantList: any){
    this.cartService.addtoCart(plantList);
  }
}
