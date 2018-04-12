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
		String test = "";
		int resultat = 0;
		for (int i = 0; i < tabJoueur1.size(); i++) {
			//Lorsque manche 10, 11 et 12 sont des Strike
			if (i >= 9 && i <= 11 && tabJoueur1.get(i).isStrike()) {
				resultat += (tabJoueur1.get(i).sommeTuple());
			//Lorsque manche 10 et 11 Strike et que manche 12 n'est pas un strike
			} else if (i == 11 && tabJoueur1.get(i-1).isStrike()){ 
				resultat += (tabJoueur1.get(i).sommeTuple());
			} else if (i == 10 && tabJoueur1.get(i - 1).isStrike()) {
				resultat += (tabJoueur1.get(i).sommeTuple());
			} else if (i == 9 && tabJoueur1.get(i).isSpare() && i + 1 < tabJoueur1.size()) {
				resultat += tabJoueur1.get(i).sommeTuple() + (tabJoueur1.get(i + 1).getL());
			} else if (i < 10) {
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
			test = "i = " + i + " / resultat = " + resultat;
			System.out.println(test);
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
		if (tabJoueur1.size() == 10) {
			if (tabJoueur1.get(9).isSpare() || tabJoueur1.get(9).isStrike()) {
				Tuple tuple = new Tuple(i, j);
				this.tabJoueur1.add(tuple);
			} else {
				throw new Exception("Il ne peut y a avoir que 11 manches sans un strike ou spare");
			}
		} else if (tabJoueur1.size() == 11) {
			if (tabJoueur1.get(10).isStrike()) {
				Tuple tuple = new Tuple(i, j);
				this.tabJoueur1.add(tuple);
			} else {
				throw new Exception("Il ne peut y a avoir que 12 manches sans un strike avant");
			}
		} else {
			Tuple tuple = new Tuple(i, j);
			this.tabJoueur1.add(tuple);
		}
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
		/*
		 * jeu.ajouterScoreJoueur1(3, 5); jeu.ajouterScoreJoueur1(7, 3);
		 * jeu.ajouterScoreJoueur1(9, 0); jeu.ajouterScoreJoueur1(10, 0);
		 * jeu.ajouterScoreJoueur1(5, 4); jeu.ajouterScoreJoueur1(10, 0);
		 * jeu.ajouterScoreJoueur1(10, 0); jeu.ajouterScoreJoueur1(5, 5);
		 * jeu.ajouterScoreJoueur1(5, 5); jeu.ajouterScoreJoueur1(5, 5);
		 * jeu.ajouterScoreJoueur1(3, 0);
		 */
		jeu.ajouterScoreJoueur1(0,0);
		jeu.ajouterScoreJoueur1(0,0);
		jeu.ajouterScoreJoueur1(0,0);
		jeu.ajouterScoreJoueur1(0,0);
		jeu.ajouterScoreJoueur1(0,0);
		jeu.ajouterScoreJoueur1(0,0);
		jeu.ajouterScoreJoueur1(0,0);
		jeu.ajouterScoreJoueur1(0,0);
		jeu.ajouterScoreJoueur1(0,0);
		jeu.ajouterScoreJoueur1(10,0);
		jeu.ajouterScoreJoueur1(10,0);
		jeu.ajouterScoreJoueur1(5,0);
		System.out.println(jeu.scoreJoueur1());
	}
}
