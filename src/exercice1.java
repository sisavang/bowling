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
	    thrown.expectMessage("Il ne peut y a avoir que 10 manches dans le cas nominal");
	    
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
	public void unCoupEnPlusQuandSpareALaManche10() throws Exception {
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
		assertTrue(jeu.scoreJoueur1() == 15);
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
		assertTrue(jeu.scoreJoueur1() == 19);
	}
	
	@Test
	public void errMoinsDe11MancheQuandStrike() throws Exception {
		thrown.expect( Exception.class );
	    thrown.expectMessage("Il ne peut y a avoir que 10 manches dans le cas nominal");
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
	    thrown.expectMessage("Il ne peut y a avoir que 10 manches dans le cas nominal");
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
	    thrown.expectMessage("Il ne peut y a avoir 12 manches");
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
		jeu.ajouterScoreJoueur1(2,2);
		jeu.ajouterScoreJoueur1(2,2);
	}
}
