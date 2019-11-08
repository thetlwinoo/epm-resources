import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { Observable, of } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { SystemParameters } from 'app/shared/model/system-parameters.model';
import { SystemParametersService } from './system-parameters.service';
import { SystemParametersComponent } from './system-parameters.component';
import { SystemParametersDetailComponent } from './system-parameters-detail.component';
import { SystemParametersUpdateComponent } from './system-parameters-update.component';
import { SystemParametersDeletePopupComponent } from './system-parameters-delete-dialog.component';
import { ISystemParameters } from 'app/shared/model/system-parameters.model';

@Injectable({ providedIn: 'root' })
export class SystemParametersResolve implements Resolve<ISystemParameters> {
  constructor(private service: SystemParametersService) {}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<ISystemParameters> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        filter((response: HttpResponse<SystemParameters>) => response.ok),
        map((systemParameters: HttpResponse<SystemParameters>) => systemParameters.body)
      );
    }
    return of(new SystemParameters());
  }
}

export const systemParametersRoute: Routes = [
  {
    path: '',
    component: SystemParametersComponent,
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'epmresourcesApp.systemParameters.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/view',
    component: SystemParametersDetailComponent,
    resolve: {
      systemParameters: SystemParametersResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'epmresourcesApp.systemParameters.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: SystemParametersUpdateComponent,
    resolve: {
      systemParameters: SystemParametersResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'epmresourcesApp.systemParameters.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/edit',
    component: SystemParametersUpdateComponent,
    resolve: {
      systemParameters: SystemParametersResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'epmresourcesApp.systemParameters.home.title'
    },
    canActivate: [UserRouteAccessService]
  }
];

export const systemParametersPopupRoute: Routes = [
  {
    path: ':id/delete',
    component: SystemParametersDeletePopupComponent,
    resolve: {
      systemParameters: SystemParametersResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'epmresourcesApp.systemParameters.home.title'
    },
    canActivate: [UserRouteAccessService],
    outlet: 'popup'
  }
];
