package main;

import java.util.ArrayList;
import java.util.Stack;

import org.stringtemplate.v4.compiler.STParser.template_return;

import grammar.GrammarBaseListener;
import grammar.GrammarParser.Arr_refContext;
import grammar.GrammarParser.AssignContext;
import grammar.GrammarParser.Assign_arrContext;
import grammar.GrammarParser.DeclareContext;
import grammar.GrammarParser.DefineContext;
import grammar.GrammarParser.Define_arrContext;
import grammar.GrammarParser.ExprContext;
import grammar.GrammarParser.FactorContext;
import grammar.GrammarParser.Float_nameContext;
import grammar.GrammarParser.Fun_nameContext;
import grammar.GrammarParser.Function_headContext;
import grammar.GrammarParser.Function_statementContext;
import grammar.GrammarParser.GetfloatContext;
import grammar.GrammarParser.GetintContext;
import grammar.GrammarParser.Global_declareContext;
import grammar.GrammarParser.Global_defineContext;
import grammar.GrammarParser.Global_define_arrContext;
import grammar.GrammarParser.If_conditionContext;
import grammar.GrammarParser.If_statementContext;
import grammar.GrammarParser.Instruction_setContext;
import grammar.GrammarParser.IntegContext;
import grammar.GrammarParser.Integer_nameContext;
import grammar.GrammarParser.NameContext;
import grammar.GrammarParser.NoneContext;
import grammar.GrammarParser.NumberContext;
import grammar.GrammarParser.PrintContext;
import grammar.GrammarParser.PrintsContext;
import grammar.GrammarParser.ProgramContext;
import grammar.GrammarParser.Repeat_startContext;
import grammar.GrammarParser.Repeat_statementContext;
import grammar.GrammarParser.Ret_statementContext;
import grammar.GrammarParser.StringContext;
import grammar.GrammarParser.String_nameContext;
import grammar.GrammarParser.TermContext;
import main.Templates.Type;

public class GrammarListener extends GrammarBaseListener {
	
		private NumStack numStack = new NumStack();
		public InstructionStack instrStack = new InstructionStack();
		public Stack<Integer> brstack = new Stack<Integer>();
		public int brCounter = 1;

	    @Override
	    public void enterNumber(NumberContext ctx) {
	        
	    }
	    
	    @Override
	    public void enterProgram(ProgramContext ctx){
	    	String instr = "@print_int = linkonce_odr unnamed_addr constant [3 x i8] c\"%d\\00\", align 1 \n";
	    	instr += "@print_float = linkonce_odr unnamed_addr constant [4 x i8] c\"%lf\\00\", align 1 \n" ;
	    	instr += "@new_line = linkonce_odr unnamed_addr constant [2 x i8] c\"\\0A\\00\", align 1 \n";
	    	instr += "@print_char = linkonce_odr unnamed_addr constant [3 x i8] c\"%c\\00\", align 1 \n";
	    	instr += "declare i32 @printf(i8 *, ...) \n";
	    	instr += "declare i32 @scanf(i8*, ...) #1 \n";
	    	instr += "define i32 @main() { \n" ;
	    	//instr += "%iterator = alloca i32";
	    	instrStack.push(instr);
	    }
	    
	    @Override
	    public void exitProgram(ProgramContext ctx){
	    	String instr = "ret i32 1 \n";
	    	instr += "}";
	    	instrStack.push(instr);
	    	instrStack.showStack();
	    }
	    
	    @Override
	    public void exitInstruction_set(Instruction_setContext ctx){
	    	
	    }
	    
