package main;

public class Templates {
	
	enum Type{INT, FLOAT, NAME, REF, STRING, VOID};
	
	public static int varCount = 0;

	public Templates() {
		
	}
	
	public static String declare(Type type, String name, String source){
		String instruction = "";
		if(type == Type.INT){
			instruction = "%" + name + " = alloca i32 ; " + source;
		}else if(type == Type.FLOAT){
			instruction = "%" + name + " = alloca double ; " + source;
		}else if(type == Type.STRING){
			instruction += "%" + name + " = alloca [100 x i8]";
		}
		return instruction;
	}
	
	public static String globalDeclare(Type type, String name, String source){
		String instruction = "";
		if(type == Type.INT){
			instruction = "@" + name + " = common global i32 0 ; " + source;
		}else if(type == Type.FLOAT){
			instruction = "@" + name + " = common global double 0.0; " + source;
		}else if(type == Type.STRING){
			instruction += "@" + name + " = common global [100 x i8] zeroinitializer";
		}
		return instruction;
	}
	
	public static String globalArrDeclare(Type type, String name, int size){
		String instruction = "";
		if(type == Type.INT){
			instruction += "@" + name + " = common global [" + size + " x i32] zeroinitializer";
		}else if(type == Type.FLOAT){
			instruction += "@" + name + " = common global [" + size + " x double] zeroinitializer";
		}
		return instruction;
	}
	
	
	
	public static String define(Type type, String name, Num num){
		String instruction = "";
		if(type == Type.FLOAT){
			instruction = "%" + name + " = alloca double \n";
			if(num.type == Type.NAME){
				Type nameType = ProgramInfo.getInstance().getVariableType(num.name);
				if(nameType == Type.INT){
					instruction += "%r" + varCount + " = load i32* %" + num.name + " \n";
					varCount++;
					instruction +=  "%r" + varCount + " = sitofp i32 %r" + (varCount-1) + " to double \n";
					varCount ++;
					instruction += "store double %r" + (varCount-1) + ", double* %" + name;
				}else{
					instruction += "%r" + varCount + " = load double* %" + num.name + " \n";
					varCount++;
					instruction += "store double %r" + (varCount-1) + ", double* %" + name;
				}
			}else if(num.type == Type.REF){
				instruction += "store double %r" + (int)num.number + ", double* %" + name;
			}else if(num.type == Type.INT || num.type == Type.FLOAT){
				//number
				instruction += "store double " + (float)num.number + ", double* %" + name;
			}
		}else if(type == Type.INT){
			//integer
			instruction = "%" + name + " = alloca i32 \n";
			if(num.type == Type.NAME){
				Type nameType = ProgramInfo.getInstance().getVariableType(num.name);
				if(nameType == Type.INT){
					instruction += "%r" + varCount + " = load i32* %" + num.name + " \n";
					varCount++;
					instruction += "store i32 %r" + (varCount-1) + ", i32* %" + name;
				}else{
					instruction += "%r" + varCount + " = load double* %" + num.name + " \n";
					varCount++;
					instruction +=  "%r" + varCount + " = fptosi double %r" + (varCount-1) + " to i32 \n";
					varCount ++;
					instruction += "store i32 %r" + (varCount-1) + ", i32* %" + name;
				}
			}else if(num.type == Type.REF){
				instruction +=  "%r" + varCount + " = fptosi double %r" + (int)num.number + " to i32 \n";
				varCount ++;
				instruction += "store i32 %r" + (varCount-1) + ", i32* %" + name;
			}else if(num.type == Type.INT || num.type == Type.FLOAT){
				//number
				instruction += "store i32 " + (int)num.number + ", i32* %" + name;
			}
		}else if(type == Type.STRING){
			
		}
		
		return instruction;
	}
	
