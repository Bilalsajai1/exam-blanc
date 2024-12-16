import { Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { KeynoteListComponent } from './components/keynote-list/keynote-list.component';
import { KeynoteFormComponent } from './components/keynote-form/keynote-form.component';

export const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'keynotes', component: KeynoteListComponent },
  { path: 'keynotes/new', component: KeynoteFormComponent },
  { path: 'keynotes/:id/edit', component: KeynoteFormComponent },
  // { path: 'conferences', component: ConferenceListComponent },
  // { path: 'conferences/new', component: ConferenceFormComponent },
  // { path: 'conferences/:id/edit', component: ConferenceFormComponent }
];
