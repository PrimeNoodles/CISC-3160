import java.util.*;

public class SymbolTable {
	private Hashtable table;
	protected SymbolTable prev;
	public SymbolTable(SymbolTable n) {
		table = new Hashtable();
		prev = n;
	}
	public void put(Token w, Id i) {
		table.put(w, i);
	}
	public Id get(token w) {
		for(SymbolTable e = this; e != null; e = e.prev) { 
			Id found = (Id)(e.table.get(w));
			if(found != null) return found;
		}
		return null;
	}
}
