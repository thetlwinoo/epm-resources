import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { EpmresourcesSharedModule } from 'app/shared/shared.module';
import { ProductsComponent } from './products.component';
import { ProductsDetailComponent } from './products-detail.component';
import { ProductsUpdateComponent } from './products-update.component';
import { ProductsDeletePopupComponent, ProductsDeleteDialogComponent } from './products-delete-dialog.component';
import { productsRoute, productsPopupRoute } from './products.route';

const ENTITY_STATES = [...productsRoute, ...productsPopupRoute];

@NgModule({
  imports: [EpmresourcesSharedModule, RouterModule.forChild(ENTITY_STATES)],
  declarations: [
    ProductsComponent,
    ProductsDetailComponent,
    ProductsUpdateComponent,
    ProductsDeleteDialogComponent,
    ProductsDeletePopupComponent
  ],
  entryComponents: [ProductsDeleteDialogComponent]
})
export class EpmresourcesProductsModule {}
