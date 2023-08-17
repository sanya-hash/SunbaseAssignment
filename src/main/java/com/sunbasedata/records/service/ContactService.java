package com.sunbasedata.records.service;

import com.sunbasedata.records.entity.Contact;

public interface ContactService {
	Contact[] getContacts(String token) ;
	void deleteContact(String id,String token);
	String addContact(Contact c,String token);
	String updateContact(Contact c, String token, String uuid);
}
