package oop

fun school() {

    val math = Course("Diskrete Mathematik", "Bigler")
    val luca = Student("ABC", 9)

    math.addStudent(luca)

    println(math.toString())
}

class Course (private val identifier: String, private val lecturer: String){
    private val students = mutableListOf<Student>()
    fun addStudent(student: Student) {
        students.add(student)
    }

    fun removeStudent(student: Student) {
        students.remove(student)
    }

    fun numberOfStudents(): Int {
        return students.size
    }

    fun averageGrade(): Double {
        return students.sumOf { it.grade } / students.size.toDouble()
    }

    override fun toString(): String {
        return """
            Course: $identifier
            Lecturer: $lecturer
            Students: $students
        """.trimIndent()
    }
}

class Student (val id: String, val grade: Int){
    override fun toString(): String {
        return "Student(id='$id', grade=$grade)"
    }
}
