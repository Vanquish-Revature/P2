import { Component, OnInit } from '@angular/core';
import { Plant } from 'src/app/plant';
import { PlantService } from 'src/app/service/plant-service/plant.service'
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'app-plant-detail',
  templateUrl: './plant-detail.component.html',
  styleUrls: ['./plant-detail.component.css']
})
export class PlantDetailComponent implements OnInit {

  plant: Plant | undefined;

  constructor(
    private route: ActivatedRoute,
    private plantService: PlantService,
    private location: Location
  ) { }

  ngOnInit(): void {
    this.getPlant();
  }

  getPlant(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.plantService.getPlant(id)
      .subscribe(plant => this.plant = plant);
  }

  // getImage() : string
  // {
  //   const id = Number(this.route.snapshot.paramMap.get('id'));
  //   return this.plantService
  // }

  goBack(): void {
    this.location.back();
  }

}