	    @Override
	    public void exitFun_name(Fun_nameContext ctx) {
	    	String funName = ctx.getChild(0).getText();
	    	ArrayList<Type> types = ProgramInfo.getInstance().getTypesList(funName);
	    	ArrayList<String> typesName = new ArrayList<String>();
	    	for(Type t : types){
	    		if(t == Type.INT){
	    			typesName.add("i32*");
	    		}else{
	    			typesName.add("double*");
	    		}
	    	}
	    	
	    	ArrayList<Integer> refList = new ArrayList<Integer>();
	    	
	    	int factorCount = 0;
	    	int childCount = ctx.getChild(2).getChildCount();
	    	for(int i=0; i<childCount; i++){
	    		if(ctx.getChild(2).getChild(i) instanceof FactorContext){
	    			factorCount++;
	    		}
	    	}
	    	
	    	ArrayList<Num> factors = new ArrayList<Num>();
	    	for(int i=0; i<factorCount; i++){
	    		Num num = numStack.pop();
	    		factors.add(num);
	    	}
	    	
	    	
	    	if(types.size() != factors.size()){
	    		System.out.println("Inncorect arguments number!");
	    		System.exit(1);
	    	}
	    	
	    	
	    	String retType = "i32";
	    	Type type = Type.INT;
    		type = ProgramInfo.getInstance().getVariableType(funName);
    		if(type == Type.INT){
    			retType = "i32";
    		}else if(type == Type.FLOAT){
    			retType = "double";
    		}
    		
    		for(int i=0; i<factors.size(); i++){
    			Num num = factors.get(i);
    			if(num.type == Type.FLOAT || num.type == Type.INT){
    				String instr = "";
    				instr += "%r" + Templates.varCount + " = fadd double " + (float)num.number + ", 0.0 \n";
    				Templates.varCount++;
    				if(types.get(i) == Type.INT){
    					instr += "%r" + Templates.varCount + " = fptosi double %r" + (Templates.varCount-1) + " to i32 \n";
    					Templates.varCount++;
    					instr += "%r" + Templates.varCount + " = alloca i32 \n";
    					refList.add(Templates.varCount);
    					Templates.varCount++;
    					instr += "store i32 %r" + (Templates.varCount-2) + ", double* %r" + (Templates.varCount-1);
    				}else{
    					instr += "%r" + Templates.varCount + " = alloca double \n";
    					refList.add(Templates.varCount);
    					Templates.varCount++;
    					instr += "store double %r" + (Templates.varCount-2) + ", double* %r" + (Templates.varCount-1);
    				}
    				instrStack.push(instr);
    				instrStack.showStack();
    			}else{
    				//ref
    				String instr = "";
    				if(types.get(i) == Type.INT){
    					instr += "%r" + Templates.varCount + " = fptosi double %r" + (int)num.number + " to i32 \n";
    					Templates.varCount++;
    					instr += "%r" + Templates.varCount + " = alloca i32 \n";
    					refList.add(Templates.varCount);
    					Templates.varCount++;
    					instr += "store i32 %r" + (Templates.varCount-2) + ", i32* %r" + (Templates.varCount-1);
    				}else{
    					instr += "%r" + Templates.varCount + " = alloca double \n";
    					refList.add(Templates.varCount);
    					Templates.varCount++;
    					instr += "store double %r" + (Templates.varCount-2) + ", double* %r" + (Templates.varCount-1);
    				}
    				
					instrStack.push(instr);
    				instrStack.showStack();
    			}
    		}
    		
    		String instr = "";
    		instr += "%r" + Templates.varCount + " = call " + retType + " @" + funName + "(";
    		Templates.varCount++;
    		for(int i = 0; i<typesName.size(); i++){
    			String t = typesName.get(i);
    			instr += t + " %r" + refList.get(i);
    			if(i != typesName.size()-1){
    				instr += ", ";
    			}
    		}
    		instr += ")";
    		
    		instrStack.push(instr);
			instrStack.showStack();
    		
	    }
	    
