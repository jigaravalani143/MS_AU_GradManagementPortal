import { ComponentFixture, TestBed } from '@angular/core/testing';
import { LoginComponent } from './login.component';

import { SocialAuthService, SocialAuthServiceConfig } from "angularx-social-login";
import { ActivatedRoute, Router } from '@angular/router';
import { FacebookLoginProvider, GoogleLoginProvider } from "angularx-social-login";

describe('LoginComponent', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;
  let routeMock: any = { snapshot: {}};
  let routeStateMock: any = { snapshot: {}, url: '/'};
  let routerMock = {navigate: jasmine.createSpy('navigate')}

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      providers:[SocialAuthService,{
        provide: 'SocialAuthServiceConfig',
        useValue: {
          autoLogin: false,
          providers: [
            {
              id: GoogleLoginProvider.PROVIDER_ID,
              provider: new GoogleLoginProvider(
                '304772065495-3uuv1o8acn6oeteh8dsqg1gqhqa1q9lt.apps.googleusercontent.com'
                
              )
            }
          ]
        } as SocialAuthServiceConfig,
      },{provide:ActivatedRoute, useValue:routeStateMock},{ provide: Router, useValue: routerMock }],
      declarations: [ LoginComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
