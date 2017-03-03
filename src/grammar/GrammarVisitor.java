// Generated from C:\Users\Piotrek\Grammar.g4 by ANTLR 4.1
package grammar;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GrammarParser#function_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_statement(@NotNull GrammarParser.Function_statementContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument(@NotNull GrammarParser.ArgumentContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#declare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclare(@NotNull GrammarParser.DeclareContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#function_head}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_head(@NotNull GrammarParser.Function_headContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#global_declare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobal_declare(@NotNull GrammarParser.Global_declareContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(@NotNull GrammarParser.ProgramContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#none}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNone(@NotNull GrammarParser.NoneContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(@NotNull GrammarParser.TypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#arr_ref}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArr_ref(@NotNull GrammarParser.Arr_refContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#string_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString_name(@NotNull GrammarParser.String_nameContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(@NotNull GrammarParser.NumberContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#instruction_set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruction_set(@NotNull GrammarParser.Instruction_setContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(@NotNull GrammarParser.FunctionContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#define_arr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefine_arr(@NotNull GrammarParser.Define_arrContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#if_condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_condition(@NotNull GrammarParser.If_conditionContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#ret}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRet(@NotNull GrammarParser.RetContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#integer_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger_name(@NotNull GrammarParser.Integer_nameContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#new_line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNew_line(@NotNull GrammarParser.New_lineContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#floa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloa(@NotNull GrammarParser.FloaContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#integ}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteg(@NotNull GrammarParser.IntegContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#assign_arr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_arr(@NotNull GrammarParser.Assign_arrContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#factor_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor_list(@NotNull GrammarParser.Factor_listContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#if_else_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_else_statement(@NotNull GrammarParser.If_else_statementContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitName(@NotNull GrammarParser.NameContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#if_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_statement(@NotNull GrammarParser.If_statementContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(@NotNull GrammarParser.StringContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#global}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobal(@NotNull GrammarParser.GlobalContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#endrepeat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEndrepeat(@NotNull GrammarParser.EndrepeatContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#global_define_arr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobal_define_arr(@NotNull GrammarParser.Global_define_arrContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#getint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetint(@NotNull GrammarParser.GetintContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#repeat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeat(@NotNull GrammarParser.RepeatContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#define}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefine(@NotNull GrammarParser.DefineContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#ret_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRet_statement(@NotNull GrammarParser.Ret_statementContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(@NotNull GrammarParser.ExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(@NotNull GrammarParser.TermContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(@NotNull GrammarParser.FactorContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(@NotNull GrammarParser.ValueContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#fun_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFun_name(@NotNull GrammarParser.Fun_nameContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#endfunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEndfunction(@NotNull GrammarParser.EndfunctionContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#include}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInclude(@NotNull GrammarParser.IncludeContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#repeat_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeat_statement(@NotNull GrammarParser.Repeat_statementContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#global_define}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobal_define(@NotNull GrammarParser.Global_defineContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#arg_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArg_list(@NotNull GrammarParser.Arg_listContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#float_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloat_name(@NotNull GrammarParser.Float_nameContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#prints}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrints(@NotNull GrammarParser.PrintsContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#comparator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparator(@NotNull GrammarParser.ComparatorContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(@NotNull GrammarParser.PrintContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruction(@NotNull GrammarParser.InstructionContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#getfloat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetfloat(@NotNull GrammarParser.GetfloatContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#repeat_start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeat_start(@NotNull GrammarParser.Repeat_startContext ctx);

	/**
	 * Visit a parse tree produced by {@link GrammarParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(@NotNull GrammarParser.AssignContext ctx);
}