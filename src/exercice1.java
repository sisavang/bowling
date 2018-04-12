import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class exercice1 {
	
	Jeu exo = new Jeu();
	
	@Test
	public void testString() {
		String test1 = exo.thisIsAString();
		assertTrue(test1.equals("This is a string"));
	}
		
	@Test
	public void sommeDesValeursTuplesInferieurA10() throws Exception {
		Jeu jeu = new Jeu();
		jeu.ajouterScoreJoueur1(1,2);
		assertTrue(jeu.scoreJoueur1() == 3);
		
		Jeu jeu2 = new Jeu();
		jeu2.ajouterScoreJoueur2(4,2);
		assertTrue(jeu2.scoreJoueur2() == 6);
	}
	
	@Test
	public void sommePlusieursTuple() throws Exception {
		Jeu jeu = new Jeu();
		jeu.ajouterScoreJoueur1(1,2);
		jeu.ajouterScoreJoueur1(0,0);
		jeu.ajouterScoreJoueur1(3,4);
		jeu.ajouterScoreJoueur1(10,0);
		assertTrue(jeu.scoreJoueur1() == 20);
	}
	
	@Rule public ExpectedException thrown= ExpectedException.none();

	@Test
	public void sommeDesValeursTuplesSupérieurA10() throws Exception {
	    thrown.expect( Exception.class );
	    thrown.expectMessage("tuple ne peut pas etre sup a 10");
	    
	    Jeu jeu = new Jeu();
	    jeu.ajouterScoreJoueur1(10,2);
	}
	
	@Test
	public void scoreItem1DoubleApresSpare() throws Exception {
		Jeu jeu = new Jeu();
		jeu.ajouterScoreJoueur1(5,5);
		jeu.ajouterScoreJoueur1(4,0);
		assertTrue(jeu.scoreJoueur1() == 18);
	}
	
	@Test
	public void scoreTupleDoubleApresStrike() throws Exception {
		Jeu jeu = new Jeu();
		jeu.ajouterScoreJoueur1(10,0);
		jeu.ajouterScoreJoueur1(4,4);
		assertTrue(jeu.scoreJoueur1() == 26);
	}
	
	@Test
	public void scoreApresDeuxStrike() throws Exception {
		Jeu jeu = new Jeu();
		jeu.ajouterScoreJoueur1(10,0);
		jeu.ajouterScoreJoueur1(10,0);
		jeu.ajouterScoreJoueur1(3,3);
		assertTrue(jeu.scoreJoueur1() == 45);
	}
	
	@Test
	public void score300() throws Exception {
		Jeu jeu = new Jeu();
		jeu.ajouterScoreJoueur1(10,0);
		jeu.ajouterScoreJoueur1(10,0);
		jeu.ajouterScoreJoueur1(10,0);
		jeu.ajouterScoreJoueur1(10,0);
		jeu.ajouterScoreJoueur1(10,0);
		jeu.ajouterScoreJoueur1(10,0);
		jeu.ajouterScoreJoueur1(10,0);
		jeu.ajouterScoreJoueur1(10,0);
		jeu.ajouterScoreJoueur1(10,0);
		jeu.ajouterScoreJoueur1(10,0);
		jeu.ajouterScoreJoueur1(10,0);
		jeu.ajouterScoreJoueur1(10,0);

		assertTrue(jeu.scoreJoueur1() == 300);
	}
	
	@Test
	public void scoreApresStrikeEtSpare() throws Exception {
		Jeu jeu = new Jeu();
		jeu.ajouterScoreJoueur1(10,0);
		jeu.ajouterScoreJoueur1(5,5);
		jeu.ajouterScoreJoueur1(3,3);
		assertTrue(jeu.scoreJoueur1() == 39);
	}
	
	@Test
	public void scoreApresTroisStrike() throws Exception {
		Jeu jeu = new Jeu();
		jeu.ajouterScoreJoueur1(10,0);
		jeu.ajouterScoreJoueur1(10,0);
		jeu.ajouterScoreJoueur1(10,0);
		jeu.ajouterScoreJoueur1(0,0);
		jeu.ajouterScoreJoueur1(0,0);
		jeu.ajouterScoreJoueur1(0,0);
		jeu.ajouterScoreJoueur1(0,0);
		jeu.ajouterScoreJoueur1(0,0);
		jeu.ajouterScoreJoueur1(0,0);
		jeu.ajouterScoreJoueur1(0,0);
		assertTrue(jeu.scoreJoueur1() == 60);
	}
	
	@Test
	public void nombreDeMancheInf10() throws Exception {
		thrown.expect( Exception.class );
	    thrown.expectMessage("Il ne peut y a avoir que 11 manches sans un strike ou spare");
	    
		Jeu jeu = new Jeu();
		jeu.ajouterScoreJoueur1(10,0);
		jeu.ajouterScoreJoueur1(4,4);
		jeu.ajouterScoreJoueur1(4,4);
		jeu.ajouterScoreJoueur1(4,4);
		jeu.ajouterScoreJoueur1(4,4);
		jeu.ajouterScoreJoueur1(4,4);
		jeu.ajouterScoreJoueur1(4,4);
		jeu.ajouterScoreJoueur1(4,4);
		jeu.ajouterScoreJoueur1(4,4);
		jeu.ajouterScoreJoueur1(4,4);
		jeu.ajouterScoreJoueur1(4,4);
	}
		
	@Test
	public void uneMancheEnPlusQuandStrikeALaManche10() throws Exception {
		Jeu jeu = new Jeu();
		jeu.ajouterScoreJoueur1(1,0);
		jeu.ajouterScoreJoueur1(0,0);
		jeu.ajouterScoreJoueur1(0,0);
		jeu.ajouterScoreJoueur1(0,0);
		jeu.ajouterScoreJoueur1(0,0);
		jeu.ajouterScoreJoueur1(0,0);
		jeu.ajouterScoreJoueur1(0,0);
		jeu.ajouterScoreJoueur1(0,0);
		jeu.ajouterScoreJoueur1(0,0);
		jeu.ajouterScoreJoueur1(10,0);
		jeu.ajouterScoreJoueur1(2,2);
		assertTrue(jeu.scoreJoueur1() == 15);
	}
	
	@Test
	public void uneMancheEnPlusStrikeManche10StrikeManche11Point5Manche12() throws Exception {
		Jeu jeu = new Jeu();
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
		assertTrue(jeu.scoreJoueur1() == 25);
	}
	
	@Test
	public void score152AvecSpareALaFin() throws Exception {
		Jeu jeu = new Jeu();
		jeu.ajouterScoreJoueur1(3,5);
		jeu.ajouterScoreJoueur1(7,3);
		jeu.ajouterScoreJoueur1(9,0);
		jeu.ajouterScoreJoueur1(10,0);
		jeu.ajouterScoreJoueur1(5,4);
		jeu.ajouterScoreJoueur1(10,0);
		jeu.ajouterScoreJoueur1(10,0);
		jeu.ajouterScoreJoueur1(5,5);
		jeu.ajouterScoreJoueur1(5,5);
		jeu.ajouterScoreJoueur1(5,5);
		jeu.ajouterScoreJoueur1(3,0);
		assertTrue(jeu.scoreJoueur1() == 152);
	}
	
	@Test
	public void score13AvecSpareALaFin() throws Exception {
		Jeu jeu = new Jeu();
		jeu.ajouterScoreJoueur1(0,0);
		jeu.ajouterScoreJoueur1(0,0);
		jeu.ajouterScoreJoueur1(0,0);
		jeu.ajouterScoreJoueur1(0,0);
		jeu.ajouterScoreJoueur1(0,0);
		jeu.ajouterScoreJoueur1(0,0);
		jeu.ajouterScoreJoueur1(0,0);
		jeu.ajouterScoreJoueur1(0,0);
		jeu.ajouterScoreJoueur1(0,0);
		jeu.ajouterScoreJoueur1(5,5);
		jeu.ajouterScoreJoueur1(3,0);
		assertTrue(jeu.scoreJoueur1() == 13);
	}

	@Test
	public void err11MancheMaxQuandStrikeManche10() throws Exception {
		thrown.expect( Exception.class );
	    thrown.expectMessage("Il ne peut y a avoir que 12 manches sans un strike avant");
		Jeu jeu = new Jeu();
		jeu.ajouterScoreJoueur1(1,0);
		jeu.ajouterScoreJoueur1(0,0);
		jeu.ajouterScoreJoueur1(0,0);
		jeu.ajouterScoreJoueur1(0,0);
		jeu.ajouterScoreJoueur1(0,0);
		jeu.ajouterScoreJoueur1(0,0);
		jeu.ajouterScoreJoueur1(0,0);
		jeu.ajouterScoreJoueur1(0,0);
		jeu.ajouterScoreJoueur1(0,0);
		jeu.ajouterScoreJoueur1(10,0);
		jeu.ajouterScoreJoueur1(2,2);
		jeu.ajouterScoreJoueur1(2,2);
	}
	
	@Test
	public void err11MancheMaxQuandStrikePuisSPare() throws Exception {
		thrown.expect( Exception.class );
	    thrown.expectMessage("Il ne peut y a avoir que 12 manches sans un strike avant");
		Jeu jeu = new Jeu();
		jeu.ajouterScoreJoueur1(1,0);
		jeu.ajouterScoreJoueur1(0,0);
		jeu.ajouterScoreJoueur1(0,0);
		jeu.ajouterScoreJoueur1(0,0);
		jeu.ajouterScoreJoueur1(0,0);
		jeu.ajouterScoreJoueur1(0,0);
		jeu.ajouterScoreJoueur1(0,0);
		jeu.ajouterScoreJoueur1(0,0);
		jeu.ajouterScoreJoueur1(0,0);
		jeu.ajouterScoreJoueur1(10,0);
		jeu.ajouterScoreJoueur1(5,5);
		jeu.ajouterScoreJoueur1(2,2);
	}
	
	@Test
	public void err11MancheMaxQuandSpare() throws Exception {
		thrown.expect( Exception.class );
	    thrown.expectMessage("Il ne peut y a avoir que 12 manches sans un strike avant");
		Jeu jeu = new Jeu();
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
		jeu.ajouterScoreJoueur1(2,0);
		jeu.ajouterScoreJoueur1(2,2);
	}
}
