import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { VagaService } from '../../services/vagas.service';
import { Vaga } from '../../types/vaga.type';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-vagas-usuario',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './vagas-usuario.component.html',
  styleUrls: ['./vagas-usuario.component.scss']
})

export class VagasUsuarioComponent implements OnInit {
  vagas: Vaga[] = [];

  constructor(
    private vagaService: VagaService,
    private toastr: ToastrService
  ) {}

  ngOnInit(): void {
    this.vagaService.getTodasVagas().subscribe({
      next: (res) => (this.vagas = res),
      error: () => this.toastr.error('Erro ao carregar vagas')
    });
  }

  candidatar(vagaId: number): void {
    const userId = Number(sessionStorage.getItem('user_id'));
    if (!userId) {
      this.toastr.error('Usuário não autenticado');
      return;
    }

    this.vagaService.candidatarSe(vagaId).subscribe({
      next: () => this.toastr.success('Candidatura realizada com sucesso!'),
      error: () => this.toastr.error('Erro ao se candidatar à vaga')
    });
  }
}
