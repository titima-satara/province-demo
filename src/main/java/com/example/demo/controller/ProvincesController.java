package com.example.demo.controller;

import com.example.demo.model.ProvincesData;
import com.example.demo.model.ProvincesIDRequest;
import com.example.demo.model.ProvincesNameEnRequest;
import com.example.demo.model.ProvincesNameThRequest;
import com.example.demo.service.ProvincesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/information")
public class ProvincesController {
    @Autowired
    private ProvincesService service;

    //ดูข้อมูลในไฟล์ json
    @GetMapping(value = "/get/json")
    public ResponseEntity<String> showDataJson() {
        return service.showDataJson();
    }

    //เพิ่มข้อมูลจากไฟล์ json ลง database
    @GetMapping(value = "/insert/json")
    public int insertToJson() {
        return service.insertToJson();
    }

    //ดูข้อมูลจังหวัดทั้งหมดใน database
    @GetMapping(value = "/get/provincesAll")
    public ResponseEntity<?> getAllProvinces() {
        return ResponseEntity.ok(service.getAllProvinces());
    }

    //ดูข้อมูลจังหวัดตาม id
    @GetMapping(value = "/get/provincesById")
    public ResponseEntity<?> getProvincesById(@RequestBody ProvincesIDRequest request) {
        return ResponseEntity.ok(service.getProvincesById(request));
    }

    //ดูข้อมูลจังหวัดตาม NameTh
    @GetMapping(value = "/get/provincesByNameTh")
    public ResponseEntity<?> getProvincesByNameTh(@RequestBody ProvincesNameThRequest request) {
        return ResponseEntity.ok(service.getProvincesByNameTh(request));
    }

    //ดูข้อมูลจังหวัดตาม NameEn
    @GetMapping(value = "/get/provincesByNameEn")
    public ResponseEntity<?> getProvincesByNameEn(@RequestBody ProvincesNameEnRequest request) {
        return ResponseEntity.ok(service.getProvincesByNameEn(request));
    }

    //เพิ่มข้อมูลจังหวัดใหม่ ลง database
    @PostMapping(value = "/inser/provinces")
    public ResponseEntity<?> insertProvinces(@RequestBody ProvincesData request){
        return ResponseEntity.ok(service.insertProvinces(request));
    }

    //แก้ไขข้อมูลใน database by id
    @PostMapping(value = "/update/provinces")
    public ResponseEntity<?> updateProvinces(@RequestBody ProvincesData request){
        return ResponseEntity.ok(service.updateProvinces(request));
    }

    //ลบข้อมูลใน database by id
    @DeleteMapping(value = "/delete/provincesById")
    public ResponseEntity<?> deleteProvincesById(@RequestBody ProvincesIDRequest request){
        return ResponseEntity.ok(service.deleteProvincesById(request));
    }

    //แก้ไขข้อมูลใน database by id
    @PostMapping(value = "/receive/provinces", consumes = "application/x-www-form-urlencoded")
    public String receiveData(ProvincesData request){
        return request.toString();
    }
}
