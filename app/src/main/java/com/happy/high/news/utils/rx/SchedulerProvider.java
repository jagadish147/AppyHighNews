package com.happy.high.news.utils.rx;

import io.reactivex.Scheduler;

/**
 * Created by Jagadish on 19/05/2020.
 */

public interface SchedulerProvider {


    Scheduler io();

    Scheduler ui();
}
