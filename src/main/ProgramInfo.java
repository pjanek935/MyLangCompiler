package main;

import java.util.ArrayList;

import main.Templates.Type;

public class ProgramInfo {
	
	private ArrayList<Variable> variables;
	private static ProgramInfo instance; 
	
	public static Type lastType;

	public static String currentContext = "main";
	
	private ProgramInfo() {
		variables = new ArrayList<Variable>();
	}
	
	public static ProgramInfo getInstance(){
		if(instance != null){
			return instance;
		}else{
			instance = new ProgramInfo();
			return instance;
		}
	}
	
	public void addVariable(Variable var){
		variables.add(var);
	}
	
	public void addVariable(String name, Type type){
		variables.add(new Variable(name, type));
	}
	
	public boolean nameExists(String name){
		for(Variable var : variables){
			if(var.name.equals(name)){
				return true;
			}
		}
		return false;
	}
	
	
	
	public Type getVariableType(String name){
		for(Variable var : variables){
			if(var.name.equals(name)){
				return var.type;
			}
		}
		return Type.FLOAT;
	}
	
	public String getVariableContext(String name){
		for(Variable var : variables){
			if(var.name.equals(name)){
				return var.context;
			}
		}
		return "main";
	}
	
	public int getArrSize(String name){
		for(Variable var : variables){
			if(var.name.equals(name)){
				return var.size;
			}
		}
		return 0;
	}
	
	public void changeSize(String name, int newSize){
		for(Variable var : variables){
			if(var.name.equals(name)){
				var.size = newSize;
				return;
			}
		}
	}
	
	public ArrayList<Type> getTypesList(String name){
		for(Variable var : variables){
			if(var.name.equals(name)){
				return var.arguments;
			}
		}
		return null;
	}
	
	public boolean isFunction(String name){
		for(Variable var : variables){
			if(var.name.equals(name)){
				if(var.fun){
					return true;
				}else{
					return false;
				}
			}
		}
		return false;
	}

}
