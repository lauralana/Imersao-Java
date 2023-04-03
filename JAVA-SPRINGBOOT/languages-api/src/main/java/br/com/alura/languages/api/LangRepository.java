package br.com.alura.languages.api;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface LangRepository extends MongoRepository<Languages, String> {
    
}
