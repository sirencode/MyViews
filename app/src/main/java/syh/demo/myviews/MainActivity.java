package syh.demo.myviews;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews(){
        CustomSwitchView buttonCSView = (CustomSwitchView) findViewById(R.id.csv_button);
        // 绑定监听事件
        buttonCSView.setOnSwitchStateUpdateListener(new CustomSwitchView.OnSwitchStateUpdateListener() {

            @Override
            public void onStateUpdate(boolean state) {
                if (state) {
                    Toast.makeText(MainActivity.this, "打开", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "关闭", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
