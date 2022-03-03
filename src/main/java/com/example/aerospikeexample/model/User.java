package com.example.aerospikeexample.model;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Component
public class User {
    public String name;
    public long salary;
}
