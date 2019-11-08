import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { EpmresourcesSharedModule } from 'app/shared/shared.module';
import { PhotosComponent } from './photos.component';
import { PhotosDetailComponent } from './photos-detail.component';
import { PhotosUpdateComponent } from './photos-update.component';
import { PhotosDeletePopupComponent, PhotosDeleteDialogComponent } from './photos-delete-dialog.component';
import { photosRoute, photosPopupRoute } from './photos.route';

const ENTITY_STATES = [...photosRoute, ...photosPopupRoute];

@NgModule({
  imports: [EpmresourcesSharedModule, RouterModule.forChild(ENTITY_STATES)],
  declarations: [PhotosComponent, PhotosDetailComponent, PhotosUpdateComponent, PhotosDeleteDialogComponent, PhotosDeletePopupComponent],
  entryComponents: [PhotosDeleteDialogComponent]
})
export class EpmresourcesPhotosModule {}
