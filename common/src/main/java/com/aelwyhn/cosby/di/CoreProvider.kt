package com.aelwyhn.cosby.di

import android.content.Context

/**
 * Provides dependencies that are shared across the whole app code.
 */
interface CoreProvider {

    fun provideContext(): Context
}