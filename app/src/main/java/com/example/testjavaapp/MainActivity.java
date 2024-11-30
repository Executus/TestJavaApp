package com.example.testjavaapp;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.example.testjavaapp.databinding.ActivityMainBinding;
import com.example.testnativelib.NativeLib;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Create an instance of the native lib
        NativeLib nativeLib = new NativeLib();

        // Click handler for the Call Native Lib button
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Disable the button
                binding.button.setEnabled(false);

                // Show the progress bar
                binding.progressBar.setVisibility(View.VISIBLE);

                // Clear any text in the text view
                binding.textView.setText("");

                // The test integer that will be "processed" (displayed on screen)
                int THE_TEST_INTEGER = 2024;

                // Call the Process Int function in the native lib
                nativeLib.processIntAsync(THE_TEST_INTEGER, (int x) -> {
                    // We have a result, display it in the text view
                    binding.textView.setText(Integer.toString(x));

                    // Enable the button
                    binding.button.setEnabled(true);

                    // Hide the progress bar
                    binding.progressBar.setVisibility(View.INVISIBLE);
                });
            }
        });
    }
}