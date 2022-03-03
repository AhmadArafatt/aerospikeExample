package com.example.aerospikeexample.service;

import com.aerospike.client.*;
import com.aerospike.client.policy.WritePolicy;
import com.example.aerospikeexample.model.User;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    String s = "User doesnt found";
    AerospikeClient client = new AerospikeClient("172.28.128.3", 3000);
    WritePolicy writePolicy = new WritePolicy();


    public Map<String, Object> findAUser(String userKey) {
        Key key = new Key("test", "demo", userKey);
        Record record = client.get(writePolicy, key);
        return record.bins;
    }

    public List<Map<String, Object>> findAll() {
        List<Map<String, Object>> l = new ArrayList<>();
        client.scanAll(null, "test", "demo", (key, record) -> l.add(client.get(writePolicy, key).bins));
        return l;
    }

    public String create(User user, String userKey) {
        Key key = new Key("test", "demo", userKey);
        Bin NAME = new Bin("name", user.name);
        Bin SALARY = new Bin("salary", user.salary);
        client.put(writePolicy, key, NAME, SALARY);
        return "User has been Added";
    }

    public String delete(String userKey) {
        Key key = new Key("test", "demo",userKey);
        if(client.delete(writePolicy, key))
        s = "User has been deleted";
        else
            s="User doesnt found";
        return s;
    }

    public String update(String userKey, String Salary) {
        Key key = new Key("test", "demo", userKey);
        Bin SALARY = new Bin("salary", Salary);
        if(client.exists(writePolicy,key)){
            client.put(writePolicy, key, SALARY);
            s = "Salary has been updated";
        }
        else{
            s="User does not found";
        }
        return s;
    }
}


