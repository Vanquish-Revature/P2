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

  plant: Plant | undefined;
  product_id: any;

 
  constructor(
    private route: ActivatedRoute,
    private plantService: PlantService,
    private location: Location,
    private api: ApiService

  ) { }

  ngOnInit(): void {
    this.api.getPlantDetail(this.product_id)
    .subscribe((res:any)=>{
      this.plant;
    })
  }



  goBack(): void {
    this.location.back();
  }

}



