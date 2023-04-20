import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators, MaxLengthValidator } from '@angular/forms';


@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.scss']
})
export class SignUpComponent {

  username: string = "";
  mobilenumber: any = "" ;
  email: string = "";
  password: string = "";
  address: string = "";
 
  form: FormGroup;

  constructor(private http: HttpClient, 
    private fb: FormBuilder)
{
  this.form = fb.group({  
    mobileNumber: ['', [Validators.required, Validators.pattern("^((\\+91-?)|0)?[0-9]{10}$")]],
    email: ['', [Validators.required, Validators.email,Validators.pattern('^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$')]],
    password: ['', [Validators.required, Validators.minLength(6)]],
    userName: ['', Validators.required],
    address: ['', Validators.required]
  })  
}

get f(){  
  return this.form.controls;  
}  
submit(){  
  console.log(this.form.value);  
}  


create()
{

  let bodyData = {
    "userName" : this.username,
    "mobileNumber" : this.mobilenumber,
    "email" : this.email,
    "password" : this.password,
    "address" : this.address

  };
  this.http.post("http://localhost:8080/api/customer/create",bodyData,{responseType: 'text'}).subscribe((resultData: any)=>
  {
     console.log(resultData);
     alert("User REgistered Successfully")

  });

}
}


