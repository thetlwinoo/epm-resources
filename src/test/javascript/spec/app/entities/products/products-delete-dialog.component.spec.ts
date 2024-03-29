import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { EpmresourcesTestModule } from '../../../test.module';
import { ProductsDeleteDialogComponent } from 'app/entities/products/products-delete-dialog.component';
import { ProductsService } from 'app/entities/products/products.service';

describe('Component Tests', () => {
  describe('Products Management Delete Component', () => {
    let comp: ProductsDeleteDialogComponent;
    let fixture: ComponentFixture<ProductsDeleteDialogComponent>;
    let service: ProductsService;
    let mockEventManager: any;
    let mockActiveModal: any;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [EpmresourcesTestModule],
        declarations: [ProductsDeleteDialogComponent]
      })
        .overrideTemplate(ProductsDeleteDialogComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(ProductsDeleteDialogComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(ProductsService);
      mockEventManager = fixture.debugElement.injector.get(JhiEventManager);
      mockActiveModal = fixture.debugElement.injector.get(NgbActiveModal);
    });

    describe('confirmDelete', () => {
      it('Should call delete service on confirmDelete', inject(
        [],
        fakeAsync(() => {
          // GIVEN
          spyOn(service, 'delete').and.returnValue(of({}));

          // WHEN
          comp.confirmDelete(123);
          tick();

          // THEN
          expect(service.delete).toHaveBeenCalledWith(123);
          expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
          expect(mockEventManager.broadcastSpy).toHaveBeenCalled();
        })
      ));
    });
  });
});
