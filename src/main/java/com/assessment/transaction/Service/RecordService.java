package com.assessment.transaction.Service;

import com.assessment.transaction.Model.Record;
import com.assessment.transaction.Repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.time.*;
import java.time.format.DateTimeParseException;
import java.util.*;

@Service
@Transactional
public class RecordService {
    private RecordRepository recordRepository;

    @Autowired
    public RecordService(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    public String importFile(MultipartFile file) {
//        String filePath = "dataSource.txt";

        try {
            // Create a list to hold the parsed records
            List<Record> records = new ArrayList<>();

            // Read the file line by line
            BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
            String line;

            reader.readLine();
            while ((line = reader.readLine()) != null) {
                // Process the line
                // Split the line by the '|' separator
                String[] values = line.split("\\|");

                // Create a new record object and populate its fields
                Record record = new Record();

                record.setAccountNumber(Long.parseLong(values[0]));
                record.setTrxAmount(Double.parseDouble(values[1]));
                record.setDescription(values[2]);
                record.setTrxDate(values[3]);
                record.setTrxTime(values[4]);
                record.setCustomerId(Integer.parseInt(values[5]));

                // Add the record to the list
                records.add(record);
            }

            // Save the records to the database
            recordRepository.saveAll(records);

            return "File imported successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "File import failed";
        }

    }


    private boolean isValidDate(String str) {
        try {
            LocalDate.parse(str);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public void createRecords(List<Record> records) {
        recordRepository.saveAll(records);
    }

    public List<Record> getAllRecords() {
        return recordRepository.findAll();
    }

    public Record getRecordById(long id) {
        Optional<Record> optionalRecord = recordRepository.findById(id);
        return optionalRecord.orElse(null);
    }

    public List<Record> searchRecords(Integer customerId, Long accountNumber, String description) {
        List<Record> records = new ArrayList<>();

        // Search by customer ID
        if (customerId != null) {
            List<Record> customerRecords = recordRepository.findByCustomerId(customerId);
            records.addAll(customerRecords);
        }

        // Search by account number
        if (accountNumber != null) {
            List<Record> accountRecords = recordRepository.findByAccountNumber(accountNumber);
            records.addAll(accountRecords);
        }

        // Search by description
        if (description != null) {
            List<Record> descriptionRecords = recordRepository.findByDescriptionContaining(description);
            records.addAll(descriptionRecords);
        }

        return records;
    }

    public boolean updateRecordDescription(long id, String description) {
        Optional<Record> optionalRecord = recordRepository.findById(id);
        if (optionalRecord.isPresent()) {
            Record record = optionalRecord.get();
            record.setDescription(description);
            recordRepository.save(record);
            return true;
        }
        return false;
    }

    public Record createRecord(Record record) {
        return recordRepository.save(record);
    }

    public boolean deleteRecord(long id) {
        Optional<Record> optionalRecord = recordRepository.findById(id);
        if (optionalRecord.isPresent()) {
            recordRepository.delete(optionalRecord.get());
            return true;
        }
        return false;
    }

    //pagination
    public Page<Record> getAllRecords(Pageable pageable) {
        return recordRepository.findAll(pageable);
    }
}
