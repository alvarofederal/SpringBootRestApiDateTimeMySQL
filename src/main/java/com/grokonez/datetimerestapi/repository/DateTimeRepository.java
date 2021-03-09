package com.grokonez.datetimerestapi.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.grokonez.datetimerestapi.model.DateTimeModel;

public interface DateTimeRepository extends CrudRepository<DateTimeModel, Long>{
	
	List<DateTimeModel> findAllByDatetimeBetween(
								Date dateTimeStart,
								Date dateTimeEnd);
	
    @Query("select d from DateTimeModel d where d.datetime <= :datetime")
    List<DateTimeModel> findAllWithDatetimeBefore(
    		@Param("datetime") Date datetime);
}