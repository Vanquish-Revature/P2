import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import { Plant } from 'src/app/plant';
import { Plants } from 'src/app/mock-plants';
import { MessageService } from '../message/message.service';

@Injectable({
  providedIn: 'root'
})
export class PlantService {

 

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient, private messageService: MessageService) { }

  getPlants(): Observable<Plant[]> {
    const plants = of(Plants);
    this.messageService.add('PlantService: fetched plants');
    return plants;
  }

  getPlant(id: number): Observable<Plant> {
    const plant = Plants.find(p => p.product_ID === id)!;
    this.messageService.add(`PlantService: fetched plant id=${id}`);
    return of(plant);
}
}
