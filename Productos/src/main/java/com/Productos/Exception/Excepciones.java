package com.Productos.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.Productos.dto.MensajeError;

@ControllerAdvice   
public class Excepciones {
   
    //Controla el error cuando el dato ingrsado no es un numero
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<MensajeError> ErrorTipoInvalido(MethodArgumentTypeMismatchException ex){
        String mensaje = "El dato ingresado " + ex.getValue() + " no es un valor valido como " + ex.getName();
        return ResponseEntity.badRequest().body(new MensajeError(mensaje));
    }

    //Controla otros errores genericos
    @ExceptionHandler(Exception.class)
    public ResponseEntity<MensajeError> manejarExcepcionGeneral(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body(new MensajeError("Ocurrió un error interno: " + ex.getMessage()));
    }
}
