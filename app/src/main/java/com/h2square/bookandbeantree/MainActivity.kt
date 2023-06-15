package com.h2square.bookandbeantree

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold

import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.h2square.bookandbeantree.MainActivity.Companion.TAG
import com.h2square.bookandbeantree.ui.theme.BookAndBeanTreeTheme
import com.h2square.bookandbeantree.ui.theme.gaugeColor
import com.h2square.bookandbeantree.ui.theme.levelTextColor

import com.h2square.bookandbeantree.ui.theme.mainView


class MainActivity : ComponentActivity() {
    companion object {
        const val TAG = "SysTemBookLog"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookAndBeanTreeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PreviewTextWithImageLayout()

                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextWithImageLayout(text: String, imageResId: Int) {
    Column(Modifier.fillMaxSize()) {
        TopAppBar(
            title = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = null,
                        modifier = Modifier.size(48.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "",
                        textAlign = TextAlign.Start
                    )


                }
            },
            actions = {
                MyIconButton(
                    imageVector = painterResource(id = R.drawable.bell),
                    contentDescription = "My Icon"
                ) { /* 알림 버튼 클릭 핸들러 구현 */ }
            }
        )
        TextWithImageContent(text = text, imageResId = imageResId)
        Text(
            text = "책을 교환하면 포인트를 얻을수있어요",
            textAlign = TextAlign.Start,
            modifier = Modifier.padding(16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "줄기단계까지 2권남았어요",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),

            style = TextStyle(
                color = levelTextColor, // 원하는 글자색으로 변경
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

        )
        Spacer(modifier = Modifier.width(8.dp))
        GaugeBarLayout(progress = 0.6f, maxProgress = 1f, gaugeColor = gaugeColor)

        Box() {

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopStart)
            ) {
                Text(text = "")

                IconButton(onClick = { Log.d(TAG, "되니?") }) {
                    Image(
                        painter = painterResource(id = R.drawable.add_btn),
                        contentDescription = null,
                        modifier = Modifier.size(50.dp)

                    )

                }


            }

            MainView()
        }
    }
}

@Composable
fun MainView() {
    LazyColumn(modifier = Modifier.padding(20.dp)
        .fillMaxHeight()
        .background(mainView)
        .fillMaxHeight()) {
        item {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier

                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(mainView)
            ) {
            }
        }
        items((1..50).toList()) { index ->
            Text(text = "Item $index", modifier = Modifier
                .fillMaxHeight()
                .background(mainView)

            )
            }
        }

    }


@Composable
fun TextWithImageContent(text: String, imageResId: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {

        Text(
            text = text,
            textAlign = TextAlign.Start,
            modifier = Modifier.weight(1f),
            style = TextStyle( fontSize = 24.sp, fontWeight = Bold)
        )

        Spacer(modifier = Modifier.width(16.dp))
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = null,
            modifier = Modifier
                .size(128.dp)
                .fillMaxHeight()
        )
    }
}

@Composable
fun MyIconButton(

    imageVector: Painter,
    contentDescription: String,
    onClick: () -> Unit
) {
    IconButton(onClick = onClick) {
        Image(
            painter = imageVector,
            contentDescription = contentDescription,
            modifier = Modifier.size(30.dp)
        )
    }
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview
@Composable
fun PreviewTextWithImageLayout() {
    val id = "안유진"
    val level = "새싹"
    TextWithImageLayout("$id 님의 새싹단계는 $level 단계입니다.!", R.drawable.yujin)
}