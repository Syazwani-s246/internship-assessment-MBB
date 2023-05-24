package com.assessment.transaction;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/records")
public class RecordsController {

    private final RecordService recordService;

    public RecordsController(RecordService recordService) {
        this.recordService = recordService;
    }

    /**
     * Get all records.
     *
     * @return List of all records.
     */
    @GetMapping
    public List<Record> getAllRecords() {
        return recordService.getAllRecords();
    }

    /**
     * Get a record by its ID.
     *
     * @param id The ID of the record.
     * @return The record with the specified ID.
     */
    @GetMapping("/{id}")
    public Record getRecordById(@PathVariable("id") int id) {
        return recordService.getRecordById(id);
    }

    /**
     * Create a new record.
     *
     * @param record The record to create.
     * @return The created record.
     */
    @PostMapping
    public Record createRecord(@RequestBody Record record) {
        return recordService.createRecord(record);
    }

    /**
     * Update an existing record.
     *
     * @param id     The ID of the record to update.
     * @param record The updated record data.
     * @return The updated record.
     */
    @PutMapping("/{id}")
    public Record updateRecord(@PathVariable("id") int id, @RequestBody Record record) {
        return recordService.updateRecord(id, record);
    }

    /**
     * Delete a record by its ID.
     *
     * @param id The ID of the record to delete.
     */
    @DeleteMapping("/{id}")
    public void deleteRecord(@PathVariable("id") int id) {
        recordService.deleteRecord(id);
    }

    /**
     * Search records based on a keyword.
     *
     * @param keyword The keyword to search for.
     * @return List of records matching the keyword.
     */
    @GetMapping("/search")
    public List<Record> searchRecords(@RequestParam("keyword") String keyword) {
        return recordService.searchRecords(keyword);
    }

    /**
     * Get records by page and size for pagination.
     *
     * @param page The page number.
     * @param size The number of records per page.
     * @return List of records for the specified page.
     */
    @GetMapping("/page")
    public List<Record> getRecordsByPage(@RequestParam("page") int page, @RequestParam("size") int size) {
        return recordService.getRecordsByPage(page, size);
    }
}


