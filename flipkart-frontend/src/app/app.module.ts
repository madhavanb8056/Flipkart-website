import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { MyaccountComponent } from './myaccount/myaccount.component';
import { OrderDetailsComponent } from './order-details/order-details.component';
import { HelpPageComponent } from './help-page/help-page.component';
import { BuyingPageComponent } from './buying-page/buying-page.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    SignUpComponent,
    MyaccountComponent,
    OrderDetailsComponent,
    HelpPageComponent,
    BuyingPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule

  ],
  providers: [],
  bootstrap: [AppComponent,
    HomeComponent]
})
export class AppModule { }
