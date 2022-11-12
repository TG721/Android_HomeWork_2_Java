package com.tengizmkcorp.homework2butinjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.tengizmkcorp.homework2butinjava.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        EditText inputField = binding.editTextNumber;
        Button button = binding.button;
        TextView answerTextView = binding.answerTV;

        button.setOnClickListener(view1 -> {
            String answer="";
            String input = inputField.getText().toString();
            int inputNum = Integer.parseInt(input);
            switch (input) {
                case "1000": {
                    answerTextView.setText(thousand);
                }
                case "0": {
                    answerTextView.setText("ნული");
                }
            }
                switch (input.length()) {
                    case 3: {
                        if(inputNum%100!=0) {
                            answer = arrHundreds[inputNum / 100 - 1] + " ";
                            input = Integer.toString(inputNum % 100);
                            inputNum = Integer.parseInt(input);
                        } else {
                            answerTextView.setText(arrHundreds[inputNum / 100 - 1] + "ი");
                            break;
                        }
                    }
                    case 1:
                    case 2: {
                        if (inputNum != 0) {
                            if (inputNum < 21) {
                                answer += arrUpToTwenty[inputNum];
                            } else if ((inputNum / 10) % 2 == 0) {
                                if (inputNum % 10 == 0)
                                    answer += dozenNums[(inputNum / 10) - 2] + arrUpToTwenty[(inputNum % 10)];
                                else
                                    answer += dozenNums[(inputNum / 10) - 2] + andWord + arrUpToTwenty[(inputNum % 10)];
                            } else
                                answer += dozenNums[(inputNum / 10) - 2] + andWord + arrUpToTwenty[(inputNum % 10) + 10];
                            answerTextView.setText(answer);
                        }
                    }
                }

        });
    }

    private String[] arrUpToTwenty = {"ი", "ერთი", "ორი", "სამი", "ოთხი", "ხუთი", "ექვსი", "შვიდი", "რვა", "ცხრა",
            "ათი", "თერთმეტი", "თორმეტი", "ცამეტი", "თოთხმეტი", "თხუთმეტი",
            "თექვსმეტი", "ჩვიდმეტი", "თვრამეტი", "ცხრამტი", "ოცი"};
    private String[] arrHundreds = {"ას", "ორას", "სამას", "ოთხას", "ხუთას",
            "ექვსას", "შვიდას", "რვაას", "ცხრაას"};
    private String[] dozenNums = {"ოც", "ოც", "ორმოც", "ორმოც", "სამოც", "სამოც",
            "ოთხმოც", "ოთხმოც"};
    private String  andWord = "და", thousand = "ათასი";

}