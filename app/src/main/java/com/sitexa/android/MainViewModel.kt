package com.sitexa.android

import com.sitexa.android.datamodel.IDataModel
import com.sitexa.android.model.Language
import com.sitexa.android.schedulers.ISchedulerProvider
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject

/**
 * View model for the main activity.
 */
class MainViewModel(private val mDataModel: IDataModel,
                    private val mSchedulerProvider: ISchedulerProvider) {

    private val mSelectedLanguage = BehaviorSubject.create<Language>()

    val greeting: Observable<String>
        get() = mSelectedLanguage
                .observeOn(mSchedulerProvider.computation())
                .map(Language::code)
                .flatMap({ mDataModel.getGreetingByLanguageCode(it) })

    val supportedLanguages: Observable<List<Language>>
        get() = mDataModel.supportedLanguages

    fun languageSelected(language: Language) {
        mSelectedLanguage.onNext(language)
    }

}
