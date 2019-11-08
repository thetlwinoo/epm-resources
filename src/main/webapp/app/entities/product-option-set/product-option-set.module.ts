import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { EpmresourcesSharedModule } from 'app/shared/shared.module';
import { ProductOptionSetComponent } from './product-option-set.component';
import { ProductOptionSetDetailComponent } from './product-option-set-detail.component';
import { ProductOptionSetUpdateComponent } from './product-option-set-update.component';
import { ProductOptionSetDeletePopupComponent, ProductOptionSetDeleteDialogComponent } from './product-option-set-delete-dialog.component';
import { productOptionSetRoute, productOptionSetPopupRoute } from './product-option-set.route';

const ENTITY_STATES = [...productOptionSetRoute, ...productOptionSetPopupRoute];

@NgModule({
  imports: [EpmresourcesSharedModule, RouterModule.forChild(ENTITY_STATES)],
  declarations: [
    ProductOptionSetComponent,
    ProductOptionSetDetailComponent,
    ProductOptionSetUpdateComponent,
    ProductOptionSetDeleteDialogComponent,
    ProductOptionSetDeletePopupComponent
  ],
  entryComponents: [ProductOptionSetDeleteDialogComponent]
})
export class EpmresourcesProductOptionSetModule {}
