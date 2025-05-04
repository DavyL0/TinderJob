import { Component } from '@angular/core';
import { VagasUsuarioComponent } from '../../components/vagas-usuario/vagas-usuario.component';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-user-page',
  standalone: true,
  imports: [VagasUsuarioComponent, CommonModule],
  templateUrl: './user-page.component.html',
  styleUrl: './user-page.component.scss'
})
export class UserPageComponent {

}
