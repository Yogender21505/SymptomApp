package com.aanchal.symptomapp.presentation.components

import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.aanchal.symptomapp.presentation.Dimens.MediumPadding1
import com.aanchal.symptomapp.presentation.Dimens.MediumPadding2
import com.aanchal.symptomapp.presentation.onboarding.Page
import com.aanchal.symptomapp.presentation.onboarding.pages
import com.aanchal.symptomapp.ui.theme.SymptomAppTheme

@Composable
fun OnBoardingPage(
    page: Page
)
{
    Column() {
        Image(
            modifier= Modifier
                .fillMaxWidth()
                .fillMaxHeight(.7f),
            painter= painterResource(id = page.image),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(MediumPadding1))
        Text(text = page.title,
            modifier= Modifier.padding(horizontal = MediumPadding2),
            color = Color.Black)
        Text(text = page.description,
            modifier= Modifier.padding(horizontal = MediumPadding2),
            color = Color.Black)
    }
}
//
//@Preview(showBackground = true)
//@Preview(uiMode = UI_MODE_NIGHT_YES,showBackground = true)
//@Composable
//fun OnBoardingPagePreview() {
//    SymptomAppTheme {
//        OnBoardingPage(modifier = Modifier, page =pages[0] )
//    }
//}