	public static String globalDefine(Type type, String name, Num num){
		String instruction = "";
		if(type == Type.FLOAT){
			//instruction = "@" + name + " = alloca double \n";
			if(num.type == Type.NAME){
				Type nameType = ProgramInfo.getInstance().getVariableType(num.name);
				if(nameType == Type.INT){
					instruction += "%r" + varCount + " = load i32* %" + num.name + " \n";
					varCount++;
					instruction +=  "%r" + varCount + " = sitofp i32 %r" + (varCount-1) + " to double \n";
					varCount ++;
					instruction += "store double %r" + (varCount-1) + ", double* @" + name;
				}else{
					instruction += "%r" + varCount + " = load double* %" + num.name + " \n";
					varCount++;
					instruction += "store double %r" + (varCount-1) + ", double* @" + name;
				}
			}else if(num.type == Type.REF){
				instruction += "store double %r" + (int)num.number + ", double* @" + name;
			}else if(num.type == Type.INT || num.type == Type.FLOAT){
				//number
				instruction += "store double " + (float)num.number + ", double* @" + name;
			}
		}else if(type == Type.INT){
			//integer
			//instruction = "%" + name + " = alloca i32 \n";
			if(num.type == Type.NAME){
				Type nameType = ProgramInfo.getInstance().getVariableType(num.name);
				if(nameType == Type.INT){
					instruction += "%r" + varCount + " = load i32* %" + num.name + " \n";
					varCount++;
					instruction += "store i32 %r" + (varCount-1) + ", i32* @" + name;
				}else{
					instruction += "%r" + varCount + " = load double* %" + num.name + " \n";
					varCount++;
					instruction +=  "%r" + varCount + " = fptosi double %r" + (varCount-1) + " to i32 \n";
					varCount ++;
					instruction += "store i32 %r" + (varCount-1) + ", i32* @" + name;
				}
			}else if(num.type == Type.REF){
				instruction +=  "%r" + varCount + " = fptosi double %r" + (int)num.number + " to i32 \n";
				varCount ++;
				instruction += "store i32 %r" + (varCount-1) + ", i32* @" + name;
			}else if(num.type == Type.INT || num.type == Type.FLOAT){
				//number
				instruction += "store i32 " + (int)num.number + ", i32* @" + name;
			}
		}else if(type == Type.STRING){
			
		}
		
		return instruction;
	}
	
	public static String defineString(String name, String value){
		String instr = "";
		int size = value.length();
		instr += "%" + name + " = alloca [" + 100 + " x i8] \n";
		for(int i=0; i<size; i++){
			char c = value.charAt(i);
			instr += "%r" + varCount + " = getelementptr inbounds [" + 100 + " x i8]* %" + name + " , i32 0, i32 " + i + " \n";
			instr += "store i8 " + (int)c + ", i8* %r" + varCount + " \n";
			varCount++;
		}
		return instr;
	}
	
	public static String globalDeclareString(String name, String value){
		String instr = "";
		int size = value.length();
		instr += "@" + name + " = common global [" + 100 + " x i8] zeroinitializer";
		
		return instr;
	}
	
	public static String globalDefineString(String name, String value){
		String instr = "";
		int size = value.length();
		for(int i=0; i<size; i++){
			char c = value.charAt(i);
			instr += "%r" + varCount + " = getelementptr inbounds [" + 100 + " x i8]* @" + name + " , i32 0, i32 " + i + " \n";
			instr += "store i8 " + (int)c + ", i8* %r" + varCount + " \n";
			varCount++;
		}
		return instr;
	}
	
	public static String startExpr(Num f){
		String instr = "";
		if(f.type == Type.NAME){
			if(ProgramInfo.getInstance().getVariableContext(f.name).equals("global")){
				instr += "%r" + varCount + " = fadd double @" + f.name + " , 0.0";
			}else{
				instr += "%r" + varCount + " = fadd double %" + f.name + " , 0.0";
			}
			
		}else if(f.type == Type.INT){
			instr = "%r" + varCount + " = fadd double " + (float)f.number + " , 0.0";
		}else if(f.type == Type.FLOAT){
			instr += "%r" + varCount + " = fadd double " + (float)f.number + " , 0.0";
		}else{
			instr += "%r" + varCount + " = fadd double %r" + (int)f.number + " , 0.0";
		}
		varCount++;
		return instr;
	}
	
	public static String mulNext(Num f){
		String instr = "";
		if(f.type == Type.NAME){
			if(ProgramInfo.getInstance().getVariableContext(f.name).equals("global")){
				instr = "%r" + varCount + " = fmul double %r" + (varCount-1) + " , " + f.name;
			}else{
				instr = "%r" + varCount + " = fmul double %r" + (varCount-1) + " , %" + f.name;
			}
			
		}else if(f.type == Type.INT){
			instr = "%r" + varCount + " = fmul double %r" + (varCount-1) + " , " + (float)f.number ;
		}else if(f.type == Type.FLOAT){
			instr = "%r" + varCount + " = fmul double %r" + (varCount-1) + " , " + (float)f.number;
		}else{
			instr = "%r" + varCount + " = fmul double %r" + (varCount-1) + " , %r" + (int)f.number;
		}
		varCount++;
		return instr;
	}
	
