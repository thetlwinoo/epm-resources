import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { EpmresourcesSharedModule } from 'app/shared/shared.module';
import { BarcodeTypesComponent } from './barcode-types.component';
import { BarcodeTypesDetailComponent } from './barcode-types-detail.component';
import { BarcodeTypesUpdateComponent } from './barcode-types-update.component';
import { BarcodeTypesDeletePopupComponent, BarcodeTypesDeleteDialogComponent } from './barcode-types-delete-dialog.component';
import { barcodeTypesRoute, barcodeTypesPopupRoute } from './barcode-types.route';

const ENTITY_STATES = [...barcodeTypesRoute, ...barcodeTypesPopupRoute];

@NgModule({
  imports: [EpmresourcesSharedModule, RouterModule.forChild(ENTITY_STATES)],
  declarations: [
    BarcodeTypesComponent,
    BarcodeTypesDetailComponent,
    BarcodeTypesUpdateComponent,
    BarcodeTypesDeleteDialogComponent,
    BarcodeTypesDeletePopupComponent
  ],
  entryComponents: [BarcodeTypesDeleteDialogComponent]
})
export class EpmresourcesBarcodeTypesModule {}
