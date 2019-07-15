package org.xtext.example.mydsl.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.xtext.example.mydsl.services.MyDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMyDslParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Casino'", "'{'", "'}'", "'domain'", "'module'", "'submodule'", "'op'", "'type:'", "'operates_on:'", "'Read'", "'Create'", "'generalEntity'", "':'", "'dataType'", "'specialEntity'", "'trx'", "'exchange'", "'sale'", "'rel'", "'Composition'", "'source:'", "'target:'", "'arch'", "'component'", "'Back'", "'Front'", "'layer'", "'JavaScript'", "'Ejb'", "'War'", "'layerSegment'", "'allowedToUse:'", "'Services'", "'Ui'", "'Store'", "'RestEntity'", "'Pojo'", "'Facade'", "'Dto'", "'Util'", "'Containers'", "'sublayerSegment'", "'Actions'", "'Reducers'", "'relationArch'", "','", "'tech'", "'javaApp'", "'jeeProject'", "'subproject'", "'abstractClass'", "'use :'", "'genericClass'", "'extends :'", "'implements :'", "'nativeClass'", "'attribute'", "'epackage'", "'methodBack'", "'argument'", "'return'", "'abstractMethodBack'", "'descriptor'", "'path'", "'annotation'", "'propertie'", "'library'", "'isNative'", "'true'", "'false'", "'reactApp'", "'performs:'", "'holds:'", "'use:'", "'functionality'", "'uses:'", "'wraps:'", "'render:'", "'state:'", "'calls:'", "'organizedBy:'", "'router'", "'inWithin:'", "'route:'", "'container'", "'dispatch:'", "'map:'", "'visualizer'", "'service'", "'method:'", "'directory'", "'has:'", "'contains:'", "'purpose:'", "'md'", "'js'", "'json'", "'css'", "'state'", "'handleAction:'", "'handleReducer:'", "'action'", "'create:'", "'actionDirectory:'", "'actionCreator'", "'actionDispatcher'", "'reducer'", "'catch:'", "'reducerDirectory:'", "'presentIn:'", "'method'", "'jsMethodType:'", "'returns:'", "'reactConstructor'", "'reactRender'", "'reactLifecycle'", "'customJsMethod'", "'jsmethodArgument'", "'axiosRequest'", "'restMethod:'", "'getMethod'", "'postMethod'", "'URL:'", "'data:'"
    };
    public static final int T__50=50;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__133=133;
    public static final int T__132=132;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int T__134=134;
    public static final int RULE_ID=4;
    public static final int T__131=131;
    public static final int T__130=130;
    public static final int RULE_INT=6;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__67=67;
    public static final int T__129=129;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__126=126;
    public static final int T__63=63;
    public static final int T__125=125;
    public static final int T__64=64;
    public static final int T__128=128;
    public static final int T__65=65;
    public static final int T__127=127;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__99=99;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__122=122;
    public static final int T__70=70;
    public static final int T__121=121;
    public static final int T__71=71;
    public static final int T__124=124;
    public static final int T__72=72;
    public static final int T__123=123;
    public static final int T__120=120;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__77=77;
    public static final int T__119=119;
    public static final int T__78=78;
    public static final int T__118=118;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int T__115=115;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__114=114;
    public static final int T__75=75;
    public static final int T__117=117;
    public static final int T__76=76;
    public static final int T__116=116;
    public static final int T__80=80;
    public static final int T__111=111;
    public static final int T__81=81;
    public static final int T__110=110;
    public static final int T__82=82;
    public static final int T__113=113;
    public static final int T__83=83;
    public static final int T__112=112;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int T__109=109;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int T__86=86;
    public static final int T__106=106;
    public static final int T__87=87;
    public static final int T__105=105;

    // delegates
    // delegators


        public InternalMyDslParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMyDslParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMyDslParser.tokenNames; }
    public String getGrammarFileName() { return "InternalMyDsl.g"; }



     	private MyDslGrammarAccess grammarAccess;

        public InternalMyDslParser(TokenStream input, MyDslGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "System";
       	}

       	@Override
       	protected MyDslGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleSystem"
    // InternalMyDsl.g:64:1: entryRuleSystem returns [EObject current=null] : iv_ruleSystem= ruleSystem EOF ;
    public final EObject entryRuleSystem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSystem = null;


        try {
            // InternalMyDsl.g:64:47: (iv_ruleSystem= ruleSystem EOF )
            // InternalMyDsl.g:65:2: iv_ruleSystem= ruleSystem EOF
            {
             newCompositeNode(grammarAccess.getSystemRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSystem=ruleSystem();

            state._fsp--;

             current =iv_ruleSystem; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSystem"


    // $ANTLR start "ruleSystem"
    // InternalMyDsl.g:71:1: ruleSystem returns [EObject current=null] : (otherlv_0= 'Casino' otherlv_1= '{' ( (lv_dom_2_0= ruleDomain ) ) ( (lv_arch_3_0= ruleArchitecture ) ) ( (lv_tech_4_0= ruleTechnology ) ) otherlv_5= '}' ) ;
    public final EObject ruleSystem() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_5=null;
        EObject lv_dom_2_0 = null;

        EObject lv_arch_3_0 = null;

        EObject lv_tech_4_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:77:2: ( (otherlv_0= 'Casino' otherlv_1= '{' ( (lv_dom_2_0= ruleDomain ) ) ( (lv_arch_3_0= ruleArchitecture ) ) ( (lv_tech_4_0= ruleTechnology ) ) otherlv_5= '}' ) )
            // InternalMyDsl.g:78:2: (otherlv_0= 'Casino' otherlv_1= '{' ( (lv_dom_2_0= ruleDomain ) ) ( (lv_arch_3_0= ruleArchitecture ) ) ( (lv_tech_4_0= ruleTechnology ) ) otherlv_5= '}' )
            {
            // InternalMyDsl.g:78:2: (otherlv_0= 'Casino' otherlv_1= '{' ( (lv_dom_2_0= ruleDomain ) ) ( (lv_arch_3_0= ruleArchitecture ) ) ( (lv_tech_4_0= ruleTechnology ) ) otherlv_5= '}' )
            // InternalMyDsl.g:79:3: otherlv_0= 'Casino' otherlv_1= '{' ( (lv_dom_2_0= ruleDomain ) ) ( (lv_arch_3_0= ruleArchitecture ) ) ( (lv_tech_4_0= ruleTechnology ) ) otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getSystemAccess().getCasinoKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getSystemAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalMyDsl.g:87:3: ( (lv_dom_2_0= ruleDomain ) )
            // InternalMyDsl.g:88:4: (lv_dom_2_0= ruleDomain )
            {
            // InternalMyDsl.g:88:4: (lv_dom_2_0= ruleDomain )
            // InternalMyDsl.g:89:5: lv_dom_2_0= ruleDomain
            {

            					newCompositeNode(grammarAccess.getSystemAccess().getDomDomainParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_5);
            lv_dom_2_0=ruleDomain();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSystemRule());
            					}
            					set(
            						current,
            						"dom",
            						lv_dom_2_0,
            						"org.xtext.example.mydsl.MyDsl.Domain");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:106:3: ( (lv_arch_3_0= ruleArchitecture ) )
            // InternalMyDsl.g:107:4: (lv_arch_3_0= ruleArchitecture )
            {
            // InternalMyDsl.g:107:4: (lv_arch_3_0= ruleArchitecture )
            // InternalMyDsl.g:108:5: lv_arch_3_0= ruleArchitecture
            {

            					newCompositeNode(grammarAccess.getSystemAccess().getArchArchitectureParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_6);
            lv_arch_3_0=ruleArchitecture();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSystemRule());
            					}
            					set(
            						current,
            						"arch",
            						lv_arch_3_0,
            						"org.xtext.example.mydsl.MyDsl.Architecture");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:125:3: ( (lv_tech_4_0= ruleTechnology ) )
            // InternalMyDsl.g:126:4: (lv_tech_4_0= ruleTechnology )
            {
            // InternalMyDsl.g:126:4: (lv_tech_4_0= ruleTechnology )
            // InternalMyDsl.g:127:5: lv_tech_4_0= ruleTechnology
            {

            					newCompositeNode(grammarAccess.getSystemAccess().getTechTechnologyParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_7);
            lv_tech_4_0=ruleTechnology();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSystemRule());
            					}
            					set(
            						current,
            						"tech",
            						lv_tech_4_0,
            						"org.xtext.example.mydsl.MyDsl.Technology");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getSystemAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSystem"


    // $ANTLR start "entryRuleDomain"
    // InternalMyDsl.g:152:1: entryRuleDomain returns [EObject current=null] : iv_ruleDomain= ruleDomain EOF ;
    public final EObject entryRuleDomain() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDomain = null;


        try {
            // InternalMyDsl.g:152:47: (iv_ruleDomain= ruleDomain EOF )
            // InternalMyDsl.g:153:2: iv_ruleDomain= ruleDomain EOF
            {
             newCompositeNode(grammarAccess.getDomainRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDomain=ruleDomain();

            state._fsp--;

             current =iv_ruleDomain; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDomain"


    // $ANTLR start "ruleDomain"
    // InternalMyDsl.g:159:1: ruleDomain returns [EObject current=null] : (otherlv_0= 'domain' otherlv_1= '{' ( (lv_types_2_0= ruleType ) )* ( (lv_modules_3_0= ruleModule ) )+ ( (lv_relations_4_0= ruleRelationDom ) )+ otherlv_5= '}' ) ;
    public final EObject ruleDomain() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_5=null;
        EObject lv_types_2_0 = null;

        EObject lv_modules_3_0 = null;

        EObject lv_relations_4_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:165:2: ( (otherlv_0= 'domain' otherlv_1= '{' ( (lv_types_2_0= ruleType ) )* ( (lv_modules_3_0= ruleModule ) )+ ( (lv_relations_4_0= ruleRelationDom ) )+ otherlv_5= '}' ) )
            // InternalMyDsl.g:166:2: (otherlv_0= 'domain' otherlv_1= '{' ( (lv_types_2_0= ruleType ) )* ( (lv_modules_3_0= ruleModule ) )+ ( (lv_relations_4_0= ruleRelationDom ) )+ otherlv_5= '}' )
            {
            // InternalMyDsl.g:166:2: (otherlv_0= 'domain' otherlv_1= '{' ( (lv_types_2_0= ruleType ) )* ( (lv_modules_3_0= ruleModule ) )+ ( (lv_relations_4_0= ruleRelationDom ) )+ otherlv_5= '}' )
            // InternalMyDsl.g:167:3: otherlv_0= 'domain' otherlv_1= '{' ( (lv_types_2_0= ruleType ) )* ( (lv_modules_3_0= ruleModule ) )+ ( (lv_relations_4_0= ruleRelationDom ) )+ otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,14,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDomainAccess().getDomainKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getDomainAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalMyDsl.g:175:3: ( (lv_types_2_0= ruleType ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==24) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalMyDsl.g:176:4: (lv_types_2_0= ruleType )
            	    {
            	    // InternalMyDsl.g:176:4: (lv_types_2_0= ruleType )
            	    // InternalMyDsl.g:177:5: lv_types_2_0= ruleType
            	    {

            	    					newCompositeNode(grammarAccess.getDomainAccess().getTypesTypeParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_8);
            	    lv_types_2_0=ruleType();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDomainRule());
            	    					}
            	    					add(
            	    						current,
            	    						"types",
            	    						lv_types_2_0,
            	    						"org.xtext.example.mydsl.MyDsl.Type");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalMyDsl.g:194:3: ( (lv_modules_3_0= ruleModule ) )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==15) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalMyDsl.g:195:4: (lv_modules_3_0= ruleModule )
            	    {
            	    // InternalMyDsl.g:195:4: (lv_modules_3_0= ruleModule )
            	    // InternalMyDsl.g:196:5: lv_modules_3_0= ruleModule
            	    {

            	    					newCompositeNode(grammarAccess.getDomainAccess().getModulesModuleParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_9);
            	    lv_modules_3_0=ruleModule();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDomainRule());
            	    					}
            	    					add(
            	    						current,
            	    						"modules",
            	    						lv_modules_3_0,
            	    						"org.xtext.example.mydsl.MyDsl.Module");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);

            // InternalMyDsl.g:213:3: ( (lv_relations_4_0= ruleRelationDom ) )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==29) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalMyDsl.g:214:4: (lv_relations_4_0= ruleRelationDom )
            	    {
            	    // InternalMyDsl.g:214:4: (lv_relations_4_0= ruleRelationDom )
            	    // InternalMyDsl.g:215:5: lv_relations_4_0= ruleRelationDom
            	    {

            	    					newCompositeNode(grammarAccess.getDomainAccess().getRelationsRelationDomParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_10);
            	    lv_relations_4_0=ruleRelationDom();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDomainRule());
            	    					}
            	    					add(
            	    						current,
            	    						"relations",
            	    						lv_relations_4_0,
            	    						"org.xtext.example.mydsl.MyDsl.RelationDom");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);

            otherlv_5=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getDomainAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDomain"


    // $ANTLR start "entryRuleModule"
    // InternalMyDsl.g:240:1: entryRuleModule returns [EObject current=null] : iv_ruleModule= ruleModule EOF ;
    public final EObject entryRuleModule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModule = null;


        try {
            // InternalMyDsl.g:240:47: (iv_ruleModule= ruleModule EOF )
            // InternalMyDsl.g:241:2: iv_ruleModule= ruleModule EOF
            {
             newCompositeNode(grammarAccess.getModuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModule=ruleModule();

            state._fsp--;

             current =iv_ruleModule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModule"


    // $ANTLR start "ruleModule"
    // InternalMyDsl.g:247:1: ruleModule returns [EObject current=null] : (otherlv_0= 'module' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_submodules_3_0= ruleSubmodule ) )+ otherlv_4= '}' ) ;
    public final EObject ruleModule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_submodules_3_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:253:2: ( (otherlv_0= 'module' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_submodules_3_0= ruleSubmodule ) )+ otherlv_4= '}' ) )
            // InternalMyDsl.g:254:2: (otherlv_0= 'module' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_submodules_3_0= ruleSubmodule ) )+ otherlv_4= '}' )
            {
            // InternalMyDsl.g:254:2: (otherlv_0= 'module' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_submodules_3_0= ruleSubmodule ) )+ otherlv_4= '}' )
            // InternalMyDsl.g:255:3: otherlv_0= 'module' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_submodules_3_0= ruleSubmodule ) )+ otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getModuleAccess().getModuleKeyword_0());
            		
            // InternalMyDsl.g:259:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMyDsl.g:260:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMyDsl.g:260:4: (lv_name_1_0= RULE_ID )
            // InternalMyDsl.g:261:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_3); 

            					newLeafNode(lv_name_1_0, grammarAccess.getModuleAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getModuleRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_12); 

            			newLeafNode(otherlv_2, grammarAccess.getModuleAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:281:3: ( (lv_submodules_3_0= ruleSubmodule ) )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==16) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalMyDsl.g:282:4: (lv_submodules_3_0= ruleSubmodule )
            	    {
            	    // InternalMyDsl.g:282:4: (lv_submodules_3_0= ruleSubmodule )
            	    // InternalMyDsl.g:283:5: lv_submodules_3_0= ruleSubmodule
            	    {

            	    					newCompositeNode(grammarAccess.getModuleAccess().getSubmodulesSubmoduleParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_13);
            	    lv_submodules_3_0=ruleSubmodule();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getModuleRule());
            	    					}
            	    					add(
            	    						current,
            	    						"submodules",
            	    						lv_submodules_3_0,
            	    						"org.xtext.example.mydsl.MyDsl.Submodule");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);

            otherlv_4=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getModuleAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModule"


    // $ANTLR start "entryRuleSubmodule"
    // InternalMyDsl.g:308:1: entryRuleSubmodule returns [EObject current=null] : iv_ruleSubmodule= ruleSubmodule EOF ;
    public final EObject entryRuleSubmodule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubmodule = null;


        try {
            // InternalMyDsl.g:308:50: (iv_ruleSubmodule= ruleSubmodule EOF )
            // InternalMyDsl.g:309:2: iv_ruleSubmodule= ruleSubmodule EOF
            {
             newCompositeNode(grammarAccess.getSubmoduleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSubmodule=ruleSubmodule();

            state._fsp--;

             current =iv_ruleSubmodule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSubmodule"


    // $ANTLR start "ruleSubmodule"
    // InternalMyDsl.g:315:1: ruleSubmodule returns [EObject current=null] : (otherlv_0= 'submodule' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_operations_3_0= ruleOperation ) )+ ( ( (lv_entities_4_1= ruleGeneralEntity | lv_entities_4_2= ruleSpecialEntity ) ) )+ otherlv_5= '}' ) ;
    public final EObject ruleSubmodule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject lv_operations_3_0 = null;

        EObject lv_entities_4_1 = null;

        EObject lv_entities_4_2 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:321:2: ( (otherlv_0= 'submodule' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_operations_3_0= ruleOperation ) )+ ( ( (lv_entities_4_1= ruleGeneralEntity | lv_entities_4_2= ruleSpecialEntity ) ) )+ otherlv_5= '}' ) )
            // InternalMyDsl.g:322:2: (otherlv_0= 'submodule' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_operations_3_0= ruleOperation ) )+ ( ( (lv_entities_4_1= ruleGeneralEntity | lv_entities_4_2= ruleSpecialEntity ) ) )+ otherlv_5= '}' )
            {
            // InternalMyDsl.g:322:2: (otherlv_0= 'submodule' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_operations_3_0= ruleOperation ) )+ ( ( (lv_entities_4_1= ruleGeneralEntity | lv_entities_4_2= ruleSpecialEntity ) ) )+ otherlv_5= '}' )
            // InternalMyDsl.g:323:3: otherlv_0= 'submodule' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_operations_3_0= ruleOperation ) )+ ( ( (lv_entities_4_1= ruleGeneralEntity | lv_entities_4_2= ruleSpecialEntity ) ) )+ otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,16,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getSubmoduleAccess().getSubmoduleKeyword_0());
            		
            // InternalMyDsl.g:327:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMyDsl.g:328:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMyDsl.g:328:4: (lv_name_1_0= RULE_ID )
            // InternalMyDsl.g:329:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_3); 

            					newLeafNode(lv_name_1_0, grammarAccess.getSubmoduleAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSubmoduleRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_14); 

            			newLeafNode(otherlv_2, grammarAccess.getSubmoduleAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:349:3: ( (lv_operations_3_0= ruleOperation ) )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==17) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalMyDsl.g:350:4: (lv_operations_3_0= ruleOperation )
            	    {
            	    // InternalMyDsl.g:350:4: (lv_operations_3_0= ruleOperation )
            	    // InternalMyDsl.g:351:5: lv_operations_3_0= ruleOperation
            	    {

            	    					newCompositeNode(grammarAccess.getSubmoduleAccess().getOperationsOperationParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_15);
            	    lv_operations_3_0=ruleOperation();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getSubmoduleRule());
            	    					}
            	    					add(
            	    						current,
            	    						"operations",
            	    						lv_operations_3_0,
            	    						"org.xtext.example.mydsl.MyDsl.Operation");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);

            // InternalMyDsl.g:368:3: ( ( (lv_entities_4_1= ruleGeneralEntity | lv_entities_4_2= ruleSpecialEntity ) ) )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==22||LA7_0==25) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalMyDsl.g:369:4: ( (lv_entities_4_1= ruleGeneralEntity | lv_entities_4_2= ruleSpecialEntity ) )
            	    {
            	    // InternalMyDsl.g:369:4: ( (lv_entities_4_1= ruleGeneralEntity | lv_entities_4_2= ruleSpecialEntity ) )
            	    // InternalMyDsl.g:370:5: (lv_entities_4_1= ruleGeneralEntity | lv_entities_4_2= ruleSpecialEntity )
            	    {
            	    // InternalMyDsl.g:370:5: (lv_entities_4_1= ruleGeneralEntity | lv_entities_4_2= ruleSpecialEntity )
            	    int alt6=2;
            	    int LA6_0 = input.LA(1);

            	    if ( (LA6_0==22) ) {
            	        alt6=1;
            	    }
            	    else if ( (LA6_0==25) ) {
            	        alt6=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 6, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt6) {
            	        case 1 :
            	            // InternalMyDsl.g:371:6: lv_entities_4_1= ruleGeneralEntity
            	            {

            	            						newCompositeNode(grammarAccess.getSubmoduleAccess().getEntitiesGeneralEntityParserRuleCall_4_0_0());
            	            					
            	            pushFollow(FOLLOW_16);
            	            lv_entities_4_1=ruleGeneralEntity();

            	            state._fsp--;


            	            						if (current==null) {
            	            							current = createModelElementForParent(grammarAccess.getSubmoduleRule());
            	            						}
            	            						add(
            	            							current,
            	            							"entities",
            	            							lv_entities_4_1,
            	            							"org.xtext.example.mydsl.MyDsl.GeneralEntity");
            	            						afterParserOrEnumRuleCall();
            	            					

            	            }
            	            break;
            	        case 2 :
            	            // InternalMyDsl.g:387:6: lv_entities_4_2= ruleSpecialEntity
            	            {

            	            						newCompositeNode(grammarAccess.getSubmoduleAccess().getEntitiesSpecialEntityParserRuleCall_4_0_1());
            	            					
            	            pushFollow(FOLLOW_16);
            	            lv_entities_4_2=ruleSpecialEntity();

            	            state._fsp--;


            	            						if (current==null) {
            	            							current = createModelElementForParent(grammarAccess.getSubmoduleRule());
            	            						}
            	            						add(
            	            							current,
            	            							"entities",
            	            							lv_entities_4_2,
            	            							"org.xtext.example.mydsl.MyDsl.SpecialEntity");
            	            						afterParserOrEnumRuleCall();
            	            					

            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);

            otherlv_5=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getSubmoduleAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSubmodule"


    // $ANTLR start "entryRuleOperation"
    // InternalMyDsl.g:413:1: entryRuleOperation returns [EObject current=null] : iv_ruleOperation= ruleOperation EOF ;
    public final EObject entryRuleOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperation = null;


        try {
            // InternalMyDsl.g:413:50: (iv_ruleOperation= ruleOperation EOF )
            // InternalMyDsl.g:414:2: iv_ruleOperation= ruleOperation EOF
            {
             newCompositeNode(grammarAccess.getOperationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOperation=ruleOperation();

            state._fsp--;

             current =iv_ruleOperation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOperation"


    // $ANTLR start "ruleOperation"
    // InternalMyDsl.g:420:1: ruleOperation returns [EObject current=null] : (otherlv_0= 'op' otherlv_1= '{' otherlv_2= 'type:' ( (lv_type_3_0= ruleSubOperation ) ) otherlv_4= 'operates_on:' ( (lv_target_5_0= ruleEntityName ) ) otherlv_6= '}' ) ;
    public final EObject ruleOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_type_3_0 = null;

        EObject lv_target_5_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:426:2: ( (otherlv_0= 'op' otherlv_1= '{' otherlv_2= 'type:' ( (lv_type_3_0= ruleSubOperation ) ) otherlv_4= 'operates_on:' ( (lv_target_5_0= ruleEntityName ) ) otherlv_6= '}' ) )
            // InternalMyDsl.g:427:2: (otherlv_0= 'op' otherlv_1= '{' otherlv_2= 'type:' ( (lv_type_3_0= ruleSubOperation ) ) otherlv_4= 'operates_on:' ( (lv_target_5_0= ruleEntityName ) ) otherlv_6= '}' )
            {
            // InternalMyDsl.g:427:2: (otherlv_0= 'op' otherlv_1= '{' otherlv_2= 'type:' ( (lv_type_3_0= ruleSubOperation ) ) otherlv_4= 'operates_on:' ( (lv_target_5_0= ruleEntityName ) ) otherlv_6= '}' )
            // InternalMyDsl.g:428:3: otherlv_0= 'op' otherlv_1= '{' otherlv_2= 'type:' ( (lv_type_3_0= ruleSubOperation ) ) otherlv_4= 'operates_on:' ( (lv_target_5_0= ruleEntityName ) ) otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,17,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getOperationAccess().getOpKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_17); 

            			newLeafNode(otherlv_1, grammarAccess.getOperationAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,18,FOLLOW_18); 

            			newLeafNode(otherlv_2, grammarAccess.getOperationAccess().getTypeKeyword_2());
            		
            // InternalMyDsl.g:440:3: ( (lv_type_3_0= ruleSubOperation ) )
            // InternalMyDsl.g:441:4: (lv_type_3_0= ruleSubOperation )
            {
            // InternalMyDsl.g:441:4: (lv_type_3_0= ruleSubOperation )
            // InternalMyDsl.g:442:5: lv_type_3_0= ruleSubOperation
            {

            					newCompositeNode(grammarAccess.getOperationAccess().getTypeSubOperationParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_19);
            lv_type_3_0=ruleSubOperation();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOperationRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_3_0,
            						"org.xtext.example.mydsl.MyDsl.SubOperation");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,19,FOLLOW_11); 

            			newLeafNode(otherlv_4, grammarAccess.getOperationAccess().getOperates_onKeyword_4());
            		
            // InternalMyDsl.g:463:3: ( (lv_target_5_0= ruleEntityName ) )
            // InternalMyDsl.g:464:4: (lv_target_5_0= ruleEntityName )
            {
            // InternalMyDsl.g:464:4: (lv_target_5_0= ruleEntityName )
            // InternalMyDsl.g:465:5: lv_target_5_0= ruleEntityName
            {

            					newCompositeNode(grammarAccess.getOperationAccess().getTargetEntityNameParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_7);
            lv_target_5_0=ruleEntityName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOperationRule());
            					}
            					add(
            						current,
            						"target",
            						lv_target_5_0,
            						"org.xtext.example.mydsl.MyDsl.EntityName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getOperationAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOperation"


    // $ANTLR start "entryRuleEntityName"
    // InternalMyDsl.g:490:1: entryRuleEntityName returns [EObject current=null] : iv_ruleEntityName= ruleEntityName EOF ;
    public final EObject entryRuleEntityName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityName = null;


        try {
            // InternalMyDsl.g:490:51: (iv_ruleEntityName= ruleEntityName EOF )
            // InternalMyDsl.g:491:2: iv_ruleEntityName= ruleEntityName EOF
            {
             newCompositeNode(grammarAccess.getEntityNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEntityName=ruleEntityName();

            state._fsp--;

             current =iv_ruleEntityName; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntityName"


    // $ANTLR start "ruleEntityName"
    // InternalMyDsl.g:497:1: ruleEntityName returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleEntityName() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalMyDsl.g:503:2: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalMyDsl.g:504:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalMyDsl.g:504:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalMyDsl.g:505:3: (lv_name_0_0= RULE_ID )
            {
            // InternalMyDsl.g:505:3: (lv_name_0_0= RULE_ID )
            // InternalMyDsl.g:506:4: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getEntityNameAccess().getNameIDTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getEntityNameRule());
            				}
            				setWithLastConsumed(
            					current,
            					"name",
            					lv_name_0_0,
            					"org.eclipse.xtext.common.Terminals.ID");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEntityName"


    // $ANTLR start "entryRuleSubOperation"
    // InternalMyDsl.g:525:1: entryRuleSubOperation returns [String current=null] : iv_ruleSubOperation= ruleSubOperation EOF ;
    public final String entryRuleSubOperation() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSubOperation = null;


        try {
            // InternalMyDsl.g:525:52: (iv_ruleSubOperation= ruleSubOperation EOF )
            // InternalMyDsl.g:526:2: iv_ruleSubOperation= ruleSubOperation EOF
            {
             newCompositeNode(grammarAccess.getSubOperationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSubOperation=ruleSubOperation();

            state._fsp--;

             current =iv_ruleSubOperation.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSubOperation"


    // $ANTLR start "ruleSubOperation"
    // InternalMyDsl.g:532:1: ruleSubOperation returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Read' | kw= 'Create' ) ;
    public final AntlrDatatypeRuleToken ruleSubOperation() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalMyDsl.g:538:2: ( (kw= 'Read' | kw= 'Create' ) )
            // InternalMyDsl.g:539:2: (kw= 'Read' | kw= 'Create' )
            {
            // InternalMyDsl.g:539:2: (kw= 'Read' | kw= 'Create' )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==20) ) {
                alt8=1;
            }
            else if ( (LA8_0==21) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalMyDsl.g:540:3: kw= 'Read'
                    {
                    kw=(Token)match(input,20,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getSubOperationAccess().getReadKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:546:3: kw= 'Create'
                    {
                    kw=(Token)match(input,21,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getSubOperationAccess().getCreateKeyword_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSubOperation"


    // $ANTLR start "entryRuleGeneralEntity"
    // InternalMyDsl.g:555:1: entryRuleGeneralEntity returns [EObject current=null] : iv_ruleGeneralEntity= ruleGeneralEntity EOF ;
    public final EObject entryRuleGeneralEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGeneralEntity = null;


        try {
            // InternalMyDsl.g:555:54: (iv_ruleGeneralEntity= ruleGeneralEntity EOF )
            // InternalMyDsl.g:556:2: iv_ruleGeneralEntity= ruleGeneralEntity EOF
            {
             newCompositeNode(grammarAccess.getGeneralEntityRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGeneralEntity=ruleGeneralEntity();

            state._fsp--;

             current =iv_ruleGeneralEntity; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGeneralEntity"


    // $ANTLR start "ruleGeneralEntity"
    // InternalMyDsl.g:562:1: ruleGeneralEntity returns [EObject current=null] : (otherlv_0= 'generalEntity' ( (lv_name_1_0= ruleEntityName ) ) otherlv_2= '{' ( (lv_properties_3_0= ruleProperty ) )+ otherlv_4= '}' ) ;
    public final EObject ruleGeneralEntity() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_name_1_0 = null;

        EObject lv_properties_3_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:568:2: ( (otherlv_0= 'generalEntity' ( (lv_name_1_0= ruleEntityName ) ) otherlv_2= '{' ( (lv_properties_3_0= ruleProperty ) )+ otherlv_4= '}' ) )
            // InternalMyDsl.g:569:2: (otherlv_0= 'generalEntity' ( (lv_name_1_0= ruleEntityName ) ) otherlv_2= '{' ( (lv_properties_3_0= ruleProperty ) )+ otherlv_4= '}' )
            {
            // InternalMyDsl.g:569:2: (otherlv_0= 'generalEntity' ( (lv_name_1_0= ruleEntityName ) ) otherlv_2= '{' ( (lv_properties_3_0= ruleProperty ) )+ otherlv_4= '}' )
            // InternalMyDsl.g:570:3: otherlv_0= 'generalEntity' ( (lv_name_1_0= ruleEntityName ) ) otherlv_2= '{' ( (lv_properties_3_0= ruleProperty ) )+ otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,22,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getGeneralEntityAccess().getGeneralEntityKeyword_0());
            		
            // InternalMyDsl.g:574:3: ( (lv_name_1_0= ruleEntityName ) )
            // InternalMyDsl.g:575:4: (lv_name_1_0= ruleEntityName )
            {
            // InternalMyDsl.g:575:4: (lv_name_1_0= ruleEntityName )
            // InternalMyDsl.g:576:5: lv_name_1_0= ruleEntityName
            {

            					newCompositeNode(grammarAccess.getGeneralEntityAccess().getNameEntityNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_3);
            lv_name_1_0=ruleEntityName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGeneralEntityRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.example.mydsl.MyDsl.EntityName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_11); 

            			newLeafNode(otherlv_2, grammarAccess.getGeneralEntityAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:597:3: ( (lv_properties_3_0= ruleProperty ) )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==RULE_ID) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalMyDsl.g:598:4: (lv_properties_3_0= ruleProperty )
            	    {
            	    // InternalMyDsl.g:598:4: (lv_properties_3_0= ruleProperty )
            	    // InternalMyDsl.g:599:5: lv_properties_3_0= ruleProperty
            	    {

            	    					newCompositeNode(grammarAccess.getGeneralEntityAccess().getPropertiesPropertyParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_20);
            	    lv_properties_3_0=ruleProperty();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getGeneralEntityRule());
            	    					}
            	    					add(
            	    						current,
            	    						"properties",
            	    						lv_properties_3_0,
            	    						"org.xtext.example.mydsl.MyDsl.Property");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);

            otherlv_4=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getGeneralEntityAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGeneralEntity"


    // $ANTLR start "entryRuleProperty"
    // InternalMyDsl.g:624:1: entryRuleProperty returns [EObject current=null] : iv_ruleProperty= ruleProperty EOF ;
    public final EObject entryRuleProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProperty = null;


        try {
            // InternalMyDsl.g:624:49: (iv_ruleProperty= ruleProperty EOF )
            // InternalMyDsl.g:625:2: iv_ruleProperty= ruleProperty EOF
            {
             newCompositeNode(grammarAccess.getPropertyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProperty=ruleProperty();

            state._fsp--;

             current =iv_ruleProperty; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProperty"


    // $ANTLR start "ruleProperty"
    // InternalMyDsl.g:631:1: ruleProperty returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleProperty() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalMyDsl.g:637:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) )
            // InternalMyDsl.g:638:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalMyDsl.g:638:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) )
            // InternalMyDsl.g:639:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) )
            {
            // InternalMyDsl.g:639:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalMyDsl.g:640:4: (lv_name_0_0= RULE_ID )
            {
            // InternalMyDsl.g:640:4: (lv_name_0_0= RULE_ID )
            // InternalMyDsl.g:641:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_21); 

            					newLeafNode(lv_name_0_0, grammarAccess.getPropertyAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPropertyRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,23,FOLLOW_11); 

            			newLeafNode(otherlv_1, grammarAccess.getPropertyAccess().getColonKeyword_1());
            		
            // InternalMyDsl.g:661:3: ( (otherlv_2= RULE_ID ) )
            // InternalMyDsl.g:662:4: (otherlv_2= RULE_ID )
            {
            // InternalMyDsl.g:662:4: (otherlv_2= RULE_ID )
            // InternalMyDsl.g:663:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPropertyRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(otherlv_2, grammarAccess.getPropertyAccess().getTypeTypeCrossReference_2_0());
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProperty"


    // $ANTLR start "entryRuleType"
    // InternalMyDsl.g:678:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // InternalMyDsl.g:678:45: (iv_ruleType= ruleType EOF )
            // InternalMyDsl.g:679:2: iv_ruleType= ruleType EOF
            {
             newCompositeNode(grammarAccess.getTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleType=ruleType();

            state._fsp--;

             current =iv_ruleType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleType"


    // $ANTLR start "ruleType"
    // InternalMyDsl.g:685:1: ruleType returns [EObject current=null] : (otherlv_0= 'dataType' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalMyDsl.g:691:2: ( (otherlv_0= 'dataType' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalMyDsl.g:692:2: (otherlv_0= 'dataType' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalMyDsl.g:692:2: (otherlv_0= 'dataType' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalMyDsl.g:693:3: otherlv_0= 'dataType' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,24,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getTypeAccess().getDataTypeKeyword_0());
            		
            // InternalMyDsl.g:697:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMyDsl.g:698:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMyDsl.g:698:4: (lv_name_1_0= RULE_ID )
            // InternalMyDsl.g:699:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getTypeAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTypeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleType"


    // $ANTLR start "entryRuleSpecialEntity"
    // InternalMyDsl.g:719:1: entryRuleSpecialEntity returns [EObject current=null] : iv_ruleSpecialEntity= ruleSpecialEntity EOF ;
    public final EObject entryRuleSpecialEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecialEntity = null;


        try {
            // InternalMyDsl.g:719:54: (iv_ruleSpecialEntity= ruleSpecialEntity EOF )
            // InternalMyDsl.g:720:2: iv_ruleSpecialEntity= ruleSpecialEntity EOF
            {
             newCompositeNode(grammarAccess.getSpecialEntityRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSpecialEntity=ruleSpecialEntity();

            state._fsp--;

             current =iv_ruleSpecialEntity; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSpecialEntity"


    // $ANTLR start "ruleSpecialEntity"
    // InternalMyDsl.g:726:1: ruleSpecialEntity returns [EObject current=null] : (otherlv_0= 'specialEntity' ( (lv_name_1_0= ruleEntityName ) ) otherlv_2= '{' ( (lv_properties_3_0= ruleProperty ) )+ ( (lv_transactions_4_0= ruleTransaction ) )+ otherlv_5= '}' ) ;
    public final EObject ruleSpecialEntity() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject lv_name_1_0 = null;

        EObject lv_properties_3_0 = null;

        EObject lv_transactions_4_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:732:2: ( (otherlv_0= 'specialEntity' ( (lv_name_1_0= ruleEntityName ) ) otherlv_2= '{' ( (lv_properties_3_0= ruleProperty ) )+ ( (lv_transactions_4_0= ruleTransaction ) )+ otherlv_5= '}' ) )
            // InternalMyDsl.g:733:2: (otherlv_0= 'specialEntity' ( (lv_name_1_0= ruleEntityName ) ) otherlv_2= '{' ( (lv_properties_3_0= ruleProperty ) )+ ( (lv_transactions_4_0= ruleTransaction ) )+ otherlv_5= '}' )
            {
            // InternalMyDsl.g:733:2: (otherlv_0= 'specialEntity' ( (lv_name_1_0= ruleEntityName ) ) otherlv_2= '{' ( (lv_properties_3_0= ruleProperty ) )+ ( (lv_transactions_4_0= ruleTransaction ) )+ otherlv_5= '}' )
            // InternalMyDsl.g:734:3: otherlv_0= 'specialEntity' ( (lv_name_1_0= ruleEntityName ) ) otherlv_2= '{' ( (lv_properties_3_0= ruleProperty ) )+ ( (lv_transactions_4_0= ruleTransaction ) )+ otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,25,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getSpecialEntityAccess().getSpecialEntityKeyword_0());
            		
            // InternalMyDsl.g:738:3: ( (lv_name_1_0= ruleEntityName ) )
            // InternalMyDsl.g:739:4: (lv_name_1_0= ruleEntityName )
            {
            // InternalMyDsl.g:739:4: (lv_name_1_0= ruleEntityName )
            // InternalMyDsl.g:740:5: lv_name_1_0= ruleEntityName
            {

            					newCompositeNode(grammarAccess.getSpecialEntityAccess().getNameEntityNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_3);
            lv_name_1_0=ruleEntityName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSpecialEntityRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.example.mydsl.MyDsl.EntityName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_11); 

            			newLeafNode(otherlv_2, grammarAccess.getSpecialEntityAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:761:3: ( (lv_properties_3_0= ruleProperty ) )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==RULE_ID) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalMyDsl.g:762:4: (lv_properties_3_0= ruleProperty )
            	    {
            	    // InternalMyDsl.g:762:4: (lv_properties_3_0= ruleProperty )
            	    // InternalMyDsl.g:763:5: lv_properties_3_0= ruleProperty
            	    {

            	    					newCompositeNode(grammarAccess.getSpecialEntityAccess().getPropertiesPropertyParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_22);
            	    lv_properties_3_0=ruleProperty();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getSpecialEntityRule());
            	    					}
            	    					add(
            	    						current,
            	    						"properties",
            	    						lv_properties_3_0,
            	    						"org.xtext.example.mydsl.MyDsl.Property");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);

            // InternalMyDsl.g:780:3: ( (lv_transactions_4_0= ruleTransaction ) )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==26) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalMyDsl.g:781:4: (lv_transactions_4_0= ruleTransaction )
            	    {
            	    // InternalMyDsl.g:781:4: (lv_transactions_4_0= ruleTransaction )
            	    // InternalMyDsl.g:782:5: lv_transactions_4_0= ruleTransaction
            	    {

            	    					newCompositeNode(grammarAccess.getSpecialEntityAccess().getTransactionsTransactionParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_23);
            	    lv_transactions_4_0=ruleTransaction();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getSpecialEntityRule());
            	    					}
            	    					add(
            	    						current,
            	    						"transactions",
            	    						lv_transactions_4_0,
            	    						"org.xtext.example.mydsl.MyDsl.Transaction");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);

            otherlv_5=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getSpecialEntityAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSpecialEntity"


    // $ANTLR start "entryRuleTransaction"
    // InternalMyDsl.g:807:1: entryRuleTransaction returns [EObject current=null] : iv_ruleTransaction= ruleTransaction EOF ;
    public final EObject entryRuleTransaction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransaction = null;


        try {
            // InternalMyDsl.g:807:52: (iv_ruleTransaction= ruleTransaction EOF )
            // InternalMyDsl.g:808:2: iv_ruleTransaction= ruleTransaction EOF
            {
             newCompositeNode(grammarAccess.getTransactionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTransaction=ruleTransaction();

            state._fsp--;

             current =iv_ruleTransaction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTransaction"


    // $ANTLR start "ruleTransaction"
    // InternalMyDsl.g:814:1: ruleTransaction returns [EObject current=null] : (otherlv_0= 'trx' otherlv_1= '{' otherlv_2= 'type:' ( (lv_type_3_0= ruleSubTransaction ) ) ( (lv_operateson_4_0= ruleOperateson ) )+ otherlv_5= '}' ) ;
    public final EObject ruleTransaction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_type_3_0 = null;

        EObject lv_operateson_4_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:820:2: ( (otherlv_0= 'trx' otherlv_1= '{' otherlv_2= 'type:' ( (lv_type_3_0= ruleSubTransaction ) ) ( (lv_operateson_4_0= ruleOperateson ) )+ otherlv_5= '}' ) )
            // InternalMyDsl.g:821:2: (otherlv_0= 'trx' otherlv_1= '{' otherlv_2= 'type:' ( (lv_type_3_0= ruleSubTransaction ) ) ( (lv_operateson_4_0= ruleOperateson ) )+ otherlv_5= '}' )
            {
            // InternalMyDsl.g:821:2: (otherlv_0= 'trx' otherlv_1= '{' otherlv_2= 'type:' ( (lv_type_3_0= ruleSubTransaction ) ) ( (lv_operateson_4_0= ruleOperateson ) )+ otherlv_5= '}' )
            // InternalMyDsl.g:822:3: otherlv_0= 'trx' otherlv_1= '{' otherlv_2= 'type:' ( (lv_type_3_0= ruleSubTransaction ) ) ( (lv_operateson_4_0= ruleOperateson ) )+ otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,26,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getTransactionAccess().getTrxKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_17); 

            			newLeafNode(otherlv_1, grammarAccess.getTransactionAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,18,FOLLOW_24); 

            			newLeafNode(otherlv_2, grammarAccess.getTransactionAccess().getTypeKeyword_2());
            		
            // InternalMyDsl.g:834:3: ( (lv_type_3_0= ruleSubTransaction ) )
            // InternalMyDsl.g:835:4: (lv_type_3_0= ruleSubTransaction )
            {
            // InternalMyDsl.g:835:4: (lv_type_3_0= ruleSubTransaction )
            // InternalMyDsl.g:836:5: lv_type_3_0= ruleSubTransaction
            {

            					newCompositeNode(grammarAccess.getTransactionAccess().getTypeSubTransactionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_19);
            lv_type_3_0=ruleSubTransaction();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTransactionRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_3_0,
            						"org.xtext.example.mydsl.MyDsl.SubTransaction");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:853:3: ( (lv_operateson_4_0= ruleOperateson ) )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==19) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalMyDsl.g:854:4: (lv_operateson_4_0= ruleOperateson )
            	    {
            	    // InternalMyDsl.g:854:4: (lv_operateson_4_0= ruleOperateson )
            	    // InternalMyDsl.g:855:5: lv_operateson_4_0= ruleOperateson
            	    {

            	    					newCompositeNode(grammarAccess.getTransactionAccess().getOperatesonOperatesonParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_25);
            	    lv_operateson_4_0=ruleOperateson();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTransactionRule());
            	    					}
            	    					add(
            	    						current,
            	    						"operateson",
            	    						lv_operateson_4_0,
            	    						"org.xtext.example.mydsl.MyDsl.Operateson");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);

            otherlv_5=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getTransactionAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTransaction"


    // $ANTLR start "entryRuleSubTransaction"
    // InternalMyDsl.g:880:1: entryRuleSubTransaction returns [String current=null] : iv_ruleSubTransaction= ruleSubTransaction EOF ;
    public final String entryRuleSubTransaction() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSubTransaction = null;


        try {
            // InternalMyDsl.g:880:54: (iv_ruleSubTransaction= ruleSubTransaction EOF )
            // InternalMyDsl.g:881:2: iv_ruleSubTransaction= ruleSubTransaction EOF
            {
             newCompositeNode(grammarAccess.getSubTransactionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSubTransaction=ruleSubTransaction();

            state._fsp--;

             current =iv_ruleSubTransaction.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSubTransaction"


    // $ANTLR start "ruleSubTransaction"
    // InternalMyDsl.g:887:1: ruleSubTransaction returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'exchange' | kw= 'sale' ) ;
    public final AntlrDatatypeRuleToken ruleSubTransaction() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalMyDsl.g:893:2: ( (kw= 'exchange' | kw= 'sale' ) )
            // InternalMyDsl.g:894:2: (kw= 'exchange' | kw= 'sale' )
            {
            // InternalMyDsl.g:894:2: (kw= 'exchange' | kw= 'sale' )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==27) ) {
                alt13=1;
            }
            else if ( (LA13_0==28) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalMyDsl.g:895:3: kw= 'exchange'
                    {
                    kw=(Token)match(input,27,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getSubTransactionAccess().getExchangeKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:901:3: kw= 'sale'
                    {
                    kw=(Token)match(input,28,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getSubTransactionAccess().getSaleKeyword_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSubTransaction"


    // $ANTLR start "entryRuleOperateson"
    // InternalMyDsl.g:910:1: entryRuleOperateson returns [EObject current=null] : iv_ruleOperateson= ruleOperateson EOF ;
    public final EObject entryRuleOperateson() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperateson = null;


        try {
            // InternalMyDsl.g:910:51: (iv_ruleOperateson= ruleOperateson EOF )
            // InternalMyDsl.g:911:2: iv_ruleOperateson= ruleOperateson EOF
            {
             newCompositeNode(grammarAccess.getOperatesonRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOperateson=ruleOperateson();

            state._fsp--;

             current =iv_ruleOperateson; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOperateson"


    // $ANTLR start "ruleOperateson"
    // InternalMyDsl.g:917:1: ruleOperateson returns [EObject current=null] : (otherlv_0= 'operates_on:' ( (lv_operateson_1_0= ruleEntityName ) ) ) ;
    public final EObject ruleOperateson() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_operateson_1_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:923:2: ( (otherlv_0= 'operates_on:' ( (lv_operateson_1_0= ruleEntityName ) ) ) )
            // InternalMyDsl.g:924:2: (otherlv_0= 'operates_on:' ( (lv_operateson_1_0= ruleEntityName ) ) )
            {
            // InternalMyDsl.g:924:2: (otherlv_0= 'operates_on:' ( (lv_operateson_1_0= ruleEntityName ) ) )
            // InternalMyDsl.g:925:3: otherlv_0= 'operates_on:' ( (lv_operateson_1_0= ruleEntityName ) )
            {
            otherlv_0=(Token)match(input,19,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getOperatesonAccess().getOperates_onKeyword_0());
            		
            // InternalMyDsl.g:929:3: ( (lv_operateson_1_0= ruleEntityName ) )
            // InternalMyDsl.g:930:4: (lv_operateson_1_0= ruleEntityName )
            {
            // InternalMyDsl.g:930:4: (lv_operateson_1_0= ruleEntityName )
            // InternalMyDsl.g:931:5: lv_operateson_1_0= ruleEntityName
            {

            					newCompositeNode(grammarAccess.getOperatesonAccess().getOperatesonEntityNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_operateson_1_0=ruleEntityName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOperatesonRule());
            					}
            					add(
            						current,
            						"operateson",
            						lv_operateson_1_0,
            						"org.xtext.example.mydsl.MyDsl.EntityName");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOperateson"


    // $ANTLR start "entryRuleRelationDom"
    // InternalMyDsl.g:952:1: entryRuleRelationDom returns [EObject current=null] : iv_ruleRelationDom= ruleRelationDom EOF ;
    public final EObject entryRuleRelationDom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationDom = null;


        try {
            // InternalMyDsl.g:952:52: (iv_ruleRelationDom= ruleRelationDom EOF )
            // InternalMyDsl.g:953:2: iv_ruleRelationDom= ruleRelationDom EOF
            {
             newCompositeNode(grammarAccess.getRelationDomRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRelationDom=ruleRelationDom();

            state._fsp--;

             current =iv_ruleRelationDom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRelationDom"


    // $ANTLR start "ruleRelationDom"
    // InternalMyDsl.g:959:1: ruleRelationDom returns [EObject current=null] : (otherlv_0= 'rel' otherlv_1= '{' otherlv_2= 'type:' otherlv_3= 'Composition' otherlv_4= 'source:' ( (lv_source_5_0= ruleEntityName ) ) otherlv_6= 'target:' ( (lv_target_7_0= ruleEntityName ) ) otherlv_8= '}' ) ;
    public final EObject ruleRelationDom() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_source_5_0 = null;

        EObject lv_target_7_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:965:2: ( (otherlv_0= 'rel' otherlv_1= '{' otherlv_2= 'type:' otherlv_3= 'Composition' otherlv_4= 'source:' ( (lv_source_5_0= ruleEntityName ) ) otherlv_6= 'target:' ( (lv_target_7_0= ruleEntityName ) ) otherlv_8= '}' ) )
            // InternalMyDsl.g:966:2: (otherlv_0= 'rel' otherlv_1= '{' otherlv_2= 'type:' otherlv_3= 'Composition' otherlv_4= 'source:' ( (lv_source_5_0= ruleEntityName ) ) otherlv_6= 'target:' ( (lv_target_7_0= ruleEntityName ) ) otherlv_8= '}' )
            {
            // InternalMyDsl.g:966:2: (otherlv_0= 'rel' otherlv_1= '{' otherlv_2= 'type:' otherlv_3= 'Composition' otherlv_4= 'source:' ( (lv_source_5_0= ruleEntityName ) ) otherlv_6= 'target:' ( (lv_target_7_0= ruleEntityName ) ) otherlv_8= '}' )
            // InternalMyDsl.g:967:3: otherlv_0= 'rel' otherlv_1= '{' otherlv_2= 'type:' otherlv_3= 'Composition' otherlv_4= 'source:' ( (lv_source_5_0= ruleEntityName ) ) otherlv_6= 'target:' ( (lv_target_7_0= ruleEntityName ) ) otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,29,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getRelationDomAccess().getRelKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_17); 

            			newLeafNode(otherlv_1, grammarAccess.getRelationDomAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,18,FOLLOW_26); 

            			newLeafNode(otherlv_2, grammarAccess.getRelationDomAccess().getTypeKeyword_2());
            		
            otherlv_3=(Token)match(input,30,FOLLOW_27); 

            			newLeafNode(otherlv_3, grammarAccess.getRelationDomAccess().getCompositionKeyword_3());
            		
            otherlv_4=(Token)match(input,31,FOLLOW_11); 

            			newLeafNode(otherlv_4, grammarAccess.getRelationDomAccess().getSourceKeyword_4());
            		
            // InternalMyDsl.g:987:3: ( (lv_source_5_0= ruleEntityName ) )
            // InternalMyDsl.g:988:4: (lv_source_5_0= ruleEntityName )
            {
            // InternalMyDsl.g:988:4: (lv_source_5_0= ruleEntityName )
            // InternalMyDsl.g:989:5: lv_source_5_0= ruleEntityName
            {

            					newCompositeNode(grammarAccess.getRelationDomAccess().getSourceEntityNameParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_28);
            lv_source_5_0=ruleEntityName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRelationDomRule());
            					}
            					add(
            						current,
            						"source",
            						lv_source_5_0,
            						"org.xtext.example.mydsl.MyDsl.EntityName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,32,FOLLOW_11); 

            			newLeafNode(otherlv_6, grammarAccess.getRelationDomAccess().getTargetKeyword_6());
            		
            // InternalMyDsl.g:1010:3: ( (lv_target_7_0= ruleEntityName ) )
            // InternalMyDsl.g:1011:4: (lv_target_7_0= ruleEntityName )
            {
            // InternalMyDsl.g:1011:4: (lv_target_7_0= ruleEntityName )
            // InternalMyDsl.g:1012:5: lv_target_7_0= ruleEntityName
            {

            					newCompositeNode(grammarAccess.getRelationDomAccess().getTargetEntityNameParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_7);
            lv_target_7_0=ruleEntityName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRelationDomRule());
            					}
            					add(
            						current,
            						"target",
            						lv_target_7_0,
            						"org.xtext.example.mydsl.MyDsl.EntityName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_8=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getRelationDomAccess().getRightCurlyBracketKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRelationDom"


    // $ANTLR start "entryRuleArchitecture"
    // InternalMyDsl.g:1037:1: entryRuleArchitecture returns [EObject current=null] : iv_ruleArchitecture= ruleArchitecture EOF ;
    public final EObject entryRuleArchitecture() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArchitecture = null;


        try {
            // InternalMyDsl.g:1037:53: (iv_ruleArchitecture= ruleArchitecture EOF )
            // InternalMyDsl.g:1038:2: iv_ruleArchitecture= ruleArchitecture EOF
            {
             newCompositeNode(grammarAccess.getArchitectureRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleArchitecture=ruleArchitecture();

            state._fsp--;

             current =iv_ruleArchitecture; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArchitecture"


    // $ANTLR start "ruleArchitecture"
    // InternalMyDsl.g:1044:1: ruleArchitecture returns [EObject current=null] : (otherlv_0= 'arch' otherlv_1= '{' ( (lv_componentes_2_0= ruleComponent ) )+ ( (lv_relationArch_3_0= ruleRelationArch ) )+ otherlv_4= '}' ) ;
    public final EObject ruleArchitecture() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_componentes_2_0 = null;

        EObject lv_relationArch_3_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1050:2: ( (otherlv_0= 'arch' otherlv_1= '{' ( (lv_componentes_2_0= ruleComponent ) )+ ( (lv_relationArch_3_0= ruleRelationArch ) )+ otherlv_4= '}' ) )
            // InternalMyDsl.g:1051:2: (otherlv_0= 'arch' otherlv_1= '{' ( (lv_componentes_2_0= ruleComponent ) )+ ( (lv_relationArch_3_0= ruleRelationArch ) )+ otherlv_4= '}' )
            {
            // InternalMyDsl.g:1051:2: (otherlv_0= 'arch' otherlv_1= '{' ( (lv_componentes_2_0= ruleComponent ) )+ ( (lv_relationArch_3_0= ruleRelationArch ) )+ otherlv_4= '}' )
            // InternalMyDsl.g:1052:3: otherlv_0= 'arch' otherlv_1= '{' ( (lv_componentes_2_0= ruleComponent ) )+ ( (lv_relationArch_3_0= ruleRelationArch ) )+ otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,33,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getArchitectureAccess().getArchKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_29); 

            			newLeafNode(otherlv_1, grammarAccess.getArchitectureAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalMyDsl.g:1060:3: ( (lv_componentes_2_0= ruleComponent ) )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==34) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalMyDsl.g:1061:4: (lv_componentes_2_0= ruleComponent )
            	    {
            	    // InternalMyDsl.g:1061:4: (lv_componentes_2_0= ruleComponent )
            	    // InternalMyDsl.g:1062:5: lv_componentes_2_0= ruleComponent
            	    {

            	    					newCompositeNode(grammarAccess.getArchitectureAccess().getComponentesComponentParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_30);
            	    lv_componentes_2_0=ruleComponent();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getArchitectureRule());
            	    					}
            	    					add(
            	    						current,
            	    						"componentes",
            	    						lv_componentes_2_0,
            	    						"org.xtext.example.mydsl.MyDsl.Component");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt14 >= 1 ) break loop14;
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
            } while (true);

            // InternalMyDsl.g:1079:3: ( (lv_relationArch_3_0= ruleRelationArch ) )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==55) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalMyDsl.g:1080:4: (lv_relationArch_3_0= ruleRelationArch )
            	    {
            	    // InternalMyDsl.g:1080:4: (lv_relationArch_3_0= ruleRelationArch )
            	    // InternalMyDsl.g:1081:5: lv_relationArch_3_0= ruleRelationArch
            	    {

            	    					newCompositeNode(grammarAccess.getArchitectureAccess().getRelationArchRelationArchParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_31);
            	    lv_relationArch_3_0=ruleRelationArch();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getArchitectureRule());
            	    					}
            	    					add(
            	    						current,
            	    						"relationArch",
            	    						lv_relationArch_3_0,
            	    						"org.xtext.example.mydsl.MyDsl.RelationArch");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt15 >= 1 ) break loop15;
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
            } while (true);

            otherlv_4=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getArchitectureAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArchitecture"


    // $ANTLR start "entryRuleComponent"
    // InternalMyDsl.g:1106:1: entryRuleComponent returns [EObject current=null] : iv_ruleComponent= ruleComponent EOF ;
    public final EObject entryRuleComponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponent = null;


        try {
            // InternalMyDsl.g:1106:50: (iv_ruleComponent= ruleComponent EOF )
            // InternalMyDsl.g:1107:2: iv_ruleComponent= ruleComponent EOF
            {
             newCompositeNode(grammarAccess.getComponentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleComponent=ruleComponent();

            state._fsp--;

             current =iv_ruleComponent; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComponent"


    // $ANTLR start "ruleComponent"
    // InternalMyDsl.g:1113:1: ruleComponent returns [EObject current=null] : (otherlv_0= 'component' ( (lv_name_1_0= ruleComponentName ) ) otherlv_2= '{' ( (lv_layer_3_0= ruleLayer ) )+ otherlv_4= '}' ) ;
    public final EObject ruleComponent() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_layer_3_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1119:2: ( (otherlv_0= 'component' ( (lv_name_1_0= ruleComponentName ) ) otherlv_2= '{' ( (lv_layer_3_0= ruleLayer ) )+ otherlv_4= '}' ) )
            // InternalMyDsl.g:1120:2: (otherlv_0= 'component' ( (lv_name_1_0= ruleComponentName ) ) otherlv_2= '{' ( (lv_layer_3_0= ruleLayer ) )+ otherlv_4= '}' )
            {
            // InternalMyDsl.g:1120:2: (otherlv_0= 'component' ( (lv_name_1_0= ruleComponentName ) ) otherlv_2= '{' ( (lv_layer_3_0= ruleLayer ) )+ otherlv_4= '}' )
            // InternalMyDsl.g:1121:3: otherlv_0= 'component' ( (lv_name_1_0= ruleComponentName ) ) otherlv_2= '{' ( (lv_layer_3_0= ruleLayer ) )+ otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,34,FOLLOW_32); 

            			newLeafNode(otherlv_0, grammarAccess.getComponentAccess().getComponentKeyword_0());
            		
            // InternalMyDsl.g:1125:3: ( (lv_name_1_0= ruleComponentName ) )
            // InternalMyDsl.g:1126:4: (lv_name_1_0= ruleComponentName )
            {
            // InternalMyDsl.g:1126:4: (lv_name_1_0= ruleComponentName )
            // InternalMyDsl.g:1127:5: lv_name_1_0= ruleComponentName
            {

            					newCompositeNode(grammarAccess.getComponentAccess().getNameComponentNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_3);
            lv_name_1_0=ruleComponentName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getComponentRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.example.mydsl.MyDsl.ComponentName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_33); 

            			newLeafNode(otherlv_2, grammarAccess.getComponentAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:1148:3: ( (lv_layer_3_0= ruleLayer ) )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==37) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalMyDsl.g:1149:4: (lv_layer_3_0= ruleLayer )
            	    {
            	    // InternalMyDsl.g:1149:4: (lv_layer_3_0= ruleLayer )
            	    // InternalMyDsl.g:1150:5: lv_layer_3_0= ruleLayer
            	    {

            	    					newCompositeNode(grammarAccess.getComponentAccess().getLayerLayerParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_34);
            	    lv_layer_3_0=ruleLayer();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getComponentRule());
            	    					}
            	    					add(
            	    						current,
            	    						"layer",
            	    						lv_layer_3_0,
            	    						"org.xtext.example.mydsl.MyDsl.Layer");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
            } while (true);

            otherlv_4=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getComponentAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComponent"


    // $ANTLR start "entryRuleComponentName"
    // InternalMyDsl.g:1175:1: entryRuleComponentName returns [String current=null] : iv_ruleComponentName= ruleComponentName EOF ;
    public final String entryRuleComponentName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleComponentName = null;


        try {
            // InternalMyDsl.g:1175:53: (iv_ruleComponentName= ruleComponentName EOF )
            // InternalMyDsl.g:1176:2: iv_ruleComponentName= ruleComponentName EOF
            {
             newCompositeNode(grammarAccess.getComponentNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleComponentName=ruleComponentName();

            state._fsp--;

             current =iv_ruleComponentName.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComponentName"


    // $ANTLR start "ruleComponentName"
    // InternalMyDsl.g:1182:1: ruleComponentName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Back' | kw= 'Front' ) ;
    public final AntlrDatatypeRuleToken ruleComponentName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalMyDsl.g:1188:2: ( (kw= 'Back' | kw= 'Front' ) )
            // InternalMyDsl.g:1189:2: (kw= 'Back' | kw= 'Front' )
            {
            // InternalMyDsl.g:1189:2: (kw= 'Back' | kw= 'Front' )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==35) ) {
                alt17=1;
            }
            else if ( (LA17_0==36) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // InternalMyDsl.g:1190:3: kw= 'Back'
                    {
                    kw=(Token)match(input,35,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getComponentNameAccess().getBackKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:1196:3: kw= 'Front'
                    {
                    kw=(Token)match(input,36,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getComponentNameAccess().getFrontKeyword_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComponentName"


    // $ANTLR start "entryRuleLayer"
    // InternalMyDsl.g:1205:1: entryRuleLayer returns [EObject current=null] : iv_ruleLayer= ruleLayer EOF ;
    public final EObject entryRuleLayer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLayer = null;


        try {
            // InternalMyDsl.g:1205:46: (iv_ruleLayer= ruleLayer EOF )
            // InternalMyDsl.g:1206:2: iv_ruleLayer= ruleLayer EOF
            {
             newCompositeNode(grammarAccess.getLayerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLayer=ruleLayer();

            state._fsp--;

             current =iv_ruleLayer; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLayer"


    // $ANTLR start "ruleLayer"
    // InternalMyDsl.g:1212:1: ruleLayer returns [EObject current=null] : (otherlv_0= 'layer' ( (lv_name_1_0= ruleLayerName ) ) otherlv_2= '{' ( (lv_layerSegments_3_0= ruleLayerSegment ) )* otherlv_4= '}' ) ;
    public final EObject ruleLayer() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_layerSegments_3_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1218:2: ( (otherlv_0= 'layer' ( (lv_name_1_0= ruleLayerName ) ) otherlv_2= '{' ( (lv_layerSegments_3_0= ruleLayerSegment ) )* otherlv_4= '}' ) )
            // InternalMyDsl.g:1219:2: (otherlv_0= 'layer' ( (lv_name_1_0= ruleLayerName ) ) otherlv_2= '{' ( (lv_layerSegments_3_0= ruleLayerSegment ) )* otherlv_4= '}' )
            {
            // InternalMyDsl.g:1219:2: (otherlv_0= 'layer' ( (lv_name_1_0= ruleLayerName ) ) otherlv_2= '{' ( (lv_layerSegments_3_0= ruleLayerSegment ) )* otherlv_4= '}' )
            // InternalMyDsl.g:1220:3: otherlv_0= 'layer' ( (lv_name_1_0= ruleLayerName ) ) otherlv_2= '{' ( (lv_layerSegments_3_0= ruleLayerSegment ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,37,FOLLOW_35); 

            			newLeafNode(otherlv_0, grammarAccess.getLayerAccess().getLayerKeyword_0());
            		
            // InternalMyDsl.g:1224:3: ( (lv_name_1_0= ruleLayerName ) )
            // InternalMyDsl.g:1225:4: (lv_name_1_0= ruleLayerName )
            {
            // InternalMyDsl.g:1225:4: (lv_name_1_0= ruleLayerName )
            // InternalMyDsl.g:1226:5: lv_name_1_0= ruleLayerName
            {

            					newCompositeNode(grammarAccess.getLayerAccess().getNameLayerNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_3);
            lv_name_1_0=ruleLayerName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLayerRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.example.mydsl.MyDsl.LayerName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_36); 

            			newLeafNode(otherlv_2, grammarAccess.getLayerAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:1247:3: ( (lv_layerSegments_3_0= ruleLayerSegment ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==41) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalMyDsl.g:1248:4: (lv_layerSegments_3_0= ruleLayerSegment )
            	    {
            	    // InternalMyDsl.g:1248:4: (lv_layerSegments_3_0= ruleLayerSegment )
            	    // InternalMyDsl.g:1249:5: lv_layerSegments_3_0= ruleLayerSegment
            	    {

            	    					newCompositeNode(grammarAccess.getLayerAccess().getLayerSegmentsLayerSegmentParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_36);
            	    lv_layerSegments_3_0=ruleLayerSegment();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getLayerRule());
            	    					}
            	    					add(
            	    						current,
            	    						"layerSegments",
            	    						lv_layerSegments_3_0,
            	    						"org.xtext.example.mydsl.MyDsl.LayerSegment");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            otherlv_4=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getLayerAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLayer"


    // $ANTLR start "entryRuleLayerName"
    // InternalMyDsl.g:1274:1: entryRuleLayerName returns [String current=null] : iv_ruleLayerName= ruleLayerName EOF ;
    public final String entryRuleLayerName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLayerName = null;


        try {
            // InternalMyDsl.g:1274:49: (iv_ruleLayerName= ruleLayerName EOF )
            // InternalMyDsl.g:1275:2: iv_ruleLayerName= ruleLayerName EOF
            {
             newCompositeNode(grammarAccess.getLayerNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLayerName=ruleLayerName();

            state._fsp--;

             current =iv_ruleLayerName.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLayerName"


    // $ANTLR start "ruleLayerName"
    // InternalMyDsl.g:1281:1: ruleLayerName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'JavaScript' | kw= 'Ejb' | kw= 'War' ) ;
    public final AntlrDatatypeRuleToken ruleLayerName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalMyDsl.g:1287:2: ( (kw= 'JavaScript' | kw= 'Ejb' | kw= 'War' ) )
            // InternalMyDsl.g:1288:2: (kw= 'JavaScript' | kw= 'Ejb' | kw= 'War' )
            {
            // InternalMyDsl.g:1288:2: (kw= 'JavaScript' | kw= 'Ejb' | kw= 'War' )
            int alt19=3;
            switch ( input.LA(1) ) {
            case 38:
                {
                alt19=1;
                }
                break;
            case 39:
                {
                alt19=2;
                }
                break;
            case 40:
                {
                alt19=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // InternalMyDsl.g:1289:3: kw= 'JavaScript'
                    {
                    kw=(Token)match(input,38,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getLayerNameAccess().getJavaScriptKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:1295:3: kw= 'Ejb'
                    {
                    kw=(Token)match(input,39,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getLayerNameAccess().getEjbKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:1301:3: kw= 'War'
                    {
                    kw=(Token)match(input,40,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getLayerNameAccess().getWarKeyword_2());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLayerName"


    // $ANTLR start "entryRuleLayerSegment"
    // InternalMyDsl.g:1310:1: entryRuleLayerSegment returns [EObject current=null] : iv_ruleLayerSegment= ruleLayerSegment EOF ;
    public final EObject entryRuleLayerSegment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLayerSegment = null;


        try {
            // InternalMyDsl.g:1310:53: (iv_ruleLayerSegment= ruleLayerSegment EOF )
            // InternalMyDsl.g:1311:2: iv_ruleLayerSegment= ruleLayerSegment EOF
            {
             newCompositeNode(grammarAccess.getLayerSegmentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLayerSegment=ruleLayerSegment();

            state._fsp--;

             current =iv_ruleLayerSegment; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLayerSegment"


    // $ANTLR start "ruleLayerSegment"
    // InternalMyDsl.g:1317:1: ruleLayerSegment returns [EObject current=null] : (otherlv_0= 'layerSegment' ( (lv_name_1_0= ruleLayerSegmentName ) ) otherlv_2= '{' (otherlv_3= '{' ( (lv_relations_4_0= ruleLayerSegmentRelation ) )* otherlv_5= '}' )? ( (lv_sublayerSegments_6_0= ruleSublayerSegment ) )* otherlv_7= '}' ) ;
    public final EObject ruleLayerSegment() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_relations_4_0 = null;

        EObject lv_sublayerSegments_6_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1323:2: ( (otherlv_0= 'layerSegment' ( (lv_name_1_0= ruleLayerSegmentName ) ) otherlv_2= '{' (otherlv_3= '{' ( (lv_relations_4_0= ruleLayerSegmentRelation ) )* otherlv_5= '}' )? ( (lv_sublayerSegments_6_0= ruleSublayerSegment ) )* otherlv_7= '}' ) )
            // InternalMyDsl.g:1324:2: (otherlv_0= 'layerSegment' ( (lv_name_1_0= ruleLayerSegmentName ) ) otherlv_2= '{' (otherlv_3= '{' ( (lv_relations_4_0= ruleLayerSegmentRelation ) )* otherlv_5= '}' )? ( (lv_sublayerSegments_6_0= ruleSublayerSegment ) )* otherlv_7= '}' )
            {
            // InternalMyDsl.g:1324:2: (otherlv_0= 'layerSegment' ( (lv_name_1_0= ruleLayerSegmentName ) ) otherlv_2= '{' (otherlv_3= '{' ( (lv_relations_4_0= ruleLayerSegmentRelation ) )* otherlv_5= '}' )? ( (lv_sublayerSegments_6_0= ruleSublayerSegment ) )* otherlv_7= '}' )
            // InternalMyDsl.g:1325:3: otherlv_0= 'layerSegment' ( (lv_name_1_0= ruleLayerSegmentName ) ) otherlv_2= '{' (otherlv_3= '{' ( (lv_relations_4_0= ruleLayerSegmentRelation ) )* otherlv_5= '}' )? ( (lv_sublayerSegments_6_0= ruleSublayerSegment ) )* otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,41,FOLLOW_37); 

            			newLeafNode(otherlv_0, grammarAccess.getLayerSegmentAccess().getLayerSegmentKeyword_0());
            		
            // InternalMyDsl.g:1329:3: ( (lv_name_1_0= ruleLayerSegmentName ) )
            // InternalMyDsl.g:1330:4: (lv_name_1_0= ruleLayerSegmentName )
            {
            // InternalMyDsl.g:1330:4: (lv_name_1_0= ruleLayerSegmentName )
            // InternalMyDsl.g:1331:5: lv_name_1_0= ruleLayerSegmentName
            {

            					newCompositeNode(grammarAccess.getLayerSegmentAccess().getNameLayerSegmentNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_3);
            lv_name_1_0=ruleLayerSegmentName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLayerSegmentRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.example.mydsl.MyDsl.LayerSegmentName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_38); 

            			newLeafNode(otherlv_2, grammarAccess.getLayerSegmentAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:1352:3: (otherlv_3= '{' ( (lv_relations_4_0= ruleLayerSegmentRelation ) )* otherlv_5= '}' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==12) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalMyDsl.g:1353:4: otherlv_3= '{' ( (lv_relations_4_0= ruleLayerSegmentRelation ) )* otherlv_5= '}'
                    {
                    otherlv_3=(Token)match(input,12,FOLLOW_39); 

                    				newLeafNode(otherlv_3, grammarAccess.getLayerSegmentAccess().getLeftCurlyBracketKeyword_3_0());
                    			
                    // InternalMyDsl.g:1357:4: ( (lv_relations_4_0= ruleLayerSegmentRelation ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==42) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // InternalMyDsl.g:1358:5: (lv_relations_4_0= ruleLayerSegmentRelation )
                    	    {
                    	    // InternalMyDsl.g:1358:5: (lv_relations_4_0= ruleLayerSegmentRelation )
                    	    // InternalMyDsl.g:1359:6: lv_relations_4_0= ruleLayerSegmentRelation
                    	    {

                    	    						newCompositeNode(grammarAccess.getLayerSegmentAccess().getRelationsLayerSegmentRelationParserRuleCall_3_1_0());
                    	    					
                    	    pushFollow(FOLLOW_39);
                    	    lv_relations_4_0=ruleLayerSegmentRelation();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getLayerSegmentRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"relations",
                    	    							lv_relations_4_0,
                    	    							"org.xtext.example.mydsl.MyDsl.LayerSegmentRelation");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,13,FOLLOW_40); 

                    				newLeafNode(otherlv_5, grammarAccess.getLayerSegmentAccess().getRightCurlyBracketKeyword_3_2());
                    			

                    }
                    break;

            }

            // InternalMyDsl.g:1381:3: ( (lv_sublayerSegments_6_0= ruleSublayerSegment ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==52) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalMyDsl.g:1382:4: (lv_sublayerSegments_6_0= ruleSublayerSegment )
            	    {
            	    // InternalMyDsl.g:1382:4: (lv_sublayerSegments_6_0= ruleSublayerSegment )
            	    // InternalMyDsl.g:1383:5: lv_sublayerSegments_6_0= ruleSublayerSegment
            	    {

            	    					newCompositeNode(grammarAccess.getLayerSegmentAccess().getSublayerSegmentsSublayerSegmentParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_40);
            	    lv_sublayerSegments_6_0=ruleSublayerSegment();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getLayerSegmentRule());
            	    					}
            	    					add(
            	    						current,
            	    						"sublayerSegments",
            	    						lv_sublayerSegments_6_0,
            	    						"org.xtext.example.mydsl.MyDsl.SublayerSegment");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            otherlv_7=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getLayerSegmentAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLayerSegment"


    // $ANTLR start "entryRuleLayerSegmentRelation"
    // InternalMyDsl.g:1408:1: entryRuleLayerSegmentRelation returns [EObject current=null] : iv_ruleLayerSegmentRelation= ruleLayerSegmentRelation EOF ;
    public final EObject entryRuleLayerSegmentRelation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLayerSegmentRelation = null;


        try {
            // InternalMyDsl.g:1408:61: (iv_ruleLayerSegmentRelation= ruleLayerSegmentRelation EOF )
            // InternalMyDsl.g:1409:2: iv_ruleLayerSegmentRelation= ruleLayerSegmentRelation EOF
            {
             newCompositeNode(grammarAccess.getLayerSegmentRelationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLayerSegmentRelation=ruleLayerSegmentRelation();

            state._fsp--;

             current =iv_ruleLayerSegmentRelation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLayerSegmentRelation"


    // $ANTLR start "ruleLayerSegmentRelation"
    // InternalMyDsl.g:1415:1: ruleLayerSegmentRelation returns [EObject current=null] : (otherlv_0= 'allowedToUse:' ( (lv_layerSegment_1_0= ruleLayerSegmentName ) ) ) ;
    public final EObject ruleLayerSegmentRelation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_layerSegment_1_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1421:2: ( (otherlv_0= 'allowedToUse:' ( (lv_layerSegment_1_0= ruleLayerSegmentName ) ) ) )
            // InternalMyDsl.g:1422:2: (otherlv_0= 'allowedToUse:' ( (lv_layerSegment_1_0= ruleLayerSegmentName ) ) )
            {
            // InternalMyDsl.g:1422:2: (otherlv_0= 'allowedToUse:' ( (lv_layerSegment_1_0= ruleLayerSegmentName ) ) )
            // InternalMyDsl.g:1423:3: otherlv_0= 'allowedToUse:' ( (lv_layerSegment_1_0= ruleLayerSegmentName ) )
            {
            otherlv_0=(Token)match(input,42,FOLLOW_37); 

            			newLeafNode(otherlv_0, grammarAccess.getLayerSegmentRelationAccess().getAllowedToUseKeyword_0());
            		
            // InternalMyDsl.g:1427:3: ( (lv_layerSegment_1_0= ruleLayerSegmentName ) )
            // InternalMyDsl.g:1428:4: (lv_layerSegment_1_0= ruleLayerSegmentName )
            {
            // InternalMyDsl.g:1428:4: (lv_layerSegment_1_0= ruleLayerSegmentName )
            // InternalMyDsl.g:1429:5: lv_layerSegment_1_0= ruleLayerSegmentName
            {

            					newCompositeNode(grammarAccess.getLayerSegmentRelationAccess().getLayerSegmentLayerSegmentNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_layerSegment_1_0=ruleLayerSegmentName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLayerSegmentRelationRule());
            					}
            					set(
            						current,
            						"layerSegment",
            						lv_layerSegment_1_0,
            						"org.xtext.example.mydsl.MyDsl.LayerSegmentName");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLayerSegmentRelation"


    // $ANTLR start "entryRuleLayerSegmentName"
    // InternalMyDsl.g:1450:1: entryRuleLayerSegmentName returns [String current=null] : iv_ruleLayerSegmentName= ruleLayerSegmentName EOF ;
    public final String entryRuleLayerSegmentName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLayerSegmentName = null;


        try {
            // InternalMyDsl.g:1450:56: (iv_ruleLayerSegmentName= ruleLayerSegmentName EOF )
            // InternalMyDsl.g:1451:2: iv_ruleLayerSegmentName= ruleLayerSegmentName EOF
            {
             newCompositeNode(grammarAccess.getLayerSegmentNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLayerSegmentName=ruleLayerSegmentName();

            state._fsp--;

             current =iv_ruleLayerSegmentName.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLayerSegmentName"


    // $ANTLR start "ruleLayerSegmentName"
    // InternalMyDsl.g:1457:1: ruleLayerSegmentName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Services' | kw= 'Ui' | kw= 'Store' | kw= 'RestEntity' | kw= 'Pojo' | kw= 'Facade' | kw= 'Dto' | kw= 'Util' | kw= 'Containers' ) ;
    public final AntlrDatatypeRuleToken ruleLayerSegmentName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalMyDsl.g:1463:2: ( (kw= 'Services' | kw= 'Ui' | kw= 'Store' | kw= 'RestEntity' | kw= 'Pojo' | kw= 'Facade' | kw= 'Dto' | kw= 'Util' | kw= 'Containers' ) )
            // InternalMyDsl.g:1464:2: (kw= 'Services' | kw= 'Ui' | kw= 'Store' | kw= 'RestEntity' | kw= 'Pojo' | kw= 'Facade' | kw= 'Dto' | kw= 'Util' | kw= 'Containers' )
            {
            // InternalMyDsl.g:1464:2: (kw= 'Services' | kw= 'Ui' | kw= 'Store' | kw= 'RestEntity' | kw= 'Pojo' | kw= 'Facade' | kw= 'Dto' | kw= 'Util' | kw= 'Containers' )
            int alt23=9;
            switch ( input.LA(1) ) {
            case 43:
                {
                alt23=1;
                }
                break;
            case 44:
                {
                alt23=2;
                }
                break;
            case 45:
                {
                alt23=3;
                }
                break;
            case 46:
                {
                alt23=4;
                }
                break;
            case 47:
                {
                alt23=5;
                }
                break;
            case 48:
                {
                alt23=6;
                }
                break;
            case 49:
                {
                alt23=7;
                }
                break;
            case 50:
                {
                alt23=8;
                }
                break;
            case 51:
                {
                alt23=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // InternalMyDsl.g:1465:3: kw= 'Services'
                    {
                    kw=(Token)match(input,43,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getLayerSegmentNameAccess().getServicesKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:1471:3: kw= 'Ui'
                    {
                    kw=(Token)match(input,44,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getLayerSegmentNameAccess().getUiKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:1477:3: kw= 'Store'
                    {
                    kw=(Token)match(input,45,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getLayerSegmentNameAccess().getStoreKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:1483:3: kw= 'RestEntity'
                    {
                    kw=(Token)match(input,46,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getLayerSegmentNameAccess().getRestEntityKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalMyDsl.g:1489:3: kw= 'Pojo'
                    {
                    kw=(Token)match(input,47,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getLayerSegmentNameAccess().getPojoKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalMyDsl.g:1495:3: kw= 'Facade'
                    {
                    kw=(Token)match(input,48,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getLayerSegmentNameAccess().getFacadeKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalMyDsl.g:1501:3: kw= 'Dto'
                    {
                    kw=(Token)match(input,49,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getLayerSegmentNameAccess().getDtoKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalMyDsl.g:1507:3: kw= 'Util'
                    {
                    kw=(Token)match(input,50,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getLayerSegmentNameAccess().getUtilKeyword_7());
                    		

                    }
                    break;
                case 9 :
                    // InternalMyDsl.g:1513:3: kw= 'Containers'
                    {
                    kw=(Token)match(input,51,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getLayerSegmentNameAccess().getContainersKeyword_8());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLayerSegmentName"


    // $ANTLR start "entryRuleSublayerSegment"
    // InternalMyDsl.g:1522:1: entryRuleSublayerSegment returns [EObject current=null] : iv_ruleSublayerSegment= ruleSublayerSegment EOF ;
    public final EObject entryRuleSublayerSegment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSublayerSegment = null;


        try {
            // InternalMyDsl.g:1522:56: (iv_ruleSublayerSegment= ruleSublayerSegment EOF )
            // InternalMyDsl.g:1523:2: iv_ruleSublayerSegment= ruleSublayerSegment EOF
            {
             newCompositeNode(grammarAccess.getSublayerSegmentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSublayerSegment=ruleSublayerSegment();

            state._fsp--;

             current =iv_ruleSublayerSegment; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSublayerSegment"


    // $ANTLR start "ruleSublayerSegment"
    // InternalMyDsl.g:1529:1: ruleSublayerSegment returns [EObject current=null] : (otherlv_0= 'sublayerSegment' ( (lv_name_1_0= ruleSublayerSegmentName ) ) ) ;
    public final EObject ruleSublayerSegment() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1535:2: ( (otherlv_0= 'sublayerSegment' ( (lv_name_1_0= ruleSublayerSegmentName ) ) ) )
            // InternalMyDsl.g:1536:2: (otherlv_0= 'sublayerSegment' ( (lv_name_1_0= ruleSublayerSegmentName ) ) )
            {
            // InternalMyDsl.g:1536:2: (otherlv_0= 'sublayerSegment' ( (lv_name_1_0= ruleSublayerSegmentName ) ) )
            // InternalMyDsl.g:1537:3: otherlv_0= 'sublayerSegment' ( (lv_name_1_0= ruleSublayerSegmentName ) )
            {
            otherlv_0=(Token)match(input,52,FOLLOW_41); 

            			newLeafNode(otherlv_0, grammarAccess.getSublayerSegmentAccess().getSublayerSegmentKeyword_0());
            		
            // InternalMyDsl.g:1541:3: ( (lv_name_1_0= ruleSublayerSegmentName ) )
            // InternalMyDsl.g:1542:4: (lv_name_1_0= ruleSublayerSegmentName )
            {
            // InternalMyDsl.g:1542:4: (lv_name_1_0= ruleSublayerSegmentName )
            // InternalMyDsl.g:1543:5: lv_name_1_0= ruleSublayerSegmentName
            {

            					newCompositeNode(grammarAccess.getSublayerSegmentAccess().getNameSublayerSegmentNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_name_1_0=ruleSublayerSegmentName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSublayerSegmentRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.example.mydsl.MyDsl.SublayerSegmentName");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSublayerSegment"


    // $ANTLR start "entryRuleSublayerSegmentName"
    // InternalMyDsl.g:1564:1: entryRuleSublayerSegmentName returns [String current=null] : iv_ruleSublayerSegmentName= ruleSublayerSegmentName EOF ;
    public final String entryRuleSublayerSegmentName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSublayerSegmentName = null;


        try {
            // InternalMyDsl.g:1564:59: (iv_ruleSublayerSegmentName= ruleSublayerSegmentName EOF )
            // InternalMyDsl.g:1565:2: iv_ruleSublayerSegmentName= ruleSublayerSegmentName EOF
            {
             newCompositeNode(grammarAccess.getSublayerSegmentNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSublayerSegmentName=ruleSublayerSegmentName();

            state._fsp--;

             current =iv_ruleSublayerSegmentName.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSublayerSegmentName"


    // $ANTLR start "ruleSublayerSegmentName"
    // InternalMyDsl.g:1571:1: ruleSublayerSegmentName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Actions' | kw= 'Reducers' ) ;
    public final AntlrDatatypeRuleToken ruleSublayerSegmentName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalMyDsl.g:1577:2: ( (kw= 'Actions' | kw= 'Reducers' ) )
            // InternalMyDsl.g:1578:2: (kw= 'Actions' | kw= 'Reducers' )
            {
            // InternalMyDsl.g:1578:2: (kw= 'Actions' | kw= 'Reducers' )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==53) ) {
                alt24=1;
            }
            else if ( (LA24_0==54) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // InternalMyDsl.g:1579:3: kw= 'Actions'
                    {
                    kw=(Token)match(input,53,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getSublayerSegmentNameAccess().getActionsKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:1585:3: kw= 'Reducers'
                    {
                    kw=(Token)match(input,54,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getSublayerSegmentNameAccess().getReducersKeyword_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSublayerSegmentName"


    // $ANTLR start "entryRuleRelationArch"
    // InternalMyDsl.g:1594:1: entryRuleRelationArch returns [EObject current=null] : iv_ruleRelationArch= ruleRelationArch EOF ;
    public final EObject entryRuleRelationArch() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationArch = null;


        try {
            // InternalMyDsl.g:1594:53: (iv_ruleRelationArch= ruleRelationArch EOF )
            // InternalMyDsl.g:1595:2: iv_ruleRelationArch= ruleRelationArch EOF
            {
             newCompositeNode(grammarAccess.getRelationArchRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRelationArch=ruleRelationArch();

            state._fsp--;

             current =iv_ruleRelationArch; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRelationArch"


    // $ANTLR start "ruleRelationArch"
    // InternalMyDsl.g:1601:1: ruleRelationArch returns [EObject current=null] : (otherlv_0= 'relationArch' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'source:' ( (lv_source_4_0= ruleLayerName ) ) otherlv_5= ',' otherlv_6= 'target:' ( (lv_target_7_0= ruleLayerName ) ) otherlv_8= '}' ) ;
    public final EObject ruleRelationArch() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_source_4_0 = null;

        AntlrDatatypeRuleToken lv_target_7_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1607:2: ( (otherlv_0= 'relationArch' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'source:' ( (lv_source_4_0= ruleLayerName ) ) otherlv_5= ',' otherlv_6= 'target:' ( (lv_target_7_0= ruleLayerName ) ) otherlv_8= '}' ) )
            // InternalMyDsl.g:1608:2: (otherlv_0= 'relationArch' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'source:' ( (lv_source_4_0= ruleLayerName ) ) otherlv_5= ',' otherlv_6= 'target:' ( (lv_target_7_0= ruleLayerName ) ) otherlv_8= '}' )
            {
            // InternalMyDsl.g:1608:2: (otherlv_0= 'relationArch' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'source:' ( (lv_source_4_0= ruleLayerName ) ) otherlv_5= ',' otherlv_6= 'target:' ( (lv_target_7_0= ruleLayerName ) ) otherlv_8= '}' )
            // InternalMyDsl.g:1609:3: otherlv_0= 'relationArch' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'source:' ( (lv_source_4_0= ruleLayerName ) ) otherlv_5= ',' otherlv_6= 'target:' ( (lv_target_7_0= ruleLayerName ) ) otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,55,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getRelationArchAccess().getRelationArchKeyword_0());
            		
            // InternalMyDsl.g:1613:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMyDsl.g:1614:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMyDsl.g:1614:4: (lv_name_1_0= RULE_ID )
            // InternalMyDsl.g:1615:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_3); 

            					newLeafNode(lv_name_1_0, grammarAccess.getRelationArchAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRelationArchRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_27); 

            			newLeafNode(otherlv_2, grammarAccess.getRelationArchAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,31,FOLLOW_35); 

            			newLeafNode(otherlv_3, grammarAccess.getRelationArchAccess().getSourceKeyword_3());
            		
            // InternalMyDsl.g:1639:3: ( (lv_source_4_0= ruleLayerName ) )
            // InternalMyDsl.g:1640:4: (lv_source_4_0= ruleLayerName )
            {
            // InternalMyDsl.g:1640:4: (lv_source_4_0= ruleLayerName )
            // InternalMyDsl.g:1641:5: lv_source_4_0= ruleLayerName
            {

            					newCompositeNode(grammarAccess.getRelationArchAccess().getSourceLayerNameParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_42);
            lv_source_4_0=ruleLayerName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRelationArchRule());
            					}
            					set(
            						current,
            						"source",
            						lv_source_4_0,
            						"org.xtext.example.mydsl.MyDsl.LayerName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,56,FOLLOW_28); 

            			newLeafNode(otherlv_5, grammarAccess.getRelationArchAccess().getCommaKeyword_5());
            		
            otherlv_6=(Token)match(input,32,FOLLOW_35); 

            			newLeafNode(otherlv_6, grammarAccess.getRelationArchAccess().getTargetKeyword_6());
            		
            // InternalMyDsl.g:1666:3: ( (lv_target_7_0= ruleLayerName ) )
            // InternalMyDsl.g:1667:4: (lv_target_7_0= ruleLayerName )
            {
            // InternalMyDsl.g:1667:4: (lv_target_7_0= ruleLayerName )
            // InternalMyDsl.g:1668:5: lv_target_7_0= ruleLayerName
            {

            					newCompositeNode(grammarAccess.getRelationArchAccess().getTargetLayerNameParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_7);
            lv_target_7_0=ruleLayerName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRelationArchRule());
            					}
            					set(
            						current,
            						"target",
            						lv_target_7_0,
            						"org.xtext.example.mydsl.MyDsl.LayerName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_8=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getRelationArchAccess().getRightCurlyBracketKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRelationArch"


    // $ANTLR start "entryRuleTechnology"
    // InternalMyDsl.g:1693:1: entryRuleTechnology returns [EObject current=null] : iv_ruleTechnology= ruleTechnology EOF ;
    public final EObject entryRuleTechnology() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTechnology = null;


        try {
            // InternalMyDsl.g:1693:51: (iv_ruleTechnology= ruleTechnology EOF )
            // InternalMyDsl.g:1694:2: iv_ruleTechnology= ruleTechnology EOF
            {
             newCompositeNode(grammarAccess.getTechnologyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTechnology=ruleTechnology();

            state._fsp--;

             current =iv_ruleTechnology; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTechnology"


    // $ANTLR start "ruleTechnology"
    // InternalMyDsl.g:1700:1: ruleTechnology returns [EObject current=null] : (otherlv_0= 'tech' otherlv_1= '{' ( (lv_java_2_0= ruleJavaApp ) ) ( (lv_react_3_0= ruleReactApp ) ) otherlv_4= '}' ) ;
    public final EObject ruleTechnology() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_java_2_0 = null;

        EObject lv_react_3_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1706:2: ( (otherlv_0= 'tech' otherlv_1= '{' ( (lv_java_2_0= ruleJavaApp ) ) ( (lv_react_3_0= ruleReactApp ) ) otherlv_4= '}' ) )
            // InternalMyDsl.g:1707:2: (otherlv_0= 'tech' otherlv_1= '{' ( (lv_java_2_0= ruleJavaApp ) ) ( (lv_react_3_0= ruleReactApp ) ) otherlv_4= '}' )
            {
            // InternalMyDsl.g:1707:2: (otherlv_0= 'tech' otherlv_1= '{' ( (lv_java_2_0= ruleJavaApp ) ) ( (lv_react_3_0= ruleReactApp ) ) otherlv_4= '}' )
            // InternalMyDsl.g:1708:3: otherlv_0= 'tech' otherlv_1= '{' ( (lv_java_2_0= ruleJavaApp ) ) ( (lv_react_3_0= ruleReactApp ) ) otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,57,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getTechnologyAccess().getTechKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_43); 

            			newLeafNode(otherlv_1, grammarAccess.getTechnologyAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalMyDsl.g:1716:3: ( (lv_java_2_0= ruleJavaApp ) )
            // InternalMyDsl.g:1717:4: (lv_java_2_0= ruleJavaApp )
            {
            // InternalMyDsl.g:1717:4: (lv_java_2_0= ruleJavaApp )
            // InternalMyDsl.g:1718:5: lv_java_2_0= ruleJavaApp
            {

            					newCompositeNode(grammarAccess.getTechnologyAccess().getJavaJavaAppParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_44);
            lv_java_2_0=ruleJavaApp();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTechnologyRule());
            					}
            					set(
            						current,
            						"java",
            						lv_java_2_0,
            						"org.xtext.example.mydsl.MyDsl.JavaApp");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:1735:3: ( (lv_react_3_0= ruleReactApp ) )
            // InternalMyDsl.g:1736:4: (lv_react_3_0= ruleReactApp )
            {
            // InternalMyDsl.g:1736:4: (lv_react_3_0= ruleReactApp )
            // InternalMyDsl.g:1737:5: lv_react_3_0= ruleReactApp
            {

            					newCompositeNode(grammarAccess.getTechnologyAccess().getReactReactAppParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_7);
            lv_react_3_0=ruleReactApp();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTechnologyRule());
            					}
            					set(
            						current,
            						"react",
            						lv_react_3_0,
            						"org.xtext.example.mydsl.MyDsl.ReactApp");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getTechnologyAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTechnology"


    // $ANTLR start "entryRuleJavaApp"
    // InternalMyDsl.g:1762:1: entryRuleJavaApp returns [EObject current=null] : iv_ruleJavaApp= ruleJavaApp EOF ;
    public final EObject entryRuleJavaApp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJavaApp = null;


        try {
            // InternalMyDsl.g:1762:48: (iv_ruleJavaApp= ruleJavaApp EOF )
            // InternalMyDsl.g:1763:2: iv_ruleJavaApp= ruleJavaApp EOF
            {
             newCompositeNode(grammarAccess.getJavaAppRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJavaApp=ruleJavaApp();

            state._fsp--;

             current =iv_ruleJavaApp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJavaApp"


    // $ANTLR start "ruleJavaApp"
    // InternalMyDsl.g:1769:1: ruleJavaApp returns [EObject current=null] : (otherlv_0= 'javaApp' otherlv_1= '{' ( (lv_jeeproject_2_0= ruleJeeProject ) ) otherlv_3= '}' ) ;
    public final EObject ruleJavaApp() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_jeeproject_2_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1775:2: ( (otherlv_0= 'javaApp' otherlv_1= '{' ( (lv_jeeproject_2_0= ruleJeeProject ) ) otherlv_3= '}' ) )
            // InternalMyDsl.g:1776:2: (otherlv_0= 'javaApp' otherlv_1= '{' ( (lv_jeeproject_2_0= ruleJeeProject ) ) otherlv_3= '}' )
            {
            // InternalMyDsl.g:1776:2: (otherlv_0= 'javaApp' otherlv_1= '{' ( (lv_jeeproject_2_0= ruleJeeProject ) ) otherlv_3= '}' )
            // InternalMyDsl.g:1777:3: otherlv_0= 'javaApp' otherlv_1= '{' ( (lv_jeeproject_2_0= ruleJeeProject ) ) otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,58,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getJavaAppAccess().getJavaAppKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_45); 

            			newLeafNode(otherlv_1, grammarAccess.getJavaAppAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalMyDsl.g:1785:3: ( (lv_jeeproject_2_0= ruleJeeProject ) )
            // InternalMyDsl.g:1786:4: (lv_jeeproject_2_0= ruleJeeProject )
            {
            // InternalMyDsl.g:1786:4: (lv_jeeproject_2_0= ruleJeeProject )
            // InternalMyDsl.g:1787:5: lv_jeeproject_2_0= ruleJeeProject
            {

            					newCompositeNode(grammarAccess.getJavaAppAccess().getJeeprojectJeeProjectParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_7);
            lv_jeeproject_2_0=ruleJeeProject();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getJavaAppRule());
            					}
            					add(
            						current,
            						"jeeproject",
            						lv_jeeproject_2_0,
            						"org.xtext.example.mydsl.MyDsl.JeeProject");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getJavaAppAccess().getRightCurlyBracketKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJavaApp"


    // $ANTLR start "entryRuleJeeProject"
    // InternalMyDsl.g:1812:1: entryRuleJeeProject returns [EObject current=null] : iv_ruleJeeProject= ruleJeeProject EOF ;
    public final EObject entryRuleJeeProject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJeeProject = null;


        try {
            // InternalMyDsl.g:1812:51: (iv_ruleJeeProject= ruleJeeProject EOF )
            // InternalMyDsl.g:1813:2: iv_ruleJeeProject= ruleJeeProject EOF
            {
             newCompositeNode(grammarAccess.getJeeProjectRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJeeProject=ruleJeeProject();

            state._fsp--;

             current =iv_ruleJeeProject; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJeeProject"


    // $ANTLR start "ruleJeeProject"
    // InternalMyDsl.g:1819:1: ruleJeeProject returns [EObject current=null] : (otherlv_0= 'jeeProject' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_subproject_3_0= ruleSubproject ) )+ otherlv_4= '}' ) ;
    public final EObject ruleJeeProject() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_subproject_3_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1825:2: ( (otherlv_0= 'jeeProject' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_subproject_3_0= ruleSubproject ) )+ otherlv_4= '}' ) )
            // InternalMyDsl.g:1826:2: (otherlv_0= 'jeeProject' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_subproject_3_0= ruleSubproject ) )+ otherlv_4= '}' )
            {
            // InternalMyDsl.g:1826:2: (otherlv_0= 'jeeProject' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_subproject_3_0= ruleSubproject ) )+ otherlv_4= '}' )
            // InternalMyDsl.g:1827:3: otherlv_0= 'jeeProject' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_subproject_3_0= ruleSubproject ) )+ otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,59,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getJeeProjectAccess().getJeeProjectKeyword_0());
            		
            // InternalMyDsl.g:1831:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMyDsl.g:1832:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMyDsl.g:1832:4: (lv_name_1_0= RULE_ID )
            // InternalMyDsl.g:1833:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_3); 

            					newLeafNode(lv_name_1_0, grammarAccess.getJeeProjectAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJeeProjectRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_46); 

            			newLeafNode(otherlv_2, grammarAccess.getJeeProjectAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:1853:3: ( (lv_subproject_3_0= ruleSubproject ) )+
            int cnt25=0;
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==60) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalMyDsl.g:1854:4: (lv_subproject_3_0= ruleSubproject )
            	    {
            	    // InternalMyDsl.g:1854:4: (lv_subproject_3_0= ruleSubproject )
            	    // InternalMyDsl.g:1855:5: lv_subproject_3_0= ruleSubproject
            	    {

            	    					newCompositeNode(grammarAccess.getJeeProjectAccess().getSubprojectSubprojectParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_47);
            	    lv_subproject_3_0=ruleSubproject();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getJeeProjectRule());
            	    					}
            	    					add(
            	    						current,
            	    						"subproject",
            	    						lv_subproject_3_0,
            	    						"org.xtext.example.mydsl.MyDsl.Subproject");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt25 >= 1 ) break loop25;
                        EarlyExitException eee =
                            new EarlyExitException(25, input);
                        throw eee;
                }
                cnt25++;
            } while (true);

            otherlv_4=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getJeeProjectAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJeeProject"


    // $ANTLR start "entryRuleSubproject"
    // InternalMyDsl.g:1880:1: entryRuleSubproject returns [EObject current=null] : iv_ruleSubproject= ruleSubproject EOF ;
    public final EObject entryRuleSubproject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubproject = null;


        try {
            // InternalMyDsl.g:1880:51: (iv_ruleSubproject= ruleSubproject EOF )
            // InternalMyDsl.g:1881:2: iv_ruleSubproject= ruleSubproject EOF
            {
             newCompositeNode(grammarAccess.getSubprojectRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSubproject=ruleSubproject();

            state._fsp--;

             current =iv_ruleSubproject; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSubproject"


    // $ANTLR start "ruleSubproject"
    // InternalMyDsl.g:1887:1: ruleSubproject returns [EObject current=null] : (otherlv_0= 'subproject' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_epackage_3_0= ruleEpackage ) )+ otherlv_4= ',' ( (lv_library_5_0= ruleLibrary ) )+ otherlv_6= ',' ( (lv_descriptor_7_0= ruleDescriptor ) )+ otherlv_8= '}' ) ;
    public final EObject ruleSubproject() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_epackage_3_0 = null;

        EObject lv_library_5_0 = null;

        EObject lv_descriptor_7_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1893:2: ( (otherlv_0= 'subproject' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_epackage_3_0= ruleEpackage ) )+ otherlv_4= ',' ( (lv_library_5_0= ruleLibrary ) )+ otherlv_6= ',' ( (lv_descriptor_7_0= ruleDescriptor ) )+ otherlv_8= '}' ) )
            // InternalMyDsl.g:1894:2: (otherlv_0= 'subproject' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_epackage_3_0= ruleEpackage ) )+ otherlv_4= ',' ( (lv_library_5_0= ruleLibrary ) )+ otherlv_6= ',' ( (lv_descriptor_7_0= ruleDescriptor ) )+ otherlv_8= '}' )
            {
            // InternalMyDsl.g:1894:2: (otherlv_0= 'subproject' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_epackage_3_0= ruleEpackage ) )+ otherlv_4= ',' ( (lv_library_5_0= ruleLibrary ) )+ otherlv_6= ',' ( (lv_descriptor_7_0= ruleDescriptor ) )+ otherlv_8= '}' )
            // InternalMyDsl.g:1895:3: otherlv_0= 'subproject' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_epackage_3_0= ruleEpackage ) )+ otherlv_4= ',' ( (lv_library_5_0= ruleLibrary ) )+ otherlv_6= ',' ( (lv_descriptor_7_0= ruleDescriptor ) )+ otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,60,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getSubprojectAccess().getSubprojectKeyword_0());
            		
            // InternalMyDsl.g:1899:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMyDsl.g:1900:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMyDsl.g:1900:4: (lv_name_1_0= RULE_ID )
            // InternalMyDsl.g:1901:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_3); 

            					newLeafNode(lv_name_1_0, grammarAccess.getSubprojectAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSubprojectRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_48); 

            			newLeafNode(otherlv_2, grammarAccess.getSubprojectAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:1921:3: ( (lv_epackage_3_0= ruleEpackage ) )+
            int cnt26=0;
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==68) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalMyDsl.g:1922:4: (lv_epackage_3_0= ruleEpackage )
            	    {
            	    // InternalMyDsl.g:1922:4: (lv_epackage_3_0= ruleEpackage )
            	    // InternalMyDsl.g:1923:5: lv_epackage_3_0= ruleEpackage
            	    {

            	    					newCompositeNode(grammarAccess.getSubprojectAccess().getEpackageEpackageParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_49);
            	    lv_epackage_3_0=ruleEpackage();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getSubprojectRule());
            	    					}
            	    					add(
            	    						current,
            	    						"epackage",
            	    						lv_epackage_3_0,
            	    						"org.xtext.example.mydsl.MyDsl.Epackage");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt26 >= 1 ) break loop26;
                        EarlyExitException eee =
                            new EarlyExitException(26, input);
                        throw eee;
                }
                cnt26++;
            } while (true);

            otherlv_4=(Token)match(input,56,FOLLOW_50); 

            			newLeafNode(otherlv_4, grammarAccess.getSubprojectAccess().getCommaKeyword_4());
            		
            // InternalMyDsl.g:1944:3: ( (lv_library_5_0= ruleLibrary ) )+
            int cnt27=0;
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==77) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalMyDsl.g:1945:4: (lv_library_5_0= ruleLibrary )
            	    {
            	    // InternalMyDsl.g:1945:4: (lv_library_5_0= ruleLibrary )
            	    // InternalMyDsl.g:1946:5: lv_library_5_0= ruleLibrary
            	    {

            	    					newCompositeNode(grammarAccess.getSubprojectAccess().getLibraryLibraryParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_51);
            	    lv_library_5_0=ruleLibrary();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getSubprojectRule());
            	    					}
            	    					add(
            	    						current,
            	    						"library",
            	    						lv_library_5_0,
            	    						"org.xtext.example.mydsl.MyDsl.Library");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt27 >= 1 ) break loop27;
                        EarlyExitException eee =
                            new EarlyExitException(27, input);
                        throw eee;
                }
                cnt27++;
            } while (true);

            otherlv_6=(Token)match(input,56,FOLLOW_52); 

            			newLeafNode(otherlv_6, grammarAccess.getSubprojectAccess().getCommaKeyword_6());
            		
            // InternalMyDsl.g:1967:3: ( (lv_descriptor_7_0= ruleDescriptor ) )+
            int cnt28=0;
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==73) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalMyDsl.g:1968:4: (lv_descriptor_7_0= ruleDescriptor )
            	    {
            	    // InternalMyDsl.g:1968:4: (lv_descriptor_7_0= ruleDescriptor )
            	    // InternalMyDsl.g:1969:5: lv_descriptor_7_0= ruleDescriptor
            	    {

            	    					newCompositeNode(grammarAccess.getSubprojectAccess().getDescriptorDescriptorParserRuleCall_7_0());
            	    				
            	    pushFollow(FOLLOW_53);
            	    lv_descriptor_7_0=ruleDescriptor();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getSubprojectRule());
            	    					}
            	    					add(
            	    						current,
            	    						"descriptor",
            	    						lv_descriptor_7_0,
            	    						"org.xtext.example.mydsl.MyDsl.Descriptor");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt28 >= 1 ) break loop28;
                        EarlyExitException eee =
                            new EarlyExitException(28, input);
                        throw eee;
                }
                cnt28++;
            } while (true);

            otherlv_8=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getSubprojectAccess().getRightCurlyBracketKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSubproject"


    // $ANTLR start "entryRuleAbstractClass"
    // InternalMyDsl.g:1994:1: entryRuleAbstractClass returns [EObject current=null] : iv_ruleAbstractClass= ruleAbstractClass EOF ;
    public final EObject entryRuleAbstractClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractClass = null;


        try {
            // InternalMyDsl.g:1994:54: (iv_ruleAbstractClass= ruleAbstractClass EOF )
            // InternalMyDsl.g:1995:2: iv_ruleAbstractClass= ruleAbstractClass EOF
            {
             newCompositeNode(grammarAccess.getAbstractClassRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAbstractClass=ruleAbstractClass();

            state._fsp--;

             current =iv_ruleAbstractClass; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAbstractClass"


    // $ANTLR start "ruleAbstractClass"
    // InternalMyDsl.g:2001:1: ruleAbstractClass returns [EObject current=null] : (otherlv_0= 'abstractClass' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_attribute_3_0= ruleAttribute ) )* ( (lv_methodClass_4_0= ruleMethodBack ) )* (otherlv_5= 'use :' ( (otherlv_6= RULE_ID ) ) )* ( (lv_abstractMethod_7_0= ruleAbstractMethod ) )* otherlv_8= '}' ) ;
    public final EObject ruleAbstractClass() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_attribute_3_0 = null;

        EObject lv_methodClass_4_0 = null;

        EObject lv_abstractMethod_7_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:2007:2: ( (otherlv_0= 'abstractClass' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_attribute_3_0= ruleAttribute ) )* ( (lv_methodClass_4_0= ruleMethodBack ) )* (otherlv_5= 'use :' ( (otherlv_6= RULE_ID ) ) )* ( (lv_abstractMethod_7_0= ruleAbstractMethod ) )* otherlv_8= '}' ) )
            // InternalMyDsl.g:2008:2: (otherlv_0= 'abstractClass' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_attribute_3_0= ruleAttribute ) )* ( (lv_methodClass_4_0= ruleMethodBack ) )* (otherlv_5= 'use :' ( (otherlv_6= RULE_ID ) ) )* ( (lv_abstractMethod_7_0= ruleAbstractMethod ) )* otherlv_8= '}' )
            {
            // InternalMyDsl.g:2008:2: (otherlv_0= 'abstractClass' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_attribute_3_0= ruleAttribute ) )* ( (lv_methodClass_4_0= ruleMethodBack ) )* (otherlv_5= 'use :' ( (otherlv_6= RULE_ID ) ) )* ( (lv_abstractMethod_7_0= ruleAbstractMethod ) )* otherlv_8= '}' )
            // InternalMyDsl.g:2009:3: otherlv_0= 'abstractClass' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_attribute_3_0= ruleAttribute ) )* ( (lv_methodClass_4_0= ruleMethodBack ) )* (otherlv_5= 'use :' ( (otherlv_6= RULE_ID ) ) )* ( (lv_abstractMethod_7_0= ruleAbstractMethod ) )* otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,61,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getAbstractClassAccess().getAbstractClassKeyword_0());
            		
            // InternalMyDsl.g:2013:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMyDsl.g:2014:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMyDsl.g:2014:4: (lv_name_1_0= RULE_ID )
            // InternalMyDsl.g:2015:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_3); 

            					newLeafNode(lv_name_1_0, grammarAccess.getAbstractClassAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAbstractClassRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_54); 

            			newLeafNode(otherlv_2, grammarAccess.getAbstractClassAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:2035:3: ( (lv_attribute_3_0= ruleAttribute ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==67) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalMyDsl.g:2036:4: (lv_attribute_3_0= ruleAttribute )
            	    {
            	    // InternalMyDsl.g:2036:4: (lv_attribute_3_0= ruleAttribute )
            	    // InternalMyDsl.g:2037:5: lv_attribute_3_0= ruleAttribute
            	    {

            	    					newCompositeNode(grammarAccess.getAbstractClassAccess().getAttributeAttributeParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_54);
            	    lv_attribute_3_0=ruleAttribute();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getAbstractClassRule());
            	    					}
            	    					add(
            	    						current,
            	    						"attribute",
            	    						lv_attribute_3_0,
            	    						"org.xtext.example.mydsl.MyDsl.Attribute");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

            // InternalMyDsl.g:2054:3: ( (lv_methodClass_4_0= ruleMethodBack ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==69) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalMyDsl.g:2055:4: (lv_methodClass_4_0= ruleMethodBack )
            	    {
            	    // InternalMyDsl.g:2055:4: (lv_methodClass_4_0= ruleMethodBack )
            	    // InternalMyDsl.g:2056:5: lv_methodClass_4_0= ruleMethodBack
            	    {

            	    					newCompositeNode(grammarAccess.getAbstractClassAccess().getMethodClassMethodBackParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_55);
            	    lv_methodClass_4_0=ruleMethodBack();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getAbstractClassRule());
            	    					}
            	    					add(
            	    						current,
            	    						"methodClass",
            	    						lv_methodClass_4_0,
            	    						"org.xtext.example.mydsl.MyDsl.MethodBack");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

            // InternalMyDsl.g:2073:3: (otherlv_5= 'use :' ( (otherlv_6= RULE_ID ) ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==62) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalMyDsl.g:2074:4: otherlv_5= 'use :' ( (otherlv_6= RULE_ID ) )
            	    {
            	    otherlv_5=(Token)match(input,62,FOLLOW_11); 

            	    				newLeafNode(otherlv_5, grammarAccess.getAbstractClassAccess().getUseKeyword_5_0());
            	    			
            	    // InternalMyDsl.g:2078:4: ( (otherlv_6= RULE_ID ) )
            	    // InternalMyDsl.g:2079:5: (otherlv_6= RULE_ID )
            	    {
            	    // InternalMyDsl.g:2079:5: (otherlv_6= RULE_ID )
            	    // InternalMyDsl.g:2080:6: otherlv_6= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getAbstractClassRule());
            	    						}
            	    					
            	    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_56); 

            	    						newLeafNode(otherlv_6, grammarAccess.getAbstractClassAccess().getAnnotationAnnotationCrossReference_5_1_0());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

            // InternalMyDsl.g:2092:3: ( (lv_abstractMethod_7_0= ruleAbstractMethod ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==72) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalMyDsl.g:2093:4: (lv_abstractMethod_7_0= ruleAbstractMethod )
            	    {
            	    // InternalMyDsl.g:2093:4: (lv_abstractMethod_7_0= ruleAbstractMethod )
            	    // InternalMyDsl.g:2094:5: lv_abstractMethod_7_0= ruleAbstractMethod
            	    {

            	    					newCompositeNode(grammarAccess.getAbstractClassAccess().getAbstractMethodAbstractMethodParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_57);
            	    lv_abstractMethod_7_0=ruleAbstractMethod();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getAbstractClassRule());
            	    					}
            	    					add(
            	    						current,
            	    						"abstractMethod",
            	    						lv_abstractMethod_7_0,
            	    						"org.xtext.example.mydsl.MyDsl.AbstractMethod");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

            otherlv_8=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getAbstractClassAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAbstractClass"


    // $ANTLR start "entryRuleGenericClass"
    // InternalMyDsl.g:2119:1: entryRuleGenericClass returns [EObject current=null] : iv_ruleGenericClass= ruleGenericClass EOF ;
    public final EObject entryRuleGenericClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGenericClass = null;


        try {
            // InternalMyDsl.g:2119:53: (iv_ruleGenericClass= ruleGenericClass EOF )
            // InternalMyDsl.g:2120:2: iv_ruleGenericClass= ruleGenericClass EOF
            {
             newCompositeNode(grammarAccess.getGenericClassRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGenericClass=ruleGenericClass();

            state._fsp--;

             current =iv_ruleGenericClass; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGenericClass"


    // $ANTLR start "ruleGenericClass"
    // InternalMyDsl.g:2126:1: ruleGenericClass returns [EObject current=null] : (otherlv_0= 'genericClass' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_attribute_3_0= ruleAttribute ) )* ( (lv_methodClass_4_0= ruleMethodBack ) )* (otherlv_5= 'use :' ( (otherlv_6= RULE_ID ) ) )* (otherlv_7= 'extends :' ( (otherlv_8= RULE_ID ) ) )? (otherlv_9= 'implements :' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= '}' ) ;
    public final EObject ruleGenericClass() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        EObject lv_attribute_3_0 = null;

        EObject lv_methodClass_4_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:2132:2: ( (otherlv_0= 'genericClass' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_attribute_3_0= ruleAttribute ) )* ( (lv_methodClass_4_0= ruleMethodBack ) )* (otherlv_5= 'use :' ( (otherlv_6= RULE_ID ) ) )* (otherlv_7= 'extends :' ( (otherlv_8= RULE_ID ) ) )? (otherlv_9= 'implements :' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= '}' ) )
            // InternalMyDsl.g:2133:2: (otherlv_0= 'genericClass' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_attribute_3_0= ruleAttribute ) )* ( (lv_methodClass_4_0= ruleMethodBack ) )* (otherlv_5= 'use :' ( (otherlv_6= RULE_ID ) ) )* (otherlv_7= 'extends :' ( (otherlv_8= RULE_ID ) ) )? (otherlv_9= 'implements :' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= '}' )
            {
            // InternalMyDsl.g:2133:2: (otherlv_0= 'genericClass' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_attribute_3_0= ruleAttribute ) )* ( (lv_methodClass_4_0= ruleMethodBack ) )* (otherlv_5= 'use :' ( (otherlv_6= RULE_ID ) ) )* (otherlv_7= 'extends :' ( (otherlv_8= RULE_ID ) ) )? (otherlv_9= 'implements :' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= '}' )
            // InternalMyDsl.g:2134:3: otherlv_0= 'genericClass' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_attribute_3_0= ruleAttribute ) )* ( (lv_methodClass_4_0= ruleMethodBack ) )* (otherlv_5= 'use :' ( (otherlv_6= RULE_ID ) ) )* (otherlv_7= 'extends :' ( (otherlv_8= RULE_ID ) ) )? (otherlv_9= 'implements :' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= '}'
            {
            otherlv_0=(Token)match(input,63,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getGenericClassAccess().getGenericClassKeyword_0());
            		
            // InternalMyDsl.g:2138:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMyDsl.g:2139:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMyDsl.g:2139:4: (lv_name_1_0= RULE_ID )
            // InternalMyDsl.g:2140:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_3); 

            					newLeafNode(lv_name_1_0, grammarAccess.getGenericClassAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGenericClassRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_58); 

            			newLeafNode(otherlv_2, grammarAccess.getGenericClassAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:2160:3: ( (lv_attribute_3_0= ruleAttribute ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==67) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalMyDsl.g:2161:4: (lv_attribute_3_0= ruleAttribute )
            	    {
            	    // InternalMyDsl.g:2161:4: (lv_attribute_3_0= ruleAttribute )
            	    // InternalMyDsl.g:2162:5: lv_attribute_3_0= ruleAttribute
            	    {

            	    					newCompositeNode(grammarAccess.getGenericClassAccess().getAttributeAttributeParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_58);
            	    lv_attribute_3_0=ruleAttribute();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getGenericClassRule());
            	    					}
            	    					add(
            	    						current,
            	    						"attribute",
            	    						lv_attribute_3_0,
            	    						"org.xtext.example.mydsl.MyDsl.Attribute");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

            // InternalMyDsl.g:2179:3: ( (lv_methodClass_4_0= ruleMethodBack ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==69) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalMyDsl.g:2180:4: (lv_methodClass_4_0= ruleMethodBack )
            	    {
            	    // InternalMyDsl.g:2180:4: (lv_methodClass_4_0= ruleMethodBack )
            	    // InternalMyDsl.g:2181:5: lv_methodClass_4_0= ruleMethodBack
            	    {

            	    					newCompositeNode(grammarAccess.getGenericClassAccess().getMethodClassMethodBackParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_59);
            	    lv_methodClass_4_0=ruleMethodBack();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getGenericClassRule());
            	    					}
            	    					add(
            	    						current,
            	    						"methodClass",
            	    						lv_methodClass_4_0,
            	    						"org.xtext.example.mydsl.MyDsl.MethodBack");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

            // InternalMyDsl.g:2198:3: (otherlv_5= 'use :' ( (otherlv_6= RULE_ID ) ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==62) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalMyDsl.g:2199:4: otherlv_5= 'use :' ( (otherlv_6= RULE_ID ) )
            	    {
            	    otherlv_5=(Token)match(input,62,FOLLOW_11); 

            	    				newLeafNode(otherlv_5, grammarAccess.getGenericClassAccess().getUseKeyword_5_0());
            	    			
            	    // InternalMyDsl.g:2203:4: ( (otherlv_6= RULE_ID ) )
            	    // InternalMyDsl.g:2204:5: (otherlv_6= RULE_ID )
            	    {
            	    // InternalMyDsl.g:2204:5: (otherlv_6= RULE_ID )
            	    // InternalMyDsl.g:2205:6: otherlv_6= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getGenericClassRule());
            	    						}
            	    					
            	    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_60); 

            	    						newLeafNode(otherlv_6, grammarAccess.getGenericClassAccess().getAnnotationAnnotationCrossReference_5_1_0());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

            // InternalMyDsl.g:2217:3: (otherlv_7= 'extends :' ( (otherlv_8= RULE_ID ) ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==64) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalMyDsl.g:2218:4: otherlv_7= 'extends :' ( (otherlv_8= RULE_ID ) )
                    {
                    otherlv_7=(Token)match(input,64,FOLLOW_11); 

                    				newLeafNode(otherlv_7, grammarAccess.getGenericClassAccess().getExtendsKeyword_6_0());
                    			
                    // InternalMyDsl.g:2222:4: ( (otherlv_8= RULE_ID ) )
                    // InternalMyDsl.g:2223:5: (otherlv_8= RULE_ID )
                    {
                    // InternalMyDsl.g:2223:5: (otherlv_8= RULE_ID )
                    // InternalMyDsl.g:2224:6: otherlv_8= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getGenericClassRule());
                    						}
                    					
                    otherlv_8=(Token)match(input,RULE_ID,FOLLOW_61); 

                    						newLeafNode(otherlv_8, grammarAccess.getGenericClassAccess().getAbsAbstractClassCrossReference_6_1_0());
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMyDsl.g:2236:3: (otherlv_9= 'implements :' ( (otherlv_10= RULE_ID ) ) )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==65) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalMyDsl.g:2237:4: otherlv_9= 'implements :' ( (otherlv_10= RULE_ID ) )
            	    {
            	    otherlv_9=(Token)match(input,65,FOLLOW_11); 

            	    				newLeafNode(otherlv_9, grammarAccess.getGenericClassAccess().getImplementsKeyword_7_0());
            	    			
            	    // InternalMyDsl.g:2241:4: ( (otherlv_10= RULE_ID ) )
            	    // InternalMyDsl.g:2242:5: (otherlv_10= RULE_ID )
            	    {
            	    // InternalMyDsl.g:2242:5: (otherlv_10= RULE_ID )
            	    // InternalMyDsl.g:2243:6: otherlv_10= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getGenericClassRule());
            	    						}
            	    					
            	    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_61); 

            	    						newLeafNode(otherlv_10, grammarAccess.getGenericClassAccess().getImpEinterfaceCrossReference_7_1_0());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

            otherlv_11=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_11, grammarAccess.getGenericClassAccess().getRightCurlyBracketKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGenericClass"


    // $ANTLR start "entryRuleNativeClass"
    // InternalMyDsl.g:2263:1: entryRuleNativeClass returns [EObject current=null] : iv_ruleNativeClass= ruleNativeClass EOF ;
    public final EObject entryRuleNativeClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNativeClass = null;


        try {
            // InternalMyDsl.g:2263:52: (iv_ruleNativeClass= ruleNativeClass EOF )
            // InternalMyDsl.g:2264:2: iv_ruleNativeClass= ruleNativeClass EOF
            {
             newCompositeNode(grammarAccess.getNativeClassRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNativeClass=ruleNativeClass();

            state._fsp--;

             current =iv_ruleNativeClass; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNativeClass"


    // $ANTLR start "ruleNativeClass"
    // InternalMyDsl.g:2270:1: ruleNativeClass returns [EObject current=null] : (otherlv_0= 'nativeClass' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_attribute_3_0= ruleAttribute ) )* ( (lv_methodClass_4_0= ruleMethodBack ) )* otherlv_5= '}' ) ;
    public final EObject ruleNativeClass() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject lv_attribute_3_0 = null;

        EObject lv_methodClass_4_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:2276:2: ( (otherlv_0= 'nativeClass' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_attribute_3_0= ruleAttribute ) )* ( (lv_methodClass_4_0= ruleMethodBack ) )* otherlv_5= '}' ) )
            // InternalMyDsl.g:2277:2: (otherlv_0= 'nativeClass' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_attribute_3_0= ruleAttribute ) )* ( (lv_methodClass_4_0= ruleMethodBack ) )* otherlv_5= '}' )
            {
            // InternalMyDsl.g:2277:2: (otherlv_0= 'nativeClass' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_attribute_3_0= ruleAttribute ) )* ( (lv_methodClass_4_0= ruleMethodBack ) )* otherlv_5= '}' )
            // InternalMyDsl.g:2278:3: otherlv_0= 'nativeClass' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_attribute_3_0= ruleAttribute ) )* ( (lv_methodClass_4_0= ruleMethodBack ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,66,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getNativeClassAccess().getNativeClassKeyword_0());
            		
            // InternalMyDsl.g:2282:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMyDsl.g:2283:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMyDsl.g:2283:4: (lv_name_1_0= RULE_ID )
            // InternalMyDsl.g:2284:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_3); 

            					newLeafNode(lv_name_1_0, grammarAccess.getNativeClassAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getNativeClassRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_62); 

            			newLeafNode(otherlv_2, grammarAccess.getNativeClassAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:2304:3: ( (lv_attribute_3_0= ruleAttribute ) )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==67) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalMyDsl.g:2305:4: (lv_attribute_3_0= ruleAttribute )
            	    {
            	    // InternalMyDsl.g:2305:4: (lv_attribute_3_0= ruleAttribute )
            	    // InternalMyDsl.g:2306:5: lv_attribute_3_0= ruleAttribute
            	    {

            	    					newCompositeNode(grammarAccess.getNativeClassAccess().getAttributeAttributeParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_62);
            	    lv_attribute_3_0=ruleAttribute();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getNativeClassRule());
            	    					}
            	    					add(
            	    						current,
            	    						"attribute",
            	    						lv_attribute_3_0,
            	    						"org.xtext.example.mydsl.MyDsl.Attribute");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);

            // InternalMyDsl.g:2323:3: ( (lv_methodClass_4_0= ruleMethodBack ) )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==69) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalMyDsl.g:2324:4: (lv_methodClass_4_0= ruleMethodBack )
            	    {
            	    // InternalMyDsl.g:2324:4: (lv_methodClass_4_0= ruleMethodBack )
            	    // InternalMyDsl.g:2325:5: lv_methodClass_4_0= ruleMethodBack
            	    {

            	    					newCompositeNode(grammarAccess.getNativeClassAccess().getMethodClassMethodBackParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_63);
            	    lv_methodClass_4_0=ruleMethodBack();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getNativeClassRule());
            	    					}
            	    					add(
            	    						current,
            	    						"methodClass",
            	    						lv_methodClass_4_0,
            	    						"org.xtext.example.mydsl.MyDsl.MethodBack");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);

            otherlv_5=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getNativeClassAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNativeClass"


    // $ANTLR start "entryRuleEclass"
    // InternalMyDsl.g:2350:1: entryRuleEclass returns [EObject current=null] : iv_ruleEclass= ruleEclass EOF ;
    public final EObject entryRuleEclass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEclass = null;


        try {
            // InternalMyDsl.g:2350:47: (iv_ruleEclass= ruleEclass EOF )
            // InternalMyDsl.g:2351:2: iv_ruleEclass= ruleEclass EOF
            {
             newCompositeNode(grammarAccess.getEclassRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEclass=ruleEclass();

            state._fsp--;

             current =iv_ruleEclass; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEclass"


    // $ANTLR start "ruleEclass"
    // InternalMyDsl.g:2357:1: ruleEclass returns [EObject current=null] : (this_AbstractClass_0= ruleAbstractClass | this_GenericClass_1= ruleGenericClass | this_NativeClass_2= ruleNativeClass | this_Annotation_3= ruleAnnotation ) ;
    public final EObject ruleEclass() throws RecognitionException {
        EObject current = null;

        EObject this_AbstractClass_0 = null;

        EObject this_GenericClass_1 = null;

        EObject this_NativeClass_2 = null;

        EObject this_Annotation_3 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:2363:2: ( (this_AbstractClass_0= ruleAbstractClass | this_GenericClass_1= ruleGenericClass | this_NativeClass_2= ruleNativeClass | this_Annotation_3= ruleAnnotation ) )
            // InternalMyDsl.g:2364:2: (this_AbstractClass_0= ruleAbstractClass | this_GenericClass_1= ruleGenericClass | this_NativeClass_2= ruleNativeClass | this_Annotation_3= ruleAnnotation )
            {
            // InternalMyDsl.g:2364:2: (this_AbstractClass_0= ruleAbstractClass | this_GenericClass_1= ruleGenericClass | this_NativeClass_2= ruleNativeClass | this_Annotation_3= ruleAnnotation )
            int alt40=4;
            switch ( input.LA(1) ) {
            case 61:
                {
                alt40=1;
                }
                break;
            case 63:
                {
                alt40=2;
                }
                break;
            case 66:
                {
                alt40=3;
                }
                break;
            case 75:
                {
                alt40=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }

            switch (alt40) {
                case 1 :
                    // InternalMyDsl.g:2365:3: this_AbstractClass_0= ruleAbstractClass
                    {

                    			newCompositeNode(grammarAccess.getEclassAccess().getAbstractClassParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_AbstractClass_0=ruleAbstractClass();

                    state._fsp--;


                    			current = this_AbstractClass_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:2374:3: this_GenericClass_1= ruleGenericClass
                    {

                    			newCompositeNode(grammarAccess.getEclassAccess().getGenericClassParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_GenericClass_1=ruleGenericClass();

                    state._fsp--;


                    			current = this_GenericClass_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:2383:3: this_NativeClass_2= ruleNativeClass
                    {

                    			newCompositeNode(grammarAccess.getEclassAccess().getNativeClassParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_NativeClass_2=ruleNativeClass();

                    state._fsp--;


                    			current = this_NativeClass_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:2392:3: this_Annotation_3= ruleAnnotation
                    {

                    			newCompositeNode(grammarAccess.getEclassAccess().getAnnotationParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_Annotation_3=ruleAnnotation();

                    state._fsp--;


                    			current = this_Annotation_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEclass"


    // $ANTLR start "entryRuleAttribute"
    // InternalMyDsl.g:2404:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // InternalMyDsl.g:2404:50: (iv_ruleAttribute= ruleAttribute EOF )
            // InternalMyDsl.g:2405:2: iv_ruleAttribute= ruleAttribute EOF
            {
             newCompositeNode(grammarAccess.getAttributeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAttribute=ruleAttribute();

            state._fsp--;

             current =iv_ruleAttribute; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttribute"


    // $ANTLR start "ruleAttribute"
    // InternalMyDsl.g:2411:1: ruleAttribute returns [EObject current=null] : (otherlv_0= 'attribute' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalMyDsl.g:2417:2: ( (otherlv_0= 'attribute' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) ) )
            // InternalMyDsl.g:2418:2: (otherlv_0= 'attribute' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) )
            {
            // InternalMyDsl.g:2418:2: (otherlv_0= 'attribute' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) )
            // InternalMyDsl.g:2419:3: otherlv_0= 'attribute' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (otherlv_3= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,67,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getAttributeAccess().getAttributeKeyword_0());
            		
            // InternalMyDsl.g:2423:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMyDsl.g:2424:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMyDsl.g:2424:4: (lv_name_1_0= RULE_ID )
            // InternalMyDsl.g:2425:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_21); 

            					newLeafNode(lv_name_1_0, grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAttributeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,23,FOLLOW_11); 

            			newLeafNode(otherlv_2, grammarAccess.getAttributeAccess().getColonKeyword_2());
            		
            // InternalMyDsl.g:2445:3: ( (otherlv_3= RULE_ID ) )
            // InternalMyDsl.g:2446:4: (otherlv_3= RULE_ID )
            {
            // InternalMyDsl.g:2446:4: (otherlv_3= RULE_ID )
            // InternalMyDsl.g:2447:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAttributeRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(otherlv_3, grammarAccess.getAttributeAccess().getTypeEclassCrossReference_3_0());
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "entryRuleEpackage"
    // InternalMyDsl.g:2462:1: entryRuleEpackage returns [EObject current=null] : iv_ruleEpackage= ruleEpackage EOF ;
    public final EObject entryRuleEpackage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEpackage = null;


        try {
            // InternalMyDsl.g:2462:49: (iv_ruleEpackage= ruleEpackage EOF )
            // InternalMyDsl.g:2463:2: iv_ruleEpackage= ruleEpackage EOF
            {
             newCompositeNode(grammarAccess.getEpackageRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEpackage=ruleEpackage();

            state._fsp--;

             current =iv_ruleEpackage; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEpackage"


    // $ANTLR start "ruleEpackage"
    // InternalMyDsl.g:2469:1: ruleEpackage returns [EObject current=null] : (otherlv_0= 'epackage' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_eclass_3_0= ruleEclass ) )* otherlv_4= '}' ) ;
    public final EObject ruleEpackage() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_eclass_3_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:2475:2: ( (otherlv_0= 'epackage' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_eclass_3_0= ruleEclass ) )* otherlv_4= '}' ) )
            // InternalMyDsl.g:2476:2: (otherlv_0= 'epackage' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_eclass_3_0= ruleEclass ) )* otherlv_4= '}' )
            {
            // InternalMyDsl.g:2476:2: (otherlv_0= 'epackage' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_eclass_3_0= ruleEclass ) )* otherlv_4= '}' )
            // InternalMyDsl.g:2477:3: otherlv_0= 'epackage' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_eclass_3_0= ruleEclass ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,68,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getEpackageAccess().getEpackageKeyword_0());
            		
            // InternalMyDsl.g:2481:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMyDsl.g:2482:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMyDsl.g:2482:4: (lv_name_1_0= RULE_ID )
            // InternalMyDsl.g:2483:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_3); 

            					newLeafNode(lv_name_1_0, grammarAccess.getEpackageAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEpackageRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_64); 

            			newLeafNode(otherlv_2, grammarAccess.getEpackageAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:2503:3: ( (lv_eclass_3_0= ruleEclass ) )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==61||LA41_0==63||LA41_0==66||LA41_0==75) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalMyDsl.g:2504:4: (lv_eclass_3_0= ruleEclass )
            	    {
            	    // InternalMyDsl.g:2504:4: (lv_eclass_3_0= ruleEclass )
            	    // InternalMyDsl.g:2505:5: lv_eclass_3_0= ruleEclass
            	    {

            	    					newCompositeNode(grammarAccess.getEpackageAccess().getEclassEclassParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_64);
            	    lv_eclass_3_0=ruleEclass();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getEpackageRule());
            	    					}
            	    					add(
            	    						current,
            	    						"eclass",
            	    						lv_eclass_3_0,
            	    						"org.xtext.example.mydsl.MyDsl.Eclass");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);

            otherlv_4=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getEpackageAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEpackage"


    // $ANTLR start "entryRuleMethodBack"
    // InternalMyDsl.g:2530:1: entryRuleMethodBack returns [EObject current=null] : iv_ruleMethodBack= ruleMethodBack EOF ;
    public final EObject entryRuleMethodBack() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethodBack = null;


        try {
            // InternalMyDsl.g:2530:51: (iv_ruleMethodBack= ruleMethodBack EOF )
            // InternalMyDsl.g:2531:2: iv_ruleMethodBack= ruleMethodBack EOF
            {
             newCompositeNode(grammarAccess.getMethodBackRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMethodBack=ruleMethodBack();

            state._fsp--;

             current =iv_ruleMethodBack; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMethodBack"


    // $ANTLR start "ruleMethodBack"
    // InternalMyDsl.g:2537:1: ruleMethodBack returns [EObject current=null] : (otherlv_0= 'methodBack' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'argument' ( (otherlv_4= RULE_ID ) ) )* (otherlv_5= 'return' ( (otherlv_6= RULE_ID ) ) )? otherlv_7= '}' ) ;
    public final EObject ruleMethodBack() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;


        	enterRule();

        try {
            // InternalMyDsl.g:2543:2: ( (otherlv_0= 'methodBack' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'argument' ( (otherlv_4= RULE_ID ) ) )* (otherlv_5= 'return' ( (otherlv_6= RULE_ID ) ) )? otherlv_7= '}' ) )
            // InternalMyDsl.g:2544:2: (otherlv_0= 'methodBack' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'argument' ( (otherlv_4= RULE_ID ) ) )* (otherlv_5= 'return' ( (otherlv_6= RULE_ID ) ) )? otherlv_7= '}' )
            {
            // InternalMyDsl.g:2544:2: (otherlv_0= 'methodBack' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'argument' ( (otherlv_4= RULE_ID ) ) )* (otherlv_5= 'return' ( (otherlv_6= RULE_ID ) ) )? otherlv_7= '}' )
            // InternalMyDsl.g:2545:3: otherlv_0= 'methodBack' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'argument' ( (otherlv_4= RULE_ID ) ) )* (otherlv_5= 'return' ( (otherlv_6= RULE_ID ) ) )? otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,69,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getMethodBackAccess().getMethodBackKeyword_0());
            		
            // InternalMyDsl.g:2549:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMyDsl.g:2550:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMyDsl.g:2550:4: (lv_name_1_0= RULE_ID )
            // InternalMyDsl.g:2551:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_3); 

            					newLeafNode(lv_name_1_0, grammarAccess.getMethodBackAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMethodBackRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_65); 

            			newLeafNode(otherlv_2, grammarAccess.getMethodBackAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:2571:3: (otherlv_3= 'argument' ( (otherlv_4= RULE_ID ) ) )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==70) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalMyDsl.g:2572:4: otherlv_3= 'argument' ( (otherlv_4= RULE_ID ) )
            	    {
            	    otherlv_3=(Token)match(input,70,FOLLOW_11); 

            	    				newLeafNode(otherlv_3, grammarAccess.getMethodBackAccess().getArgumentKeyword_3_0());
            	    			
            	    // InternalMyDsl.g:2576:4: ( (otherlv_4= RULE_ID ) )
            	    // InternalMyDsl.g:2577:5: (otherlv_4= RULE_ID )
            	    {
            	    // InternalMyDsl.g:2577:5: (otherlv_4= RULE_ID )
            	    // InternalMyDsl.g:2578:6: otherlv_4= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getMethodBackRule());
            	    						}
            	    					
            	    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_65); 

            	    						newLeafNode(otherlv_4, grammarAccess.getMethodBackAccess().getArgEclassCrossReference_3_1_0());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);

            // InternalMyDsl.g:2590:3: (otherlv_5= 'return' ( (otherlv_6= RULE_ID ) ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==71) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalMyDsl.g:2591:4: otherlv_5= 'return' ( (otherlv_6= RULE_ID ) )
                    {
                    otherlv_5=(Token)match(input,71,FOLLOW_11); 

                    				newLeafNode(otherlv_5, grammarAccess.getMethodBackAccess().getReturnKeyword_4_0());
                    			
                    // InternalMyDsl.g:2595:4: ( (otherlv_6= RULE_ID ) )
                    // InternalMyDsl.g:2596:5: (otherlv_6= RULE_ID )
                    {
                    // InternalMyDsl.g:2596:5: (otherlv_6= RULE_ID )
                    // InternalMyDsl.g:2597:6: otherlv_6= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMethodBackRule());
                    						}
                    					
                    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_7); 

                    						newLeafNode(otherlv_6, grammarAccess.getMethodBackAccess().getTypeEclassCrossReference_4_1_0());
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getMethodBackAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMethodBack"


    // $ANTLR start "entryRuleAbstractMethod"
    // InternalMyDsl.g:2617:1: entryRuleAbstractMethod returns [EObject current=null] : iv_ruleAbstractMethod= ruleAbstractMethod EOF ;
    public final EObject entryRuleAbstractMethod() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractMethod = null;


        try {
            // InternalMyDsl.g:2617:55: (iv_ruleAbstractMethod= ruleAbstractMethod EOF )
            // InternalMyDsl.g:2618:2: iv_ruleAbstractMethod= ruleAbstractMethod EOF
            {
             newCompositeNode(grammarAccess.getAbstractMethodRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAbstractMethod=ruleAbstractMethod();

            state._fsp--;

             current =iv_ruleAbstractMethod; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAbstractMethod"


    // $ANTLR start "ruleAbstractMethod"
    // InternalMyDsl.g:2624:1: ruleAbstractMethod returns [EObject current=null] : (otherlv_0= 'abstractMethodBack' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'argument' ( (otherlv_4= RULE_ID ) ) )* (otherlv_5= 'return' ( (otherlv_6= RULE_ID ) ) )? otherlv_7= '}' ) ;
    public final EObject ruleAbstractMethod() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;


        	enterRule();

        try {
            // InternalMyDsl.g:2630:2: ( (otherlv_0= 'abstractMethodBack' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'argument' ( (otherlv_4= RULE_ID ) ) )* (otherlv_5= 'return' ( (otherlv_6= RULE_ID ) ) )? otherlv_7= '}' ) )
            // InternalMyDsl.g:2631:2: (otherlv_0= 'abstractMethodBack' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'argument' ( (otherlv_4= RULE_ID ) ) )* (otherlv_5= 'return' ( (otherlv_6= RULE_ID ) ) )? otherlv_7= '}' )
            {
            // InternalMyDsl.g:2631:2: (otherlv_0= 'abstractMethodBack' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'argument' ( (otherlv_4= RULE_ID ) ) )* (otherlv_5= 'return' ( (otherlv_6= RULE_ID ) ) )? otherlv_7= '}' )
            // InternalMyDsl.g:2632:3: otherlv_0= 'abstractMethodBack' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'argument' ( (otherlv_4= RULE_ID ) ) )* (otherlv_5= 'return' ( (otherlv_6= RULE_ID ) ) )? otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,72,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getAbstractMethodAccess().getAbstractMethodBackKeyword_0());
            		
            // InternalMyDsl.g:2636:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMyDsl.g:2637:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMyDsl.g:2637:4: (lv_name_1_0= RULE_ID )
            // InternalMyDsl.g:2638:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_3); 

            					newLeafNode(lv_name_1_0, grammarAccess.getAbstractMethodAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAbstractMethodRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_65); 

            			newLeafNode(otherlv_2, grammarAccess.getAbstractMethodAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:2658:3: (otherlv_3= 'argument' ( (otherlv_4= RULE_ID ) ) )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==70) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalMyDsl.g:2659:4: otherlv_3= 'argument' ( (otherlv_4= RULE_ID ) )
            	    {
            	    otherlv_3=(Token)match(input,70,FOLLOW_11); 

            	    				newLeafNode(otherlv_3, grammarAccess.getAbstractMethodAccess().getArgumentKeyword_3_0());
            	    			
            	    // InternalMyDsl.g:2663:4: ( (otherlv_4= RULE_ID ) )
            	    // InternalMyDsl.g:2664:5: (otherlv_4= RULE_ID )
            	    {
            	    // InternalMyDsl.g:2664:5: (otherlv_4= RULE_ID )
            	    // InternalMyDsl.g:2665:6: otherlv_4= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getAbstractMethodRule());
            	    						}
            	    					
            	    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_65); 

            	    						newLeafNode(otherlv_4, grammarAccess.getAbstractMethodAccess().getArgEclassCrossReference_3_1_0());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);

            // InternalMyDsl.g:2677:3: (otherlv_5= 'return' ( (otherlv_6= RULE_ID ) ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==71) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalMyDsl.g:2678:4: otherlv_5= 'return' ( (otherlv_6= RULE_ID ) )
                    {
                    otherlv_5=(Token)match(input,71,FOLLOW_11); 

                    				newLeafNode(otherlv_5, grammarAccess.getAbstractMethodAccess().getReturnKeyword_4_0());
                    			
                    // InternalMyDsl.g:2682:4: ( (otherlv_6= RULE_ID ) )
                    // InternalMyDsl.g:2683:5: (otherlv_6= RULE_ID )
                    {
                    // InternalMyDsl.g:2683:5: (otherlv_6= RULE_ID )
                    // InternalMyDsl.g:2684:6: otherlv_6= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAbstractMethodRule());
                    						}
                    					
                    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_7); 

                    						newLeafNode(otherlv_6, grammarAccess.getAbstractMethodAccess().getTypeEclassCrossReference_4_1_0());
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getAbstractMethodAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAbstractMethod"


    // $ANTLR start "entryRuleDescriptor"
    // InternalMyDsl.g:2704:1: entryRuleDescriptor returns [EObject current=null] : iv_ruleDescriptor= ruleDescriptor EOF ;
    public final EObject entryRuleDescriptor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescriptor = null;


        try {
            // InternalMyDsl.g:2704:51: (iv_ruleDescriptor= ruleDescriptor EOF )
            // InternalMyDsl.g:2705:2: iv_ruleDescriptor= ruleDescriptor EOF
            {
             newCompositeNode(grammarAccess.getDescriptorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDescriptor=ruleDescriptor();

            state._fsp--;

             current =iv_ruleDescriptor; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDescriptor"


    // $ANTLR start "ruleDescriptor"
    // InternalMyDsl.g:2711:1: ruleDescriptor returns [EObject current=null] : (otherlv_0= 'descriptor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'path' ( (lv_path_4_0= RULE_STRING ) ) otherlv_5= '}' ) ;
    public final EObject ruleDescriptor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_path_4_0=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalMyDsl.g:2717:2: ( (otherlv_0= 'descriptor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'path' ( (lv_path_4_0= RULE_STRING ) ) otherlv_5= '}' ) )
            // InternalMyDsl.g:2718:2: (otherlv_0= 'descriptor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'path' ( (lv_path_4_0= RULE_STRING ) ) otherlv_5= '}' )
            {
            // InternalMyDsl.g:2718:2: (otherlv_0= 'descriptor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'path' ( (lv_path_4_0= RULE_STRING ) ) otherlv_5= '}' )
            // InternalMyDsl.g:2719:3: otherlv_0= 'descriptor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'path' ( (lv_path_4_0= RULE_STRING ) ) otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,73,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getDescriptorAccess().getDescriptorKeyword_0());
            		
            // InternalMyDsl.g:2723:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMyDsl.g:2724:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMyDsl.g:2724:4: (lv_name_1_0= RULE_ID )
            // InternalMyDsl.g:2725:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_3); 

            					newLeafNode(lv_name_1_0, grammarAccess.getDescriptorAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDescriptorRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_66); 

            			newLeafNode(otherlv_2, grammarAccess.getDescriptorAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,74,FOLLOW_67); 

            			newLeafNode(otherlv_3, grammarAccess.getDescriptorAccess().getPathKeyword_3());
            		
            // InternalMyDsl.g:2749:3: ( (lv_path_4_0= RULE_STRING ) )
            // InternalMyDsl.g:2750:4: (lv_path_4_0= RULE_STRING )
            {
            // InternalMyDsl.g:2750:4: (lv_path_4_0= RULE_STRING )
            // InternalMyDsl.g:2751:5: lv_path_4_0= RULE_STRING
            {
            lv_path_4_0=(Token)match(input,RULE_STRING,FOLLOW_7); 

            					newLeafNode(lv_path_4_0, grammarAccess.getDescriptorAccess().getPathSTRINGTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDescriptorRule());
            					}
            					setWithLastConsumed(
            						current,
            						"path",
            						lv_path_4_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_5=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getDescriptorAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDescriptor"


    // $ANTLR start "entryRuleAnnotation"
    // InternalMyDsl.g:2775:1: entryRuleAnnotation returns [EObject current=null] : iv_ruleAnnotation= ruleAnnotation EOF ;
    public final EObject entryRuleAnnotation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotation = null;


        try {
            // InternalMyDsl.g:2775:51: (iv_ruleAnnotation= ruleAnnotation EOF )
            // InternalMyDsl.g:2776:2: iv_ruleAnnotation= ruleAnnotation EOF
            {
             newCompositeNode(grammarAccess.getAnnotationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAnnotation=ruleAnnotation();

            state._fsp--;

             current =iv_ruleAnnotation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAnnotation"


    // $ANTLR start "ruleAnnotation"
    // InternalMyDsl.g:2782:1: ruleAnnotation returns [EObject current=null] : (otherlv_0= 'annotation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'propertie' ( (lv_propertie_4_0= RULE_STRING ) ) )* otherlv_5= '}' ) ;
    public final EObject ruleAnnotation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_propertie_4_0=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalMyDsl.g:2788:2: ( (otherlv_0= 'annotation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'propertie' ( (lv_propertie_4_0= RULE_STRING ) ) )* otherlv_5= '}' ) )
            // InternalMyDsl.g:2789:2: (otherlv_0= 'annotation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'propertie' ( (lv_propertie_4_0= RULE_STRING ) ) )* otherlv_5= '}' )
            {
            // InternalMyDsl.g:2789:2: (otherlv_0= 'annotation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'propertie' ( (lv_propertie_4_0= RULE_STRING ) ) )* otherlv_5= '}' )
            // InternalMyDsl.g:2790:3: otherlv_0= 'annotation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'propertie' ( (lv_propertie_4_0= RULE_STRING ) ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,75,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getAnnotationAccess().getAnnotationKeyword_0());
            		
            // InternalMyDsl.g:2794:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMyDsl.g:2795:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMyDsl.g:2795:4: (lv_name_1_0= RULE_ID )
            // InternalMyDsl.g:2796:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_3); 

            					newLeafNode(lv_name_1_0, grammarAccess.getAnnotationAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAnnotationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_68); 

            			newLeafNode(otherlv_2, grammarAccess.getAnnotationAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:2816:3: (otherlv_3= 'propertie' ( (lv_propertie_4_0= RULE_STRING ) ) )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==76) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalMyDsl.g:2817:4: otherlv_3= 'propertie' ( (lv_propertie_4_0= RULE_STRING ) )
            	    {
            	    otherlv_3=(Token)match(input,76,FOLLOW_67); 

            	    				newLeafNode(otherlv_3, grammarAccess.getAnnotationAccess().getPropertieKeyword_3_0());
            	    			
            	    // InternalMyDsl.g:2821:4: ( (lv_propertie_4_0= RULE_STRING ) )
            	    // InternalMyDsl.g:2822:5: (lv_propertie_4_0= RULE_STRING )
            	    {
            	    // InternalMyDsl.g:2822:5: (lv_propertie_4_0= RULE_STRING )
            	    // InternalMyDsl.g:2823:6: lv_propertie_4_0= RULE_STRING
            	    {
            	    lv_propertie_4_0=(Token)match(input,RULE_STRING,FOLLOW_68); 

            	    						newLeafNode(lv_propertie_4_0, grammarAccess.getAnnotationAccess().getPropertieSTRINGTerminalRuleCall_3_1_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getAnnotationRule());
            	    						}
            	    						setWithLastConsumed(
            	    							current,
            	    							"propertie",
            	    							lv_propertie_4_0,
            	    							"org.eclipse.xtext.common.Terminals.STRING");
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);

            otherlv_5=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getAnnotationAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAnnotation"


    // $ANTLR start "entryRuleLibrary"
    // InternalMyDsl.g:2848:1: entryRuleLibrary returns [EObject current=null] : iv_ruleLibrary= ruleLibrary EOF ;
    public final EObject entryRuleLibrary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLibrary = null;


        try {
            // InternalMyDsl.g:2848:48: (iv_ruleLibrary= ruleLibrary EOF )
            // InternalMyDsl.g:2849:2: iv_ruleLibrary= ruleLibrary EOF
            {
             newCompositeNode(grammarAccess.getLibraryRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLibrary=ruleLibrary();

            state._fsp--;

             current =iv_ruleLibrary; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLibrary"


    // $ANTLR start "ruleLibrary"
    // InternalMyDsl.g:2855:1: ruleLibrary returns [EObject current=null] : (otherlv_0= 'library' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'isNative' ( (lv_isNative_4_0= ruleBoolean ) ) ( (lv_annotation_5_0= ruleAnnotation ) )* otherlv_6= '}' ) ;
    public final EObject ruleLibrary() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_isNative_4_0 = null;

        EObject lv_annotation_5_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:2861:2: ( (otherlv_0= 'library' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'isNative' ( (lv_isNative_4_0= ruleBoolean ) ) ( (lv_annotation_5_0= ruleAnnotation ) )* otherlv_6= '}' ) )
            // InternalMyDsl.g:2862:2: (otherlv_0= 'library' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'isNative' ( (lv_isNative_4_0= ruleBoolean ) ) ( (lv_annotation_5_0= ruleAnnotation ) )* otherlv_6= '}' )
            {
            // InternalMyDsl.g:2862:2: (otherlv_0= 'library' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'isNative' ( (lv_isNative_4_0= ruleBoolean ) ) ( (lv_annotation_5_0= ruleAnnotation ) )* otherlv_6= '}' )
            // InternalMyDsl.g:2863:3: otherlv_0= 'library' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'isNative' ( (lv_isNative_4_0= ruleBoolean ) ) ( (lv_annotation_5_0= ruleAnnotation ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,77,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getLibraryAccess().getLibraryKeyword_0());
            		
            // InternalMyDsl.g:2867:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMyDsl.g:2868:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMyDsl.g:2868:4: (lv_name_1_0= RULE_ID )
            // InternalMyDsl.g:2869:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_3); 

            					newLeafNode(lv_name_1_0, grammarAccess.getLibraryAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLibraryRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_69); 

            			newLeafNode(otherlv_2, grammarAccess.getLibraryAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,78,FOLLOW_70); 

            			newLeafNode(otherlv_3, grammarAccess.getLibraryAccess().getIsNativeKeyword_3());
            		
            // InternalMyDsl.g:2893:3: ( (lv_isNative_4_0= ruleBoolean ) )
            // InternalMyDsl.g:2894:4: (lv_isNative_4_0= ruleBoolean )
            {
            // InternalMyDsl.g:2894:4: (lv_isNative_4_0= ruleBoolean )
            // InternalMyDsl.g:2895:5: lv_isNative_4_0= ruleBoolean
            {

            					newCompositeNode(grammarAccess.getLibraryAccess().getIsNativeBooleanParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_64);
            lv_isNative_4_0=ruleBoolean();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLibraryRule());
            					}
            					set(
            						current,
            						"isNative",
            						lv_isNative_4_0,
            						"org.xtext.example.mydsl.MyDsl.Boolean");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:2912:3: ( (lv_annotation_5_0= ruleAnnotation ) )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==75) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // InternalMyDsl.g:2913:4: (lv_annotation_5_0= ruleAnnotation )
            	    {
            	    // InternalMyDsl.g:2913:4: (lv_annotation_5_0= ruleAnnotation )
            	    // InternalMyDsl.g:2914:5: lv_annotation_5_0= ruleAnnotation
            	    {

            	    					newCompositeNode(grammarAccess.getLibraryAccess().getAnnotationAnnotationParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_64);
            	    lv_annotation_5_0=ruleAnnotation();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getLibraryRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotation",
            	    						lv_annotation_5_0,
            	    						"org.xtext.example.mydsl.MyDsl.Annotation");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);

            otherlv_6=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getLibraryAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLibrary"


    // $ANTLR start "entryRuleBoolean"
    // InternalMyDsl.g:2939:1: entryRuleBoolean returns [String current=null] : iv_ruleBoolean= ruleBoolean EOF ;
    public final String entryRuleBoolean() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBoolean = null;


        try {
            // InternalMyDsl.g:2939:47: (iv_ruleBoolean= ruleBoolean EOF )
            // InternalMyDsl.g:2940:2: iv_ruleBoolean= ruleBoolean EOF
            {
             newCompositeNode(grammarAccess.getBooleanRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBoolean=ruleBoolean();

            state._fsp--;

             current =iv_ruleBoolean.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBoolean"


    // $ANTLR start "ruleBoolean"
    // InternalMyDsl.g:2946:1: ruleBoolean returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'true' | kw= 'false' ) ;
    public final AntlrDatatypeRuleToken ruleBoolean() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalMyDsl.g:2952:2: ( (kw= 'true' | kw= 'false' ) )
            // InternalMyDsl.g:2953:2: (kw= 'true' | kw= 'false' )
            {
            // InternalMyDsl.g:2953:2: (kw= 'true' | kw= 'false' )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==79) ) {
                alt48=1;
            }
            else if ( (LA48_0==80) ) {
                alt48=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }
            switch (alt48) {
                case 1 :
                    // InternalMyDsl.g:2954:3: kw= 'true'
                    {
                    kw=(Token)match(input,79,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getBooleanAccess().getTrueKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:2960:3: kw= 'false'
                    {
                    kw=(Token)match(input,80,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getBooleanAccess().getFalseKeyword_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBoolean"


    // $ANTLR start "entryRuleAbstractFrontElement"
    // InternalMyDsl.g:2969:1: entryRuleAbstractFrontElement returns [EObject current=null] : iv_ruleAbstractFrontElement= ruleAbstractFrontElement EOF ;
    public final EObject entryRuleAbstractFrontElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractFrontElement = null;


        try {
            // InternalMyDsl.g:2969:61: (iv_ruleAbstractFrontElement= ruleAbstractFrontElement EOF )
            // InternalMyDsl.g:2970:2: iv_ruleAbstractFrontElement= ruleAbstractFrontElement EOF
            {
             newCompositeNode(grammarAccess.getAbstractFrontElementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAbstractFrontElement=ruleAbstractFrontElement();

            state._fsp--;

             current =iv_ruleAbstractFrontElement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAbstractFrontElement"


    // $ANTLR start "ruleAbstractFrontElement"
    // InternalMyDsl.g:2976:1: ruleAbstractFrontElement returns [EObject current=null] : (this_ReactApp_0= ruleReactApp | this_Functionality_1= ruleFunctionality | this_Directory_2= ruleDirectory | this_JsModule_3= ruleJsModule | this_Type_4= ruleType | this_RouterComponent_5= ruleRouterComponent | this_Container_6= ruleContainer | this_Visualizer_7= ruleVisualizer | this_ServiceFront_8= ruleServiceFront | this_File_9= ruleFile | this_State_10= ruleState | this_Action_11= ruleAction | this_ActionCreator_12= ruleActionCreator | this_ActionDispatcher_13= ruleActionDispatcher | this_Reducer_14= ruleReducer | this_AxiosRequest_15= ruleAxiosRequest ) ;
    public final EObject ruleAbstractFrontElement() throws RecognitionException {
        EObject current = null;

        EObject this_ReactApp_0 = null;

        EObject this_Functionality_1 = null;

        EObject this_Directory_2 = null;

        EObject this_JsModule_3 = null;

        EObject this_Type_4 = null;

        EObject this_RouterComponent_5 = null;

        EObject this_Container_6 = null;

        EObject this_Visualizer_7 = null;

        EObject this_ServiceFront_8 = null;

        EObject this_File_9 = null;

        EObject this_State_10 = null;

        EObject this_Action_11 = null;

        EObject this_ActionCreator_12 = null;

        EObject this_ActionDispatcher_13 = null;

        EObject this_Reducer_14 = null;

        EObject this_AxiosRequest_15 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:2982:2: ( (this_ReactApp_0= ruleReactApp | this_Functionality_1= ruleFunctionality | this_Directory_2= ruleDirectory | this_JsModule_3= ruleJsModule | this_Type_4= ruleType | this_RouterComponent_5= ruleRouterComponent | this_Container_6= ruleContainer | this_Visualizer_7= ruleVisualizer | this_ServiceFront_8= ruleServiceFront | this_File_9= ruleFile | this_State_10= ruleState | this_Action_11= ruleAction | this_ActionCreator_12= ruleActionCreator | this_ActionDispatcher_13= ruleActionDispatcher | this_Reducer_14= ruleReducer | this_AxiosRequest_15= ruleAxiosRequest ) )
            // InternalMyDsl.g:2983:2: (this_ReactApp_0= ruleReactApp | this_Functionality_1= ruleFunctionality | this_Directory_2= ruleDirectory | this_JsModule_3= ruleJsModule | this_Type_4= ruleType | this_RouterComponent_5= ruleRouterComponent | this_Container_6= ruleContainer | this_Visualizer_7= ruleVisualizer | this_ServiceFront_8= ruleServiceFront | this_File_9= ruleFile | this_State_10= ruleState | this_Action_11= ruleAction | this_ActionCreator_12= ruleActionCreator | this_ActionDispatcher_13= ruleActionDispatcher | this_Reducer_14= ruleReducer | this_AxiosRequest_15= ruleAxiosRequest )
            {
            // InternalMyDsl.g:2983:2: (this_ReactApp_0= ruleReactApp | this_Functionality_1= ruleFunctionality | this_Directory_2= ruleDirectory | this_JsModule_3= ruleJsModule | this_Type_4= ruleType | this_RouterComponent_5= ruleRouterComponent | this_Container_6= ruleContainer | this_Visualizer_7= ruleVisualizer | this_ServiceFront_8= ruleServiceFront | this_File_9= ruleFile | this_State_10= ruleState | this_Action_11= ruleAction | this_ActionCreator_12= ruleActionCreator | this_ActionDispatcher_13= ruleActionDispatcher | this_Reducer_14= ruleReducer | this_AxiosRequest_15= ruleAxiosRequest )
            int alt49=16;
            switch ( input.LA(1) ) {
            case 81:
                {
                alt49=1;
                }
                break;
            case 85:
                {
                alt49=2;
                }
                break;
            case 101:
                {
                alt49=3;
                }
                break;
            case 15:
                {
                alt49=4;
                }
                break;
            case 24:
                {
                alt49=5;
                }
                break;
            case 92:
                {
                alt49=6;
                }
                break;
            case 95:
                {
                alt49=7;
                }
                break;
            case 98:
                {
                alt49=8;
                }
                break;
            case 99:
                {
                alt49=9;
                }
                break;
            case 105:
            case 106:
            case 107:
            case 108:
                {
                alt49=10;
                }
                break;
            case 109:
                {
                alt49=11;
                }
                break;
            case 112:
                {
                alt49=12;
                }
                break;
            case 115:
                {
                alt49=13;
                }
                break;
            case 116:
                {
                alt49=14;
                }
                break;
            case 117:
                {
                alt49=15;
                }
                break;
            case 129:
                {
                alt49=16;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }

            switch (alt49) {
                case 1 :
                    // InternalMyDsl.g:2984:3: this_ReactApp_0= ruleReactApp
                    {

                    			newCompositeNode(grammarAccess.getAbstractFrontElementAccess().getReactAppParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_ReactApp_0=ruleReactApp();

                    state._fsp--;


                    			current = this_ReactApp_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:2993:3: this_Functionality_1= ruleFunctionality
                    {

                    			newCompositeNode(grammarAccess.getAbstractFrontElementAccess().getFunctionalityParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Functionality_1=ruleFunctionality();

                    state._fsp--;


                    			current = this_Functionality_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:3002:3: this_Directory_2= ruleDirectory
                    {

                    			newCompositeNode(grammarAccess.getAbstractFrontElementAccess().getDirectoryParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Directory_2=ruleDirectory();

                    state._fsp--;


                    			current = this_Directory_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:3011:3: this_JsModule_3= ruleJsModule
                    {

                    			newCompositeNode(grammarAccess.getAbstractFrontElementAccess().getJsModuleParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_JsModule_3=ruleJsModule();

                    state._fsp--;


                    			current = this_JsModule_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalMyDsl.g:3020:3: this_Type_4= ruleType
                    {

                    			newCompositeNode(grammarAccess.getAbstractFrontElementAccess().getTypeParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_Type_4=ruleType();

                    state._fsp--;


                    			current = this_Type_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalMyDsl.g:3029:3: this_RouterComponent_5= ruleRouterComponent
                    {

                    			newCompositeNode(grammarAccess.getAbstractFrontElementAccess().getRouterComponentParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_RouterComponent_5=ruleRouterComponent();

                    state._fsp--;


                    			current = this_RouterComponent_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalMyDsl.g:3038:3: this_Container_6= ruleContainer
                    {

                    			newCompositeNode(grammarAccess.getAbstractFrontElementAccess().getContainerParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_Container_6=ruleContainer();

                    state._fsp--;


                    			current = this_Container_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 8 :
                    // InternalMyDsl.g:3047:3: this_Visualizer_7= ruleVisualizer
                    {

                    			newCompositeNode(grammarAccess.getAbstractFrontElementAccess().getVisualizerParserRuleCall_7());
                    		
                    pushFollow(FOLLOW_2);
                    this_Visualizer_7=ruleVisualizer();

                    state._fsp--;


                    			current = this_Visualizer_7;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 9 :
                    // InternalMyDsl.g:3056:3: this_ServiceFront_8= ruleServiceFront
                    {

                    			newCompositeNode(grammarAccess.getAbstractFrontElementAccess().getServiceFrontParserRuleCall_8());
                    		
                    pushFollow(FOLLOW_2);
                    this_ServiceFront_8=ruleServiceFront();

                    state._fsp--;


                    			current = this_ServiceFront_8;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 10 :
                    // InternalMyDsl.g:3065:3: this_File_9= ruleFile
                    {

                    			newCompositeNode(grammarAccess.getAbstractFrontElementAccess().getFileParserRuleCall_9());
                    		
                    pushFollow(FOLLOW_2);
                    this_File_9=ruleFile();

                    state._fsp--;


                    			current = this_File_9;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 11 :
                    // InternalMyDsl.g:3074:3: this_State_10= ruleState
                    {

                    			newCompositeNode(grammarAccess.getAbstractFrontElementAccess().getStateParserRuleCall_10());
                    		
                    pushFollow(FOLLOW_2);
                    this_State_10=ruleState();

                    state._fsp--;


                    			current = this_State_10;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 12 :
                    // InternalMyDsl.g:3083:3: this_Action_11= ruleAction
                    {

                    			newCompositeNode(grammarAccess.getAbstractFrontElementAccess().getActionParserRuleCall_11());
                    		
                    pushFollow(FOLLOW_2);
                    this_Action_11=ruleAction();

                    state._fsp--;


                    			current = this_Action_11;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 13 :
                    // InternalMyDsl.g:3092:3: this_ActionCreator_12= ruleActionCreator
                    {

                    			newCompositeNode(grammarAccess.getAbstractFrontElementAccess().getActionCreatorParserRuleCall_12());
                    		
                    pushFollow(FOLLOW_2);
                    this_ActionCreator_12=ruleActionCreator();

                    state._fsp--;


                    			current = this_ActionCreator_12;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 14 :
                    // InternalMyDsl.g:3101:3: this_ActionDispatcher_13= ruleActionDispatcher
                    {

                    			newCompositeNode(grammarAccess.getAbstractFrontElementAccess().getActionDispatcherParserRuleCall_13());
                    		
                    pushFollow(FOLLOW_2);
                    this_ActionDispatcher_13=ruleActionDispatcher();

                    state._fsp--;


                    			current = this_ActionDispatcher_13;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 15 :
                    // InternalMyDsl.g:3110:3: this_Reducer_14= ruleReducer
                    {

                    			newCompositeNode(grammarAccess.getAbstractFrontElementAccess().getReducerParserRuleCall_14());
                    		
                    pushFollow(FOLLOW_2);
                    this_Reducer_14=ruleReducer();

                    state._fsp--;


                    			current = this_Reducer_14;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 16 :
                    // InternalMyDsl.g:3119:3: this_AxiosRequest_15= ruleAxiosRequest
                    {

                    			newCompositeNode(grammarAccess.getAbstractFrontElementAccess().getAxiosRequestParserRuleCall_15());
                    		
                    pushFollow(FOLLOW_2);
                    this_AxiosRequest_15=ruleAxiosRequest();

                    state._fsp--;


                    			current = this_AxiosRequest_15;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAbstractFrontElement"


    // $ANTLR start "entryRuleReactApp"
    // InternalMyDsl.g:3131:1: entryRuleReactApp returns [EObject current=null] : iv_ruleReactApp= ruleReactApp EOF ;
    public final EObject entryRuleReactApp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReactApp = null;


        try {
            // InternalMyDsl.g:3131:49: (iv_ruleReactApp= ruleReactApp EOF )
            // InternalMyDsl.g:3132:2: iv_ruleReactApp= ruleReactApp EOF
            {
             newCompositeNode(grammarAccess.getReactAppRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleReactApp=ruleReactApp();

            state._fsp--;

             current =iv_ruleReactApp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReactApp"


    // $ANTLR start "ruleReactApp"
    // InternalMyDsl.g:3138:1: ruleReactApp returns [EObject current=null] : (otherlv_0= 'reactApp' otherlv_1= '{' ( (lv_elements_2_0= ruleAbstractFrontElement ) )+ (otherlv_3= 'performs:' ( (otherlv_4= RULE_ID ) ) )+ (otherlv_5= 'holds:' ( (otherlv_6= RULE_ID ) ) )+ (otherlv_7= 'use:' ( (otherlv_8= RULE_ID ) ) )+ otherlv_9= '}' ) ;
    public final EObject ruleReactApp() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        EObject lv_elements_2_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:3144:2: ( (otherlv_0= 'reactApp' otherlv_1= '{' ( (lv_elements_2_0= ruleAbstractFrontElement ) )+ (otherlv_3= 'performs:' ( (otherlv_4= RULE_ID ) ) )+ (otherlv_5= 'holds:' ( (otherlv_6= RULE_ID ) ) )+ (otherlv_7= 'use:' ( (otherlv_8= RULE_ID ) ) )+ otherlv_9= '}' ) )
            // InternalMyDsl.g:3145:2: (otherlv_0= 'reactApp' otherlv_1= '{' ( (lv_elements_2_0= ruleAbstractFrontElement ) )+ (otherlv_3= 'performs:' ( (otherlv_4= RULE_ID ) ) )+ (otherlv_5= 'holds:' ( (otherlv_6= RULE_ID ) ) )+ (otherlv_7= 'use:' ( (otherlv_8= RULE_ID ) ) )+ otherlv_9= '}' )
            {
            // InternalMyDsl.g:3145:2: (otherlv_0= 'reactApp' otherlv_1= '{' ( (lv_elements_2_0= ruleAbstractFrontElement ) )+ (otherlv_3= 'performs:' ( (otherlv_4= RULE_ID ) ) )+ (otherlv_5= 'holds:' ( (otherlv_6= RULE_ID ) ) )+ (otherlv_7= 'use:' ( (otherlv_8= RULE_ID ) ) )+ otherlv_9= '}' )
            // InternalMyDsl.g:3146:3: otherlv_0= 'reactApp' otherlv_1= '{' ( (lv_elements_2_0= ruleAbstractFrontElement ) )+ (otherlv_3= 'performs:' ( (otherlv_4= RULE_ID ) ) )+ (otherlv_5= 'holds:' ( (otherlv_6= RULE_ID ) ) )+ (otherlv_7= 'use:' ( (otherlv_8= RULE_ID ) ) )+ otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,81,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getReactAppAccess().getReactAppKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_71); 

            			newLeafNode(otherlv_1, grammarAccess.getReactAppAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalMyDsl.g:3154:3: ( (lv_elements_2_0= ruleAbstractFrontElement ) )+
            int cnt50=0;
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==15||LA50_0==24||LA50_0==81||LA50_0==85||LA50_0==92||LA50_0==95||(LA50_0>=98 && LA50_0<=99)||LA50_0==101||(LA50_0>=105 && LA50_0<=109)||LA50_0==112||(LA50_0>=115 && LA50_0<=117)||LA50_0==129) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // InternalMyDsl.g:3155:4: (lv_elements_2_0= ruleAbstractFrontElement )
            	    {
            	    // InternalMyDsl.g:3155:4: (lv_elements_2_0= ruleAbstractFrontElement )
            	    // InternalMyDsl.g:3156:5: lv_elements_2_0= ruleAbstractFrontElement
            	    {

            	    					newCompositeNode(grammarAccess.getReactAppAccess().getElementsAbstractFrontElementParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_72);
            	    lv_elements_2_0=ruleAbstractFrontElement();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getReactAppRule());
            	    					}
            	    					add(
            	    						current,
            	    						"elements",
            	    						lv_elements_2_0,
            	    						"org.xtext.example.mydsl.MyDsl.AbstractFrontElement");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt50 >= 1 ) break loop50;
                        EarlyExitException eee =
                            new EarlyExitException(50, input);
                        throw eee;
                }
                cnt50++;
            } while (true);

            // InternalMyDsl.g:3173:3: (otherlv_3= 'performs:' ( (otherlv_4= RULE_ID ) ) )+
            int cnt51=0;
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==82) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // InternalMyDsl.g:3174:4: otherlv_3= 'performs:' ( (otherlv_4= RULE_ID ) )
            	    {
            	    otherlv_3=(Token)match(input,82,FOLLOW_11); 

            	    				newLeafNode(otherlv_3, grammarAccess.getReactAppAccess().getPerformsKeyword_3_0());
            	    			
            	    // InternalMyDsl.g:3178:4: ( (otherlv_4= RULE_ID ) )
            	    // InternalMyDsl.g:3179:5: (otherlv_4= RULE_ID )
            	    {
            	    // InternalMyDsl.g:3179:5: (otherlv_4= RULE_ID )
            	    // InternalMyDsl.g:3180:6: otherlv_4= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getReactAppRule());
            	    						}
            	    					
            	    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_73); 

            	    						newLeafNode(otherlv_4, grammarAccess.getReactAppAccess().getFuncFunctionalityCrossReference_3_1_0());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt51 >= 1 ) break loop51;
                        EarlyExitException eee =
                            new EarlyExitException(51, input);
                        throw eee;
                }
                cnt51++;
            } while (true);

            // InternalMyDsl.g:3192:3: (otherlv_5= 'holds:' ( (otherlv_6= RULE_ID ) ) )+
            int cnt52=0;
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==83) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // InternalMyDsl.g:3193:4: otherlv_5= 'holds:' ( (otherlv_6= RULE_ID ) )
            	    {
            	    otherlv_5=(Token)match(input,83,FOLLOW_11); 

            	    				newLeafNode(otherlv_5, grammarAccess.getReactAppAccess().getHoldsKeyword_4_0());
            	    			
            	    // InternalMyDsl.g:3197:4: ( (otherlv_6= RULE_ID ) )
            	    // InternalMyDsl.g:3198:5: (otherlv_6= RULE_ID )
            	    {
            	    // InternalMyDsl.g:3198:5: (otherlv_6= RULE_ID )
            	    // InternalMyDsl.g:3199:6: otherlv_6= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getReactAppRule());
            	    						}
            	    					
            	    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_74); 

            	    						newLeafNode(otherlv_6, grammarAccess.getReactAppAccess().getDirDirectoryCrossReference_4_1_0());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt52 >= 1 ) break loop52;
                        EarlyExitException eee =
                            new EarlyExitException(52, input);
                        throw eee;
                }
                cnt52++;
            } while (true);

            // InternalMyDsl.g:3211:3: (otherlv_7= 'use:' ( (otherlv_8= RULE_ID ) ) )+
            int cnt53=0;
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==84) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // InternalMyDsl.g:3212:4: otherlv_7= 'use:' ( (otherlv_8= RULE_ID ) )
            	    {
            	    otherlv_7=(Token)match(input,84,FOLLOW_11); 

            	    				newLeafNode(otherlv_7, grammarAccess.getReactAppAccess().getUseKeyword_5_0());
            	    			
            	    // InternalMyDsl.g:3216:4: ( (otherlv_8= RULE_ID ) )
            	    // InternalMyDsl.g:3217:5: (otherlv_8= RULE_ID )
            	    {
            	    // InternalMyDsl.g:3217:5: (otherlv_8= RULE_ID )
            	    // InternalMyDsl.g:3218:6: otherlv_8= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getReactAppRule());
            	    						}
            	    					
            	    otherlv_8=(Token)match(input,RULE_ID,FOLLOW_75); 

            	    						newLeafNode(otherlv_8, grammarAccess.getReactAppAccess().getModJsModuleCrossReference_5_1_0());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt53 >= 1 ) break loop53;
                        EarlyExitException eee =
                            new EarlyExitException(53, input);
                        throw eee;
                }
                cnt53++;
            } while (true);

            otherlv_9=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getReactAppAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReactApp"


    // $ANTLR start "entryRuleFunctionality"
    // InternalMyDsl.g:3238:1: entryRuleFunctionality returns [EObject current=null] : iv_ruleFunctionality= ruleFunctionality EOF ;
    public final EObject entryRuleFunctionality() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionality = null;


        try {
            // InternalMyDsl.g:3238:54: (iv_ruleFunctionality= ruleFunctionality EOF )
            // InternalMyDsl.g:3239:2: iv_ruleFunctionality= ruleFunctionality EOF
            {
             newCompositeNode(grammarAccess.getFunctionalityRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFunctionality=ruleFunctionality();

            state._fsp--;

             current =iv_ruleFunctionality; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunctionality"


    // $ANTLR start "ruleFunctionality"
    // InternalMyDsl.g:3245:1: ruleFunctionality returns [EObject current=null] : (otherlv_0= 'functionality' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'uses:' ( (otherlv_4= RULE_ID ) ) )* (otherlv_5= 'wraps:' ( (otherlv_6= RULE_ID ) ) )* (otherlv_7= 'render:' ( (otherlv_8= RULE_ID ) ) )+ (otherlv_9= 'state:' ( (otherlv_10= RULE_ID ) ) )* (otherlv_11= 'calls:' ( (otherlv_12= RULE_ID ) ) )* otherlv_13= 'organizedBy:' ( (otherlv_14= RULE_ID ) ) otherlv_15= '}' ) ;
    public final EObject ruleFunctionality() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_15=null;


        	enterRule();

        try {
            // InternalMyDsl.g:3251:2: ( (otherlv_0= 'functionality' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'uses:' ( (otherlv_4= RULE_ID ) ) )* (otherlv_5= 'wraps:' ( (otherlv_6= RULE_ID ) ) )* (otherlv_7= 'render:' ( (otherlv_8= RULE_ID ) ) )+ (otherlv_9= 'state:' ( (otherlv_10= RULE_ID ) ) )* (otherlv_11= 'calls:' ( (otherlv_12= RULE_ID ) ) )* otherlv_13= 'organizedBy:' ( (otherlv_14= RULE_ID ) ) otherlv_15= '}' ) )
            // InternalMyDsl.g:3252:2: (otherlv_0= 'functionality' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'uses:' ( (otherlv_4= RULE_ID ) ) )* (otherlv_5= 'wraps:' ( (otherlv_6= RULE_ID ) ) )* (otherlv_7= 'render:' ( (otherlv_8= RULE_ID ) ) )+ (otherlv_9= 'state:' ( (otherlv_10= RULE_ID ) ) )* (otherlv_11= 'calls:' ( (otherlv_12= RULE_ID ) ) )* otherlv_13= 'organizedBy:' ( (otherlv_14= RULE_ID ) ) otherlv_15= '}' )
            {
            // InternalMyDsl.g:3252:2: (otherlv_0= 'functionality' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'uses:' ( (otherlv_4= RULE_ID ) ) )* (otherlv_5= 'wraps:' ( (otherlv_6= RULE_ID ) ) )* (otherlv_7= 'render:' ( (otherlv_8= RULE_ID ) ) )+ (otherlv_9= 'state:' ( (otherlv_10= RULE_ID ) ) )* (otherlv_11= 'calls:' ( (otherlv_12= RULE_ID ) ) )* otherlv_13= 'organizedBy:' ( (otherlv_14= RULE_ID ) ) otherlv_15= '}' )
            // InternalMyDsl.g:3253:3: otherlv_0= 'functionality' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'uses:' ( (otherlv_4= RULE_ID ) ) )* (otherlv_5= 'wraps:' ( (otherlv_6= RULE_ID ) ) )* (otherlv_7= 'render:' ( (otherlv_8= RULE_ID ) ) )+ (otherlv_9= 'state:' ( (otherlv_10= RULE_ID ) ) )* (otherlv_11= 'calls:' ( (otherlv_12= RULE_ID ) ) )* otherlv_13= 'organizedBy:' ( (otherlv_14= RULE_ID ) ) otherlv_15= '}'
            {
            otherlv_0=(Token)match(input,85,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getFunctionalityAccess().getFunctionalityKeyword_0());
            		
            // InternalMyDsl.g:3257:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMyDsl.g:3258:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMyDsl.g:3258:4: (lv_name_1_0= RULE_ID )
            // InternalMyDsl.g:3259:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_3); 

            					newLeafNode(lv_name_1_0, grammarAccess.getFunctionalityAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFunctionalityRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_76); 

            			newLeafNode(otherlv_2, grammarAccess.getFunctionalityAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:3279:3: (otherlv_3= 'uses:' ( (otherlv_4= RULE_ID ) ) )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==86) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // InternalMyDsl.g:3280:4: otherlv_3= 'uses:' ( (otherlv_4= RULE_ID ) )
            	    {
            	    otherlv_3=(Token)match(input,86,FOLLOW_11); 

            	    				newLeafNode(otherlv_3, grammarAccess.getFunctionalityAccess().getUsesKeyword_3_0());
            	    			
            	    // InternalMyDsl.g:3284:4: ( (otherlv_4= RULE_ID ) )
            	    // InternalMyDsl.g:3285:5: (otherlv_4= RULE_ID )
            	    {
            	    // InternalMyDsl.g:3285:5: (otherlv_4= RULE_ID )
            	    // InternalMyDsl.g:3286:6: otherlv_4= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getFunctionalityRule());
            	    						}
            	    					
            	    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_76); 

            	    						newLeafNode(otherlv_4, grammarAccess.getFunctionalityAccess().getRouteRouterComponentCrossReference_3_1_0());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop54;
                }
            } while (true);

            // InternalMyDsl.g:3298:3: (otherlv_5= 'wraps:' ( (otherlv_6= RULE_ID ) ) )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==87) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // InternalMyDsl.g:3299:4: otherlv_5= 'wraps:' ( (otherlv_6= RULE_ID ) )
            	    {
            	    otherlv_5=(Token)match(input,87,FOLLOW_11); 

            	    				newLeafNode(otherlv_5, grammarAccess.getFunctionalityAccess().getWrapsKeyword_4_0());
            	    			
            	    // InternalMyDsl.g:3303:4: ( (otherlv_6= RULE_ID ) )
            	    // InternalMyDsl.g:3304:5: (otherlv_6= RULE_ID )
            	    {
            	    // InternalMyDsl.g:3304:5: (otherlv_6= RULE_ID )
            	    // InternalMyDsl.g:3305:6: otherlv_6= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getFunctionalityRule());
            	    						}
            	    					
            	    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_77); 

            	    						newLeafNode(otherlv_6, grammarAccess.getFunctionalityAccess().getWrapContainerCrossReference_4_1_0());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop55;
                }
            } while (true);

            // InternalMyDsl.g:3317:3: (otherlv_7= 'render:' ( (otherlv_8= RULE_ID ) ) )+
            int cnt56=0;
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==88) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // InternalMyDsl.g:3318:4: otherlv_7= 'render:' ( (otherlv_8= RULE_ID ) )
            	    {
            	    otherlv_7=(Token)match(input,88,FOLLOW_11); 

            	    				newLeafNode(otherlv_7, grammarAccess.getFunctionalityAccess().getRenderKeyword_5_0());
            	    			
            	    // InternalMyDsl.g:3322:4: ( (otherlv_8= RULE_ID ) )
            	    // InternalMyDsl.g:3323:5: (otherlv_8= RULE_ID )
            	    {
            	    // InternalMyDsl.g:3323:5: (otherlv_8= RULE_ID )
            	    // InternalMyDsl.g:3324:6: otherlv_8= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getFunctionalityRule());
            	    						}
            	    					
            	    otherlv_8=(Token)match(input,RULE_ID,FOLLOW_78); 

            	    						newLeafNode(otherlv_8, grammarAccess.getFunctionalityAccess().getRenderVisualizerCrossReference_5_1_0());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt56 >= 1 ) break loop56;
                        EarlyExitException eee =
                            new EarlyExitException(56, input);
                        throw eee;
                }
                cnt56++;
            } while (true);

            // InternalMyDsl.g:3336:3: (otherlv_9= 'state:' ( (otherlv_10= RULE_ID ) ) )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==89) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // InternalMyDsl.g:3337:4: otherlv_9= 'state:' ( (otherlv_10= RULE_ID ) )
            	    {
            	    otherlv_9=(Token)match(input,89,FOLLOW_11); 

            	    				newLeafNode(otherlv_9, grammarAccess.getFunctionalityAccess().getStateKeyword_6_0());
            	    			
            	    // InternalMyDsl.g:3341:4: ( (otherlv_10= RULE_ID ) )
            	    // InternalMyDsl.g:3342:5: (otherlv_10= RULE_ID )
            	    {
            	    // InternalMyDsl.g:3342:5: (otherlv_10= RULE_ID )
            	    // InternalMyDsl.g:3343:6: otherlv_10= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getFunctionalityRule());
            	    						}
            	    					
            	    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_79); 

            	    						newLeafNode(otherlv_10, grammarAccess.getFunctionalityAccess().getStateStateCrossReference_6_1_0());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop57;
                }
            } while (true);

            // InternalMyDsl.g:3355:3: (otherlv_11= 'calls:' ( (otherlv_12= RULE_ID ) ) )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==90) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // InternalMyDsl.g:3356:4: otherlv_11= 'calls:' ( (otherlv_12= RULE_ID ) )
            	    {
            	    otherlv_11=(Token)match(input,90,FOLLOW_11); 

            	    				newLeafNode(otherlv_11, grammarAccess.getFunctionalityAccess().getCallsKeyword_7_0());
            	    			
            	    // InternalMyDsl.g:3360:4: ( (otherlv_12= RULE_ID ) )
            	    // InternalMyDsl.g:3361:5: (otherlv_12= RULE_ID )
            	    {
            	    // InternalMyDsl.g:3361:5: (otherlv_12= RULE_ID )
            	    // InternalMyDsl.g:3362:6: otherlv_12= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getFunctionalityRule());
            	    						}
            	    					
            	    otherlv_12=(Token)match(input,RULE_ID,FOLLOW_80); 

            	    						newLeafNode(otherlv_12, grammarAccess.getFunctionalityAccess().getServiceServiceFrontCrossReference_7_1_0());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop58;
                }
            } while (true);

            otherlv_13=(Token)match(input,91,FOLLOW_11); 

            			newLeafNode(otherlv_13, grammarAccess.getFunctionalityAccess().getOrganizedByKeyword_8());
            		
            // InternalMyDsl.g:3378:3: ( (otherlv_14= RULE_ID ) )
            // InternalMyDsl.g:3379:4: (otherlv_14= RULE_ID )
            {
            // InternalMyDsl.g:3379:4: (otherlv_14= RULE_ID )
            // InternalMyDsl.g:3380:5: otherlv_14= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFunctionalityRule());
            					}
            				
            otherlv_14=(Token)match(input,RULE_ID,FOLLOW_7); 

            					newLeafNode(otherlv_14, grammarAccess.getFunctionalityAccess().getTypeDirectoryCrossReference_9_0());
            				

            }


            }

            otherlv_15=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_15, grammarAccess.getFunctionalityAccess().getRightCurlyBracketKeyword_10());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunctionality"


    // $ANTLR start "entryRuleRouterComponent"
    // InternalMyDsl.g:3399:1: entryRuleRouterComponent returns [EObject current=null] : iv_ruleRouterComponent= ruleRouterComponent EOF ;
    public final EObject entryRuleRouterComponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRouterComponent = null;


        try {
            // InternalMyDsl.g:3399:56: (iv_ruleRouterComponent= ruleRouterComponent EOF )
            // InternalMyDsl.g:3400:2: iv_ruleRouterComponent= ruleRouterComponent EOF
            {
             newCompositeNode(grammarAccess.getRouterComponentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRouterComponent=ruleRouterComponent();

            state._fsp--;

             current =iv_ruleRouterComponent; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRouterComponent"


    // $ANTLR start "ruleRouterComponent"
    // InternalMyDsl.g:3406:1: ruleRouterComponent returns [EObject current=null] : (otherlv_0= 'router' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'inWithin:' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'use:' ( (otherlv_6= RULE_ID ) ) otherlv_7= 'route:' ( (otherlv_8= RULE_ID ) ) otherlv_9= '}' ) ;
    public final EObject ruleRouterComponent() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;


        	enterRule();

        try {
            // InternalMyDsl.g:3412:2: ( (otherlv_0= 'router' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'inWithin:' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'use:' ( (otherlv_6= RULE_ID ) ) otherlv_7= 'route:' ( (otherlv_8= RULE_ID ) ) otherlv_9= '}' ) )
            // InternalMyDsl.g:3413:2: (otherlv_0= 'router' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'inWithin:' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'use:' ( (otherlv_6= RULE_ID ) ) otherlv_7= 'route:' ( (otherlv_8= RULE_ID ) ) otherlv_9= '}' )
            {
            // InternalMyDsl.g:3413:2: (otherlv_0= 'router' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'inWithin:' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'use:' ( (otherlv_6= RULE_ID ) ) otherlv_7= 'route:' ( (otherlv_8= RULE_ID ) ) otherlv_9= '}' )
            // InternalMyDsl.g:3414:3: otherlv_0= 'router' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'inWithin:' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'use:' ( (otherlv_6= RULE_ID ) ) otherlv_7= 'route:' ( (otherlv_8= RULE_ID ) ) otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,92,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getRouterComponentAccess().getRouterKeyword_0());
            		
            // InternalMyDsl.g:3418:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMyDsl.g:3419:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMyDsl.g:3419:4: (lv_name_1_0= RULE_ID )
            // InternalMyDsl.g:3420:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_3); 

            					newLeafNode(lv_name_1_0, grammarAccess.getRouterComponentAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRouterComponentRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_81); 

            			newLeafNode(otherlv_2, grammarAccess.getRouterComponentAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,93,FOLLOW_11); 

            			newLeafNode(otherlv_3, grammarAccess.getRouterComponentAccess().getInWithinKeyword_3());
            		
            // InternalMyDsl.g:3444:3: ( (otherlv_4= RULE_ID ) )
            // InternalMyDsl.g:3445:4: (otherlv_4= RULE_ID )
            {
            // InternalMyDsl.g:3445:4: (otherlv_4= RULE_ID )
            // InternalMyDsl.g:3446:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRouterComponentRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_82); 

            					newLeafNode(otherlv_4, grammarAccess.getRouterComponentAccess().getTypeDirectoryCrossReference_4_0());
            				

            }


            }

            otherlv_5=(Token)match(input,84,FOLLOW_11); 

            			newLeafNode(otherlv_5, grammarAccess.getRouterComponentAccess().getUseKeyword_5());
            		
            // InternalMyDsl.g:3461:3: ( (otherlv_6= RULE_ID ) )
            // InternalMyDsl.g:3462:4: (otherlv_6= RULE_ID )
            {
            // InternalMyDsl.g:3462:4: (otherlv_6= RULE_ID )
            // InternalMyDsl.g:3463:5: otherlv_6= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRouterComponentRule());
            					}
            				
            otherlv_6=(Token)match(input,RULE_ID,FOLLOW_83); 

            					newLeafNode(otherlv_6, grammarAccess.getRouterComponentAccess().getTypeJsModuleCrossReference_6_0());
            				

            }


            }

            otherlv_7=(Token)match(input,94,FOLLOW_11); 

            			newLeafNode(otherlv_7, grammarAccess.getRouterComponentAccess().getRouteKeyword_7());
            		
            // InternalMyDsl.g:3478:3: ( (otherlv_8= RULE_ID ) )
            // InternalMyDsl.g:3479:4: (otherlv_8= RULE_ID )
            {
            // InternalMyDsl.g:3479:4: (otherlv_8= RULE_ID )
            // InternalMyDsl.g:3480:5: otherlv_8= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRouterComponentRule());
            					}
            				
            otherlv_8=(Token)match(input,RULE_ID,FOLLOW_7); 

            					newLeafNode(otherlv_8, grammarAccess.getRouterComponentAccess().getRouteUIComponentCrossReference_8_0());
            				

            }


            }

            otherlv_9=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getRouterComponentAccess().getRightCurlyBracketKeyword_9());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRouterComponent"


    // $ANTLR start "entryRuleContainer"
    // InternalMyDsl.g:3499:1: entryRuleContainer returns [EObject current=null] : iv_ruleContainer= ruleContainer EOF ;
    public final EObject entryRuleContainer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainer = null;


        try {
            // InternalMyDsl.g:3499:50: (iv_ruleContainer= ruleContainer EOF )
            // InternalMyDsl.g:3500:2: iv_ruleContainer= ruleContainer EOF
            {
             newCompositeNode(grammarAccess.getContainerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContainer=ruleContainer();

            state._fsp--;

             current =iv_ruleContainer; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContainer"


    // $ANTLR start "ruleContainer"
    // InternalMyDsl.g:3506:1: ruleContainer returns [EObject current=null] : (otherlv_0= 'container' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'inWithin:' ( (otherlv_4= RULE_ID ) ) (otherlv_5= 'dispatch:' ( (otherlv_6= RULE_ID ) ) )? (otherlv_7= 'map:' ( (otherlv_8= RULE_ID ) ) )* otherlv_9= 'use:' ( (otherlv_10= RULE_ID ) ) otherlv_11= '}' ) ;
    public final EObject ruleContainer() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;


        	enterRule();

        try {
            // InternalMyDsl.g:3512:2: ( (otherlv_0= 'container' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'inWithin:' ( (otherlv_4= RULE_ID ) ) (otherlv_5= 'dispatch:' ( (otherlv_6= RULE_ID ) ) )? (otherlv_7= 'map:' ( (otherlv_8= RULE_ID ) ) )* otherlv_9= 'use:' ( (otherlv_10= RULE_ID ) ) otherlv_11= '}' ) )
            // InternalMyDsl.g:3513:2: (otherlv_0= 'container' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'inWithin:' ( (otherlv_4= RULE_ID ) ) (otherlv_5= 'dispatch:' ( (otherlv_6= RULE_ID ) ) )? (otherlv_7= 'map:' ( (otherlv_8= RULE_ID ) ) )* otherlv_9= 'use:' ( (otherlv_10= RULE_ID ) ) otherlv_11= '}' )
            {
            // InternalMyDsl.g:3513:2: (otherlv_0= 'container' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'inWithin:' ( (otherlv_4= RULE_ID ) ) (otherlv_5= 'dispatch:' ( (otherlv_6= RULE_ID ) ) )? (otherlv_7= 'map:' ( (otherlv_8= RULE_ID ) ) )* otherlv_9= 'use:' ( (otherlv_10= RULE_ID ) ) otherlv_11= '}' )
            // InternalMyDsl.g:3514:3: otherlv_0= 'container' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'inWithin:' ( (otherlv_4= RULE_ID ) ) (otherlv_5= 'dispatch:' ( (otherlv_6= RULE_ID ) ) )? (otherlv_7= 'map:' ( (otherlv_8= RULE_ID ) ) )* otherlv_9= 'use:' ( (otherlv_10= RULE_ID ) ) otherlv_11= '}'
            {
            otherlv_0=(Token)match(input,95,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getContainerAccess().getContainerKeyword_0());
            		
            // InternalMyDsl.g:3518:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMyDsl.g:3519:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMyDsl.g:3519:4: (lv_name_1_0= RULE_ID )
            // InternalMyDsl.g:3520:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_3); 

            					newLeafNode(lv_name_1_0, grammarAccess.getContainerAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getContainerRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_81); 

            			newLeafNode(otherlv_2, grammarAccess.getContainerAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,93,FOLLOW_11); 

            			newLeafNode(otherlv_3, grammarAccess.getContainerAccess().getInWithinKeyword_3());
            		
            // InternalMyDsl.g:3544:3: ( (otherlv_4= RULE_ID ) )
            // InternalMyDsl.g:3545:4: (otherlv_4= RULE_ID )
            {
            // InternalMyDsl.g:3545:4: (otherlv_4= RULE_ID )
            // InternalMyDsl.g:3546:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getContainerRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_84); 

            					newLeafNode(otherlv_4, grammarAccess.getContainerAccess().getTypeDirectoryCrossReference_4_0());
            				

            }


            }

            // InternalMyDsl.g:3557:3: (otherlv_5= 'dispatch:' ( (otherlv_6= RULE_ID ) ) )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==96) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // InternalMyDsl.g:3558:4: otherlv_5= 'dispatch:' ( (otherlv_6= RULE_ID ) )
                    {
                    otherlv_5=(Token)match(input,96,FOLLOW_11); 

                    				newLeafNode(otherlv_5, grammarAccess.getContainerAccess().getDispatchKeyword_5_0());
                    			
                    // InternalMyDsl.g:3562:4: ( (otherlv_6= RULE_ID ) )
                    // InternalMyDsl.g:3563:5: (otherlv_6= RULE_ID )
                    {
                    // InternalMyDsl.g:3563:5: (otherlv_6= RULE_ID )
                    // InternalMyDsl.g:3564:6: otherlv_6= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getContainerRule());
                    						}
                    					
                    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_85); 

                    						newLeafNode(otherlv_6, grammarAccess.getContainerAccess().getTypeActionDispatcherCrossReference_5_1_0());
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMyDsl.g:3576:3: (otherlv_7= 'map:' ( (otherlv_8= RULE_ID ) ) )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==97) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // InternalMyDsl.g:3577:4: otherlv_7= 'map:' ( (otherlv_8= RULE_ID ) )
            	    {
            	    otherlv_7=(Token)match(input,97,FOLLOW_11); 

            	    				newLeafNode(otherlv_7, grammarAccess.getContainerAccess().getMapKeyword_6_0());
            	    			
            	    // InternalMyDsl.g:3581:4: ( (otherlv_8= RULE_ID ) )
            	    // InternalMyDsl.g:3582:5: (otherlv_8= RULE_ID )
            	    {
            	    // InternalMyDsl.g:3582:5: (otherlv_8= RULE_ID )
            	    // InternalMyDsl.g:3583:6: otherlv_8= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getContainerRule());
            	    						}
            	    					
            	    otherlv_8=(Token)match(input,RULE_ID,FOLLOW_85); 

            	    						newLeafNode(otherlv_8, grammarAccess.getContainerAccess().getTypeReducerCrossReference_6_1_0());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop60;
                }
            } while (true);

            otherlv_9=(Token)match(input,84,FOLLOW_11); 

            			newLeafNode(otherlv_9, grammarAccess.getContainerAccess().getUseKeyword_7());
            		
            // InternalMyDsl.g:3599:3: ( (otherlv_10= RULE_ID ) )
            // InternalMyDsl.g:3600:4: (otherlv_10= RULE_ID )
            {
            // InternalMyDsl.g:3600:4: (otherlv_10= RULE_ID )
            // InternalMyDsl.g:3601:5: otherlv_10= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getContainerRule());
            					}
            				
            otherlv_10=(Token)match(input,RULE_ID,FOLLOW_7); 

            					newLeafNode(otherlv_10, grammarAccess.getContainerAccess().getTypeJsModuleCrossReference_8_0());
            				

            }


            }

            otherlv_11=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_11, grammarAccess.getContainerAccess().getRightCurlyBracketKeyword_9());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContainer"


    // $ANTLR start "entryRuleVisualizer"
    // InternalMyDsl.g:3620:1: entryRuleVisualizer returns [EObject current=null] : iv_ruleVisualizer= ruleVisualizer EOF ;
    public final EObject entryRuleVisualizer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVisualizer = null;


        try {
            // InternalMyDsl.g:3620:51: (iv_ruleVisualizer= ruleVisualizer EOF )
            // InternalMyDsl.g:3621:2: iv_ruleVisualizer= ruleVisualizer EOF
            {
             newCompositeNode(grammarAccess.getVisualizerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVisualizer=ruleVisualizer();

            state._fsp--;

             current =iv_ruleVisualizer; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVisualizer"


    // $ANTLR start "ruleVisualizer"
    // InternalMyDsl.g:3627:1: ruleVisualizer returns [EObject current=null] : (otherlv_0= 'visualizer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'inWithin:' ( (otherlv_4= RULE_ID ) ) (otherlv_5= 'use:' ( (otherlv_6= RULE_ID ) ) )+ ( (lv_methods_7_0= ruleJsMethod ) )+ otherlv_8= '}' ) ;
    public final EObject ruleVisualizer() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_methods_7_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:3633:2: ( (otherlv_0= 'visualizer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'inWithin:' ( (otherlv_4= RULE_ID ) ) (otherlv_5= 'use:' ( (otherlv_6= RULE_ID ) ) )+ ( (lv_methods_7_0= ruleJsMethod ) )+ otherlv_8= '}' ) )
            // InternalMyDsl.g:3634:2: (otherlv_0= 'visualizer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'inWithin:' ( (otherlv_4= RULE_ID ) ) (otherlv_5= 'use:' ( (otherlv_6= RULE_ID ) ) )+ ( (lv_methods_7_0= ruleJsMethod ) )+ otherlv_8= '}' )
            {
            // InternalMyDsl.g:3634:2: (otherlv_0= 'visualizer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'inWithin:' ( (otherlv_4= RULE_ID ) ) (otherlv_5= 'use:' ( (otherlv_6= RULE_ID ) ) )+ ( (lv_methods_7_0= ruleJsMethod ) )+ otherlv_8= '}' )
            // InternalMyDsl.g:3635:3: otherlv_0= 'visualizer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'inWithin:' ( (otherlv_4= RULE_ID ) ) (otherlv_5= 'use:' ( (otherlv_6= RULE_ID ) ) )+ ( (lv_methods_7_0= ruleJsMethod ) )+ otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,98,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getVisualizerAccess().getVisualizerKeyword_0());
            		
            // InternalMyDsl.g:3639:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMyDsl.g:3640:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMyDsl.g:3640:4: (lv_name_1_0= RULE_ID )
            // InternalMyDsl.g:3641:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_3); 

            					newLeafNode(lv_name_1_0, grammarAccess.getVisualizerAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getVisualizerRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_81); 

            			newLeafNode(otherlv_2, grammarAccess.getVisualizerAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,93,FOLLOW_11); 

            			newLeafNode(otherlv_3, grammarAccess.getVisualizerAccess().getInWithinKeyword_3());
            		
            // InternalMyDsl.g:3665:3: ( (otherlv_4= RULE_ID ) )
            // InternalMyDsl.g:3666:4: (otherlv_4= RULE_ID )
            {
            // InternalMyDsl.g:3666:4: (otherlv_4= RULE_ID )
            // InternalMyDsl.g:3667:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getVisualizerRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_82); 

            					newLeafNode(otherlv_4, grammarAccess.getVisualizerAccess().getTypeDirectoryCrossReference_4_0());
            				

            }


            }

            // InternalMyDsl.g:3678:3: (otherlv_5= 'use:' ( (otherlv_6= RULE_ID ) ) )+
            int cnt61=0;
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==84) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // InternalMyDsl.g:3679:4: otherlv_5= 'use:' ( (otherlv_6= RULE_ID ) )
            	    {
            	    otherlv_5=(Token)match(input,84,FOLLOW_11); 

            	    				newLeafNode(otherlv_5, grammarAccess.getVisualizerAccess().getUseKeyword_5_0());
            	    			
            	    // InternalMyDsl.g:3683:4: ( (otherlv_6= RULE_ID ) )
            	    // InternalMyDsl.g:3684:5: (otherlv_6= RULE_ID )
            	    {
            	    // InternalMyDsl.g:3684:5: (otherlv_6= RULE_ID )
            	    // InternalMyDsl.g:3685:6: otherlv_6= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getVisualizerRule());
            	    						}
            	    					
            	    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_86); 

            	    						newLeafNode(otherlv_6, grammarAccess.getVisualizerAccess().getTypeJsModuleCrossReference_5_1_0());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt61 >= 1 ) break loop61;
                        EarlyExitException eee =
                            new EarlyExitException(61, input);
                        throw eee;
                }
                cnt61++;
            } while (true);

            // InternalMyDsl.g:3697:3: ( (lv_methods_7_0= ruleJsMethod ) )+
            int cnt62=0;
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==121) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // InternalMyDsl.g:3698:4: (lv_methods_7_0= ruleJsMethod )
            	    {
            	    // InternalMyDsl.g:3698:4: (lv_methods_7_0= ruleJsMethod )
            	    // InternalMyDsl.g:3699:5: lv_methods_7_0= ruleJsMethod
            	    {

            	    					newCompositeNode(grammarAccess.getVisualizerAccess().getMethodsJsMethodParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_87);
            	    lv_methods_7_0=ruleJsMethod();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getVisualizerRule());
            	    					}
            	    					add(
            	    						current,
            	    						"methods",
            	    						lv_methods_7_0,
            	    						"org.xtext.example.mydsl.MyDsl.JsMethod");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt62 >= 1 ) break loop62;
                        EarlyExitException eee =
                            new EarlyExitException(62, input);
                        throw eee;
                }
                cnt62++;
            } while (true);

            otherlv_8=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getVisualizerAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVisualizer"


    // $ANTLR start "entryRuleServiceFront"
    // InternalMyDsl.g:3724:1: entryRuleServiceFront returns [EObject current=null] : iv_ruleServiceFront= ruleServiceFront EOF ;
    public final EObject entryRuleServiceFront() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceFront = null;


        try {
            // InternalMyDsl.g:3724:53: (iv_ruleServiceFront= ruleServiceFront EOF )
            // InternalMyDsl.g:3725:2: iv_ruleServiceFront= ruleServiceFront EOF
            {
             newCompositeNode(grammarAccess.getServiceFrontRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleServiceFront=ruleServiceFront();

            state._fsp--;

             current =iv_ruleServiceFront; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleServiceFront"


    // $ANTLR start "ruleServiceFront"
    // InternalMyDsl.g:3731:1: ruleServiceFront returns [EObject current=null] : (otherlv_0= 'service' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'use:' ( (otherlv_4= RULE_ID ) ) (otherlv_5= 'method:' ( (lv_method_6_0= RULE_STRING ) ) )+ ( (lv_requests_7_0= ruleAxiosRequest ) )+ otherlv_8= '}' ) ;
    public final EObject ruleServiceFront() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_method_6_0=null;
        Token otherlv_8=null;
        EObject lv_requests_7_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:3737:2: ( (otherlv_0= 'service' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'use:' ( (otherlv_4= RULE_ID ) ) (otherlv_5= 'method:' ( (lv_method_6_0= RULE_STRING ) ) )+ ( (lv_requests_7_0= ruleAxiosRequest ) )+ otherlv_8= '}' ) )
            // InternalMyDsl.g:3738:2: (otherlv_0= 'service' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'use:' ( (otherlv_4= RULE_ID ) ) (otherlv_5= 'method:' ( (lv_method_6_0= RULE_STRING ) ) )+ ( (lv_requests_7_0= ruleAxiosRequest ) )+ otherlv_8= '}' )
            {
            // InternalMyDsl.g:3738:2: (otherlv_0= 'service' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'use:' ( (otherlv_4= RULE_ID ) ) (otherlv_5= 'method:' ( (lv_method_6_0= RULE_STRING ) ) )+ ( (lv_requests_7_0= ruleAxiosRequest ) )+ otherlv_8= '}' )
            // InternalMyDsl.g:3739:3: otherlv_0= 'service' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'use:' ( (otherlv_4= RULE_ID ) ) (otherlv_5= 'method:' ( (lv_method_6_0= RULE_STRING ) ) )+ ( (lv_requests_7_0= ruleAxiosRequest ) )+ otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,99,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getServiceFrontAccess().getServiceKeyword_0());
            		
            // InternalMyDsl.g:3743:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMyDsl.g:3744:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMyDsl.g:3744:4: (lv_name_1_0= RULE_ID )
            // InternalMyDsl.g:3745:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_3); 

            					newLeafNode(lv_name_1_0, grammarAccess.getServiceFrontAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getServiceFrontRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_82); 

            			newLeafNode(otherlv_2, grammarAccess.getServiceFrontAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,84,FOLLOW_11); 

            			newLeafNode(otherlv_3, grammarAccess.getServiceFrontAccess().getUseKeyword_3());
            		
            // InternalMyDsl.g:3769:3: ( (otherlv_4= RULE_ID ) )
            // InternalMyDsl.g:3770:4: (otherlv_4= RULE_ID )
            {
            // InternalMyDsl.g:3770:4: (otherlv_4= RULE_ID )
            // InternalMyDsl.g:3771:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getServiceFrontRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_88); 

            					newLeafNode(otherlv_4, grammarAccess.getServiceFrontAccess().getTypeJsModuleCrossReference_4_0());
            				

            }


            }

            // InternalMyDsl.g:3782:3: (otherlv_5= 'method:' ( (lv_method_6_0= RULE_STRING ) ) )+
            int cnt63=0;
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==100) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // InternalMyDsl.g:3783:4: otherlv_5= 'method:' ( (lv_method_6_0= RULE_STRING ) )
            	    {
            	    otherlv_5=(Token)match(input,100,FOLLOW_67); 

            	    				newLeafNode(otherlv_5, grammarAccess.getServiceFrontAccess().getMethodKeyword_5_0());
            	    			
            	    // InternalMyDsl.g:3787:4: ( (lv_method_6_0= RULE_STRING ) )
            	    // InternalMyDsl.g:3788:5: (lv_method_6_0= RULE_STRING )
            	    {
            	    // InternalMyDsl.g:3788:5: (lv_method_6_0= RULE_STRING )
            	    // InternalMyDsl.g:3789:6: lv_method_6_0= RULE_STRING
            	    {
            	    lv_method_6_0=(Token)match(input,RULE_STRING,FOLLOW_89); 

            	    						newLeafNode(lv_method_6_0, grammarAccess.getServiceFrontAccess().getMethodSTRINGTerminalRuleCall_5_1_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getServiceFrontRule());
            	    						}
            	    						setWithLastConsumed(
            	    							current,
            	    							"method",
            	    							lv_method_6_0,
            	    							"org.eclipse.xtext.common.Terminals.STRING");
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt63 >= 1 ) break loop63;
                        EarlyExitException eee =
                            new EarlyExitException(63, input);
                        throw eee;
                }
                cnt63++;
            } while (true);

            // InternalMyDsl.g:3806:3: ( (lv_requests_7_0= ruleAxiosRequest ) )+
            int cnt64=0;
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==129) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // InternalMyDsl.g:3807:4: (lv_requests_7_0= ruleAxiosRequest )
            	    {
            	    // InternalMyDsl.g:3807:4: (lv_requests_7_0= ruleAxiosRequest )
            	    // InternalMyDsl.g:3808:5: lv_requests_7_0= ruleAxiosRequest
            	    {

            	    					newCompositeNode(grammarAccess.getServiceFrontAccess().getRequestsAxiosRequestParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_90);
            	    lv_requests_7_0=ruleAxiosRequest();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getServiceFrontRule());
            	    					}
            	    					add(
            	    						current,
            	    						"requests",
            	    						lv_requests_7_0,
            	    						"org.xtext.example.mydsl.MyDsl.AxiosRequest");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt64 >= 1 ) break loop64;
                        EarlyExitException eee =
                            new EarlyExitException(64, input);
                        throw eee;
                }
                cnt64++;
            } while (true);

            otherlv_8=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getServiceFrontAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleServiceFront"


    // $ANTLR start "entryRuleDirectory"
    // InternalMyDsl.g:3833:1: entryRuleDirectory returns [EObject current=null] : iv_ruleDirectory= ruleDirectory EOF ;
    public final EObject entryRuleDirectory() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDirectory = null;


        try {
            // InternalMyDsl.g:3833:50: (iv_ruleDirectory= ruleDirectory EOF )
            // InternalMyDsl.g:3834:2: iv_ruleDirectory= ruleDirectory EOF
            {
             newCompositeNode(grammarAccess.getDirectoryRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDirectory=ruleDirectory();

            state._fsp--;

             current =iv_ruleDirectory; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDirectory"


    // $ANTLR start "ruleDirectory"
    // InternalMyDsl.g:3840:1: ruleDirectory returns [EObject current=null] : (otherlv_0= 'directory' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (otherlv_3= 'has:' )+ ( (otherlv_4= RULE_ID ) ) )* (otherlv_5= 'contains:' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= 'purpose:' ( (lv_purpose_8_0= RULE_STRING ) ) otherlv_9= '}' ) ;
    public final EObject ruleDirectory() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_purpose_8_0=null;
        Token otherlv_9=null;


        	enterRule();

        try {
            // InternalMyDsl.g:3846:2: ( (otherlv_0= 'directory' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (otherlv_3= 'has:' )+ ( (otherlv_4= RULE_ID ) ) )* (otherlv_5= 'contains:' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= 'purpose:' ( (lv_purpose_8_0= RULE_STRING ) ) otherlv_9= '}' ) )
            // InternalMyDsl.g:3847:2: (otherlv_0= 'directory' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (otherlv_3= 'has:' )+ ( (otherlv_4= RULE_ID ) ) )* (otherlv_5= 'contains:' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= 'purpose:' ( (lv_purpose_8_0= RULE_STRING ) ) otherlv_9= '}' )
            {
            // InternalMyDsl.g:3847:2: (otherlv_0= 'directory' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (otherlv_3= 'has:' )+ ( (otherlv_4= RULE_ID ) ) )* (otherlv_5= 'contains:' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= 'purpose:' ( (lv_purpose_8_0= RULE_STRING ) ) otherlv_9= '}' )
            // InternalMyDsl.g:3848:3: otherlv_0= 'directory' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (otherlv_3= 'has:' )+ ( (otherlv_4= RULE_ID ) ) )* (otherlv_5= 'contains:' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= 'purpose:' ( (lv_purpose_8_0= RULE_STRING ) ) otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,101,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getDirectoryAccess().getDirectoryKeyword_0());
            		
            // InternalMyDsl.g:3852:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMyDsl.g:3853:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMyDsl.g:3853:4: (lv_name_1_0= RULE_ID )
            // InternalMyDsl.g:3854:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_3); 

            					newLeafNode(lv_name_1_0, grammarAccess.getDirectoryAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDirectoryRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_91); 

            			newLeafNode(otherlv_2, grammarAccess.getDirectoryAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:3874:3: ( (otherlv_3= 'has:' )+ ( (otherlv_4= RULE_ID ) ) )*
            loop66:
            do {
                int alt66=2;
                int LA66_0 = input.LA(1);

                if ( (LA66_0==102) ) {
                    alt66=1;
                }


                switch (alt66) {
            	case 1 :
            	    // InternalMyDsl.g:3875:4: (otherlv_3= 'has:' )+ ( (otherlv_4= RULE_ID ) )
            	    {
            	    // InternalMyDsl.g:3875:4: (otherlv_3= 'has:' )+
            	    int cnt65=0;
            	    loop65:
            	    do {
            	        int alt65=2;
            	        int LA65_0 = input.LA(1);

            	        if ( (LA65_0==102) ) {
            	            alt65=1;
            	        }


            	        switch (alt65) {
            	    	case 1 :
            	    	    // InternalMyDsl.g:3876:5: otherlv_3= 'has:'
            	    	    {
            	    	    otherlv_3=(Token)match(input,102,FOLLOW_92); 

            	    	    					newLeafNode(otherlv_3, grammarAccess.getDirectoryAccess().getHasKeyword_3_0());
            	    	    				

            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt65 >= 1 ) break loop65;
            	                EarlyExitException eee =
            	                    new EarlyExitException(65, input);
            	                throw eee;
            	        }
            	        cnt65++;
            	    } while (true);

            	    // InternalMyDsl.g:3881:4: ( (otherlv_4= RULE_ID ) )
            	    // InternalMyDsl.g:3882:5: (otherlv_4= RULE_ID )
            	    {
            	    // InternalMyDsl.g:3882:5: (otherlv_4= RULE_ID )
            	    // InternalMyDsl.g:3883:6: otherlv_4= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getDirectoryRule());
            	    						}
            	    					
            	    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_91); 

            	    						newLeafNode(otherlv_4, grammarAccess.getDirectoryAccess().getFileFileCrossReference_3_1_0());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop66;
                }
            } while (true);

            // InternalMyDsl.g:3895:3: (otherlv_5= 'contains:' ( (otherlv_6= RULE_ID ) ) )*
            loop67:
            do {
                int alt67=2;
                int LA67_0 = input.LA(1);

                if ( (LA67_0==103) ) {
                    alt67=1;
                }


                switch (alt67) {
            	case 1 :
            	    // InternalMyDsl.g:3896:4: otherlv_5= 'contains:' ( (otherlv_6= RULE_ID ) )
            	    {
            	    otherlv_5=(Token)match(input,103,FOLLOW_11); 

            	    				newLeafNode(otherlv_5, grammarAccess.getDirectoryAccess().getContainsKeyword_4_0());
            	    			
            	    // InternalMyDsl.g:3900:4: ( (otherlv_6= RULE_ID ) )
            	    // InternalMyDsl.g:3901:5: (otherlv_6= RULE_ID )
            	    {
            	    // InternalMyDsl.g:3901:5: (otherlv_6= RULE_ID )
            	    // InternalMyDsl.g:3902:6: otherlv_6= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getDirectoryRule());
            	    						}
            	    					
            	    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_93); 

            	    						newLeafNode(otherlv_6, grammarAccess.getDirectoryAccess().getSubdirectoryDirectoryCrossReference_4_1_0());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop67;
                }
            } while (true);

            otherlv_7=(Token)match(input,104,FOLLOW_67); 

            			newLeafNode(otherlv_7, grammarAccess.getDirectoryAccess().getPurposeKeyword_5());
            		
            // InternalMyDsl.g:3918:3: ( (lv_purpose_8_0= RULE_STRING ) )
            // InternalMyDsl.g:3919:4: (lv_purpose_8_0= RULE_STRING )
            {
            // InternalMyDsl.g:3919:4: (lv_purpose_8_0= RULE_STRING )
            // InternalMyDsl.g:3920:5: lv_purpose_8_0= RULE_STRING
            {
            lv_purpose_8_0=(Token)match(input,RULE_STRING,FOLLOW_7); 

            					newLeafNode(lv_purpose_8_0, grammarAccess.getDirectoryAccess().getPurposeSTRINGTerminalRuleCall_6_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDirectoryRule());
            					}
            					setWithLastConsumed(
            						current,
            						"purpose",
            						lv_purpose_8_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_9=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getDirectoryAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDirectory"


    // $ANTLR start "entryRuleFile"
    // InternalMyDsl.g:3944:1: entryRuleFile returns [EObject current=null] : iv_ruleFile= ruleFile EOF ;
    public final EObject entryRuleFile() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFile = null;


        try {
            // InternalMyDsl.g:3944:45: (iv_ruleFile= ruleFile EOF )
            // InternalMyDsl.g:3945:2: iv_ruleFile= ruleFile EOF
            {
             newCompositeNode(grammarAccess.getFileRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFile=ruleFile();

            state._fsp--;

             current =iv_ruleFile; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFile"


    // $ANTLR start "ruleFile"
    // InternalMyDsl.g:3951:1: ruleFile returns [EObject current=null] : (this_Md_0= ruleMd | this_Js_1= ruleJs | this_Json_2= ruleJson | this_Css_3= ruleCss ) ;
    public final EObject ruleFile() throws RecognitionException {
        EObject current = null;

        EObject this_Md_0 = null;

        EObject this_Js_1 = null;

        EObject this_Json_2 = null;

        EObject this_Css_3 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:3957:2: ( (this_Md_0= ruleMd | this_Js_1= ruleJs | this_Json_2= ruleJson | this_Css_3= ruleCss ) )
            // InternalMyDsl.g:3958:2: (this_Md_0= ruleMd | this_Js_1= ruleJs | this_Json_2= ruleJson | this_Css_3= ruleCss )
            {
            // InternalMyDsl.g:3958:2: (this_Md_0= ruleMd | this_Js_1= ruleJs | this_Json_2= ruleJson | this_Css_3= ruleCss )
            int alt68=4;
            switch ( input.LA(1) ) {
            case 105:
                {
                alt68=1;
                }
                break;
            case 106:
                {
                alt68=2;
                }
                break;
            case 107:
                {
                alt68=3;
                }
                break;
            case 108:
                {
                alt68=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;
            }

            switch (alt68) {
                case 1 :
                    // InternalMyDsl.g:3959:3: this_Md_0= ruleMd
                    {

                    			newCompositeNode(grammarAccess.getFileAccess().getMdParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Md_0=ruleMd();

                    state._fsp--;


                    			current = this_Md_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:3968:3: this_Js_1= ruleJs
                    {

                    			newCompositeNode(grammarAccess.getFileAccess().getJsParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Js_1=ruleJs();

                    state._fsp--;


                    			current = this_Js_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:3977:3: this_Json_2= ruleJson
                    {

                    			newCompositeNode(grammarAccess.getFileAccess().getJsonParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Json_2=ruleJson();

                    state._fsp--;


                    			current = this_Json_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:3986:3: this_Css_3= ruleCss
                    {

                    			newCompositeNode(grammarAccess.getFileAccess().getCssParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_Css_3=ruleCss();

                    state._fsp--;


                    			current = this_Css_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFile"


    // $ANTLR start "entryRuleMd"
    // InternalMyDsl.g:3998:1: entryRuleMd returns [EObject current=null] : iv_ruleMd= ruleMd EOF ;
    public final EObject entryRuleMd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMd = null;


        try {
            // InternalMyDsl.g:3998:43: (iv_ruleMd= ruleMd EOF )
            // InternalMyDsl.g:3999:2: iv_ruleMd= ruleMd EOF
            {
             newCompositeNode(grammarAccess.getMdRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMd=ruleMd();

            state._fsp--;

             current =iv_ruleMd; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMd"


    // $ANTLR start "ruleMd"
    // InternalMyDsl.g:4005:1: ruleMd returns [EObject current=null] : (otherlv_0= 'md' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'type:' ( (lv_type_4_0= RULE_STRING ) ) otherlv_5= '}' ) ;
    public final EObject ruleMd() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_type_4_0=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalMyDsl.g:4011:2: ( (otherlv_0= 'md' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'type:' ( (lv_type_4_0= RULE_STRING ) ) otherlv_5= '}' ) )
            // InternalMyDsl.g:4012:2: (otherlv_0= 'md' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'type:' ( (lv_type_4_0= RULE_STRING ) ) otherlv_5= '}' )
            {
            // InternalMyDsl.g:4012:2: (otherlv_0= 'md' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'type:' ( (lv_type_4_0= RULE_STRING ) ) otherlv_5= '}' )
            // InternalMyDsl.g:4013:3: otherlv_0= 'md' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'type:' ( (lv_type_4_0= RULE_STRING ) ) otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,105,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getMdAccess().getMdKeyword_0());
            		
            // InternalMyDsl.g:4017:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMyDsl.g:4018:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMyDsl.g:4018:4: (lv_name_1_0= RULE_ID )
            // InternalMyDsl.g:4019:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_3); 

            					newLeafNode(lv_name_1_0, grammarAccess.getMdAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMdRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_17); 

            			newLeafNode(otherlv_2, grammarAccess.getMdAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,18,FOLLOW_67); 

            			newLeafNode(otherlv_3, grammarAccess.getMdAccess().getTypeKeyword_3());
            		
            // InternalMyDsl.g:4043:3: ( (lv_type_4_0= RULE_STRING ) )
            // InternalMyDsl.g:4044:4: (lv_type_4_0= RULE_STRING )
            {
            // InternalMyDsl.g:4044:4: (lv_type_4_0= RULE_STRING )
            // InternalMyDsl.g:4045:5: lv_type_4_0= RULE_STRING
            {
            lv_type_4_0=(Token)match(input,RULE_STRING,FOLLOW_7); 

            					newLeafNode(lv_type_4_0, grammarAccess.getMdAccess().getTypeSTRINGTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMdRule());
            					}
            					setWithLastConsumed(
            						current,
            						"type",
            						lv_type_4_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_5=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getMdAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMd"


    // $ANTLR start "entryRuleJs"
    // InternalMyDsl.g:4069:1: entryRuleJs returns [EObject current=null] : iv_ruleJs= ruleJs EOF ;
    public final EObject entryRuleJs() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJs = null;


        try {
            // InternalMyDsl.g:4069:43: (iv_ruleJs= ruleJs EOF )
            // InternalMyDsl.g:4070:2: iv_ruleJs= ruleJs EOF
            {
             newCompositeNode(grammarAccess.getJsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJs=ruleJs();

            state._fsp--;

             current =iv_ruleJs; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJs"


    // $ANTLR start "ruleJs"
    // InternalMyDsl.g:4076:1: ruleJs returns [EObject current=null] : (otherlv_0= 'js' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'type:' ( (lv_type_4_0= RULE_STRING ) ) otherlv_5= '}' ) ;
    public final EObject ruleJs() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_type_4_0=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalMyDsl.g:4082:2: ( (otherlv_0= 'js' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'type:' ( (lv_type_4_0= RULE_STRING ) ) otherlv_5= '}' ) )
            // InternalMyDsl.g:4083:2: (otherlv_0= 'js' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'type:' ( (lv_type_4_0= RULE_STRING ) ) otherlv_5= '}' )
            {
            // InternalMyDsl.g:4083:2: (otherlv_0= 'js' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'type:' ( (lv_type_4_0= RULE_STRING ) ) otherlv_5= '}' )
            // InternalMyDsl.g:4084:3: otherlv_0= 'js' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'type:' ( (lv_type_4_0= RULE_STRING ) ) otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,106,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getJsAccess().getJsKeyword_0());
            		
            // InternalMyDsl.g:4088:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMyDsl.g:4089:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMyDsl.g:4089:4: (lv_name_1_0= RULE_ID )
            // InternalMyDsl.g:4090:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_3); 

            					newLeafNode(lv_name_1_0, grammarAccess.getJsAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJsRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_17); 

            			newLeafNode(otherlv_2, grammarAccess.getJsAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,18,FOLLOW_67); 

            			newLeafNode(otherlv_3, grammarAccess.getJsAccess().getTypeKeyword_3());
            		
            // InternalMyDsl.g:4114:3: ( (lv_type_4_0= RULE_STRING ) )
            // InternalMyDsl.g:4115:4: (lv_type_4_0= RULE_STRING )
            {
            // InternalMyDsl.g:4115:4: (lv_type_4_0= RULE_STRING )
            // InternalMyDsl.g:4116:5: lv_type_4_0= RULE_STRING
            {
            lv_type_4_0=(Token)match(input,RULE_STRING,FOLLOW_7); 

            					newLeafNode(lv_type_4_0, grammarAccess.getJsAccess().getTypeSTRINGTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJsRule());
            					}
            					setWithLastConsumed(
            						current,
            						"type",
            						lv_type_4_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_5=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getJsAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJs"


    // $ANTLR start "entryRuleJson"
    // InternalMyDsl.g:4140:1: entryRuleJson returns [EObject current=null] : iv_ruleJson= ruleJson EOF ;
    public final EObject entryRuleJson() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJson = null;


        try {
            // InternalMyDsl.g:4140:45: (iv_ruleJson= ruleJson EOF )
            // InternalMyDsl.g:4141:2: iv_ruleJson= ruleJson EOF
            {
             newCompositeNode(grammarAccess.getJsonRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJson=ruleJson();

            state._fsp--;

             current =iv_ruleJson; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJson"


    // $ANTLR start "ruleJson"
    // InternalMyDsl.g:4147:1: ruleJson returns [EObject current=null] : (otherlv_0= 'json' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'type:' ( (lv_type_4_0= RULE_STRING ) ) otherlv_5= '}' ) ;
    public final EObject ruleJson() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_type_4_0=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalMyDsl.g:4153:2: ( (otherlv_0= 'json' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'type:' ( (lv_type_4_0= RULE_STRING ) ) otherlv_5= '}' ) )
            // InternalMyDsl.g:4154:2: (otherlv_0= 'json' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'type:' ( (lv_type_4_0= RULE_STRING ) ) otherlv_5= '}' )
            {
            // InternalMyDsl.g:4154:2: (otherlv_0= 'json' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'type:' ( (lv_type_4_0= RULE_STRING ) ) otherlv_5= '}' )
            // InternalMyDsl.g:4155:3: otherlv_0= 'json' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'type:' ( (lv_type_4_0= RULE_STRING ) ) otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,107,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getJsonAccess().getJsonKeyword_0());
            		
            // InternalMyDsl.g:4159:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMyDsl.g:4160:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMyDsl.g:4160:4: (lv_name_1_0= RULE_ID )
            // InternalMyDsl.g:4161:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_3); 

            					newLeafNode(lv_name_1_0, grammarAccess.getJsonAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJsonRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_17); 

            			newLeafNode(otherlv_2, grammarAccess.getJsonAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,18,FOLLOW_67); 

            			newLeafNode(otherlv_3, grammarAccess.getJsonAccess().getTypeKeyword_3());
            		
            // InternalMyDsl.g:4185:3: ( (lv_type_4_0= RULE_STRING ) )
            // InternalMyDsl.g:4186:4: (lv_type_4_0= RULE_STRING )
            {
            // InternalMyDsl.g:4186:4: (lv_type_4_0= RULE_STRING )
            // InternalMyDsl.g:4187:5: lv_type_4_0= RULE_STRING
            {
            lv_type_4_0=(Token)match(input,RULE_STRING,FOLLOW_7); 

            					newLeafNode(lv_type_4_0, grammarAccess.getJsonAccess().getTypeSTRINGTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJsonRule());
            					}
            					setWithLastConsumed(
            						current,
            						"type",
            						lv_type_4_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_5=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getJsonAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJson"


    // $ANTLR start "entryRuleCss"
    // InternalMyDsl.g:4211:1: entryRuleCss returns [EObject current=null] : iv_ruleCss= ruleCss EOF ;
    public final EObject entryRuleCss() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCss = null;


        try {
            // InternalMyDsl.g:4211:44: (iv_ruleCss= ruleCss EOF )
            // InternalMyDsl.g:4212:2: iv_ruleCss= ruleCss EOF
            {
             newCompositeNode(grammarAccess.getCssRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCss=ruleCss();

            state._fsp--;

             current =iv_ruleCss; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCss"


    // $ANTLR start "ruleCss"
    // InternalMyDsl.g:4218:1: ruleCss returns [EObject current=null] : (otherlv_0= 'css' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'type:' ( (lv_type_4_0= RULE_STRING ) ) otherlv_5= '}' ) ;
    public final EObject ruleCss() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_type_4_0=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalMyDsl.g:4224:2: ( (otherlv_0= 'css' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'type:' ( (lv_type_4_0= RULE_STRING ) ) otherlv_5= '}' ) )
            // InternalMyDsl.g:4225:2: (otherlv_0= 'css' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'type:' ( (lv_type_4_0= RULE_STRING ) ) otherlv_5= '}' )
            {
            // InternalMyDsl.g:4225:2: (otherlv_0= 'css' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'type:' ( (lv_type_4_0= RULE_STRING ) ) otherlv_5= '}' )
            // InternalMyDsl.g:4226:3: otherlv_0= 'css' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'type:' ( (lv_type_4_0= RULE_STRING ) ) otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,108,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getCssAccess().getCssKeyword_0());
            		
            // InternalMyDsl.g:4230:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMyDsl.g:4231:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMyDsl.g:4231:4: (lv_name_1_0= RULE_ID )
            // InternalMyDsl.g:4232:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_3); 

            					newLeafNode(lv_name_1_0, grammarAccess.getCssAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCssRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_17); 

            			newLeafNode(otherlv_2, grammarAccess.getCssAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,18,FOLLOW_67); 

            			newLeafNode(otherlv_3, grammarAccess.getCssAccess().getTypeKeyword_3());
            		
            // InternalMyDsl.g:4256:3: ( (lv_type_4_0= RULE_STRING ) )
            // InternalMyDsl.g:4257:4: (lv_type_4_0= RULE_STRING )
            {
            // InternalMyDsl.g:4257:4: (lv_type_4_0= RULE_STRING )
            // InternalMyDsl.g:4258:5: lv_type_4_0= RULE_STRING
            {
            lv_type_4_0=(Token)match(input,RULE_STRING,FOLLOW_7); 

            					newLeafNode(lv_type_4_0, grammarAccess.getCssAccess().getTypeSTRINGTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCssRule());
            					}
            					setWithLastConsumed(
            						current,
            						"type",
            						lv_type_4_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_5=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getCssAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCss"


    // $ANTLR start "entryRuleState"
    // InternalMyDsl.g:4282:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // InternalMyDsl.g:4282:46: (iv_ruleState= ruleState EOF )
            // InternalMyDsl.g:4283:2: iv_ruleState= ruleState EOF
            {
             newCompositeNode(grammarAccess.getStateRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleState=ruleState();

            state._fsp--;

             current =iv_ruleState; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleState"


    // $ANTLR start "ruleState"
    // InternalMyDsl.g:4289:1: ruleState returns [EObject current=null] : (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'handleAction:' ( (otherlv_4= RULE_ID ) ) )* (otherlv_5= 'handleReducer:' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= '}' ) ;
    public final EObject ruleState() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;


        	enterRule();

        try {
            // InternalMyDsl.g:4295:2: ( (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'handleAction:' ( (otherlv_4= RULE_ID ) ) )* (otherlv_5= 'handleReducer:' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= '}' ) )
            // InternalMyDsl.g:4296:2: (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'handleAction:' ( (otherlv_4= RULE_ID ) ) )* (otherlv_5= 'handleReducer:' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= '}' )
            {
            // InternalMyDsl.g:4296:2: (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'handleAction:' ( (otherlv_4= RULE_ID ) ) )* (otherlv_5= 'handleReducer:' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= '}' )
            // InternalMyDsl.g:4297:3: otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'handleAction:' ( (otherlv_4= RULE_ID ) ) )* (otherlv_5= 'handleReducer:' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,109,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getStateAccess().getStateKeyword_0());
            		
            // InternalMyDsl.g:4301:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMyDsl.g:4302:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMyDsl.g:4302:4: (lv_name_1_0= RULE_ID )
            // InternalMyDsl.g:4303:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_3); 

            					newLeafNode(lv_name_1_0, grammarAccess.getStateAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStateRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_94); 

            			newLeafNode(otherlv_2, grammarAccess.getStateAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:4323:3: (otherlv_3= 'handleAction:' ( (otherlv_4= RULE_ID ) ) )*
            loop69:
            do {
                int alt69=2;
                int LA69_0 = input.LA(1);

                if ( (LA69_0==110) ) {
                    alt69=1;
                }


                switch (alt69) {
            	case 1 :
            	    // InternalMyDsl.g:4324:4: otherlv_3= 'handleAction:' ( (otherlv_4= RULE_ID ) )
            	    {
            	    otherlv_3=(Token)match(input,110,FOLLOW_11); 

            	    				newLeafNode(otherlv_3, grammarAccess.getStateAccess().getHandleActionKeyword_3_0());
            	    			
            	    // InternalMyDsl.g:4328:4: ( (otherlv_4= RULE_ID ) )
            	    // InternalMyDsl.g:4329:5: (otherlv_4= RULE_ID )
            	    {
            	    // InternalMyDsl.g:4329:5: (otherlv_4= RULE_ID )
            	    // InternalMyDsl.g:4330:6: otherlv_4= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getStateRule());
            	    						}
            	    					
            	    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_94); 

            	    						newLeafNode(otherlv_4, grammarAccess.getStateAccess().getActionActionCrossReference_3_1_0());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop69;
                }
            } while (true);

            // InternalMyDsl.g:4342:3: (otherlv_5= 'handleReducer:' ( (otherlv_6= RULE_ID ) ) )*
            loop70:
            do {
                int alt70=2;
                int LA70_0 = input.LA(1);

                if ( (LA70_0==111) ) {
                    alt70=1;
                }


                switch (alt70) {
            	case 1 :
            	    // InternalMyDsl.g:4343:4: otherlv_5= 'handleReducer:' ( (otherlv_6= RULE_ID ) )
            	    {
            	    otherlv_5=(Token)match(input,111,FOLLOW_11); 

            	    				newLeafNode(otherlv_5, grammarAccess.getStateAccess().getHandleReducerKeyword_4_0());
            	    			
            	    // InternalMyDsl.g:4347:4: ( (otherlv_6= RULE_ID ) )
            	    // InternalMyDsl.g:4348:5: (otherlv_6= RULE_ID )
            	    {
            	    // InternalMyDsl.g:4348:5: (otherlv_6= RULE_ID )
            	    // InternalMyDsl.g:4349:6: otherlv_6= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getStateRule());
            	    						}
            	    					
            	    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_95); 

            	    						newLeafNode(otherlv_6, grammarAccess.getStateAccess().getReducerReducerCrossReference_4_1_0());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop70;
                }
            } while (true);

            otherlv_7=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getStateAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleState"


    // $ANTLR start "entryRuleAction"
    // InternalMyDsl.g:4369:1: entryRuleAction returns [EObject current=null] : iv_ruleAction= ruleAction EOF ;
    public final EObject entryRuleAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction = null;


        try {
            // InternalMyDsl.g:4369:47: (iv_ruleAction= ruleAction EOF )
            // InternalMyDsl.g:4370:2: iv_ruleAction= ruleAction EOF
            {
             newCompositeNode(grammarAccess.getActionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAction=ruleAction();

            state._fsp--;

             current =iv_ruleAction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAction"


    // $ANTLR start "ruleAction"
    // InternalMyDsl.g:4376:1: ruleAction returns [EObject current=null] : (otherlv_0= 'action' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'create:' ( (otherlv_4= RULE_ID ) ) )* (otherlv_5= 'dispatch:' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= 'actionDirectory:' ( (otherlv_8= RULE_ID ) ) otherlv_9= '}' ) ;
    public final EObject ruleAction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;


        	enterRule();

        try {
            // InternalMyDsl.g:4382:2: ( (otherlv_0= 'action' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'create:' ( (otherlv_4= RULE_ID ) ) )* (otherlv_5= 'dispatch:' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= 'actionDirectory:' ( (otherlv_8= RULE_ID ) ) otherlv_9= '}' ) )
            // InternalMyDsl.g:4383:2: (otherlv_0= 'action' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'create:' ( (otherlv_4= RULE_ID ) ) )* (otherlv_5= 'dispatch:' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= 'actionDirectory:' ( (otherlv_8= RULE_ID ) ) otherlv_9= '}' )
            {
            // InternalMyDsl.g:4383:2: (otherlv_0= 'action' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'create:' ( (otherlv_4= RULE_ID ) ) )* (otherlv_5= 'dispatch:' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= 'actionDirectory:' ( (otherlv_8= RULE_ID ) ) otherlv_9= '}' )
            // InternalMyDsl.g:4384:3: otherlv_0= 'action' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'create:' ( (otherlv_4= RULE_ID ) ) )* (otherlv_5= 'dispatch:' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= 'actionDirectory:' ( (otherlv_8= RULE_ID ) ) otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,112,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getActionAccess().getActionKeyword_0());
            		
            // InternalMyDsl.g:4388:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMyDsl.g:4389:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMyDsl.g:4389:4: (lv_name_1_0= RULE_ID )
            // InternalMyDsl.g:4390:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_3); 

            					newLeafNode(lv_name_1_0, grammarAccess.getActionAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getActionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_96); 

            			newLeafNode(otherlv_2, grammarAccess.getActionAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:4410:3: (otherlv_3= 'create:' ( (otherlv_4= RULE_ID ) ) )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==113) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // InternalMyDsl.g:4411:4: otherlv_3= 'create:' ( (otherlv_4= RULE_ID ) )
            	    {
            	    otherlv_3=(Token)match(input,113,FOLLOW_11); 

            	    				newLeafNode(otherlv_3, grammarAccess.getActionAccess().getCreateKeyword_3_0());
            	    			
            	    // InternalMyDsl.g:4415:4: ( (otherlv_4= RULE_ID ) )
            	    // InternalMyDsl.g:4416:5: (otherlv_4= RULE_ID )
            	    {
            	    // InternalMyDsl.g:4416:5: (otherlv_4= RULE_ID )
            	    // InternalMyDsl.g:4417:6: otherlv_4= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getActionRule());
            	    						}
            	    					
            	    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_96); 

            	    						newLeafNode(otherlv_4, grammarAccess.getActionAccess().getActionCreatorActionCreatorCrossReference_3_1_0());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop71;
                }
            } while (true);

            // InternalMyDsl.g:4429:3: (otherlv_5= 'dispatch:' ( (otherlv_6= RULE_ID ) ) )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==96) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // InternalMyDsl.g:4430:4: otherlv_5= 'dispatch:' ( (otherlv_6= RULE_ID ) )
            	    {
            	    otherlv_5=(Token)match(input,96,FOLLOW_11); 

            	    				newLeafNode(otherlv_5, grammarAccess.getActionAccess().getDispatchKeyword_4_0());
            	    			
            	    // InternalMyDsl.g:4434:4: ( (otherlv_6= RULE_ID ) )
            	    // InternalMyDsl.g:4435:5: (otherlv_6= RULE_ID )
            	    {
            	    // InternalMyDsl.g:4435:5: (otherlv_6= RULE_ID )
            	    // InternalMyDsl.g:4436:6: otherlv_6= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getActionRule());
            	    						}
            	    					
            	    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_97); 

            	    						newLeafNode(otherlv_6, grammarAccess.getActionAccess().getActionDispatcherActionDispatcherCrossReference_4_1_0());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop72;
                }
            } while (true);

            otherlv_7=(Token)match(input,114,FOLLOW_11); 

            			newLeafNode(otherlv_7, grammarAccess.getActionAccess().getActionDirectoryKeyword_5());
            		
            // InternalMyDsl.g:4452:3: ( (otherlv_8= RULE_ID ) )
            // InternalMyDsl.g:4453:4: (otherlv_8= RULE_ID )
            {
            // InternalMyDsl.g:4453:4: (otherlv_8= RULE_ID )
            // InternalMyDsl.g:4454:5: otherlv_8= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getActionRule());
            					}
            				
            otherlv_8=(Token)match(input,RULE_ID,FOLLOW_7); 

            					newLeafNode(otherlv_8, grammarAccess.getActionAccess().getDirDirectoryCrossReference_6_0());
            				

            }


            }

            otherlv_9=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getActionAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAction"


    // $ANTLR start "entryRuleActionCreator"
    // InternalMyDsl.g:4473:1: entryRuleActionCreator returns [EObject current=null] : iv_ruleActionCreator= ruleActionCreator EOF ;
    public final EObject entryRuleActionCreator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActionCreator = null;


        try {
            // InternalMyDsl.g:4473:54: (iv_ruleActionCreator= ruleActionCreator EOF )
            // InternalMyDsl.g:4474:2: iv_ruleActionCreator= ruleActionCreator EOF
            {
             newCompositeNode(grammarAccess.getActionCreatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleActionCreator=ruleActionCreator();

            state._fsp--;

             current =iv_ruleActionCreator; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleActionCreator"


    // $ANTLR start "ruleActionCreator"
    // InternalMyDsl.g:4480:1: ruleActionCreator returns [EObject current=null] : (otherlv_0= 'actionCreator' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'type:' ( (lv_type_4_0= RULE_STRING ) ) otherlv_5= '}' ) ;
    public final EObject ruleActionCreator() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_type_4_0=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalMyDsl.g:4486:2: ( (otherlv_0= 'actionCreator' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'type:' ( (lv_type_4_0= RULE_STRING ) ) otherlv_5= '}' ) )
            // InternalMyDsl.g:4487:2: (otherlv_0= 'actionCreator' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'type:' ( (lv_type_4_0= RULE_STRING ) ) otherlv_5= '}' )
            {
            // InternalMyDsl.g:4487:2: (otherlv_0= 'actionCreator' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'type:' ( (lv_type_4_0= RULE_STRING ) ) otherlv_5= '}' )
            // InternalMyDsl.g:4488:3: otherlv_0= 'actionCreator' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'type:' ( (lv_type_4_0= RULE_STRING ) ) otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,115,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getActionCreatorAccess().getActionCreatorKeyword_0());
            		
            // InternalMyDsl.g:4492:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMyDsl.g:4493:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMyDsl.g:4493:4: (lv_name_1_0= RULE_ID )
            // InternalMyDsl.g:4494:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_3); 

            					newLeafNode(lv_name_1_0, grammarAccess.getActionCreatorAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getActionCreatorRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_17); 

            			newLeafNode(otherlv_2, grammarAccess.getActionCreatorAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,18,FOLLOW_67); 

            			newLeafNode(otherlv_3, grammarAccess.getActionCreatorAccess().getTypeKeyword_3());
            		
            // InternalMyDsl.g:4518:3: ( (lv_type_4_0= RULE_STRING ) )
            // InternalMyDsl.g:4519:4: (lv_type_4_0= RULE_STRING )
            {
            // InternalMyDsl.g:4519:4: (lv_type_4_0= RULE_STRING )
            // InternalMyDsl.g:4520:5: lv_type_4_0= RULE_STRING
            {
            lv_type_4_0=(Token)match(input,RULE_STRING,FOLLOW_7); 

            					newLeafNode(lv_type_4_0, grammarAccess.getActionCreatorAccess().getTypeSTRINGTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getActionCreatorRule());
            					}
            					setWithLastConsumed(
            						current,
            						"type",
            						lv_type_4_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_5=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getActionCreatorAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleActionCreator"


    // $ANTLR start "entryRuleActionDispatcher"
    // InternalMyDsl.g:4544:1: entryRuleActionDispatcher returns [EObject current=null] : iv_ruleActionDispatcher= ruleActionDispatcher EOF ;
    public final EObject entryRuleActionDispatcher() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActionDispatcher = null;


        try {
            // InternalMyDsl.g:4544:57: (iv_ruleActionDispatcher= ruleActionDispatcher EOF )
            // InternalMyDsl.g:4545:2: iv_ruleActionDispatcher= ruleActionDispatcher EOF
            {
             newCompositeNode(grammarAccess.getActionDispatcherRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleActionDispatcher=ruleActionDispatcher();

            state._fsp--;

             current =iv_ruleActionDispatcher; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleActionDispatcher"


    // $ANTLR start "ruleActionDispatcher"
    // InternalMyDsl.g:4551:1: ruleActionDispatcher returns [EObject current=null] : (otherlv_0= 'actionDispatcher' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'use:' ( (otherlv_4= RULE_ID ) ) )* otherlv_5= '}' ) ;
    public final EObject ruleActionDispatcher() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalMyDsl.g:4557:2: ( (otherlv_0= 'actionDispatcher' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'use:' ( (otherlv_4= RULE_ID ) ) )* otherlv_5= '}' ) )
            // InternalMyDsl.g:4558:2: (otherlv_0= 'actionDispatcher' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'use:' ( (otherlv_4= RULE_ID ) ) )* otherlv_5= '}' )
            {
            // InternalMyDsl.g:4558:2: (otherlv_0= 'actionDispatcher' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'use:' ( (otherlv_4= RULE_ID ) ) )* otherlv_5= '}' )
            // InternalMyDsl.g:4559:3: otherlv_0= 'actionDispatcher' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'use:' ( (otherlv_4= RULE_ID ) ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,116,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getActionDispatcherAccess().getActionDispatcherKeyword_0());
            		
            // InternalMyDsl.g:4563:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMyDsl.g:4564:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMyDsl.g:4564:4: (lv_name_1_0= RULE_ID )
            // InternalMyDsl.g:4565:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_3); 

            					newLeafNode(lv_name_1_0, grammarAccess.getActionDispatcherAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getActionDispatcherRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_75); 

            			newLeafNode(otherlv_2, grammarAccess.getActionDispatcherAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:4585:3: (otherlv_3= 'use:' ( (otherlv_4= RULE_ID ) ) )*
            loop73:
            do {
                int alt73=2;
                int LA73_0 = input.LA(1);

                if ( (LA73_0==84) ) {
                    alt73=1;
                }


                switch (alt73) {
            	case 1 :
            	    // InternalMyDsl.g:4586:4: otherlv_3= 'use:' ( (otherlv_4= RULE_ID ) )
            	    {
            	    otherlv_3=(Token)match(input,84,FOLLOW_11); 

            	    				newLeafNode(otherlv_3, grammarAccess.getActionDispatcherAccess().getUseKeyword_3_0());
            	    			
            	    // InternalMyDsl.g:4590:4: ( (otherlv_4= RULE_ID ) )
            	    // InternalMyDsl.g:4591:5: (otherlv_4= RULE_ID )
            	    {
            	    // InternalMyDsl.g:4591:5: (otherlv_4= RULE_ID )
            	    // InternalMyDsl.g:4592:6: otherlv_4= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getActionDispatcherRule());
            	    						}
            	    					
            	    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_75); 

            	    						newLeafNode(otherlv_4, grammarAccess.getActionDispatcherAccess().getTypeActionCreatorCrossReference_3_1_0());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop73;
                }
            } while (true);

            otherlv_5=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getActionDispatcherAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleActionDispatcher"


    // $ANTLR start "entryRuleReducer"
    // InternalMyDsl.g:4612:1: entryRuleReducer returns [EObject current=null] : iv_ruleReducer= ruleReducer EOF ;
    public final EObject entryRuleReducer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReducer = null;


        try {
            // InternalMyDsl.g:4612:48: (iv_ruleReducer= ruleReducer EOF )
            // InternalMyDsl.g:4613:2: iv_ruleReducer= ruleReducer EOF
            {
             newCompositeNode(grammarAccess.getReducerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleReducer=ruleReducer();

            state._fsp--;

             current =iv_ruleReducer; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReducer"


    // $ANTLR start "ruleReducer"
    // InternalMyDsl.g:4619:1: ruleReducer returns [EObject current=null] : (otherlv_0= 'reducer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'catch:' ( (otherlv_4= RULE_ID ) ) )+ otherlv_5= 'reducerDirectory:' ( (otherlv_6= RULE_ID ) ) otherlv_7= '}' ) ;
    public final EObject ruleReducer() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;


        	enterRule();

        try {
            // InternalMyDsl.g:4625:2: ( (otherlv_0= 'reducer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'catch:' ( (otherlv_4= RULE_ID ) ) )+ otherlv_5= 'reducerDirectory:' ( (otherlv_6= RULE_ID ) ) otherlv_7= '}' ) )
            // InternalMyDsl.g:4626:2: (otherlv_0= 'reducer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'catch:' ( (otherlv_4= RULE_ID ) ) )+ otherlv_5= 'reducerDirectory:' ( (otherlv_6= RULE_ID ) ) otherlv_7= '}' )
            {
            // InternalMyDsl.g:4626:2: (otherlv_0= 'reducer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'catch:' ( (otherlv_4= RULE_ID ) ) )+ otherlv_5= 'reducerDirectory:' ( (otherlv_6= RULE_ID ) ) otherlv_7= '}' )
            // InternalMyDsl.g:4627:3: otherlv_0= 'reducer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'catch:' ( (otherlv_4= RULE_ID ) ) )+ otherlv_5= 'reducerDirectory:' ( (otherlv_6= RULE_ID ) ) otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,117,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getReducerAccess().getReducerKeyword_0());
            		
            // InternalMyDsl.g:4631:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMyDsl.g:4632:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMyDsl.g:4632:4: (lv_name_1_0= RULE_ID )
            // InternalMyDsl.g:4633:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_3); 

            					newLeafNode(lv_name_1_0, grammarAccess.getReducerAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReducerRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_98); 

            			newLeafNode(otherlv_2, grammarAccess.getReducerAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:4653:3: (otherlv_3= 'catch:' ( (otherlv_4= RULE_ID ) ) )+
            int cnt74=0;
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==118) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // InternalMyDsl.g:4654:4: otherlv_3= 'catch:' ( (otherlv_4= RULE_ID ) )
            	    {
            	    otherlv_3=(Token)match(input,118,FOLLOW_11); 

            	    				newLeafNode(otherlv_3, grammarAccess.getReducerAccess().getCatchKeyword_3_0());
            	    			
            	    // InternalMyDsl.g:4658:4: ( (otherlv_4= RULE_ID ) )
            	    // InternalMyDsl.g:4659:5: (otherlv_4= RULE_ID )
            	    {
            	    // InternalMyDsl.g:4659:5: (otherlv_4= RULE_ID )
            	    // InternalMyDsl.g:4660:6: otherlv_4= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getReducerRule());
            	    						}
            	    					
            	    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_99); 

            	    						newLeafNode(otherlv_4, grammarAccess.getReducerAccess().getTypeActionCreatorCrossReference_3_1_0());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt74 >= 1 ) break loop74;
                        EarlyExitException eee =
                            new EarlyExitException(74, input);
                        throw eee;
                }
                cnt74++;
            } while (true);

            otherlv_5=(Token)match(input,119,FOLLOW_11); 

            			newLeafNode(otherlv_5, grammarAccess.getReducerAccess().getReducerDirectoryKeyword_4());
            		
            // InternalMyDsl.g:4676:3: ( (otherlv_6= RULE_ID ) )
            // InternalMyDsl.g:4677:4: (otherlv_6= RULE_ID )
            {
            // InternalMyDsl.g:4677:4: (otherlv_6= RULE_ID )
            // InternalMyDsl.g:4678:5: otherlv_6= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReducerRule());
            					}
            				
            otherlv_6=(Token)match(input,RULE_ID,FOLLOW_7); 

            					newLeafNode(otherlv_6, grammarAccess.getReducerAccess().getTypeDirectoryCrossReference_5_0());
            				

            }


            }

            otherlv_7=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getReducerAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReducer"


    // $ANTLR start "entryRuleJsModule"
    // InternalMyDsl.g:4697:1: entryRuleJsModule returns [EObject current=null] : iv_ruleJsModule= ruleJsModule EOF ;
    public final EObject entryRuleJsModule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJsModule = null;


        try {
            // InternalMyDsl.g:4697:49: (iv_ruleJsModule= ruleJsModule EOF )
            // InternalMyDsl.g:4698:2: iv_ruleJsModule= ruleJsModule EOF
            {
             newCompositeNode(grammarAccess.getJsModuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJsModule=ruleJsModule();

            state._fsp--;

             current =iv_ruleJsModule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJsModule"


    // $ANTLR start "ruleJsModule"
    // InternalMyDsl.g:4704:1: ruleJsModule returns [EObject current=null] : (otherlv_0= 'module' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'presentIn:' ( (otherlv_4= RULE_ID ) ) otherlv_5= '}' ) ;
    public final EObject ruleJsModule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalMyDsl.g:4710:2: ( (otherlv_0= 'module' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'presentIn:' ( (otherlv_4= RULE_ID ) ) otherlv_5= '}' ) )
            // InternalMyDsl.g:4711:2: (otherlv_0= 'module' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'presentIn:' ( (otherlv_4= RULE_ID ) ) otherlv_5= '}' )
            {
            // InternalMyDsl.g:4711:2: (otherlv_0= 'module' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'presentIn:' ( (otherlv_4= RULE_ID ) ) otherlv_5= '}' )
            // InternalMyDsl.g:4712:3: otherlv_0= 'module' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'presentIn:' ( (otherlv_4= RULE_ID ) ) otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getJsModuleAccess().getModuleKeyword_0());
            		
            // InternalMyDsl.g:4716:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMyDsl.g:4717:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMyDsl.g:4717:4: (lv_name_1_0= RULE_ID )
            // InternalMyDsl.g:4718:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_3); 

            					newLeafNode(lv_name_1_0, grammarAccess.getJsModuleAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJsModuleRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_100); 

            			newLeafNode(otherlv_2, grammarAccess.getJsModuleAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,120,FOLLOW_11); 

            			newLeafNode(otherlv_3, grammarAccess.getJsModuleAccess().getPresentInKeyword_3());
            		
            // InternalMyDsl.g:4742:3: ( (otherlv_4= RULE_ID ) )
            // InternalMyDsl.g:4743:4: (otherlv_4= RULE_ID )
            {
            // InternalMyDsl.g:4743:4: (otherlv_4= RULE_ID )
            // InternalMyDsl.g:4744:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJsModuleRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_7); 

            					newLeafNode(otherlv_4, grammarAccess.getJsModuleAccess().getTypeDirectoryCrossReference_4_0());
            				

            }


            }

            otherlv_5=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getJsModuleAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJsModule"


    // $ANTLR start "entryRuleJsMethod"
    // InternalMyDsl.g:4763:1: entryRuleJsMethod returns [EObject current=null] : iv_ruleJsMethod= ruleJsMethod EOF ;
    public final EObject entryRuleJsMethod() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJsMethod = null;


        try {
            // InternalMyDsl.g:4763:49: (iv_ruleJsMethod= ruleJsMethod EOF )
            // InternalMyDsl.g:4764:2: iv_ruleJsMethod= ruleJsMethod EOF
            {
             newCompositeNode(grammarAccess.getJsMethodRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJsMethod=ruleJsMethod();

            state._fsp--;

             current =iv_ruleJsMethod; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJsMethod"


    // $ANTLR start "ruleJsMethod"
    // InternalMyDsl.g:4770:1: ruleJsMethod returns [EObject current=null] : (otherlv_0= 'method' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'jsMethodType:' ( (lv_type_4_0= ruleJsMethodType ) ) ( (lv_arguments_5_0= ruleJsMethodArgs ) )* (otherlv_6= 'returns:' ruleBoolean )? otherlv_8= '}' ) ;
    public final EObject ruleJsMethod() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_type_4_0 = null;

        EObject lv_arguments_5_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:4776:2: ( (otherlv_0= 'method' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'jsMethodType:' ( (lv_type_4_0= ruleJsMethodType ) ) ( (lv_arguments_5_0= ruleJsMethodArgs ) )* (otherlv_6= 'returns:' ruleBoolean )? otherlv_8= '}' ) )
            // InternalMyDsl.g:4777:2: (otherlv_0= 'method' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'jsMethodType:' ( (lv_type_4_0= ruleJsMethodType ) ) ( (lv_arguments_5_0= ruleJsMethodArgs ) )* (otherlv_6= 'returns:' ruleBoolean )? otherlv_8= '}' )
            {
            // InternalMyDsl.g:4777:2: (otherlv_0= 'method' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'jsMethodType:' ( (lv_type_4_0= ruleJsMethodType ) ) ( (lv_arguments_5_0= ruleJsMethodArgs ) )* (otherlv_6= 'returns:' ruleBoolean )? otherlv_8= '}' )
            // InternalMyDsl.g:4778:3: otherlv_0= 'method' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'jsMethodType:' ( (lv_type_4_0= ruleJsMethodType ) ) ( (lv_arguments_5_0= ruleJsMethodArgs ) )* (otherlv_6= 'returns:' ruleBoolean )? otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,121,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getJsMethodAccess().getMethodKeyword_0());
            		
            // InternalMyDsl.g:4782:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMyDsl.g:4783:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMyDsl.g:4783:4: (lv_name_1_0= RULE_ID )
            // InternalMyDsl.g:4784:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_3); 

            					newLeafNode(lv_name_1_0, grammarAccess.getJsMethodAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJsMethodRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_101); 

            			newLeafNode(otherlv_2, grammarAccess.getJsMethodAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,122,FOLLOW_102); 

            			newLeafNode(otherlv_3, grammarAccess.getJsMethodAccess().getJsMethodTypeKeyword_3());
            		
            // InternalMyDsl.g:4808:3: ( (lv_type_4_0= ruleJsMethodType ) )
            // InternalMyDsl.g:4809:4: (lv_type_4_0= ruleJsMethodType )
            {
            // InternalMyDsl.g:4809:4: (lv_type_4_0= ruleJsMethodType )
            // InternalMyDsl.g:4810:5: lv_type_4_0= ruleJsMethodType
            {

            					newCompositeNode(grammarAccess.getJsMethodAccess().getTypeJsMethodTypeParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_103);
            lv_type_4_0=ruleJsMethodType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getJsMethodRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_4_0,
            						"org.xtext.example.mydsl.MyDsl.JsMethodType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:4827:3: ( (lv_arguments_5_0= ruleJsMethodArgs ) )*
            loop75:
            do {
                int alt75=2;
                int LA75_0 = input.LA(1);

                if ( (LA75_0==128) ) {
                    alt75=1;
                }


                switch (alt75) {
            	case 1 :
            	    // InternalMyDsl.g:4828:4: (lv_arguments_5_0= ruleJsMethodArgs )
            	    {
            	    // InternalMyDsl.g:4828:4: (lv_arguments_5_0= ruleJsMethodArgs )
            	    // InternalMyDsl.g:4829:5: lv_arguments_5_0= ruleJsMethodArgs
            	    {

            	    					newCompositeNode(grammarAccess.getJsMethodAccess().getArgumentsJsMethodArgsParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_103);
            	    lv_arguments_5_0=ruleJsMethodArgs();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getJsMethodRule());
            	    					}
            	    					add(
            	    						current,
            	    						"arguments",
            	    						lv_arguments_5_0,
            	    						"org.xtext.example.mydsl.MyDsl.JsMethodArgs");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop75;
                }
            } while (true);

            // InternalMyDsl.g:4846:3: (otherlv_6= 'returns:' ruleBoolean )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==123) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // InternalMyDsl.g:4847:4: otherlv_6= 'returns:' ruleBoolean
                    {
                    otherlv_6=(Token)match(input,123,FOLLOW_70); 

                    				newLeafNode(otherlv_6, grammarAccess.getJsMethodAccess().getReturnsKeyword_6_0());
                    			

                    				newCompositeNode(grammarAccess.getJsMethodAccess().getBooleanParserRuleCall_6_1());
                    			
                    pushFollow(FOLLOW_7);
                    ruleBoolean();

                    state._fsp--;


                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;

            }

            otherlv_8=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getJsMethodAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJsMethod"


    // $ANTLR start "entryRuleJsMethodType"
    // InternalMyDsl.g:4867:1: entryRuleJsMethodType returns [String current=null] : iv_ruleJsMethodType= ruleJsMethodType EOF ;
    public final String entryRuleJsMethodType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleJsMethodType = null;


        try {
            // InternalMyDsl.g:4867:52: (iv_ruleJsMethodType= ruleJsMethodType EOF )
            // InternalMyDsl.g:4868:2: iv_ruleJsMethodType= ruleJsMethodType EOF
            {
             newCompositeNode(grammarAccess.getJsMethodTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJsMethodType=ruleJsMethodType();

            state._fsp--;

             current =iv_ruleJsMethodType.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJsMethodType"


    // $ANTLR start "ruleJsMethodType"
    // InternalMyDsl.g:4874:1: ruleJsMethodType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'reactConstructor' | kw= 'reactRender' | kw= 'reactLifecycle' | kw= 'customJsMethod' ) ;
    public final AntlrDatatypeRuleToken ruleJsMethodType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalMyDsl.g:4880:2: ( (kw= 'reactConstructor' | kw= 'reactRender' | kw= 'reactLifecycle' | kw= 'customJsMethod' ) )
            // InternalMyDsl.g:4881:2: (kw= 'reactConstructor' | kw= 'reactRender' | kw= 'reactLifecycle' | kw= 'customJsMethod' )
            {
            // InternalMyDsl.g:4881:2: (kw= 'reactConstructor' | kw= 'reactRender' | kw= 'reactLifecycle' | kw= 'customJsMethod' )
            int alt77=4;
            switch ( input.LA(1) ) {
            case 124:
                {
                alt77=1;
                }
                break;
            case 125:
                {
                alt77=2;
                }
                break;
            case 126:
                {
                alt77=3;
                }
                break;
            case 127:
                {
                alt77=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 77, 0, input);

                throw nvae;
            }

            switch (alt77) {
                case 1 :
                    // InternalMyDsl.g:4882:3: kw= 'reactConstructor'
                    {
                    kw=(Token)match(input,124,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getJsMethodTypeAccess().getReactConstructorKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:4888:3: kw= 'reactRender'
                    {
                    kw=(Token)match(input,125,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getJsMethodTypeAccess().getReactRenderKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:4894:3: kw= 'reactLifecycle'
                    {
                    kw=(Token)match(input,126,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getJsMethodTypeAccess().getReactLifecycleKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:4900:3: kw= 'customJsMethod'
                    {
                    kw=(Token)match(input,127,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getJsMethodTypeAccess().getCustomJsMethodKeyword_3());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJsMethodType"


    // $ANTLR start "entryRuleJsMethodArgs"
    // InternalMyDsl.g:4909:1: entryRuleJsMethodArgs returns [EObject current=null] : iv_ruleJsMethodArgs= ruleJsMethodArgs EOF ;
    public final EObject entryRuleJsMethodArgs() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJsMethodArgs = null;


        try {
            // InternalMyDsl.g:4909:53: (iv_ruleJsMethodArgs= ruleJsMethodArgs EOF )
            // InternalMyDsl.g:4910:2: iv_ruleJsMethodArgs= ruleJsMethodArgs EOF
            {
             newCompositeNode(grammarAccess.getJsMethodArgsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJsMethodArgs=ruleJsMethodArgs();

            state._fsp--;

             current =iv_ruleJsMethodArgs; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJsMethodArgs"


    // $ANTLR start "ruleJsMethodArgs"
    // InternalMyDsl.g:4916:1: ruleJsMethodArgs returns [EObject current=null] : (otherlv_0= 'jsmethodArgument' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleJsMethodArgs() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalMyDsl.g:4922:2: ( (otherlv_0= 'jsmethodArgument' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalMyDsl.g:4923:2: (otherlv_0= 'jsmethodArgument' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalMyDsl.g:4923:2: (otherlv_0= 'jsmethodArgument' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalMyDsl.g:4924:3: otherlv_0= 'jsmethodArgument' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,128,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getJsMethodArgsAccess().getJsmethodArgumentKeyword_0());
            		
            // InternalMyDsl.g:4928:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMyDsl.g:4929:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMyDsl.g:4929:4: (lv_name_1_0= RULE_ID )
            // InternalMyDsl.g:4930:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getJsMethodArgsAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJsMethodArgsRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJsMethodArgs"


    // $ANTLR start "entryRuleAxiosRequest"
    // InternalMyDsl.g:4950:1: entryRuleAxiosRequest returns [EObject current=null] : iv_ruleAxiosRequest= ruleAxiosRequest EOF ;
    public final EObject entryRuleAxiosRequest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAxiosRequest = null;


        try {
            // InternalMyDsl.g:4950:53: (iv_ruleAxiosRequest= ruleAxiosRequest EOF )
            // InternalMyDsl.g:4951:2: iv_ruleAxiosRequest= ruleAxiosRequest EOF
            {
             newCompositeNode(grammarAccess.getAxiosRequestRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAxiosRequest=ruleAxiosRequest();

            state._fsp--;

             current =iv_ruleAxiosRequest; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAxiosRequest"


    // $ANTLR start "ruleAxiosRequest"
    // InternalMyDsl.g:4957:1: ruleAxiosRequest returns [EObject current=null] : (otherlv_0= 'axiosRequest' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'restMethod:' ( ( (lv_axiosRestMethod_4_1= 'getMethod' | lv_axiosRestMethod_4_2= 'postMethod' ) ) ) otherlv_5= 'URL:' ( (lv_url_6_0= RULE_STRING ) ) (otherlv_7= 'data:' ( (lv_data_8_0= ruleJsMethodArgs ) ) )? otherlv_9= '}' ) ;
    public final EObject ruleAxiosRequest() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_axiosRestMethod_4_1=null;
        Token lv_axiosRestMethod_4_2=null;
        Token otherlv_5=null;
        Token lv_url_6_0=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_data_8_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:4963:2: ( (otherlv_0= 'axiosRequest' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'restMethod:' ( ( (lv_axiosRestMethod_4_1= 'getMethod' | lv_axiosRestMethod_4_2= 'postMethod' ) ) ) otherlv_5= 'URL:' ( (lv_url_6_0= RULE_STRING ) ) (otherlv_7= 'data:' ( (lv_data_8_0= ruleJsMethodArgs ) ) )? otherlv_9= '}' ) )
            // InternalMyDsl.g:4964:2: (otherlv_0= 'axiosRequest' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'restMethod:' ( ( (lv_axiosRestMethod_4_1= 'getMethod' | lv_axiosRestMethod_4_2= 'postMethod' ) ) ) otherlv_5= 'URL:' ( (lv_url_6_0= RULE_STRING ) ) (otherlv_7= 'data:' ( (lv_data_8_0= ruleJsMethodArgs ) ) )? otherlv_9= '}' )
            {
            // InternalMyDsl.g:4964:2: (otherlv_0= 'axiosRequest' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'restMethod:' ( ( (lv_axiosRestMethod_4_1= 'getMethod' | lv_axiosRestMethod_4_2= 'postMethod' ) ) ) otherlv_5= 'URL:' ( (lv_url_6_0= RULE_STRING ) ) (otherlv_7= 'data:' ( (lv_data_8_0= ruleJsMethodArgs ) ) )? otherlv_9= '}' )
            // InternalMyDsl.g:4965:3: otherlv_0= 'axiosRequest' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'restMethod:' ( ( (lv_axiosRestMethod_4_1= 'getMethod' | lv_axiosRestMethod_4_2= 'postMethod' ) ) ) otherlv_5= 'URL:' ( (lv_url_6_0= RULE_STRING ) ) (otherlv_7= 'data:' ( (lv_data_8_0= ruleJsMethodArgs ) ) )? otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,129,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getAxiosRequestAccess().getAxiosRequestKeyword_0());
            		
            // InternalMyDsl.g:4969:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMyDsl.g:4970:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMyDsl.g:4970:4: (lv_name_1_0= RULE_ID )
            // InternalMyDsl.g:4971:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_3); 

            					newLeafNode(lv_name_1_0, grammarAccess.getAxiosRequestAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAxiosRequestRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_104); 

            			newLeafNode(otherlv_2, grammarAccess.getAxiosRequestAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,130,FOLLOW_105); 

            			newLeafNode(otherlv_3, grammarAccess.getAxiosRequestAccess().getRestMethodKeyword_3());
            		
            // InternalMyDsl.g:4995:3: ( ( (lv_axiosRestMethod_4_1= 'getMethod' | lv_axiosRestMethod_4_2= 'postMethod' ) ) )
            // InternalMyDsl.g:4996:4: ( (lv_axiosRestMethod_4_1= 'getMethod' | lv_axiosRestMethod_4_2= 'postMethod' ) )
            {
            // InternalMyDsl.g:4996:4: ( (lv_axiosRestMethod_4_1= 'getMethod' | lv_axiosRestMethod_4_2= 'postMethod' ) )
            // InternalMyDsl.g:4997:5: (lv_axiosRestMethod_4_1= 'getMethod' | lv_axiosRestMethod_4_2= 'postMethod' )
            {
            // InternalMyDsl.g:4997:5: (lv_axiosRestMethod_4_1= 'getMethod' | lv_axiosRestMethod_4_2= 'postMethod' )
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==131) ) {
                alt78=1;
            }
            else if ( (LA78_0==132) ) {
                alt78=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 78, 0, input);

                throw nvae;
            }
            switch (alt78) {
                case 1 :
                    // InternalMyDsl.g:4998:6: lv_axiosRestMethod_4_1= 'getMethod'
                    {
                    lv_axiosRestMethod_4_1=(Token)match(input,131,FOLLOW_106); 

                    						newLeafNode(lv_axiosRestMethod_4_1, grammarAccess.getAxiosRequestAccess().getAxiosRestMethodGetMethodKeyword_4_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAxiosRequestRule());
                    						}
                    						setWithLastConsumed(current, "axiosRestMethod", lv_axiosRestMethod_4_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:5009:6: lv_axiosRestMethod_4_2= 'postMethod'
                    {
                    lv_axiosRestMethod_4_2=(Token)match(input,132,FOLLOW_106); 

                    						newLeafNode(lv_axiosRestMethod_4_2, grammarAccess.getAxiosRequestAccess().getAxiosRestMethodPostMethodKeyword_4_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAxiosRequestRule());
                    						}
                    						setWithLastConsumed(current, "axiosRestMethod", lv_axiosRestMethod_4_2, null);
                    					

                    }
                    break;

            }


            }


            }

            otherlv_5=(Token)match(input,133,FOLLOW_67); 

            			newLeafNode(otherlv_5, grammarAccess.getAxiosRequestAccess().getURLKeyword_5());
            		
            // InternalMyDsl.g:5026:3: ( (lv_url_6_0= RULE_STRING ) )
            // InternalMyDsl.g:5027:4: (lv_url_6_0= RULE_STRING )
            {
            // InternalMyDsl.g:5027:4: (lv_url_6_0= RULE_STRING )
            // InternalMyDsl.g:5028:5: lv_url_6_0= RULE_STRING
            {
            lv_url_6_0=(Token)match(input,RULE_STRING,FOLLOW_107); 

            					newLeafNode(lv_url_6_0, grammarAccess.getAxiosRequestAccess().getUrlSTRINGTerminalRuleCall_6_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAxiosRequestRule());
            					}
            					setWithLastConsumed(
            						current,
            						"url",
            						lv_url_6_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalMyDsl.g:5044:3: (otherlv_7= 'data:' ( (lv_data_8_0= ruleJsMethodArgs ) ) )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==134) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // InternalMyDsl.g:5045:4: otherlv_7= 'data:' ( (lv_data_8_0= ruleJsMethodArgs ) )
                    {
                    otherlv_7=(Token)match(input,134,FOLLOW_108); 

                    				newLeafNode(otherlv_7, grammarAccess.getAxiosRequestAccess().getDataKeyword_7_0());
                    			
                    // InternalMyDsl.g:5049:4: ( (lv_data_8_0= ruleJsMethodArgs ) )
                    // InternalMyDsl.g:5050:5: (lv_data_8_0= ruleJsMethodArgs )
                    {
                    // InternalMyDsl.g:5050:5: (lv_data_8_0= ruleJsMethodArgs )
                    // InternalMyDsl.g:5051:6: lv_data_8_0= ruleJsMethodArgs
                    {

                    						newCompositeNode(grammarAccess.getAxiosRequestAccess().getDataJsMethodArgsParserRuleCall_7_1_0());
                    					
                    pushFollow(FOLLOW_7);
                    lv_data_8_0=ruleJsMethodArgs();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAxiosRequestRule());
                    						}
                    						set(
                    							current,
                    							"data",
                    							lv_data_8_0,
                    							"org.xtext.example.mydsl.MyDsl.JsMethodArgs");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getAxiosRequestAccess().getRightCurlyBracketKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAxiosRequest"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000001008000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000021008000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000020002000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000002420000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000002402000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000004000010L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000004002000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000082000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0080000400000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0080000000002000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000001800000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000002000002000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x000001C000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000020000002000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x000FF80000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0010000000003000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000040000002000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0010000000002000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0060000000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x1000000000002000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0100000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0100000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000002000L,0x0000000000000200L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x4000000000002000L,0x0000000000000128L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x4000000000002000L,0x0000000000000120L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x4000000000002000L,0x0000000000000100L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000002000L,0x0000000000000100L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x4000000000002000L,0x000000000000002BL});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x4000000000002000L,0x0000000000000023L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x4000000000002000L,0x0000000000000003L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000002000L,0x0000000000000002L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000002000L,0x0000000000000028L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000002000L,0x0000000000000020L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0xA000000000002000L,0x0000000000000804L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000002000L,0x00000000000000C0L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000002000L,0x0000000000001000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000000000L,0x0000000000018000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000001008000L,0x00393E2C90220000L,0x0000000000000002L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000001008000L,0x00393E2C90260000L,0x0000000000000002L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000000000L,0x00000000000C0000L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000000000L,0x0000000000180000L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000000000002000L,0x0000000000100000L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000000000000000L,0x0000000001C00000L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000000000000000L,0x0000000001800000L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000000000000000L,0x000000000F000000L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000000000000000L,0x000000000E000000L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0000000000000000L,0x000000000C000000L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x0000000000000000L,0x0000000300100000L});
    public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x0000000000000000L,0x0000000200100000L});
    public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0000000000000000L,0x0200000000100000L});
    public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x0000000000002000L,0x0200000000000000L});
    public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_89 = new BitSet(new long[]{0x0000000001008000L,0x00393E3C90220000L,0x0000000000000002L});
    public static final BitSet FOLLOW_90 = new BitSet(new long[]{0x000000000100A000L,0x00393E2C90220000L,0x0000000000000002L});
    public static final BitSet FOLLOW_91 = new BitSet(new long[]{0x0000000000000000L,0x000001C000000000L});
    public static final BitSet FOLLOW_92 = new BitSet(new long[]{0x0000000000000010L,0x0000004000000000L});
    public static final BitSet FOLLOW_93 = new BitSet(new long[]{0x0000000000000000L,0x0000018000000000L});
    public static final BitSet FOLLOW_94 = new BitSet(new long[]{0x0000000000002000L,0x0000C00000000000L});
    public static final BitSet FOLLOW_95 = new BitSet(new long[]{0x0000000000002000L,0x0000800000000000L});
    public static final BitSet FOLLOW_96 = new BitSet(new long[]{0x0000000000000000L,0x0006000100000000L});
    public static final BitSet FOLLOW_97 = new BitSet(new long[]{0x0000000000000000L,0x0004000100000000L});
    public static final BitSet FOLLOW_98 = new BitSet(new long[]{0x0000000000000000L,0x0040000000000000L});
    public static final BitSet FOLLOW_99 = new BitSet(new long[]{0x0000000000000000L,0x00C0000000000000L});
    public static final BitSet FOLLOW_100 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_101 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_102 = new BitSet(new long[]{0x0000000000000000L,0xF000000000000000L});
    public static final BitSet FOLLOW_103 = new BitSet(new long[]{0x0000000000002000L,0x0800000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_104 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_105 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000018L});
    public static final BitSet FOLLOW_106 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_107 = new BitSet(new long[]{0x0000000000002000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_108 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000001L});

}