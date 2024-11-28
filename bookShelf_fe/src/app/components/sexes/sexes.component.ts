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
  newList : Array<string> = [];
  data : object = {};

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
      //to fix = right alert when the remove failed
      alert("Sex successfully removed");
    })
  }

  //to fix = how to show and hide the list
  //how to avoid repeting get data.
  listAll() {
    this.http.get<object>("http://localhost:8080/myBookShelf/sex/list").subscribe(data => {
      console.log(data);
      
      Object.values(data).forEach(ob => {
        console.log(ob.sex);
        this.newList.push(ob.sex);
      });
      console.log(this.newList);
    })
  }
}
