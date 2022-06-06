package br.com.bank.transfer.core.executor;

import java.util.Objects;
import java.util.function.UnaryOperator;

public class Chain<T> {

    protected UnaryOperator<T> errorHandler;

    protected UnaryOperator<T> beforeEach;

    protected UnaryOperator<T> afterEach;

    protected UnaryOperator<T> beforeAll;

    protected UnaryOperator<T> afterAll;

    protected UnaryOperator<T> executeHandler(UnaryOperator<T> execute) {
        return (T input) -> {
            try {
                return Objects.isNull(execute) ? input : execute.apply(input);
            } catch (Exception e) {
                e.printStackTrace();
                throw e;
            }
        };
    }
}
