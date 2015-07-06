package com.taha.testjason;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	TextView id;
	TextView name;
	EditText editId;
	EditText editName;
	CheckBox chk;
	Button bSave;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		intialize();

		bSave.setOnClickListener(this);

	}

	private void intialize() {
		// TODO Auto-generated method stub
		id = (TextView) findViewById(R.id.tvid);
		name = (TextView) findViewById(R.id.tvName);
		editId = (EditText) findViewById(R.id.edId);
		editName = (EditText) findViewById(R.id.edName);
		chk = (CheckBox) findViewById(R.id.cStauts);
		bSave = (Button) findViewById(R.id.bwrite);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Toast.makeText(MainActivity.this, "Button has been pressed",
				Toast.LENGTH_LONG).show();
		jsonWrite();

	}

	private void jsonWrite() {
		// TODO Auto-generated method stub
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("id", editId.getText().toString());
			jsonObject.put("name", editName.getText().toString());
			jsonObject.put("chk", chk.isChecked());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		System.out.println(jsonObject);
		finish();
	}
}
