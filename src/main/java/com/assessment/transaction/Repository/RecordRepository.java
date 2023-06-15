package com.assessment.transaction.Repository;

import com.assessment.transaction.Model.Record;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {

    List<Record> findByCustomerId(Integer customerId);

    List<Record> findByAccountNumber(Long accountNumber);

    List<Record> findByDescriptionContaining(String description);

    Page<Record> findAll(Pageable pageable);
//    public Page<Record> getAllRecords(Pageable pageable) {
//        return recordRepository.findAll(pageable);
//    }
}
