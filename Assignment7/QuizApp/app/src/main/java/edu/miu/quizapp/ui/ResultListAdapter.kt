package edu.miu.quizapp.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import edu.miu.quizapp.databinding.RowAnswersBinding
import edu.miu.quizapp.db.QuizResult

class ResultListAdapter : ListAdapter<QuizResult, RecyclerView.ViewHolder>(AnswerDiffUtilCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = RowAnswersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ResultViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int){
        (holder as ResultViewHolder).bind(getItem(position))
    }

    class ResultViewHolder(private val binding: RowAnswersBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: QuizResult) {
            binding.questionTextView.text = data.question
            binding.answerTextView.apply {
                text = "Your answer: ${data.answer}"
                setTextColor(if (data.answer == data.correctAnswer)
                    Color.parseColor("#00A300")
                else
                    Color.RED
                )
            }
            binding.correctAnswerTextView.text = "Correct answer: ${ data.explanation }"
        }
    }
}

class AnswerDiffUtilCallBack : DiffUtil.ItemCallback<QuizResult>() {
    override fun areItemsTheSame(oldItem: QuizResult, newItem: QuizResult): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: QuizResult, newItem: QuizResult): Boolean {
        return oldItem.id == newItem.id
    }
}