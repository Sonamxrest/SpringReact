package com.sonam.hamro.persitDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserPersitDto {
    public Long id;
    public String username;
    public String password;
    @JsonProperty("first_name")
    public String firstName;
    public String profile;
}
