import { Component } from '@angular/core';
import { VagasComponent } from '../../components/vagas/vagas.component';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from '../../components/header/header.component';

@Component({
  selector: 'app-admin-page',
  standalone: true,
  imports: [VagasComponent,HeaderComponent,CommonModule],
  templateUrl: './admin-page.component.html',
  styleUrl: './admin-page.component.scss'
})
export class AdminPageComponent {

}
