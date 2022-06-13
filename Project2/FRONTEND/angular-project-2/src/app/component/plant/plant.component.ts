import { Component, OnInit } from '@angular/core';
import { Plant } from 'src/app/plant';
import { PlantService} from 'src/app/service/plant-service/plant.service';
import { MessageService } from 'src/app/service/message/message.service';

@Component({
  selector: 'app-plant',
  templateUrl: './plant.component.html',
  styleUrls: ['./plant.component.css']
})
export class PlantComponent implements OnInit {
  plants: Plant[] = [];

  constructor(private plantService: PlantService) { }

  ngOnInit(): void {
    this.getPlants();
  }

  getPlants(): void {
    this.plantService.getPlants()
    .subscribe(plants => this.plants = plants);
  }

}
