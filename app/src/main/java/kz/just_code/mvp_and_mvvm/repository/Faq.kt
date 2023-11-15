package kz.just_code.mvp_and_mvvm.repository

import androidx.annotation.StringRes

data class Faq(
    val id: Int,
    @StringRes
    val title: Int,
    @StringRes
    val description: Int
)
