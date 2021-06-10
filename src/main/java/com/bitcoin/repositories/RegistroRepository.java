package com.bitcoin.repositories;
import com.bitcoin.models.Registro;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RegistroRepository extends MongoRepository<Registro, String> {

	public abstract Optional<Registro> findById(String idRegistro);

}
