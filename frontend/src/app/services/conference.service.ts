import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Conference, Review } from "../models/conference.model";

@Injectable({
  providedIn: 'root'
})
export class ConferenceService {
  private apiUrl = 'http://localhost:8081/api/conferences';

  constructor(private http: HttpClient) { }

  getAll(): Observable<Conference[]> {
    return this.http.get<Conference[]>(this.apiUrl);
  }

  getById(id: number): Observable<Conference> {
    return this.http.get<Conference>(`${this.apiUrl}/${id}`);
  }

  create(conference: Conference): Observable<Conference> {
    return this.http.post<Conference>(this.apiUrl, conference);
  }

  update(id: number, conference: Conference): Observable<Conference> {
    return this.http.put<Conference>(`${this.apiUrl}/${id}`, conference);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }

  addReview(conferenceId: number, review: Review): Observable<Conference> {
    return this.http.post<Conference>(`${this.apiUrl}/${conferenceId}/reviews`, review);
  }
}