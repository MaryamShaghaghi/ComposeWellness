package com.example.basicstatecodelab.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }
    //-------
    StatelessCounter(count, onIncrement = { count++}, modifier)

}

@Composable
private fun StatelessCounter(count: Int, onIncrement: () -> Unit, modifier: Modifier = Modifier) {
    var count = count
    Column(modifier = modifier.padding(16.dp)) {

        if (count > 0) {
            Text(text = "You've had $count glasses.")
        }

        Button(
            onClick = onIncrement,
            enabled = count < 10,
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Add one")
        }
    }
}