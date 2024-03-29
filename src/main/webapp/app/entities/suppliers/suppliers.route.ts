import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { Observable, of } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { Suppliers } from 'app/shared/model/suppliers.model';
import { SuppliersService } from './suppliers.service';
import { SuppliersComponent } from './suppliers.component';
import { SuppliersDetailComponent } from './suppliers-detail.component';
import { SuppliersUpdateComponent } from './suppliers-update.component';
import { SuppliersDeletePopupComponent } from './suppliers-delete-dialog.component';
import { ISuppliers } from 'app/shared/model/suppliers.model';

@Injectable({ providedIn: 'root' })
export class SuppliersResolve implements Resolve<ISuppliers> {
  constructor(private service: SuppliersService) {}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<ISuppliers> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        filter((response: HttpResponse<Suppliers>) => response.ok),
        map((suppliers: HttpResponse<Suppliers>) => suppliers.body)
      );
    }
    return of(new Suppliers());
  }
}

export const suppliersRoute: Routes = [
  {
    path: '',
    component: SuppliersComponent,
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'epmresourcesApp.suppliers.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/view',
    component: SuppliersDetailComponent,
    resolve: {
      suppliers: SuppliersResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'epmresourcesApp.suppliers.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: SuppliersUpdateComponent,
    resolve: {
      suppliers: SuppliersResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'epmresourcesApp.suppliers.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/edit',
    component: SuppliersUpdateComponent,
    resolve: {
      suppliers: SuppliersResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'epmresourcesApp.suppliers.home.title'
    },
    canActivate: [UserRouteAccessService]
  }
];

export const suppliersPopupRoute: Routes = [
  {
    path: ':id/delete',
    component: SuppliersDeletePopupComponent,
    resolve: {
      suppliers: SuppliersResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'epmresourcesApp.suppliers.home.title'
    },
    canActivate: [UserRouteAccessService],
    outlet: 'popup'
  }
];
