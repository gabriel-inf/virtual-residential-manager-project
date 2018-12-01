import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-logs',
  templateUrl: './logs.component.html',
  styleUrls: ['./logs.component.css']
})





export class LogsComponent implements OnInit {

  @Input()
  iteractionLogs: string;


  logs = [
  ]

  constructor() { }

  ngOnInit() {
    this.logs = this.iteractionLogs.split('#');
    console.log(this.iteractionLogs);

  }

}
