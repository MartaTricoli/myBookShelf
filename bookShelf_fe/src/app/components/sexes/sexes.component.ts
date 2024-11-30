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
  show : boolean = true;
  refresh : boolean = true;

  addSex() {
    const bodyData = {
      "description": this.sex
    };

    this.http.post("http://localhost:8080/myBookShelf/sex/create", bodyData, {responseType: "text"}).subscribe((resultData : string) => {
      const resultMessage = resultData.replace("{", "").replace("}", "").split(",")[1].split(":")[1];
      if (resultMessage == "null") {
        alert("new sex add successfully");
      } else {
        alert("this sex already exists.");
      }
    });
    this.newList = [];
    this.show = true;
    this.refresh = true;
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
      const message : string = Object.values(s)[1];
      if (message == null) {
        alert("Sex successfully removed");
      } else {
        alert("this sex does not exists");
      }
    })
    this.newList = [];
    this.show = true;
    this.refresh = true;
  }

  listAll() {
    console.log(this.newList.length);
    if (this.refresh) {
      this.newList = [];
      this.http.get<object>("http://localhost:8080/myBookShelf/sex/list").subscribe(data => {
        Object.values(data).forEach(ob => {
          this.newList.push(ob.sex);
        });
      })
      this.refresh = false;
    }
    this.show = false;
  }

  hide() {
    this.show = true;
  }

  search() {
    this.newList = [];
    this.refresh = true;
    const d : string = this.sex;
    this.http.get<object>(`http://localhost:8080/myBookShelf/sex/listOne?d=${d}`).subscribe(data => {
      if (data == null) {
        alert("This item is not present in the list");
        this.show = true;

      } else {
        this.newList.push(Object.values(data)[1]);
        this.show = false;
      }
    })
  }
}
