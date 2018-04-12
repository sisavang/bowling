import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

public class Jeu {

	private ArrayList<Tuple> tabJoueur1;
	private ArrayList<Tuple> tabJoueur2;

	public Jeu() {
		tabJoueur1 = new ArrayList<Tuple>();
		tabJoueur2 = new ArrayList<Tuple>();
	}

	public String thisIsAString() {
		return "This is a string";
	}

	public int scoreJoueur1() {
		/*
		 * int resultat = 0; for (int i = 0; i < tabJoueur1.size(); i++) { if (i >= 1) {
		 * if (tabJoueur1.get(i - 1).isSpare()) { resultat += tabJoueur1.get(i).getL();
		 * } if (tabJoueur1.get(i - 1).isStrike()) { resultat +=
		 * tabJoueur1.get(i).sommeTuple(); } } resultat +=
		 * (tabJoueur1.get(i).sommeTuple()); } return resultat;
		 */
		int resultat = 0;
		for (int i = 0; i < tabJoueur1.size(); i++) {
			if (i == 10 && tabJoueur1.get(i).isStrike()) {
				resultat += (tabJoueur1.get(i).sommeTuple());
			} else if (i == 11 && tabJoueur1.get(i).isStrike()) {
				resultat += (tabJoueur1.get(i).sommeTuple());
			} else if (i == 9 && tabJoueur1.get(i).isStrike()) {
				resultat += (tabJoueur1.get(i).sommeTuple());
			} else {
				if (tabJoueur1.get(i).isStrike()) {
					if (i + 1 < tabJoueur1.size()) {
						if (tabJoueur1.get(i + 1).isStrike()) {
							if (i + 2 < tabJoueur1.size()) {
								resultat += tabJoueur1.get(i + 2).getL();
							}
						}
						resultat += tabJoueur1.get(i + 1).sommeTuple();
					}
				}
				if (tabJoueur1.get(i).isSpare()) {
					if (i + 1 < tabJoueur1.size()) {
						resultat += tabJoueur1.get(i + 1).getL();
					}
				}
				resultat += (tabJoueur1.get(i).sommeTuple());
			}
		}
		return resultat;
	}

	public int scoreJoueur2() {
		int resultat = 0;
		for (int i = 0; i < tabJoueur2.size(); i++) {
			resultat += (tabJoueur2.get(i).getL() + tabJoueur2.get(i).getR());
		}
		return resultat;
	}

	public void ajouterScoreJoueur1(int i, int j) throws Exception {
		if (i + j > 10) {
			throw new Exception("tuple ne peut pas etre sup a 10");
		}

		if (tabJoueur1.size() >= 10 && !tabJoueur1.get(tabJoueur1.size() - 1).isSpare()
				&& !tabJoueur1.get(tabJoueur1.size() - 1).isStrike()) {
			throw new Exception("Il ne peut y a avoir que 10 manches dans le cas nominal");
		}

		if (tabJoueur1.size() >= 12 && !tabJoueur1.get(9).isSpare()) {
			throw new Exception("Il ne peut y a avoir 12 manches");
		}

		Tuple tuple = new Tuple(i, j);
		if (tabJoueur1.size() == 10 && tabJoueur1.get(9).isSpare()) {
			tuple.setR(0);
		}

		this.tabJoueur1.add(tuple);
	}

	public void ajouterScoreJoueur2(int i, int j) throws Exception {
		if (i + j > 10) {
			throw new Exception("tuple ne peut pas etre sup a 10");
		}
		Tuple tuple = new Tuple(i, j);
		this.tabJoueur2.add(tuple);
	}

	public static void main(String[] args) throws Exception {
		Jeu jeu = new Jeu();

		jeu.ajouterScoreJoueur1(10, 0);
		jeu.ajouterScoreJoueur1(10, 0);
		jeu.ajouterScoreJoueur1(10, 0);
		jeu.ajouterScoreJoueur1(10, 0);
		jeu.ajouterScoreJoueur1(10, 0);
		jeu.ajouterScoreJoueur1(10, 0);
		jeu.ajouterScoreJoueur1(10, 0);
		jeu.ajouterScoreJoueur1(10, 0);
		jeu.ajouterScoreJoueur1(10, 0);
		jeu.ajouterScoreJoueur1(10, 0);
		jeu.ajouterScoreJoueur1(10, 0);
		jeu.ajouterScoreJoueur1(10, 0);

		System.out.println(jeu.scoreJoueur1());
	}
}
