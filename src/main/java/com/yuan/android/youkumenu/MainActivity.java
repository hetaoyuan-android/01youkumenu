package com.yuan.android.youkumenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private ImageView icon_home;
    private ImageView icon_menu;
    private RelativeLayout level1;
    private RelativeLayout level2;
    private RelativeLayout level3;
    /**
     * 是否显示第三个圆环
     * true显示
     * false 隐藏
     */
    private boolean isShowLevel3 = true;
    private boolean isShowLevel2 = true;
    private boolean isShowLevel1 = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        icon_home = (ImageView) findViewById(R.id.icon_home);
        icon_menu = (ImageView) findViewById(R.id.icon_menu);
        level1 = (RelativeLayout) findViewById(R.id.level1);
        level2 = (RelativeLayout) findViewById(R.id.level2);
        level3 = (RelativeLayout) findViewById(R.id.level3);

        MyOnClickListener myOnClickListener = new MyOnClickListener();
        //设置点击事件
        icon_home.setOnClickListener(myOnClickListener);
        icon_menu.setOnClickListener(myOnClickListener);
        level1.setOnClickListener(myOnClickListener);
        level2.setOnClickListener(myOnClickListener);
        level3.setOnClickListener(myOnClickListener);
    }

    class MyOnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.icon_home:
                    //如果二级和三级菜单是显示的，都隐藏
                    if(isShowLevel2){
                        //隐藏二级菜单
                        isShowLevel2 = false;
                        Tools.hideView(level2);
                        if(isShowLevel3){
                            isShowLevel3 = false;
                            Tools.hideView(level3, 200);
                        }
                    }else{
                        //如果是隐藏的，二级菜单显示
                        //显示二级菜单
                        isShowLevel2 = true;
                        Tools.showView(level2);
                    }

                    break;
                case R.id.icon_menu:
                    if(isShowLevel3){
                        isShowLevel3 = false;
                        Tools.hideView(level3);
                    }else{
                        isShowLevel3 = true;
                        Tools.showView(level3);
                    }

                    break;
            }

        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_MENU){

            //如果一级，二级，三级菜单是显示的就全部隐藏
            if(isShowLevel1){
                isShowLevel1 = false;
                Tools.hideView(level1);
                if(isShowLevel2){
                    //隐藏二级
                    isShowLevel2 = false;
                    Tools.hideView(level2,200);
                    //隐藏三级
                    isShowLevel3 = false;
                    Tools.hideView(level3,400);
                }
            }else {
            //如果一级，二级菜单隐藏，就显示
            //显示一级菜单
                isShowLevel1 = true;
                Tools.showView(level1);
                //显示二级
                isShowLevel2 = true;
                Tools.showView(level1,200);
            }
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}
