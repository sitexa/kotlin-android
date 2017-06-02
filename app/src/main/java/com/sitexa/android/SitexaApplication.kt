package com.sitexa.android

import android.app.Application
import com.sitexa.android.datamodel.DataModel
import com.sitexa.android.datamodel.IDataModel
import com.sitexa.android.schedulers.ISchedulerProvider
import com.sitexa.android.schedulers.SchedulerProvider

class SitexaApplication : Application() {

    val dataModel: IDataModel

    init {
        dataModel = DataModel()
    }

    val schedulerProvider: ISchedulerProvider
        get() = SchedulerProvider.instance

    val viewModel: MainViewModel
        get() = MainViewModel(dataModel, schedulerProvider)

}
