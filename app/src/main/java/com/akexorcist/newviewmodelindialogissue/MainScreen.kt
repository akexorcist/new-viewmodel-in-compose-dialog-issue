package com.akexorcist.newviewmodelindialogissue

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.akexorcist.newviewmodelindialogissue.ui.theme.NewViewModelInDialogIssueTheme

@Composable
fun MainRoute() {
    var showDialog by remember { mutableStateOf(false) }
    MainScreen(
        onShowDialogClick = {
            showDialog = true
        }
    )

    if (showDialog) {
        SampleDialog(
            onDismissRequest = {
                showDialog = false
            }
        )
    }
}

@Composable
fun MainScreen(onShowDialogClick: () -> Unit) {
    Column {
        Button(
            onClick = onShowDialogClick,
        ) {
            Text("Show Dialog")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    NewViewModelInDialogIssueTheme {
        MainScreen(
            onShowDialogClick = {},
        )
    }
}
