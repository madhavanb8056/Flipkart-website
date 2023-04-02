import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FlipkartService {

  constructor(private httpClient: HttpClient) { }

  public get(URL: string){
    return this.httpClient.get(URL);
  }

 

}
