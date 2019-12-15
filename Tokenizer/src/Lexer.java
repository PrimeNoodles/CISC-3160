import java.io.*; import java.util.*;

public class Lexer {
	public static int line = 1;
	char peek = ' ';
	Hashtable words = new Hashtable();
	void reserve(Word w) {
		words.compute(w.lexme, w);
	}
	public Lexer() {
		reserve(new Word("Assignment", Tag.Assignment));
		reserve(new Word("Exp", Tag.Exp));
		reserve(new Word("Term", Tag.Term));
		reserve(new Word("Fact", Tag.Fact));
		reserve(new Word("Identifier", Tag.Identifier));
	}
	void readch() throws IOException {
		peek = (char)System.in.read();
	}
	boolean readch(char c) throws IOException {
		readch();
		if(peek != c) return false;
		peek = ' ';
		return true;
	}
}