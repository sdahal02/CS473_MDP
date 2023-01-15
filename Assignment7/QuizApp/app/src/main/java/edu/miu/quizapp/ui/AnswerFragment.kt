package edu.miu.quizapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.miu.quizapp.R
import edu.miu.quizapp.db.Quiz
import edu.miu.quizapp.db.QuizDatabase
import edu.miu.quizapp.db.QuizResult
import edu.miu.quizapp.utils.BaseFragment
import kotlinx.coroutines.launch


class AnswerFragment : BaseFragment() {

    private lateinit var resultAdapter: ResultListAdapter
    private lateinit var recyclerView: RecyclerView

    private lateinit var questions: List<Quiz>
    private val quizResult: ArrayList<QuizResult> =  ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_answer, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        val answers = ResultFragmentArgs.fromBundle(requireArguments()).answers

        setUpRecyclerView()

        launch {
            context?.let {
                questions = QuizDatabase(it).getQuizDao().getAllQuizzes()
                questions.forEach{ q ->
                    q.answer
                }
                populateData(questions, answers.toList())
            }
        }

        return view
    }

    //initialize recycler view
    private fun setUpRecyclerView() {
        resultAdapter = ResultListAdapter()
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = resultAdapter
        }
    }

    private fun populateData(questions: List<Quiz>, answers: List<String>) {
        //clear previous data from quizResult
        quizResult.clear()

        for ((index, value) in questions.withIndex()){
            quizResult.add(
                QuizResult(
                    id = index,
                    question = value.question,
                    answer = answers[index],
                    correctAnswer = value.answer,
                    explanation = value.explanation
                )
            )

        }

        //populate updated data in recycler view
        resultAdapter.submitList(quizResult)
    }
}