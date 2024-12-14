package ru.netren.testfilms.films.repository.network.mappers

internal fun String.replacedFirstCharToUpperCase(): String {
    return this.replaceFirstChar { firstChar ->
        if (firstChar.isLowerCase()) firstChar.uppercaseChar().toString()
        else firstChar.toString()
    }
}
