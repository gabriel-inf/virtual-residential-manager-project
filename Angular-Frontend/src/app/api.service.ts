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

  
  
}