package com.h2square.bookandbeantree

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.h2square.bookandbeantree.ui.theme.gaugeColor

@Composable
fun GaugeBarLayout(progress: Float, maxProgress: Float, gaugeColor: Color) {
    Column(modifier = Modifier.padding(16.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Progress")
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "${(progress * 100).toInt()}%")
        }
        Spacer(modifier = Modifier.height(16.dp))
//        LinearProgressIndicator(
//            progress = progress,
//            modifier = Modifier.fillMaxWidth(),
//            color = gaugeColor
//        )
        Spacer(modifier = Modifier.height(16.dp))
        Canvas(modifier = Modifier.fillMaxWidth()) {
            drawLine(
                color = Color.Gray,
                strokeWidth = 1.dp.toPx(),
                start = Offset(0f, 0f),
                end = Offset(size.width, 0f),
                cap = StrokeCap.Square
            )
            val gaugeWidth = size.width * progress
            drawLine(
                color = gaugeColor,
                strokeWidth = 8.dp.toPx(),
                start = Offset(0f, 0f),
                end = Offset(gaugeWidth, 0f),
                cap = StrokeCap.Square
            )
        }
    }
}

@Preview
@Composable
fun PreviewGaugeBarLayout() {
    GaugeBarLayout(progress = 0.6f, maxProgress = 1f, gaugeColor = gaugeColor)
}
