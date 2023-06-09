import { Component, OnInit } from '@angular/core'
import { Client } from "../client"
import { ClientsService } from "../../clients.service"

@Component({
  selector: 'app-clients-form',
  templateUrl: './clients-form.component.html',
  styleUrls: ['./clients-form.component.css']
})
export class ClientsFormComponent implements OnInit {

  client: Client
  success: boolean = false
  errors : String[] | undefined

  constructor(private service: ClientsService) {
    this.client = new Client()
  }
  ngOnInit(): void {
  }

  onSubmit() {
    this.service
      .postClient(this.client)
      .subscribe(response => {
        this.success = true
        this.errors = []
        this.client = response
      }, errorResponse => {
        console.log(errorResponse.error);
        this.success = false
        this.errors = errorResponse.error.errors;
      }
      )
  }
}
