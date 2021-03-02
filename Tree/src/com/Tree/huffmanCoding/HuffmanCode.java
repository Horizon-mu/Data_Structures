package com.Tree.huffmanCoding;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Horizon~muu
 * @Date: 2021/02/18/18:39
 * @Description:
 */
public class HuffmanCode {
    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();
        byte[] huffmanCodeBytes = huffmanZip(contentBytes);
        System.out.println(Arrays.toString(huffmanCodeBytes));
    }

    public static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("空树，无法遍历~");
        }
    }

    /*
     * 生成哈夫曼树对应的哈夫曼编码
     * 思路：
     * 1、将哈夫曼编码表存放在Map<Byte,String> 形式
     * 2、在生成哈夫曼编码时，需要去拼接路径 ，定义一个StringBuilder，存储某个叶子结点的哈夫曼编码
     * */
    static Map<Byte, String> huffmanCodes = new HashMap<>();
    static StringBuilder stringBuilder = new StringBuilder();

    /*
     *功能：得到传入的结点node的所有叶子节点的哈夫曼编码，并放入 huffmanCodes集合中
     *node : 传入结点
     * code： 路径：左子树是0 ，右子树是1
     * stringBuilder 用于拼接路径
     *
     * 结果：32=01, 97=100, 100=11000, 117=11001, 101=1110, 118=11011, 105=101, 121=11010, 106=0010, 107=1111, 108=000, 111=0011
     * */
    private static void getCodes(Node node, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        //将code加入到stringBuilder2中
        stringBuilder2.append(code);
        if (node != null) {
            //判断当前结点是否是叶子结点
            if (node.data == null) {//不是叶子结点
                //递归处理
                //向左
                getCodes(node.left, "0", stringBuilder2);
                //向右
                getCodes(node.right, "1", stringBuilder2);
            } else {//该结点是叶子结点
                huffmanCodes.put(node.data, stringBuilder2.toString());
            }
        }

    }

    //为了调用方法方便，重载方法getCodes()
    public static Map<Byte, String> getCodes(Node root) {
        if (root == null) {
            return null;
        }
        getCodes(root.left, "0", stringBuilder);
        getCodes(root.right, "1", stringBuilder);
        return huffmanCodes;
    }

    //使用哈夫曼编码来生成哈夫曼编码的数据
    //编码写一个方法，将字符串对应的byte[]数组，通过生成的哈夫曼编码表，返回一个经过压缩后的byte[]

    /*
    * bytes  原始的字符串数组
    * HuffmanCodes  哈夫曼编码表
    * 返回 压缩后的byte[]
    *
    * */
    private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bytes) {
            stringBuilder.append(huffmanCodes.get(b));
        }
        //System.out.println(stringBuilder.toString());
        //统计返回 HuffmanCodeBytes 长度
        //一句话 int len = (stringBuilder.length() + 7) / 8;

        int len;
        if (stringBuilder.length() % 8 == 0) {
            len = stringBuilder.length() / 8;
        } else {
            len = stringBuilder.length() / 8 + 1;
        }
        //创建压缩后的byte数组
        byte[] huffmanCodeBytes = new byte[len];
        int index = 0;
        for (int i = 0; i < stringBuilder.length(); i += 8) {
            String strByte;
            if (i + 8 > stringBuilder.length()) {
                strByte = stringBuilder.substring(i);
            } else {
                strByte = stringBuilder.substring(i, i + 8);
            }
            huffmanCodeBytes[index] = (byte) Integer.parseInt(strByte, 2);
            index++;
        }
        return huffmanCodeBytes;
    }

    private static byte[] huffmanZip(byte[] bytes) {
        List<Node> nodes = getNodes(bytes);
        //根据nodes创建哈夫曼树
        Node root = creatHuffmanTree(nodes);
        Map<Byte,String> huffmanCodes = getCodes(root);
        byte[] huffmanCodeBytes = zip(bytes, huffmanCodes);
        return huffmanCodeBytes;
    }


    private static List<Node> getNodes(byte[] bytes) {
        //代码格式化快捷键 Ctrl + alt + L
        //1.创建一个ArrayList
        List<Node> nodes = new ArrayList<>();

        //遍历bytes,统计每一个字符出现的次数Map<key,value>
        Map<Byte, Integer> counts = new HashMap<>();
        for (byte b : bytes) {
            Integer count = counts.get(b);
            if (count == null) {
                counts.put(b, 1);
            } else {
                counts.put(b, count + 1);
            }
        }
        //把每一个键值对转为Node对象，并存到nodes中
        //遍历Map
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }

    /*
    * 完成数据解压
    * 思路
    * 1：将huffmanCodeBytes数组转换为二进制
    * 2.对照哈夫曼编码表，重新转换为字符串
    *
    * */


    //构建哈夫曼树
    private static Node creatHuffmanTree(List<Node> nodes){
        while (nodes.size() > 1){
            Collections.sort(nodes);

            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node parent = new Node(null,leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;

            nodes.remove(leftNode);
            nodes.remove(rightNode);

            nodes.add(parent);
        }
        return nodes.get(0);
    }
}


class Node implements Comparable<Node>{
    Byte data;        //存放数据本身
    int weight;       //权值

    Node left;          //左子节点
    Node right;         //右子结点

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        //从小到大排序
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }
    //前序遍历

    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

}
