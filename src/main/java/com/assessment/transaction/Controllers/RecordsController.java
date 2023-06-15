package com.assessment.transaction.Controllers;

import com.assessment.transaction.Model.Record;
import com.assessment.transaction.Service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RecordsController {

    private final RecordService recordService;

    @Autowired
    public RecordsController(RecordService recordService) {
        this.recordService = recordService;
    }

    @GetMapping("/welcome")
    public String getPage() {
        return "Hello!";
    }

    @PostMapping("/import")
    public ResponseEntity<String> importFile(@RequestParam("file") MultipartFile file) {
        String message = recordService.importFile(file);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Record>> getAllRecords() {
        List<Record> records = recordService.getAllRecords();
        return ResponseEntity.ok(records);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Record> getRecordById(@PathVariable("id") long id) {
        Record record = recordService.getRecordById(id);
        if (record != null) {
            return ResponseEntity.ok(record);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<Record>> searchRecords(@RequestParam(required = false) Integer customerId,
                                                      @RequestParam(required = false) Long accountNumber,
                                                      @RequestParam(required = false) String description) {
        List<Record> records = recordService.searchRecords(customerId, accountNumber, description);
        if (!records.isEmpty()) {
            return ResponseEntity.ok(records);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    @PutMapping("update/{id}")
    public ResponseEntity<String> updateRecordDescription(
            @PathVariable("id") long id,
            @RequestParam("description") String description) {
        boolean updated = recordService.updateRecordDescription(id, description);
        if (updated) {
            return ResponseEntity.ok("Record description updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Record> createRecord(@RequestBody Record record) {
        Record createdRecord = recordService.createRecord(record);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRecord);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteRecord(@PathVariable("id") long id) {
        boolean deleted = recordService.deleteRecord(id);
        if (deleted) {
            return ResponseEntity.ok("Record deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/getByPage")
    public ResponseEntity<List<Record>> getRecordsByPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        PageRequest pageable = PageRequest.of(page, size);
        Page<Record> recordPage = recordService.getAllRecords(pageable);
        List<Record> records = recordPage.getContent();

        return ResponseEntity.ok(records);
    }

}
