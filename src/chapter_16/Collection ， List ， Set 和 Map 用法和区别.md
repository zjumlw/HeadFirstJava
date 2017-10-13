# **Collection **， **List **， **Set **和 **Map **用法和区别

## 关系

Collection          	接口的	接口   对象的集合 
├ List                   	**子接口 **     按进入先后有序保存   可重复 
│├ LinkedList              	  接口实现类   链表   插入删除   没有同步   线程不安全 
│├ ArrayList                 	 接口实现类   数组   随机访问   没有同步   线程不安全 
│└ Vector                      	接口实现类   数组                  同步        线程安全 
│ 　 └ Stack
└ Set                  	 **子接口 **      仅接收一次，并做内部排序

├ HashSet

│ 　 └ LinkedHashSet
└ TreeSet

 

​	对于 List ，关心的是顺序， 它保证维护元素特定的顺序（允许有相同元素），使用此接口能够精确的控制每个元素插入的位置。用户能够使用索引（元素在 List 中的位置，类似于数组下标）来访问 List 中的元素。

​	对于 Set ，只关心某元素是否属于 Set （不 允许有相同元素 ），而不关心它的顺序。

 

Map                	接口   		键值对的集合 
├ Hashtable                  接口实现类                  同步           线程安全 
├ HashMap                   接口实现类                  没有同步    线程不安全

│├ LinkedHashMap

│└ WeakHashMap

├ TreeMap
└ IdentifyHashMap

​	对于 Map ，最大的特点是键值映射，且为一一映射，键不能重复，值可以，所以是用键来索引值。 方法 put(Object key, Object value) 添加一个“值” ( 想要得东西 ) 和与“值”相关联的“键” (key) ( 使用它来查找 ) 。方法 get(Object key)返回与给定“键”相关联的“值”。

​	Map 同样对每个元素保存一份，但这是基于 " 键 " 的， Map 也有内置的排序，因而不关心元素添加的顺序。如果添加元素的顺序对你很重要，应该使用 LinkedHashSet 或者 LinkedHashMap.

​	对于效率， Map 由于采用了哈希散列，查找元素时明显比 ArrayList 快。

## 精炼的总结

Collection 是对象集合， Collection 有两个子接口 List 和 Set

List 可以通过下标 (1,2..) 来取得值，值可以重复

而 Set 只能通过游标来取值，并且值是不能重复的

ArrayList ， Vector ， LinkedList 是 List 的实现类

ArrayList 是线程不安全的， Vector 是线程安全的，这两个类底层都是由数组实现的

LinkedList 是线程不安全的，底层是由链表实现的   

Map 是键值对集合

HashTable 和 HashMap 是 Map 的实现类   
HashTable 是线程安全的，不能存储 null 值   
HashMap 不是线程安全的，可以存储 null 值  

## 深入的理解

​	众所周知， Java 来源于 C++ ，屏蔽了其底层实现，简化了对底层实现的管理，使开发者专注于上层功能的实现。在C/C++ 里关于数据的存储需要程序员非常清楚，而 Java 程序员可以完全不管这些，那么， Java 是怎么管理的呢？其实Java 还是需要面临这些问题，只不过经过封装后，变得面目全非。所以对于像我这种从 C/C++ 转向 Java 的人还需要一段时间适应， Collection 、 List 、 Set 、 Map 等概念还需要一个接受的过程。其实到后来发现，不管是什么语言，其底层存储不外乎数组、线性表、栈、队列、串、树和图等数据结构。想明白了这些，一切都敞亮了。

### 一、容器（Collection ） 接口 

　 　容器（ Collection ）是最基本的集合接口，一个容器（ Collection ）保存一组对象（ Object ），即对象是容器的元素（ Elements ）。一些 Collection 允许相同的元素而另一些不行。一些能排序而另一些不行。 Java SDK 不提供直接继承自 Collection 的类， Java SDK 提供的类都是继承自 Collection 的 “ 子接口 ” 如 List 和 Set 。 
　　所有实现 Collection 接口的类都必须提供两个标准的构造函数：**无参数**的构造函数用于创建一个空的 Collection ，有一个 **Collection 参数**的构造函数用于创建一个新的 Collection ，这个新的 Collection 与传入的 Collection 有相同的元素。后一个构造函数允许用户复制一个 Collection 。 
　　如何遍历 Collection 中的每一个元素？不论 Collection 的实际类型如何，它都支持一个 iterator() 的方法，该方法返回一个迭代子，使用该迭代子即可**逐一访问** Collection 中每一个元素。典型的用法如下： 

