package AwsADFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PowerpuffGirls {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
       // System.out.println("Enter the number of ingredients \n");
        int numbIng = sc.nextInt();
       // System.out.println("Enter the quantity of each ingredients needed to make powepuff girls \n");
        List<Integer> quantityNeeded = new ArrayList<Integer>();
        sc = new Scanner(System.in);
        for(int i=0;i<numbIng;i++) {     	
        	quantityNeeded.add(sc.nextInt());     	    	
        }
       // System.out.println("Enter the quantity of each ingredients present in lab \n");
        sc = new Scanner(System.in);
        List<Integer> quantityPresentinLab = new ArrayList<Integer>();
        for(int i=0;i<numbIng;i++) {
        	
        	quantityPresentinLab.add(sc.nextInt());
        	    	
        }
           List<Integer> minIngredentiLefy = new ArrayList<Integer>();
            for(int i=0;i<numbIng;i++) {
            	
            	minIngredentiLefy.add(quantityPresentinLab.get(i)/quantityNeeded.get(i));
            	
            }
            Collections.sort(minIngredentiLefy);
           // System.out.println("Number of powerpuff girls "+ minIngredentiLefy.get(0));
        System.out.println(minIngredentiLefy.get(0));
	}

}
