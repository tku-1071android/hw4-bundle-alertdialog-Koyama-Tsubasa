package tsubasa.csie.example.bundle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    private EditText etProgramming,etDataStructure,etAlgorithms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        etProgramming = (EditText)findViewById(R.id.etProgramming);
        etDataStructure = (EditText)findViewById(R.id.etDataStructure);
        etAlgorithms = (EditText)findViewById(R.id.etAlgorithms);
    }

    private boolean isValid (EditText edittext) {
        String pattern = "1[0]{2} | [0-9]{1,2}";
        String text = edittext.getText().toString();
        if (!text.matches(pattern)) {
            edittext.setError("0~100");
            return false;
        }
        else {
            return true;
        }
    }

    public void onSubmitClick (View view) {
        boolean isValid = isValid(etProgramming) & isValid(etAlgorithms) & isValid(etDataStructure);
        if (!isValid) {
            return;
        }
        int programming = Integer.parseInt(etProgramming.getText().toString());
        int datastructure = Integer.parseInt(etDataStructure.getText().toString());
        int algorithms = Integer.parseInt(etAlgorithms.getText().toString());
        Intent intent = new Intent(this,ResultActivity.class);
        Bundle bundle  = new Bundle();
        bundle.putInt("programming",programming);
        bundle.putInt("datastructure",datastructure);
        bundle.putInt("algorithms",algorithms);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}
