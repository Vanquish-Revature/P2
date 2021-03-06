import { NgModule, NO_ERRORS_SCHEMA } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './component/header/header.component';
import { CartComponent } from './component/cart/cart.component';
import { PlantComponent } from './component/plant/plant.component';
import { PlantDetailComponent } from './component/plant-detail/plant-detail.component';
import { DashboardComponent } from './component/dashboard/dashboard.component';
import { MessagesComponent } from './component/messages/messages.component';
import { HttpClientModule } from '@angular/common/http';
import { UserProfileComponent } from './component/user-profile/user-profile.component';
import { LoginComponent } from './component/login/login.component';
import { RegisterComponent } from './component/register/register.component';
import {UserServiceService} from 'src/app/service/user-service/user-service.service';
import { CheckoutComponent } from './component/checkout/checkout.component';
import { ReactiveFormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    CartComponent,
    PlantComponent,
    PlantDetailComponent,
    DashboardComponent,
    MessagesComponent,
    UserProfileComponent,
    LoginComponent,
    RegisterComponent,
    CheckoutComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [UserServiceService],
  bootstrap: [AppComponent],
  schemas: 
  [
    NO_ERRORS_SCHEMA
  ]
})
export class AppModule { }
