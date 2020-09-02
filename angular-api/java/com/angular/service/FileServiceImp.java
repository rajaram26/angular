package com.angular.service;

import java.io.InputStreamReader;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.angular.model.User;
import com.angular.repositary.UserRepositary;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

@Service
@Transactional
public class FileServiceImp{
	
	@Autowired
	private UserRepositary userrepositary;

	public boolean readDataFromCsv(MultipartFile file) {
		try {
			InputStreamReader reader = new InputStreamReader(file.getInputStream());
			CSVReader csvreader = new CSVReaderBuilder(reader).withSkipLines(1).build();
			List<String[]> rows = csvreader.readAll();
			for(String[] row : rows )
			{
				userrepositary.save(new User(row[0], row[1], row[2], row[3],row[4],row[5],row[6]));
			}
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
}
