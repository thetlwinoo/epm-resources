import { Component, OnInit } from '@angular/core';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { JhiAlertService } from 'ng-jhipster';
import { IProductCategory, ProductCategory } from 'app/shared/model/product-category.model';
import { ProductCategoryService } from './product-category.service';

@Component({
  selector: 'jhi-product-category-update',
  templateUrl: './product-category-update.component.html'
})
export class ProductCategoryUpdateComponent implements OnInit {
  isSaving: boolean;

  productcategories: IProductCategory[];

  editForm = this.fb.group({
    id: [],
    name: [null, [Validators.required]],
    shortLabel: [],
    thumbnailUrl: [],
    parentId: []
  });

  constructor(
    protected jhiAlertService: JhiAlertService,
    protected productCategoryService: ProductCategoryService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit() {
    this.isSaving = false;
    this.activatedRoute.data.subscribe(({ productCategory }) => {
      this.updateForm(productCategory);
    });
    this.productCategoryService
      .query()
      .pipe(
        filter((mayBeOk: HttpResponse<IProductCategory[]>) => mayBeOk.ok),
        map((response: HttpResponse<IProductCategory[]>) => response.body)
      )
      .subscribe((res: IProductCategory[]) => (this.productcategories = res), (res: HttpErrorResponse) => this.onError(res.message));
  }

  updateForm(productCategory: IProductCategory) {
    this.editForm.patchValue({
      id: productCategory.id,
      name: productCategory.name,
      shortLabel: productCategory.shortLabel,
      thumbnailUrl: productCategory.thumbnailUrl,
      parentId: productCategory.parentId
    });
  }

  previousState() {
    window.history.back();
  }

  save() {
    this.isSaving = true;
    const productCategory = this.createFromForm();
    if (productCategory.id !== undefined) {
      this.subscribeToSaveResponse(this.productCategoryService.update(productCategory));
    } else {
      this.subscribeToSaveResponse(this.productCategoryService.create(productCategory));
    }
  }

  private createFromForm(): IProductCategory {
    return {
      ...new ProductCategory(),
      id: this.editForm.get(['id']).value,
      name: this.editForm.get(['name']).value,
      shortLabel: this.editForm.get(['shortLabel']).value,
      thumbnailUrl: this.editForm.get(['thumbnailUrl']).value,
      parentId: this.editForm.get(['parentId']).value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IProductCategory>>) {
    result.subscribe(() => this.onSaveSuccess(), () => this.onSaveError());
  }

  protected onSaveSuccess() {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError() {
    this.isSaving = false;
  }
  protected onError(errorMessage: string) {
    this.jhiAlertService.error(errorMessage, null, null);
  }

  trackProductCategoryById(index: number, item: IProductCategory) {
    return item.id;
  }
}
