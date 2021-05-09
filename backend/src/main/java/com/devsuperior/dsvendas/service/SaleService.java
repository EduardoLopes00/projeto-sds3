package com.devsuperior.dsvendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.dto.SaleSuccessDTO;
import com.devsuperior.dsvendas.dto.SaleSumDTO;
import com.devsuperior.dsvendas.entities.Sale;
import com.devsuperior.dsvendas.repositories.SaleRepository;
import com.devsuperior.dsvendas.repositories.SellerRepository; 

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRespoitory;
	
	@Transactional(readOnly = true) //Não gera transação no banco de dados.
	public Page<SaleDTO> findAll(Pageable pegeable) {
		sellerRespoitory.findAll(); //Buscando todos os vendedores para n ficar repetindo o select de 1 vendedor por 1 (Feito aepnas quand se tem poucos registros	)
		Page<Sale> result = repository.findAll(pegeable);
		return result.map(x -> new SaleDTO(x));
	}
	
	@Transactional(readOnly = true) //Não gera transação no banco de dados.
	public List<SaleSumDTO> amountGroupedBySeller() {				 
		return repository.amountGroupedBySeller(); 
	}
	
	@Transactional(readOnly = true) //Não gera transação no banco de dados.
	public List<SaleSuccessDTO> successGroupedBySeller() {				 
		return repository.successGroupedBySeller(); 
	}
}
