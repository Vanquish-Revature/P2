import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Plant } from 'src/app/plant';
import { Plants } from 'src/app/mock-plants';
import { MessageService } from '../message/message.service';

@Injectable({
  providedIn: 'root'
})
export class PlantService {

  constructor(private messageService: MessageService) { }

  getPlants(): Observable<Plant[]> {
    const plants = of(Plants);
    this.messageService.add('PlantService: fetched plants');
    return plants;
  }

  getPlant(id: number): Observable<Plant> {
    const plant = Plants.find(p => p.id === id)!;
    this.messageService.add(`PlantService: fetched plant id=${id}`);
    return of(plant);
}
}
