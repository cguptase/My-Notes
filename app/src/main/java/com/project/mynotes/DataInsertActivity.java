package com.project.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.project.mynotes.databinding.ActivityDataInsertBinding;

public class DataInsertActivity extends AppCompatActivity {
    ActivityDataInsertBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDataInsertBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String type = getIntent().getStringExtra("type");
        if (type.equals("update")) {
            setTitle("update");
            binding.insertTitleET.setText(getIntent().getStringExtra("title"));
            binding.insertDescriptionET.setText(getIntent().getStringExtra("description"));
            int id = getIntent().getIntExtra("id", 0);
            binding.submitBtn.setText("update note");
            binding.submitBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("title", binding.insertTitleET.getText().toString());
                    intent.putExtra("description", binding.insertDescriptionET.getText().toString());
                    intent.putExtra("id", id);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            });
        } else {
            setTitle("Add Mode");
            binding.submitBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("title", binding.insertTitleET.getText().toString());
                    intent.putExtra("description", binding.insertDescriptionET.getText().toString());
                    setResult(RESULT_OK, intent);
                    finish();
                }
            });
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(DataInsertActivity.this, MainActivity.class));
    }
}