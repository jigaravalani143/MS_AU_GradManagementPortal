import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailGradComponent } from './detail-grad.component';
import { GradService } from '../grad.service';
import { FormArray, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { MatSnackBar, MatSnackBarConfig } from '@angular/material/snack-bar';
import { OverlayModule } from '@angular/cdk/overlay';
import { MAT_DIALOG_DATA,MatDialogRef } from '@angular/material/dialog';
import { Institute } from '../institute';
import { Location } from '../location';

describe('DetailGradComponent', () => {
  let component: DetailGradComponent;
  let fixture: ComponentFixture<DetailGradComponent>;

  let Institute : Institute;
  let Location : Location;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientTestingModule, OverlayModule],
      providers: [GradService,{ 
        provide: MatDialogRef,
        useValue: []
         }, 
        { 
        provide: MAT_DIALOG_DATA, 
        useValue: [] 
        }],
      declarations: [ DetailGradComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailGradComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  // it('should create', () => {
  //   component.grad = {
  //     name: 'One component',
  //     email: 'Caption',
  //     contact:'5',
  //     description:'',
  //     feedback:'',
  //     skills:[],
  //     institute: Institute,
  //     loc: Location,
  //     join_loc:Location,
  //     ten_join_date:'04/06/2021',
  //     id:1
  // };
  //   expect(component).toBeTruthy();
  // });
});
