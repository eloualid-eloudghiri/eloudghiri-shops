import {AbstractControl, FormGroup, ValidationErrors, ValidatorFn} from '@angular/forms';

export class PasswordValidators {
    private static lowerCasePattern = /[a-z]/;
    private static upperCasePattern = /[A-Z]/;
    private static numberPattern = /[0-9]/;
    private static specialCharPattern = /[=$@!%*?&]/;

    static areNotEqual(control: FormGroup): ValidationErrors | null {
        if (control.get('password').value !== control.get('repeat').value) {
            return {areNotEqual: true};
        }
        return null;
    }

    public static pattern(): ValidatorFn {
        return (control: AbstractControl): { [key: string]: any } => {
            const value = <string> control.value;
            return this.countPasswordValidationGroups(value) >= 3 ? null : {'pattern': {value}};
        }
    }

    private static countPasswordValidationGroups(password: string): number {
        let res = 0;
        res += this.lowerCasePattern.test(password) ? 1 : 0;
        res += this.upperCasePattern.test(password) ? 1 : 0;
        res += this.numberPattern.test(password) ? 1 : 0;
        res += this.specialCharPattern.test(password) ? 1 : 0;
        return res;
    }
}
