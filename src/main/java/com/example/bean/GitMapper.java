package com.example.bean;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class GitMapper {
    private String name;
    private String location;
    private String login;
    private String id;
}