```java　　　　
Iterator it = collection.iterator(); // 获得一个迭代子 
	while(it.hasNext()) {
		Object obj = it.next(); // 得到下一个元素 
	}
```


​	由 Collection 接口派生的两个接口是 List 和 Set 。 List 按对象进入的顺序保存对象，不做排序或编辑操作。 Set 对每个对象只接受一次，并使用自己内部的排序方法 ( 通常，你只关心某个元素是否属于 Set, 而不关心它的顺序 -- 否则应该使用 List) 。

#### 1. List 接口 

　　 List 是有序的 Collection ，次序是 List 最重要的特点：它保证维护元素特定的顺序。使用此接口能够精确的控制每个元素插入的位置。用户能够使用索引（元素在 List 中的位置，类似于数组下标）来访问 List 中的元素，这类似于 Java的数组。和下面要提到的 Set 不同， List **允许**有**相同**的元素。 
　 　除了具有 Collection 接口必备的 iterator() 方法外， List 还提供一个 listIterator() 方法，返回一个 ListIterator 接口，和标准的 Iterator 接口相比， ListIterator 多了一些 add() 之类的方法，允许添加，删除，设定元素， 还能向前或向后遍历。 
　　实现 List 接口的常用类有 LinkedList ， ArrayList ， Vector 和 Stack 。其中，最常用的是 LinkedList 和 ArrayList两个。 

##### **LinkedList** 类 

　 　 LinkedList 实现了 List 接口，允许 null 元素。此外 LinkedList 提供额外的 addFirst(), addLast(), getFirst(), getLast(), removeFirst(), removeLast(), insertFirst(), insertLast() 方法在 LinkedList 的首部或尾部，这些方法（没有在任何接口或基类中定义过）使 LinkedList 可被用作堆栈（ stack ），队列（ queue ）或双向队列（ deque ）。

​	注意 LinkedList 没有同步方法。如果多个线程同时访问一个 List ，则必须自己实现访问同步。一种解决方法是在创建List 时构造一个同步的 List ： 
　　　　 List list = Collections.synchronizedList(new LinkedList(...));

​	特点：对顺序访问进行了优化，向 List 中间插入与删除的开销并不大。随机访问则相对较慢。 ( 使用 ArrayList 代替。)

##### ArrayList 类 

　　 ArrayList 是由数组实现的 List ，并且实现了可变大小的数组。它允许所有元素，包括 null 。 ArrayList 没有同步。size ， isEmpty ， get ， set 方法运行时间为常数。但是 add 方法开销为分摊的常数，添加 n 个元素需要 O(n) 的时间。其他的方法运行时间为线性。 
　 　每个 ArrayList 实例都有一个容量（ Capacity ），即用于存储元素的数组的大小。这个容量可随着不断添加新元素而自动增加，但是增长算法并没有定义。当需要插入大量元素时，在插入前可以调用 ensureCapacity 方法来增加 ArrayList的容量以提高插入效率。 
　　和 LinkedList 一样， ArrayList 也是非同步的（ unsynchronized ）。

特点：允许对元素进行快速随机访问，但是向 List 中间插入与移除元素的速度很慢。 ListIterator 只应该用来由后向前遍历 ArrayList, 而不是用来插入和移除元素。因为那比 LinkedList 开销要大很多。

##### Vector 类 

　 　 Vector 非常类似 ArrayList ，但是 Vector 是同步的。由 Vector 创建的 Iterator ，虽然和 ArrayList 创建的Iterator 是同一接口，但是，因为 Vector 是同步的，当一个 Iterator 被创建而且正在被使用，另一个线程改变了 Vector的状态（例如，添加或删除了一些元素），这时调用 Iterator 的方法时将抛出 ConcurrentModificationException ，因此必须捕获该异常。 

###### Stack 类 

​	Stack 继承自 Vector ，实现一个后进先出的堆栈。 Stack 提供 5 个额外的方法使得 Vector 得以被当作堆栈使用。基本的 push 和 pop 方法，还有 peek 方法得到栈顶的元素， empty 方法测试堆栈是否为空， search 方法检测一个元素在堆栈中的位置。 Stack 刚创建后是空栈。 

#### 2. Set 接口 

