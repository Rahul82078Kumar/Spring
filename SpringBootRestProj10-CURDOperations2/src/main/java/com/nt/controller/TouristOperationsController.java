package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.Entity.Tourist;
import com.nt.service.ITouristMgmtService;

@RestController
@RequestMapping("/tourist")
public class TouristOperationsController {
	@Autowired
	 private ITouristMgmtService  service;
	
	@PostMapping("/register")
	public ResponseEntity<String>  enrollTourist(@RequestBody Tourist tourist){
		try {
		//use service
		String resultMsg=service.registerTourist(tourist);
		 return  new ResponseEntity<String>(resultMsg,
				                                                                     HttpStatus.CREATED); //201 content created successfully 
		}
		catch(Exception e) {
			e.printStackTrace();
			return  new ResponseEntity<String>("problem in tourist enrollment",
                    HttpStatus.INTERNAL_SERVER_ERROR); //500 error
		}
		
	}
	
	
		@GetMapping("/fetch")
		public ResponseEntity<?> fetchAllTOurist(){
			
			try {
					List<Tourist> list = service.fetchAllTOurist();
					return new 	ResponseEntity<List<Tourist>>(list,HttpStatus.OK);
			}
			catch(Exception e) {
				e.printStackTrace();
				return new ResponseEntity<String>("Problem in fetching Tourists",HttpStatus.INTERNAL_SERVER_ERROR);
			}
		
		

	}
}