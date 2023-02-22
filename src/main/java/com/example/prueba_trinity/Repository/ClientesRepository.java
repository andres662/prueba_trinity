package com.example.prueba_trinity.Repository;

import com.example.prueba_trinity.Entity.ClientesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepository extends JpaRepository<ClientesEntity, Long> {

    @Query(value = "SELECT * FROM tbl_clientes where id = :id", nativeQuery = true)
    ClientesEntity findByIdCliente(@Param("id")Long id);
}
