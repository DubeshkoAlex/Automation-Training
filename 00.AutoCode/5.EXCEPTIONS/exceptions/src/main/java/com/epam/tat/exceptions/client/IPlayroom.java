package com.epam.tat.exceptions.client;

import com.epam.tat.exceptions.bean.Toy;

import java.util.List;

public interface IPlayroom {

	List<Toy> getAllToys();

	List<Toy> getToysByParameter(String parameter, String value);

	boolean addToy(Toy toy);

	boolean removeToy(Toy toy);

	boolean updateToy(Long id, Toy toy);
}
