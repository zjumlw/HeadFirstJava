## getContentPane()与setContentPane()

方法1：

```java
frame.getContentPane().add(childComponent);
```

先得到JFrame的内容面板，然后往内容面板里添加组件。

方法2：

```java
class MyDrawPanel extends JPanel implements ControllerEventListener{
  ......
};
ml = new MyDrawPanel();
frame.setContentPane(ml);
```

先建立一个JPanel的中间容器，把组件添加到该容器中，然后把该容器设置为JFrame的内容面板。