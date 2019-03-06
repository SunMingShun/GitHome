package com.jianyuan.gitdemo.gitdemo;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;

import java.util.List;

public class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public String getTopActivity(Activity context) {
        ActivityManager manager = (ActivityManager) context.getSystemService(ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> runningTaskInfos = manager.getRunningTasks(1);
        if (runningTaskInfos != null && runningTaskInfos.size() > 0)
            return (runningTaskInfos.get(0).topActivity).toString();
        else
            return null;
    }

    /**
     *
     * 判断某activity是否处于栈顶
     * @return true在栈顶 false不在栈顶
     */
    public boolean isActivityTop(Class cls,Context context){
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        String name = manager.getRunningTasks(1).get(0).topActivity.getClassName();
        return name.equals(cls.getName());
    }
}
