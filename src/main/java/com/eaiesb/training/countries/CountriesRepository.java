package com.eaiesb.training.countries;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CountriesRepository extends MongoRepository<Countries, String> {

}

