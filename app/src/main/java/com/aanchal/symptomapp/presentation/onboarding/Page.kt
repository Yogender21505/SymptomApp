package com.aanchal.symptomapp.presentation.onboarding

import androidx.annotation.DrawableRes
import com.aanchal.symptomapp.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

val pages = listOf(
    Page(
        title = "Page 1 hello ",
        description = "it is the pageit is the pageit is the page",
        image = R.drawable.first
    ),
    Page(
    title = "Page 1 hello ",
        description = "it is the pageit is the pageit is the page",
        image = R.drawable.second
    ),
    Page(
    title = "Page 1 hello ",
    description = "it is the pageit is the pageit is the page",
    image = R.drawable.third
    )
)