import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { EpmresourcesSharedModule } from 'app/shared/shared.module';
import { PersonPhoneComponent } from './person-phone.component';
import { PersonPhoneDetailComponent } from './person-phone-detail.component';
import { PersonPhoneUpdateComponent } from './person-phone-update.component';
import { PersonPhoneDeletePopupComponent, PersonPhoneDeleteDialogComponent } from './person-phone-delete-dialog.component';
import { personPhoneRoute, personPhonePopupRoute } from './person-phone.route';

const ENTITY_STATES = [...personPhoneRoute, ...personPhonePopupRoute];

@NgModule({
  imports: [EpmresourcesSharedModule, RouterModule.forChild(ENTITY_STATES)],
  declarations: [
    PersonPhoneComponent,
    PersonPhoneDetailComponent,
    PersonPhoneUpdateComponent,
    PersonPhoneDeleteDialogComponent,
    PersonPhoneDeletePopupComponent
  ],
  entryComponents: [PersonPhoneDeleteDialogComponent]
})
export class EpmresourcesPersonPhoneModule {}
