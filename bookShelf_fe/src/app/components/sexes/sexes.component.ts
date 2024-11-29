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
      const message : string = Object.values(s)[1];
      if (message == null) {
        alert("Sex successfully removed");
      } else {
        alert("this sex does not exists");
      }
    })
    this.newList = [];
    this.show = true;
  }

  listAll() {
    console.log(this.newList.length);
    if (this.newList.length == 0) {
      this.http.get<object>("http://localhost:8080/myBookShelf/sex/list").subscribe(data => {
        console.log(data);
        Object.values(data).forEach(ob => {
          this.newList.push(ob.sex);
        });
      })
    }
    this.show = false;
  }

  hide() {
    console.log(this.newList.length);
    this.show = true;
  }

  // gestire l'errore in caso in cui l'elemento che sto cercando non esista, se esiste lo mostro, se non esiste un messaggio che dice che non è presente in elenco.
  search() {
    this.newList = [];
    const d : string = this.sex;
    this.http.get<object>(`http://localhost:8080/myBookShelf/sex/listOne?d=${d}`).subscribe(data => {
      console.log(data);
      const resultMessage = Object.values(data)[0];
      console.log(typeof(resultMessage));
      //da ultimare
      
    })
  }
}
