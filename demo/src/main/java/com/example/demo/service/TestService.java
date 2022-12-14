package com.example.demo.service;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TestDao;

@Service("TestService")
public class TestService {
	
	@Autowired
	TestDao dao;
		
	public void insertDate(String data) throws Exception {		
		dao.insert(data);;
	}
	
	
	public Workbook getWorkbook(String path) throws Exception {
		Workbook wb = null;
		if(path == null) return null;
		String extString = path.substring(path.lastIndexOf("."));
		InputStream is = new FileInputStream(path);
		if(".xls".equals(extString)){
		    wb = new HSSFWorkbook(is);
		}else if(".xlsx".equals(extString)){
		    wb = new XSSFWorkbook(is);
		}
		return wb;
	}
	
	
	public String getCellType(Cell cell) throws Exception  {
		String tmp = "";
		if (cell.getCellType() == CellType.STRING) {
			tmp = cell.getStringCellValue();
	    } else if (cell.getCellType() == CellType.NUMERIC) {
	    	tmp = cell.getNumericCellValue() + "";
	    }
		return tmp;
	}

}
