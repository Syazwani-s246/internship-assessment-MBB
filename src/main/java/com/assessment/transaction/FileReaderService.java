package com.assessment.transaction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderService {

    public static List<Record> readRecordsFromFile(String filePath) {
        List<Record> records = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean firstLine = true; // Flag to skip the first line (header)
            int version = 1; // Initial version for records

            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue; // Skip the header line
                }

                // Assuming the text file has a specific format, split the line by a delimiter
                String[] parts = line.split("\\|");

                // Extract the relevant information from the line
//                int accountNumber = Integer.parseInt(parts[0]);
                long accountNumber = Long.parseLong(parts[0]);

                double trxAmount = Double.parseDouble(parts[1]);
                String description = parts[2];
                String trxDate = parts[3];
                String trxTime = parts[4];
                int customerId = Integer.parseInt(parts[5]);

                // Create a new record object with the version
                Record record = new Record((int) accountNumber, trxAmount, description, trxDate, trxTime, customerId, version);
                records.add(record);

                // Increment the version for the next record
                version++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return records;
    }
}
