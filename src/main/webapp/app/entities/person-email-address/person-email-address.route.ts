import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { Observable, of } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { PersonEmailAddress } from 'app/shared/model/person-email-address.model';
import { PersonEmailAddressService } from './person-email-address.service';
import { PersonEmailAddressComponent } from './person-email-address.component';
import { PersonEmailAddressDetailComponent } from './person-email-address-detail.component';
import { PersonEmailAddressUpdateComponent } from './person-email-address-update.component';
import { PersonEmailAddressDeletePopupComponent } from './person-email-address-delete-dialog.component';
import { IPersonEmailAddress } from 'app/shared/model/person-email-address.model';

@Injectable({ providedIn: 'root' })
export class PersonEmailAddressResolve implements Resolve<IPersonEmailAddress> {
  constructor(private service: PersonEmailAddressService) {}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<IPersonEmailAddress> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        filter((response: HttpResponse<PersonEmailAddress>) => response.ok),
        map((personEmailAddress: HttpResponse<PersonEmailAddress>) => personEmailAddress.body)
      );
    }
    return of(new PersonEmailAddress());
  }
}

export const personEmailAddressRoute: Routes = [
  {
    path: '',
    component: PersonEmailAddressComponent,
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'epmresourcesApp.personEmailAddress.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/view',
    component: PersonEmailAddressDetailComponent,
    resolve: {
      personEmailAddress: PersonEmailAddressResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'epmresourcesApp.personEmailAddress.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: PersonEmailAddressUpdateComponent,
    resolve: {
      personEmailAddress: PersonEmailAddressResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'epmresourcesApp.personEmailAddress.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/edit',
    component: PersonEmailAddressUpdateComponent,
    resolve: {
      personEmailAddress: PersonEmailAddressResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'epmresourcesApp.personEmailAddress.home.title'
    },
    canActivate: [UserRouteAccessService]
  }
];

export const personEmailAddressPopupRoute: Routes = [
  {
    path: ':id/delete',
    component: PersonEmailAddressDeletePopupComponent,
    resolve: {
      personEmailAddress: PersonEmailAddressResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'epmresourcesApp.personEmailAddress.home.title'
    },
    canActivate: [UserRouteAccessService],
    outlet: 'popup'
  }
];
