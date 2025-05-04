import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Usuario } from '../types/usuario.type';
import { UserUpdateDTO } from '../types/user-update.dto';

@Injectable({ providedIn: 'root' })
export class UsuarioService {
  private readonly api = 'http://localhost:8080/user';
  apiUrl: any;

  constructor(private http: HttpClient) {}

  getUsuarioAtual(): Observable<Usuario> {
    return this.http.get<Usuario>(`${this.api}/me`);
  }
  
  

  getUsuarioPorId(id: number): Observable<Usuario> {
    return this.http.get<Usuario>(`${this.api}/listar/${id}`);
  }

  atualizarUsuario(email: string, dadosAtualizados: UserUpdateDTO): Observable<Usuario> {
    return this.http.put<Usuario>(`${this.api}/${email}`, dadosAtualizados);
  }

  excluirUsuario(id: number): Observable<void> {
    return this.http.delete<void>(`${this.api}/${id}`);
  }
}
