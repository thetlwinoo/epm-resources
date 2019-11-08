import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { EpmresourcesSharedModule } from 'app/shared/shared.module';
import { AddressesComponent } from './addresses.component';
import { AddressesDetailComponent } from './addresses-detail.component';
import { AddressesUpdateComponent } from './addresses-update.component';
import { AddressesDeletePopupComponent, AddressesDeleteDialogComponent } from './addresses-delete-dialog.component';
import { addressesRoute, addressesPopupRoute } from './addresses.route';

const ENTITY_STATES = [...addressesRoute, ...addressesPopupRoute];

@NgModule({
  imports: [EpmresourcesSharedModule, RouterModule.forChild(ENTITY_STATES)],
  declarations: [
    AddressesComponent,
    AddressesDetailComponent,
    AddressesUpdateComponent,
    AddressesDeleteDialogComponent,
    AddressesDeletePopupComponent
  ],
  entryComponents: [AddressesDeleteDialogComponent]
})
export class EpmresourcesAddressesModule {}
