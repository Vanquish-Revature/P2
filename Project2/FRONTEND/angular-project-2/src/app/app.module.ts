import { NgModule } from '@angular/core';
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
<<<<<<< HEAD

=======
import { UserProfileComponent } from './component/user-profile/user-profile.component';
import { LoginComponent } from './component/login/login.component';
import { RegisterComponent } from './component/register/register.component';
>>>>>>> 4affc403d369af37428f90018c824dabfa5078ea


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    CartComponent,
    PlantComponent,
    PlantDetailComponent,
    DashboardComponent,
<<<<<<< HEAD
    MessagesComponent
=======
    MessagesComponent,
    UserProfileComponent,
    LoginComponent,
    RegisterComponent
>>>>>>> 4affc403d369af37428f90018c824dabfa5078ea
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
