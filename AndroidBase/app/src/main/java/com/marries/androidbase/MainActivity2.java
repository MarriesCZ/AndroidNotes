package com.marries.androidbase;

import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity2 extends AppCompatActivity {

  private static final String TAG = "AB_MainActivity2";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    Log.d(TAG, "onCreate: ");
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main2);
  }

  @Override
  protected void onStart() {
    Log.d(TAG, "onStart: ");
    super.onStart();
  }

  @Override
  protected void onResume() {
    Log.d(TAG, "onResume: ");
    super.onResume();
  }

  @Override
  protected void onPause() {
    Log.d(TAG, "onPause: ");
    super.onPause();
  }

  @Override
  protected void onStop() {
    Log.d(TAG, "onStop: ");
    super.onStop();
  }
}