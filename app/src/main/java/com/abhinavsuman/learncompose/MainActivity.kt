package com.abhinavsuman.learncompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.SemanticsProperties.ContentDescription
import androidx.compose.ui.tooling.preview.Preview
import com.abhinavsuman.learncompose.ui.theme.LearnComposeTheme
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Defaults

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ExpandableCard(title = "Abhinav", body = "Hello, I'm Abhinav Maurya")
                }
            }
        }
    }
}

@Composable
fun ExpandableCard(title: String, body: String) {
    var expanded by remember {
        mutableStateOf(false)
    }
    Card {
        Column {
            Text(text = title)

            if (expanded) {
                Text(text = body)
                IconButton(onClick = {expanded = false}) {
                    Icon(Icons.Default.KeyboardArrowDown, contentDescription = "Collapse")
                }
            } else {
                IconButton(onClick = {expanded = true}) {
                    Icon(Icons.Default.KeyboardArrowUp, contentDescription = "Expanded")
                }
            }
        }
    }
}

@Composable
@Preview
fun CardPreview () {
    ExpandableCard(title = "Abhinav", body = "Hello, I'm Abhinav Maurya")
}