	    @Override
	    public void exitFactor(FactorContext ctx) {
	        if(ctx.getChildCount() == 1 && ctx.getChild(0) instanceof NameContext){
	        	String name = ctx.getText();
	        	if(!ProgramInfo.getInstance().nameExists(name)){
	        		System.out.println("Name " + name + " does not exist!");
	        		System.exit(1);
	        	}
	        	
	        	boolean fun = ProgramInfo.getInstance().isFunction(name);
	        	
	        	if(!fun){
	        		String k = "%";
		        	if(ProgramInfo.getInstance().getVariableContext(name).equals("global")){
		        		k = "@";
		        	}
		        	
		        	
		        	Type type = ProgramInfo.getInstance().getVariableType(name);
		        	if(type == Type.FLOAT){
		        		String instr = "%r" + Templates.varCount + " = load double* " + k + name + " ";
		        		Templates.varCount++;
		        		Num num = new Num();
		        		num.type = Type.REF;
		        		num.number = Templates.varCount-1;
		        		numStack.push(num);
		        		instrStack.push(instr);
		        	}else if(type == Type.INT){
		        		String instr = "%r" + Templates.varCount + " = load i32* "+ k + name + " \n";
		        		Templates.varCount++;
		        		instr +=  "%r" + Templates.varCount + " = sitofp i32 %r" + (Templates.varCount-1) + " to double";
		        		Templates.varCount++;
		        		Num num = new Num();
		        		num.type = Type.REF;
		        		num.number = Templates.varCount-1;
		        		numStack.push(num);
		        		instrStack.push(instr);
		        	}
		        	
		        	/*Num num = new Num(0, Type.NAME);
		        	num.name = name;
		        	numStack.push(num);
		        	numStack.showStack();*/
	        	}else{
	        		
	        		
		    		
	        	}
	        	
	        	
	        	
	        	
	        	numStack.showStack();
	        	instrStack.showStack();
	        }else if(ctx.getChildCount() == 1 && ctx.getChild(0) instanceof Arr_refContext){
	        	String name = ctx.getChild(0).getChild(0).getText();
	        	int elementNumber = (int)Float.parseFloat(ctx.getChild(0).getChild(2).getText());
	        	if(!ProgramInfo.getInstance().nameExists(name)){
	        		System.out.println("Array " + name + " does not exist!");
	        		System.exit(1);
	        	}
	        	
	        	String k = "%";
	        	if(ProgramInfo.getInstance().getVariableContext(name).equals("global")){
	        		k = "@";
	        	}
	        	
	        	int maxSize = ProgramInfo.getInstance().getArrSize(name);
	        	if(elementNumber >= maxSize){
	        		System.out.println("Element number exceeds maximum array length!");
	        		elementNumber = maxSize-1;
	        	}
	        	Num num = numStack.pop();
	        	Type type = ProgramInfo.getInstance().getVariableType(name);
	        	
	        	String instr = "";
	    		if(type == Type.INT){
	    			instr += "%r" + Templates.varCount + " = getelementptr inbounds [" + maxSize + " x i32]* " + k + name + ", i32 0, i32 " + elementNumber + " \n";
	    			Templates.varCount++;
	    			instr += "%r" + Templates.varCount + " = load i32* %r" + (Templates.varCount-1) + "\n";
	    			Templates.varCount++;
	    			instr +=  "%r" + Templates.varCount + " = sitofp i32 %r" + (Templates.varCount-1) + " to double";
	    			Templates.varCount++;
	    			//dodaca na stos
	    			instrStack.push(instr);
	    			
	    			Num numarr = new Num();
	    			numarr.type = Type.REF;
	    			numarr.number = Templates.varCount-1;
	    			numStack.push(numarr);
	    		}else if(type == Type.FLOAT){
	    			instr += "%r" + Templates.varCount + " = getelementptr inbounds [" + maxSize + " x double]* " + k + name + ", i32 0, i32 " + elementNumber + " \n";
	    			Templates.varCount++;
	    			instr += "%r" + Templates.varCount + " = load double* %r" + (Templates.varCount-1) + "";
	    			Templates.varCount++;
	    			//dodac na stos
	    			instrStack.push(instr);
	    			Num numarr = new Num();
	    			numarr.type = Type.REF;
	    			numarr.number = Templates.varCount-1;
	    			numStack.push(numarr);
	    		}
	    		
	    		instrStack.showStack();
	        }else if(ctx.getChildCount() == 1 && ctx.getChild(0) instanceof Fun_nameContext){
	        	
	        	String name = ctx.getChild(0).getChild(0).getText();
	        	if(ProgramInfo.getInstance().getVariableType(name) == Type.INT){
	        		String instr = "";
	        		instr += "%r" + Templates.varCount + " = sitofp i32 %r" + (Templates.varCount-1) + " to double";
	        		Templates.varCount++;
	        		instrStack.push(instr);
	        	}else{
	        		
	        	}
	        	
	        	Num num = new Num();
        		num.type = Type.REF;
        		num.number = Templates.varCount-1;
        		numStack.push(num);
	        	
	        	
	        	
	        }
	    }
	    
	    @Override
	    public void exitExpr(ExprContext ctx) {
	    	int childCount = ctx.getChildCount();
	    	if(childCount >= 3 && !ctx.getChild(0).getText().equals("(")){
	    		for(int i=childCount-1; i>=0; i--){
	    			if(ctx.getChild(i) instanceof TermContext){
	    				if(i == childCount-1){
	    					Num num = numStack.pop();
	    					String instr = Templates.startExpr(num);
	    					instrStack.push(instr);
	    					//System.out.println(instr);
	    				}else{
	    					if(ctx.getChild(i+1).getText().equals("+")){
	    						Num num = numStack.pop();
	    						String instr = Templates.addNext(num);
	    						instrStack.push(instr);
	    						//System.out.println(instr);
	    					}else{
	    						Num num = numStack.pop();
	    						String instr = Templates.subNext(num);
	    						instrStack.push(instr);
	    						//System.out.println(instr);
	    					}
	    				}
	    			}
	    		}
	    		Num num = new Num();
	    		num.number = Templates.varCount-1;
	    		num.type = Type.REF;
	    		numStack.push(num);
	    		numStack.showStack();
	    		instrStack.showStack();
	    	}
	    }
	    
	    @Override
	    public void exitTerm(TermContext ctx){
	    	int childCount = ctx.getChildCount();
	    	if(childCount >= 3 && !ctx.getChild(0).getText().equals("(")){
	    		for(int i=childCount-1; i>=0; i--){
	    			if(ctx.getChild(i) instanceof FactorContext){
	    				if(i == childCount-1){
	    					Num num = numStack.pop();
	    					String instr = Templates.startExpr(num);
	    					instrStack.push(instr);
	    					//System.out.println(instr);
	    				}else{
	    					if(ctx.getChild(i+1).getText().equals("*")){
	    						Num num = numStack.pop();
	    						String instr = Templates.mulNext(num);
	    						instrStack.push(instr);
	    						//System.out.println(instr);
	    					}else{
	    						Num num = numStack.pop();
	    						String instr = Templates.divNext(num);
	    						instrStack.push(instr);
	    						//System.out.println(instr);
	    					}
	    				}
	    			}
	    		}
	    		Num num = new Num();
	    		num.number = Templates.varCount-1;
	    		num.type = Type.REF;
	    		numStack.push(num);
	    		numStack.showStack();
	    		instrStack.showStack();
	    	}
	    }
	    
