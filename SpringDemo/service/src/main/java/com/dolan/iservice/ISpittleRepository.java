package com.dolan.iservice;

import java.util.List;

import com.dolan.model.spittle.Spittle;



public interface ISpittleRepository {
	List<Spittle> findSpittles(long max,int count);
}
