export interface Conference {
  id?: number;
  title: string;
  type: string;
  date: Date;
  duration: number;
  registeredCount: number;
  score: number;
  reviews?: Review[];
}

export interface Review {
  id?: number;
  date: Date;
  text: string;
  stars: number;
}