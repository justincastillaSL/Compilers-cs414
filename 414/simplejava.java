/* Generated By:JavaCC: Do not edit this line. simplejava.java */
public class simplejava implements simplejavaConstants {

/*
1. Array []s are off for all the tests test02, test06, test09, test11 and possibly more
2. y = y + 1 doesn't even get output  test04
3. test08 seriously bad
4. test09 missing a bunch of if statements
5. test10 missing 2 for loops and a couple of function calls
DONE
*/
  static final public ASTProgram program() throws ParseException {
  Token t;
  ASTClasses classes = new ASTClasses();
  ASTClass class_v;
  ASTFunctionDefinitions functionDefinitions = new ASTFunctionDefinitions();
  ASTFunctionDefinition functionDefinition;
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case CLASS:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      class_v = classDef();
      classes.addElement(class_v);
    }
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ID:
        ;
        break;
      default:
        jj_la1[1] = jj_gen;
        break label_2;
      }
      functionDefinition = functionDef();
      functionDefinitions.addElement(functionDefinition);
    }
    t = jj_consume_token(0);
    {if (true) return new ASTProgram(classes, functionDefinitions, t.beginLine);}
    throw new Error("Missing return statement in function");
  }

/*
DONE
*/
  static final public ASTClass classDef() throws ParseException {
  Token t;
  ASTInstanceVariableDefs instanceVariableDefs = new ASTInstanceVariableDefs();
  ASTInstanceVariableDef instanceVariableDef;
    jj_consume_token(CLASS);
    t = jj_consume_token(ID);
    jj_consume_token(LB);
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ID:
        ;
        break;
      default:
        jj_la1[2] = jj_gen;
        break label_3;
      }
      instanceVariableDef = varDecl();
      instanceVariableDefs.addElement(instanceVariableDef);
    }
    jj_consume_token(RB);
    {if (true) return new ASTClass(t.image, instanceVariableDefs, t.beginLine);}
    throw new Error("Missing return statement in function");
  }

/*
DONE
*/
  static final public ASTInstanceVariableDef varDecl() throws ParseException {
  Token type;
  Token name;
  int dimension = 0;
  ASTInstanceVariableDef instanceVariableDef;
  ASTExpression e;
    type = jj_consume_token(ID);
    name = jj_consume_token(ID);
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LBKT:
        ;
        break;
      default:
        jj_la1[3] = jj_gen;
        break label_4;
      }
      jj_consume_token(LBKT);
      jj_consume_token(RBKT);
                                                  dimension++;
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case GETS:
      jj_consume_token(GETS);
      e = expression();
      break;
    default:
      jj_la1[4] = jj_gen;
      ;
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case SEMI:
      jj_consume_token(SEMI);
      break;
    default:
      jj_la1[5] = jj_gen;
      ;
    }
    if(dimension != 0)
    {
      instanceVariableDef = new ASTInstanceVariableDef(type.image, name.image, dimension, type.beginLine);
      dimension = 0;
    }
    else
    {
      instanceVariableDef = new ASTInstanceVariableDef(type.image, name.image, type.beginLine);
    }
    {if (true) return instanceVariableDef;}
    throw new Error("Missing return statement in function");
  }

/*
DONE
*/
  static final public ASTFunctionDefinition functionDef() throws ParseException {
  Token type;
  Token name;
  ASTFormals formals_v = new ASTFormals();
  ASTStatements statements_v = new ASTStatements();
  ASTStatement statement_v;
  ASTPrototype prototype;
  ASTFunction function;
    type = jj_consume_token(ID);
    name = jj_consume_token(ID);
    jj_consume_token(LP);
      formals_v = formals();
    jj_consume_token(RP);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case SEMI:
      jj_consume_token(SEMI);
      prototype = new ASTPrototype(type.image, name.image, formals_v, type.beginLine);
      {if (true) return prototype;}
      break;
    case LB:
      jj_consume_token(LB);
      label_5:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case DO:
        case FOR:
        case IF:
        case WHILE:
        case RETURN:
        case LB:
        case SEMI:
        case ID:
          ;
          break;
        default:
          jj_la1[6] = jj_gen;
          break label_5;
        }
        statement_v = statement();
                        statements_v.addElement(statement_v);
      }
      jj_consume_token(RB);
    function = new ASTFunction(type.image, name.image, formals_v, statements_v, type.beginLine);
    {if (true) return function;}
      break;
    default:
      jj_la1[7] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

