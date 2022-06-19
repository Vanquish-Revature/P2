import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PlantComponent } from './component/plant/plant.component';
import { PlantDetailComponent } from './component/plant-detail/plant-detail.component';
import { DashboardComponent } from './component/dashboard/dashboard.component';
<<<<<<< HEAD

const routes: Routes = [
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
//  { path: 'dashboard', component: DashboardComponent },
  { path: 'detail/:id', component: PlantDetailComponent },
 // { path: "plants", component: PlantComponent }
=======
import { CartComponent } from './component/cart/cart.component';
import { UserProfileComponent } from './component/user-profile/user-profile.component';
import { LoginComponent} from './component/login/login.component'
import {RegisterComponent} from './component/register/register.component'


const routes: Routes = [
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'detail/:id', component: PlantDetailComponent },
  { path: "plants", component: PlantComponent },
  { path: "cart", component: CartComponent},
  {path: "userProfile", component: UserProfileComponent}, //will need to include/:id when connected to database
  {path: "login", component: LoginComponent},
  {path: "register", component: RegisterComponent}
>>>>>>> 4affc403d369af37428f90018c824dabfa5078ea
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
