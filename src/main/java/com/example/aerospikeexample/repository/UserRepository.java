package com.example.aerospikeexample.repository;

import com.example.aerospikeexample.model.User;
import org.springframework.data.aerospike.repository.AerospikeRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends AerospikeRepository<User,Integer> {
}