/*
DONE
*/
  static final public ASTFormals formals() throws ParseException {
 ASTFormals formals_v = new ASTFormals();
 ASTFormal formal_v;
 int dimension = 0;
 Token type, name;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ID:
      type = jj_consume_token(ID);
      name = jj_consume_token(ID);
      label_6:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case LBKT:
          ;
          break;
        default:
          jj_la1[8] = jj_gen;
          break label_6;
        }
        jj_consume_token(LBKT);
        jj_consume_token(RBKT);
                                                    dimension++;
      }
                if(dimension != 0){
                        formal_v = new ASTFormal(type.image, name.image, dimension, type.beginLine);
                }
                else{
                        formal_v = new ASTFormal(type.image, name.image, type.beginLine);
                }
                formals_v.addElement(formal_v);
                dimension=0;
      label_7:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case COMMA:
          ;
          break;
        default:
          jj_la1[9] = jj_gen;
          break label_7;
        }
        jj_consume_token(COMMA);
        type = jj_consume_token(ID);
        name = jj_consume_token(ID);
        label_8:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case LBKT:
            ;
            break;
          default:
            jj_la1[10] = jj_gen;
            break label_8;
          }
          jj_consume_token(LBKT);
          jj_consume_token(RBKT);
                                                               dimension++;
        }
                        if(dimension != 0){
                                formal_v = new ASTFormal(type.image, name.image, dimension, type.beginLine);
                        }
                        else{
                                formal_v = new ASTFormal(type.image, name.image, type.beginLine);
                        }
                        formals_v.addElement(formal_v);
                        dimension=0;
      }
          {if (true) return formals_v;}
      break;
    default:
      jj_la1[11] = jj_gen;

  {if (true) return formals_v;}
    }
    throw new Error("Missing return statement in function");
  }

/*
DONE
*/
  static final public ASTExpression expression() throws ParseException {
  ASTExpression result;
  ASTExpression rhs;
  Token t;
    result = expression2();
    label_9:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case OR:
        ;
        break;
      default:
        jj_la1[12] = jj_gen;
        break label_9;
      }
      t = jj_consume_token(OR);
      rhs = expression2();
      result = new ASTOperatorExpression(result, rhs, t.image, t.beginLine);
    }
    {if (true) return result;}
    throw new Error("Missing return statement in function");
  }

/*
DONE
*/
  static final public ASTExpression expression2() throws ParseException {
  ASTExpression result;
  ASTExpression rhs;
  Token t;
    result = expression3();
    label_10:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case AND:
        ;
        break;
      default:
        jj_la1[13] = jj_gen;
        break label_10;
      }
      t = jj_consume_token(AND);
      rhs = expression3();
      result = new ASTOperatorExpression(result, rhs, t.image, t.beginLine);
    }
    {if (true) return result;}
    throw new Error("Missing return statement in function");
  }

/*
DONE
*/
  static final public ASTExpression expression3() throws ParseException {
  ASTExpression result;
  ASTExpression rhs;
  Token t;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NOT:
      t = jj_consume_token(NOT);
      result = expression3();
      result = new ASTUnaryOperatorExpression(result, ASTUnaryOperatorExpression.NOT, t.beginLine);
      {if (true) return result;}
      break;
    case FALSE:
    case TRUE:
    case NEW:
    case MINUS:
    case LP:
    case ID:
    case INTEGER_LITERAL:
      result = expression4();
      {if (true) return result;}
      break;
    default:
      jj_la1[14] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

/*
DONE
*/
  static final public ASTExpression expression4() throws ParseException {
  ASTExpression result;
  ASTExpression rhs;
  Token t;
    result = expression5();
    label_11:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case EQUAL:
      case NOTEQUAL:
      case LESS:
      case GREAT:
      case LEQUAL:
      case GEQUAL:
        ;
        break;
      default:
        jj_la1[15] = jj_gen;
        break label_11;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case EQUAL:
        t = jj_consume_token(EQUAL);
        break;
      case NOTEQUAL:
        t = jj_consume_token(NOTEQUAL);
        break;
      case LEQUAL:
        t = jj_consume_token(LEQUAL);
        break;
      case GEQUAL:
        t = jj_consume_token(GEQUAL);
        break;
      case LESS:
        t = jj_consume_token(LESS);
        break;
      case GREAT:
        t = jj_consume_token(GREAT);
        break;
      default:
        jj_la1[16] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      rhs = expression5();
      result = new ASTOperatorExpression(result, rhs, t.image, t.beginLine);
    }
    {if (true) return result;}
    throw new Error("Missing return statement in function");
  }

