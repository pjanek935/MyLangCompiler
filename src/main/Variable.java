package main;

import java.util.ArrayList;

import main.Templates.Type;

public class Variable{
	public String name;
	Type type;
	public String context = "main";
	public int size;
	boolean fun = false;
	
	public ArrayList<Type> arguments = new ArrayList<Type>();
	public Variable(String name, Type type){
		this.name = name;
		this.type = type;
	}
}
