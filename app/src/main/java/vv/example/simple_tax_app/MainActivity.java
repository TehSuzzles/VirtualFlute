package vv.example.simple_tax_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        // set references to widgets
        final Button calculateBtn = findViewById(R.id.calculateBtn);
        final TextView textOutputInv = findViewById(R.id.editTextBreakdown);
        final TextView incomeInput = findViewById(R.id.editTextIncomeValue);
        final TextView taxOutput = findViewById(R.id.taxTextView);
        final TextView afterTaxOutput = findViewById(R.id.afterTaxTextView);

        // Initialise Variables/Outputs
        textOutputInv.setText ("");


        //Method that completes calculations when "calculate" button is clicked
        calculateBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (incomeInput.length() == 0) {
                    textOutputInv.setText("ERROR: Please enter an income value");
                }
                else{
                  double incomeValue = Double.parseDouble(incomeInput.getText().toString());

                  if (incomeValue < 14000){
                      double taxValue = incomeValue/100*10.5;
                      double afterTaxValue = incomeValue - taxValue;

                      NumberFormat formatter = new DecimalFormat("###,###,###.##");
                      String formattedTaxValue = formatter.format(taxValue);
                      String formattedAfterTaxValue = formatter.format(afterTaxValue);
                      String formattedIncomeValue = formatter.format(incomeValue);


                     // taxOutput.setText(String.valueOf(taxValue));
                      //afterTaxOutput.setText(String.valueOf(afterTaxValue));
                      //textOutputInv.setText("Income under $14k taxed at 10.5%: $"+ incomeValue +"\r\n" );
                      taxOutput.setText(formattedTaxValue);
                      afterTaxOutput.setText(formattedAfterTaxValue);
                      textOutputInv.setText("Income under $14k taxed at 10.5%: $"+ formattedIncomeValue +"\r\n" );
                  }

                  else if (incomeValue > 14000 & incomeValue <= 48000) {
                      double taxBracket1 = 14000/100*10.5;
                      double nextBracketValue = incomeValue - 14000;
                      double taxCalc = nextBracketValue/100*17.5;
                      double taxValue = taxCalc+taxBracket1;
                      double afterTaxValue = incomeValue - taxValue;

                      NumberFormat formatter = new DecimalFormat("###,###,###.##");
                      String formattedTaxValue = formatter.format(taxValue);
                      String formattedAfterTaxValue = formatter.format(afterTaxValue);
                      String formattedIncomeValue = formatter.format(incomeValue);
                      String formattedNextBracketValue = formatter.format(nextBracketValue);

                     // taxOutput.setText(String.valueOf(taxValue));
                     // afterTaxOutput.setText(String.valueOf(afterTaxValue));
                      taxOutput.setText(formattedTaxValue);
                      afterTaxOutput.setText(formattedAfterTaxValue);
                      textOutputInv.setText("Income under $14k taxed at 10.5%: $14,000.00 "+ "\r\n" +
                                            "Income over $14k taxed at 17.5%: $" + formattedNextBracketValue);
                  }

                  else if (incomeValue > 48000 & incomeValue <= 70000) {
                      double taxBracket1 = 14000/100*10.5;
                      double taxBracket2 = 34000/100*17.5;

                      double nextBracketValue = incomeValue - 48000;
                      double taxCalc = nextBracketValue/100*30;
                      double taxValue = taxCalc+taxBracket1+taxBracket2;
                      double afterTaxValue = incomeValue - taxValue;

                      NumberFormat formatter = new DecimalFormat("###,###,###.##");
                      String formattedTaxValue = formatter.format(taxValue);
                      String formattedAfterTaxValue = formatter.format(afterTaxValue);
                      String formattedIncomeValue = formatter.format(incomeValue);
                      String formattedNextBracketValue = formatter.format(nextBracketValue);

                     // taxOutput.setText(String.valueOf(taxValue));
                     // afterTaxOutput.setText(String.valueOf(afterTaxValue));
                      taxOutput.setText(formattedTaxValue);
                      afterTaxOutput.setText(formattedAfterTaxValue);
                      textOutputInv.setText("Income under $14k taxed at 10.5%: $14,000.00 "+ "\r\n" +
                              "Income over $14k taxed at 17.5%: $34,000.00" +"\r\n" + "Income over $48k taxed at 30%: $" + formattedNextBracketValue);
                  }

                  else if (incomeValue > 70000 & incomeValue <= 180000) {
                      double taxBracket1 = 14000/100*10.5;
                      double taxBracket2 = 34000/100*17.5;
                      double taxBracket3 = 22000/100*30;
                      double nextBracketValue = incomeValue - 70000;
                      double taxCalc = nextBracketValue/100*33;
                      double taxValue = taxCalc+taxBracket1+taxBracket2+taxBracket3;
                      double afterTaxValue = incomeValue - taxValue;

                      //taxOutput.setText(String.valueOf(taxValue));
                      //afterTaxOutput.setText(String.valueOf(afterTaxValue));

                      NumberFormat formatter = new DecimalFormat("###,###,###.##");
                      String formattedTaxValue = formatter.format(taxValue);
                      String formattedAfterTaxValue = formatter.format(afterTaxValue);
                      String formattedIncomeValue = formatter.format(incomeValue);
                      String formattedNextBracketValue = formatter.format(nextBracketValue);

                      taxOutput.setText(formattedTaxValue);
                      afterTaxOutput.setText(formattedAfterTaxValue);

                      textOutputInv.setText("Income under $14k taxed at 10.5%: $14,000.00 "+ "\r\n" +
                              "Income over $14k taxed at 17.5%: $34,000.00" +"\r\n"
                              + "Income over $48k taxed at 30%: $22,000" +"\r\n"+
                                      "Income over $70k taxed at 33%: $" +"\r\n"+
                              formattedNextBracketValue);

                  }
                  else if ( incomeValue > 180000) {
                      double taxBracket1 = 14000/100*10.5;
                      double taxBracket2 = 34000/100*17.5;
                      double taxBracket3 = 22000/100*30;
                      double taxBracket4 = 110000/100*33;

                      double nextBracketValue = incomeValue - 180000;
                      double taxCalc = nextBracketValue/100*39;
                      double taxValue = taxCalc+taxBracket1+taxBracket2+taxBracket3+taxBracket4;
                      double afterTaxValue = incomeValue - taxValue;

                      NumberFormat formatter = new DecimalFormat("###,###,###.##");
                      String formattedTaxValue = formatter.format(taxValue);
                      String formattedAfterTaxValue = formatter.format(afterTaxValue);
                      String formattedIncomeValue = formatter.format(incomeValue);
                      String formattedNextBracketValue = formatter.format(nextBracketValue);

                     // taxOutput.setText(String.valueOf(taxValue));
                     // afterTaxOutput.setText(String.valueOf(afterTaxValue));
                      taxOutput.setText(formattedTaxValue);
                      afterTaxOutput.setText(formattedAfterTaxValue);

                      textOutputInv.setText("Income under $14k taxed at 10.5%: $14,000.00 "+ "\r\n" +
                              "Income over $14k taxed at 17.5%: $34,000.00" +"\r\n"
                              + "Income over $48k taxed at 30%: $22,000.00" +"\r\n"+
                              "Income over $70k taxed at 33%: $110,000.00"+"\r\n" + "Income over $180k taxed at 39%: $" +
                              formattedNextBracketValue);

                  }
                    reset();
                }
            }
        });
        }
    public void reset() {
        //references
       // final TextView textOutputInv = findViewById(R.id.editTextBreakdown);
        final TextView incomeInput = findViewById(R.id.editTextIncomeValue);
        //final TextView taxOutput = findViewById(R.id.taxTextView);
       // final TextView afterTaxOutput = findViewById(R.id.afterTaxTextView);

        // resetting variables
        incomeInput.setText("");
       // taxOutput.setText("");
       // afterTaxOutput.setText("");
       // textOutputInv.setText("");
    }

    }