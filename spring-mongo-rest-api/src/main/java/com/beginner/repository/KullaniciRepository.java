package com.beginner.repository;

import com.beginner.entity.Kullanici;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface KullaniciRepository extends MongoRepository <Kullanici, String> {
    
}