/*
DONE
*/
  static final public ASTExpression expression5() throws ParseException {
  ASTExpression result;
  Token t;
  ASTExpression rhs;
    result = expression6();
    label_12:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
      case MINUS:
        ;
        break;
      default:
        jj_la1[17] = jj_gen;
        break label_12;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
        t = jj_consume_token(PLUS);
        break;
      case MINUS:
        t = jj_consume_token(MINUS);
        break;
      default:
        jj_la1[18] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      rhs = expression6();
      result = new ASTOperatorExpression(result, rhs, t.image, t.beginLine);
    }
    {if (true) return result;}
    throw new Error("Missing return statement in function");
  }

/*
DONE
*/
  static final public ASTExpression expression6() throws ParseException {
  ASTExpression result;
  Token t;
  ASTExpression rhs;
    result = factor();
    label_13:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MULT:
      case DIVIDE:
        ;
        break;
      default:
        jj_la1[19] = jj_gen;
        break label_13;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MULT:
        t = jj_consume_token(MULT);
        break;
      case DIVIDE:
        t = jj_consume_token(DIVIDE);
        break;
      default:
        jj_la1[20] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      rhs = factor();
      result = new ASTOperatorExpression(result, rhs, t.image, t.beginLine);
    }
    {if (true) return result;}
    throw new Error("Missing return statement in function");
  }

/*
DONE
*/
  static final public ASTExpression factor() throws ParseException {
  ASTExpression e;
  ASTExpression value;
  Token t;
  int dimension = 0;
  Token name;
  ASTVariable var;
  ASTFunctionCallExpression fc;
  ASTExpression newExp;
  ASTNewClassExpression ce;
  ASTNewClassExpression ae;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INTEGER_LITERAL:
      t = jj_consume_token(INTEGER_LITERAL);
    {if (true) return new ASTIntegerLiteral(Integer.parseInt(t.image), t.beginLine);}
      break;
    case MINUS:
      t = jj_consume_token(MINUS);
      value = factor();
    {if (true) return new ASTOperatorExpression(new ASTIntegerLiteral(0, t.beginLine), value, ASTOperatorExpression.MINUS, t.beginLine);}
      break;
    case LP:
      t = jj_consume_token(LP);
      e = expression();
      jj_consume_token(RP);
    {if (true) return e;}
      break;
    case TRUE:
      t = jj_consume_token(TRUE);
    {if (true) return new ASTBooleanLiteral(true, t.beginLine);}
      break;
    case FALSE:
      t = jj_consume_token(FALSE);
    {if (true) return new ASTBooleanLiteral(false, t.beginLine);}
      break;
    case ID:
      t = jj_consume_token(ID);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LP:
    fc = new ASTFunctionCallExpression(t.image, t.beginLine);
        jj_consume_token(LP);
        fc = actuals(fc);
        jj_consume_token(RP);
      {if (true) return fc;}
        break;
      default:
        jj_la1[23] = jj_gen;
                var = new ASTBaseVariable(t.image, t.beginLine);
        label_14:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case DOT:
          case LBKT:
            ;
            break;
          default:
            jj_la1[21] = jj_gen;
            break label_14;
          }
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case DOT:
            jj_consume_token(DOT);
            name = jj_consume_token(ID);
                var = new ASTClassVariable(var, name.image, t.beginLine);
            break;
          case LBKT:
            jj_consume_token(LBKT);
            e = expression();
            jj_consume_token(RBKT);
        var = new ASTArrayVariable(var, e, t.beginLine);
            break;
          default:
            jj_la1[22] = jj_gen;
            jj_consume_token(-1);
            throw new ParseException();
          }
        }
      {if (true) return new ASTVariableExpression(var, t.beginLine);}
      }
      break;
    case NEW:
      jj_consume_token(NEW);
      t = jj_consume_token(ID);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LP:
        jj_consume_token(LP);
        jj_consume_token(RP);
              newExp = new ASTNewClassExpression(t.image, t.beginLine);
        break;
      case LBKT:
        jj_consume_token(LBKT);
        e = expression();
        jj_consume_token(RBKT);
        label_15:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case LBKT:
            ;
            break;
          default:
            jj_la1[24] = jj_gen;
            break label_15;
          }
          jj_consume_token(LBKT);
          jj_consume_token(RBKT);
                dimension++;
        }
                      if(dimension != 0)
                      {
                        newExp = new ASTNewArrayExpression(t.image, e, dimension, t.beginLine);
                        dimension = 0;
                      }
                      else
                      {
                        newExp = new ASTNewArrayExpression(t.image, e, t.beginLine);
                      }
        break;
      default:
        jj_la1[25] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
            {if (true) return newExp;}
      break;
    default:
      jj_la1[26] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

