package net.cs.jimisthebest.t4rge7.xfixcalc;
/**
 * 
 * @author James Roberts jpr242
 *
 */
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends Activity {
	
	private boolean auto = true, pre = false, post = false, in = false;

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
		final Button left = (Button) findViewById(R.id.left);
		final Button right = (Button) findViewById(R.id.right);
		final ToggleButton auto = (ToggleButton) findViewById(R.id.autoToggle);
		final RadioGroup group = (RadioGroup) findViewById(R.id.group);

		
		auto.setChecked(true);
		
		
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
		left.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				otherButton(v, 8);
			}
		});
		right.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				otherButton(v, 9);
			}
		});
		auto.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				toggle(0);
			}
		});

		group.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				toggle(1);
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
		TextView tv = (TextView) this.findViewById(R.id.tv);
		EditText input = (EditText) this.findViewById(R.id.input);
//		RadioButton pre = (RadioButton) findViewById(R.id.pre);
//		RadioButton post = (RadioButton) findViewById(R.id.post);
//		RadioButton in = (RadioButton) findViewById(R.id.in);
		String toChange = "";
		String temp = input.getText().toString();
		boolean end = true;
		while(temp.charAt(0) == ' ') {
			temp = temp.substring(1);
	//		System.out.println(true);
		}
		while(temp.charAt(temp.length() - 1) == ' ') {
			temp = temp.substring(0, temp.length() -1);
		}
		while(temp.contains("  ")) {
			temp = temp.replaceFirst("  ", " ");
		}
		char zero = temp.charAt(0), last = temp.charAt(temp.length() - 1);
		
		if(this.auto) {
			if (zero == '+' || zero == '-' || zero == '*' || zero == '/') {
				// prefix
				this.pre = true;
				this.post = false;
				this.in = false;
				tv.setText("Auto: Prefix");
			} else if (last == '+' || last == '-' || last == '*' || last == '/') {
				// postfix
				this.pre = false;
				this.post = true;
				this.in = false;
				tv.setText("Auto: Postfix");
			} else {
				// infix
				this.pre = false;
				this.post = false;
				this.in = true;
				tv.setText("Auto: Infix");
			}
		} else {
			if(this.pre) {
				tv.setText("Manual: Prefix");
			} else if(this.post) {
				tv.setText("Manual: Postfix");
			} else if(this.in) {
				tv.setText("Manual: Infix");
			}
		}
		
		
		tv.setText(tv.getText() + " -> " + temp);
		
		try {
			if (this.pre) {
				// prefix
				PreFix prefix = new PreFix(temp);
				toChange = " " + prefix.answer();
				end = false;
			} else if (this.post) {
				// postfix
				PostFix postfix = new PostFix(temp);
				toChange = postfix.answer() + " ";
			} else if (this.in){
				// infix
				InFix infix = new InFix(temp);
				toChange = infix.answer() + "";
			}
			input.setTextColor(Color.BLACK);
		} catch (IllegalInputException e) {
			toChange = e.getMessage();
			input.setTextColor(Color.RED);
		} catch (OperandsException e) {
			toChange = e.getMessage();
			input.setTextColor(Color.RED);
		} catch (OperationsException e) {
			toChange = e.getMessage();
			input.setTextColor(Color.RED);
		} catch (ZeroDivisionException e) {
			toChange = e.getMessage();
			input.setTextColor(Color.RED);
		}
		input.setText(toChange);
		if (input.getTextColors().equals(Color.RED)) {
			input.setSelection(0, input.length());
		} else if(!end) {
			input.setSelection(0);
		} else {
			input.setSelection(input.length());
		}
		
		if(!(temp.contains("+") || temp.contains("-") || temp.contains("*") || temp.contains("/")) && temp.matches("\\s*[\\d]*[\\.]?[\\d]*\\s*")) {
			input.setText(temp.replaceAll(" ", ""));
			input.setSelection(input.length());
			input.setTextColor(Color.BLACK);
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
			input.setTextColor(Color.BLACK);
			break;
		case 7:
			in += ".";
			break;
		case 8:
			in += "(";
			break;
		case 9:
			in += ")";
			break;
		}
		input.setText(in);
		input.setSelection(input.length());
	}
	
	public void toggle(int i) {
//		EditText input = (EditText) this.findViewById(R.id.input);
		ToggleButton auto = (ToggleButton) findViewById(R.id.autoToggle);
		RadioGroup group = (RadioGroup) findViewById(R.id.group);
		RadioButton pre = (RadioButton) findViewById(R.id.pre);
		RadioButton post = (RadioButton) findViewById(R.id.post);
		RadioButton in = (RadioButton) findViewById(R.id.in);
		
//		input.setText("CAlled");
		if(i == 0) {
			auto.setChecked(true);
			auto.setChecked(true);
			pre.setChecked(false);
			post.setChecked(false);
			in.setChecked(false);
//			input.setText("HERE");
				this.auto = true;
				this.pre = false;
				this.post = false;
				this.in = false;
		} else {
//			input.setText("Radio");
			auto.setChecked(false);

			if(group.getCheckedRadioButtonId() == R.id.pre) {
				this.auto = false;
				this.pre = true;
				this.post = false;
				this.in = false;
			} else if(group.getCheckedRadioButtonId() == R.id.post) {
				this.auto = false;
				this.pre = false;
				this.post = true;
				this.in = false;
			} else if(group.getCheckedRadioButtonId() == R.id.in) {
				this.auto = false;
				this.pre = false;
				this.post = false;
				this.in = true;
			}
		}
	}

}
