package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Labirinto {

	private Stanza stanzaIniziale;
	private Stanza stanzaFinale;
	public Labirinto() {
		creaStanze();
	}
	 public void creaStanze() {

			/* crea gli attrezzi */
	    	Attrezzo lanterna = new Attrezzo("lanterna",3);
			Attrezzo osso = new Attrezzo("osso",1);
	    	Attrezzo chiave = new Attrezzo("chiave alata", 1);
	    	Attrezzo torcia = new Attrezzo("Torcia", 2);
			/* crea stanze del labirinto */
			Stanza atrio = new Stanza("Atrio");
			Stanza aulaN11 = new Stanza("Aula N11");
			Stanza aulaN10 = new Stanza("Aula N10");
			Stanza laboratorio = new Stanza("Laboratorio Campus");
			Stanza biblioteca = new Stanza("Biblioteca");
			StanzaBuia cripta = new StanzaBuia("cripta","torcia");
			StanzaBloccata segreta = new StanzaBloccata("segreta","chiave alata", "est");
			StanzaMagica  magica = new StanzaMagica("dungeon");
			StanzaMagica  necessita = new StanzaMagica("necessità", 5);
			/* collega le stanze */
			atrio.impostaStanzaAdiacente("nord", biblioteca);
			atrio.impostaStanzaAdiacente("est", aulaN11);
			atrio.impostaStanzaAdiacente("sud", aulaN10);
			atrio.impostaStanzaAdiacente("ovest", laboratorio);
			aulaN11.impostaStanzaAdiacente("est", laboratorio);
			aulaN11.impostaStanzaAdiacente("ovest", atrio);
			aulaN10.impostaStanzaAdiacente("nord", atrio);
			aulaN10.impostaStanzaAdiacente("est", aulaN11);
			aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
			laboratorio.impostaStanzaAdiacente("est", atrio);
			laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
			biblioteca.impostaStanzaAdiacente("sud", atrio);
            cripta.impostaStanzaAdiacente("est", biblioteca);
            segreta.impostaStanzaAdiacente("sud", laboratorio);
            magica.impostaStanzaAdiacente("nord", atrio);
            necessita.impostaStanzaAdiacente("est", aulaN10);
	        /* pone gli attrezzi nelle stanze */
			aulaN10.addAttrezzo(lanterna);
			atrio.addAttrezzo(osso);
			aulaN11.addAttrezzo(chiave);
            laboratorio.addAttrezzo(torcia);
			// il gioco comincia nell'atrio
	        stanzaIniziale = atrio;  
			stanzaFinale = biblioteca;
	    }

		public Stanza getStanzaIniziale() {
			return this.stanzaIniziale;
		}

		
		public Stanza getStanzaFinale() {
			return this.stanzaFinale;
		}
}
