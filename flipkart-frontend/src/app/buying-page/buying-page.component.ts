import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { FlipkartService } from '../flipkart.service';
import { GlobalService } from '../service/global.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-buying-page',
  templateUrl: './buying-page.component.html',
  styleUrls: ['./buying-page.component.scss']
})
export class BuyingPageComponent implements OnInit {
  id!: number;
  product: any = [];
  isDisplayed: boolean = false;
  paymentMode: String = "Cash on delivery";
  modeOfPaymentList = ['Cash on delivery', 'Net Banking', 'Credit Card', 'Debit Card', 'EMI'];
  paymentStatus: String = "";
  customer: any;


  constructor(private route: ActivatedRoute,
    private flipkartService: FlipkartService,
    private globalService: GlobalService,
    private httpclient: HttpClient,
    private router: Router){}

  ngOnInit(){
  this.id = Number(this.route.snapshot.paramMap.get('id'));
  console.log(this.id);
this.isDisplayed = false;
    const id = String(this.id);
    this.flipkartService.get("http://localhost:8080/api/product/id".replace("id", id)).subscribe(
      response => {
      console.log(response);
      this.product = response;
      this.globalService.sendData(this.product);
      this.isDisplayed = true;
    });

    this.globalService.getData().subscribe(data => {
      this.product = data;
    });
  }

  buy(){

    let customerString = localStorage.getItem('customer');
    let customer;
    if(customerString !== null){
     customer = JSON.parse(customerString);
    }else{
    alert("Please Login");
    this.router.navigate(['/login']);
  }
  
    
    if(this.paymentMode == "Cash on delivery"){
       this.paymentStatus = "Not Paid";
    }else{
      this.paymentStatus = "Paid"
    }
  

    var order ={
     productId : this.product.id,
     customerId : customer.id,
     paymentMode: this.paymentMode,
     paymentStatus: this.paymentStatus
    }
    
    console.log(this.paymentMode)
    this.httpclient.post("http://localhost:8080/api/order/create", order,{responseType: 'text'}).subscribe ((resultData: any)=>{
      console.log(resultData);
      alert("Product Ordered Successfully");
      this.router.navigate(['/home']);
   });
  }
}
