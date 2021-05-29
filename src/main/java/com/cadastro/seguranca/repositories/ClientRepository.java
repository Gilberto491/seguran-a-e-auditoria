package com.cadastro.seguranca.repositories;

import com.cadastro.seguranca.dto.request.ClientPagedFilterResquestDTO;
import com.cadastro.seguranca.po.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("SELECT m FROM Client m " +
    " WHERE (:#{#filter.cdClient} IS NULL OR :#{#filter.cdClient} = m.cdClient) " +
    " AND (:#{#filter.email} IS NULL OR :#{#filter.email} = m.email) " +
    " AND (:#{#filter.name} IS NULL OR :#{#filter.name} = m.name) " +
    " AND (:#{#filter.status} IS NULL OR :#{#filter.status} = m.status) ")
    Page<Client> findFilterList(
            ClientPagedFilterResquestDTO filter,
            Pageable pageable);
}