	public static String divNext(Num f){
		String instr = "";
		if(f.type == Type.NAME){
			//instr = "%r" + varCount + " = fdiv double %r" + (varCount-1) + " , %" + f.name;
			if(ProgramInfo.getInstance().getVariableContext(f.name).equals("global")){
				instr = "%r" + varCount + " = fdiv double %" + f.name + " , @" + (varCount-1);
			}else{
				instr = "%r" + varCount + " = fdiv double %" + f.name + " , %" + (varCount-1);
			}
			
		}else if(f.type == Type.INT){
			//instr = "%r" + varCount + " = fdiv double %r" + (varCount-1) + " , " + (float)f.number ;
			instr = "%r" + varCount + " = fdiv double " + (float)f.number + " , %r" +  (varCount-1);
		}else if(f.type == Type.FLOAT){
			//instr = "%r" + varCount + " = fdiv double %r" + (varCount-1) + " , " + (float)f.number;
			instr = "%r" + varCount + " = fdiv double " + (float)f.number + " , %r" + (varCount-1);
		}else{
			//instr = "%r" + varCount + " = fdiv double %r" + (varCount-1) + " , %r" + (int)f.number;
			instr = "%r" + varCount + " = fdiv double %r" + (int)f.number + " , %r" + (varCount-1) ;
		}
		varCount++;
		return instr;
	}
	
	public static String addNext(Num f){
		String instr = "";
		if(f.type == Type.NAME){
			if(ProgramInfo.getInstance().getVariableContext(f.name).equals("global")){
				instr = "%r" + varCount + " = fadd double %r" + (varCount-1) + " , @" + f.name;
			}else{
				instr = "%r" + varCount + " = fadd double %r" + (varCount-1) + " , %" + f.name;
			}
		}else if(f.type == Type.INT){
			instr = "%r" + varCount + " = fadd double %r" + (varCount-1) + " , " + (float)f.number ;
		}else if(f.type == Type.FLOAT){
			instr = "%r" + varCount + " = fadd double %r" + (varCount-1) + " , " + (float)f.number;
		}else{
			instr = "%r" + varCount + " = fadd double %r" + (varCount-1) + " , %r" + (int)f.number;
		}
		varCount++;
		return instr;
	}
	
	public static String subNext(Num f){
		String instr = "";
		if(f.type == Type.NAME){
			if(ProgramInfo.getInstance().getVariableContext(f.name).equals("global")){
				instr = "%r" + varCount + " = fsub double @" + f.name + ", %r" + + (varCount-1);
			}else{
				instr = "%r" + varCount + " = fsub double %" + f.name + ", %r" + + (varCount-1);
			}
			
		}else if(f.type == Type.INT){
			instr = "%r" + varCount + " = fsub double " + (float)f.number + ", %r" + + (varCount-1);
		}else if(f.type == Type.FLOAT){
			instr = "%r" + varCount + " = fsub double " + (float)f.number + ", %r" + + (varCount-1);
		}else{
			instr = "%r" + varCount + " = fsub double %r" + (int)f.number + ", %r" + + (varCount-1);
		}
		varCount++;
		return instr;
	}
	
	public static String assignString(String name, String value){
		String instr = "";
		int newSize = value.length();
		ProgramInfo.getInstance().changeSize(name, newSize);
		for(int i=0; i<newSize; i++){
			char c = value.charAt(i);
			instr += "%r" + varCount + " = getelementptr inbounds [" + 100 + " x i8]* %" + name + " , i32 0, i32 " + i + " \n";
			instr += "store i8 " + (int)c + ", i8* %r" + varCount + " \n";
			varCount++;
		}
		return instr;
	}
	
	public static String assignArr(String name, int elementNumber, Num num, int maxSize){
		String instr = "";
		Type type = ProgramInfo.getInstance().getVariableType(name);
		
		String k = "%";
		if(ProgramInfo.getInstance().getVariableContext(name).equals("global")){
			k = "@";
		}
		
		if(type == Type.FLOAT){
					
			instr += "%r" + varCount + " = getelementptr inbounds [" + maxSize + " x double]* " + k + name + " , i32 0, i32 " + elementNumber + " \n";
			varCount++;
			if(num.type == Type.INT || num.type == Type.FLOAT){
				instr += "store double " + (float)num.number + ", double* %r" + (varCount-1);
			}else if(num.type == Type.REF){
				instr += "store double %r" + (int)num.number + ", double* %r" + (varCount-1);
			}
			
		}else if(type == Type.INT){
			
			instr += "%r" + varCount + " = getelementptr inbounds [" + maxSize + " x i32]* " + k + name + " , i32 0, i32 " + elementNumber + " \n";
			varCount++;
			if(num.type == Type.INT || num.type == Type.FLOAT){
				instr += "store i32 " + (int)num.number + ", i32* %r" + (varCount-1);
			}else if(num.type == Type.REF){
				instr +=  "%r" + varCount + " = fptosi double %r" + (int)num.number + " to i32 \n";
				varCount++;
				instr += "store i32 %r" + (varCount-1) + ", i32* %r" + (varCount-2);
			}
			
		}
		
		return instr;
	}
	
