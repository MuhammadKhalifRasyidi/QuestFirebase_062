package com.example.meet14.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.meet14.model.Mahasiswa
import com.example.meet14.repository.MahasiswaRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class HomeViewModel(private val mhs: MahasiswaRepository) : ViewModel() {
    var mhsUIState: HomeUiState by mutableStateOf(HomeUiState.Loading)
        private set

    init {
        getMhs()
        deleteMhs(mahasiswa = Mahasiswa())
    }

    fun getMhs() {
        viewModelScope.launch {
            mhs.getMahasiswa()
                .onStart {
                    mhsUIState = HomeUiState.Loading
                }
                .catch {
                    mhsUIState = HomeUiState.Error(it)
                }

                .collect {
                    mhsUIState = if (it.isEmpty()) {
                        HomeUiState.Error(Exception("Belum ada adaftar mahasiswa"))
                    } else {
                        HomeUiState.Success(it)
                    }
                }
        }
    }

    fun deleteMhs(mahasiswa: Mahasiswa) {
        viewModelScope.launch {
            try {
                mhs.deleteMahasiswa(mahasiswa)
            } catch (e: Exception) {
                mhsUIState = HomeUiState.Error(e)
            }
        }
    }
}

sealed class HomeUiState {
    data class Success(val mahasiswa: List<Mahasiswa>) : HomeUiState()
    data class Error(val message: Throwable) : HomeUiState()
    object Loading : HomeUiState()
}
