package com.prunny.exception;

import lombok.Data;

@Data
public class CategoryServiceCustomException extends RuntimeException {

	 private String errorCode;
	
	   public CategoryServiceCustomException(String message, String errorCode) {
		  
	        super(message);
	        this.errorCode = errorCode;
	    }
}