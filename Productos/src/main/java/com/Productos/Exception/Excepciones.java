package com.Productos.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.Productos.dto.MensajeError;

@RestControllerAdvice
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
                             .body(new MensajeError("Ocurrió un error en el sistema: " + ex.getMessage()));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<MensajeError> manejarRuntime(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                         .body(new MensajeError("Ocurrio un error en el sistema" + ex.getMessage()));
}

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errores = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errores.put(error.getField(), error.getDefaultMessage());
        });

        return ResponseEntity.badRequest().body(errores);
    }
}
