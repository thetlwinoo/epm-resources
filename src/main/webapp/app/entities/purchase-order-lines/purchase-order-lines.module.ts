import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { EpmresourcesSharedModule } from 'app/shared/shared.module';
import { PurchaseOrderLinesComponent } from './purchase-order-lines.component';
import { PurchaseOrderLinesDetailComponent } from './purchase-order-lines-detail.component';
import { PurchaseOrderLinesUpdateComponent } from './purchase-order-lines-update.component';
import {
  PurchaseOrderLinesDeletePopupComponent,
  PurchaseOrderLinesDeleteDialogComponent
} from './purchase-order-lines-delete-dialog.component';
import { purchaseOrderLinesRoute, purchaseOrderLinesPopupRoute } from './purchase-order-lines.route';

const ENTITY_STATES = [...purchaseOrderLinesRoute, ...purchaseOrderLinesPopupRoute];

@NgModule({
  imports: [EpmresourcesSharedModule, RouterModule.forChild(ENTITY_STATES)],
  declarations: [
    PurchaseOrderLinesComponent,
    PurchaseOrderLinesDetailComponent,
    PurchaseOrderLinesUpdateComponent,
    PurchaseOrderLinesDeleteDialogComponent,
    PurchaseOrderLinesDeletePopupComponent
  ],
  entryComponents: [PurchaseOrderLinesDeleteDialogComponent]
})
export class EpmresourcesPurchaseOrderLinesModule {}
