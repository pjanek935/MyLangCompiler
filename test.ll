@print_int = linkonce_odr unnamed_addr constant [3 x i8] c"%d\00", align 1
@print_float = linkonce_odr unnamed_addr constant [4 x i8] c"%lf\00", align 1
@new_line = linkonce_odr unnamed_addr constant [2 x i8] c"\0A\00", align 1
declare i32 @printf(i8 *, ...)
declare i32 @scanf(i8*, ...) #1

define i32 @main() {


%val = alloca double 
store double 19.4, double* %val 
%r0 = load double* %val  
call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([4 x i8]* @print_float, i32 0, i32 0), double %r0) 
call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([2 x i8]* @new_line, i32 0, i32 0)) 
%tab = alloca [10 x double] 
%r1 = getelementptr inbounds [10 x double]* %tab , i32 0, i32 6 
store double 10.111, double* %r1 
%r2 = getelementptr inbounds [10 x double]* %tab, i32 0, i32 6 
%r3 = load double* %r2 
%r4 = fadd double 1.0 , 0.0 
%r5 = fadd double %r4 , %r3 
call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([4 x i8]* @print_float, i32 0, i32 0), double %r5) 
call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([2 x i8]* @new_line, i32 0, i32 0)) 







	
  ret i32 1
}