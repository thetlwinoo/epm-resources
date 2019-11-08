import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { Observable, of } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { ReviewLines } from 'app/shared/model/review-lines.model';
import { ReviewLinesService } from './review-lines.service';
import { ReviewLinesComponent } from './review-lines.component';
import { ReviewLinesDetailComponent } from './review-lines-detail.component';
import { ReviewLinesUpdateComponent } from './review-lines-update.component';
import { ReviewLinesDeletePopupComponent } from './review-lines-delete-dialog.component';
import { IReviewLines } from 'app/shared/model/review-lines.model';

@Injectable({ providedIn: 'root' })
export class ReviewLinesResolve implements Resolve<IReviewLines> {
  constructor(private service: ReviewLinesService) {}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<IReviewLines> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        filter((response: HttpResponse<ReviewLines>) => response.ok),
        map((reviewLines: HttpResponse<ReviewLines>) => reviewLines.body)
      );
    }
    return of(new ReviewLines());
  }
}

export const reviewLinesRoute: Routes = [
  {
    path: '',
    component: ReviewLinesComponent,
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'epmresourcesApp.reviewLines.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/view',
    component: ReviewLinesDetailComponent,
    resolve: {
      reviewLines: ReviewLinesResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'epmresourcesApp.reviewLines.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: ReviewLinesUpdateComponent,
    resolve: {
      reviewLines: ReviewLinesResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'epmresourcesApp.reviewLines.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/edit',
    component: ReviewLinesUpdateComponent,
    resolve: {
      reviewLines: ReviewLinesResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'epmresourcesApp.reviewLines.home.title'
    },
    canActivate: [UserRouteAccessService]
  }
];

export const reviewLinesPopupRoute: Routes = [
  {
    path: ':id/delete',
    component: ReviewLinesDeletePopupComponent,
    resolve: {
      reviewLines: ReviewLinesResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'epmresourcesApp.reviewLines.home.title'
    },
    canActivate: [UserRouteAccessService],
    outlet: 'popup'
  }
];
