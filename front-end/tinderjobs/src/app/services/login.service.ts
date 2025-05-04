import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { tap } from 'rxjs';
import { LoginResponse } from '../types/login-response.type';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private readonly TOKEN_KEY = 'auth-token';
  private readonly USERNAME_KEY = 'username';
  private readonly IS_ADMIN_KEY = 'is-admin';
  private readonly USER_ID_KEY = 'user_id';


  apiUrl: string = 'http://localhost:8080/auth';

  constructor(private httpClient: HttpClient) {}

  login(email: string, password: string) {
    return this.httpClient.post<LoginResponse>(`${this.apiUrl}/login`, { email, password }).pipe(
      tap((response) => {
        sessionStorage.setItem(this.TOKEN_KEY, response.token);
        sessionStorage.setItem(this.USERNAME_KEY, response.name);
        sessionStorage.setItem(this.IS_ADMIN_KEY, String(response.admin));

        console.log('Login response:', response); // debug opcional
      })
    );
  }

  signup(name: string, email: string, password: string, admin: boolean = false) {
    return this.httpClient.post<LoginResponse>(`${this.apiUrl}/register`, {
      name,
      email,
      password,
      admin
    }).pipe(
      tap((response) => {
        sessionStorage.setItem(this.TOKEN_KEY, response.token);
        sessionStorage.setItem(this.USERNAME_KEY, response.name);
        sessionStorage.setItem(this.IS_ADMIN_KEY, String(response.admin));
        sessionStorage.setItem(this.USER_ID_KEY, response.id.toString());
      })
    );
  }

  /** Retorna true se o token existir */
  estaAutenticado(): boolean {
    return !!sessionStorage.getItem(this.TOKEN_KEY);
  }

  /** Retorna o token armazenado */
  getToken(): string | null {
    return sessionStorage.getItem(this.TOKEN_KEY);
  }

  /** Remove dados da sessão */
  logout(): void {
    sessionStorage.removeItem(this.TOKEN_KEY);
    sessionStorage.removeItem(this.USERNAME_KEY);
    sessionStorage.removeItem(this.IS_ADMIN_KEY);
  }

  /** (Opcional) Retorna se o usuário é admin */
  isAdmin(): boolean {
    return sessionStorage.getItem(this.IS_ADMIN_KEY) === 'true';
  }

  /** (Opcional) Nome do usuário logado */
  getUsername(): string | null {
    return sessionStorage.getItem(this.USERNAME_KEY);
  }
}
