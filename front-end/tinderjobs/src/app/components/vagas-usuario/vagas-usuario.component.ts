import { CommonModule } from "@angular/common";
import { Component, OnInit } from "@angular/core";
import { VagaService } from "../../services/vagas.service";
import { LoginService } from "../../services/login.service";
import { Vaga } from "../../types/vaga.type";


@Component({
  selector: 'app-vagas-usuario',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './vagas-usuario.component.html',
  styleUrls: ['./vagas-usuario.component.scss']
})
export class VagasUsuarioComponent implements OnInit {
  vagas: Vaga[] = [];
  userId: number | null = null;

  constructor(private vagaService: VagaService, private loginService: LoginService) {}

  ngOnInit() {
    this.userId = Number(sessionStorage.getItem('user_id'));
    this.vagaService.getTodasVagas().subscribe((vagas) => (this.vagas = vagas));
  }

  candidatar(vagaId: number) {
    if (!this.userId) return;

    this.vagaService.candidatarSe(vagaId).subscribe({
      next: () => {
        alert('Candidatura realizada com sucesso!');
        // opcional: atualizar os dados da vaga
      },
      error: (err) => {
        console.error(err);
        alert('Erro ao se candidatar à vaga.');
      }
    });
  }
}
