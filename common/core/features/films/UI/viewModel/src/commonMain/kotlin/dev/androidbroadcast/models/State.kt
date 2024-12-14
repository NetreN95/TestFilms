package dev.androidbroadcast.models

/**
 * Источник данного файла с кодом - https://github.com/androidbroadcast/SampleNewsApp
 */

sealed class State<E>(open val list: List<E>?) {
    class None<E>(list: List<E>? = null) : State<E>(list)
    class Loading<E>(list: List<E>? = null) : State<E>(list)
    class Error<E>(list: List<E>? = null) : State<E>(list)
    class Success<E>(override val list: List<E>) : State<E>(list)
}