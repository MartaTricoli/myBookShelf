import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-sexes',
  templateUrl: './sexes.component.html',
  styleUrl: './sexes.component.css'
})
export class SexesComponent {

  constructor(private http: HttpClient) {

  }

  sex : string = "";

  addSex() {
    const bodyData = {
      "description": this.sex
    };

    this.http.post("http://localhost:8080/myBookShelf/sex/create", bodyData, {responseType: "text"}).subscribe((resultData : string) => {
      console.log(resultData);
      alert("new sex add successfully");
    });
  }

  removeSex() {
    const options = {
      headers : new HttpHeaders ({
        'Content-Type': 'application/json'
      }),
      body: {
        "description": this.sex
      }
    };

    this.http.delete("http://localhost:8080/myBookShelf/sex/remove", options).subscribe((s) => {
      console.log(s);
      alert("Sex successfully removed");
    })
  }
}