	    @Override
	    public void exitNumber(NumberContext ctx) {
	        if(ctx.getChild(0) instanceof IntegContext){
	        	int number = Integer.parseInt(ctx.getText());
	        	Type type = Type.INT;
	        	numStack.push(number, type);
	        }else{
	        	float number = Float.parseFloat(ctx.getText());
	        	Type type = Type.FLOAT;
	        	numStack.push(number, type);
	        }
	        numStack.showStack();
	    }
	    
	    @Override
	    public void exitDeclare(DeclareContext ctx){
	    	Type type = Type.INT;
	    	if(ctx.getChild(0).getChild(0) instanceof Integer_nameContext){
	    		type = Type.INT;
	    	}else if(ctx.getChild(0).getChild(0) instanceof Float_nameContext){
	    		type = Type.FLOAT;
	    	}else if(ctx.getChild(0).getChild(0) instanceof String_nameContext){
	    		type = Type.STRING;
	    	}else{
	    		System.out.println("Name error!");
	    		System.exit(1);
	    	}
	    	String name = ctx.getChild(1).getText();
	    	String instruction = Templates.declare(type, name, ctx.getText());
	    	ProgramInfo.getInstance().addVariable(name, type);
	    	instrStack.push(instruction);
	    }
	    
	    @Override
	    public void exitGlobal_declare(Global_declareContext ctx) {
	    	Type type = Type.INT;
	    	if(ctx.getChild(1).getChild(0) instanceof Integer_nameContext){
	    		type = Type.INT;
	    	}else if(ctx.getChild(1).getChild(0) instanceof Float_nameContext){
	    		type = Type.FLOAT;
	    	}else if(ctx.getChild(1).getChild(0) instanceof String_nameContext){
	    		type = Type.STRING;
	    	}else{
	    		System.out.println("Name error!");
	    		System.exit(1);
	    	}
	    	String name = ctx.getChild(2).getText();
	    	String instruction = Templates.globalDeclare(type, name, ctx.getText());
	    	Variable var = new Variable(name, type);
	    	var.context = "global";
	    	ProgramInfo.getInstance().addVariable(var);
	    	instrStack.addGlobalVariable(instruction);
	    	
	    }

	    
	    @Override
	    public void exitDefine(DefineContext ctx){
	    	Type type = Type.INT;
	    	if(ctx.getChild(0).getChild(0) instanceof Integer_nameContext){
	    		type = Type.INT;
	    	}else if(ctx.getChild(0).getChild(0) instanceof Float_nameContext){
	    		type = Type.FLOAT;
	    	}else if(ctx.getChild(0).getChild(0) instanceof String_nameContext){
	    		type = Type.STRING;
	    	}else{
	    		System.out.println("Error with defining variable!");
	    		System.exit(1);
	    	}
	    	
	    	String name = ctx.getChild(1).getText();
	    	
	    	if(type == Type.STRING){
	    		String value = ctx.getChild(3).getText();
	    		value = value.substring(1, value.length()-1);
	    		String instr = Templates.defineString(name, value);
	    		Variable var = new Variable(name, type);
	    		var.size = value.length();
		    	ProgramInfo.getInstance().addVariable(var);
		    	instrStack.push(instr);
		    	instrStack.showStack();
	    	}else{
	    		Num num = numStack.pop();
		    	String instr = Templates.define(type, name, num);
		    	ProgramInfo.getInstance().addVariable(name, type);
		    	instrStack.push(instr);
		    	instrStack.showStack();
	    	}
	    	
	    	
	    	
	    }
	    
	    @Override
	    public void exitGlobal_define(Global_defineContext ctx){
	    	Type type = Type.INT;
	    	if(ctx.getChild(1).getChild(0) instanceof Integer_nameContext){
	    		type = Type.INT;
	    	}else if(ctx.getChild(1).getChild(0) instanceof Float_nameContext){
	    		type = Type.FLOAT;
	    	}else if(ctx.getChild(1).getChild(0) instanceof String_nameContext){
	    		type = Type.STRING;
	    	}else{
	    		System.out.println("Error with defining variable!");
	    		System.exit(1);
	    	}
	    	
	    	String name = ctx.getChild(2).getText();
	    	
	    	if(type == Type.STRING){
	    		String value = ctx.getChild(4).getText();
	    		value = value.substring(1, value.length()-1);
	    		String instrDec = Templates.globalDeclareString(name, value);
	    		instrStack.addGlobalVariable(instrDec);
	    		Variable var = new Variable(name, type);
	    		var.size = value.length();
	    		var.context = "global";
		    	ProgramInfo.getInstance().addVariable(var);
		    	String instr = Templates.globalDefineString(name, value);
		    	instrStack.push(instr);
		    	instrStack.showStack();
	    	}else{
	    		Num num = numStack.pop();
	    		
	    		String instrDec = Templates.globalDeclare(type, name, ctx.getText());
	    		instrStack.addGlobalVariable(instrDec);
	    		
		    	String instr = Templates.globalDefine(type, name, num);
		    	Variable var = new Variable(name, type);
		    	var.context = "global";
		    	ProgramInfo.getInstance().addVariable(var);
		    	instrStack.push(instr);
		    	instrStack.showStack();
	    	}
	    	
	    	
	    	
	    }
	    
	    
	    
