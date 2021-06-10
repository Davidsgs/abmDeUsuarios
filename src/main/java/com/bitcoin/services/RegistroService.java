package com.bitcoin.services;

import com.bitcoin.repositories.RegistroRepository;
import com.bitcoin.models.Registro;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroService {

    @Autowired
    RegistroRepository registroRepository;

    public List<Registro> getAllRegistro(){
        return (List<Registro>) registroRepository.findAll();
    }

    public Registro getRegistroById(String idRegistro){
        return registroRepository.findById(idRegistro).orElseThrow(
                () -> new IllegalStateException("Registro with id " + idRegistro + " Not found.")) ;
    }

    public Registro addRegistro(Registro registro){
        if(registro != null){
            registro = registroRepository.save(registro);
        }
        return registro;
    }

    public Registro updateRegistro(String registroId, Registro registro){
        var registroAux = getRegistroById(registroId);
        if(registro.getPassword() != null) { registroAux.setPassword(registro.getPassword()); }
        if(registro.getEmailUser() != null ) { registroAux.setEmailUser(registro.getEmailUser()); }
        if(registro.getPhoneUser() != null ) { registroAux.setPhoneUser(registro.getPhoneUser());}
        if(registro.getName_lastNameUser() != null){ registroAux.setName_lastNameUser(registro.getName_lastNameUser());}
        if(registro.getDocUser() != null ) { registroAux.setDocUser(registro.getDocUser());}
        if(registro.getCardNumber() != 0) {registroAux.setCardNumber(registro.getCardNumber());}
        if(registro.getSecurityCode() != 0) { registroAux.setSecurityCode(registro.getSecurityCode()); }
        return registroAux;
    }

    public Boolean deleteRegistro(String idRegistro){
        try{
            registroRepository.deleteById(idRegistro);//OJO, Revisar cuando cambies el id de String a Long en la DB.
            return true;
        }catch (Exception e){
            return false;
        }
    }


}
