import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PlantComponent } from './component/plant/plant.component';
import { PlantDetailComponent } from './component/plant-detail/plant-detail.component';
import { DashboardComponent } from './component/dashboard/dashboard.component';
import { CartComponent } from './component/cart/cart.component';
import { UserProfileComponent } from './component/user-profile/user-profile.component';
import { LoginComponent} from './component/login/login.component'
import {RegisterComponent} from './component/register/register.component'
import { CheckoutComponent } from './component/checkout/checkout.component';


const routes: Routes = [
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'detail/:id', component: PlantDetailComponent },
  { path: "plants", component: PlantComponent },
  { path: "cart", component: CartComponent},
  {path: "userProfile", component: UserProfileComponent}, //will need to include/:id when connected to database
  {path: "login", component: LoginComponent},
  {path: "register", component: RegisterComponent},
  {path: "checkout", component: CheckoutComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
