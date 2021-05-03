import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddComponent } from './add.component';
import { HttpClientModule } from '@angular/common/http';
import { GradService } from '../grad.service';
import { FormArray, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { MatSnackBar, MatSnackBarConfig } from '@angular/material/snack-bar';
import { OverlayModule } from '@angular/cdk/overlay';

describe('AddComponent', () => {
  let component: AddComponent;
  let fixture: ComponentFixture<AddComponent>;
  //let service: GradService;

  beforeEach(async () => {
      TestBed.configureTestingModule({
      imports: [HttpClientTestingModule, OverlayModule],
      providers: [GradService,FormBuilder,MatSnackBar],
      declarations: [ AddComponent ]
    })
    .compileComponents();
  });
 // service = TestBed.inject(GradService);

  beforeEach(() => {
    fixture = TestBed.createComponent(AddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
