## ArrayList

### 方法
add(Object elem)  
向list中加入对象参数  
remove(int index)  
在索引参数中移除对象  
remove(Object elem)  
移除该对象  
contain(Object elem)  
如果和对象参数匹配返回“true”  
isEmpty()  
如果list中没有元素返回“true"  
indexOf(Object elem)  
返回对象参数的索引或-1  
size()  
返回list中元素的个数  
get(int index)  
返回当前索引参数的对象
### 与一般数组的不同
1. 一般数组在创建时就必须确定大小  
ArrayList只需要创建该类型的对象就可以，不需要指定大小，因为在加入或者删除元素时自动地调整大小。  
2. 存放对象给一般数组时必须制定位置  
ArrayList可以使用add(Int, Object)来指定索引值，或者用add来让它自行管理大小
3. 一般数组使用特殊的语法
4. ArrayList是参数化的  
ArrayList<String>其中的String就是类型参数，代表这是String的集合。