	    @Override
	    public void exitAssign(AssignContext ctx){
	    	String name = ctx.getChild(0).getText();
	    	
	    	if(!ProgramInfo.getInstance().nameExists(name)){
	    		System.out.println("Variable " + name + " does not exist!");
	    		System.exit(1);
	    	}
	    	
	    	if(ProgramInfo.getInstance().getVariableType(name) == Type.STRING){
	    		if(ctx.getChild(2).getChild(0) instanceof StringContext){
		    		String value = ctx.getChild(2).getText();
		    		value = value.substring(1, value.length()-1);
		    		String instr = Templates.assignString(name, value);
			    	instrStack.push(instr);
			    	instrStack.showStack();
		    	}
	    	}else{
	    		Num val = numStack.pop();
		    	String instr = Templates.assign(name, val);
		    	instrStack.push(instr);
		    	instrStack.showStack();
	    	}
	    	
	    	
	    	
	    	
	    }
	    
	    @Override
	    public void exitPrint(PrintContext ctx){
	    	Num num = numStack.pop();
	    	String instr = Templates.printInteger(num);
	    	instrStack.push(instr);
	    	instrStack.showStack();
	    }
	    
	    @Override
	    public void exitPrints(PrintsContext ctx){
	    	
	    	if(ctx.getChild(1) instanceof NameContext){
	    		String name = ctx.getChild(1).getText();
	    		if(!ProgramInfo.getInstance().nameExists(name)){
	    			System.out.println("Variable " + name + " does not exist!");
	    			System.exit(1);
	    		}
	    		if(ProgramInfo.getInstance().getVariableType(name) != Type.STRING){
	    			System.out.println("Variable " + name + " is not a string!");
	    			System.exit(1);
	    		}
	    		String instr  = Templates.printString(name);
		    	instrStack.push(instr);
		    	instrStack.showStack();
	    	}
	    	
	    	
	    }
	    
	    @Override
	    public void exitGetint(GetintContext ctx){
	    	String name = ctx.getChild(0).getText();
	    	if(!ProgramInfo.getInstance().nameExists(name)){
	    		System.out.println("Variable " + name + " does not exist!");
	    		System.exit(1);
	    	}
	    	if(!ctx.getChild(1).getText().equals("[")){
	    		String instr = Templates.getInt(name);
		    	instrStack.push(instr);
		    	instrStack.showStack();
	    	}else{
	    		Num num = numStack.pop();
	    		int elementNumber = (int)Float.parseFloat(ctx.getChild(2).getText());
	    		String instr = Templates.getIntArr(name, elementNumber);
		    	instrStack.push(instr);
		    	instrStack.showStack();
	    	}
	    	
	    }
	    
	    @Override
	    public void exitGetfloat(GetfloatContext ctx){
	    	String name = ctx.getChild(0).getText();
	    	if(!ProgramInfo.getInstance().nameExists(name)){
	    		System.out.println("Variable " + name + " does not exist!");
	    		System.exit(1);
	    	}
	    	if(!ctx.getChild(1).getText().equals("[")){
	    		String instr = Templates.getFloat(name);
		    	instrStack.push(instr);
		    	instrStack.showStack();
	    	}else{
	    		Num num = numStack.pop();
	    		int elementNumber = (int)Float.parseFloat(ctx.getChild(2).getText());
	    		String instr = Templates.getFloatArr(name, elementNumber);
		    	instrStack.push(instr);
		    	instrStack.showStack();
	    	}
	    	
	    }
	    
	    @Override
	    public void exitDefine_arr(Define_arrContext ctx) {
	    	String name = ctx.getChild(4).getText();
	    	Type type = Type.INT;
	    	if(ctx.getChild(0).getChild(0) instanceof Integer_nameContext){
	    		type = Type.INT;
	    	}else if(ctx.getChild(0).getChild(0) instanceof Float_nameContext){
	    		type = Type.FLOAT;
	    	}
	    	Num num = numStack.pop();
	    	int size = (int)Float.parseFloat(ctx.getChild(2).getText());
	    	
	    	if(ProgramInfo.getInstance().nameExists(name)){
	    		System.out.println("Name: " + name + " already exists!");
	    		System.exit(1);
	    	}
	    	
	    	String instr = Templates.defineArr(type, name, size);
	    	instrStack.push(instr);
	    	instrStack.showStack();
	    	
	    	Variable var = new Variable(name, type);
	    	var.size = size;
	    	ProgramInfo.getInstance().addVariable(var);
	    }
	    
