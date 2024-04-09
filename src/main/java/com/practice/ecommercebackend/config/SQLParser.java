package com.practice.ecommercebackend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.FileCopyUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SQLParser {


    public static void main(String[] args) {
        String filePath = "/db.changelog/changes/refresh-database-with-4-categories.sql";
        SQLParser sqlParser = new SQLParser();
        String sqlContent = null;
        sqlParser.extractInsertQueries(sqlContent);
    }

    private String readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }

    private void extractInsertQueries(String sqlContent) {
        Pattern pattern = Pattern.compile("(?i)INSERT\\s+INTO\\s+.*?\\((.*?)\\)\\s+VALUES\\s*\\((.*?)\\);", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(sqlContent);
        
        while (matcher.find()) {
            String columns = matcher.group(1);
            String values = matcher.group(2);
            
            System.out.println("Insert query:");
            System.out.println("Columns: " + columns);
            System.out.println("Values: " + values);
            System.out.println();
        }
    }
}
