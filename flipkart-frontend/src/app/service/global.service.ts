import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GlobalService {

  constructor() { }

  private projectSubject = new Subject<any[]>();

  sendData(data: any[]) {
    this.projectSubject.next(data);
  }

  getData() {
    return this.projectSubject.asObservable();
  }

}
