package com.pawanpatidar.SQLValidation.Services;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.Data;
import lombok.Getter;
import net.sf.jsqlparser.statement.Statements;
import net.sf.jsqlparser.util.validation.Validation;
import net.sf.jsqlparser.util.validation.ValidationError;
import net.sf.jsqlparser.util.validation.ValidationException;
import net.sf.jsqlparser.util.validation.feature.DatabaseType;
import net.sf.jsqlparser.util.validation.feature.FeaturesAllowed;

@Service
@Data
@Getter
public class SQLValidationService {

	
	public List<ValidationError> validateSQL(String sqlQuery) {
       
        List<DatabaseType> databases = Arrays.asList( DatabaseType.POSTGRESQL);

        Validation validation = new Validation(databases, sqlQuery);
        List<ValidationError> errors = validation.validate();
//        for(ValidationError err : errors) {
//        	System.out.println("```````````````````````````````````````````````````");
//        	for(ValidationException exc : err.getErrors()) {
//        		System.out.println(exc.toString());
//        	}
//        }
        return errors;
    }
	
	
	public List<ValidationError> validateSqlQuery(String sqlQuery) {
	  
	    Validation validation = new Validation(Arrays.asList(FeaturesAllowed.SELECT), sqlQuery);
	        
	    List<ValidationError> errors = validation.validate();
	    
//	    for(ValidationError err : errors) {
//        	System.out.println("```````````````````````````````````````````````````");
//        	for(ValidationException exc : err.getErrors()) {
//        		System.out.println(exc.toString());
//        	}
//        }
	    
	    return errors;
	    
	}
	
}
	    
	    
	    
//	    for(ValidationError err : errors) {
//	    	System.err.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//	    	for(ValidationException exc : err.getErrors()) {
//	    		System.err.println(exc.toString());
//	    	}
//	    }
//	   
//	    if (errors.isEmpty()) {
//	        Statements statements = validation.getParsedStatements();
//	        return "SQL query is valid. Parsed Statements: " + statements.toString();
//	    }
//	    
//	    else {
//	    	return "Invalid Query";
//	    }
//	}
//
//}





// for more validations :- https://github.com/JSQLParser/JSqlParser/wiki/Examples-of-SQL-Validation



