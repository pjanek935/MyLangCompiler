define i32 @power2( i32* %x) { 

%r0 = load i32* %x 
%r1 = sitofp i32 %r0 to double
%r2 = load i32* %x 
%r3 = sitofp i32 %r2 to double
%r4 = fadd double %r3 , 0.0
%r5 = fmul double %r4 , %r1
%val = alloca i32 
%r6 = fptosi double %r5 to i32 
store i32 %r6, i32* %val
%r7 = load i32* %val 
%r8 = sitofp i32 %r7 to double
%r9 = fptosi double %r8 to i32 
ret i32 %r9
}

@print_int = linkonce_odr unnamed_addr constant [3 x i8] c"%d\00", align 1 
@print_float = linkonce_odr unnamed_addr constant [4 x i8] c"%lf\00", align 1 
@new_line = linkonce_odr unnamed_addr constant [2 x i8] c"\0A\00", align 1 
@print_char = linkonce_odr unnamed_addr constant [3 x i8] c"%c\00", align 1 
declare i32 @printf(i8 *, ...) 
declare i32 @scanf(i8*, ...) #1 
define i32 @main() { 

%x = alloca i32 ; intx
call i32 (i8*, ...)* @scanf(i8* getelementptr inbounds ([3 x i8]* @print_int, i32 0, i32 0), i32* %x)
%r10 = load i32* %x 
%r11 = sitofp i32 %r10 to double
%r12 = fptosi double %r11 to i32 
%r13 = alloca i32 
store i32 %r12, i32* %r13
%r14 = call i32 @power2(i32* %r13)
%r15 = sitofp i32 %r14 to double
call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([4 x i8]* @print_float, i32 0, i32 0), double %r15) 
call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([2 x i8]* @new_line, i32 0, i32 0))
ret i32 1 
}

