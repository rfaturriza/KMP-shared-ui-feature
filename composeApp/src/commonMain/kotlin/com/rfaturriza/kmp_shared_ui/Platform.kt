package com.rfaturriza.kmp_shared_ui

interface Platform {
    val name: String
}

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect class ContextFactory {
    fun getContext(): Any
    fun getApplication(): Any
    fun getActivity(): Any
}

expect fun getPlatform(): Platform

expect fun closeCurrentScreen(
    activity: Any? = null
)