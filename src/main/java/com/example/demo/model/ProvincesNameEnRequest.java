package com.example.demo.model;

import lombok.Data;

@Data
public class ProvincesNameEnRequest {
    public String name_en;

	public String getName_en() {
		return name_en;
	}

	public void setName_en(String name_en) {
		this.name_en = name_en;
	}
}
