import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {

  userName: string = "";
  email: string = "";
  password: string = "";

  constructor(private router: Router, private http: HttpClient) {

  }

  save() {
    const bodyData = {
      "userName" : this.userName,
      "email": this.email,
      "password": this.password
    };
    this.http.post("http://localhost:8080/myBookShelf/user/save", bodyData, {responseType: "text"}).subscribe((resultData: any) => {
      console.log(resultData);
      const message: string = resultData.split(",")[1].split(":")[1].replace('}', '');
      console.log(message);

      if (message == '"this email is already registered."') {
        alert("This email is already registered");
      }
    });
  }

  goToLogin() {
    this.router.navigateByUrl('');
  }
}
