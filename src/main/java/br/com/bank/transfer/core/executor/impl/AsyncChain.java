package br.com.bank.transfer.core.executor.impl;

import br.com.bank.transfer.core.executor.Chain;
import br.com.bank.transfer.core.executor.Executor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@Builder
public class AsyncChain<T> extends Chain<T> implements Executor<T> {

    @Singular
    public List<Executor<T>> chains;

    public T execute(T input) {
        T output = input;
        try {
            output = this.executeHandler(beforeAll).apply(output);
            for (var operation : chains) {
                output = executeHandler(beforeEach)
                        .andThen(executeHandler(operation::execute))
                        .andThen(executeHandler(afterEach))
                        .apply(output);
            }
        } catch (Exception e) {
            executeHandler(errorHandler).apply(output);
        }
        return executeHandler(afterAll).apply(output);
    }
}
