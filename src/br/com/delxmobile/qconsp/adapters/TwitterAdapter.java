package br.com.delxmobile.qconsp.adapters;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import br.com.delxmobile.qconsp.R;
import br.com.delxmobile.qconsp.objects.Result;

public class TwitterAdapter extends ArrayAdapter<Result> {

	private ArrayList<Result> items;

	public TwitterAdapter(Context context, int textViewResourceId,
			ArrayList<Result> items) {
		super(context, textViewResourceId, items);
		this.items = items;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;

		if (v == null) {
			LayoutInflater vi = (LayoutInflater) getContext().getSystemService(
					Context.LAYOUT_INFLATER_SERVICE);
			v = vi.inflate(R.layout.twitter_row, null);
		}

		Result o = items.get(position);
		if (o != null) {
			ImageView userImage = (ImageView) v.findViewById(R.id.user_image);
			TextView tt = (TextView) v.findViewById(R.id.username);
			TextView bt = (TextView) v.findViewById(R.id.tweet);
			if (userImage != null) {
				Drawable drawable = LoadImageFromWebOperations(o
						.getProfile_image_url());
				userImage.setImageDrawable(drawable);
			}
			if (tt != null) {
				tt.setText(o.getFrom_user());
			}
			if (bt != null) {
				bt.setText(o.getText());
			}
		}
		return v;
	}

	private Drawable LoadImageFromWebOperations(String url) {
		try {
			InputStream is = (InputStream) new URL(url).getContent();
			Drawable d = Drawable.createFromStream(is, "src name");
			return d;
		} catch (Exception e) {
			System.out.println("Exc=" + e);
			return null;
		}
	}

}
