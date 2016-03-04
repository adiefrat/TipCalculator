package tipcalculator.huji.ac.il.tipcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class TipCalculatorActivity extends Activity implements View.OnClickListener {
    private Button calcButton;
    private RelativeLayout layout;
    private EditText edt, inputNumber;
    private CheckBox chkRound;
    private double billAmount, tip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
        //layout = (RelativeLayout) findViewById(R.id.relativeLayout);
        inputNumber = (EditText)findViewById(R.id.inputNumber);
        chkRound = (CheckBox)findViewById(R.id.chkRound);
        calcButton = (Button)findViewById(R.id.btnCalculate);
        calcButton.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tip_calculator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        if(view == calcButton){
            billAmount = Double.parseDouble(inputNumber.getText().toString());
            tip = billAmount * 0.12;
            if(chkRound.isChecked()){
                tip = Math.round(tip);
            }
            edt = (EditText)findViewById(R.id.txtTipResult);
            edt.setText("Tip:$" + String.format("%,.2f", tip));
            }
    }
}
