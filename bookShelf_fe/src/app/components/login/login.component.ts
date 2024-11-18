import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  email: string = "";
  password: string = "";

  constructor(private router: Router, private http: HttpClient) {

  }

  login() {
    console.log(this.email);
    console.log(this.password);

    const bodyData = {
      email: this.email,
      password: this.password
    };

    this.http.post("http://localhost:8080/myBookShelf/user/login", bodyData).subscribe((resultData: any) => {
      console.log(resultData);

      if (resultData.message == "email not valid") {
        alert("Email not exist");
      } else if (resultData.message == "Successful login") {
        this.router.navigateByUrl('home');
      } else {
        alert("Incorrect password");
      }
    })
  }
}
