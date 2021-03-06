package com.zhenggq.datastructure.ch11;

/**
 * @Author: Zhenggq
 * @Date: 2018/9/15 14:51
 * @Description:
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {

        //Scanner cin = new Scanner(System.in);
        //int a = cin.nextInt(), b = cin.nextInt();
        //System.out.println(a + b);

        Tree t = new Tree();
        t.insert(10);
        t.insert(15);
        t.insert(6);
        t.insert(25);
        t.insert(13);
        t.insert(9);
        t.insert(5);
        t.insert(12);
        t.insert(14);

        //System.out.println(t.root.data);
        //System.out.println(t.root.rightChild.data);
        //System.out.println(t.root.rightChild.rightChild.data);
        //System.out.println(t.root.leftChild.data);

        //查找节点
        //Node n = t.find(25);
        //System.out.println(n.data);


        //前序遍历
        System.out.println("前序遍历测试=======");
        t.frontOrder(t.root);
        //中序遍历
        System.out.println("中序遍历测试=======");
        t.inOrder(t.root);
        //后序遍历
        System.out.println("后序遍历测试=======");
        t.laterOrder(t.root);


        //删除测试1,删除数字为5的节点,第一种情况
        t.delete(5);
        System.out.println("验证删除结果1=======");
        t.frontOrder(t.root);
        //删除测试2,删除数字为6的节点,第二种情况
        t.delete(6);

        t.delete(9);
        t.delete(10);

        System.out.println("验证删除结果2=======");
        t.frontOrder(t.root);


        //             10
        //        6           15
        //    5      9    13     25
        //              12  14 23  50
        //                   22
        //
        //
    }
}