/*
I think this is messed up
*/
  static final public ASTStatement subset() throws ParseException {
  ASTStatement stmt;
  Token t;
  ASTExpression retExp = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case RETURN:
      t = jj_consume_token(RETURN);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case FALSE:
      case TRUE:
      case NEW:
      case MINUS:
      case LP:
      case NOT:
      case ID:
      case INTEGER_LITERAL:
        retExp = expression();
        break;
      default:
        jj_la1[27] = jj_gen;
        ;
      }
  {if (true) return new ASTReturnStatement(retExp, t.beginLine);}
      break;
    case ID:
      t = jj_consume_token(ID);
      stmt = statementPrime(t);
  {if (true) return stmt;}
      break;
    default:
      jj_la1[28] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

/*
DONE
*/
  static final public ASTStatement statement() throws ParseException {
  ASTStatements statement_v = new ASTStatements();
  ASTStatement stmt = new ASTEmptyStatement(0);
  ASTStatement body;
  ASTStatement initialize = new ASTEmptyStatement(0);
  ASTStatement increment = new ASTEmptyStatement(0);
  ASTExpression e;
  ASTStatement thenstatement;
  ASTStatement elsestatement;
  Token t;
  ASTExpression retExp = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LB:
      t = jj_consume_token(LB);
      label_16:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case DO:
        case FOR:
        case IF:
        case WHILE:
        case RETURN:
        case LB:
        case SEMI:
        case ID:
          ;
          break;
        default:
          jj_la1[29] = jj_gen;
          break label_16;
        }
        stmt = statement();
    statement_v.addElement(stmt);
      }
      jj_consume_token(RB);
    {if (true) return statement_v;}
      break;
    case IF:
      t = jj_consume_token(IF);
      jj_consume_token(LP);
      e = expression();
      jj_consume_token(RP);
      thenstatement = statement();
      elsestatement = optionalelse();
  {if (true) return new ASTIfStatement(e, thenstatement, elsestatement, t.beginLine);}
      break;
    case WHILE:
      t = jj_consume_token(WHILE);
      jj_consume_token(LP);
      e = expression();
      jj_consume_token(RP);
      body = statement();
  {if (true) return new ASTWhileStatement(e, body, t.beginLine);}
      break;
    case DO:
      t = jj_consume_token(DO);
      body = statement();
      jj_consume_token(WHILE);
      jj_consume_token(LP);
      e = expression();
      jj_consume_token(RP);
      jj_consume_token(SEMI);
  {if (true) return new ASTDoWhileStatement(e, body, t.beginLine);}
      break;
    case FOR:
      t = jj_consume_token(FOR);
      jj_consume_token(LP);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case RETURN:
      case ID:
        initialize = subset();
        break;
      default:
        jj_la1[30] = jj_gen;
        ;
      }
      jj_consume_token(SEMI);
      e = expression();
      jj_consume_token(SEMI);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case RETURN:
      case ID:
        increment = subset();
        break;
      default:
        jj_la1[31] = jj_gen;
        ;
      }
      jj_consume_token(RP);
      body = statement();
  {if (true) return new ASTForStatement(initialize, e, increment, body, t.beginLine);}
      break;
    case RETURN:
      t = jj_consume_token(RETURN);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case FALSE:
      case TRUE:
      case NEW:
      case MINUS:
      case LP:
      case NOT:
      case ID:
      case INTEGER_LITERAL:
        retExp = expression();
        break;
      default:
        jj_la1[32] = jj_gen;
        ;
      }
      jj_consume_token(SEMI);
  {if (true) return new ASTReturnStatement(retExp, t.beginLine);}
      break;
    case ID:
      t = jj_consume_token(ID);
      stmt = statementPrime(t);
      jj_consume_token(SEMI);
  {if (true) return stmt;}
      break;
    case SEMI:
      t = jj_consume_token(SEMI);
  {if (true) return new ASTEmptyStatement(t.beginLine);}
      break;
    default:
      jj_la1[33] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public ASTStatement statementPrime(Token type) throws ParseException {
       ASTVariable statement_v;
       ASTExpression e = null;
       ASTVariableDefStatement varDef;
       Token name;
       int dimension =0;
       int flag = 0;
       ASTBaseVariable base;
       ASTExpression e1;
       ASTOperatorExpression change;
       Token t;
       ASTFunctionCallStatement fc;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ID:
      name = jj_consume_token(ID);
      label_17:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case LBKT:
          ;
          break;
        default:
          jj_la1[34] = jj_gen;
          break label_17;
        }
        jj_consume_token(LBKT);
        jj_consume_token(RBKT);
                                  dimension++;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case GETS:
        jj_consume_token(GETS);
        e = expression();
                                                                              flag = 1;
        break;
      default:
        jj_la1[35] = jj_gen;
        ;
      }
   if (dimension > 0 && flag > 0)
   {
      varDef = new ASTVariableDefStatement(type.image, name.image, dimension, e, type.beginLine);
   }
   else  if (dimension > 0 && flag == 0)
   {
      varDef = new ASTVariableDefStatement(type.image, name.image, dimension, type.beginLine);
   }
   else  if (dimension == 0 && flag > 0)
   {
      varDef = new ASTVariableDefStatement(type.image, name.image, e, type.beginLine);
   }
   else
   {
      varDef = new ASTVariableDefStatement(type.image, name.image, type.beginLine);
   }
   dimension = 0;
   {if (true) return varDef;}
      break;
    case DOT:
    case LBKT:
    case INCR:
    case DECR:
    case GETS:
                statement_v = new ASTBaseVariable(type.image, type.beginLine);
      label_18:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case DOT:
        case LBKT:
          ;
          break;
        default:
          jj_la1[36] = jj_gen;
          break label_18;
        }
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case DOT:
          jj_consume_token(DOT);
          name = jj_consume_token(ID);
                statement_v = new ASTClassVariable(statement_v, name.image, type.beginLine);
          break;
        case LBKT:
          jj_consume_token(LBKT);
          e = expression();
          jj_consume_token(RBKT);
          statement_v = new ASTArrayVariable(statement_v, e, type.beginLine);
          break;
        default:
          jj_la1[37] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case GETS:
        t = jj_consume_token(GETS);
        e = expression();
                {if (true) return new ASTAssignmentStatement(statement_v, e, t.beginLine);}
        break;
      case INCR:
      case DECR:
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case INCR:
          t = jj_consume_token(INCR);
                e1 = new ASTVariableExpression(statement_v, type.beginLine);
                change = new ASTOperatorExpression(e1, new ASTIntegerLiteral(1, t.beginLine), ASTOperatorExpression.PLUS, t.beginLine);
                {if (true) return new ASTAssignmentStatement(statement_v, change, type.beginLine);}
          break;
        case DECR:
          t = jj_consume_token(DECR);
                e1 = new ASTVariableExpression(statement_v, type.beginLine);
                change = new ASTOperatorExpression(e1, new ASTIntegerLiteral(1, t.beginLine), ASTOperatorExpression.MINUS, t.beginLine);
                {if (true) return new ASTAssignmentStatement(statement_v, change, type.beginLine);}
          break;
        default:
          jj_la1[38] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
      default:
        jj_la1[39] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    case LP:
      t = jj_consume_token(LP);
         fc = new ASTFunctionCallStatement(type.image, type.beginLine);
      fc = actualsStmt(fc);
      jj_consume_token(RP);
      {if (true) return fc;}
      break;
    default:
      jj_la1[40] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

