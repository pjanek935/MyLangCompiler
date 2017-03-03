package main;

import java.util.ArrayList;

public class InstructionStack {
	
	private ArrayList<String> stack;
	
	private int globalVariablesMarker = 0;
	
	private int fStartMarker = 0;

	public InstructionStack() {
		stack = new ArrayList<String>();
	}
	
	public void push(String instruction){
		stack.add(instruction);
	}
	
	public String pop(){
		String instruction = stack.get(stack.size()-1);
		stack.remove(stack.size()-1);
		return instruction;
	}
	
	public void showStack(){
		System.out.println();
		for(String instr : stack){
			System.out.println(instr + " ");
		}
		System.out.println();
	}
	
	public ArrayList<String> getInstrList(){
		return stack;
	}
	
	public void addGlobalVariable(String instruction){
		stack.add(globalVariablesMarker, instruction);
		globalVariablesMarker++;
	}
	
	public void markFunctionStart(){
		fStartMarker = stack.size();
	}
	
	public String splitLastFunction(){
		String instr = "";
		int diff = 0;
		for(int i=fStartMarker; i<stack.size(); i++){
			instr += stack.get(i) + "\n";
			diff++;
		}
		
		for(int i=0; i<diff; i++){
			stack.remove(stack.size()-1);
		}
		
		return instr;
	}
	
	

}