　　 Set 具有与 Collection 完全一样的接口，因此没有任何额外的功能，不像前面有几个不同的 List 。实际上 Set 就是Collection ，只是行为不同。（这是继承与多态思想的典型应用：表现不同的行为）。其次， Set 是一种**不包含重复的元素**的 Collection ，加入 Set 的元素必须定义 **equals()** 方法以确保对象的**唯一性** （ 即任意的两个元素 e1 和 e2 都有e1.equals(e2)=false ），与 List 不同的是， Set 接口不保证维护元素的次序。最后， Set **最多有一个** null 元素。 
　　很明显， Set 的构造函数有一个约束条件，传入的 Collection 参数不能包含重复的元素。 
　　请注意：必须小心操作可变对象（ Mutable Object ）。如果一个 Set 中的可变元素改变了自身状态导致Object.equals(Object)=true 将导致一些问题。 

##### HashSet 类

​	为**快速查找**设计的 Set 。存入 HashSet 的对象必须定义 hashCode() 。

###### LinkedHashSet 类

​	具有 HashSet 的查询速度，且内部使用链表维护元素的顺序 ( 插入的次序 ) 。于是在使用迭代器遍历 Set 时，结果会按元素插入的次序显示。

##### TreeSet 类

​	**保存次序**的 Set, 底层为**树**结构。使用它可以从 Set 中提取有序的序列。

### 二、 Map 接口 

　 　请注意， Map 没有继承 Collection 接口， Map 提供 key 到 value 的映射，你可以通过“键”查找“值”。一个Map 中**不能包含相同的 key** ，每个 key 只能映射**一个 value** 。 Map 接口提供 3 种集合的视图， Map 的内容可以被当作一组 key 集合，一组 value 集合，或者一组 key-value 映射。

​	方法 put(Object key, Object value) 添加一个“值” ( 想要得东西 ) 和与“值”相关联的“键” (key) ( 使用它来查找) 。方法 get(Object key) 返回与给定“键”相关联的“值”。可以用 **containsKey()** 和 **containsValue()** 测试 Map 中是否包含某个“键”或“值”。 标准的 Java 类库中包含了几种不同的 Map ： HashMap, TreeMap, LinkedHashMap, WeakHashMap, IdentityHashMap 。它们都有同样的基本接口 Map ，但是行为、效率、排序策略、保存对象的生命周期和判定“键”等价的策略等各不相同。

​	Map 同样对每个元素保存**一份**，但这是基于 **" 键 "** 的， Map 也有内置的排序，因而不关心元素添加的顺序。如果添加元素的顺序对你很重要，应该使用 LinkedHashSet 或者 LinkedHashMap.

​	执行效率是 Map 的一个大问题。看看 get() 要做哪些事，就会明白为什么在 ArrayList 中搜索“键”是相当慢的。而这正是 HashMap 提高速度的地方。 HashMap 使用了特殊的值，称为**“散列码” (hash code)** ，来取代对键的缓慢搜索。“散列码”是“相对唯一”用以代表对象的 int 值，它是通过将该对象的某些信息进行转换而生成的（在下面总结二：需要的注意的地方有更进一步探讨）。所有 Java 对象都能产生散列码，因为 **hashCode() 是定义在基类 Object 中的方法** 。 HashMap 就是使用对象的 hashCode() 进行快速查询的。此方法能够显著提高性能。

#### Hashtable类 

　　 Hashtable 继承 Map 接口，实现一个 key-value 映射的哈希表。任何**非空**（ non-null ）的对象都可作为 key 或者value 。 
　　**添加**数据使用 **put(key, value)** ，**取出**数据使用 **get(key)** ，这两个基本操作的时间开销为常数。

​	Hashtable 通过**初始化容量** (initial capacity) 和**负载因子** (load factor) 两个参数调整性能。通常缺省的 load factor 0.75 较好地实现了时间和空间的均衡。增大 load factor 可以节省空间但相应的查找时间将增大，这会影响像 get 和 put这样的操作。 
​	使用 Hashtable 的简单示例如下，将 1 ， 2 ， 3 放到 Hashtable 中，他们的 key 分别是 ”one” ， ”two” ，”three” ： 

```java
Hashtable numbers = new Hashtable();
numbers.put(“one”, new Integer(1));
numbers.put(“two”, new Integer(2));
numbers.put(“three”, new Integer(3));
```
　　要取出一个数，比如 2 ，用相应的 key ： 

```java
 Integer n = (Integer)numbers.get(“two”);
　　　　 System.out.println(“two = ” + n);
```

