package com.devsuperior.dsvendas.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvendas.entities.Sale;
import com.devsuperior.dsvendas.entities.Seller;
import com.devsuperior.dsvendas.repositories.SaleRepository;
import com.devsuperior.dsvendas.repositories.SellerRepository;
import com.devsuperior.dto.SaleDTO;
import com.devsuperior.dto.SellerDTO;

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
}
