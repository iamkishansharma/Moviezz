package com.heycode.moviezz

import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService

public class AppExecutor {
    // Singleton pattern
    private val instance: AppExecutor = AppExecutor()

    public fun getInstance(): AppExecutor {
        return instance
    }

    private val networkIO: ScheduledExecutorService = Executors.newScheduledThreadPool(3)

    public fun getNetworkIO(): ScheduledExecutorService {
        return networkIO
    }

}