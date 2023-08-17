package com.sunbasedata.records.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
public class Jwt {
   private String access_token;

public String getAccess_token() {
	return access_token;
}

public void setAccess_token(String access_token) {
	this.access_token = access_token;
}

public Jwt(String access_token) {
	super();
	this.access_token = access_token;
}

public Jwt() {
	super();
	// TODO Auto-generated constructor stub
}
   
}
