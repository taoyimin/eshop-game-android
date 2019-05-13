package com.taoyimin.eshop.fragment

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.taoyimin.eshop.R
import com.taoyimin.eshop.adapter.GameAdapter
import com.taoyimin.eshop.bean.Game
import com.taoyimin.eshop.i.OnItemClickListener
import kotlinx.android.synthetic.main.fragment_game_list.*

/**
 * Created by Tao Yimin on 2019/5/10.
 */
class GameListFragment : BaseFragment() {
    private val gameList = ArrayList<Game>()
    private var adapter = GameAdapter(gameList)

    companion object {
        private val TAG = this::class.java.name

        fun getInstance(title: String): GameListFragment {
            val fragment = GameListFragment()
            val bundle = Bundle()
            bundle.putString("title", title)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun setContentViewId(): Int {
        return R.layout.fragment_game_list
    }

    override fun initView() {
        recycler_view.layoutManager = LinearLayoutManager(context)
        recycler_view.adapter = adapter
        adapter.setOnItemClickListener(object : OnItemClickListener<Game> {
            override fun onItemClick(obj: Game, position: Int) {

            }
        })
        when (arguments?.getString("title")) {
            "标题1" -> recycler_view.setBackgroundColor(Color.BLUE)
            "标题2" -> recycler_view.setBackgroundColor(Color.RED)
            "标题3" -> recycler_view.setBackgroundColor(Color.GREEN)
            "标题4" -> recycler_view.setBackgroundColor(Color.GRAY)
        }
    }

    override fun loadData() {
        for (i in 1..40) {
            val game = Game("标题$i")
            gameList.add(game)
        }
        adapter.notifyDataSetChanged()
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        Log.i(TAG, arguments?.getString("title")+"***setUserVisibleHint***isVisibleToUser="+isVisibleToUser)
        super.setUserVisibleHint(isVisibleToUser)
    }

    override fun onAttach(context: Context?) {
        Log.i(TAG, arguments?.getString("title")+"***onAttach")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i(TAG, arguments?.getString("title")+"***onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.i(TAG, arguments?.getString("title")+"***onCreateView")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.i(TAG, arguments?.getString("title")+"***onViewCreated")
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.i(TAG, arguments?.getString("title")+"***onActivityCreated")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        Log.i(TAG, arguments?.getString("title")+"***onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.i(TAG, arguments?.getString("title")+"***onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.i(TAG, arguments?.getString("title")+"***onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.i(TAG, arguments?.getString("title")+"***onStop")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.i(TAG, arguments?.getString("title")+"***onDestroyView")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.i(TAG, arguments?.getString("title")+"***onDestroy")
        super.onDestroy()
    }

    override fun onDetach() {
        Log.i(TAG, arguments?.getString("title")+"***onDetach")
        super.onDetach()
    }
}