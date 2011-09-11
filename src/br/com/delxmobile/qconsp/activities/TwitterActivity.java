package br.com.delxmobile.qconsp.activities;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import br.com.delxmobile.qconsp.R;
import br.com.delxmobile.qconsp.adapters.TwitterAdapter;
import br.com.delxmobile.qconsp.objects.Result;
import br.com.delxmobile.qconsp.objects.Tweet;
import br.com.delxmobile.qconsp.util.ActivityHelper;

import com.google.gson.Gson;

public class TwitterActivity extends ListActivity {

	ActivityHelper mActivityHelper = ActivityHelper.createInstance(this);

	private ProgressDialog m_ProgressDialog = null;
	private ArrayList<Result> m_results = null;
	private TwitterAdapter adapter;
	private Runnable loadResults;
	
	private Handler handler = new Handler() {
		
		public void handleMessage(android.os.Message msg) {
			super.handleMessage(msg);
			m_ProgressDialog.dismiss();
		};
		
	};
	
	private void processThread() {
		m_ProgressDialog = ProgressDialog.show(TwitterActivity.this, "", "Doing...");
		
		new Thread() {
			@Override
			public void run() {
//				super.run();
				try {
					runJSONParser("50");
				} catch (Exception e) {
					handler.sendEmptyMessage(0);
				}
			}
		}.start();
	}

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.twitter);
		mActivityHelper.setupActionBar("Twitter");

		m_results = new ArrayList<Result>();

//		processThread();
		runJSONParser("50");

		this.adapter = new TwitterAdapter(this, R.layout.twitter_row, m_results);
		setListAdapter(this.adapter);

		// loadResults = new Runnable() {
		//
		// public void run() {
		// callData();
		// }
		// };
		// Thread thread = new Thread(null, loadResults, "MagentoBackground");
		// thread.start();
		// m_ProgressDialog = ProgressDialog.show(TwitterActivity.this,
		// "Please wait...", "Retrieving data ...", true);

	}

	public InputStream getJSONData(String url) {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		URI uri;
		InputStream data = null;
		try {
			uri = new URI(url);
			HttpGet method = new HttpGet(uri);
			HttpResponse response = httpClient.execute(method);
			data = response.getEntity().getContent();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	public void runJSONParser(String rpp) {
		try {
			String searchUrl = "http://search.twitter.com/search.json?q=qconsp2011%20OR%20qconsp&result_type=mixed&rpp="
					+ rpp;
			Gson gson = new Gson();
			Reader r = new InputStreamReader(getJSONData(searchUrl));
			Tweet tweets = gson.fromJson(r, Tweet.class);
			for (Result result : tweets.getResults()) {
				m_results.add(result);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void callData() {
		runJSONParser("50");
		runOnUiThread(returnRes);
	}

	private Runnable returnRes = new Runnable() {

		public void run() {
			if (m_results != null && m_results.size() > 0) {
				adapter.notifyDataSetChanged();
				for (int i = 0; i < m_results.size(); i++)
					adapter.add(m_results.get(i));
			}
			m_ProgressDialog.dismiss();
			adapter.notifyDataSetChanged();
		}
	};

}
