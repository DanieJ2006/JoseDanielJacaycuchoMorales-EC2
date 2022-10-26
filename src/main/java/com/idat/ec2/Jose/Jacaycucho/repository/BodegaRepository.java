package com.idat.ec2.Jose.Jacaycucho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.ec2.Jose.Jacaycucho.model.Bodega;
@Repository
public interface BodegaRepository extends JpaRepository<Bodega, Integer>{

}
