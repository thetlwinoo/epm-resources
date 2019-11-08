import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IWishlistProducts } from 'app/shared/model/wishlist-products.model';
import { WishlistProductsService } from './wishlist-products.service';

@Component({
  selector: 'jhi-wishlist-products-delete-dialog',
  templateUrl: './wishlist-products-delete-dialog.component.html'
})
export class WishlistProductsDeleteDialogComponent {
  wishlistProducts: IWishlistProducts;

  constructor(
    protected wishlistProductsService: WishlistProductsService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  clear() {
    this.activeModal.dismiss('cancel');
  }

  confirmDelete(id: number) {
    this.wishlistProductsService.delete(id).subscribe(response => {
      this.eventManager.broadcast({
        name: 'wishlistProductsListModification',
        content: 'Deleted an wishlistProducts'
      });
      this.activeModal.dismiss(true);
    });
  }
}

@Component({
  selector: 'jhi-wishlist-products-delete-popup',
  template: ''
})
export class WishlistProductsDeletePopupComponent implements OnInit, OnDestroy {
  protected ngbModalRef: NgbModalRef;

  constructor(protected activatedRoute: ActivatedRoute, protected router: Router, protected modalService: NgbModal) {}

  ngOnInit() {
    this.activatedRoute.data.subscribe(({ wishlistProducts }) => {
      setTimeout(() => {
        this.ngbModalRef = this.modalService.open(WishlistProductsDeleteDialogComponent as Component, { size: 'lg', backdrop: 'static' });
        this.ngbModalRef.componentInstance.wishlistProducts = wishlistProducts;
        this.ngbModalRef.result.then(
          result => {
            this.router.navigate(['/wishlist-products', { outlets: { popup: null } }]);
            this.ngbModalRef = null;
          },
          reason => {
            this.router.navigate(['/wishlist-products', { outlets: { popup: null } }]);
            this.ngbModalRef = null;
          }
        );
      }, 0);
    });
  }

  ngOnDestroy() {
    this.ngbModalRef = null;
  }
}
