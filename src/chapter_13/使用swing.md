## 使用swing

### swing的组件

几乎所有的组件都能够安置其他的组件，大部分情况下，把按钮或者列表等**用户交互**组件放在**框架**和**面板**等**背景组件**上。

除了JFrame之外，交互组件与背景组件的差异不太明确。

创建GUI的四个步骤：

- 创建window（JFrame）：

```java
JFrame frame = new JFrame();
```

- 创建组件：

```java
JButton button = new JButton("click me");
```

- 把组件加到frame上：

```java
frame.getContentPane().add(BorderLauout.EAST,button);
```

- 显示出来：

```java
frame.setSize(300,300);
frame.setVisible(true);
```

### 布局管理器（Layout Managers）

布局管理器是与特定组件关联的Java对象，大多数是背景组件，用来**控制**所关联组件上**携带的其他组件**。

面板携带按钮：

```java
myPanel.add(button);
```

不同的布局管理器有不同的策略。

三大管理器：

- BorderLayout：把背景组件分成5个区域，每个区域只能放一个组件。这是**框架**默认的布局管理器。
- FlowLayout：每个组件都会依照理想的大小呈现，并且会从左到右依照加入的顺序以可能会换行的方式排列。这是**面板**默认的布局管理器。
- BoxLayout：以垂直的方向来排列，但是不会自动换行，它让你插入某种类似换行的机制来强制组件从新的一列开始排列。

#### BorderLayout

```java
public void go(){
  JFrame frame = new JFrame();
  JButton button = new JButton("Click");
  Font bigFont = new Font("serif", Font.BOLD, 28);
  button.getFont(bigFont);
  frame.getContentPane().add(BorderLayout.NORTH, button);
  frame.setSize(200, 200);
  frame.setVisible(true);
}
```

中间区域只能捡剩下的。

#### FlowLayout

JPanel的默认布局管理是FlowLayout布局。

把面板加到JFrame时：

- 面板的大小和位置还是受BorderLayout布局的管理；
- 面板内部的组件由面板的FlowLayout布局来管理。

```java
public void go(){
  JFrame frame = new JFrame();
  JPanel panel = new JPanel();
  panel.setBackground(Color.gray);	//设置面板颜色
  
  JButton button = new JButton("Click");
  panel.add(button);
  frame.getContentPane().add(BorderLayout.NORTH, panel);
  frame.setSize(200, 200);
  frame.setVisible(true);
}
```

#### BoxLayout

就算水平宽度足以容纳组件，还是会用新的行来排列组件。

```
public void go(){
  JFrame frame = new JFrame();
  JPanel panel = new JPanel();
  panel.setBackground(Color.gray);	//设置面板颜色
  //更换布局管理器，参数需要知道1.管理那个组件；2.使用那个轴
  panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
  
  JButton button = new JButton("Click");
  JButton buttonTwo = new JButton("OK");
  
  panel.add(button);
  panel.add(buttonTwo);
  frame.getContentPane().add(BorderLayout.NORTH, panel);
  frame.setSize(200, 200);
  frame.setVisible(true);
}
```

#### 要点

- 布局管理器会控制嵌套在其他组件中组件的大小和位置。
- 当某个组件加到背景组件上面时，被加入的组件是由背景组件的布局管理器管理的。
- 布局管理器在做决定之前会询问组件的理想大小，并根据策略来决定采用哪些数据。
- BorderLayout布局可以让你把组件加到五个区域上，南北区域使用组件的高度而不管宽度，东西区域使用组件的宽度而不管高度，中间区域只能使用剩下的空间。
- pack()方法使window的大小符合内含组件的大小。
- FlowLayout布局会由左至右、由上至下依加入的顺序来安置组件，若宽度超过时就会换行。
- FlowLayout布局会让组件在长宽上都使用理想的尺寸大小。
- BoxLayout布局可以垂直地排列组件。
- 可以用setLayout()来改变面板的布局管理器。

### 常用的组件

#### JTextField

构造函数：

```java
JTextField field = new JTextField(20); //代表20字宽
JTextField field = new JTextField("Your name");
```

取得文本内容：

```java
System.out.println(field.getText());
```

设定内容：

```java
field.setText("what");
```

取得用户输入完毕按下return或enter的事件：

```java
field.addActionListener(myActionListener);
```

选取文本字段的内容：

```java
field.selectAll();
```

把GUI目前焦点拉到文本字段以便让用户进行输入操作：

```java
field.requestFocus();
```

#### JTextArea

不像JTextField只能显示一行文字，JTextArea可以显示多行文字，而且可以加入ScrollPane滚动条。

构造函数：

```java
JTextArea text = new JTextArea(10, 20);	//10行，20字宽
```

只有垂直的滚动条：

```java
JScrollPane scroller = new JScrollPane(text);	//将text值赋值给新创建的JScrollPane
text.setLineWrap(true);	//启动自动换行
//设定只使用垂直滚动条
scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

panel.add(scroller);	//加入的是带有文本域的滚动条而不是文本域，不再添加文本域
```

替换掉文字内容：

```java
text.setText("lost");
```

加入文字：

```java
text.append("click");
```

选取内容：

```java
text.selectAll();
```

把GUI目前焦点拉到文本字段以便让用户进行输入操作：

```java
field.requestFocus();
```

#### JCheckBox

构造函数：

```java
JCheckBox check = new JCheckBox("go");
```

监听item的事件：

```java
check.addItemListener(this);
```

处理事件：

```java
public void itemStateChanged(ItemEvent ev){
  String onOff = "off";
  if(check.isSelected())
  	onOff = "on";
  System.out.println("Checkbox is " + onOff);
}
```

用程序来选取或不选取：

```java
check.setSelected(true);
check.setSelected(false);
```

#### JList

构造函数需要一个任意类型的数组：

```java
String[] listEntries = {"a","b",...};
list = new JList(listEntries);
```

让它显示垂直的滚动条：

```java
JScrollPane scroller = new JScrollPane(list);	//将list值赋值给新创建的JScrollPane
//设定只使用垂直滚动条
scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

list.add(scroller);	//加入的是带有文本域的滚动条而不是文本域，不再添加文本域
```

设定显示的行数：

```java
list.setVisibleRowCount(4);
```

限制用户只能选取一个项目：

```java
list.setListSelectionMode(ListSelectionModel.SINGLE_SELECTION);
```

对选择事件做注册：

```java
list.addListSelectionListener(this);
```

处理事件：

```java
public void valueChanged(ListSelectionEvent lse){
  if(!lse.getValueIsAdjusting()){	//如果不加上if，会得到两次的事件
    String selection = (String) list.getSelectionValue();	//返回的可能是一个Object
    System.out.println(selection);
  }
}
```

