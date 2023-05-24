package com.assessment.transaction;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RecordService {

    private final List<Record> records = new ArrayList<>();

    public List<Record> getAllRecords() {
        return records;
    }

    public Record getRecordById(int id) {
        // Find the record by its ID
        for (Record record : records) {
            if (record.getCustomerId() == id) {
                return record;
            }
        }
        // If no record is found with the given ID, return null
        return null;
    }

    public Record createRecord(Record record) {
        // Generate a new ID for the record
        int newId = generateNewId();

        // Set the ID for the record
        record.setCustomerId(newId);

        // Add the record to the list
        records.add(record);

        return record;
    }

    public Record updateRecord(int id, Record updatedRecord) {
        // Find the record by its ID
        for (Record record : records) {
            if (record.getCustomerId() == id) { // Use getCustomerId() instead of getId()
                // Check if the version of the updated record matches the current version of the record
                if (record.getVersion() != updatedRecord.getVersion()) {
                    throw new RuntimeException("Concurrent update detected. Please refresh the record and try again.");
                }

                // Update the fields of the found record with the data from updatedRecord
                record.setAccountNumber(updatedRecord.getAccountNumber());
                record.setTrxAmount(updatedRecord.getTrxAmount());
                record.setDescription(updatedRecord.getDescription());
                record.setTrxDate(updatedRecord.getTrxDate());
                record.setTrxTime(updatedRecord.getTrxTime());

                // Increment the version of the record
                record.setVersion(record.getVersion() + 1);

                return record;
            }
        }
        // If no record is found, return null
        return null;
    }



    public void deleteRecord(int id) {
        // Find the record by its ID
        Record foundRecord = null;
        for (Record record : records) {
            if (record.getCustomerId() == id) {
                foundRecord = record;
                break;
            }
        }
        // If a record is found, remove it from the list
        if (foundRecord != null) {
            records.remove(foundRecord);
        }
    }

    public List<Record> searchRecords(String keyword) {
        List<Record> searchResults = new ArrayList<>();
        for (Record record : records) {
            if (String.valueOf(record.getCustomerId()).contains(keyword)
                    || String.valueOf(record.getAccountNumber()).contains(keyword)
                    || record.getDescription().contains(keyword)) {
                searchResults.add(record);
            }
        }
        return searchResults;
    }




    public List<Record> getRecordsByPage(int page, int size) {
        // Implement logic to retrieve records by page and size for pagination
        int startIndex = (page - 1) * size;
        int endIndex = Math.min(startIndex + size, records.size());
        return records.subList(startIndex, endIndex);
    }

    private int generateNewId() {
        // Generate a new unique ID for a record

        // generate a new ID by incrementing the last ID by 1
        if (records.isEmpty()) {
            return 1;
        }
        Record lastRecord = records.get(records.size() - 1);
        int lastId = lastRecord.getCustomerId();
        return lastId + 1;
    }
}
