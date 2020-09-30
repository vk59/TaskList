package com.vk59.tasklist

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.vk59.tasklist.databinding.FragmentTasksListBinding
import com.vk59.tasklist.db.Task

class TasksListFragment : Fragment() {
    private lateinit var tasksListViewModel: TasksViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding: FragmentTasksListBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_tasks_list, container, false
        )
        binding.lifecycleOwner = this

        tasksListViewModel = ViewModelProvider(this).get(TasksViewModel::class.java)
        binding.tasksListViewModel = tasksListViewModel

        setHasOptionsMenu(true)
        binding.floatingActionButton.setOnClickListener {
            Navigation
                .findNavController(it).navigate(R.id.action_tasksListFragment_to_addTaskFragment)
        }
        tasksListViewModel.tasksList.observe(viewLifecycleOwner, { tasks: List<Task> ->
            val stringBuilder: StringBuilder = StringBuilder()
            for (task: Task in tasks) {
                stringBuilder.append(task.taskName + " " + task.taskImportance + "\n")
            }
            binding.tasksList.text = stringBuilder.toString()
        })
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == R.id.deleteAll) {
            tasksListViewModel.deleteAllTasks()
            true
        } else {
            NavigationUI.onNavDestinationSelected(
                item,
                NavHostFragment.findNavController(this)
            ) || super.onOptionsItemSelected(item)
        }
    }
}