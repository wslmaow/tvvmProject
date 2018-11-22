package com.code.mvvm.core.data.source;

import com.code.mvvm.callback.CallBack;
import com.code.mvvm.core.data.BaseRepository;
import com.code.mvvm.core.data.pojo.activity.ActivityListVo;
import com.code.mvvm.network.rx.RxSchedulers;
import com.code.mvvm.network.rx.RxSubscriber;

/**
 * @author：tqzhang on 18/7/26 16:18
 */
public class ActivityRepository extends BaseRepository {

    public void loadActivityList(String lastId, String rn, final CallBack listener) {
        addSubscribe(apiService.getActivityList(lastId, rn)
                .compose(RxSchedulers.io_main())
                .subscribe(new RxSubscriber<ActivityListVo>() {
                    @Override
                    protected void onNoNetWork() {
                        super.onNoNetWork();
                        listener.onNoNetWork();
                    }

                    @Override
                    public void onSuccess(ActivityListVo activityListObject) {
                        listener.onNext(activityListObject);
                    }

                    @Override
                    public void onFailure(String msg) {
                        listener.onError(msg);
                    }
                }));


    }

}
