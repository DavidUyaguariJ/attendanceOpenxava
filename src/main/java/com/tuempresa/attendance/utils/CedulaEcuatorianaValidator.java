package com.tuempresa.attendance.utils;

import javax.validation.*;

public class CedulaEcuatorianaValidator implements ConstraintValidator<CedulaEcuatoriana, String> {

    @Override
    public boolean isValid(String cedula, ConstraintValidatorContext context) {

        if (cedula == null || !cedula.matches("\\d{10}")) {
            return false;
        }

        int provincia = Integer.parseInt(cedula.substring(0, 2));
        int tercerDigito = Character.getNumericValue(cedula.charAt(2));

        if (provincia < 1 || provincia > 24 || tercerDigito >= 6) {
            return false;
        }

        int[] coeficientes = {2,1,2,1,2,1,2,1,2};
        int suma = 0;

        for (int i = 0; i < 9; i++) {
            int valor = Character.getNumericValue(cedula.charAt(i)) * coeficientes[i];
            suma += (valor >= 10) ? valor - 9 : valor;
        }

        int digitoVerificador = (10 - (suma % 10)) % 10;
        int ultimoDigito = Character.getNumericValue(cedula.charAt(9));

        return digitoVerificador == ultimoDigito;
    }
}