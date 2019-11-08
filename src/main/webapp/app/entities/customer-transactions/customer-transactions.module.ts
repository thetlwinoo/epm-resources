import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { EpmresourcesSharedModule } from 'app/shared/shared.module';
import { CustomerTransactionsComponent } from './customer-transactions.component';
import { CustomerTransactionsDetailComponent } from './customer-transactions-detail.component';
import { CustomerTransactionsUpdateComponent } from './customer-transactions-update.component';
import {
  CustomerTransactionsDeletePopupComponent,
  CustomerTransactionsDeleteDialogComponent
} from './customer-transactions-delete-dialog.component';
import { customerTransactionsRoute, customerTransactionsPopupRoute } from './customer-transactions.route';

const ENTITY_STATES = [...customerTransactionsRoute, ...customerTransactionsPopupRoute];

@NgModule({
  imports: [EpmresourcesSharedModule, RouterModule.forChild(ENTITY_STATES)],
  declarations: [
    CustomerTransactionsComponent,
    CustomerTransactionsDetailComponent,
    CustomerTransactionsUpdateComponent,
    CustomerTransactionsDeleteDialogComponent,
    CustomerTransactionsDeletePopupComponent
  ],
  entryComponents: [CustomerTransactionsDeleteDialogComponent]
})
export class EpmresourcesCustomerTransactionsModule {}
