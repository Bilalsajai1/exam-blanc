import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Keynote } from "../models/keynote.model";

@Injectable({
  providedIn: 'root'
})
export class KeynoteService {
  private apiUrl = 'http://localhost:8080/api/keynotes';

  constructor(private http: HttpClient) { }

  getAll(): Observable<Keynote[]> {
    return this.http.get<Keynote[]>(this.apiUrl);
  }

  getById(id: number): Observable<Keynote> {
    return this.http.get<Keynote>(`${this.apiUrl}/${id}`);
  }

  create(keynote: Keynote): Observable<Keynote> {
    return this.http.post<Keynote>(this.apiUrl, keynote);
  }

  update(id: number, keynote: Keynote): Observable<Keynote> {
    return this.http.put<Keynote>(`${this.apiUrl}/${id}`, keynote);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}