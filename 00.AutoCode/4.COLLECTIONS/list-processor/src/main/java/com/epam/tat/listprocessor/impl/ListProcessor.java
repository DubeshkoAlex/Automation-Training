package com.epam.tat.listprocessor.impl;

import com.epam.tat.listprocessor.IListProcessor;
import com.epam.tat.listprocessor.exception.ListProcessorException;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Function Description:
 * Complete the functions below. All methods must work with list of String.
 *
 * In case of incorrect input values or inability to perform an action, the method should throw an appropriate
 * exception.
 *
 */
public class ListProcessor implements IListProcessor {

	/**
	 * Find the second by length string in a list.
	 *
	 * Ex.:
	 * From list:
	 * {"a", "aa", "aaaaa", "aaaa", "aaa"}
	 * will be return "aaaa"
	 *
	 * @param list - input data
	 * @return second by length string in the input list
	 */
	@Override
	public String getSecondStringByLength(List<String> list) {
		try {
			if(!list.isEmpty()) {
				list.sort((o1, o2) -> o2.length()-o1.length());
				return list.get(1);
			}
			else {
				throw new ListProcessorException("There are NO any values! Empty list!");
			}
		}
		catch (NullPointerException e){
			throw new ListProcessorException("Null instead of list or in the list values!");
		}
		catch (IndexOutOfBoundsException e){
			throw new ListProcessorException("There is ONLY ONE value!");
		}
	}

	/**
	 * Sort list by string length.
	 *
	 * Ex.:
	 * From list:
	 * {"a", "aa", "aaA", "aAa", "aaa", "Aa"}
	 * will be return
	 * {"a", "Aa", "aa", "aAa", "aaA", "aaa"}
	 *
	 * @param list - input data
	 * @return sort list by string length
	 */
	@Override
	public List<String> getSortedListByLength(List<String> list) {
		try {
			if(!list.isEmpty()) {
				list.sort(Comparator.comparingInt(String::length));
				return list;
			}
			else {
				throw new ListProcessorException("There are NO any values! Empty list!");
			}
		}
		catch (NullPointerException e){
			throw new ListProcessorException("Null instead of list or in the list values!");
		}
	}

	/**
	 * Sort list or array by count of vowels in string.
	 * If the number of vowels in several words is the same, the order is alphabetical.
	 *
	 * Ex.:
	 * From list:
	 * {"Puma", "Nike", "Timberland", "Adidas"}
	 * will be return
	 * {"Nike", "Puma", "Adidas", "Timberland"}
	 *
	 * @param list - input data
	 * @return sort list by string length
	 */
	@Override
	public List<String> getSortedListByCountOfVowels(List<String> list) {
		try {
			int countVowels = 0;
			for (Character ch:list.toString().toCharArray()) {
				if(ch.toString().matches("(?ui:[aeiouy])")){
					countVowels++;
				}
			}
			if(countVowels==0){
				throw new ListProcessorException("There is no one vowels! ");
			}
			System.out.println(countVowels);
			if(!list.isEmpty()) {
				List<String> newList = list.stream().sorted((o1,o2)->{
					int o1VowelsCount = 0;
					for (Character ch: o1.toCharArray()) {
						if(ch.toString().matches("(?ui:[aeiouy])")){
							o1VowelsCount++;
						}
					}
					int o2VowelsCount = 0;
					for (Character ch: o2.toCharArray()) {
						if(ch.toString().matches("(?ui:[aeiouy])")){
							o2VowelsCount++;
						}
					}
					return o1VowelsCount != o2VowelsCount ? o1VowelsCount - o2VowelsCount : o1.compareTo(o2);
				}).collect(Collectors.toList());
				return newList;
			}
			else {
				throw new ListProcessorException("There are NO any values! Empty list!");
			}
		}
		catch (NullPointerException e){
			throw new ListProcessorException("Null instead of list or in the list values!");
		}
	}

	/**
	 * Sort list or array by count of consonants in string.
	 * If the number of consonants in several words is the same, the order is alphabetical.
	 *
	 * Ex.:
	 * From list:
	 * {"Puma", "Nike", "Timberland", "Adidas"}
	 * will be return
	 * {"Nike", "Puma", "Adidas", "Timberland"}
	 *
	 * @param list - input data
	 * @return sort list by string length
	 */
	@Override
	public List<String> getSortedListByCountOfConsonants(List<String> list) {
		try {
			int countConsonants = 0;
			for (Character ch:list.toString().toCharArray()) {
				if(ch.toString().matches("(?ui:[bcdfghjklmnpqrstvwxyz])")){
					countConsonants++;
				}
			}
			if(countConsonants==0){
				throw new ListProcessorException("There is no one consonants! ");
			}
			if(!list.isEmpty()) {
				List<String> newList = list.stream().sorted((o1,o2)->{
					int o1ConsonantsCount = 0;
					for (Character ch: o1.toCharArray()) {
						if(ch.toString().matches("(?ui:[bcdfghjklmnpqrstvwxyz])")){
							o1ConsonantsCount++;
						}
					}
					int o2ConsonantsCount = 0;
					for (Character ch: o2.toCharArray()) {
						if(ch.toString().matches("(?ui:[bcdfghjklmnpqrstvwxyz])")){
							o2ConsonantsCount++;
						}
					}
					return o1ConsonantsCount != o2ConsonantsCount ? o1ConsonantsCount - o2ConsonantsCount : o1.compareTo(o2);
				}).collect(Collectors.toList());
				return newList;
			}
			else {
				throw new ListProcessorException("There are NO any values! Empty list!");
			}
		}
		catch (NullPointerException e){
			throw new ListProcessorException("Null instead of list or in the list values!");
		}
	}

	/**
	 * Change by places first and last symbols in each second string of list.
	 *
	 * Ex.:
	 * From list:
	 * {"Puma", "Nike", "Timberland", "Adidas"}
	 * will be return
	 * {"Puma", "eikN", "Timberland", "sdidaA"}
	 *
	 * @param list - input data
	 * @return sort list by string length
	 */
	@Override
	public List<String> changeByPlacesFirstAndLastSymbolsInEachSecondStringOfList(List<String> list) {
		try {
			if(list.size()<2){
				throw new ListProcessorException("There is ONLY ONE value!");
			}
			if(!list.isEmpty()) {
				List<String> newList = list.stream().map(string-> {
					if ((list.indexOf(string)+1)%2==0 && string.length()>2) {
						char[] charString = string.toCharArray();
						char temp = charString[0];
						charString[0] = charString[string.length() - 1];
						charString[string.length() - 1] = temp;
						return String.valueOf(charString);
					}
					else return string;
				}).collect(Collectors.toList());
				return newList;
			}
			else {
				throw new ListProcessorException("There are NO any values! Empty list!");
			}
		}
		catch (NullPointerException e){
			throw new ListProcessorException("Null instead of list or in the list values!");
		}
	}

	/**
	 * Revert strings of list.
	 *
	 * Ex.:
	 * From list:
	 * {"Puma", "Nike", "Timberland", "Adidas"}
	 * will be return
	 * {"amuP", "ekiN", "dnalrebmiT", "sadidA"}
	 *
	 * @param list - input data
	 * @return sort list by string length
	 */
	@Override
	public List<String> reverseStringsOfList(List<String> list) {
		try {
			if(!list.isEmpty()) {
				return list.stream().map(string -> new StringBuilder(string).reverse().toString()).collect(Collectors.toList());
			}
			else {
				throw new ListProcessorException("There are NO any values! Empty list!");
			}
		}
		catch (NullPointerException e){
			throw new ListProcessorException("Null instead of list or in the list values!");
		}
	}
}
