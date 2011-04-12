package uk.ac.nott.cs.itxpm;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class calc extends Activity implements OnClickListener {
	TextView textInput;
	int opPlus = 0, opEquals = 0, opMinus = 0, opDivision = 0, opProduct = 0;
	Double numLeft, numRight, numResult;
	Button btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix,
			btnSeven, btnEight, btnNine, btnPlus, btnMinus, btnDivision,
			btnProduct, btnEquals, btnClear, btnPoint;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		textInput = (TextView) findViewById(R.id.txtInput);
		btnZero = (Button) findViewById(R.id.buttonZero);
		btnZero.setOnClickListener(this);
		btnOne = (Button) findViewById(R.id.buttonOne);
		btnOne.setOnClickListener(this);
		btnTwo = (Button) findViewById(R.id.buttonTwo);
		btnTwo.setOnClickListener(this);
		btnThree = (Button) findViewById(R.id.buttonThree);
		btnThree.setOnClickListener(this);
		btnFour = (Button) findViewById(R.id.buttonFour);
		btnFour.setOnClickListener(this);
		btnFive = (Button) findViewById(R.id.buttonFive);
		btnFive.setOnClickListener(this);
		btnSix = (Button) findViewById(R.id.buttonSix);
		btnSix.setOnClickListener(this);
		btnSeven = (Button) findViewById(R.id.buttonSeven);
		btnSeven.setOnClickListener(this);
		btnEight = (Button) findViewById(R.id.buttonEight);
		btnEight.setOnClickListener(this);
		btnNine = (Button) findViewById(R.id.buttonNine);
		btnNine.setOnClickListener(this);
		btnPoint = (Button) findViewById(R.id.buttonPoint);
		btnPoint.setOnClickListener(this);
		btnPlus = (Button) findViewById(R.id.buttonPlus);
		btnPlus.setOnClickListener(this);
		btnMinus = (Button) findViewById(R.id.buttonMinus);
		btnMinus.setOnClickListener(this);
		btnDivision = (Button) findViewById(R.id.buttonDivision);
		btnDivision.setOnClickListener(this);
		btnProduct = (Button) findViewById(R.id.buttonProduct);
		btnProduct.setOnClickListener(this);
		btnEquals = (Button) findViewById(R.id.buttonEquals);
		btnEquals.setOnClickListener(this);
		btnClear = (Button) findViewById(R.id.buttonClear);
		btnClear.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String currentInput = textInput.getText().toString();

		if (opEquals > 0) {
			textInput.setText("");
			opEquals = 0;
		}

		if (v == btnClear) {
			numLeft = 0.0;
			numRight = 0.0;
			textInput.setText("");
		}
		if (v == btnZero) {
			if (currentInput.equals("0"))
				return;
			else
				textInput.append(btnZero.getText());
		}
		if (v == btnOne) {
			textInput.append(btnOne.getText());
		}
		if (v == btnTwo) {
			textInput.append(btnTwo.getText());
		}
		if (v == btnThree) {
			textInput.append(btnThree.getText());
		}
		if (v == btnFour) {
			textInput.append(btnFour.getText());
		}
		if (v == btnFive) {
			textInput.append(btnFive.getText());
		}
		if (v == btnSix) {
			textInput.append(btnSix.getText());
		}
		if (v == btnSeven) {
			textInput.append(btnSeven.getText());
		}
		if (v == btnEight) {
			textInput.append(btnEight.getText());
		}
		if (v == btnNine) {
			textInput.append(btnNine.getText());
		}
		if (v == btnPoint) {
			if (currentInput.contains(".") || currentInput.equals(""))
				return;
			else
				textInput.append(btnPoint.getText());
		}
		if (v == btnProduct && !currentInput.equals("")) {
			numLeft = Double.parseDouble(currentInput);
			opProduct = 1;
			textInput.setText("");
		}
		if (v == btnDivision && !currentInput.equals("")) {
			numLeft = Double.parseDouble(currentInput);
			opDivision = 1;
			textInput.setText("");
		}
		if (v == btnPlus && !currentInput.equals("")) {
			numLeft = Double.parseDouble(currentInput);
			opPlus = 1;
			textInput.setText("");
		}
		if (v == btnMinus && !currentInput.equals("")) {
			numLeft = Double.parseDouble(currentInput);
			opMinus = 1;
			textInput.setText("");
		}
		if (v == btnEquals) {
			opEquals = 1;
			if (currentInput.equals("")) {
				numRight = 0.0;
			} else {
				numRight = Double.parseDouble(currentInput);
			}
			if (opPlus > 0) {
				textInput.setText(doubleToString(numLeft + numRight));
				opPlus = 0;
			}
			if (opMinus > 0) {
				textInput.setText(doubleToString(numLeft - numRight));
				opMinus = 0;
			}
			if (opProduct > 0) {
				textInput.setText(doubleToString(numLeft * numRight));
				opProduct = 0;
			}
			if (opDivision > 0 && numRight != 0.0) {
				textInput.setText(doubleToString(numLeft / numRight));
				opDivision = 0;
			}
		}
	}

	private String doubleToString(double value) {
		if (Double.isNaN(value))
			return null;

		long longVal = (long) value;
		if (longVal == value)
			return Long.toString(longVal);
		else
			return Double.toString(value);
	}

}