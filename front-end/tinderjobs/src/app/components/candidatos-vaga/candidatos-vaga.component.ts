import { Component, Input, OnInit } from '@angular/core';
import { VagaService } from '../../services/vagas.service';
import { CommonModule } from '@angular/common';
import { VagaCandidatosDTO } from '../../types/vaga-candidatos.type';


@Component({
  standalone: true,
  selector: 'app-candidatos-vaga',
  templateUrl: './candidatos-vaga.component.html',
  styleUrl: './candidatos-vaga.component.scss',
  imports: [CommonModule]
})
export class CandidatosVagaComponent implements OnInit {
  vagasComCandidatos: VagaCandidatosDTO[] = [];

  constructor(private vagaService: VagaService) {}

  ngOnInit(): void {
    this.vagaService.getVagasComCandidatos().subscribe({
      next: (res) => {
        this.vagasComCandidatos = res;
      },
      error: (err) => {
        console.error('Erro ao buscar vagas e candidatos', err);
      },
    });
  }
}
