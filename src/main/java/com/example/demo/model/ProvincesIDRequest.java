package com.example.demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class ProvincesIDRequest {
    public String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
