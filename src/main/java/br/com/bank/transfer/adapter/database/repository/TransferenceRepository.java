package br.com.bank.transfer.adapter.database.repository;

import br.com.bank.transfer.adapter.database.entity.TransferenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferenceRepository extends JpaRepository<TransferenceEntity, String> {

}