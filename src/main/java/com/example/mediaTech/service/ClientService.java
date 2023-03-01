package com.example.mediaTech.service;

import com.example.mediaTech.dto.ClientRequestDto;
import com.example.mediaTech.dto.ClientResponseDto;

import java.util.List;

public interface ClientService {


ClientResponseDto save(ClientRequestDto clientRequestDto);
ClientResponseDto findById(Integer id);
ClientResponseDto findByFirstName(String firstName);
void delete(Integer id);


ClientResponseDto update(ClientRequestDto clientRequestDto, Integer id);
List<ClientResponseDto> findAll();


}
