import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-elevator-list',
  templateUrl: './elevator-list.component.html',
  styleUrls: ['./elevator-list.component.css']
})
export class ElevatorListComponent implements OnInit {

  constructor(private api: ApiService) { }
  response = [];
  ngOnInit() {
  }

  moveElevators(){
    console.log("Mooooving")
    this.api.moveAllElevators().subscribe(res => {
      this.response = res.split("#");
  
    });
  }

}