	    @Override
	    public void exitGlobal_define_arr(Global_define_arrContext ctx) {
	    	String name = ctx.getChild(5).getText();
	    	Type type = Type.INT;
	    	if(ctx.getChild(1).getChild(0) instanceof Integer_nameContext){
	    		type = Type.INT;
	    	}else if(ctx.getChild(1).getChild(0) instanceof Float_nameContext){
	    		type = Type.FLOAT;
	    	}
	    	Num num = numStack.pop();
	    	int size = (int)Float.parseFloat(ctx.getChild(3).getText());
	    	
	    	if(ProgramInfo.getInstance().nameExists(name)){
	    		System.out.println("Name: " + name + " already exists!");
	    		System.exit(1);
	    	}
	    	
	    	String instrDec = Templates.globalArrDeclare(type, name, size);
	    	instrStack.addGlobalVariable(instrDec);
	    	
	    	/*String instr = Templates.defineArr(type, name, size);
	    	instrStack.push(instr);*/
	    	instrStack.showStack();
	    	
	    	Variable var = new Variable(name, type);
	    	var.size = size;
	    	var.context = "global";
	    	ProgramInfo.getInstance().addVariable(var);
	    }
	    
	    @Override
	    public void exitAssign_arr(Assign_arrContext ctx){
	    	Num num = numStack.pop();
	    	String name = ctx.getChild(0).getText();
	    	if(!ProgramInfo.getInstance().nameExists(name)){
	    		System.out.println("Name " + name + " does not exist!");
	    		System.exit(1);
	    	}
	    	int elementNumber = (int)Float.parseFloat(ctx.getChild(2).getText());
	    	int maxSize = ProgramInfo.getInstance().getArrSize(name);
	    	if(maxSize == 0){
	    		System.out.println("Variable " + name + " is not an array!");
	    		System.exit(1);
	    	}
	    	if(elementNumber >= maxSize){
	    		System.out.println("Exceding maximum array size!");
	    		elementNumber = maxSize-1;
	    	}
	    	
	    	String instr = Templates.assignArr(name, elementNumber, num, maxSize);
	    	instrStack.push(instr);
	    	instrStack.showStack();
	    	
	    }
	    
	    
	    @Override
	    public void exitRepeat_start(Repeat_startContext ctx) {
	    	String instr = "";
	    	Num num = numStack.pop();
	    	
	    	
	    	int repeatStart = brCounter;
	    	brCounter++;
	    	int repeatMid = brCounter;
	    	brCounter++;
	    	int repeatEnd = brCounter;
	    	brCounter++;
	    	
	    	brstack.push(repeatEnd);
	    	brstack.push(repeatStart);
	    	
	    	instr += "%r" + Templates.varCount + " = alloca i32 \n";
	    	int iterator = Templates.varCount;
	    	Templates.varCount++;
	    	
	    	instr += "store i32 0, i32* %r" + iterator + " \n";
	    	instr += "br label %br" + repeatStart + "\n";
	    	instr += "br" + repeatStart + ": \n";
	    	instr += "%r" + Templates.varCount + " = load i32* %r" + iterator + "\n";
	    	int iter = Templates.varCount;
	    	Templates.varCount++;
	    	
	    	instr += "%r" + Templates.varCount + " = add nsw i32 %r" + (Templates.varCount-1) + ", 1 \n";
	    	Templates.varCount++;
	    	
	    	instr += "store i32 %r" + (Templates.varCount-1) + ", i32* %r" + iterator + " \n";
	    	
	    	if(num.type == Type.FLOAT || num.type == Type.INT){
	    		instr += "%r" + Templates.varCount + " = icmp slt i32 %r" + iter + "," + (int)num.number + " \n";
	    		Templates.varCount++;
	    		
		    	
	    	}else if(num.type == Type.REF){
	    		instr +=  "%r" + Templates.varCount + " = fptosi double %r" + (int)num.number + " to i32 \n";
	    		Templates.varCount ++;
	    		
	    		instr += "%r" + Templates.varCount + " = icmp slt i32 %r" + iter + ", %r" + (Templates.varCount-1) + " \n";
	    		Templates.varCount++;
	    		
	    	}
	    	
	    	instr += "br i1 %r" + (Templates.varCount-1) + " , label %br" + repeatMid + ", label %br" + repeatEnd + " \n";
	    	
	    	instr += "br" + repeatMid + ": \n";
	    	
	    	instrStack.push(instr);
	    	
	    }
	    
