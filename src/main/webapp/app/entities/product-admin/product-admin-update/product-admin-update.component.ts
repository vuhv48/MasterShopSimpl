import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'jhi-product-admin-update',
  templateUrl: './product-admin-update.component.html',
  styleUrls: ['./product-admin-update.component.scss'],
})
export class ProductAdminUpdateComponent implements OnInit {
  // isSaving = false;
  // editForm = this.fb.group({
  //   id: [],
  //   address: [],
  //   phone: [],
  // });

  constructor() {
    console.log('okok');
  }
  // protected productAdminService: ProductAdminService, protected activatedRoute: ActivatedRoute, protected fb: FormBuilder
  ngOnInit(): void {
    console.log('okok');
  }
  // previousState(): void {
  //   window.history.back();
  // }
  // save(): void {
  //   this.isSaving = true;
  //   const student = this.createFromForm();
  //   if (student.id !== undefined) {
  //     this.subscribeToSaveResponse(this.productAdminService.update(student));
  //   } else {
  //     this.subscribeToSaveResponse(this.productAdminService.create(student));
  //   }
  // }

  // protected subscribeToSaveResponse(result: Observable<HttpResponse<IStudent>>): void {
  //   result.pipe(finalize(() => this.onSaveFinalize())).subscribe({
  //     next: () => this.onSaveSuccess(),
  //     error: () => this.onSaveError(),
  //   });
  // }

  // protected onSaveSuccess(): void {
  //   this.previousState();
  // }

  // protected onSaveError(): void {
  //   // Api for inheritance.
  // }

  // protected onSaveFinalize(): void {
  //   this.isSaving = false;
  // }

  // protected updateForm(student: IStudent): void {
  //   this.editForm.patchValue({
  //     id: student.id,
  //     address: student.address,
  //     phone: student.phone,
  //   });
  // }

  // protected createFromForm(): IStudent {
  //   return {
  //     ...new Student(),
  //     id: this.editForm.get(['id'])!.value,
  //     address: this.editForm.get(['address'])!.value,
  //     phone: this.editForm.get(['phone'])!.value,
  //   };
  // }
}
