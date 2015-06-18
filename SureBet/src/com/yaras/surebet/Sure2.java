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
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.content.Intent;

/*Geliþtirici notlarý
 *intent olayý ile diðer bir sayfaya geçilecek
 *Sonuç sayýlarýn küsüratý çok 10 haneyi falan geçiyor, onu düzelt	****DÜZELTÝLDÝ
 *Tasarýmda öðelerin yerleri düzeltilebilir 						***KISMEN DÜZELTÝLDÝ,(iyileþtirilebilir)
 *renk uyumu deðiþtirilebilir
 *Uygulama simgesi
 */

public class Sure2 extends Activity {
	
	EditText oran1, oran2, bahis;
	TextView sonucText, sonucParaText, sonucOran1, sonucOran2;
	RadioGroup activitySelect;
	Button clr;
	double o1, o2, bhs;
	Intent i1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sure2);
		
		oran1 = (EditText) findViewById(R.id.Oran1Text);
		oran2 = (EditText) findViewById(R.id.Oran2Text);
		bahis = (EditText) findViewById(R.id.BahisText);
		clr = (Button) findViewById(R.id.CLR2);
		sonucText = (TextView) findViewById(R.id.SonucYuzde);
		sonucParaText = (TextView) findViewById(R.id.SonucPara2);
		sonucOran1 = (TextView) findViewById(R.id.Oran1Sonuc);
		sonucOran2 = (TextView) findViewById(R.id.Oran2Sonuc);
		activitySelect = (RadioGroup) findViewById(R.id.RadioGroup);
		i1 = new Intent(Sure2.this, Sure3.class);
		i1.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
		bahisListener();
		oran1Listener();
		oran2Listener();
		buttonListener();
		activitySelectListener();
	}
	
	public void activitySelectListener() {
		activitySelect
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {
					public void onCheckedChanged(RadioGroup group, int checkedId) {
						if (checkedId == R.id.SureBet3Options) {
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
				sonucParaText.setText("");
				sonucOran1.setText("");
				sonucOran2.setText("");
				sonucText.setText("");
			}
		});
	}
	
	private Boolean Parser() {
		if (!TextUtils.isEmpty(oran1.getText().toString())
				&& !TextUtils.isEmpty(oran2.getText().toString())
				&& !TextUtils.isEmpty(bahis.getText().toString())) {
			/*if (oran1.getText().toString().startsWith("."))
				oran1.getText().append('0');
			else if (oran2.getText().toString().startsWith("."))
				oran2.getText().append('0');
			else if (bahis.getText().toString().startsWith("."))
				bahis.getText().append('0');*/
			return true;
		}
		return false;
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
	
	private void GenTextListener() {
		
		if (Parser()) {
			o1 = Double.parseDouble(oran1.getText().toString());
			o2 = Double.parseDouble(oran2.getText().toString());
			bhs = Double.parseDouble(bahis.getText().toString());
			SureCalc sCalc = new SureCalc(o1, o2, bhs);
			sonucText.setText("%" + sCalc.yuzdeString());
			sonucParaText.setText(sCalc.paraString());
			sonucOran1.setText(sCalc.o1String());
			sonucOran2.setText(sCalc.o2String());
			double sonuc = sCalc.getYuzde();
			if (sonuc > 0)
				sonucText.setTextColor(getResources().getColor(R.color.Green));
			else
				sonucText.setTextColor(getResources().getColor(R.color.Red));
		}
		
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
