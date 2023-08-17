package com.sunbasedata.records.service;


import com.sunbasedata.records.entity.Jwt;
import com.sunbasedata.records.entity.User;


public interface LoginService {

	Jwt loginUser(User user);
}
