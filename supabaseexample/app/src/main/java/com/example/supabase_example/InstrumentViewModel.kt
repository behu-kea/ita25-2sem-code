package com.example.supabase_example

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
    var instruments by mutableStateOf<List<Instrument>>(listOf())

    init {
        viewModelScope.launch {
            instruments = instrumentRepository.getInstruments()
        }
    }

    fun createInstrument() {
        viewModelScope.launch {
            val newInstrument = Instrument( name = "Drums");
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
