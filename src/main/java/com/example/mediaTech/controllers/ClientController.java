package com.example.mediaTech.controllers;

import com.example.mediaTech.dto.ClientRequestDto;
import com.example.mediaTech.dto.ClientResponseDto;
import com.example.mediaTech.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/get")
    public ResponseEntity<List<ClientResponseDto>> getClient(){
        return new ResponseEntity<>(clientService.findAll(), HttpStatus.OK);

    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/add")
    public ResponseEntity<ClientResponseDto> save(@RequestBody ClientRequestDto clientRequestDto){
        ClientResponseDto clientResponseDto  = clientService.save(clientRequestDto);
        return new ResponseEntity<>(clientResponseDto, HttpStatus.CREATED);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/id/{id}")
    public ResponseEntity<ClientResponseDto> findById(@PathVariable("id") Integer id) {
        ClientResponseDto clientResponseDto= clientService.findById(id);
        return ResponseEntity.ok(clientResponseDto);
    }
    @CrossOrigin(origins = "http://localhost:4200")

    @GetMapping("/nom/{firstName}")
    public ClientResponseDto findByFirstName(@PathVariable String firstName) {
        return clientService.findByFirstName(firstName);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/id/{id}")
    public void delete(@PathVariable() Integer id) {
        clientService.delete(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/update/{id}")
    public ResponseEntity<ClientResponseDto> update(@RequestBody() ClientRequestDto clientRequestDto,@PathVariable Integer id) {
        ClientResponseDto clientResponseDto=clientService.update(clientRequestDto, id);
        return new ResponseEntity<>(clientResponseDto,HttpStatus.ACCEPTED);
    }
}
