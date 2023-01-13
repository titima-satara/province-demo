package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.ProvincesRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ProvincesService {
    private final static String urlProvince = "https://raw.githubusercontent.com/kongvut/thai-province-data/master/api_province.json";
    private RestTemplate restTemplate = new RestTemplate();
    private HttpHeaders headers = new HttpHeaders();
    private HttpEntity<String> entity = new HttpEntity<>(headers);
    @Autowired
    private ProvincesRepository repository;

    public ResponseEntity<String> showDataJson(){
        return restTemplate.exchange(urlProvince, HttpMethod.GET, entity, String.class);
    }

    public int insertToJson(){
        int response = 0;
        String result = restTemplate.getForObject(urlProvince, String.class);
        List<ProvincesData> provincesDataList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        List<ProvincesToJson> results;
        try {
            results = mapper.readValue(result.toString(), new TypeReference<List<ProvincesToJson>>(){});
            for(ProvincesToJson thai_provinces : results){
                ProvincesData provincesData = new ProvincesData();
                provincesData.setId(String.valueOf(thai_provinces.getId()));
                provincesData.setName_th(thai_provinces.getName_th());
                provincesData.setName_en(thai_provinces.getName_en());
                provincesDataList.add(provincesData);
            }
            response = repository.insertToJson(provincesDataList);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return response;
    }
    public ResponseEntity<?> getAllProvinces() {
        try {
            List<ProvincesData> response = repository.getAllProvinces();
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            throw e;
        }
    }

    public ResponseEntity<?> getProvincesById(ProvincesIDRequest request) {
        if (request.getId() == null || request.getId().isEmpty()) {
            String response = "ไม่มี id ที่รับ";
            return ResponseEntity.ok(response);
        }
        try {
            List<ProvincesData> provincesDataList = repository.getAllProvinces();
            int chackID = 0;
            for(ProvincesData provincesData : provincesDataList){
                if(provincesDataList.get(chackID).getId().equals(request.getId())){
                    List<ProvincesData> response = (List<ProvincesData>) repository.getProvincesById(request);
                    return ResponseEntity.ok(response);
                }
                chackID++;
            }
            String response = "ไม่มี id ในฐานข้อมูล";
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            throw e;
        }
    }

    public ResponseEntity<?> getProvincesByNameTh(ProvincesNameThRequest request) {
        if (request.getName_th() == null || request.getName_th().isEmpty()) {
            String response = "ไม่มี Name_th ที่รับ";
            return ResponseEntity.ok(response);
        }
        try {
            List<ProvincesData> provincesDataList = repository.getAllProvinces();
            int chackTh = 0;
            for(ProvincesData provincesData : provincesDataList){
                if(provincesDataList.get(chackTh).getName_th().equals(request.getName_th())){
                    List<ProvincesData> response = (List<ProvincesData>) repository.getProvincesByNameTh(request);
                    return ResponseEntity.ok(response);
                }
                chackTh++;
            }
            String response = "ไม่มี Name_th ในฐานข้อมูล";
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            throw e;
        }
    }

    public ResponseEntity<?> getProvincesByNameEn(ProvincesNameEnRequest request) {
        if (request.getName_en() == null || request.getName_en().isEmpty()) {
            String response = "ไม่มี Name_en ที่รับ";
            return ResponseEntity.ok(response);
        }
        try {
            List<ProvincesData> provincesDataList = repository.getAllProvinces();
            int chackEn= 0;
            for(ProvincesData provincesData : provincesDataList){
                if(provincesDataList.get(chackEn).getName_en().equals(request.getName_en())){
                    List<ProvincesData> response = (List<ProvincesData>) repository.getProvincesByNameEn(request);
                    return ResponseEntity.ok(response);
                }
                chackEn++;
            }
            String response = "ไม่มี Name_en ในฐานข้อมูล";
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            throw e;
        }
    }

    public ResponseEntity<?> insertProvinces(ProvincesData request){

        if (request.getId() == null || request.getId().isEmpty()) {
            String response = "ไม่มี id ที่รับ";
            return ResponseEntity.ok(response);
        }
        else if (request.getName_th() == null || request.getName_th().isEmpty()) {
            String response = "ไม่มี NameTh ที่รับ";
            return ResponseEntity.ok(response);
        }
        else if (request.getName_en() == null || request.getName_en().isEmpty()) {
            String response = "ไม่มี NameEn ที่รับ";
            return ResponseEntity.ok(response);
        }
        else {
            try {
                List<ProvincesData> provincesDataList = repository.getAllProvinces();
                int chackId = 0;
                for(ProvincesData provincesData : provincesDataList){
                    if(provincesDataList.get(chackId).getId().equals(request.getId())){
                        String response = "มี id ในฐานข้อมูลแล้ว";
                        return ResponseEntity.ok(response);
                    }
                    chackId++;
                }
                return ResponseEntity.ok(repository.insertProvinces(request));
            } catch (Exception e) {
                throw e;
            }
        }
    }

    public ResponseEntity<?> updateProvinces(ProvincesData request){
        if (request.getId() == null || request.getId().isEmpty()) {
            String response = "ไม่มี id ที่รับ";
            return ResponseEntity.ok(response);
        }
        else if (request.getName_th() == null || request.getName_th().isEmpty()) {
            String response = "ไม่มี NameTh ที่รับ";
            return ResponseEntity.ok(response);
        }
        else if (request.getName_en() == null || request.getName_en().isEmpty()) {
            String response = "ไม่มี NameEn ที่รับ";
            return ResponseEntity.ok(response);
        }
        else {
            try {
                List<ProvincesData> provincesDataList = repository.getAllProvinces();
                int chackId = 0;
                for(ProvincesData provincesData : provincesDataList){
                    if(provincesDataList.get(chackId).getId().equals(request.getId())){
                        return ResponseEntity.ok(repository.updateProvinces(request));
                    }else {
                        chackId++;
                    }
                }
                String response = "ไม่มี id ในฐานข้อมูล";
                return ResponseEntity.ok(response);
            } catch (Exception e) {
                throw e;
            }
        }
    }

    public ResponseEntity<?> deleteProvincesById(ProvincesIDRequest request){
        if (request.getId() == null || request.getId().isEmpty()) {
            String response = "ไม่มี id ที่รับ";
            return ResponseEntity.ok(response);
        }
        else {
            try {
                List<ProvincesData> provincesDataList = repository.getAllProvinces();
                int chackID = 0;
                for(ProvincesData provincesData : provincesDataList){
                    if(provincesDataList.get(chackID).getId().equals(request.getId())){
                        return ResponseEntity.ok(repository.deleteProvincesById(request));
                    }
                    chackID++;
                }
                String response = "ไม่มี id ในฐานข้อมูล";
                return ResponseEntity.ok(response);
            } catch (Exception e) {
                throw e;
            }
        }
    }
}
