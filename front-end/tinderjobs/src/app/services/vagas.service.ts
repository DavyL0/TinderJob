// vagas.service.ts
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Vaga } from '../types/vaga.type';
import { VagaCandidatosDTO } from '../types/vaga-candidatos.type';


@Injectable({ providedIn: 'root' })
export class VagaService {
  private readonly api = 'http://localhost:8080/vagas';

  constructor(private http: HttpClient) {}

  getTodasVagas(): Observable<Vaga[]> {
    return this.http.get<Vaga[]>(`${this.api}/listar`);
  }

  criarVaga(vaga: Vaga): Observable<Vaga> {
    return this.http.post<Vaga>(this.api, vaga);
  }

  atualizarVaga(id: number, vaga: Vaga): Observable<Vaga> {
    return this.http.put<Vaga>(`${this.api}/${id}`, vaga);
  }

  excluirVaga(id: number): Observable<void> {
    return this.http.delete<void>(`${this.api}/${id}`);
  }

  candidatarSe(idVaga: number): Observable<any> {
    return this.http.put(`${this.api}/${idVaga}/candidatar`, {});
  }

  
  // vaga.service.ts
  getVagasComCandidatos(): Observable<VagaCandidatosDTO[]> {
    return this.http.get<VagaCandidatosDTO[]>(`${this.api}/vagas-com-candidatos`);
  }


  
}
