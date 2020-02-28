package com.sai.spring;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;

public class Main {

	public static final String FILE_NAME = "employee.avro";

	public static void main(String[] args) throws IOException {
		Employee employee = new Employee();
		employee.setAddress("Hyderabad");
		employee.setId(200);
		employee.setName("sai");
		
		
		Employee employee2 = new Employee();
		employee2.setAddress("Nizamabad");
		employee2.setId(100);
		employee2.setName("sai kumar");
		
		append(FILE_NAME, Arrays.asList(employee,employee2));
		read(FILE_NAME);
	}

	public static void write(String filename, List<Employee> employees) throws IOException {
		DatumWriter<Employee> empDatumWriter = new SpecificDatumWriter<>(Employee.class);
		try (DataFileWriter<Employee> empFileWriter = new DataFileWriter<>(empDatumWriter)) {
			empFileWriter.create(Employee.SCHEMA$, new File(filename));
			employees.forEach(employee -> {
				try {
					empFileWriter.append(employee);
				} catch (IOException e) {
					
				}
			});
		}
	}
	
	public static void append(String filename, List<Employee> employees) throws IOException {
		DatumWriter<Employee> empDatumWriter = new SpecificDatumWriter<>(Employee.class);
		try (DataFileWriter<Employee> empFileWriter = new DataFileWriter<>(empDatumWriter)) {
			empFileWriter.appendTo(new File(filename));
			employees.forEach(employee -> {
				try {
					empFileWriter.append(employee);
				} catch (IOException e) {
					
				}
			});
		}
	}
	
	
	public static void read(String filename) throws IOException {
		DatumReader<Employee> empDatumReader = new SpecificDatumReader<>(Employee.class);
		try (DataFileReader<Employee> dataFileReader = new DataFileReader<>(new File(filename),
				empDatumReader)) {
			Employee employee1 = null;
			while (dataFileReader.hasNext()) {
				employee1 = dataFileReader.next(employee1);
				System.out.println(employee1);
			}
		}
	}

}
