package edu.pdsw.mvc;


import java.util.*;
import java.lang.*;
import javax.faces.bean.*;

@ManagedBean(name = "guessBean")
@ApplicationScoped

public class BackingBean {
	
	private int numberGuess;
	private int numberAttemp;
	private int prize;
	private int amount;
	private String state;
	private List<Integer> tries; 
	
	public BackingBean() {
		restart();
	}
	
	public int getNumberGuess() {
		return numberGuess;
	}
	
	public int getAttemps() {
		return numberAttemp;
	}

	public int getPrize() {
		return prize;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public String getState() {
		return state;
	}
	
	public void setNumberGuess(int newNumber){
		numberGuess = newNumber;
	}
	
	public void setAttemps(int newAttemp) {
		numberAttemp = newAttemp;
	}

	public void setPrize(int newPrize){
		prize = newPrize;
	}
	
	public void setAmount(int newAmount) {
		amount = newAmount;
	}
	
	
	public void setState(String newState) {
		state=newState;
	}
	
	public void guess(int numberGuessing) {
		if(numberGuessing==getNumberGuess()) {
			amount+=prize; state="You win!, Congrats!";
			setPrize(0);
		}else {
			setPrize(prize-10);
			state="You lost!!!, :(";
		}
		tries.add(numberGuessing);
		setAttemps(numberAttemp+1);
	}
	
	public void restart() {
		numberGuess = (new Random()).nextInt(10);
		numberAttemp=0;
		prize=100;
		amount=0;
		state="";
		tries = new ArrayList<Integer>();
	}
	
	public List<Integer> getTries(){
		return tries;
	}
	
}
