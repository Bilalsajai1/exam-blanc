import { Component, OnInit } from '@angular/core';
import { Keynote } from '../../models/keynote.model';
import { KeynoteService } from '../../services/keynote.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-keynote-form',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './keynote-form.component.html',
})
export class KeynoteFormComponent implements OnInit {
  keynote: Keynote = {
    firstName: '',
    lastName: '',
    email: '',
    function: '',
  };
  isEdit = false;

  constructor(
    private keynoteService: KeynoteService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.isEdit = true;
      this.keynoteService.getById(+id).subscribe((data) => {
        this.keynote = data;
      });
    }
  }

  saveKeynote() {
    if (this.isEdit) {
      this.keynoteService
        .update(this.keynote.id!, this.keynote)
        .subscribe(() => {
          this.router.navigate(['/keynotes']);
        });
    } else {
      this.keynoteService.create(this.keynote).subscribe(() => {
        this.router.navigate(['/keynotes']);
      });
    }
  }
}
