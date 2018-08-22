package com.lonewolf.together;

import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import es.dmoral.toasty.Toasty;

public class CreatePollsActivity extends AppCompatActivity {
    SharedPrefs sharedPrefs;
    int i = 1;
    private ArrayList<EditText> options = new ArrayList<>();
    PollData d =  new PollData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        sharedPrefs = new SharedPrefs(this);

        if (sharedPrefs.loadNightModeState()) setTheme(R.style.darkTheme);
        else setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_polls);
        final EditText pollQuestion = findViewById(R.id.poll_question);
        Button submit = findViewById(R.id.submit);
        ImageButton addEditText = findViewById(R.id.addEditText);

        final LinearLayout linearLayout = findViewById(R.id.editTextContainer);

        final LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        params.setMargins(0, 20, 0, 10);

        addEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createOptions(params, linearLayout);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setQuestion(pollQuestion);
                setOptions(options);
            }
        });
    }

    private void createOptions(LinearLayout.LayoutParams params, LinearLayout linearLayout) {
        EditText editText = new EditText(getApplicationContext());
        editText.setId(i);
        i++;
        editText.setHint("Option");
        editText.setHapticFeedbackEnabled(true);
        editText.setSingleLine(true);
        editText.isSoundEffectsEnabled();
        editText.isCursorVisible();
        editText.setTextColor(R.attr.textColor);
        editText.setInputType(InputType.TYPE_TEXT_FLAG_CAP_SENTENCES | InputType.TYPE_TEXT_FLAG_AUTO_CORRECT);
        editText.setLayoutParams(params);
        options.add(editText);
        linearLayout.addView(editText);
    }

    private void setQuestion(EditText pollQuestion) {
        if (pollQuestion.getText().toString().matches("")) Toasty.error(CreatePollsActivity.this, "Question can't be empty!", Toast.LENGTH_SHORT, true).show();
        else {
            d.setPollQuestion(pollQuestion.getText().toString());
            Log.i("mine", d.getPollQuestion());
        }
    }

    public void setOptions(ArrayList<EditText> editTextList) {
        Toast.makeText(this, "Im here", Toast.LENGTH_SHORT).show();
        for(EditText editText : editTextList) {
            Toast.makeText(this, editText.getText().toString(), Toast.LENGTH_SHORT).show();
            d.setOptions(editText.getText().toString());
        }
        for(String options : d.options)
        Log.i("mine", options);
    }
}
