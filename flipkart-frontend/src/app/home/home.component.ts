import { Component } from '@angular/core';
import { FlipkartService } from '../flipkart.service';
import { GlobalService } from '../service/global.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent {

  products: any = [];
  isDisplayed: boolean = false;
  constructor(
    private flipkartService: FlipkartService,
    private globalService: GlobalService) {

  }

  ngOnInit() {
    this.isDisplayed = false;
    
    this.flipkartService.get("http://localhost:8080/api/product").subscribe(
      response => {
      console.log(response);
      this.products = response;
      this.globalService.sendData(this.products);
      this.isDisplayed = true;
    });

    this.globalService.getData().subscribe(data => {
      this.products = data;
    });
  }
}
