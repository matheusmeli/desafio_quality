package br.com.mercadolivre.desafioquality.exceptions;

public class ErrorDetail {

    private String message;
    private String field;
    private String rejectedValue;

    public ErrorDetail(String message, String field, String rejectedValue) {
        this.message = message;
        this.field = field;
        this.rejectedValue = rejectedValue;
    }

    public ErrorDetail(){}

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRejectedValue() {
        return rejectedValue;
    }

    public void setRejectedValue(String rejectedValue) {
        this.rejectedValue = rejectedValue;
    }
}
