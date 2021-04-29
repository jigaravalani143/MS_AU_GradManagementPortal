import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SocialAuthService } from 'angularx-social-login';
import { FacebookLoginProvider, GoogleLoginProvider } from "angularx-social-login";
import { SocialUser } from "angularx-social-login";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
 
  username:String;
  constructor(private authService:SocialAuthService,private route:ActivatedRoute,private router: Router) { 
    this.username = localStorage.getItem('userName');
  }



  
  ngOnInit(): void {
    this.username = localStorage.getItem('userName');
  }

  signOut(): any{
    localStorage.removeItem("idToken");
    localStorage.removeItem("userName");
    localStorage.removeItem("userEmail");
    this.router.navigate(['']);
    this.authService.signOut();

  }

}