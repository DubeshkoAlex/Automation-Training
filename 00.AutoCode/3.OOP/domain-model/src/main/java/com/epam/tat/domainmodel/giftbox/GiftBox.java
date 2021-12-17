package com.epam.tat.domainmodel.giftbox;

import com.epam.tat.domainmodel.candies.Candy;
import com.epam.tat.domainmodel.util.Finding;
import com.epam.tat.domainmodel.util.Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class Description:
 * Implement interfaces: Sorting and Finding and
 * their methods for sorting candies by name or weight and
 * finding candies by parameters.
 * <p>
 */
public class GiftBox implements Finding, Sorting {
    /**
     * No actions are required for class variable candiesList.
     */
    private List<Candy> candiesList;

    /**
     * No actions are required for constructor GiftBox().
     */
    public GiftBox() {
        candiesList = new ArrayList<Candy>();
    }

    /**
     * No actions are required for method addCandy().
     */
    public void addCandy(Candy candy) {
        this.candiesList.add(candy);
    }

    /**
     * Implement sorting of candiesList by its names in ascending order
     * and return sorted by name ascending list of candies.
     */
    @Override
    public List<Candy> sortCandiesByNameAsc() {
        for (int j = 0; j < candiesList.toArray().length; j++) {
            for (int i = j + 1; i < candiesList.toArray().length; i++) {
                if (candiesList.get(i).getName().compareTo(candiesList.get(j).getName()) < 0) {
                    Candy temp = candiesList.get(j);
                    candiesList.add(j,candiesList.get(i));
                    candiesList.remove(j+1);
                    candiesList.add(i,temp);
                    candiesList.remove(i+1);
                }
            }
        }
        return candiesList;
    }

    /**
     * Implement sorting of candiesList by its weight in ascending order
     * and return sorted by weight ascending list of candies.
     */
    @Override
    public List<Candy> sortCandiesByWeightAsc() {

        Candy temp1, temp2;
        for (int left = 0; left < candiesList.toArray().length; left++) {

            Candy value = candiesList.get(left);
            int i = left - 1;
            for (; i >= 0; i--) {
                if (value.getWeight() < candiesList.get(i).getWeight()) {
                    candiesList.remove(i+1);
                    candiesList.add(i+1, candiesList.get(i));
                } else {
                    break;
                }
            }
            candiesList.remove(i+1);
            candiesList.add(i+1,value);
        }

        return candiesList;

    }

    /**
     * Implement selection of candies from candiesList with names started with candyNameFirstLetter
     * and return list of candies which names started with candyNameFirstLetter in name ascending list of candies.
     */
    @Override
    public List<Candy> findCandiesByNameStartedWith(char candyNameFirstLetter) {
        GiftBox newCandiesList = new GiftBox();
        for (Candy candy:candiesList) {
            if(candy.getName().substring(0,1).equals(Character.toString(candyNameFirstLetter))){
                newCandiesList.addCandy(candy);
            }
        }
        return newCandiesList.sortCandiesByNameAsc();
    }

    /**
     * Implement selection ot candies from candiesList so that its [weightFrom <= weight => weightTo]
     * and return list of candies with weight in range [weightFrom, weightTo] in weight ascending list of candies.
     */
    @Override
    public List<Candy> findCandiesByWeightInRange(int weightFrom, int weightTo) {
        GiftBox newCandyList = new GiftBox();
        for (Candy candy:candiesList) {
            if(candy.getWeight() >= weightFrom && candy.getWeight() <= weightTo){
                newCandyList.addCandy(candy);
            }
        }
        return newCandyList.sortCandiesByWeightAsc();

    }
}
