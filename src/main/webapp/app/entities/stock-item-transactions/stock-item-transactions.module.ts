import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { EpmresourcesSharedModule } from 'app/shared/shared.module';
import { StockItemTransactionsComponent } from './stock-item-transactions.component';
import { StockItemTransactionsDetailComponent } from './stock-item-transactions-detail.component';
import { StockItemTransactionsUpdateComponent } from './stock-item-transactions-update.component';
import {
  StockItemTransactionsDeletePopupComponent,
  StockItemTransactionsDeleteDialogComponent
} from './stock-item-transactions-delete-dialog.component';
import { stockItemTransactionsRoute, stockItemTransactionsPopupRoute } from './stock-item-transactions.route';

const ENTITY_STATES = [...stockItemTransactionsRoute, ...stockItemTransactionsPopupRoute];

@NgModule({
  imports: [EpmresourcesSharedModule, RouterModule.forChild(ENTITY_STATES)],
  declarations: [
    StockItemTransactionsComponent,
    StockItemTransactionsDetailComponent,
    StockItemTransactionsUpdateComponent,
    StockItemTransactionsDeleteDialogComponent,
    StockItemTransactionsDeletePopupComponent
  ],
  entryComponents: [StockItemTransactionsDeleteDialogComponent]
})
export class EpmresourcesStockItemTransactionsModule {}
