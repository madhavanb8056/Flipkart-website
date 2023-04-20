import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  mobilenumber: any = "" ;
  password: string = "";

  form: FormGroup;

  constructor(private http: HttpClient, private fb: FormBuilder, private route: Router)
  {
    this.form = fb.group({  
      mobileNumber: ['', [Validators.required, Validators.pattern("^((\\+91-?)|0)?[0-9]{10}$")]],
      
      password: ['', [Validators.required, Validators.minLength(6)]],

    })  
  
  }
  get f(){  
    return this.form.controls;  
  }  
  submit(){  
    console.log(this.form.value);  
  }  

login(){
   console.log(this.mobilenumber);
   console.log(this.password);

 
    
      this.http.get("http://localhost:8080/api/customer?phnNum={phnNum}&password={password}".replace("{phnNum}", this.mobilenumber).replace("{password}", this.password)).subscribe((resultData: any)=>{
       console.log(resultData);
       if(resultData != null){
       console.log(resultData.massage);
       localStorage.setItem("customer", JSON.stringify(resultData));
       
       

        alert("login success");
        
       }
       else {

        alert("Incorrect Mobilenumber or password");
        this.route.navigate(['/login']);
        
       }


      })





}








}
