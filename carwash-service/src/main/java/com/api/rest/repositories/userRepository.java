package com.api.rest.repositories;

import com.api.rest.models.userModel;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends CrudRepository<userModel, Long> {
    public abstract ArrayList<userModel> findByPriority(Integer priority);
    
}
 