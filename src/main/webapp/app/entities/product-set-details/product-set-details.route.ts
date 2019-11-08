import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { Observable, of } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { ProductSetDetails } from 'app/shared/model/product-set-details.model';
import { ProductSetDetailsService } from './product-set-details.service';
import { ProductSetDetailsComponent } from './product-set-details.component';
import { ProductSetDetailsDetailComponent } from './product-set-details-detail.component';
import { ProductSetDetailsUpdateComponent } from './product-set-details-update.component';
import { ProductSetDetailsDeletePopupComponent } from './product-set-details-delete-dialog.component';
import { IProductSetDetails } from 'app/shared/model/product-set-details.model';

@Injectable({ providedIn: 'root' })
export class ProductSetDetailsResolve implements Resolve<IProductSetDetails> {
  constructor(private service: ProductSetDetailsService) {}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<IProductSetDetails> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        filter((response: HttpResponse<ProductSetDetails>) => response.ok),
        map((productSetDetails: HttpResponse<ProductSetDetails>) => productSetDetails.body)
      );
    }
    return of(new ProductSetDetails());
  }
}

export const productSetDetailsRoute: Routes = [
  {
    path: '',
    component: ProductSetDetailsComponent,
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'epmresourcesApp.productSetDetails.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/view',
    component: ProductSetDetailsDetailComponent,
    resolve: {
      productSetDetails: ProductSetDetailsResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'epmresourcesApp.productSetDetails.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: ProductSetDetailsUpdateComponent,
    resolve: {
      productSetDetails: ProductSetDetailsResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'epmresourcesApp.productSetDetails.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/edit',
    component: ProductSetDetailsUpdateComponent,
    resolve: {
      productSetDetails: ProductSetDetailsResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'epmresourcesApp.productSetDetails.home.title'
    },
    canActivate: [UserRouteAccessService]
  }
];

export const productSetDetailsPopupRoute: Routes = [
  {
    path: ':id/delete',
    component: ProductSetDetailsDeletePopupComponent,
    resolve: {
      productSetDetails: ProductSetDetailsResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'epmresourcesApp.productSetDetails.home.title'
    },
    canActivate: [UserRouteAccessService],
    outlet: 'popup'
  }
];
