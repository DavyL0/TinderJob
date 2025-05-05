// vaga-candidatos.dto.ts
export class CandidatoDTO {
    id!: number;
    nome!: string;
    email!: string;
  }
  
  export class VagaCandidatosDTO {
    vagaId!: number;
    vagaNome!: string;
    candidatos!: CandidatoDTO[];
  }
  