　 　由于作为 key 的对象将通过计算其散列函数来确定与之对应的 value 的位置，因此任何作为 key 的对象都必须实现hashCode 方法和 equals 方法。 hashCode 方法和 equals 方法继承自根类 Object ，如果你用自定义的类当作 key 的话，要相当小心，按照散列函数的定义，如果两个对象相同，即 obj1.equals(obj2)=true ，则它们的 hashCode 必须相同，但如果两个对象不同，则它们的 hashCode 不一定不同，如果两个不同对象的 hashCode 相同，这种现象称为冲突，冲突会导致操作哈希表的时间开销增大，所以尽量定义好的 hashCode() 方法，能加快哈希表的操作。 
　　如果相同的对象有不同的 hashCode ，对哈希表的操作会出现意想不到的结果（期待的 get 方法返回 null ），要避免这种问题，只需要牢记一条：要同时复写 equals 方法和 hashCode 方法，而不要只写其中一个。 
　　 Hashtable 是**<u>同步</u>**的。 

#### HashMap类 

　 　 HashMap 和 Hashtable 类似，也是**基于散列表**的实现。不同之处在于 HashMap 是**<u>非同步</u>**的，并且**允许 null** ，即null value 和 null key 。将 HashMap 视为 Collection 时（ values() 方法可返回 Collection ），插入和查询“键值对”的开销是固定的，但其**迭代子**操作时间开销和 HashMap 的**容量**成比例。因此，如果迭代操作的性能相当重要的话，不要将 HashMap 的初始化容量 (initial capacity) 设得过高，或者负载因子 (load factor) 过低。

##### LinkedHashMap 类

​	类似于 HashMap ，但是迭代遍历它时，取得“键值对”的**顺序**是其**插入次序**，或者是最近最少使用 (LRU) 的次序。只比 HashMap 慢一点。而在迭代访问时发而更快，因为它使用链表维护内部次序。

##### WeakHashMap 类

​	弱键（ weak key ） Map 是一种改进的 HashMap ，它是为解决特殊问题设计的，对 key 实行“ 弱引用 ” ，如果一个 key 不再被外部所引用（没有 map 之外的引用），那么该 key 可以被垃圾收集器 (GC) 回收。 

#### TreeMap类

​	基于红黑树数据结构的实现。查看“键”或“键值对”时，它们会被排序 ( 次序由 Comparabel 或 Comparator 决定) 。 TreeMap 的特点在于，你得到的**结果是经过排序**的。 TreeMap 是**唯一**的带有 subMap() 方法的 Map ，它可以返回一个子树。 

#### IdentifyHashMap 类

​	使用 == 代替 equals() 对“键”作比较的 hash map 。专为解决特殊问题而设计。

## 总结一：比较

### 1 ，数组 (Array) ，数组类 (Arrays)

​	Java 所有“存储及随机访问一连串对象”的做法， array 是最有效率的一种。但**缺点**是**容量固定**且**无法动态改变**。 array还有一个缺点是，无法判断其中实际存有多少元素， length 只是告诉我们 array 的容量。

​	Java 中有一个数组类 (Arrays) ，专门用来操作 array 。数组类 (arrays) 中拥有一组 static 函数。

equals() ：比较两个 array 是否相等。 array 拥有相同元素个数，且所有对应元素两两相等。

fill() ：将值填入 array 中。

sort() ：用来对 array 进行排序。

binarySearch() ：在排好序的 array 中寻找元素。

System.arraycopy() ： array 的复制。

​	若编写程序时不知道究竟需要多少对象，需要在空间不足时自动扩增容量，则需要使用容器类库， array 不适用。

### 2 ，容器类与数组的区别

​	容器类仅能持有对象引用（指向对象的指针），而不是将对象信息 copy 一份至数列某位置。一旦将对象置入容器内，便损失了该对象的型别信息。

### 3 ，容器 (Collection) 与 Map 的联系与区别

​	Collection 类型，每个位置只有一个元素。

​	Map 类型，持有 **key-value 对** (pair) ，像个小型数据库。

 

​	Collections 是针对**集合类**的一个帮助类。提供了一系列静态方法实现对各种集合的**搜索**、**排序**、**线程完全化**等操作。相当于对 Array 进行类似操作的类—— Arrays 。

如， Collections.max(Collection coll); 取 coll 中最大的元素。

​    	Collections.sort(List list); 对 list 中元素排序

 

​	List ， Set ， Map 将持有对象一律视为 Object 型别。

​	Collection 、 List 、 Set 、 Map 都是接口，不能实例化。继承自它们的 ArrayList, Vector, HashTable, HashMap 是具象 class ，这些才可被实例化。

​	vector 容器确切知道它所持有的对象隶属什么型别。 vector 不进行边界检查。

### 4， Collection与Collections的区别

Collection：Java.util下的一个接口，是各种集合结构的**父接口**。

Collections：Java.util下的一个专用**静态类**，他包含各种集合操作的静态方法，包括对集合的搜索、排序、线程安全等操作。