	public static String assign(String to, Num what){
		String instr = "";
		Type type = ProgramInfo.getInstance().getVariableType(to);
		
		
		
		String k = "%";
		if(ProgramInfo.getInstance().getVariableContext(to).equals("global")){
			k = "@";
		}
		
		if(type == Type.FLOAT){
			
			if(what.type == Type.FLOAT || what.type == Type.INT){
				instr += "store double " + (float)what.number + ", double* " + k  + to;
			}else if(what.type == Type.NAME){
				
				if(ProgramInfo.getInstance().getVariableType(what.name) == Type.FLOAT){
					//float
					if(ProgramInfo.getInstance().getVariableContext(what.name).equals("global")){
						instr += "%r" + varCount + " = load double* @" + what.name + " \n";
					}else{
						instr += "%r" + varCount + " = load double* %" + what.name + " \n";
					}
					
					instr += "store double %r" + (varCount-1) + ", double* " + k + to;
					varCount ++;
				}else if(ProgramInfo.getInstance().getVariableType(what.name) == Type.INT){
					//int
					if(ProgramInfo.getInstance().getVariableContext(what.name).equals("global")){
						instr += "%r" + varCount + " = load i32* @" + what.name + " \n";
					}else{
						instr += "%r" + varCount + " = load i32* %" + what.name + " \n";
					}
					varCount ++;
					instr +=  "%r" + varCount + " = sitofp i32 %r" + (varCount-1) + " to double \n";
					varCount++;
					instr += "store double %r" + (varCount-1) + ", double* " + k  + to;
				}
				
			}else if(what.type == Type.REF){
				instr += "store double %r" + (int)what.number + ", double* " + k  + to;
			}
			
			
		}else if(type == Type.INT){
			
			if(what.type == Type.FLOAT || what.type == Type.INT){
				instr += "store i32 " + (int)what.number + ", i32* %" + to;
			}else if(what.type == Type.NAME){
				
				if(ProgramInfo.getInstance().getVariableType(what.name) == Type.FLOAT){
					//float
					if(ProgramInfo.getInstance().getVariableContext(what.name).equals("global")){
						instr += "%r" + varCount + " = load double* @" + what.name + " \n";
					}else{
						instr += "%r" + varCount + " = load double* %" + what.name + " \n";
					}
					
					varCount++;
					instr +=  "%r" + varCount + " = fptosi double %r" + (varCount-1) + " to i32 \n";
					varCount++;
					instr += "store i32 %r" + (varCount-1) + ", i32* %" + to;
				}else if(ProgramInfo.getInstance().getVariableType(what.name) == Type.INT){
					//int
					if(ProgramInfo.getInstance().getVariableContext(what.name).equals("global")){
						instr += "%r" + varCount + " = load i32* @" + what.name + " \n";
					}else{
						instr += "%r" + varCount + " = load i32* %" + what.name + " \n";
					}
					
					varCount ++;
					instr += "store i32 %r" + (varCount-1) + ", i32* %" + to;
				}
				
			}else if(what.type == Type.REF){
				instr +=  "%r" + varCount + " = fptosi double %r" + (int)what.number + " to i32 \n";
				varCount++;
				instr += "store i32 %r" + (varCount-1) + ", i32* %" + to;
			}
			
		}
		
		
		
		
		return instr;
		
	}
	
	public static String printInteger(Num num){
		String instr = "";
		
		
		if(num.type == Type.FLOAT){
			instr += "call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([3 x i8]* @print_float, i32 0, i32 0), double %r" + num.number + ") \n";
		}else if(num.type == Type.INT){
			instr += "call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([3 x i8]* @print_int, i32 0, i32 0), i32 %r" + (int)num.number + ") \n";
		}else if(num.type == Type.NAME){
			Type type = ProgramInfo.getInstance().getVariableType(num.name);
			if(type == Type.FLOAT){
				
				if(ProgramInfo.getInstance().getVariableContext(num.name).equals("global")){
					instr += "%r" + varCount + " = load double* @" + num.name + " \n";
				}else{
					instr += "%r" + varCount + " = load double* %" + num.name + " \n";
				}
				
				varCount++;
				instr += "call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([4 x i8]* @print_float, i32 0, i32 0), double %r" + (varCount-1) + ") \n";
			}else if(type == Type.INT){
				
				if(ProgramInfo.getInstance().getVariableContext(num.name).equals("global")){
					instr += "%r" + varCount + " = load i32* @" + num.name + " \n";
				}else{
					instr += "%r" + varCount + " = load i32* %" + num.name + " \n";
				}
				
				varCount++;
				instr += "call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([3 x i8]* @print_int, i32 0, i32 0), i32 %r" + (varCount-1) + ") \n";
			}
		}else{
			//ref
			instr += "call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([4 x i8]* @print_float, i32 0, i32 0), double %r" + (int)num.number + ") \n";
		}
		
		instr += "call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([2 x i8]* @new_line, i32 0, i32 0))";
		
		return instr;
	}
	
