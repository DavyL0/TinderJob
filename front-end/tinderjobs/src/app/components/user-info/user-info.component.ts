import { Component, OnInit } from '@angular/core';
import { UsuarioService } from '../../services/user.service';
import { Usuario } from '../../types/usuario.type';
import { UserUpdateDTO } from '../../types/user-update.dto';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  standalone: true,
  selector: 'app-user-info',
  templateUrl: './user-info.component.html',
  styleUrls: ['./user-info.component.scss'],
  imports: [CommonModule, FormsModule]
})


export class UserInfoComponent implements OnInit {
  usuario: Usuario | null = null;
  isEditing: boolean = false;

  constructor(private usuarioService: UsuarioService) {}

  ngOnInit(): void {
    // Chama o serviço para pegar o usuário logado
    this.usuarioService.getUsuarioAtual().subscribe({
      next: (res) => {
        this.usuario = res;
      },
      error: (err) => {
        console.error('Erro ao obter usuário:', err);
      }
    });
  }

  toggleEdit() {
    this.isEditing = !this.isEditing;
  }

  saveDescription(novaDescricao: string) {
    if (!this.usuario) return;

    const update: UserUpdateDTO = {
      ...this.usuario,
      description: novaDescricao,
    };

    this.usuarioService.atualizarUsuario(this.usuario.email, update).subscribe({
      next: (res) => {
        this.usuario = res;
        this.isEditing = false;
      },
      error: (err) => {
        console.error('Erro ao atualizar descrição:', err);
      }
    });
  }
}
