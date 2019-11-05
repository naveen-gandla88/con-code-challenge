package com.app.coni.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.coni.entity.CountryDtls;
@Repository
public interface ValidateVatRepository extends JpaRepository<CountryDtls, Long>{
	
	@Query("SELECT c.countryName FROM CountryDtls c where c.countryCd = :countryCd")
	String getCountryByCd(@Param("countryCd") String countryCd);

}
