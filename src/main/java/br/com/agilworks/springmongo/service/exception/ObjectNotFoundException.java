package br.com.agilworks.springmongo.service.exception;

// Não exige que o compilador trate a exceção
public class ObjectNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ObjectNotFoundException(String message) {
        super(message);
    }
}
