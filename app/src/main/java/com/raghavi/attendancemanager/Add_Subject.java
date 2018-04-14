package com.raghavi.attendancemanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static java.lang.Integer.parseInt;

public class Add_Subject extends AppCompatActivity {

    public EditText addsubjectNameEditText;
    public EditText addsubjectTotalLecEditText;
    public EditText addsubjectBunkedLecEditText;
    Button addSubDataButton;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__subject);

        initialise();



        addSubDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Float per;

                String subNameString = addsubjectNameEditText.getText().toString();

                String bunkedLecturesString = addsubjectBunkedLecEditText.getText().toString();
                int bunkedLecInt = parseInt(bunkedLecturesString);

                String totalLecturesString = addsubjectTotalLecEditText.getText().toString();
                int totalLecInt = parseInt(totalLecturesString);

                per = (float) (((bunkedLecInt) * 100) / totalLecInt);

                subjectData obj = new subjectData();
                obj.setSubName(subNameString);
                obj.setBunkedLec(bunkedLecInt);
                obj.setMinPercent(per);
                obj.setTotalLec(totalLecInt);

                SubjectUpdate.dataset.add(obj);

                Intent in = new Intent(getApplicationContext(), SubjectUpdate.class);
                in.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(in);
            }
        });


    }

public void initialise()
{
    addSubDataButton = (Button) findViewById(R.id.add_subject_data_button);
    addsubjectNameEditText = (EditText) findViewById(R.id.add_subject_name_editText);
    addsubjectTotalLecEditText = (EditText) findViewById(R.id.add_subject_totalLec_editText);
    addsubjectBunkedLecEditText = (EditText) findViewById(R.id.add_subject_bunkedLec_editText);

}

}
