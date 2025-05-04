import { Component } from '@angular/core';
import { VagasUsuarioComponent } from '../../components/vagas-usuario/vagas-usuario.component';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from '../../components/header/header.component';
import { UserInfoComponent } from "../../components/user-info/user-info.component";

@Component({
  selector: 'app-user-page',
  standalone: true,
  imports: [VagasUsuarioComponent, HeaderComponent, CommonModule, UserInfoComponent],
  templateUrl: './user-page.component.html',
  styleUrl: './user-page.component.scss'
})
export class UserPageComponent {

}
