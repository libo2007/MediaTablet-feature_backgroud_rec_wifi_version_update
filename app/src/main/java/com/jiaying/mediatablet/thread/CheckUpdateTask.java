package com.jiaying.mediatablet.thread;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;

import com.jiaying.mediatablet.R;
import com.jiaying.mediatablet.utils.ToastUtils;
import com.jiaying.mediatablet.utils.UpdateManager;

/**
 * 作者：lenovo on 2017/1/5 19:25
 * 邮箱：353510746@qq.com
 * 功能：检查软件更新
 */
public class CheckUpdateTask extends AsyncTask<Void, Void, Boolean> {
    private UpdateManager updateManager;
    private Context context;

    public CheckUpdateTask(Context context) {
        this.context = context;
        updateManager = new UpdateManager(context);
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        return updateManager.isUpdate();
    }

    @Override
    protected void onPostExecute(Boolean update) {
        super.onPostExecute(update);
        if (update) {
            if (context != null && !((Activity) context).isFinishing()) {
                try {
                    updateManager.showNoticeDialog();
                } catch (Exception e) {

                }
            }
        }else {
            ToastUtils.showToast((Activity) context, R.string.version_newest);
        }
    }
}
