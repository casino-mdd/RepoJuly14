/*
 * generated by Xtext 2.18.0
 */
package org.xtext.example.mydsl.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;
import org.xtext.example.mydsl.services.MyDslGrammarAccess;

@SuppressWarnings("all")
public class MyDslSyntacticSequencer extends AbstractSyntacticSequencer {

	protected MyDslGrammarAccess grammarAccess;
	protected AbstractElementAlias match_Directory_HasKeyword_3_0_p;
	protected AbstractElementAlias match_JsMethod___ReturnsKeyword_6_0_BooleanParserRuleCall_6_1__q;
	protected AbstractElementAlias match_LayerSegment___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_2__q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (MyDslGrammarAccess) access;
		match_Directory_HasKeyword_3_0_p = new TokenAlias(true, false, grammarAccess.getDirectoryAccess().getHasKeyword_3_0());
		match_JsMethod___ReturnsKeyword_6_0_BooleanParserRuleCall_6_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getJsMethodAccess().getReturnsKeyword_6_0()), new TokenAlias(false, false, grammarAccess.getJsMethodAccess().getBooleanParserRuleCall_6_1()));
		match_LayerSegment___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getLayerSegmentAccess().getLeftCurlyBracketKeyword_3_0()), new TokenAlias(false, false, grammarAccess.getLayerSegmentAccess().getRightCurlyBracketKeyword_3_2()));
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (ruleCall.getRule() == grammarAccess.getBooleanRule())
			return getBooleanToken(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * Boolean:
	 * 'true'|'false'
	 * ;
	 */
	protected String getBooleanToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "true";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if (match_Directory_HasKeyword_3_0_p.equals(syntax))
				emit_Directory_HasKeyword_3_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_JsMethod___ReturnsKeyword_6_0_BooleanParserRuleCall_6_1__q.equals(syntax))
				emit_JsMethod___ReturnsKeyword_6_0_BooleanParserRuleCall_6_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_LayerSegment___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_2__q.equals(syntax))
				emit_LayerSegment___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Ambiguous syntax:
	 *     'has:'+
	 *
	 * This ambiguous syntax occurs at:
	 *     file=[File|ID] (ambiguity) file=[File|ID]
	 *     name=ID '{' (ambiguity) file=[File|ID]
	 */
	protected void emit_Directory_HasKeyword_3_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('returns:' Boolean)?
	 *
	 * This ambiguous syntax occurs at:
	 *     arguments+=JsMethodArgs (ambiguity) '}' (rule end)
	 *     type=JsMethodType (ambiguity) '}' (rule end)
	 */
	protected void emit_JsMethod___ReturnsKeyword_6_0_BooleanParserRuleCall_6_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('{' '}')?
	 *
	 * This ambiguous syntax occurs at:
	 *     name=LayerSegmentName '{' (ambiguity) '}' (rule end)
	 *     name=LayerSegmentName '{' (ambiguity) sublayerSegments+=SublayerSegment
	 */
	protected void emit_LayerSegment___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
