package com.hotel.hotel_server.repository;

import com.hotel.hotel_server.model.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository<Cliente, String> {

}