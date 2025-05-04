import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Vaga } from '../../types/vaga.type';
import { VagaService } from '../../services/vagas.service';
import { CommonModule, getLocaleDateFormat } from '@angular/common';


@Component({
  selector: 'app-vagas',
  standalone: true,
  imports: [ CommonModule ,FormsModule],
  templateUrl: './vagas.component.html',
  styleUrls: ['./vagas.component.scss']
})
export class VagasComponent implements OnInit {
  vagas: Vaga[] = [];
  vaga: Vaga = {
    nome: '',
    description: '',
    requisitos: '',
    status: '',
    dataCriacao: new Date(),
    usuarios: []
  };
  
  
  idEditando?: number;

  constructor(private vagaService: VagaService) {}

  ngOnInit() {
    this.carregarVagas();
  }

  carregarVagas() {
    this.vagaService.getTodasVagas().subscribe((vagas) => (this.vagas = vagas));
  }

  salvarVaga() {
    if (this.idEditando) {
      this.vagaService.atualizarVaga(this.idEditando, this.vaga).subscribe(() => {
        this.idEditando = undefined;
        this.vaga = { nome: '', description: '', requisitos: '', status: '',dataCriacao: new Date(), usuarios: [] };
        this.carregarVagas();
      });
    } else {
      this.vagaService.criarVaga(this.vaga).subscribe(() => {
        this.vaga = { nome: '', description: '', requisitos: '', status: '',dataCriacao: new Date(), usuarios: [] };
        this.carregarVagas();
      });
    }
  }

  editar(vaga: Vaga) {
    this.idEditando = vaga.id!;
    this.vaga = { ...vaga };
  }

  excluir(id: number) {
    this.vagaService.excluirVaga(id).subscribe(() => this.carregarVagas());
  }

  
  
}
