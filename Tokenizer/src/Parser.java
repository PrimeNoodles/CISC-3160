import java.io.*;

public class Parser {
	static int lookahead;
	
	public Parser() throws IOException {
		lookahead = System.in.read();
	}
	
	void expr() throws IOException {
		term();
		while(true) {
			if(lookahead == '+') {
				match('+'); term(); System.out.write('+');
			}
			else if(lookahead == '-') {
				match('-'); term(); System.out.write('-');
			}
			else return;
		}
	}
	void term() throws IOException {
		if(Character.isDigit((char)lookahead)) {
			System.out.write((char)lookahead); match(lookahead);
		}
		else throw new Error("Syntax error detected");
	}
	void maatch(int t) throws IOException {
		if(lookahead == t) lookahead = System.in.read();
		else throw new Error("syntax error");
	}
}

class Postfix {
	public static void main(String[] args) throws IOException {
		Parser parse = new Parser();
		parse.expr(); System.out.write('\n');
	}
}