package edu.miu.quizapp.db

data class QuizResult(
    val id: Int,
    val question: String,
    val answer: String,
    val correctAnswer: String,
    val explanation: String
)
