package com.ase.budgetase.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class UtilService extends CustomResponse {


  String getCustomSucessResponse(CustomResponse obj) {

    return "{content:{" + obj + "},status:true }";
  }

  public static LocalDateTime getDatetime() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    return LocalDateTime.parse(LocalDateTime.now().toString(), formatter);
  }


  public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseObj) {
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("message", message);
    map.put("status", status.value());

    if (responseObj == null) {
      map.put("error", message);
    } else {
      map.put("content", responseObj);
    }


    return new ResponseEntity<Object>(map, status);
  }
}
