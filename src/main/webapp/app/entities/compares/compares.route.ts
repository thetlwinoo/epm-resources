import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { Observable, of } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { Compares } from 'app/shared/model/compares.model';
import { ComparesService } from './compares.service';
import { ComparesComponent } from './compares.component';
import { ComparesDetailComponent } from './compares-detail.component';
import { ComparesUpdateComponent } from './compares-update.component';
import { ComparesDeletePopupComponent } from './compares-delete-dialog.component';
import { ICompares } from 'app/shared/model/compares.model';

@Injectable({ providedIn: 'root' })
export class ComparesResolve implements Resolve<ICompares> {
  constructor(private service: ComparesService) {}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<ICompares> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        filter((response: HttpResponse<Compares>) => response.ok),
        map((compares: HttpResponse<Compares>) => compares.body)
      );
    }
    return of(new Compares());
  }
}

export const comparesRoute: Routes = [
  {
    path: '',
    component: ComparesComponent,
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'epmresourcesApp.compares.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/view',
    component: ComparesDetailComponent,
    resolve: {
      compares: ComparesResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'epmresourcesApp.compares.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: ComparesUpdateComponent,
    resolve: {
      compares: ComparesResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'epmresourcesApp.compares.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/edit',
    component: ComparesUpdateComponent,
    resolve: {
      compares: ComparesResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'epmresourcesApp.compares.home.title'
    },
    canActivate: [UserRouteAccessService]
  }
];

export const comparesPopupRoute: Routes = [
  {
    path: ':id/delete',
    component: ComparesDeletePopupComponent,
    resolve: {
      compares: ComparesResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'epmresourcesApp.compares.home.title'
    },
    canActivate: [UserRouteAccessService],
    outlet: 'popup'
  }
];
