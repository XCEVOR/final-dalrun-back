package com.dalrun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dalrun.dao.AdminDao;

@Service
@Transactional
public class AdminService {
	@Autowired
	AdminDao dao;
}
