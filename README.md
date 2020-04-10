# ProjectExample-Using-Room-MVVM
This is a Project Example for android using Room Database instead of SQL Cursor and MVVM(Model View ViewModel).

Using Reactive Programming RxJava

##
RxJava
Dependencies :
 *implementation "io.reactivex.rxjava2:rxjava:2.2.2" 
 *implementation 'io.reactivex.rxjava2:rxandroid:2.1.0'

##
Room
*implementation "androidx.room:room-runtime:$room_version"
*implementation "androidx.room:room-rxjava2:$room_version"
 
//if you are using java, use annotation processor instead of kapt 
*kapt "androidx.room:room-compiler:$room_version"
 
##
MVVM
Dependencies : 
  *implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version"
  *implementation "androidx.lifecycle:lifecycle-common-java8:$lifecycle_version"
  *implementation "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version"
  *implementation 'androidx.lifecycle:lifecycle-extensions:2.2.0'
