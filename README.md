# Приложение с фильмами

Приложение показывает список фильмов, полученный по ссылке
https://s3-eu-west-1.amazonaws.com/sequeniatesttask/films.json

[apk:* - собранные apk](apk)

Приложение написано для следующих платформ:
- Android
- Desktop

Приложение проверено на следующих устройствах:
- Эмулятор Pixel 8 (Android 8, API 26)
- Xiaomi Redmi 8A (Android 10.0, API 29)
- ПК с ОС Windows 10 средствами среды разработки Android Studio

Технологический стек:
- Среда разработки Android Studio
- Android SDK
- [Kotlin 2.0](https://kotlinlang.org/docs/whatsnew20.html)
- [Kotlin multiplatform](https://kotlinlang.org/docs/multiplatform.html)
- [KotlinX Coroutines](https://github.com/Kotlin/kotlinx.coroutines)
- [View Model](https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-viewmodel.html)
- [Jetpack Compose](https://developer.android.com/develop/ui/compose)
- [Koin](https://insert-koin.io/)
- [Retrofit](https://square.github.io/retrofit/)
- [CoIL Image Loader](https://coil-kt.github.io/coil/)
- [Odyssey (Навигация)](https://github.com/AlexGladkov/Odyssey)

Основные модули
- common:core:* - базовые модули, библиотеки, интерфейсы/абстрактные классы, модели,
  которые используются в проекте
- common:features:* - реализации feature модулей
- common:features:*:main - центральная сборка модуля
- common:main - центральная сборка приложения
- app:* - сборка приложения для платформ