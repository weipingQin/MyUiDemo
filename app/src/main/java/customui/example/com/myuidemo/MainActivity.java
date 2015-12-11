package customui.example.com.myuidemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        init();
    }

    private void init() {
        TextView btnShowToast = (TextView) findViewById(R.id.btn_showtoast);
        btnShowToast.setText("显示");
        btnShowToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast(MainActivity.this,"asdhasdihasidhasid");
            }
        });
    }



    private void showToast(Context context,String textString){
        View toastRoot = getLayoutInflater().inflate(R.layout.dialog,null);
       // Color.parseColor("FFFFFF");
       // toastRoot.setBackgroundColor(Color.parseColor("FFFFFF"));
       /* TextView textView = (TextView)toastRoot.findViewById(R.id.tvTitleToast);
        textView.setText("MyToast");*/
        Toast toastStart = new Toast(this);
        toastStart.setGravity(Gravity.CENTER, 0, 0);
        toastStart.setDuration(Toast.LENGTH_LONG);
        toastStart.setView(toastRoot);
        toastStart.makeText(context, textString, Toast.LENGTH_LONG);
        toastRoot.setMinimumWidth(400);
        toastRoot.setMinimumHeight(200);
        toastStart.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
