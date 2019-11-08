import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { EpmresourcesSharedModule } from 'app/shared/shared.module';
import { WishlistsComponent } from './wishlists.component';
import { WishlistsDetailComponent } from './wishlists-detail.component';
import { WishlistsUpdateComponent } from './wishlists-update.component';
import { WishlistsDeletePopupComponent, WishlistsDeleteDialogComponent } from './wishlists-delete-dialog.component';
import { wishlistsRoute, wishlistsPopupRoute } from './wishlists.route';

const ENTITY_STATES = [...wishlistsRoute, ...wishlistsPopupRoute];

@NgModule({
  imports: [EpmresourcesSharedModule, RouterModule.forChild(ENTITY_STATES)],
  declarations: [
    WishlistsComponent,
    WishlistsDetailComponent,
    WishlistsUpdateComponent,
    WishlistsDeleteDialogComponent,
    WishlistsDeletePopupComponent
  ],
  entryComponents: [WishlistsDeleteDialogComponent]
})
export class EpmresourcesWishlistsModule {}
