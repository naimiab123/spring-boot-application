package io.nai.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import io.nai.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
