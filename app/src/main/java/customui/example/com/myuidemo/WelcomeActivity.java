package customui.example.com.myuidemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class WelcomeActivity extends AppCompatActivity {

    private ViewPager mPager;
    private boolean needLogin = true; //标记是否显示登录页
    private List<View> viewList;
    private TextView welcomeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        init();
    }

    /**
     * 初始化相应的资源文件
     */
    private void init(){
        needLogin = getIntent().getBooleanExtra("needLogin", true);
        mPager = (ViewPager)findViewById(R.id.guide_viewpager);
        initPager();
        ViewPagerAdapter adapter = new ViewPagerAdapter(viewList);
        mPager.setAdapter(adapter);
    }

    private void initPager(){
        viewList = new ArrayList<View>();
        int[] images = new int[] { R.mipmap.welcome1, R.mipmap.welcome2, R.mipmap.welcome3};
        for (int i = 0; i < images.length; i++) {
            viewList.add(initView(images[i]));
        }
    }

    private View initView(int res){
        View view = LayoutInflater.from(this).inflate(R.layout.item_guide, null);
        welcomeBtn = (TextView)view.findViewById(R.id.iguide_btn);
        ImageView imageView = (ImageView)view.findViewById(R.id.iguide_img);
        imageView.setBackgroundResource(res);
        return view;
    }

    class ViewPagerAdapter extends PagerAdapter {

        private List<View> data;

        public ViewPagerAdapter(List<View> data){
            super();
            this.data = data;
        }

        @Override
        public int getCount() {

            return data.size();
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {

            return arg0 == arg1;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(data.get(position));
            if(position == 2){
                welcomeBtn.setVisibility(View.VISIBLE);
                welcomeBtn.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View arg0) {
                        if(needLogin){
                            Intent intent = new Intent(WelcomeActivity.this,LoginActivity.class);
                            startActivity(intent);
                        }
                        finish();
                    }});
            }
            return data.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(data.get(position));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_welcome, menu);
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
