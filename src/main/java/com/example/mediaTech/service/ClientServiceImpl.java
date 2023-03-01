package com.example.mediaTech.service;

import com.example.mediaTech.dao.ClientDao;
import com.example.mediaTech.dto.ClientRequestDto;
import com.example.mediaTech.dto.ClientResponseDto;
import com.example.mediaTech.models.ClientEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService{
    private ClientDao clientDao;
    private ModelMapper modelMapper;


    public ClientServiceImpl(ClientDao clientDao, ModelMapper modelMapper) {
        this.clientDao = clientDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public ClientResponseDto save(ClientRequestDto clientRequestDto) {

        ClientEntity clientEntity=modelMapper.map(clientRequestDto,ClientEntity.class);
        ClientEntity saved=clientDao.save(clientEntity);
        return modelMapper.map(saved, ClientResponseDto.class);
    }

    @Override
    public ClientResponseDto findById(Integer id) {

        ClientEntity clientEntity = clientDao.findById(id).orElseThrow(()->new RuntimeException("client not found"));
        return modelMapper.map(clientEntity, ClientResponseDto.class);

    }

    @Override
    public ClientResponseDto findByFirstName(String firstName) {
        ClientEntity clientEntity = clientDao.findByFirstName(firstName);
        return modelMapper.map(clientEntity,ClientResponseDto.class);
    }

    @Override
    public void delete(Integer id) {
        clientDao.deleteById(id);

    }

    @Override
    public ClientResponseDto update(ClientRequestDto clientRequestDto, Integer id) {
        Optional<ClientEntity> clientEntityOptional = clientDao.findById(id);

        if (clientEntityOptional.isPresent()) {
            ClientEntity clientEntity = modelMapper.map(clientRequestDto, ClientEntity.class);
            clientEntity.setId(id);
            ClientEntity updated = clientDao.save(clientEntity);
            return modelMapper.map(updated, ClientResponseDto.class);
        } else {
             return null;
        }


    }


    @Override
    public List<ClientResponseDto> findAll() {
        return clientDao.findAll()
                .stream().map(el -> modelMapper.map(el, ClientResponseDto.class))
                .collect(Collectors.toList());}

}