### 5， ArrayList、LinkedList和Vector的区别

**ArrayList **是一个可改变大小的数组，当更多的元素加入到ArrayList中时，其大小将会动态地增长。内部的元素可以直接通过get与set方法进行访问，因为ArrayList本质上就是一个数组。
**LinkedList **是一个双链表，在添加和删除元素时具有比ArrayList更好的性能。但在get与set方面弱于ArrayList。

> 当然，这些对比都是指数据量很大或者操作很频繁的情况下的对比，如果数据和运算量很小，那么对比将失去意义。

**Vector **和ArrayList类似，唯一的区别在于Vector是同步类(synchronized)。如果你的程序本身是线程安全的（thread-safe，没有在多个线程之间共享同一个集合/对象），那么使用ArrayList是更好的选择。

Vector和ArrayList在更多元素添加进来时会请求更大的空间。Vector每次请求其大小的双倍空间，而ArrayList每次对size增长50%。

而LinkedList **还实现了 **Queue接口，该接口比List提供了更多的方法，包括 offer()，peek()，poll()等。

>  注意：默认情况下ArrayList的初始容量非常小，所以如果可以预估数据量的话，分配一个较大的初始值属于最佳实践，这样可以减少调整大小的开销。

#### ArrayList与LinkedList性能对比

时间复杂度对比如下:

|          | ArrayList | LinkedList         |
| -------- | --------- | ------------------ |
| get()    | **O(1)**  | **O(n)**           |
| add()    | **O(1)**  | **O(1) amortized** |
| remove() | **O(n)**  | **O(n)**           |

LinkedList更适用于:

- **没有**大规模的随机读取；
- **大量**的增加/删除操作。

## 总结二：需要注意的地方

1 、 Collection 只能通过 **iterator()** 遍历元素，没有 get() 方法来取得某个元素。

2 、 Set 和 Collection 拥有一模一样的接口。但排除掉传入的 Collection 参数重复的元素。

3 、 List ，可以通过 get() 方法来一次取出一个元素。使用数字来选择一堆对象中的一个， get(0)... 。 (add/get)

4 、 Map 用 put(k,v) / get(k) ，还可以使用 containsKey()/containsValue() 来检查其中是否含有某个 key/value 。

​	HashMap 会利用对象的 hashCode 来快速找到 key 。

​	哈希码 (hashing) 就是将对象的信息经过一些转变形成一个独一无二的 int 值，这个值存储在一个 array 中。我们都知道所有存储结构中， array 查找速度是最快的。所以，可以加速查找。发生碰撞时，让 array 指向多个 values 。即，数组每个位置上又生成一个梿表。

5 、 Map 中元素，可以将 key 序列、 value 序列单独抽取出来。

使用 keySet() 抽取 key 序列，将 map 中的所有 keys 生成一个 Set 。

使用 values() 抽取 value 序列，将 map 中的所有 values 生成一个 Collection 。

为什么一个生成 Set ，一个生成 Collection ？那是因为， key 总是独一无二的， value 允许重复。

## 总结三：如何选择 

### 从效率角度：

​	在各种 Lists ，对于需要快速插入，删除元素，应该使用 LinkedList （可用 LinkedList 构造堆栈 stack 、队列 queue），如果需要快速随机访问元素，应该使用 ArrayList 。最好的做法是以 ArrayList 作为缺省选择。 Vector 总是比ArrayList 慢，所以要尽量避免使用。

​	在各种 Sets 中， HashSet 通常优于 HashTree （插入、查找）。只有当需要产生一个经过排序的序列，才用 TreeSet 。HashTree 存在的**唯一**理由：**能够维护其内元素的排序状态。**

​	在各种 Maps 中 HashMap 用于**快速查找**。

​	最后，当元素个数固定，用 Array ，因为 Array 效率是最高的。

​	所以结论：最常用的是 ArrayList ， HashSet ， HashMap ， Array 。

### 更近一步分析：

​	如果程序在**单线程**环境中，或者访问仅仅在一个线程中进行，考虑**非同步**的类，其效率较高，如果**多个线程**可能同时操作一个类，应该使用**同步**的类。 
​	要特别注意对哈希表的操作，作为 key 的对象要同时正确**复写** **equals 方法**和 **hashCode 方法**。 
​	尽量**返回接口**而非实际的类型，如返回 List 而非 ArrayList ，这样如果以后需要将 ArrayList 换成 LinkedList 时，客户端代码不用改变。这就是针对抽象编程。

zz：http://blog.csdn.net/zccst/article/details/5056920