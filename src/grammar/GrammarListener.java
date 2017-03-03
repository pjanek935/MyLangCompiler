// Generated from C:\Users\Piotrek\Grammar.g4 by ANTLR 4.1
package grammar;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarParser}.
 */
public interface GrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammarParser#function_statement}.
	 * @param ctx the parse tree
	 */
	void enterFunction_statement(@NotNull GrammarParser.Function_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#function_statement}.
	 * @param ctx the parse tree
	 */
	void exitFunction_statement(@NotNull GrammarParser.Function_statementContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(@NotNull GrammarParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(@NotNull GrammarParser.ArgumentContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#declare}.
	 * @param ctx the parse tree
	 */
	void enterDeclare(@NotNull GrammarParser.DeclareContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#declare}.
	 * @param ctx the parse tree
	 */
	void exitDeclare(@NotNull GrammarParser.DeclareContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#function_head}.
	 * @param ctx the parse tree
	 */
	void enterFunction_head(@NotNull GrammarParser.Function_headContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#function_head}.
	 * @param ctx the parse tree
	 */
	void exitFunction_head(@NotNull GrammarParser.Function_headContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#global_declare}.
	 * @param ctx the parse tree
	 */
	void enterGlobal_declare(@NotNull GrammarParser.Global_declareContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#global_declare}.
	 * @param ctx the parse tree
	 */
	void exitGlobal_declare(@NotNull GrammarParser.Global_declareContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(@NotNull GrammarParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(@NotNull GrammarParser.ProgramContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#none}.
	 * @param ctx the parse tree
	 */
	void enterNone(@NotNull GrammarParser.NoneContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#none}.
	 * @param ctx the parse tree
	 */
	void exitNone(@NotNull GrammarParser.NoneContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(@NotNull GrammarParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(@NotNull GrammarParser.TypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#arr_ref}.
	 * @param ctx the parse tree
	 */
	void enterArr_ref(@NotNull GrammarParser.Arr_refContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#arr_ref}.
	 * @param ctx the parse tree
	 */
	void exitArr_ref(@NotNull GrammarParser.Arr_refContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#string_name}.
	 * @param ctx the parse tree
	 */
	void enterString_name(@NotNull GrammarParser.String_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#string_name}.
	 * @param ctx the parse tree
	 */
	void exitString_name(@NotNull GrammarParser.String_nameContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(@NotNull GrammarParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(@NotNull GrammarParser.NumberContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#instruction_set}.
	 * @param ctx the parse tree
	 */
	void enterInstruction_set(@NotNull GrammarParser.Instruction_setContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#instruction_set}.
	 * @param ctx the parse tree
	 */
	void exitInstruction_set(@NotNull GrammarParser.Instruction_setContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(@NotNull GrammarParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(@NotNull GrammarParser.FunctionContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#define_arr}.
	 * @param ctx the parse tree
	 */
	void enterDefine_arr(@NotNull GrammarParser.Define_arrContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#define_arr}.
	 * @param ctx the parse tree
	 */
	void exitDefine_arr(@NotNull GrammarParser.Define_arrContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#if_condition}.
	 * @param ctx the parse tree
	 */
	void enterIf_condition(@NotNull GrammarParser.If_conditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#if_condition}.
	 * @param ctx the parse tree
	 */
	void exitIf_condition(@NotNull GrammarParser.If_conditionContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#ret}.
	 * @param ctx the parse tree
	 */
	void enterRet(@NotNull GrammarParser.RetContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#ret}.
	 * @param ctx the parse tree
	 */
	void exitRet(@NotNull GrammarParser.RetContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#integer_name}.
	 * @param ctx the parse tree
	 */
	void enterInteger_name(@NotNull GrammarParser.Integer_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#integer_name}.
	 * @param ctx the parse tree
	 */
	void exitInteger_name(@NotNull GrammarParser.Integer_nameContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#new_line}.
	 * @param ctx the parse tree
	 */
	void enterNew_line(@NotNull GrammarParser.New_lineContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#new_line}.
	 * @param ctx the parse tree
	 */
	void exitNew_line(@NotNull GrammarParser.New_lineContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#floa}.
	 * @param ctx the parse tree
	 */
	void enterFloa(@NotNull GrammarParser.FloaContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#floa}.
	 * @param ctx the parse tree
	 */
	void exitFloa(@NotNull GrammarParser.FloaContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#integ}.
	 * @param ctx the parse tree
	 */
	void enterInteg(@NotNull GrammarParser.IntegContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#integ}.
	 * @param ctx the parse tree
	 */
	void exitInteg(@NotNull GrammarParser.IntegContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#assign_arr}.
	 * @param ctx the parse tree
	 */
	void enterAssign_arr(@NotNull GrammarParser.Assign_arrContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#assign_arr}.
	 * @param ctx the parse tree
	 */
	void exitAssign_arr(@NotNull GrammarParser.Assign_arrContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#factor_list}.
	 * @param ctx the parse tree
	 */
	void enterFactor_list(@NotNull GrammarParser.Factor_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#factor_list}.
	 * @param ctx the parse tree
	 */
	void exitFactor_list(@NotNull GrammarParser.Factor_listContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#if_else_statement}.
	 * @param ctx the parse tree
	 */
	void enterIf_else_statement(@NotNull GrammarParser.If_else_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#if_else_statement}.
	 * @param ctx the parse tree
	 */
	void exitIf_else_statement(@NotNull GrammarParser.If_else_statementContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(@NotNull GrammarParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(@NotNull GrammarParser.NameContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void enterIf_statement(@NotNull GrammarParser.If_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void exitIf_statement(@NotNull GrammarParser.If_statementContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#string}.
	 * @param ctx the parse tree
	 */
	void enterString(@NotNull GrammarParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#string}.
	 * @param ctx the parse tree
	 */
	void exitString(@NotNull GrammarParser.StringContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#global}.
	 * @param ctx the parse tree
	 */
	void enterGlobal(@NotNull GrammarParser.GlobalContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#global}.
	 * @param ctx the parse tree
	 */
	void exitGlobal(@NotNull GrammarParser.GlobalContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#endrepeat}.
	 * @param ctx the parse tree
	 */
	void enterEndrepeat(@NotNull GrammarParser.EndrepeatContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#endrepeat}.
	 * @param ctx the parse tree
	 */
	void exitEndrepeat(@NotNull GrammarParser.EndrepeatContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#global_define_arr}.
	 * @param ctx the parse tree
	 */
	void enterGlobal_define_arr(@NotNull GrammarParser.Global_define_arrContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#global_define_arr}.
	 * @param ctx the parse tree
	 */
	void exitGlobal_define_arr(@NotNull GrammarParser.Global_define_arrContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#getint}.
	 * @param ctx the parse tree
	 */
	void enterGetint(@NotNull GrammarParser.GetintContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#getint}.
	 * @param ctx the parse tree
	 */
	void exitGetint(@NotNull GrammarParser.GetintContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#repeat}.
	 * @param ctx the parse tree
	 */
	void enterRepeat(@NotNull GrammarParser.RepeatContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#repeat}.
	 * @param ctx the parse tree
	 */
	void exitRepeat(@NotNull GrammarParser.RepeatContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#define}.
	 * @param ctx the parse tree
	 */
	void enterDefine(@NotNull GrammarParser.DefineContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#define}.
	 * @param ctx the parse tree
	 */
	void exitDefine(@NotNull GrammarParser.DefineContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#ret_statement}.
	 * @param ctx the parse tree
	 */
	void enterRet_statement(@NotNull GrammarParser.Ret_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#ret_statement}.
	 * @param ctx the parse tree
	 */
	void exitRet_statement(@NotNull GrammarParser.Ret_statementContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(@NotNull GrammarParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(@NotNull GrammarParser.ExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(@NotNull GrammarParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(@NotNull GrammarParser.TermContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(@NotNull GrammarParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(@NotNull GrammarParser.FactorContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(@NotNull GrammarParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(@NotNull GrammarParser.ValueContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#fun_name}.
	 * @param ctx the parse tree
	 */
	void enterFun_name(@NotNull GrammarParser.Fun_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#fun_name}.
	 * @param ctx the parse tree
	 */
	void exitFun_name(@NotNull GrammarParser.Fun_nameContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#endfunction}.
	 * @param ctx the parse tree
	 */
	void enterEndfunction(@NotNull GrammarParser.EndfunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#endfunction}.
	 * @param ctx the parse tree
	 */
	void exitEndfunction(@NotNull GrammarParser.EndfunctionContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#include}.
	 * @param ctx the parse tree
	 */
	void enterInclude(@NotNull GrammarParser.IncludeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#include}.
	 * @param ctx the parse tree
	 */
	void exitInclude(@NotNull GrammarParser.IncludeContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#repeat_statement}.
	 * @param ctx the parse tree
	 */
	void enterRepeat_statement(@NotNull GrammarParser.Repeat_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#repeat_statement}.
	 * @param ctx the parse tree
	 */
	void exitRepeat_statement(@NotNull GrammarParser.Repeat_statementContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#global_define}.
	 * @param ctx the parse tree
	 */
	void enterGlobal_define(@NotNull GrammarParser.Global_defineContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#global_define}.
	 * @param ctx the parse tree
	 */
	void exitGlobal_define(@NotNull GrammarParser.Global_defineContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#arg_list}.
	 * @param ctx the parse tree
	 */
	void enterArg_list(@NotNull GrammarParser.Arg_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#arg_list}.
	 * @param ctx the parse tree
	 */
	void exitArg_list(@NotNull GrammarParser.Arg_listContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#float_name}.
	 * @param ctx the parse tree
	 */
	void enterFloat_name(@NotNull GrammarParser.Float_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#float_name}.
	 * @param ctx the parse tree
	 */
	void exitFloat_name(@NotNull GrammarParser.Float_nameContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#prints}.
	 * @param ctx the parse tree
	 */
	void enterPrints(@NotNull GrammarParser.PrintsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#prints}.
	 * @param ctx the parse tree
	 */
	void exitPrints(@NotNull GrammarParser.PrintsContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#comparator}.
	 * @param ctx the parse tree
	 */
	void enterComparator(@NotNull GrammarParser.ComparatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#comparator}.
	 * @param ctx the parse tree
	 */
	void exitComparator(@NotNull GrammarParser.ComparatorContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(@NotNull GrammarParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(@NotNull GrammarParser.PrintContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstruction(@NotNull GrammarParser.InstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstruction(@NotNull GrammarParser.InstructionContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#getfloat}.
	 * @param ctx the parse tree
	 */
	void enterGetfloat(@NotNull GrammarParser.GetfloatContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#getfloat}.
	 * @param ctx the parse tree
	 */
	void exitGetfloat(@NotNull GrammarParser.GetfloatContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#repeat_start}.
	 * @param ctx the parse tree
	 */
	void enterRepeat_start(@NotNull GrammarParser.Repeat_startContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#repeat_start}.
	 * @param ctx the parse tree
	 */
	void exitRepeat_start(@NotNull GrammarParser.Repeat_startContext ctx);

	/**
	 * Enter a parse tree produced by {@link GrammarParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(@NotNull GrammarParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(@NotNull GrammarParser.AssignContext ctx);
}