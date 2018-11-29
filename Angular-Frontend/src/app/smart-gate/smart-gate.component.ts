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
    { id: 2, desc: "Proprietary user and 1 known friend" },
    { id: 3, desc: "Proprietary and 1 unknown friend" },
    { id: 4, desc: "Unknown user ask to go to appartment 1005" },
    { id: 5, desc: "Pizza man to Gilberto (appartment 516)" }
  ]

  constructor(private api: ApiService) { console.log(this.cases) }

  ngOnInit() {
  }

  selectsCase(c) {
    if (this.selectedCase != c) {
      this.selectedCase = c;
    } else {
      this.selectedCase = null
    }
  }

  simulate(){
    
  }

}
