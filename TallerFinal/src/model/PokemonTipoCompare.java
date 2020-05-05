package model;

import java.util.Comparator;

public class PokemonTipoCompare implements Comparator<Pokemon>{

	@Override
	public int compare(Pokemon o1, Pokemon o2) {
		// TODO Auto-generated method stub
		return o1.getTipo().compareTo(o2.getTipo());
	}

}