	public static String printString(String name){
		String instr = "";
		int size = ProgramInfo.getInstance().getArrSize(name);
		
		String k = "%";
		if(ProgramInfo.getInstance().getVariableContext(name).equals("global")){
			k = "@";
		}
		
		for(int i=0; i<size; i++){
			instr += "%r" + varCount + " = getelementptr inbounds [100 x i8]* " + k + name + ", i32 0, i32 " + i + " \n";
			varCount++;
			instr += "%r" + varCount + " = load i8* %r" + (varCount-1) + ", align 4 \n";
			varCount++;
			instr += "%r" + varCount + " = sext i8 %r" + (varCount-1) + " to i32 \n";
			varCount++;
			instr += "call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([3 x i8]* @print_char, i32 0, i32 0), i32 %r" + (varCount-1) + ") \n";
		}
		instr += "call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([2 x i8]* @new_line, i32 0, i32 0))";
		return instr;
	}
	
	public static String getInt(String name){
		String instr = "";
		instr += "call i32 (i8*, ...)* @scanf(i8* getelementptr inbounds ([3 x i8]* @print_int, i32 0, i32 0), i32* %" + name + ")";
		return instr;
	}
	
	public static String getIntArr(String name, int elementNumber){
		String instr = "";
		int maxSize = ProgramInfo.getInstance().getArrSize(name);
		instr += "%r" + varCount + " = getelementptr inbounds [" + maxSize + " x i32]* %" + name + " , i32 0, i32 " + elementNumber + " \n";
		varCount++;
		instr += "call i32 (i8*, ...)* @scanf(i8* getelementptr inbounds ([3 x i8]* @print_int, i32 0, i32 0), i32* %r" + (varCount-1) + ")";
		return instr;
	}
	
	public static String getFloatArr(String name, int elementNumber){
		String instr = "";
		int maxSize = ProgramInfo.getInstance().getArrSize(name);
		instr += "%r" + varCount + " = getelementptr inbounds [" + maxSize + " x double]* %" + name + " , i32 0, i32 " + elementNumber + " \n";
		varCount++;
		instr += "call i32 (i8*, ...)* @scanf(i8* getelementptr inbounds ([4 x i8]* @print_float, i32 0, i32 0), double* %r" + (varCount-1) + ")";
		return instr;
	}
	
	public static String getFloat(String name){
		String instr = "";
		instr += "call i32 (i8*, ...)* @scanf(i8* getelementptr inbounds ([4 x i8]* @print_float, i32 0, i32 0), double* %" + name + ")";
		return instr;
	}
	
	public static String defineArr(Type type, String name, int size){
		String instr = "";
		if(type == Type.INT){
			instr += "%" + name + " = alloca [" + size + " x i32]";
		}else if(type == Type.FLOAT){
			instr += "%" + name + " = alloca [" + size + " x double]";
		}
		return instr;
		
	}
	
	public static String arrRef(Type type, String name, int elementNumber, int maxSize){
		String instr = "";
		if(type == Type.INT){
			instr += "%r" + varCount + " = getelementptr inbounds [" + maxSize + " x i32]* %" + name + ", i32 0, i32 " + elementNumber + " \n";
			varCount++;
			instr += "%r" + varCount + "load i32* %r" + (varCount-1) + "\n";
			varCount++;
			instr +=  "%r" + varCount + " = sitofp i32 %r" + (varCount-1) + " to double \n";
			varCount++;
			//dodaca na stos
		}else if(type == Type.FLOAT){
			instr += "%r" + varCount + " = getelementptr inbounds [" + maxSize + " x double]* %" + name + ", i32 0, i32 " + elementNumber + " \n";
			varCount++;
			instr += "%r" + varCount + "load double* %r" + (varCount-1) + "\n";
			varCount++;
			//dodac na stos
		}
		
		return instr;
	}

	
	
	
	

}
