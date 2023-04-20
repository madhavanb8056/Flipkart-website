import { Component } from '@angular/core';
import { FlipkartService } from './flipkart.service';
import { HomeComponent } from './home/home.component';
import { GlobalService } from './service/global.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'flipkart-frontend';
  search: any;
  products: any = [];
  product: boolean= false;

  
  constructor(
    private flipkartService: FlipkartService,
    private globalService: GlobalService, 
    private route: Router) {

  }
  
  searchProduct() {
    this.route.navigate(['/home']);
    if(this.search != null) {
      console.log("Check");
      
      let URL = "http://localhost:8080/api/product/search/" + this.search;
      this.flipkartService.get(URL).subscribe(
      response => {
      console.log(response);
      if(response != null){
      this.products = response;
      this.globalService.sendData(this.products);;
       }else{
        
        alert("No Products Found")
       }
  
  
  });
  
    
    }else{
      let URL = "http://localhost:8080/api/product";
      this.flipkartService.get(URL).subscribe(
        response => {
        console.log(response);
        this.products = response;
        this.globalService.sendData(this.products);
        
      });
    }
    
  }
  isLogged(){
       let data = localStorage.getItem("customer");
       if(data != undefined){
         return true;

       }else{
        return false;
       }


  }
  isNotLogged(){
     let data = localStorage.getItem("customer")
      if(data != undefined){
        return false;
      }else{
        return true;
      }

  }
  logout(){
    let data = localStorage.removeItem("customer");
    alert("Logout Successful");
}
}
