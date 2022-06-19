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
<<<<<<< HEAD
    this.messageService.add(`HeroService: fetched hero id=${id}`);
=======
    this.messageService.add(`PlantService: fetched plant id=${id}`);
>>>>>>> 4affc403d369af37428f90018c824dabfa5078ea
    return of(plant);
}
}
