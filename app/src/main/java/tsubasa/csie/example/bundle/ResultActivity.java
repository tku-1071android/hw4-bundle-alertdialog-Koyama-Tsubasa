package tsubasa.csie.example.bundle;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.text.NumberFormat;

public class ResultActivity extends Activity {

    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstantstate) {
        super.onCreate(savedInstantstate);
        setContentView(R.layout.resultlayout);
        tvResult = (TextView) findViewById(R.id.textView2);
        showResults();
    }

    private void showResults () {
        NumberFormat nf = NumberFormat.getInstance();
        Bundle bundle = getIntent().getExtras();
        int programming = bundle.getInt("programming");
        int datastructure = bundle.getInt("datastructure");
        int algorithms = bundle.getInt("algorithms");
        int sum = programming + datastructure + algorithms;
        double average = sum/3.0;
        String text = "programming = " + programming +
                "\ndatastructure = " + datastructure +
                "\nalgorithms = " + algorithms +
                "\nsum = " + sum +
                "\naverage = " + nf.format(average);
        tvResult.setText(text);
    }

    public void onBackClick (View view) {finish();}

}
