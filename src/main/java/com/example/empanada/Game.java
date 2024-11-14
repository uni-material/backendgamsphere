package com.example.empanada;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Document(collection = "games")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Game {
    @Id
    public String id;
    public String title;
    public String developer;
    private byte[] file;
    
}
