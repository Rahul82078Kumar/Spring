package com.nt.service;

import java.util.List;

import com.nt.Entity.Tourist;


public interface ITouristMgmtService {
     public   String  registerTourist(Tourist tourist);
     public List<Tourist> fetchAllTOurist();
  }