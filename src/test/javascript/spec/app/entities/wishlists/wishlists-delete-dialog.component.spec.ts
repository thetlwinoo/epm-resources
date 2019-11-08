import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { EpmresourcesTestModule } from '../../../test.module';
import { WishlistsDeleteDialogComponent } from 'app/entities/wishlists/wishlists-delete-dialog.component';
import { WishlistsService } from 'app/entities/wishlists/wishlists.service';

describe('Component Tests', () => {
  describe('Wishlists Management Delete Component', () => {
    let comp: WishlistsDeleteDialogComponent;
    let fixture: ComponentFixture<WishlistsDeleteDialogComponent>;
    let service: WishlistsService;
    let mockEventManager: any;
    let mockActiveModal: any;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [EpmresourcesTestModule],
        declarations: [WishlistsDeleteDialogComponent]
      })
        .overrideTemplate(WishlistsDeleteDialogComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(WishlistsDeleteDialogComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(WishlistsService);
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
