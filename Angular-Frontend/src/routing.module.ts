import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './app/home-page/home-page.component';
import { UserPageComponent } from './app/user-page/user-page.component';
import { UserListComponent } from './app/user-page/user-list/user-list.component';

const appRoutes: Routes = [
  { path: '', component: HomePageComponent },
  { path: 'users', component: UserPageComponent },
  { path: 'users/list', component: UserListComponent }
];

@NgModule({
  imports: [ RouterModule.forRoot(appRoutes) ],
  exports: [ RouterModule ]
})
export class RoutingModule { }
