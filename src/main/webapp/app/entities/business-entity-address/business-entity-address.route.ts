import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { Observable, of } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { BusinessEntityAddress } from 'app/shared/model/business-entity-address.model';
import { BusinessEntityAddressService } from './business-entity-address.service';
import { BusinessEntityAddressComponent } from './business-entity-address.component';
import { BusinessEntityAddressDetailComponent } from './business-entity-address-detail.component';
import { BusinessEntityAddressUpdateComponent } from './business-entity-address-update.component';
import { BusinessEntityAddressDeletePopupComponent } from './business-entity-address-delete-dialog.component';
import { IBusinessEntityAddress } from 'app/shared/model/business-entity-address.model';

@Injectable({ providedIn: 'root' })
export class BusinessEntityAddressResolve implements Resolve<IBusinessEntityAddress> {
  constructor(private service: BusinessEntityAddressService) {}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<IBusinessEntityAddress> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        filter((response: HttpResponse<BusinessEntityAddress>) => response.ok),
        map((businessEntityAddress: HttpResponse<BusinessEntityAddress>) => businessEntityAddress.body)
      );
    }
    return of(new BusinessEntityAddress());
  }
}

export const businessEntityAddressRoute: Routes = [
  {
    path: '',
    component: BusinessEntityAddressComponent,
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'epmresourcesApp.businessEntityAddress.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/view',
    component: BusinessEntityAddressDetailComponent,
    resolve: {
      businessEntityAddress: BusinessEntityAddressResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'epmresourcesApp.businessEntityAddress.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: BusinessEntityAddressUpdateComponent,
    resolve: {
      businessEntityAddress: BusinessEntityAddressResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'epmresourcesApp.businessEntityAddress.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/edit',
    component: BusinessEntityAddressUpdateComponent,
    resolve: {
      businessEntityAddress: BusinessEntityAddressResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'epmresourcesApp.businessEntityAddress.home.title'
    },
    canActivate: [UserRouteAccessService]
  }
];

export const businessEntityAddressPopupRoute: Routes = [
  {
    path: ':id/delete',
    component: BusinessEntityAddressDeletePopupComponent,
    resolve: {
      businessEntityAddress: BusinessEntityAddressResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'epmresourcesApp.businessEntityAddress.home.title'
    },
    canActivate: [UserRouteAccessService],
    outlet: 'popup'
  }
];
