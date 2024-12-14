package dev.androidbroadcast.mappers

import dev.androidbroadcast.RequestResult
import dev.androidbroadcast.models.State


/**
 * Источник данного файла с кодом - https://github.com/androidbroadcast/SampleNewsApp
 */

fun <E> RequestResult<List<E>>.toState(): State<E> {
    return when (this) {
        is RequestResult.Error -> State.Error(data?.toList())
        is RequestResult.InProgress -> State.Loading(data?.toList())
        is RequestResult.Success -> State.Success(data.toList())
    }
}
