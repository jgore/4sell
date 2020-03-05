package pl.goreit.sell.domain;

public enum ExceptionCode {

    FOR_SELL_01("4SELL.01", "Product does not exist"),
    FOR_SELL_02("4SELL.02", "Category does not exist");

    private final String message;
    private String code;

    private ExceptionCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }
}
