package com.dalrun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.dalrun.service.AdminService;

@RestController
public class AdminController {
	@Autowired
	AdminService service;
	
}
