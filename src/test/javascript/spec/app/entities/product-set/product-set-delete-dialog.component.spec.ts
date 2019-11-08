import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { EpmresourcesTestModule } from '../../../test.module';
import { ProductSetDeleteDialogComponent } from 'app/entities/product-set/product-set-delete-dialog.component';
import { ProductSetService } from 'app/entities/product-set/product-set.service';

describe('Component Tests', () => {
  describe('ProductSet Management Delete Component', () => {
    let comp: ProductSetDeleteDialogComponent;
    let fixture: ComponentFixture<ProductSetDeleteDialogComponent>;
    let service: ProductSetService;
    let mockEventManager: any;
    let mockActiveModal: any;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [EpmresourcesTestModule],
        declarations: [ProductSetDeleteDialogComponent]
      })
        .overrideTemplate(ProductSetDeleteDialogComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(ProductSetDeleteDialogComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(ProductSetService);
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
