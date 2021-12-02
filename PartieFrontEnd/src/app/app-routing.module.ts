import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { CreateEmployeeComponent } from './create-employee/create-employee.component';
import { UpdateEmployeeComponent } from './update-employee/update-employee.component';
import { EmployeeDetailsComponent } from './employee-details/employee-details.component';

const routes: Routes = [
  {path: 'etudiants', component: EmployeeListComponent},
  {path: 'create-etudiant', component: CreateEmployeeComponent},
  {path: '', redirectTo: 'etudiants', pathMatch: 'full'},
  {path: 'update-etudiant/:id', component: UpdateEmployeeComponent},
  {path: 'etudiant-details/:id', component: EmployeeDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],                                                                                                                                                                                                                                                                                                          
  exports: [RouterModule]
})
export class AppRoutingModule { }