	    @Override
	    public void exitRepeat_statement(Repeat_statementContext ctx) {
	    	String instr = "";
	    	int repeatStart = brstack.pop();
	    	int repeatEnd = brstack.pop();
	    	instr += "br label %br" + repeatStart + "\n" ;
	    	instr += "br" + repeatEnd + ": ";
	    	instrStack.push(instr);
	    }
	    
	    @Override
	    public void exitIf_condition(If_conditionContext ctx){
	    	String instr = "";
	    	Num num2 = numStack.pop();
	    	Num num1 = numStack.pop();
	    	boolean doubleComparison = false;
	    	if(num1.type == Type.REF || num2.type == Type.REF){
	    		doubleComparison = true;
	    	}
	    	if(num1.type == Type.FLOAT || num2.type == Type.FLOAT){
	    		doubleComparison = true;
	    	}
	    	
	    	
	    	
	    	if(doubleComparison){
	    		
	    		doubleComparision(num1, num2, ctx);
	    		
	    	}else{

	    		intComparision(num1, num2, ctx);
	    		
	    	}
	    	
	    	
	    }
	    
	    public void doubleComparision(Num num1, Num num2, If_conditionContext ctx){
	    	String instr = "";
	    	String cmp = "";
	    	int reg1 = 0;
	    	int reg2 = 0;
	    	
	    	if(num1.type == Type.FLOAT || num1.type == Type.INT){
	    		instr += "%r" + Templates.varCount + " = fadd double 0.0, " + (float)num1.number + "\n";
	    		reg1 = Templates.varCount;
	    		Templates.varCount++;
	    	}else if(num1.type == Type.REF){
	    		reg1 = (int)num1.number;
	    	}
	    	
	    	if(num2.type == Type.FLOAT || num2.type == Type.INT){
	    		instr += "%r" + Templates.varCount + " = fadd double 0.0, " + (float)num2.number + "\n";
	    		reg2 = Templates.varCount;
	    		Templates.varCount++;
	    	}else if(num2.type == Type.REF){
	    		reg2 = (int)num2.number;
	    	}
	    	
	    	if(ctx.getChild(1).getText().equals("==")){
	    		cmp = "oeq";
	    	}else if(ctx.getChild(1).getText().equals(">=")){
	    		cmp = "oge";
	    	}else if(ctx.getChild(1).getText().equals("<=")){
	    		cmp = "ole";
	    	}else if(ctx.getChild(1).getText().equals(">")){
	    		cmp = "ogt";
	    	}else if(ctx.getChild(1).getText().equals("<")){
	    		cmp = "olt";
	    	}
	    	
	    	
	    	instr += "%r" + Templates.varCount + " = fcmp " + cmp + " double %r" + reg1 + ", %r" + reg2 + "\n";
    		Templates.varCount++;
    		int iftrue = brCounter;
    		brCounter++;
    		int iffalse = brCounter;
    		brCounter++;
    		instr += "br i1 %r" + (Templates.varCount-1) + ", label %br" + iftrue + ", label %br" + iffalse + " \n";
    		instr += "br" + iftrue + ": \n";
    		brstack.push(iffalse);
	    	
	    	instrStack.push(instr);
	    	instrStack.showStack();
    		
	    	
	    }
	    
	    public void intComparision(Num num1, Num num2, If_conditionContext ctx){
	    	String instr = "";
	    	String cmp = "";
	    	
	    	if(ctx.getChild(1).getText().equals("==")){
	    		cmp = "eq";
	    	}else if(ctx.getChild(1).getText().equals(">=")){
	    		cmp = "sge";
	    	}else if(ctx.getChild(1).getText().equals("<=")){
	    		cmp = "sle";
	    	}else if(ctx.getChild(1).getText().equals(">")){
	    		cmp = "sgt";
	    	}else if(ctx.getChild(1).getText().equals("<")){
	    		cmp = "slt";
	    	}
	    	
	    	instr += "%r" + Templates.varCount + " = icmp " + cmp + " i32 " + (int)num1.number + ", " + (int)num2.number + "\n";
    		Templates.varCount++;
    		int iftrue = brCounter;
    		brCounter++;
    		int iffalse = brCounter;
    		brCounter++;
    		instr += "br i1 %r" + (Templates.varCount-1) + ", label %br" + iftrue + ", label %br" + iffalse + " \n";
    		instr += "br" + iftrue + ": \n";
    		brstack.push(iffalse);
	    	
	    	instrStack.push(instr);
	    	instrStack.showStack();
	    }
	    
	    @Override
	    public void exitIf_statement(If_statementContext ctx){
	    	String instr = "";
	    	int iffalse = brstack.pop();
	    	instr += "br label %br" + iffalse + "\n";
	    	instr += "br" + iffalse + ": ";
	    	instrStack.push(instr);
	    	instrStack.showStack();
	    }
	    
