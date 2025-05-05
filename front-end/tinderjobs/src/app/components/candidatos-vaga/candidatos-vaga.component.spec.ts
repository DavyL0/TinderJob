import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CandidatosVagaComponent } from './candidatos-vaga.component';

describe('CandidatosVagaComponent', () => {
  let component: CandidatosVagaComponent;
  let fixture: ComponentFixture<CandidatosVagaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CandidatosVagaComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CandidatosVagaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
