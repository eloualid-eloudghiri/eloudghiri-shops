import {AbstractControl, ValidationErrors, ValidatorFn, Validators} from '@angular/forms';

export class EmailOrEmptyValidators {
    public static emailOrEmpty(control: AbstractControl): ValidationErrors | null {
        return control.value === '' ? null : Validators.email(control);
    }
}
