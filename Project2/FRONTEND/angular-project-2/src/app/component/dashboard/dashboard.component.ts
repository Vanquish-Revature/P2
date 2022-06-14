import { Component, OnInit } from '@angular/core';
import { Plant } from 'src/app/plant';
import { PlantService } from 'src/app/service/plant-service/plant.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  plants: Plant[] = [];

  constructor(private plantService: PlantService) { }

  ngOnInit(): void {
    this.getPlants();
  }

  getPlants(): void {
    this.plantService.getPlants()
      .subscribe(plants => this.plants = plants); //plants.slice(0, 5));
  }
}
