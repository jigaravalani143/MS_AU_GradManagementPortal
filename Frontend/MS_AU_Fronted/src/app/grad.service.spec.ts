import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { GradService } from './grad.service';
import { FormArray, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

describe('GradService', () => {
  let service: GradService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [GradService,FormBuilder]
    });
    service = TestBed.inject(GradService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
