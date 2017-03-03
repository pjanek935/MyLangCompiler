package main;

import java.util.ArrayList;

import main.Templates.Type;

public class NumStack {
	
	private ArrayList<Num> stack;

	public NumStack() {
		stack = new ArrayList<Num>();
	}
	
	public void push(float number, Type type){
		stack.add(new Num(number, type));
	}
	
	public void push(Num num){
		stack.add(num);
	}
	
	public Num pop(){
		Num num = stack.get(stack.size()-1);
		stack.remove(stack.size()-1);
		return num;
	}
	
	

	
	public float showLastNumber(){
		return stack.get(stack.size()-1).number;
	}
	
	public void showStack(){
		System.out.println();
		for(Num num : stack){
			if(num.type == Type.NAME){
				System.out.print(num.name + " ");
			}else if(num.type == Type.INT || num.type == Type.FLOAT){
				System.out.print(num.number + " ");
			}else{
				System.out.print("r" + num.number + " ");
			}
			
		}
		System.out.println();
	}

}


