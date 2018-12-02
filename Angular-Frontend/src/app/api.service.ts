import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ApiService {




  url = "http://localhost:8888"


  constructor(private http: HttpClient) { }

  public gateCaseSimulate(caseNumber): Observable<any>{
    let path = this.url+"/gate?c="+caseNumber;
    return this.http.get(path, {responseType: 'text'});
  }


  userJumpsWrongFloor(): any {
    let path = this.url+"/elevator/jumpsWrongFloor";
    return this.http.get(path, {responseType: 'text'});
  }
  userRecognizedByCamera(): any {
    let path = this.url+"/camera/callElevator";
    return this.http.get(path, {responseType: 'text'});
  }
  userCallsElevator(): any {
    let path = this.url+"/elevator/callElevator";
    return this.http.get(path, {responseType: 'text'});
  }

  moveAllElevators(): any {
    let path = this.url+"/elevator/moveAll";
    return this.http.get(path, {responseType: 'text'});
  }

  
  
}