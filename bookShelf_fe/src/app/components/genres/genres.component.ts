import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-genres',
  templateUrl: './genres.component.html',
  styleUrl: './genres.component.css'
})
export class GenresComponent {

  constructor(private http: HttpClient) {

  }

  newList : Array<string> = [];
  data : object = {};
  show : boolean = true;
  refresh : boolean = true;
  genre : string = "";

  listAll() {
    if (this.refresh) {
      this.newList = [];
      this.http.get<object>("http://localhost:8080/myBookShelf/genre/list").subscribe(data => {
        Object.values(data).forEach(ob => {
          this.newList.push(ob.genre);
        });
      })
      this.refresh = false;
    }
    this.show = false;
  }

  hide () {
    this.show = true;
  }

  addGenre() {

    const bodyData = {
      "description": this.genre
    };

    this.http.post("http://localhost:8080/myBookShelf/genre/create", bodyData, {responseType : "text"}).subscribe((resultData : string) => {
      const resultMessage = resultData.replace("{", "").replace("}", "").split(",")[1].split(":")[1];
      if (resultMessage == "null") {
        alert("new genre add successfull.");
      } else {
        alert("thia genre already exists.");
      }
    });
    this.newList = [];
    this.show = true;
    this.refresh = true;
  }

  removeGenre() {
    const options = {
      headers : new HttpHeaders ({
        'Content-Type': 'application/json'
      }),
      body: {
        "description": this.genre
      }
    };

    this.http.delete("http://localhost:8080/myBookShelf/genre/remove", options).subscribe((g) => {
      const message : string = Object.values(g)[1];
      if (message == null) {
        alert("Genre successfully removed");
      } else {
        alert("this genre does not exists");
      }
    });
    this.newList = [];
    this.show = true;
    this.refresh = true;
  }

  search() {
    this.newList = [];
    this.refresh = true;
    const g : string = this.genre;
    this.http.get<object>(`http://localhost:8080/myBookShelf/genre/listOne?d=${g}`).subscribe(data => {
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
