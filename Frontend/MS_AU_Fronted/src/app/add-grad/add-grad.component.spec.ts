import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddGradComponent } from './add-grad.component';
import { GradService } from '../grad.service';
import { FormArray, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { MatSnackBar, MatSnackBarConfig } from '@angular/material/snack-bar';
import { OverlayModule } from '@angular/cdk/overlay';
import { MAT_DIALOG_DATA,MatDialogRef } from '@angular/material/dialog';

describe('AddGradComponent', () => {
  let component: AddGradComponent;
  let fixture: ComponentFixture<AddGradComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientTestingModule, OverlayModule],
      providers: [GradService,FormBuilder,MatSnackBar,{ 
        provide: MatDialogRef,
        useValue: []
         }, 
        { 
        provide: MAT_DIALOG_DATA, 
        useValue: [] 
        }],
      declarations: [ AddGradComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddGradComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
