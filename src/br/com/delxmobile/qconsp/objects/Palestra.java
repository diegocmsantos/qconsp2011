package br.com.delxmobile.qconsp.objects;

import android.provider.BaseColumns;


public class Palestra {

<<<<<<< HEAD
	public static String[] colunas = new String[] { Palestras._ID, Palestras.HORARIO, Palestras.TITULO, Palestras.PALESTRANTE, Palestras.RESUMO, Palestras.DIA, Palestras.TRILHA};
=======
	public static String[] colunas = new String[] { Palestras._ID, Palestras.HORARIO, Palestras.TITULO, Palestras.PALESTRANTE, Palestras.RESUMO, Palestras.DIA};
>>>>>>> ca2e7340ad4acbef040a7994df5439de5a30b20e

	
	public long id;
	public String horario;
	public String titulo;
	public String palestrante;
	public String resumo;
	public String dia;
<<<<<<< HEAD
	public int trilha;
=======
>>>>>>> ca2e7340ad4acbef040a7994df5439de5a30b20e
	
	public Palestra() {
	}

<<<<<<< HEAD
	public Palestra(String horario, String titulo, String palestrante, String resumo, String dia, int trilha) {
=======
	public Palestra(String horario, String titulo, String palestrante, String resumo, String dia) {
>>>>>>> ca2e7340ad4acbef040a7994df5439de5a30b20e
		super();
		this.horario = horario;
		this.titulo = titulo;
		this.palestrante = palestrante;
		this.resumo = resumo;
		this.dia = dia;
<<<<<<< HEAD
		this.trilha = trilha;
=======
>>>>>>> ca2e7340ad4acbef040a7994df5439de5a30b20e
	
	}



	public static final class Palestras implements BaseColumns {

		public static final String HORARIO = "horario";
		public static final String TITULO = "titulo";
		public static final String PALESTRANTE = "palestrante";
		public static final String RESUMO = "resumo";
		public static final String DIA = "dia";
<<<<<<< HEAD
		public static final String TRILHA = "trilha";
=======
>>>>>>> ca2e7340ad4acbef040a7994df5439de5a30b20e

		// N�o pode instanciar esta Classe
		private Palestras() {
		}

	}

}
