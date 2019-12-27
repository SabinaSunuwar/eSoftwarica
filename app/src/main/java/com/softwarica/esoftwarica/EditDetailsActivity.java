package com.softwarica.esoftwarica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class EditDetailsActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    EditText etName, etAge, etAddress;
    RadioGroup rdoGender;
    RadioButton rdoMale, rdoFemale, rdoeOthers;
    Button btnUpdate;
    String name, address, gender;
    int age;
    public static int index;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_details);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * .8), (int) (height * .8));

        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        etAddress = findViewById(R.id.etAddress);
        btnUpdate = findViewById(R.id.btnUpdate);
        rdoGender = findViewById(R.id.rdoGender);
        rdoMale = findViewById(R.id.rdoMale);
        rdoFemale = findViewById(R.id.rdoFemale);
        rdoeOthers = findViewById(R.id.rdoOthers);
        etName.setText(MainActivity.studentsList.get(index).getName());
        etAge.setText(MainActivity.studentsList.get(index).getAge() + "");
        etAddress.setText(MainActivity.studentsList.get(index).getAddress());
        gender = MainActivity.studentsList.get(index).getGender();
        if (gender == "male") {
            rdoMale.setChecked(true);
            rdoFemale.setChecked(false);
            rdoeOthers.setChecked(false);
        } else if (gender == "female") {
            rdoMale.setChecked(false);
            rdoFemale.setChecked(true);
            rdoeOthers.setChecked(false);
        }
        if (gender == "other") {
            rdoMale.setChecked(false);
            rdoFemale.setChecked(false);
            rdoeOthers.setChecked(true);
        }


        rdoGender.setOnCheckedChangeListener(this);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()) {
                    name = etName.getText().toString();
                    address = etAddress.getText().toString();
                    age = Integer.parseInt(etAge.getText().toString());
                    try {
                        MainActivity.studentsList.get(index).setName(name);
                        MainActivity.studentsList.get(index).setAddress(address);
                        MainActivity.studentsList.get(index).setAge(age);
                        MainActivity.studentsList.get(index).setGender(gender);
                        Toast.makeText(EditDetailsActivity.this, "Student Details Updated", Toast.LENGTH_SHORT).show();
                        finish();
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(EditDetailsActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

    private boolean validate() {
        if (TextUtils.isEmpty(etName.getText())) {
            etName.setError("Enter full name");
            etName.requestFocus();
            return false;
        } else if (TextUtils.isEmpty(etAge.getText())) {
            etAge.setError("Enter the age");
            etAge.requestFocus();
            return false;
        } else if (TextUtils.isEmpty(etAddress.getText())) {
            etAddress.setError("Enter the address");
            etAddress.requestFocus();
            return false;
        } else if (TextUtils.isEmpty(gender)) {
            Toast.makeText(EditDetailsActivity.this, "Select gender", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }




    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (i == R.id.rdoMale) {
            gender = "male";
        }
        if (i == R.id.rdoFemale) {
            gender = "female";
        }
        if (i == R.id.rdoOthers) {
            gender = "other";
        }
    }
}

