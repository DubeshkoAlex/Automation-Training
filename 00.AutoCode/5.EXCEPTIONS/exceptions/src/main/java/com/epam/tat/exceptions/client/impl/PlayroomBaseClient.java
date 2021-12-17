package com.epam.tat.exceptions.client.impl;

import com.epam.tat.exceptions.bean.Toy;
import com.epam.tat.exceptions.client.IPlayroom;
import com.epam.tat.exceptions.constants.*;
import com.epam.tat.exceptions.exception.*;

import java.util.*;
import java.util.stream.Collectors;

public class PlayroomBaseClient implements IPlayroom {

	private List<Toy> toyList;

	public PlayroomBaseClient(List<Toy> toyList) {
		if (toyList == null){
			throw new InitializationException("Can't be the null value");
		}
		else {
			this.toyList = toyList;
		}
	}

	@Override
	public List<Toy> getAllToys() {
		if(this.toyList == null || this.toyList.isEmpty() || this.toyList.contains(null)){
			throw new InitializationException("List of toys is empty or null or contains null");
		}
		else {
			return this.toyList;
		}
	}

	@Override
	public List<Toy> getToysByParameter(String parameter, String value) {
		if(parameter == null || value == null){
			throw new GetToysByParameterException("Parameter or value is null!");
		}
		Map<String,Parameter> params = new HashMap<>();
		params.put(Parameter.ID.getName(),Parameter.ID);
		params.put(Parameter.TOY_NAME.getName(),Parameter.TOY_NAME);
		params.put(Parameter.GAME_TYPE.getName(),Parameter.GAME_TYPE);
		params.put(Parameter.GENDER.getName(),Parameter.GENDER);
		params.put(Parameter.AGE.getName(),Parameter.AGE);
		params.put(Parameter.SIZE.getName(),Parameter.SIZE);
		params.put(Parameter.MATERIAL.getName(),Parameter.MATERIAL);
		params.put(Parameter.PRICE.getName(),Parameter.PRICE);

		if(params.get(parameter) != null) {
			return toyList.stream().filter(Toy -> {
				try {
					switch (params.get(parameter)) {
						case ID:
							return Toy.getId().equals(Long.valueOf(value));
						case TOY_NAME:
							return Toy.getToyName().equals(value);
						case GAME_TYPE:
							return Toy.getGameType().equals(GameType.valueOf(value));
						case GENDER:
							return Toy.getGender().equals(Gender.valueOf(value));
						case AGE:
							return Toy.getAge() == Integer.parseInt(value);
						case SIZE:
							return Toy.getSize().equals(Size.valueOf(value));
						case MATERIAL:
							return Toy.getMaterial().equals(Material.valueOf(value));
						case PRICE:
							return Toy.getPrice() == Double.parseDouble(value);
						default:
							throw new EnumConstantNotPresentException(Parameter.class, Parameter.valueOf(parameter).getName());
					}
				}catch (IllegalArgumentException e){
					throw new GetToysByParameterException("Wrong value!");
				}
					})
					.collect(Collectors.toList());
		}
		else {
			throw new GetToysByParameterException("Wrong parameter!");
		}
	}

	@Override
	public boolean addToy(Toy toy) {
		if(toy == null){
			throw new AddToyException("Toy value is null");
		}
		if(toyList.stream().map(Toy::getId).collect(Collectors.toList()).contains(toy.getId())){
			throw new AddToyException("This id is already exist!");
		}
		if(toy.getId() == null || toy.getMaterial() == null || toy.getGameType() == null || toy.getToyName() == null || toy.getGender() == null || toy.getSize() == null){
			return false;
		}
		else {
			return toyList.add(toy);
		}
	}

	@Override
	public boolean removeToy(Toy toy) {
		if(toy == null){
			throw new RemoveToyException("Toy value is null");
		}
		if(toyList.stream().map(Toy::getId).collect(Collectors.toList()).contains(toy.getId())){
			return toyList.remove(toy);
		}
		else {
			throw new RemoveToyException("There are no such value in the list");
		}
	}

	@Override
	public boolean updateToy(Long id, Toy toy) {
		if(toy == null || id == null){
			throw new UpdateToyException("Toy value is null or id is null");
		}
		if(toy.getId() == null || toy.getMaterial() == null || toy.getGameType() == null || toy.getToyName() == null || toy.getGender() == null || toy.getSize() == null){
			return false;
		}
		if(toyList.stream().map(Toy::getId).collect(Collectors.toList()).contains(id)){
			toy.setId(id);
			toyList.set(toyList.stream().map(Toy::getId).collect(Collectors.toList()).indexOf(id),toy);
			return true;
		}
		else{
			throw new UpdateToyException("Id doesn't exist");
		}
	}
}
