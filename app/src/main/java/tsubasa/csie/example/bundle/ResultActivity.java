package tsubasa.csie.example.bundle;

import android.app.Activity;
import android.app.AlertDialog;
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
        alert(average);
    }

    private void alert (double average) {

        String message = new String();
        String title = new String();
        int pic = 0;

        if (average == 100) {
            message = "Congratuation!!";
            title = "Pass";
            pic = R.drawable.check;
        }

        else if (average < 100 && average >=80) {
            message = "Good";
            title = "Pass";
            pic = R.drawable.circle;
        }

        else if (average < 80 && average >=60) {
            message = "Soso.....";
            title = "Pass";
            pic = R.drawable.triangle;
        }

        else {
            message = "Stupid";
            title = "Fail";
            pic = R.drawable.cross;
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton("OK",null);
        builder.setNegativeButton("Cancel",null);
        builder.setNeutralButton("Nothing",null);
        builder.setMessage(message);
        builder.setTitle(title);
        builder.setIcon(pic);
        builder.show();

    }

    public void onBackClick (View view) {finish();}

}
