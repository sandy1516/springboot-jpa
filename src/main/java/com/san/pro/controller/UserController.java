package com.san.pro.controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.san.pro.model.User;
import com.san.pro.repositories.UserRepository;

@RestController
public class UserController {
	
	@Autowired
    private UserRepository testRepository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody User writreUserToFile() {
		User user = new User();
        try {
        	//Getting data from data base
        	user = testRepository.findByName("sandy");
    		
    		//Writing data into text file
            String file = "D:\\abc.txt"; 
        	FileWriter fw = new FileWriter(file);
        	BufferedWriter bw = new BufferedWriter(fw);
        	bw.write(user.toString());
            bw.close();  
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(user.equals(null)) {
        	System.out.println("no user");
        }
        return user;
    }
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
    public @ResponseBody List<User> writreAllToFile() {
		List<User> users = new ArrayList<User>();
        try {
        	//Getting data from data base
        	users = testRepository.findAll();
        	
        	//Writing data into text file
        	String file = "D:\\abc.txt"; 
        	FileWriter fw = new FileWriter(file);
        	BufferedWriter bw = new BufferedWriter(fw);
        	
        	for (User user : users) {
        		bw.write(user.toString());
        		bw.write("\n");
			}    		            
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
}
