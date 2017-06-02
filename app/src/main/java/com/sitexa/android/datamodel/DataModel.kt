package com.sitexa.android.datamodel

import com.sitexa.android.model.Language
import io.reactivex.Observable
import java.util.*

class DataModel : IDataModel {

    override val supportedLanguages: Observable<List<Language>>
        get() = Observable.fromCallable<List<Language>>({ languages })

    private val languages: List<Language>
        get() = Arrays
                .asList(Language("English", Language.LanguageCode.EN),
                        Language("German", Language.LanguageCode.DE),
                        Language("Slovakian", Language.LanguageCode.HR))

    override fun getGreetingByLanguageCode(code: Language.LanguageCode): Observable<String> {
        when (code) {
            Language.LanguageCode.DE -> return Observable.just("Guten Tag!")
            Language.LanguageCode.EN -> return Observable.just("Hello!")
            Language.LanguageCode.HR -> return Observable.just("Zdravo!")
            else -> return Observable.empty<String>()
        }
    }
}
