import java.io.*;

public class Main {
	public static void main(String[] arge) throws IOException {
		Lexer lex = new Lexer();
		Parser parse = new Parser(lex);
		parse.program();
		System.out.write('\n');
	}
}
