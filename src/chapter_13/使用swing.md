## 使用swing

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

