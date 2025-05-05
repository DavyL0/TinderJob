import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Usuario } from '../types/usuario.type';
import { UserUpdateDTO } from '../types/user-update.type';


@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  private readonly api = 'http://localhost:8080/user';

  constructor(private http: HttpClient) {}

  // Método para obter o usuário logado
  getUsuarioAtual(): Observable<Usuario> {
    return this.http.get<Usuario>(`${this.api}/me`);
  }

  // Atualizar o usuário
  atualizarUsuario(email: string, dadosAtualizados: UserUpdateDTO): Observable<Usuario> {
    return this.http.put<Usuario>(`${this.api}/${email}`, dadosAtualizados);
  }

  // Excluir usuário
  excluirUsuario(id: number): Observable<void> {
    return this.http.delete<void>(`${this.api}/${id}`);
  }
}