/*
DONE
*/
  static final public ASTFunctionCallExpression actuals(ASTFunctionCallExpression fc) throws ParseException {
  ASTExpression e = null;
  ASTExpression rhs;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case FALSE:
    case TRUE:
    case NEW:
    case MINUS:
    case LP:
    case NOT:
    case ID:
    case INTEGER_LITERAL:
      e = expression();
                    fc.addElement(e);
      label_19:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case COMMA:
          ;
          break;
        default:
          jj_la1[41] = jj_gen;
          break label_19;
        }
        jj_consume_token(COMMA);
        rhs = expression();
                                  fc.addElement(rhs);
      }
    {if (true) return fc;}
      break;
    default:
      jj_la1[42] = jj_gen;

    {if (true) return fc;}
    }
    throw new Error("Missing return statement in function");
  }

/*
DONE
*/
  static final public ASTFunctionCallStatement actualsStmt(ASTFunctionCallStatement fc) throws ParseException {
  ASTExpression e = null;
  ASTExpression rhs;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case FALSE:
    case TRUE:
    case NEW:
    case MINUS:
    case LP:
    case NOT:
    case ID:
    case INTEGER_LITERAL:
      e = expression();
                    fc.addElement(e);
      label_20:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case COMMA:
          ;
          break;
        default:
          jj_la1[43] = jj_gen;
          break label_20;
        }
        jj_consume_token(COMMA);
        rhs = expression();
                                  fc.addElement(rhs);
      }
    {if (true) return fc;}
      break;
    default:
      jj_la1[44] = jj_gen;

    {if (true) return fc;}
    }
    throw new Error("Missing return statement in function");
  }

