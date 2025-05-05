import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminGuard implements CanActivate {

  constructor(private router: Router) {}

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): boolean | Observable<boolean> {
    
    // Verifica se o usuário é admin no sessionStorage
    const isAdmin = sessionStorage.getItem('is-admin') === 'true';

    if (isAdmin) {
      return true; // Permite o acesso
    }

    // Se não for admin, redireciona para a página principal (ou login)
    this.router.navigate(['/']);
    return false;
  }
}
