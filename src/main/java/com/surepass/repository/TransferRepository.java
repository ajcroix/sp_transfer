package com.surepass.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.surepass.domain.Transfer;

public interface TransferRepository extends JpaRepository<Transfer, Long>{

}
