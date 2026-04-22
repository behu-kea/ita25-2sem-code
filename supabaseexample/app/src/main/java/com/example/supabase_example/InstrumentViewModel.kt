package com.example.supabase_example

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.from
import kotlinx.coroutines.launch


val supabase = createSupabaseClient(
    supabaseUrl = "https://onrzuebqglhqpeytksph.supabase.co",
    supabaseKey = "sb_publishable_sSp1hB_iMY7D7tPH09mx_w_rusBcnFW"
) {
    install(Postgrest)
}

val instrumentRepository = InstrumentRepository()

class InstrumentViewModel: ViewModel() {
    var instruments: List<Instrument> by mutableStateOf(listOf())

    init {
        viewModelScope.launch {
            instruments = instrumentRepository.getInstruments()
            Log.d("instrument", instruments.toString())
        }
    }

    fun createInstrument() {
        viewModelScope.launch {
            val newInstrument = Instrument( name = "Large piano");
            instrumentRepository.createNewInstrument(newInstrument)
        }
    }

    fun updateInstruments() {
        viewModelScope.launch {
            instruments = instrumentRepository.getInstruments()
        }
    }

    fun deleteRandomInstrument() {
        viewModelScope.launch {
            instrumentRepository.deleteInstrument(2)
        }
    }




}
