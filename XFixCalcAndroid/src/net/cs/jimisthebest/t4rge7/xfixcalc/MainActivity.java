package net.cs.jimisthebest.t4rge7.xfixcalc;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		EditText input = (EditText) this.findViewById(R.id.input);
		input.setOnEditorActionListener(new TextView.OnEditorActionListener() {
			
			@Override
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				calculate(null);
				return true;
			}
		});
		final Button add = (Button) findViewById(R.id.add);
		final Button subtract = (Button) findViewById(R.id.subtract);
		final Button multiply = (Button) findViewById(R.id.multiply);
		final Button divide = (Button) findViewById(R.id.divide);
		final Button space = (Button) findViewById(R.id.space);
		final Button clear = (Button) findViewById(R.id.clear);
		final Button decimal = (Button) findViewById(R.id.decimal);
		final Button calculate = (Button) findViewById(R.id.calculate);

		add.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				otherButton(findViewById(R.id.input), 1);
			}
		});
		subtract.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				otherButton(v, 2);
			}
		});
		multiply.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				otherButton(v, 3);
			}
		});
		divide.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				otherButton(v, 4);
			}
		});
		space.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				otherButton(v, 5);
			}
		});
		clear.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				otherButton(v, 6);
			}
		});
		decimal.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				otherButton(v, 7);
			}
		});
		calculate.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				calculate(v);
			}
		});

		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void calculate(View view) {
		EditText input = (EditText) this.findViewById(R.id.input);
		String toChange = "";
		char zero = input.getText().charAt(0), last = input.getText().charAt(input.length() - 1);
		if (zero == '+' || zero == '-' || zero == '*' || zero == '/') {
			// prefix
		} else if (last == '+' || last == '-' || last == '*' || last == '/') {
			try {
				PostFix test = new PostFix(input.getText().toString());
				toChange = test.answer() + " ";
				input.setTextColor(Color.BLACK);
				input.setText(toChange);
				input.setSelection(input.length());
			} catch (IllegalInputException e) {
				// TODO Auto-generated catch block
				toChange = e.getMessage();
				input.setTextColor(Color.RED);
				input.setText(toChange);
			}
		}

	}

	public void otherButton(View view, int i) {
		EditText input = (EditText) this.findViewById(R.id.input);
		String in = input.getText().toString();
		switch (i) {
		case 1:
			in += "+";
			break;
		case 2:
			in += "-";
			break;
		case 3:
			in += "*";
			break;
		case 4:
			in += "/";
			break;
		case 5:
			in += " ";
			break;
		case 6:
			in = "";
			break;
		case 7:
			in += ".";
			break;
		}
		input.setText(in);
		input.setSelection(input.length());
	}

}
