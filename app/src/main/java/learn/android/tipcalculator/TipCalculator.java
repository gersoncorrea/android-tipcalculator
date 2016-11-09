package learn.android.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import learn.android.tipcalculator.larn.android.util.Constants;

public class TipCalculator extends AppCompatActivity {
    private TextView amountTextView;
    private TextView tipTextView;
    private TextView totalTextView;
    private SeekBar percentSeekBar;
    private TextView percentTextView;
    private EditText amountEditText;
    private TextWatcher textWatcher;
    private Double percent = 0.15;
    private Double amount = 0.0;
    Constants constants;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);

        amountEditText = (EditText) findViewById(R.id.amountEditText);
        tipTextView = (TextView) findViewById(R.id.tipTextView);
        totalTextView = (TextView)findViewById(R.id.totalTextView);
        percentSeekBar = (SeekBar) findViewById(R.id.percentSeekBar);
        percentTextView = (TextView) findViewById(R.id.percentTextView);

        totalTextView.setText(Double.toString(0));
        tipTextView.setText(Double.toString(0));

        percentSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                percentTextView.setText(Integer.toString(progress) + "%");
                percent = progress/100.0;
                calculateTip();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        amountEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                try{

                    amount = Double.parseDouble(s.toString());
                }catch (NumberFormatException e){
                    amount = 0.0;
                }
                calculateTip();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }

    private void calculateTip(){

        double tip = amount * percent;
        double total = tip + amount;

        tipTextView.setText(String.format("%.2f",tip));
        totalTextView.setText(String.format("%.2f",total));
    }
}
