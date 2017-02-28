package com.poc;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.InputStream;

public class JsonValidator {
    public static void main (String args[]) {
        try (InputStream inputStream = new FileInputStream("D:/Projects/PoCs/jsonvalidator/resources/schema.json")) {
            JSONObject rawSchema = new JSONObject(new JSONTokener(inputStream));
            Schema schema = SchemaLoader.load(rawSchema);
            schema.validate(new JSONObject(new JSONTokener(new FileInputStream("D:/Projects/PoCs/jsonvalidator/resources/test.json")))); // throws a ValidationException if this object is invalid
        } catch (Exception e) {
            // prints #/rectangle/a: -5.0 is not higher or equal to 0
            System.out.println(e.getMessage());
        }
    }
}