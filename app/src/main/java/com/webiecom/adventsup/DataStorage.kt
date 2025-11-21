package com.webiecom.adventsup

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "openedDays")

class DataStorage(private val context: Context) {

    val min = 0
    val max = 23
    val days = (max - min) + 1


    private val openedKeys: List<Preferences.Key<Boolean>> =
        List(days) { i -> booleanPreferencesKey("hasBeenOpened_$i") }

    // update boolean
    suspend fun saveOpened(index: Int, value: Boolean) {
        require(index in min..max) { "Index must be between $min and $max" }

        context.dataStore.edit { prefs ->
            prefs[openedKeys[index]] = value
        }
    }

    // get all booleans
    val getOpenedArray: Flow<BooleanArray> = context.dataStore.data.map { prefs ->
        BooleanArray(days) { i -> prefs[openedKeys[i]] ?: false }
    }

    // get specific boolean
    fun getOpened(index: Int): Flow<Boolean> {
        require(index in min..max) { "Index must be between $min and $max" }


        return context.dataStore.data.map { prefs ->
            prefs[openedKeys[index]] ?: false
        }
    }

}
