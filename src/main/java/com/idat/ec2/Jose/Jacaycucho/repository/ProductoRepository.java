package com.idat.ec2.Jose.Jacaycucho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.ec2.Jose.Jacaycucho.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{

}
