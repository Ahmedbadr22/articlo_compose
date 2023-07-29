package com.ahmedbadr.articlo.ui.widgets.section

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ahmedbadr.articlo.ui.widgets.card.ArticleVerticalCard

@Composable
fun HorizontalArticleScrollSection(
    modifier : Modifier = Modifier,
    sectionTitle: String,
    onShowAllClick: () -> Unit = {},
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        SectionHeader(
            modifier = Modifier.padding(horizontal = 16.dp),
            title = sectionTitle,
            onShowAllClick = onShowAllClick
        )
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(0) {
                ArticleVerticalCard()
            }
        }
    }
}