import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './app/home-page/home-page.component';
import { UserPageComponent } from './app/user-page/user-page.component';
import { UserListComponent } from './app/user-page/user-list/user-list.component';
import { SmartGateComponent } from './app/smart-gate/smart-gate.component';
import { SmartElevatorComponent } from './app/smart-elevator/smart-elevator.component';
import { AdministrationComponent } from './app/administration/administration.component';

const appRoutes: Routes = [
  { path: '', component: HomePageComponent },
  { path: 'users', component: UserPageComponent },
  { path: 'users/list', component: UserListComponent },
  { path: 'smartGate', component: SmartGateComponent },
  { path: 'smartElevator', component: SmartElevatorComponent },
  { path: 'admin', component: AdministrationComponent },
 
];

@NgModule({
  imports: [ RouterModule.forRoot(appRoutes) ],
  exports: [ RouterModule ]
})
export class RoutingModule { }
