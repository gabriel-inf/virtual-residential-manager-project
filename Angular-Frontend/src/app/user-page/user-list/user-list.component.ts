import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  showingList;
  creatingUser;
  updatingUser;
  deletinguser;

  userInfo={
    'name':'',
    'floor':'',
    'apartment':'',
  }

  constructor() { }

  ngOnInit() {
    this.showingList=true;
    this.creatingUser=false;
    this.updatingUser=false;
    this.deletinguser=false;
  }

  createUser(name,floor,apartment){
    this.userInfo.name=name.value;
    this.userInfo.floor=floor.value;
    this.userInfo.apartment=apartment.value;
    console.log(this.userInfo);

    this.creatingUser=false;
    this.showingList=true;
  }

  updateUser(name,floor,apartment){
    this.userInfo.name=name.value;
    this.userInfo.floor=floor.value;
    this.userInfo.apartment=apartment.value;
    console.log(this.userInfo);

    this.updatingUser=false;
    this.showingList=true;
  }

}
