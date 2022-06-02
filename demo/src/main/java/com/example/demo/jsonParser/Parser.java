package com.example.demo.jsonParser;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Parser {
    MainParser mainParser;
    public Parser() throws Exception {
        File file = new File("src/main/java/com/example/demo/jsonParser/data.json").getAbsoluteFile();
        this.mainParser = new ObjectMapper().readValue(file, MainParser.class);
    }
    public MainParser getData(){
        return this.mainParser;
    }
}