	    @Override
	    public void exitFunction_head(Function_headContext ctx){
	    	
	    	Type type = Type.VOID;
	    	String typeName = "void";
	    	String name = "";
	    	if(ctx.getChild(1) instanceof NoneContext){
	    		type = Type.VOID;
	    		typeName = "void";
	    	}else if(ctx.getChild(1).getChild(0) instanceof Integer_nameContext){
	    		type = Type.INT;
	    		typeName = "i32";
	    	}else if(ctx.getChild(1).getChild(0) instanceof Float_nameContext){
	    		type = Type.FLOAT;
	    		typeName = "double";
	    	}else if(ctx.getChild(1).getChild(0) instanceof String_nameContext){
	    		type = Type.STRING;
	    		typeName = "void";
	    	}
	    	
	    	name = ctx.getChild(2).getText();
	    	
	    	ProgramInfo.currentContext = name;
	    	
	    	ArrayList<Variable> arguments = new ArrayList<Variable>();
	    	int argumentCount = ctx.getChild(3).getChildCount();
	    	for(int i=0; i<argumentCount; i++){
	    		String argName = ctx.getChild(3).getChild(i).getChild(1).getText();
	    		Type argType = Type.INT;
	    		if(ctx.getChild(3).getChild(i).getChild(0).getChild(0) instanceof Integer_nameContext){
	    			argType = Type.INT;
	    		}else if(ctx.getChild(3).getChild(i).getChild(0).getChild(0) instanceof Float_nameContext){
	    			argType = Type.FLOAT;
	    		}else if(ctx.getChild(3).getChild(i).getChild(0).getChild(0) instanceof String_nameContext){
	    			argType = Type.STRING;
	    		}
	    		Variable var = new Variable(argName, argType);
	    		arguments.add(var);
	    		var.context = name;
	    		ProgramInfo.getInstance().addVariable(var);
	    	}
	    	
	    	String instr = "";
	    	instr += "define " + typeName + " @" + name + "( ";
	    	for(int i=0; i<argumentCount; i++){
	    		
	    		Variable var = arguments.get(i);
	    		String varType = var.type.name().toLowerCase();
	    		if(varType.equals("float")) varType = "double*";
	    		if(varType.equals("int")) varType = "i32*";
	    		instr += "" + varType + " %" + var.name;
	    		if(i != argumentCount-1){
	    			instr += ", ";
	    		}
	    	}
	    	instr += ") { \n";
	    	
	    	System.out.println(instr);
	    	instrStack.markFunctionStart();
	    	instrStack.push(instr);
	    	instrStack.showStack();
	    	
	    	Variable var = new Variable(name, type);
	    	var.fun = true;
	    	for(Variable v : arguments){
	    		var.arguments.add(v.type);
	    	}
	    	ProgramInfo.getInstance().addVariable(var);
	    }
	    
	    @Override
	    public void exitFunction_statement(Function_statementContext ctx){
	    	String instr = "}";
	    	instrStack.push(instr);
	    	String fun = instrStack.splitLastFunction();
	    	instrStack.showStack();
	    	
	    	System.out.println("Fun: ");
	    	System.out.println(fun);
	    	
	    	instrStack.addGlobalVariable(fun);
	    	ProgramInfo.currentContext = "main";
	    	
	    }
	    
	    @Override
	    public void exitRet_statement(Ret_statementContext ctx){
	    	String instr = "";
	    	String context = ProgramInfo.currentContext;
	    	String retType = "i32";
	    	
	    	if(context.equals("main")){
	    		retType = "i32";
	    	}else{
	    		Type type = Type.INT;
	    		type = ProgramInfo.getInstance().getVariableType(context);
	    		if(type == Type.INT){
	    			retType = "i32";
	    		}else if(type == Type.FLOAT){
	    			retType = "double";
	    		}else if(type == Type.VOID){
	    			retType = "void";
	    		}
	    	}
	    	
	    	Num num;
	    	if(!retType.equals("void")){
	    		num = numStack.pop();
	    		if(num.type == Type.FLOAT || num.type == Type.INT){
		    		if(retType.equals("i32")){
		    			instr += "ret " + retType + " " + (int)num.number;
		    		}else{
		    			instr += "ret " + retType + " " + (float)num.number;
		    		}
		    	}else if(num.type == Type.REF){
		    		if(retType.equals("i32")){
		    			instr += "%r" + Templates.varCount + " = fptosi double %r" + (int)num.number + " to i32 \n";
		    			Templates.varCount++;
		    			instr += "ret " + retType + " %r" + (Templates.varCount-1) + "";
		    		}else{
		    			instr += "ret " + retType + " %r" + (int)num.number;
		    		}
		    		
		    	}
	    	}else{
	    		instr = "ret void";
	    	}
	    	
	    	
	    	
	    	
	    	
	    	instrStack.push(instr);
	    	instrStack.showStack();
	    }
	    

}
