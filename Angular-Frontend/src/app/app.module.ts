import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HomePageComponent } from './home-page/home-page.component';
import { RoutingModule } from '../routing.module';
import { UserPageComponent } from './user-page/user-page.component';
import { UserListComponent } from './user-page/user-list/user-list.component';
import { SmartGateComponent } from './smart-gate/smart-gate.component';
import { SmartElevatorComponent } from './smart-elevator/smart-elevator.component';
import { AdministrationComponent } from './administration/administration.component';
import { CameraListComponent } from './camera-list/camera-list.component';
import { ElevatorListComponent } from './elevator-list/elevator-list.component';
import { GateListComponent } from './gate-list/gate-list.component';
import { DashboardComponent } from './dashboard/dashboard.component';

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    UserPageComponent,
    UserListComponent,
    SmartGateComponent,
    SmartElevatorComponent,
    AdministrationComponent,
    CameraListComponent,
    ElevatorListComponent,
    GateListComponent,
    DashboardComponent
  ],
  imports: [
    BrowserModule,
    RoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
