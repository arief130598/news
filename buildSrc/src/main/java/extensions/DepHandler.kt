package extensions

import Deps
import Modules
import TestDeps
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.appModuleDeps() {
    implementation(Deps.AndroidX.Navigation.ui)
    implementation(Deps.AndroidX.Navigation.fragment)
    implementation(Deps.AndroidX.Navigation.dynamicFeaturesFragment)

    implementation(Deps.DaggerHilt.hiltAndroid)
    kapt(Deps.DaggerHilt.hiltAndroidCompiler)
}

fun DependencyHandler.coreModuleDeps() {
    api(Deps.AndroidX.coreKtx)
    api(Deps.AndroidX.appcompat)
    api(Deps.AndroidX.legacy)
    api(Deps.AndroidX.Constraint.constraintLayout)
    api(Deps.AndroidX.Coordinator.coordinatorLayout)
    api(Deps.Shimmer.shimmer)

    api(Deps.Glide.glide)
    api(Deps.Glide.compiler)

    api(Deps.Retrofit.retrofit)
    api(Deps.Retrofit.moshiConverter)
    api(Deps.OkHttp.okhttp)
    api(Deps.OkHttp.logging)

    api(Deps.Coroutines.core)
    api(Deps.Coroutines.android)

    api(Deps.AndroidX.Lifecycle.runtime)
    api(Deps.AndroidX.Lifecycle.viewModel)
    api(Deps.AndroidX.Lifecycle.liveData)
    api(Deps.AndroidX.Lifecycle.common)

    api(Deps.AndroidX.Navigation.ui)
    api(Deps.AndroidX.Navigation.fragment)
    api(Deps.AndroidX.Navigation.commonKtx)

    implementation(Deps.DaggerHilt.hiltAndroid)
    kapt(Deps.DaggerHilt.hiltAndroidCompiler)
}

fun DependencyHandler.dataModuleDeps(){
    kapt(Deps.AndroidX.Room.compiler)
    implementation(Deps.AndroidX.Room.ktx)
    implementation(Deps.AndroidX.Room.runtime)
}

fun DependencyHandler.domainModuleDeps(){
    kapt(Deps.AndroidX.Room.compiler)
    implementation(Deps.AndroidX.Room.ktx)
    implementation(Deps.AndroidX.Room.runtime)

    implementation(Deps.DaggerHilt.hiltAndroid)
    kapt(Deps.DaggerHilt.hiltAndroidCompiler)
}

fun DependencyHandler.singleModuleDeps() {
    api(Deps.AndroidX.coreKtx)
    api(Deps.AndroidX.appcompat)
    api(Deps.AndroidX.legacy)
    api(Deps.AndroidX.Constraint.constraintLayout)
    api(Deps.AndroidX.Coordinator.coordinatorLayout)
    api(Deps.Shimmer.shimmer)

    api(Deps.Glide.glide)
    api(Deps.Glide.compiler)

    api(Deps.Retrofit.retrofit)
    api(Deps.Retrofit.moshiConverter)
    api(Deps.OkHttp.okhttp)
    api(Deps.OkHttp.logging)

    api(Deps.Coroutines.core)
    api(Deps.Coroutines.android)

    api(Deps.AndroidX.Lifecycle.runtime)
    api(Deps.AndroidX.Lifecycle.viewModel)
    api(Deps.AndroidX.Lifecycle.liveData)
    api(Deps.AndroidX.Lifecycle.common)

    api(Deps.AndroidX.Navigation.ui)
    api(Deps.AndroidX.Navigation.fragment)
    api(Deps.AndroidX.Navigation.commonKtx)

    implementation(Deps.DaggerHilt.hiltAndroid)
    kapt(Deps.DaggerHilt.hiltAndroidCompiler)

    kapt(Deps.AndroidX.Room.compiler)
    implementation(Deps.AndroidX.Room.ktx)
    implementation(Deps.AndroidX.Room.runtime)
}

fun DependencyHandler.testingModuleDeps() {
    testImplementation(TestDeps.JUnit.junit)
    testImplementation(TestDeps.AndroidX.roomTest)
    testImplementation(TestDeps.AndroidX.coreTesting)
    testImplementation(TestDeps.AndroidX.coreKtx)
    testImplementation(TestDeps.Coroutines.coroutines)
    testImplementation(TestDeps.Mockito.core)
    testImplementation(TestDeps.Mockito.inline)
    testImplementation(TestDeps.MockitoKotlin.mockito)
    testImplementation(TestDeps.Turbine.turbine)
    androidTestImplementation(TestDeps.AndroidX.coreKtx)
    androidTestImplementation(TestDeps.AndroidX.coreTesting)
    androidTestImplementation(TestDeps.JUnit.junit)
    androidTestImplementation(TestDeps.Espresso.espressoImplementation)
}
