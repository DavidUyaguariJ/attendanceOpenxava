package com.tuempresa.attendance.utils;

import java.lang.annotation.*;

import javax.validation.*;

@Documented
@Constraint(validatedBy = CedulaEcuatorianaValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface CedulaEcuatoriana {

    String message() default "La cédula ecuatoriana no es válida";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}