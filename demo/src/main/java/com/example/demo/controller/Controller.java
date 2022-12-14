package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.TestService;

@RestController
public class Controller {
	
	@Autowired
	TestService testService;
	
	@RequestMapping(value = "/1", method = RequestMethod.GET)
	@ResponseBody
	public void read() {
		
		Workbook wb;
		try {
			
			wb = testService.getWorkbook("C:\\Users\\USER\\Desktop\\活頁簿1.xlsx");
					
			Sheet sheet = wb.getSheetAt(0);		
			Row row = sheet.getRow(0);		
			Cell cell = row.getCell(1);		
			
			System.out.println(testService.getCellType(cell));
				
			testService.insertDate(testService.getCellType(cell));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
				
	}
	
	
	@RequestMapping(value = "/2", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getData(@RequestParam String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			
			System.out.println(id);			
			map.put("id", id);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
				
		return map;
	}

}
