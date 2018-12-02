import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-smart-elevator',
  templateUrl: './smart-elevator.component.html',
  styleUrls: ['./smart-elevator.component.css']
})
export class SmartElevatorComponent implements OnInit {

  selectedCase = null;
  response = ""
  cases = [
    { id: 1, desc: "Known user calls elevator" },
    { id: 2, desc: "User recognized by camera close to elevator" },
    { id: 3, desc: "User jumps in a wrong floor" },
  ]



  constructor(private api: ApiService) { }

  ngOnInit() {
  }


  selectsCase(c) {
    if (this.selectedCase != c) {

      this.selectedCase = c;
    } else {
      this.selectedCase = null
      this.response = "";
    }
  }

  simulate(c) {
    console.log(c.id)

    if (c.id === 1) {
      this.api.userCallsElevator().subscribe(res => {
        this.response = res;
        console.log(c);
      });
    } else if (c.id === 2) {
      this.api.userRecognizedByCamera().subscribe(res => {
        this.response = res;
        console.log(c);
      });
    } else if (c.id === 3) {
      this.api.userJumpsWrongFloor().subscribe(res => {
        this.response = res;
        console.log(c);
      });
    }
  }

  clear() {
    this.response = "";
    this.selectedCase = null;
  }


}
