package com.devsuperior.dsvendas.repositories;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.devsuperior.dsvendas.entities.Sale;
import com.devsuperior.dsvendas.entities.Seller;

public interface SaleRepository extends JpaRepositoryImplementation<Sale,  Long> {
	
}
