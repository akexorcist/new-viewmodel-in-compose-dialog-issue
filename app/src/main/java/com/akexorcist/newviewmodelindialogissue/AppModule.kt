package com.akexorcist.newviewmodelindialogissue

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

object AppModule {
    val modules = module {
        viewModelOf(::DialogViewModel)
    }
}
