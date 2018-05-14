package org.nobleprog.camel.errorhandling.onexception.handling;


public class TestOrderNotSupportedExccption extends RuntimeException {
    public TestOrderNotSupportedExccption(String message) {
        super(message);
    }
}
