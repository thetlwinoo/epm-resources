import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { Observable, of } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { AddressTypes } from 'app/shared/model/address-types.model';
import { AddressTypesService } from './address-types.service';
import { AddressTypesComponent } from './address-types.component';
import { AddressTypesDetailComponent } from './address-types-detail.component';
import { AddressTypesUpdateComponent } from './address-types-update.component';
import { AddressTypesDeletePopupComponent } from './address-types-delete-dialog.component';
import { IAddressTypes } from 'app/shared/model/address-types.model';

@Injectable({ providedIn: 'root' })
export class AddressTypesResolve implements Resolve<IAddressTypes> {
  constructor(private service: AddressTypesService) {}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<IAddressTypes> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        filter((response: HttpResponse<AddressTypes>) => response.ok),
        map((addressTypes: HttpResponse<AddressTypes>) => addressTypes.body)
      );
    }
    return of(new AddressTypes());
  }
}

export const addressTypesRoute: Routes = [
  {
    path: '',
    component: AddressTypesComponent,
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'epmresourcesApp.addressTypes.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/view',
    component: AddressTypesDetailComponent,
    resolve: {
      addressTypes: AddressTypesResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'epmresourcesApp.addressTypes.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: AddressTypesUpdateComponent,
    resolve: {
      addressTypes: AddressTypesResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'epmresourcesApp.addressTypes.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/edit',
    component: AddressTypesUpdateComponent,
    resolve: {
      addressTypes: AddressTypesResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'epmresourcesApp.addressTypes.home.title'
    },
    canActivate: [UserRouteAccessService]
  }
];

export const addressTypesPopupRoute: Routes = [
  {
    path: ':id/delete',
    component: AddressTypesDeletePopupComponent,
    resolve: {
      addressTypes: AddressTypesResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'epmresourcesApp.addressTypes.home.title'
    },
    canActivate: [UserRouteAccessService],
    outlet: 'popup'
  }
];
