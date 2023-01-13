package com.example.demo.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Entity;

@Getter
@Setter

@Data

@Entity
@Table(name = "thai_provinces")
public class ProvincesData {
    @Id
    public String id;
    public String name_th;
    public String name_en;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName_th() {
		return name_th;
	}
	public void setName_th(String name_th) {
		this.name_th = name_th;
	}
	public String getName_en() {
		return name_en;
	}
	public void setName_en(String name_en) {
		this.name_en = name_en;
	}
}