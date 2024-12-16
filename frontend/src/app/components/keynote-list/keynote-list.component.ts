import { Component, OnInit } from '@angular/core';
import { Keynote } from '../../models/keynote.model';
import { KeynoteService } from '../../services/keynote.service';

@Component({
  selector: 'app-keynote-list',
  standalone: true,
  templateUrl: './keynote-list.component.html',
})
export class KeynoteListComponent implements OnInit {
  keynotes: Keynote[] = [];

  constructor(private keynoteService: KeynoteService) {}

  ngOnInit(): void {
    this.loadKeynotes();
  }

  loadKeynotes() {
    this.keynoteService.getAll().subscribe((data) => (this.keynotes = data));
  }

  deleteKeynote(id: number) {
    if (confirm('Are you sure?')) {
      this.keynoteService.delete(id).subscribe(() => this.loadKeynotes());
    }
  }
}
