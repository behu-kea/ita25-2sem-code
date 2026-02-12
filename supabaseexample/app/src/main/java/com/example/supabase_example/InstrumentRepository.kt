package com.example.supabase_example

import io.github.jan.supabase.postgrest.from

class InstrumentRepository {
    suspend fun deleteInstrument(id: Int) {
        supabase
            .from("instruments")
            .delete {
                filter {
                    eq("id", id)
                }
            }
    }

    suspend fun createNewInstrument(instrument: Instrument) {
        supabase
            .from("instruments")
            .insert(instrument)
    }

    suspend fun getInstruments(): List<Instrument> {
        return supabase
            .from("instruments")
            .select()
            .decodeList<Instrument>()
    }
}