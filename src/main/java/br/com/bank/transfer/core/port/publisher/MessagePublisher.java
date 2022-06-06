package br.com.bank.transfer.core.port.publisher;

public interface MessagePublisher {
    void sendProcessTransferenceMessage(String transferenceId);
}
