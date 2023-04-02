import { Component } from '@angular/core';
import { FlipkartService } from './flipkart.service';
import { HomeComponent } from './home/home.component';
import { GlobalService } from './service/global.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'flipkart-frontend';
  search: any;
  products: any = [];
  
  constructor(
    private flipkartService: FlipkartService,
    private globalService: GlobalService) {

  }
  
  searchProduct() {
    if(this.search != '') {
      console.log("Check");
      
      let URL = "http://localhost:8080/api/product/search/" + this.search;
      this.flipkartService.get(URL).subscribe(
      response => {
      console.log(response);
      this.products = response;
      this.globalService.sendData(this.products);;
    });
    }
    
  }
}
