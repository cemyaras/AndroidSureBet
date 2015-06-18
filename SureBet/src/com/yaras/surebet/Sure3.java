package com.yaras.surebet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class Sure3 extends Activity {
	EditText oran1, oran2, oran3, bahis;
	TextView sonucText, sonucParaText, sonucOran1, sonucOran2, sonucOran3;
	RadioGroup activitySelect;
	Button clr;
	double o1, o2, o3, bhs;
	Intent i1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sure3);
		
		oran1 = (EditText) findViewById(R.id.Oran1Text_3);
		oran2 = (EditText) findViewById(R.id.Oran2Text_3);
		oran3 = (EditText) findViewById(R.id.Oran3Text_3);
		bahis = (EditText) findViewById(R.id.BahisText_3);
		clr = (Button) findViewById(R.id.CLR3);
		sonucText = (TextView) findViewById(R.id.SonucYuzde_3);
		sonucParaText = (TextView) findViewById(R.id.SonucPara3);
		sonucOran1 = (TextView) findViewById(R.id.Oran1Sonuc_3);
		sonucOran2 = (TextView) findViewById(R.id.Oran2Sonuc_3);
		sonucOran3 = (TextView) findViewById(R.id.Oran3Sonuc_3);
		activitySelect = (RadioGroup) findViewById(R.id.RadioGroup3);
		i1 = new Intent(Sure3.this, Sure2.class);
		i1.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
		bahisListener();
		oran1Listener();
		oran2Listener();
		oran3Listener();
		buttonListener();
		activitySelectListener();
		
	}
	
	public void activitySelectListener() {
		activitySelect
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {
					public void onCheckedChanged(RadioGroup group, int checkedId) {
						if (checkedId == R.id.SureBet2Options_3) {
							startActivity(i1);
							overridePendingTransition(R.anim.alpha,
									R.anim.alpha);
							finish();
						}
					}
				});
	}
	
	public void buttonListener() {
		clr.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				oran1.getText().clear();
				oran2.getText().clear();
				oran3.getText().clear();
				sonucParaText.setText("");
				sonucOran1.setText("");
				sonucOran2.setText("");
				sonucOran3.setText("");
				sonucText.setText("");
			}
		});
	}
	
	private Boolean Parser() {
		if (!TextUtils.isEmpty(oran1.getText().toString())
				&& !TextUtils.isEmpty(oran2.getText().toString())
				&& !TextUtils.isEmpty(oran3.getText().toString())
				&& !TextUtils.isEmpty(bahis.getText().toString())) {
			/*if (oran1.getText().toString().startsWith("."))
				oran1.getText().append('0');
			else if (oran2.getText().toString().startsWith("."))
				oran2.getText().append('0');
			else if (oran3.getText().toString().startsWith("."))
				oran3.getText().append('0');
			else if (bahis.getText().toString().startsWith("."))
				bahis.getText().append('0');*/
			return true;
		}
		return false;
	}
	
	private void GenTextListener() {
		
		if (Parser()) {
			o1 = Double.parseDouble(oran1.getText().toString());
			o2 = Double.parseDouble(oran2.getText().toString());
			o3 = Double.parseDouble(oran3.getText().toString());
			bhs = Double.parseDouble(bahis.getText().toString());
			SureCalc sCalc = new SureCalc(o1, o2, o3, bhs);
			sonucText.setText("%" + sCalc.yuzdeString());
			sonucParaText.setText(sCalc.paraString());
			sonucOran1.setText(sCalc.o1String());
			sonucOran2.setText(sCalc.o2String());
			sonucOran3.setText(sCalc.o3String());
			double sonuc = sCalc.getYuzde();
			if (sonuc > 0)
				sonucText.setTextColor(getResources().getColor(R.color.Green));
			else
				sonucText.setTextColor(getResources().getColor(R.color.Red));
		}
		
	}
	
	public void bahisListener() {
		bahis.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {
				GenTextListener();
			}
			
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}
			
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				
			}
		});
	}
	
	public void oran1Listener() {
		oran1.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {
				GenTextListener();
			}
			
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}
			
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				
			}
		});
	}
	
	public void oran2Listener() {
		oran2.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {
				GenTextListener();
			}
			
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}
			
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				
			}
		});
	}
	
	public void oran3Listener() {
		oran3.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {
				GenTextListener();
			}
			
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}
			
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sure2, menu);
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
}
