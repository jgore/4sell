package pl.goreit.sell.domain;

public class DomainException extends Exception {

    public DomainException(ExceptionCode exceptionCode) {
        super(exceptionCode.getMessage());
    }
}
