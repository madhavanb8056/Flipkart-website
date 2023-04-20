import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class FlipkartService {

  constructor(private httpClient: HttpClient) { }

  public get(URL: string){
    return this.httpClient.get(URL);
  }

  
  
 

}
