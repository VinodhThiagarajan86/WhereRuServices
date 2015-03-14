package com.hack.whereru.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hack.whereru.collections.CurrentLocation;

public interface CurrentLocationRepository extends MongoRepository<CurrentLocation, String> {
	

}
