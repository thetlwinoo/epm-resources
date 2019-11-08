import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { EpmresourcesTestModule } from '../../../test.module';
import { ProductOptionSetDeleteDialogComponent } from 'app/entities/product-option-set/product-option-set-delete-dialog.component';
import { ProductOptionSetService } from 'app/entities/product-option-set/product-option-set.service';

describe('Component Tests', () => {
  describe('ProductOptionSet Management Delete Component', () => {
    let comp: ProductOptionSetDeleteDialogComponent;
    let fixture: ComponentFixture<ProductOptionSetDeleteDialogComponent>;
    let service: ProductOptionSetService;
    let mockEventManager: any;
    let mockActiveModal: any;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [EpmresourcesTestModule],
        declarations: [ProductOptionSetDeleteDialogComponent]
      })
        .overrideTemplate(ProductOptionSetDeleteDialogComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(ProductOptionSetDeleteDialogComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(ProductOptionSetService);
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
