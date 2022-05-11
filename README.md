# WeatherApp

지역별 날씨를 보여주는 어플리케이션을 구현

## Overview
화면 구성

   - "se" 로 검색되는 지역 목록과 해당 지역의 오늘/내일 날씨 리스트 


## Description

- MVVM 
- clean architecture - presentation/domain/data layer 분리

- [Foundation](https://developer.android.com/jetpack/components) 

  - [AppCompat](https://developer.android.com/topic/libraries/support-library/packages#v7-appcompat) - Degrade gracefully on older versions of Android.

- UI
  - [Material Design](https://material.io/develop/android)
  
- [Architecture](https://developer.android.com/jetpack/arch/)

  - [Data Binding](https://developer.android.com/topic/libraries/data-binding/) - Declaratively bind observable data to UI elements.
  - [Lifecycles](https://developer.android.com/topic/libraries/architecture/lifecycle) - Create a UI that automatically responds to lifecycle events.
  - [hilt](https://developer.android.com/jetpack/androidx/releases/hilt) 
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Store UI-related data that isn't destroyed on app rotations. Easily schedule asynchronous tasks for optimal execution.
  
- Third party and miscellaneous libraries

  - [Glide](https://bumptech.github.io/glide/) for image loading
  - [Kotlin Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) for managing background threads with simplified code and reducing needs for callbacks
  - [retrofit2](https://square.github.io/retrofit/) 

