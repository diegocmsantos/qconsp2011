package br.com.delxmobile.qconsp.activities;

import java.util.List;

import br.com.delxmobile.qconsp.R;
import br.com.delxmobile.qconsp.adapters.PalestraListAdapter;
import br.com.delxmobile.qconsp.database.RepositorioPalestra;
import br.com.delxmobile.qconsp.objects.Palestra;
import br.com.delxmobile.qconsp.objects.Palestra.Palestras;
import br.com.delxmobile.qconsp.scripts.RepositorioPalestraScript;
import br.com.delxmobile.qconsp.util.ActivityHelper;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;


public class ListPalestra extends Activity implements OnItemClickListener {
	ActivityHelper mActivityHelper = ActivityHelper.createInstance(this);
	public static RepositorioPalestra repositorio;
	private ListView listview;
	private List<Palestra> palestras;
	public String dia;
	public String diatitle;
	public int trilha;
	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.listarpalestras);
		repositorio = new RepositorioPalestraScript(this);

		//Pega o atributo posicao da tela anterior
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			dia = extras.getString(Palestras.DIA);
			trilha = extras.getInt(Palestras.TRILHA);
		}
		if(dia.equals("Sabado")){
			diatitle = "Sábado";
		}
		else{
			diatitle = "Domingo";
		}
		mActivityHelper.setupActionBar(diatitle);
		atualizarLista();
	}
	protected void atualizarLista() {
		// Pega a lista de palestras e exibe na tela
		palestras = repositorio.listarPalestra(dia, trilha);
		listview = (ListView) findViewById(R.id.listview);
		listview.setAdapter(new PalestraListAdapter(this, palestras));
		listview.setOnItemClickListener(this);

	}

	public void onItemClick(AdapterView<?> parent, View view, int posicao, long id) {
		Palestra palestra = (Palestra) listview.getAdapter().getItem(posicao);
		editarPalestra(posicao);
	}

	//	@Override
	//	public boolean onCreateOptionsMenu(Menu menu) {
	//		super.onCreateOptionsMenu(menu);
	//		menu.add(0, INSERIR_EDITAR, 0, "New wish").setIcon(R.drawable.novo);
	//		menu.add(0, CONTATO, 0, "Support").setIcon(R.drawable.suportt);
	//		return true;
	//	}
	//
	//	@Override
	//	public boolean onMenuItemSelected(int featureId, MenuItem item) {
	//		// Clicou no menu
	//		switch (item.getItemId()) {
	//		case INSERIR_EDITAR:
	//			// Abre a tela com o formul�rio para adicionar
	//			startActivity(new Intent(this, EscolherSonho.class));
	//			break;
	//		case CONTATO:
	//			// Abre a tela com o formul�rio para adicionar
	//			startActivity(new Intent(this, Contato.class));
	//			break;
	//		}
	//		return true;
	//	}


	// Recupera o id da palestra, e abre a tela de detalhes
	protected void editarPalestra(int posicao) {
		Palestra palestra = palestras.get(posicao);
		if(palestra.palestrante.equals("")){

		}
		else{
			if(palestra.titulo.substring(0,5).equals("Track")){
				if(dia.equals("Sabado")){
					if(palestra.resumo.equals("1")){
						Intent it = new Intent(ListPalestra.this, ListPalestra.class);
						it.putExtra(Palestras.DIA, "Sabado" );
						it.putExtra(Palestras.TRILHA, 1);
						startActivity(it);
					}
					else if(palestra.resumo.equals("2")){
						Intent it = new Intent(ListPalestra.this, ListPalestra.class);
						it.putExtra(Palestras.DIA, "Sabado" );
						it.putExtra(Palestras.TRILHA, 2);
						startActivity(it);

					}
					else if(palestra.resumo.equals("3")){
						Intent it = new Intent(ListPalestra.this, ListPalestra.class);
						it.putExtra(Palestras.DIA, "Sabado" );
						it.putExtra(Palestras.TRILHA, 2);
						startActivity(it);
					}
					else if(palestra.resumo.equals("4")){
						Intent it = new Intent(ListPalestra.this, ListPalestra.class);
						it.putExtra(Palestras.DIA, "Sabado" );
						it.putExtra(Palestras.TRILHA, 2);
						startActivity(it);
					}
				}
				else{
					if(palestra.resumo.equals("1")){
						Intent it = new Intent(ListPalestra.this, ListPalestra.class);
						it.putExtra(Palestras.DIA, "Domingo" );
						it.putExtra(Palestras.TRILHA, 1);
						startActivity(it);
					}
					else if(palestra.resumo.equals("2")){
						Intent it = new Intent(ListPalestra.this, ListPalestra.class);
						it.putExtra(Palestras.DIA, "Domingo" );
						it.putExtra(Palestras.TRILHA, 2);
						startActivity(it);

					}
					else if(palestra.resumo.equals("3")){
						Intent it = new Intent(ListPalestra.this, ListPalestra.class);
						it.putExtra(Palestras.DIA, "Domingo" );
						it.putExtra(Palestras.TRILHA, 2);
						startActivity(it);
					}
					else if(palestra.resumo.equals("4")){
						Intent it = new Intent(ListPalestra.this, ListPalestra.class);
						it.putExtra(Palestras.DIA, "Domingo" );
						it.putExtra(Palestras.TRILHA, 2);
						startActivity(it);
					}
				}

			}

			else{
				Intent it = new Intent(ListPalestra.this, DetalhesPalestra.class);
				it.putExtra(Palestras._ID, palestra.id);
				startActivity(it);
			}

		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();

		// Fecha o banco
		repositorio.fechar();
	}
	@Override
	protected void onResume() {
		super.onResume();
		//atualizarLista();
	}
}