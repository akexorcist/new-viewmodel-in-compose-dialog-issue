package com.akexorcist.newviewmodelindialogissue

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import java.util.UUID
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import org.koin.compose.viewmodel.koinViewModel

class DialogViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<String?>(null)
    val uiState: StateFlow<String?> = _uiState

    fun updateValue() {
        _uiState.update { UUID.randomUUID().toString() }
    }

    override fun onCleared() {
        super.onCleared()
        Log.e("DialogViewModel", "$this cleared")
    }
}

@Composable
fun SampleDialog(
    viewModel: DialogViewModel = koinViewModel(
        key = UUID.randomUUID().toString()
    ),
    onDismissRequest: () -> Unit,
) {
    val currentValue by viewModel.uiState.collectAsStateWithLifecycle()
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true,
        ),
    ) {
        Column(
            modifier = Modifier
                .background(
                    color = MaterialTheme.colorScheme.background,
                    shape = RoundedCornerShape(8.dp),
                )
                .padding(64.dp)
        ) {
            Text("$currentValue")
            Spacer(Modifier.height(8.dp))
            Button(
                onClick = {
                    viewModel.updateValue()
                }
            ) {
                Text("Update Value")
            }
        }
    }
}
