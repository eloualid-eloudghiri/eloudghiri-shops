import { AbstractControl, ValidatorFn } from '@angular/forms';
export class TelephoneValidators {
    public static pattern(reg: RegExp): ValidatorFn {
        return (control: AbstractControl): { [key: string]: any } => {
            const value = <string>control.value;
            return !value ? null : value.match(reg) ? null : { 'pattern': { value } };
        }
    }

    public static portable(): ValidatorFn {
        return TelephoneValidators.pattern(/^(0|\+33)[6-79-9]([-. ]?[0-9]{2}){4}$/ig);
    }

    public static portableAndFixe(): ValidatorFn {
        return TelephoneValidators.pattern(/^(0|\+33)[1-79-9]([-. ]?[0-9]{2}){4}$/ig);
    }
}
