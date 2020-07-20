package com.mhcl.minibook.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReadFileUtil {
	private static final Logger logger 
	  = LoggerFactory.getLogger(ReadFileUtil.class);

	public static List<String> readFile(String fileName) throws Exception {
		List<String> fileArray = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				fileArray.add(sCurrentLine);
			}

		} catch (IOException e) {
			logger.info("File I/O Exception " + e);
			throw new Exception();
		}
		return fileArray;
	}

	public static void main(String[] args) {

		 

	}

}
