package com.appwork.ada.collections

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.appwork.ada.R
import java.util.*
import kotlin.collections.ArrayList

/**
 *
 * Represents a single unit of objects.
 * It's a framework that provides an architecture to store and manipulate the group of objects
 * can achieve operations on data - searching, sorting, insertion, manipulation, deletion
 * Collection framework provides -
 * Interfaces- Set, List, Queue, Deque
 * Classes -  ArrayList, LinkedList, PriorityQueue, HashSet, LinkedHashSet, TreeSet, Vector
 * Iterator - helps to traverse a list or a set of data
 *
 * Questions:
 * Collection framework vs Collections
 *
 *
 * ArrayList vs array
 *
 * 1.array holds similar type of data
 * 2.fixed size, its not dynamic
 * 3.we can take advantage of collections methods/properties
 *
 * ArrayList:
 * dis adv - misused of memory
 * adv - index, dynamic
 *
 *
 *Why and what ArrayList?
 *
 *
 * delete / add first element
 * [1][2][3][4]  Swapping each element
 * [0][1][2][3][4]
 *
 * Comparator -
 *
 * set vs add
 *
 * giving initial capacity (ArrayList<Any>(3)) - makes it faster
 *
 * val num : Int = 1
 * val num1 : Int = 2
 * val num2: Int = 3
 * val num3 : Int = 4
 * val num4 : Int = 5
 * val num5 : Int = 6
 * val num6 : Int = 7
 * val num7 : Int = 8
 *
 * val list : ArrayList<Integer> = {1,2,3,4,5,6,7,5,9,10}
 * val list : ArrayList<Any>
 *
 */

class CollectionArrayList : AppCompatActivity(){
                                                                                                        //1020
    private var list : ArrayList<Any> =ArrayList<Any>() //Creating arraylist   [head][0] -> [1020][1]-> [1030][2]


    fun addList(){
        /* 0 */list.add("Mango")//Adding object in arraylist               //arr1  {["first"][0]} {[][1][2][3]}  ,adding 1 more item , [0][1][2][3][4][5]
        /* 1 */list.add(1)
        /* 2 */list.add(true)
        /* 3 */list.add("Grapes")
        /* 4 */list.add("Melon")
        /* 5 */list.add("Grapes")
        //Printing the arraylist object
        Log.i("list : ",list.toString())

        for (i in list) { // Print list in loop // Traversal 1
            println(i)
        }

        val itr = list.iterator() // Traversal 2 using iterator() function

        while(itr.hasNext()) {
            println(itr.next())
        }

        println("size of arrayList2 = "+list.size) // list length by size attribute

        println( list.get(2)) // get method to get the value in specific index

        list.set(2,"Orange") // set new value in a specific index

        println(list.indexOf("Grapes")) // return index value of first occurrence of element otherwise -1

        println(list.lastIndexOf("Grapes")) //index value of last occurrence of element otherwise -1

       list.remove("Orange")// remove the first occurrence of element if present

        println(list)

        list.removeAt(0) // remove the element of specified index

        println(list)
        Log.i("removeAt 0: ",list.toString())


        list.clear() //remove (clear) all the elements

       //var sortedList =  Collections.sort(list)



    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collection_list)
        addList()
    }

}