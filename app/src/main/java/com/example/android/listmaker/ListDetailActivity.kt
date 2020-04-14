package com.example.android.listmaker

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.listmaker.adapters.ListItemsRecyclerViewAdapter
import com.example.android.listmaker.models.TaskList
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListDetailActivity : AppCompatActivity() {

    lateinit var list: TaskList
    lateinit var listItemsRecyclerView: RecyclerView
    lateinit var addTaskButton: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_detail)

        list = intent.getParcelableExtra(MainActivity.INTENT_LIST_KEY)

        title = list.name

        listItemsRecyclerView = findViewById(R.id.list_items_recyclerview)
        listItemsRecyclerView.adapter =
            ListItemsRecyclerViewAdapter(
                list
            )
        listItemsRecyclerView.layoutManager = LinearLayoutManager(this)

        addTaskButton = findViewById(R.id.add_task_button)
        addTaskButton.setOnClickListener {
            showCreateTaskDialog()
        }
    }

    private fun showCreateTaskDialog() {
        val positiveButtonText = getString(R.string.add_task)
        val dialogTitle = getString(R.string.task_to_add)

        val builder = AlertDialog.Builder(this)

        val taskEditText = EditText(this)
        taskEditText.inputType = InputType.TYPE_CLASS_TEXT

        builder.setTitle(dialogTitle)
        builder.setView(taskEditText)

        builder.setPositiveButton(positiveButtonText) { dialog, _ ->

                val task = taskEditText.text.toString()
                list.tasks.add(task)

                val recyclerAdapter = listItemsRecyclerView.adapter as ListItemsRecyclerViewAdapter
                recyclerAdapter.notifyItemInserted(list.tasks.size - 1)

                dialog.dismiss()
            }

        builder.create().show()
    }

    override fun onBackPressed() {
        val bundle = Bundle()
        bundle.putParcelable(MainActivity.INTENT_LIST_KEY, list)

        val intent = Intent()
        intent.putExtras(bundle)
        setResult(Activity.RESULT_OK, intent)

        super.onBackPressed()
    }
}
