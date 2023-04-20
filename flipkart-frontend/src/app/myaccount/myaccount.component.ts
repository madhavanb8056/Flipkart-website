import { DeclarationListEmitMode } from '@angular/compiler';
import { Component } from '@angular/core';

@Component({
  selector: 'app-myaccount',
  templateUrl: './myaccount.component.html',
  styleUrls: ['./myaccount.component.scss']
})
export class MyaccountComponent {
  name: string= "";
  email: string = "";
  mobilenumber: any = "" ;
  address: string = "";


 constructor(){

 }

 ngOnInit(){
  
  const customerString = localStorage.getItem('customer');
  if (customerString !== null) {
    const customer = JSON.parse(customerString);
    this.name = customer.userName;
    this.email = customer.email;
    this.mobilenumber = customer.mobileNumber;
    this.address = customer.address;
  }
    

  }


}
