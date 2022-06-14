import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PlantComponent } from './component/plant/plant.component';
import { PlantDetailComponent } from './component/plant-detail/plant-detail.component';
import { DashboardComponent } from './component/dashboard/dashboard.component';

const routes: Routes = [
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'detail/:id', component: PlantDetailComponent },
  { path: "plants", component: PlantComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
