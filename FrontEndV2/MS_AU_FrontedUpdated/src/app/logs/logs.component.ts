import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Grad } from '../grad';
import { GradService } from '../grad.service';
import {AfterViewInit, ViewChild} from '@angular/core';

import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import {MatDialog, MatDialogConfig} from "@angular/material/dialog";
import { AddGradComponent } from '../add-grad/add-grad.component';
import { DeleteGradComponent } from '../delete-grad/delete-grad.component';
import { DetailGradComponent } from '../detail-grad/detail-grad.component';

@Component({
  selector: 'app-logs',
  templateUrl: './logs.component.html',
  styleUrls: ['./logs.component.css']
})
export class LogsComponent implements OnInit {

  displayedColumns: string[] = [ 'id','userEmail','oldValues','operation','newValues','date'];
  grads: MatTableDataSource<Grad> ;

  @ViewChild(MatPaginator) paginator: MatPaginator ;
  @ViewChild(MatSort) sort: MatSort ;
  searchKey:String ;
  
  constructor(public gradService:GradService,private dialog:MatDialog) {

}

  ngOnInit(): void {
    this.gradService.getAudit().subscribe(
      (respone:Grad[])=>{
        this.grads=new MatTableDataSource(respone);
        this.grads.sort=this.sort;
        this.grads.paginator=this.paginator;
        this.grads.filterPredicate = (data: any, filter) => {
          const dataStr =JSON.stringify(data).toLowerCase();
          return dataStr.indexOf(filter) != -1; 
        }
      },
      (err:HttpErrorResponse)=>{
        alert(err.message);
      }
    );
    
  }

//   onSearchClear(){
//     this.searchKey="";
//     this.applyFilter();
//   }
//   applyFilter() {
//      //const filterValue = (event.target as HTMLInputElement).value;
//     this.grads.filter = this.searchKey.trim().toLowerCase();
 
    
//     if (this.grads.paginator) {
//       this.grads.paginator.firstPage();
//     }
//   }
// onAddClick(){
//   this.gradService.initializeFormGroup();
//   const dialogConfig = new MatDialogConfig();
//   dialogConfig.disableClose = true;
//   dialogConfig.autoFocus = true;
//   dialogConfig.width = "50%";
//   dialogConfig.data = {
//     id: 1,
//     title: 'Add New Grad'
// };
//   this.dialog.open(AddGradComponent,dialogConfig);
//   this.dialog.afterAllClosed.subscribe((res)=>{
//     this.getGrads();
//   });
// }
// onUpdateClick(row){
//   console.log(JSON.stringify(row))
//   this.gradService.populateForm(row,row.id);
//   const dialogConfig = new MatDialogConfig();
//   dialogConfig.data = {
//     id: 3,
//     title: 'Update Grad'
// };
//   dialogConfig.disableClose = true;
//   dialogConfig.autoFocus = true;
//   dialogConfig.width = "50%";
//   this.dialog.open(AddGradComponent,dialogConfig);
//   this.dialog.afterAllClosed.subscribe((res)=>{
//     this.getGrads();
//   });
// }
// onInfoClick(row)
// {
//   console.log(JSON.stringify(row))
//   this.gradService.populateForm(row,row.id);
//   const dialogConfig = new MatDialogConfig();
//   dialogConfig.data = {
//     grad:row
// };
//   dialogConfig.disableClose = true;
//   dialogConfig.autoFocus = true;
//   dialogConfig.width = "50%";
//   this.dialog.open(LogDetailsComponent,dialogConfig);
  
// }
// onDeleteClick(grad){

//    this.gradService.populateFormId(grad);
//   const dialogConfig = new MatDialogConfig();
//   dialogConfig.disableClose = true;
//   dialogConfig.autoFocus = true;
//   dialogConfig.width = "30%";
//   this.dialog.open(DeleteGradComponent,dialogConfig);
//   this.dialog.afterAllClosed.subscribe((res)=>{
//     this.getGrads();
//   });
// }

  public getAudit():void{
    this.gradService.getAudit().subscribe(
      (respone:Grad[])=>{
        this.grads=new MatTableDataSource(respone);
      
      },
      (err:HttpErrorResponse)=>{
        alert(err.message);
      }
    );
  }

}

