import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-smart-gate',
  templateUrl: './smart-gate.component.html',
  styleUrls: ['./smart-gate.component.css']
})
export class SmartGateComponent implements OnInit {

  selectedCase = null

  cases = [
    { id: 1, desc: "Proprietary known user" },
    { id: 2, desc: "Proprietary knows an user that wants to enter" },
    { id: 3, desc: "Unauthorized user tried to enter" },
  ]


  response = "";
  constructor(private api: ApiService) { }

  ngOnInit() {
  }

  selectsCase(c) {
    if (this.selectedCase != c) {
      this.selectedCase = c;

      console.log(c.id)
      this.api.gateCaseSimulate(c.id).subscribe(res => {
        this.response = res;
        console.log(this.response)
      });


    } else {
      this.selectedCase = null
      this.response = "";
    }
  }

  simulate() {

  }

}
