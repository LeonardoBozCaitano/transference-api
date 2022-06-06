package br.com.bank.transfer.core.executor;

public interface Executor<T> {
    T execute(T input);
}
