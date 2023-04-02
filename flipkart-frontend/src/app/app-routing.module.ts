import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from './home/home.component'
import {LoginComponent} from './login/login.component'
import {SignUpComponent} from './sign-up/sign-up.component'
import {MyaccountComponent} from './myaccount/myaccount.component'
import {OrderDetailsComponent} from './order-details/order-details.component'
import {BuyingPageComponent} from './buying-page/buying-page.component'
import { HelpPageComponent } from './help-page/help-page.component';

const routes: Routes = [
{
  component:HomeComponent,
  path:'home'
},
{
  component:LoginComponent,
  path:'login'
},
{
  component:SignUpComponent,
  path:'signup'
},
{
  component:MyaccountComponent,
  path:'myaccount'
},
{
  component:OrderDetailsComponent,
  path:'orders'
},
{
  component:BuyingPageComponent,
  path:'buy'
},
{
  component:HelpPageComponent,
  path:'help'
},
{ path: '', redirectTo: 'home', pathMatch: 'full' },
  
{ path: '**', redirectTo: 'home' }    



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
