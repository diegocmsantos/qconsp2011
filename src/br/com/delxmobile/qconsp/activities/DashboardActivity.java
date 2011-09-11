package br.com.delxmobile.qconsp.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import br.com.delxmobile.qconsp.R;
import br.com.delxmobile.qconsp.objects.Palestra.Palestras;
import br.com.delxmobile.qconsp.util.ActivityHelper;

public class DashboardActivity extends Activity {


	ActivityHelper mActivityHelper = ActivityHelper.createInstance(this);

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dashboard);

		mActivityHelper.setupActionBar(null);
		
		//Sábado
		Button sabado = (Button) findViewById(R.id.home_btn_sabado);
		sabado.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				Intent it = new Intent(DashboardActivity.this, ListPalestra.class);
				it.putExtra(Palestras.DIA, "Sabado");
				it.putExtra(Palestras.TRILHA, 0);
				startActivity(it);
				
			}
		}); 

		//Domingo
		Button domingo = (Button) findViewById(R.id.home_btn_domingo);
		domingo.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				Intent it = new Intent(DashboardActivity.this, ListPalestra.class);
				it.putExtra(Palestras.DIA, "Domingo");
				it.putExtra(Palestras.TRILHA, 0);
				startActivity(it);		
				}
		});
		
		//Palestrantes
		Button palestrantes = (Button) findViewById(R.id.home_btn_palestrante);
		palestrantes.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(DashboardActivity.this,GridPalestrante.class));
			}
		}); 
		
		//Mapa
		Button mapa = (Button) findViewById(R.id.home_btn_mapa);
		mapa.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(DashboardActivity.this, Local.class));
			}
		}); 
		
		//Lembrar
		Button lembrar = (Button) findViewById(R.id.home_btn_lembrar);
		lembrar.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(DashboardActivity.this, ListPalestra.class));
			}
		}); 
		//Twitter
		Button twitter = (Button) findViewById(R.id.home_btn_twitter);
		twitter.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(DashboardActivity.this, TwitterActivity.class));
			}
		}); 


	}

}