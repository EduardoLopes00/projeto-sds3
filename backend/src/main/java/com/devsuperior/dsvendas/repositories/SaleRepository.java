package com.devsuperior.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.devsuperior.dsvendas.entities.Sale;
import com.devsuperior.dsvendas.dto.SaleSuccessDTO;
import com.devsuperior.dsvendas.dto.SaleSumDTO;

public interface SaleRepository extends JpaRepositoryImplementation<Sale,  Long> {
	
	@Query("SELECT new com.devsuperior.dsvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount))" + 
			" FROM Sale AS obj GROUP BY obj.seller") //Sintaxe de select própria do JPA
	List<SaleSumDTO> amountGroupedBySeller();
	
	@Query("SELECT new com.devsuperior.dsvendas.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals))" + 
			" FROM Sale AS obj GROUP BY obj.seller") //Sintaxe de select própria do JPA
	List<SaleSuccessDTO> successGroupedBySeller();
}
