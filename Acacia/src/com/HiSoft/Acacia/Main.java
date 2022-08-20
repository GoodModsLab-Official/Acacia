package com.HiSoft.Acacia;

import com.HiSoft.Acacia.parser.Lexer;
import com.HiSoft.Acacia.parser.Parser;
import com.HiSoft.Acacia.parser.Token;
import com.HiSoft.Acacia.parser.ast.Statement;
import com.HiSoft.Acacia.parser.visitors.AssignValidator;
import com.HiSoft.Acacia.parser.visitors.FunctionAdder;
import com.HiSoft.Acacia.parser.visitors.VariablePrinter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
      final String file = "/storage/emulated/0/AppProjects/Acacia/Acacia/src/com/HiSoft/Acacia/program.afe";
      final String input = new String(Files.readAllBytes(Paths.get(file)), "UTF-8");
      final List<Token> tokens = new Lexer(input).tokenize();
      for (int i = 0; i < tokens.size(); i++) {
          System.out.println(i + " " + tokens.get(i));
      }
//        for (Token token : tokens) {
//            System.out.println(token);
//        }

      final Statement program = new Parser(tokens).parse();
      System.out.println(program.toString());
      program.accept(new FunctionAdder());
      program.accept(new VariablePrinter());
      program.accept(new AssignValidator());
      program.execute();
  }
}
