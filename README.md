# WeatherApp

지역별 날씨를 보여주는 어플리케이션을 구현

## Overview
화면 구성

   - "se" 로 검색되는 지역 목록과 해당 지역의 오늘/내일 날씨 리스트 
   - WeatherViewModel init 에서 Location Search api (지역 목록) -> Location api (각 지역 날씨 상세 정보) 를 호출 한 뒤 databinding 을 통해 화면에 표시 
   - Swiperefreshlayout 사용하여 아래로 스와이프 동작이 있을 경우 api 재호출 화면 재구성 


## Description

- MVVM 
- clean architecture - presentation/domain/data layer 분리

- [Foundation](https://developer.android.com/jetpack/components) 

  - [AppCompat](https://developer.android.com/topic/libraries/support-library/packages#v7-appcompat) - Degrade gracefully on older versions of Android.

- UI
  - [Material Design](https://material.io/develop/android)
  - [Swiperefreshlayout](https://developer.android.com/jetpack/androidx/releases/swiperefreshlayout?hl=ko)
  
- [Architecture](https://developer.android.com/jetpack/arch/)

  - [Data Binding](https://developer.android.com/topic/libraries/data-binding/) - Declaratively bind observable data to UI elements.
  - [Lifecycles](https://developer.android.com/topic/libraries/architecture/lifecycle) - Create a UI that automatically responds to lifecycle events.
  - [hilt](https://developer.android.com/jetpack/androidx/releases/hilt) 
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Store UI-related data that isn't destroyed on app rotations. Easily schedule asynchronous tasks for optimal execution.
  
- Third party and miscellaneous libraries

  - [Glide](https://bumptech.github.io/glide/) for image loading
  - [Kotlin Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) for managing background threads with simplified code and reducing needs for callbacks
  - [retrofit2](https://square.github.io/retrofit/) 

