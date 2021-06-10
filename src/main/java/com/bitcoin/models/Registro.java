package com.bitcoin.models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Document(collection = "registros")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Registro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private String id;
    private String emailUser;
    private String name_lastNameUser;
    private String docUser;
    private String phoneUser;
    private String password;
    private int cardNumber;
    private int securityCode;

}











	
	
	
	
	
	
	
	
	
	

