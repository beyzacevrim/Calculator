/*
Beyza ÇEVRİM / 7.june.2023
*/

package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity {
    TextView operationTV, resultTV;
    String operationStr = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get references to the TextViews for displaying the operation and result.
        operationTV = findViewById(R.id.textView_top);
        resultTV = findViewById(R.id.textView_bottom);
    }

    // Append the input value to the operation string and update the operation TextView.
    public void setOperation(String value) {
        operationStr = operationStr + value;
        operationTV.setText(operationStr);
    }

    // Clear the operation string and update the operation TextView.
    public void allClearOnClick(View view) {
        operationTV.setText("");
        operationStr = "";
    }

    // This method will be used to delete the last character from the operation string.
    public void DelOnClick(View view) {
        // Implementation is not provided in the original code.
        // You can add the implementation here if needed.
    }

    // Evaluate the operation string and display the result in the result TextView.
    public void equalsOnClick(View view) {
        Double result = null;

        // Replace all occurrences of 'x' with '*' in the operation string.
        operationStr = operationStr.replace('x', '*');

        // Create a script engine to evaluate the operation string.
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
        try {
            // Evaluate the operation string.
            Object evalResult = engine.eval(operationStr);
            if (evalResult instanceof Number) {
                // If the evaluation result is a number, get its value as a double.
                result = ((Number) evalResult).doubleValue();

            } else {
                // Handle the case when the evaluation result is not a number.
                Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show();
            }
        } catch (ScriptException e) {
            // Handle script evaluation errors.
            Toast.makeText(this, "Error in script evaluation", Toast.LENGTH_SHORT).show();
        }

        // If the result is not null, display it in the result TextView.
        if (result != null) {
            resultTV.setText(String.valueOf(result));
        }
    }

    // The following methods set the corresponding input values when the respective buttons are clicked.
    public void plusOnClick(View view) {
        setOperation("+");
    }

    public void minusOnClick(View view) {
        setOperation("-");
    }

    public void multiplyOnClick(View view) {
        setOperation("x");
    }

    public void divideOnClick(View view) {
        setOperation("/");
    }

    public void modOnClick(View view) {
        setOperation("%");
    }

    public void dotOnClick(View view) {
        setOperation(".");
    }

    public void nineOnClick(View view) {
        setOperation("9");
    }

    public void eightOnClick(View view) {
        setOperation("8");
    }

    public void sevenOnClick(View view) {
        setOperation("7");
    }

    public void sixOnClick(View view) {
        setOperation("6");
    }

    public void fiveOnClick(View view) {
        setOperation("5");
    }

    public void fourOnClick(View view) {
        setOperation("4");
    }

    public void threeOnClick(View view) {
        setOperation("3");
    }

    public void twoOnClick(View view) {
        setOperation("2");
    }

    public void oneOnClick(View view) {
        setOperation("1");
    }

    public void zeroOnClick(View view) {
        setOperation("0");
    }
}
