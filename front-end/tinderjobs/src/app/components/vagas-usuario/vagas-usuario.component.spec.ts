import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VagasUsuarioComponent } from './vagas-usuario.component';

describe('VagasUsuarioComponent', () => {
  let component: VagasUsuarioComponent;
  let fixture: ComponentFixture<VagasUsuarioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VagasUsuarioComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(VagasUsuarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
