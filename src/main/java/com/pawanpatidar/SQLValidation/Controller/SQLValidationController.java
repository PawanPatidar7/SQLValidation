package com.pawanpatidar.SQLValidation.Controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pawanpatidar.SQLValidation.Services.SQLValidationService;

import net.sf.jsqlparser.util.validation.ValidationError;

@RestController
@RequestMapping("/sqlValidation")
public class SQLValidationController {
  
	
	@Autowired
	private SQLValidationService sqlValidationService; 
	
	 @PostMapping("/validate")
	    public ResponseEntity<List<ValidationError>> validateSQL(@RequestParam("sql") String sqlQuery) {

		 List<ValidationError> errorMessages = sqlValidationService.validateSQL(sqlQuery);

	        return new ResponseEntity<>(errorMessages, HttpStatus.OK);
	    }
	 
	 @GetMapping("/checker")
	 public ResponseEntity<List<ValidationError>> checkQuery(@RequestParam("sql") String sqlQuery) {
		 
		 List<ValidationError> result= sqlValidationService.validateSqlQuery(sqlQuery);
		 
		 return new ResponseEntity<>(result, HttpStatus.OK);
	 }
}
