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
			if (i >= 9 && i <= 11 && tabJoueur1.get(i).isStrike()) {
				resultat += (tabJoueur1.get(i).sommeTuple());
			}else if (i == 10 && tabJoueur1.get(i - 1).isStrike() ) {
				resultat += (tabJoueur1.get(i).sommeTuple());
			} else if (i == 9 && tabJoueur1.get(i).isSpare() && i + 1 < tabJoueur1.size()) {
				resultat += tabJoueur1.get(i).sommeTuple() + (tabJoueur1.get(i + 1).getL());
				System.out.println("allo");
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

		if (tabJoueur1.size() >= 10 && !tabJoueur1.get(tabJoueur1.size() - 1).isSpare()
				&& !tabJoueur1.get(tabJoueur1.size() - 1).isStrike()) {
			throw new Exception("Il ne peut y a avoir que 10 manches dans le cas nominal");
		}
		
		/*
		if (tabJoueur1.size() >= 10 && !tabJoueur1.get(tabJoueur1.size() - 1).isSpare()
				&& !tabJoueur1.get(tabJoueur1.size() - 1).isStrike()) {
			throw new Exception("Il ne peut y a avoir que 10 manches dans le cas nominal");
		}

		if (tabJoueur1.size() >= 12 && !tabJoueur1.get(9).isSpare()) {
			throw new Exception("Il ne peut y a avoir 12 manches");
		}
		*/
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
		/*
		 * jeu.ajouterScoreJoueur1(3, 5); jeu.ajouterScoreJoueur1(7, 3);
		 * jeu.ajouterScoreJoueur1(9, 0); jeu.ajouterScoreJoueur1(10, 0);
		 * jeu.ajouterScoreJoueur1(5, 4); jeu.ajouterScoreJoueur1(10, 0);
		 * jeu.ajouterScoreJoueur1(10, 0); jeu.ajouterScoreJoueur1(5, 5);
		 * jeu.ajouterScoreJoueur1(5, 5); jeu.ajouterScoreJoueur1(5, 5);
		 * jeu.ajouterScoreJoueur1(3, 0);
		 */
		jeu.ajouterScoreJoueur1(1,0);
		jeu.ajouterScoreJoueur1(0,0);
		jeu.ajouterScoreJoueur1(0,0);
		jeu.ajouterScoreJoueur1(0,0);
		jeu.ajouterScoreJoueur1(0,0);
		jeu.ajouterScoreJoueur1(0,0);
		jeu.ajouterScoreJoueur1(0,0);
		jeu.ajouterScoreJoueur1(0,0);
		jeu.ajouterScoreJoueur1(0,0);
		jeu.ajouterScoreJoueur1(5,5);
		jeu.ajouterScoreJoueur1(2,2);
		jeu.ajouterScoreJoueur1(2,2);
		System.out.println(jeu.scoreJoueur1());
	}
}
