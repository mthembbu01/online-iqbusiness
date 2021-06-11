import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import {Person} from '../shared/person.model';
import {environment} from '../../environments/environment.prod';
import {catchError} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {
  private apiServerUrl = environment.apiBaseUrl ;
  private registeredPersons = [];
  private errorMsg: string;

  getErrorMsg(): string {
    return this.errorMsg;
  }

   setErrorMsg(errorMsg: string): void {
    this.errorMsg = errorMsg;
  }

  constructor(private http: HttpClient) {}

  public login(user: Person): Observable<Person> {
    return this.http.post<Person>(`${this.apiServerUrl}/v1/api/persons/login`, user);
  }

  public getUsers(): Observable<Person[]> {
    return this.http.get<any>(`${this.apiServerUrl}/v1/api/persons`);
        /*.pipe(
          catchError(error => {
          let errorMsg: string;
          if (error.error instanceof ErrorEvent){
            errorMsg = `Error: ${error.error.message}`;
          } else{
            errorMsg = 'error';
          }

          return throwError(errorMsg);
        })
    );*/
  }

  public addUser(user: Person): Observable<Person> {
    return this.http.post<Person>(`${this.apiServerUrl}/v1/api/persons`, user);
  }
}
