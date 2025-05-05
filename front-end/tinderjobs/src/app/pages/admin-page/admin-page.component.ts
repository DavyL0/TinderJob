import { Component } from '@angular/core';
import { VagasComponent } from '../../components/vagas/vagas.component';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from '../../components/header/header.component';
import { CandidatosVagaComponent } from '../../components/candidatos-vaga/candidatos-vaga.component';
import { FooterComponent } from '../../components/footer/footer.component';

@Component({
  selector: 'app-admin-page',
  standalone: true,
  imports: [VagasComponent,HeaderComponent,CommonModule, CandidatosVagaComponent,FooterComponent],
  templateUrl: './admin-page.component.html',
  styleUrl: './admin-page.component.scss'
})
export class AdminPageComponent {

}
