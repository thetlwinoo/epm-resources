import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { Observable, of } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { PhoneNumberType } from 'app/shared/model/phone-number-type.model';
import { PhoneNumberTypeService } from './phone-number-type.service';
import { PhoneNumberTypeComponent } from './phone-number-type.component';
import { PhoneNumberTypeDetailComponent } from './phone-number-type-detail.component';
import { PhoneNumberTypeUpdateComponent } from './phone-number-type-update.component';
import { PhoneNumberTypeDeletePopupComponent } from './phone-number-type-delete-dialog.component';
import { IPhoneNumberType } from 'app/shared/model/phone-number-type.model';

@Injectable({ providedIn: 'root' })
export class PhoneNumberTypeResolve implements Resolve<IPhoneNumberType> {
  constructor(private service: PhoneNumberTypeService) {}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<IPhoneNumberType> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        filter((response: HttpResponse<PhoneNumberType>) => response.ok),
        map((phoneNumberType: HttpResponse<PhoneNumberType>) => phoneNumberType.body)
      );
    }
    return of(new PhoneNumberType());
  }
}

export const phoneNumberTypeRoute: Routes = [
  {
    path: '',
    component: PhoneNumberTypeComponent,
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'epmresourcesApp.phoneNumberType.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/view',
    component: PhoneNumberTypeDetailComponent,
    resolve: {
      phoneNumberType: PhoneNumberTypeResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'epmresourcesApp.phoneNumberType.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: PhoneNumberTypeUpdateComponent,
    resolve: {
      phoneNumberType: PhoneNumberTypeResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'epmresourcesApp.phoneNumberType.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/edit',
    component: PhoneNumberTypeUpdateComponent,
    resolve: {
      phoneNumberType: PhoneNumberTypeResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'epmresourcesApp.phoneNumberType.home.title'
    },
    canActivate: [UserRouteAccessService]
  }
];

export const phoneNumberTypePopupRoute: Routes = [
  {
    path: ':id/delete',
    component: PhoneNumberTypeDeletePopupComponent,
    resolve: {
      phoneNumberType: PhoneNumberTypeResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'epmresourcesApp.phoneNumberType.home.title'
    },
    canActivate: [UserRouteAccessService],
    outlet: 'popup'
  }
];
