import { Component, OnInit } from '@angular/core';
import { FlipkartService } from '../flipkart.service';
import { GlobalService } from '../service/global.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-order-details',
  templateUrl: './order-details.component.html',
  styleUrls: ['./order-details.component.scss']
})
export class OrderDetailsComponent implements OnInit {
  id!: number;
  orders: any = [];
  address: String = "";
  name: String= "";
  isDisplayed: boolean = false;
  created: string = "";

  constructor(private route: ActivatedRoute,
    private flipkartService: FlipkartService,
    private globalService: GlobalService) {

  }

  ngOnInit() {
    this.id = Number(this.route.snapshot.paramMap.get('id'));
    const customerString = localStorage.getItem('customer');
  if (customerString !== null) {
    const customer = JSON.parse(customerString);
    this.id = customer.id;
    this.address = customer.address;
    this.name = customer.userName;
  }
    console.log(this.id);
    this.isDisplayed = false;
    const id = String(this.id);
    this.flipkartService.get("http://localhost:8080/api/order/id".replace("id", id)).subscribe(
      response => {
      console.log(response);
      this.orders = response;
      this.globalService.sendData(this.orders);
      this.isDisplayed = true;
    });
      this.globalService.getData().subscribe(data => {
      this.orders = data;
      this.created = this.orders.createdOn;
      
     
});

}


}