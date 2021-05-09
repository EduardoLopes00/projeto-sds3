package com.devsuperior.dsvendas.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.devsuperior.dsvendas.entities.Sale;
import com.devsuperior.dsvendas.entities.Seller;

public class SaleSumDTO implements Serializable {

		private String sellerName;
		private Double sum;
		
		public SaleSumDTO() {}


		public SaleSumDTO(Seller seller, Double sum) {			
			this.sellerName = seller.getName(); //Necessário fazer usando o objeto seller pois o mesmo será usado para agrupamento
			this.sum = sum;
		}



		public String getSellerName() {
			return sellerName;
		}

		public void setSellerName(String sellerName) {
			this.sellerName = sellerName;
		}

		public Double getSum() {
			return sum;
		}

		public void setSum(Double sum) {
			this.sum = sum;
		}
		
		
	
	}

