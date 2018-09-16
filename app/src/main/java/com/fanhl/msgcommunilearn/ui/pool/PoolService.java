package com.fanhl.msgcommunilearn.ui.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

final class PoolService {
    // The values have been hard-coded for brevity
    ExecutorService pool = new CustomThreadPoolExecutor(
            10, 10, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(10));
    // ...
}