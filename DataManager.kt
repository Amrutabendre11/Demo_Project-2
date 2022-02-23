package com.example.demo

object DataManager {
    val courses = HashMap<String,CourseInfo>()
    val notes = ArrayList<NoteInfo>()

    init{

        initializeCourses()
        initializeNotes()
    }

    private fun initializeCourses() {
        var course = CourseInfo("Android Intent","Android Prigraming with intents")
        courses.set(course.courseId,course)

        course = CourseInfo(courseId = "Android_Async",title ="Android Async Programming and Services")
        courses.set(course.courseId,course)

        course =CourseInfo(title = "Java Fundamentals:The java language",courseId = "Java_Lang")
        courses.set(course.courseId,course)

        course =CourseInfo(title = "Java_core",courseId = "Java Fundamentals: The Core Platform")
        courses.set(course.courseId,course)
    }

    private fun initializeNotes() {

        var note = NoteInfo(CourseInfo("Android Intent","Android Prigraming with intents"),"Dynamic Intent resolution with Intents ","Wow,Intent allow components to be resolved at runtime")
        notes.add(note)

        note = NoteInfo(CourseInfo("Android_Async","Android Async Programming and Services"),"Dynamic Intent resolution with Intents ","Wow,Intent allow components to be resolved at runtime")
        notes.add(note)

        note = NoteInfo(CourseInfo("Java_Lang","Java Fundamentals:The java language"),"Dynamic Intent resolution with Intents ","Wow,Intent allow components to be resolved at runtime")
        notes.add(note)

        note = NoteInfo(CourseInfo("Java Fundamentals: The Core Platform","Java_core"),"Dynamic Intent resolution with Intents ","Wow,Intent allow components to be resolved at runtime")
        notes.add(note)

        note = NoteInfo(CourseInfo("Android_Async","Android Async Programming and Services"),"Dynamic Intent resolution with Intents ","Wow,Intent allow components to be resolved at runtime")
        notes.add(note)

        note = NoteInfo(CourseInfo("Java_Lang","Java Fundamentals:The java language"),"Dynamic Intent resolution with Intents ","Wow,Intent allow components to be resolved at runtime")
        notes.add(note)

        note = NoteInfo(CourseInfo("Java Fundamentals: The Core Platform","Java_core"),"Dynamic Intent resolution with Intents ","Wow,Intent allow components to be resolved at runtime")
        notes.add(note)

        note = NoteInfo(CourseInfo("Android_Async","Android Async Programming and Services"),"Dynamic Intent resolution with Intents ","Wow,Intent allow components to be resolved at runtime")
        notes.add(note)

        note = NoteInfo(CourseInfo("Java_Lang","Java Fundamentals:The java language"),"Dynamic Intent resolution with Intents ","Wow,Intent allow components to be resolved at runtime")
        notes.add(note)

        note = NoteInfo(CourseInfo("Java Fundamentals: The Core Platform","Java_core"),"Dynamic Intent resolution with Intents ","Wow,Intent allow components to be resolved at runtime")
        notes.add(note)



    }
}