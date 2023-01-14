package edu.miu.quizapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import edu.miu.quizapp.R
import edu.miu.quizapp.db.Quiz
import edu.miu.quizapp.db.QuizDatabase
import edu.miu.quizapp.utils.BaseFragment
import edu.miu.quizapp.utils.PrefManager
import kotlinx.coroutines.launch

class SplashFragment : BaseFragment() {

    private lateinit var tvWelcome: TextView
    private var prefManager: PrefManager? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        prefManager = PrefManager(context)
        val view = inflater.inflate(R.layout.fragment_splash, container, false)
        tvWelcome = view.findViewById(R.id.logo_welcome)
        addQuestionsToDB()
        return view
    }
    override fun onResume(){
        super.onResume()
        tvWelcome.postDelayed({
                Navigation.findNavController(requireView()).navigate(R.id.action_splashFragment_to_welcomeFragment)

        }, 1000)
    }

    fun addQuestionsToDB(){
        val quiz1 = Quiz(1L,"1)What is the difference between a val and a var declaration?" + "\n","There’s no difference between these two declarations", "var declares a mutable variable and val declares a read-only variable","var declares a mutable variable and val declares a constant","val declares a mutable variable and var declares a read-only variable","b","Answer: (b)  var declares a mutable variable and val declares a read-only variable\n" +
                "\n" +
                "Explanation: Using val instead of var to declare a variable can help prevent accidental reassignment and can make it clear to other developers that the variable is intended to be immutable.")
        val quiz2 = Quiz(2L,"2) Which of these targets are not currently supported by Kotlin?" + "\n", "JVM 3",".NET CLR","JavaScript","LLVM","b","Answer: (b) .NET CLR\n" +
                "\n" +
                "Explanation: Kotlin can currently be compiled to both JVM bytecode and JavaScript. A backend to compile to native code (LLVM) is available as an early beta. The .NET CLR is not (yet) officially supported.")
        val quiz3 = Quiz(3L,"3) What are Kotlin coroutines?" + "\n","Replacement for threads and thread-based concurrency", "Way to perform long-running tasks without blocking the main thread.","A feature for creating animations and visual effects in Kotlin.","Set of tools for concurrent programming in Kotlin","d","Answer: (d) Set of tools for concurrent programming in Kotlin\n" +
                "\n" +
                "Explanation: Coroutines are (an experimental) way to run code asynchronously without the usual thread blocking.")
        val quiz4 = Quiz(4L,"4) What does the !! operator do?" + "\n","It returns the left-hand operand if the operand is not null, otherwise it returns right hand operand", "Compares two values for identity rather than equality","Converts any value to a non-null tpe and throws an exception if value is in fact null","Its the modulo operator in Kotlin, similar to Java's %","c","Answer: (c) Converts any value to a non-null tpe and throws an exception if value is in fact null\n" +
                "\n" +
                "Explanation: The not-null assertion operator !! makes sure the given nullable variable in fact is not null, and throws a NullPointerException if it is.")
        val quiz5 = Quiz(5L,"5) What is the key difference between Iterable<T> and Sequence<T> in Kotlin?" + "\n","There is no difference, as Sequence<T> is Kotlin's term for Iterable<T>", "Iterable<T> works only on immutable collections, Sequence<T> is applicable to mutable ones.","Sequences are processed sequentially, Iterables in multithreading","Sequences are processed lazily, Iterables eagerly","d","Answer: (d) Sequences are processed lazily, Iterables eagerly\n" +
                "\n" +
                "Explanation: For Sequence<T>, the extension functions perform lazily where possible, similarly to Java Streams intermediate operations.Sequence<R> and does not actually process the items until a terminal operation like toList or fold is called.")
        val quiz6 = Quiz(6L,"6) A function which can accepts a function as parameter or can returns a function is called?" + "\n","Extensions ", "Lambda","High-Order Function","Nullable Receiver","c","Answer: (c) High-Order Function\n" +
                "\n" +
                "Explanation: It is said to be higher-order because it takes one or more functions as arguments, and/or returns a function as a result. ")
        val quiz7 = Quiz(7L,"7) Which function does not use a lambda receiver (this)?" + "\n","Let", "Run ","With","Apply","a","Answer: (a) Let\n" +
                "\n" +
                "Explanation: These functions are called scope functions in Kotlin, and they are used to perform an action on an object and then return the same object. The purpose of these functions is to simplify the chaining of method calls and to improve the readability of the code.")
        val quiz8 = Quiz(8L,"8) Among these which one is the correct way to write parameters in Kotlin?" + "\n","fun sum(Int: ValueA, Int: valueB)", "fun sum(Int ValueA, Int valueB)","fun sum(valueA: Int, valueB: Int)","fun sum(valueA Int, valueB Int)","c","Answer: (c) fun sum(valueA: Int, valueB: Int)\n" +
                "\n" +
                "Explanation:  Kotlin uses the type followed by the variable name to declare the parameter and no need to use : after the type.In the given example the function sum takes twi parameters of type Int, names ValueA and valueB.")
        val quiz9 = Quiz(9L,"9) What is the correct way to declare a variable of integer type in Kotlin?" + "\n","int i=23", "var i:Int =23","var i: int =23","let i=23","b","Answer: (b) var i:Int = 23\n" +
                "\n" +
                "Explanation:  As Kotlin does not have primitive types, Int is correct while int leads to an error. When also defining a variable as in the example, you may often omit the type and let the compiler infer it.")
        val quiz10 = Quiz(10L,"10) What is the use of the \"lateinit\" keyword in Kotlin?" + "\n","To declare a variable that will be initialized later in the code.", "To declare a variable that cannot be reassigned.","To declare a variable that must be non-null.","To declare a variable that can only be accessed within the same class.","a","Answer: (a) To declare a variable that will be initialized later in the code.\n" +
                "\n" +
                "Explanation: The \"lateinit\" keyword in Kotlin is used to declare a non-null variable that will be initialized later in the code. It is used when the initial value of a variable is not known at the time of declaration. ")
        val quiz11 = Quiz(11L,"11) How can you access a private property of a class in Kotlin?" + "\n","Using private keyword", "Using public keyword","Using override keyword","Using the get and set function","d","Answer: (d) Using the get and set function\n" +
                "\n" +
                "Explanation: In Kotlin, if you want to access a private property of a class, you can do this by using the \"get\" and \"set\" function. These functions are automatically generated by the compiler and allow you to access and set the value of the private property. They are also called accessors.  ")
        val quiz12 = Quiz(12L,"12) How do you create a singleton class in Kotlin?" + "\n","by adding \"singleton\" keyword before class", "by adding \"static\" keyword before class","by adding \"object\" keyword before class","by adding \"final\" keyword before class","c","Answer : (c) by adding \"object\" keyword before class\n" +
                "\n" +
                "Explanation: The object keyword is used to create a singleton class.It creates a single instance of the class and shares it across the entire application. This instance is created at the time of class loading and it is guaranteed to be unique for the entire application.")
        val quiz13 = Quiz(13L,"13) What is the difference between \"data class\" and \"regular class\" in Kotlin?" + "\n","A data class has predefined methods for equality and hashcode whereas regular class does not", "A data class can only be used for data storage whereas regular class can be used for logic and functions","A data class can be inherited whereas regular class cannot","A data class can only have properties whereas regular class can have properties and methods","a","Answer: (a) A data class has predefined methods for equality and hashcode whereas regular class does not\n" +
                "\n" +
                "Explanation: A data class is a special kind of class that is designed to hold data. It automatically generates some useful methods such as equals(), hashCode(), toString() and copy() methods based on the properties defined in the class. ")
        val quiz14 = Quiz(14L,"14) What is the use of the \"when\" expression in Kotlin?" + "\n", "It is used to define a loop", "It is used to define a recursive function","It is used to define a class","It is used to define a switch statement","d","Answer: (d) It is used to define a switch statement\n" +
                    "\n" +
                    "Explanation: The \"when\" expression in Kotlin is used as a replacement for the traditional \"switch\" statement in Java. It evaluates an expression against a list of possible matches, like a switch statement in other programming languages.  ")
        val quiz15 = Quiz(15L,"15) What does this code do?" + "\n" + "foo() ()","Calls foo asynchronously", "Creates two dimensional array","Calls a function which is returned by the call of foo","Fails Compilation","c","Answer: (c) Calls a function which is returned by the call of foo\n" +
                "\n" +
                "Explanation: Kotlin supports high order functions. So a function may have another function as its return type. In the code above, the call to foo with foo() returns another function, which is directly called by noting the second pair of (). ")

        launch {
            context?.let {
                QuizDatabase(it)
                    .getQuizDao().deleteAllQuiz()
                QuizDatabase(it)
                    .getQuizDao().addQuizzes(quiz1,quiz2,quiz3,quiz4,quiz5,quiz6,quiz7,quiz8,
                    quiz9,quiz10,quiz11,quiz12,quiz13,quiz14,quiz15)
            }
        }
    }

}