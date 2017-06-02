package com.sitexa.android.datamodel

import com.sitexa.android.model.Language

import io.reactivex.Observable

interface IDataModel {

    val supportedLanguages: Observable<List<Language>>

    fun getGreetingByLanguageCode(code: Language.LanguageCode): Observable<String>
}
