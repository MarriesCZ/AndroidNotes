package com.marries.androidbase;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class TestPlugin {

  private Activity mActivity;
  private static ListView mListView;
  private static TestPlugin testPlugin;
  private static boolean isInit;

  TestPlugin(Activity context) {
    mActivity = context;
  }

  public synchronized static TestPlugin getInstance(Activity activity) {
    if (testPlugin == null) {
      testPlugin = new TestPlugin(activity);
    }
    return testPlugin;
  }

  public void init() {
    if (isInit) {
      return;
    }

    View view = View.inflate(mActivity, R.layout.floatingbutton, null);
    final FloatingActionButton floatingActionButton = view.findViewById(R.id.main);

    mListView = view.findViewById(R.id.button_list);
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
        LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
    mActivity.getWindow().addContentView(view, layoutParams);
    ArrayAdapter adapter = new ArrayAdapter<String>(mActivity, R.layout.floatingbutton, 0);
    mListView.setAdapter(adapter);

    floatingActionButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        mListView
            .setVisibility(mListView.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
      }
    });

    isInit = true;
  }

  public Button getButton(String text, int id) {
    if (!isInit) {
      init();
    }
    View view = View.inflate(mActivity, R.layout.float_list_button, null);
    Button button = view.findViewById(R.id.list_button_item);
    button.setText(text);
    button.setId(id);
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
        LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
    mListView.addFooterView(button);
    return button;
  }
}
