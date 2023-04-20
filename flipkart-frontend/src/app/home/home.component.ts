import { Component } from '@angular/core';
import { FlipkartService } from '../flipkart.service';
import { GlobalService } from '../service/global.service';
import { AppComponent } from '../app.component';

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
    private globalService: GlobalService,
    private app: AppComponent) {

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
   options(catagory: any)
  {
    this.app.search = "";
   this.flipkartService.get("http://localhost:8080/api/product/catagory/id".replace("id", catagory)).subscribe(
    Response=> {
    console.log(Response);
    this.products = Response;
    this.globalService.sendData(this.products);
    


   })
  

  }


}

