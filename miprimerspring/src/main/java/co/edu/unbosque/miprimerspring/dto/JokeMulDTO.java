package co.edu.unbosque.miprimerspring.dto;

import java.util.ArrayList;

public class JokeMulDTO {
	
	private boolean error;
	private int amount;
    private ArrayList<JokeDTO> jokes;
    
    public JokeMulDTO() {
		
	}
    
	public JokeMulDTO(boolean error, int amount, ArrayList<JokeDTO> jokes) {
		super();
		this.error = error;
		this.amount = amount;
		this.jokes = jokes;
	}

	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public ArrayList<JokeDTO> getJokes() {
		return jokes;
	}
	public void setJokes(ArrayList<JokeDTO> jokes) {
		this.jokes = jokes;
	}

	@Override
	public String toString() {
		return "JokeMulDTO [error=" + error + ", amount=" + amount + ", jokes=" + jokes + "]";
	} 
}