/*
DONE
*/
  static final public ASTStatement optionalelse() throws ParseException {
  ASTStatements statement_v = new ASTStatements();
  ASTStatement stmt;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ELSE:
      jj_consume_token(ELSE);
      stmt = statement();
        {if (true) return stmt;}
      break;
    default:
      jj_la1[45] = jj_gen;

  {if (true) return null;}
    }
    throw new Error("Missing return statement in function");
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public simplejavaTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[46];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x400,0x0,0x0,0x2000000,0x0,0x0,0x806c800,0x8000000,0x2000000,0x80000000,0x2000000,0x0,0x0,0x0,0x20292000,0x0,0x0,0x300000,0x300000,0xc00000,0xc00000,0x3000000,0x3000000,0x20000000,0x2000000,0x22000000,0x20292000,0x20292000,0x40000,0x806c800,0x40000,0x40000,0x20292000,0x806c800,0x2000000,0x0,0x3000000,0x3000000,0x0,0x0,0x23000000,0x80000000,0x20292000,0x80000000,0x20292000,0x1000,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x2000,0x2000,0x0,0x1000,0x1,0x2001,0x1,0x0,0x0,0x0,0x2000,0x100,0x80,0x6200,0x7e,0x7e,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x6000,0x6200,0x2000,0x2001,0x2000,0x2000,0x6200,0x2001,0x0,0x1000,0x0,0x0,0xc00,0x1c00,0x3c00,0x0,0x6200,0x0,0x6200,0x0,};
   }

  /** Constructor with InputStream. */
  public simplejava(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public simplejava(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new simplejavaTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 46; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 46; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public simplejava(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new simplejavaTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 46; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 46; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public simplejava(simplejavaTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 46; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(simplejavaTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 46; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[47];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 46; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 47; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}