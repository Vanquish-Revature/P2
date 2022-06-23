import { Component, OnInit } from '@angular/core';
import { Plant } from 'src/app/plant';
import { PlantService } from 'src/app/service/plant-service/plant.service'
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { ApiService } from 'src/app/service/api/api.service';

@Component({
  selector: 'app-plant-detail',
  templateUrl: './plant-detail.component.html',
  styleUrls: ['./plant-detail.component.css']
})
export class PlantDetailComponent implements OnInit {

  // plant: Plant | undefined;
  
  public plantList: any;
  id!: any;
  data: any;
 
  constructor(
    private route: ActivatedRoute,
    private location: Location,
    private api: ApiService

  ) { }

  ngOnInit(): void {
    this.id=this.route.snapshot.params['id']
    this.getPlantDetail();
  //   this.api.getPlantDetail(this.id)
  //   .subscribe((res: any)=>{
  //       this.plantList = res;
  //       this.plantList.forEach((a:any) => {
  //     Object.assign(a,{quantity:1, total:a.price});
  //   });
  //   console.log(this.plantList);
  // });
  }

  getPlantDetail(){
    this.api.getPlantDetail(this.id).subscribe(data=>
      {
        this.data=data;
        console.log(this.data);
      }
      )
  }

  goBack(): void {
    this.location.back();
  }

}



