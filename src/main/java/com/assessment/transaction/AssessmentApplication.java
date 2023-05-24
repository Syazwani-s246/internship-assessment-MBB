package com.assessment.transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



@SpringBootApplication

public class AssessmentApplication {
    public static void main(String[] args) {
        // Specify the path to the text file
        String filePath = "dataSource.txt";

        // Read the records from the file using the FileReaderService
        List<Record> records = FileReaderService.readRecordsFromFile(filePath);

        // Display the extracted records
        for (Record record : records) {
            System.out.println(record);
        }

        // Run the Spring Boot application
        SpringApplication.run(AssessmentApplication.class, args);
    }

}