package com.algorithm.datastructure.Tree.The_use_of_tree;


import com.algorithm.datastructure.Tree.node;

import java.io.*;
import java.util.*;

public class Huffman_tree {
    /*
     * 给定 n 个权值作为 n 个叶子结点， 构造一棵二叉树
     * 若该树的带权路径长度(wpl)达到最小，
     * 称这样的二叉树为最优二叉树， 也称为哈夫曼树(Huffman Tree)
     * 赫夫曼树是带权路径长度最短的树， 权值较大的结点离根较近
     */

    /*
     * 几个重要概念
     * 1) 路径和路径长度：
     *   在一棵树中， 从一个结点往下可以达到的孩子或孙子结点之间的通路， 称为路径。
     *   通路中分支的数目成为路径长度
     *   若规定根结点的层数为 1， 则从根结点到第 L 层结点的路径长度为 L-1
     * 2) 结点的权及带权路径长度：
     *   若将树中结点赋给一个有着某种含义的数值， 则这个数值称为该结点的权。
     *   结点的带权路径长度为： 从根结点到该结点之间的路径长度与该结点的权的乘积
     * 3) 树的带权路径长度：
     *   树的带权路径长度规定为所有叶子结点的带权路径长度之和，
     *   注意：是叶子结点
     *   记为 WPL(weighted pathlength) ,
     *   权值越大的结点离根结点越近的二叉树才是最优二叉树。
     * 4) WPL 最小的就是赫夫曼树
     */

    /**
     * 构成赫夫曼树的步骤：
     * 1) 从小到大进行排序,将每一个数据，每个数据都是一个节点，每个节点可以看成是一颗最简单的二叉树
     * 2) 取出根节点权值最小的两颗二叉树
     * 3) 组成一颗新的二叉树, 该新的二叉树的根节点的权值是前面两颗二叉树根节点权值的和
     * 4) 再将这颗新的二叉树， 以根节点的权值大小 再次排序，
     * 不断重复 1-2-3-4 的步骤， 直到数列中， 所有的数据都被处理， 就得到一颗赫夫曼树
     */
    public static node create_huffman_tree(int[] nums) {
        // 第一步为了操作方便
        // 1. 遍历数组
        // 2. 将数组每个元素构成一个node
        // 3. 将node放入到ArrayList中去
        List<node> nodes = new ArrayList<node>();
        for(int val: nums) nodes.add(new node(val));

        // 处理的过程是一个循环的过程
        while(nodes.size() > 1) {
            Collections.sort(nodes);
            System.out.println("nodes = " + nodes);

            // 取出根节点权值最小的两颗二叉树
            // (1) 取出权值最小的结点（二叉树）
            node leftNode = nodes.get(0);
            // (2) 取出权值第二小的结点（二叉树）
            node rightNode = nodes.get(1);

            // (3) 构建一颗新的二叉树
            node parent = new node(leftNode.val + rightNode.val);
            parent.left = leftNode;
            parent.right = rightNode;

            // (4) 从ArrayList删除处理过的二叉树
            nodes.remove(leftNode);
            nodes.remove(rightNode);

            // (5) 将parent加入到nodes
            nodes.add(parent);
        }

        // 返回哈夫曼树的root结点
        return nodes.get(0);
    }


    // 前序遍历
     public static void preOrder(node root){
         if(root != null) {
             root.preOrder();
         }
         else System.out.println("The tree is null");
     }

     // 赫夫曼编码
    /**
     * 1) 赫夫曼编码也翻译为 哈夫曼编码(Huffman Coding)， 又称霍夫曼编码， 是一种编码方式, 属于一种程序算法
     * 2) 赫夫曼编码是赫哈夫曼树在电讯通信中的经典的应用之一。
     * 3) 赫夫曼编码广泛地用于数据文件压缩。 其压缩率通常在 20%～90%之间
     * 4) 赫夫曼码是可变字长编码(VLC)的一种。 Huffman 于 1952 年提出一种编码方法， 称之为最佳编码
     */
    /**
     * 构成赫夫曼树的步骤：
     * 1) 从小到大进行排序, 将每一个数据， 每个数据都是一个节点 ， 每个节点可以看成是一颗最简单的二叉树
     * 2) 取出根节点权值最小的两颗二叉树
     * 3) 组成一颗新的二叉树, 该新的二叉树的根节点的权值是前面两颗二叉树根节点权值的和
     * 4) 再将这颗新的二叉树， 以根节点的权值大小 再次排序， 不断重复 1-2-3-4 的步骤， 直到数列中， 所有的数据都被处理，
     * 就得到一颗赫夫曼树
     */
    // 数据压缩--创建赫夫曼树
    public static node create_huffman_tree(List<node> nodes) {
        while(nodes.size() > 1) {
            // 排序，从小到大
            Collections.sort(nodes);
            // 取出第一颗最小的二叉树
            node leftNode = nodes.get(0);
            // 取出第二课最小的二叉树
            node rightNode = nodes.get(1);
            // 创建出一颗新的二叉树，它的根节点没有data，只有权值
            node parent = new node(null, leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;

            // 将已经处理的两颗二叉树从nodes中删除
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            // 将新的二叉树，加入到nodes
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    // 数据压缩--生成赫夫曼树对应的赫夫曼编码和赫夫曼编码后的数据
    //生成赫夫曼树对应的赫夫曼编码
    //思路:
    //1. 将赫夫曼编码表存放在 Map<Byte,String> 形式
    // 生成的赫夫曼编码表
    // {32=01, 97=100, 100=11000, 117=11001, 101=1110, 118=11011, 105=101,121=11010, 106=0010, 107=1111, 108=000, 111=0011}
    // 2. 在生成赫夫曼编码表示， 需要去拼接路径, 定义一个 StringBuilder 存储某个叶子结点的路径

    static Map<Byte, String> huffmanCodes = new HashMap<>();
    static StringBuilder stringBuilder = new StringBuilder();
    private static Map<Byte, String> getCodes(node root) {
        if(root == null) return null;
        // 处理root的左子树
        getCodes(root.left, "0", stringBuilder);
        // 处理root的右子树
        getCodes(root.right, "1", stringBuilder);
        return huffmanCodes;
    }
    /**
     *
     * 功能： 将传入的 node 结点的所有叶子结点的赫夫曼编码得到， 并放入到 huffmanCodes 集合
     * @param node 传入结点
     * @param code 路径： 左子结点是 0, 右子结点 1
     * @param stringBuilder 用于拼接路径
     */
    private static void getCodes(node node, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        // 将code加入到stringBuilder2中
        stringBuilder2.append(code);
        if(node!=null) {
            // 如果node == null不处理

            // 判断当前node是叶子结点还是非叶子结点
            if(node.data == null) {
                // 非叶子结点
                // 递归处理
                getCodes(node.left, "0", stringBuilder2);
                getCodes(node.right, "1", stringBuilder2);
            } else {
                // 叶子结点
                // 表示找到某个叶子结点的最后
                huffmanCodes.put(node.data, stringBuilder2.toString());
            }
        }
    }

    // 数据解压--使用赫夫曼编码解压
    /**
     * 将一个 byte 转成一个二进制的字符串, 如果看不懂， 可以参考二进制的原码， 反码， 补码
     * @param b 传入的 byte
     * @param flag 标志是否需要补高位如果是 true ， 表示需要补高位， 如果是 false 表示不补, 如果是最后一个字节， 无需补高位
     * @return 是该 b 对应的二进制的字符串， （注意是按补码返回）
     */
    private static String byteToBitString(boolean flag, byte b) {
        // 使用变量保存b
        int temp = b; // 将b转成int
        // 如果是正数 还存在补高位
        if(flag) {
            temp |= 256; // 按位或256
            // 1 0000 0000  |  0000 0001  => 1 0000 0001
        }
        String str = Integer.toBinaryString(temp); // 返回的是temp对应的二进制的补码
        if(flag) return str.substring(str.length() - 8);
        else return str;
    }

    //编写一个方法， 完成对压缩数据的解码
    /**
     *
     *@param huffmanCodes 赫夫曼编码表 map
     * @param huffmanBytes 赫夫曼编码得到的字节数组
     * @return 就是原来的字符串对应的数组
     */
    public static byte[] decode(Map<Byte, String> huffmanCodes, byte[] huffmanBytes) {
        // 先得到huffmanBytes 对应的二进制的字符串， 形式 1010100010111...
        StringBuilder stringBuilder = new StringBuilder();
        // 将byte数组转成二进制的字符串
        for(int i = 0; i < huffmanBytes.length; i++) {
            byte b = huffmanBytes[i];
            // 判断是不是最后一个字节
            boolean flag = (i == huffmanBytes.length - 1);
            stringBuilder.append(byteToBitString(!flag, b));
        }
        // 把字符串安装指定的赫夫曼编码进行解码
        // 把赫夫曼编码表进行调换，因为反向查询 a->100 100->a
        Map<String, Byte> map = new HashMap<>();
        for(Map.Entry<Byte, String> entry: huffmanCodes.entrySet()){
            map.put(entry.getValue(), entry.getKey());
        }

        // 创造要给集合，存放byte
        List<Byte> list = new ArrayList<>();
        // i可以理解成就是索引，来扫描stringBuilder
        for(int i = 0; i < stringBuilder.length();) {
            int count = 1;
            boolean flag =  true;
            Byte b = null;
            while(flag) {
                // 1010100010111
                // 递归的取出key
                // i 不动， 让count移动， 指定匹配到一个字符
                if(i + count > stringBuilder.length()) break; // 注意越界
                String key = stringBuilder.substring(i, i + count);
                b = map.get(key);

                if(b == null) {
                    // 没有匹配到
                    count++;
                } else {
                    // 匹配到
                    flag = false;
                }
            }
            if(i + count > stringBuilder.length()) break; // 越界不添加
            list.add(b);
            i += count; // i 直接移动到 count
        }

        // 当for循环结束后，我们list中就存放了所有的字符
        // 把list中的数据放入到byte[]并返回
        byte[] b = new byte[list.size()];
        for(int i = 0; i < b.length; i++) b[i] = list.get(i);
        return b;
    }

    // 文件压缩
    // 给你一个图片文件， 要求对其进行无损压缩, 看看压缩效果如何。
    // 思路： 读取文件-> 得到赫夫曼编码表 -> 完成压缩
    //编写方法， 将一个文件进行压缩
    /**
     * @param srcFile 你传入的希望压缩的文件的全路径
     * @param dstFile 我们压缩后将压缩文件放到哪个目录
     */

    public static void zipFile(String srcFile, String dstFile) {
        // 创建输出流
        OutputStream os = null;
        ObjectOutputStream oos = null;

        // 创建文件的输入流
        FileInputStream is = null;
        try{
            // 创建文件的输入流
            is = new FileInputStream(srcFile);
            // 创建一个和源文件大小一样的byte[]
            byte[] b = new byte[is.available()];
            // 读取文件
            is.read(b);
            // 直接对源文件压缩
            byte[] huffmanBytes = huffmanZip(b);
            // 创建文件的输出流，存放压缩文件
            os = new FileOutputStream(dstFile);
            // 创建一个和文件输出流关联的ObjectOutputStream
            oos = new ObjectOutputStream(os);
            // 把赫夫曼编码后的字节数组写入压缩文件
            oos.writeObject(huffmanBytes);
            // 这里我们以对象流的方式写入赫夫曼编码，是为了以后恢复源文件时使用
            // 注意一定要把赫夫曼编码写入压缩文件
            oos.writeObject(huffmanCodes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
                is.close();
                oos.close();
                os.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 文件解压(文件恢复)
    // 将前面压缩的文件，重新恢复成原来的文件
    // 思路：读取压缩文件（数据和赫夫曼编码表）-> 完成解压（文件恢复）
//编写一个方法， 完成对压缩文件的解压
    /**
     *
     *
     * @param zipFile 准备解压的文件
     * @param dstFile 将文件解压到哪个路径
     */
    public static void unZipFile(String zipFile, String dstFile) {
        // 定义文件输入流
        InputStream is = null;
        // 定义一个对象输入流
        ObjectInputStream ois = null;
        // 定义文件的输出流
        OutputStream os = null;
        try {
            // 创建文件输入流
            is = new FileInputStream(zipFile);
            // 创建一个和is关联的对象输入流
            ois = new ObjectInputStream(is);
            // 读取byte数组huffmanBytes
            byte[] huffmanBytes = (byte[]) ois.readObject();
            // 读取赫夫曼编码表
            Map<Byte, String> huffmanCodes = (Map<Byte, String>) ois.readObject();

            // 解码
            byte[] bytes = decode(huffmanCodes, huffmanBytes);
            // 将bytes数组写入到目标文件
            os = new FileOutputStream(dstFile);
            // 写数据到dstFile文件
            os.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
                os.close();
                ois.close();
                is.close();
            } catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }

    //使用一个方法， 将前面的方法封装起来， 便于我们的调用
    /**
     *
     *
     * @param bytes 原始的字符串对应的字节数组
     * @return 是经过 赫夫曼编码处理后的字节数组(压缩后的数组)
     */
    private static byte[] huffmanZip(byte[] bytes) {
        List<node> nodes = getNodes(bytes);
        // 根据nodes创建的赫夫曼树
        node huffmanTreeRoot = create_huffman_tree(nodes);
        // 对应的赫夫曼编码（根据赫夫曼树）
        Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRoot);
        // 根据生成的赫夫曼编码，压缩得到压缩后的赫夫曼编码字节数组
        byte[] huffmanCodeBytes = zip(bytes, huffmanCodes);
        return huffmanCodeBytes;
    }

    //编写一个方法， 将字符串对应的 byte[] 数组， 通过生成的赫夫曼编码表， 返回一个赫夫曼编码 压缩后的byte[]
    /**
     *@param bytes 这时原始的字符串对应的 byte[]
     * @param huffmanCodes 生成的赫夫曼编码 map
     * @return 返回赫夫曼编码处理后的 byte[]
     * 举例： String content = "i like like like java do you like a java"; =》 byte[] contentBytes = content.getBytes();
     * 返 回 的 是 字 符 串
    "1010100010111111110010001011111111001000101111111100100101001101110001110000011011101000111100101000
    101111111100110001001010011011100"
     * => 对应的 byte[] huffmanCodeBytes ， 即 8 位对应一个 byte,放入到 huffmanCodeBytes
     * huffmanCodeBytes[0] = 10101000(补码) => byte [推导 10101000=> 10101000 - 1 => 10100111(反
    码)=> 11011000= -88 ]
     * huffmanCodeBytes[1] = -88
     */
    private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
        //1.利用 huffmanCodes 将 bytes 转成 赫夫曼编码对应的字符串
        StringBuilder stringBuilder = new StringBuilder();
        //遍历 bytes 数组
        for(byte b: bytes) {
            stringBuilder.append(huffmanCodes.get(b));
        } //
//        System.out.println("测试 stringBuilder~~~=" + stringBuilder.toString());
        //将 "1010100010111111110..." 转成 byte[]
        //统计返回 byte[] huffmanCodeBytes 长度
        //一句话 int len = (stringBuilder.length() + 7) / 8;
        int len;
        if(stringBuilder.length() % 8 == 0) {
            len = stringBuilder.length() / 8;
        } else {
            len = stringBuilder.length() / 8 + 1;
        }
        //创建 存储压缩后的 byte 数组
        byte[] huffmanCodeBytes = new byte[len];
        int index = 0;//记录是第几个 byte
        for (int i = 0; i < stringBuilder.length(); i += 8) { //因为是每 8 位对应一个 byte,所以步长 +8
            String strByte;
            if(i+8 > stringBuilder.length()) {//不够 8 位
                strByte = stringBuilder.substring(i);
            }else{
                strByte = stringBuilder.substring(i, i + 8);
            }
            //将 strByte 转成一个 byte,放入到 huffmanCodeBytes
            huffmanCodeBytes[index] = (byte)Integer.parseInt(strByte, 2);
            index++;
        }
        return huffmanCodeBytes;
    }
    /**
     *@param bytes 接收字节数组
     * @return 返回的就是 List 形式 [Node[date=97 ,weight = 5], Node[]date=32,weight = 9]......],
    */
    private static List<node> getNodes(byte[] bytes) {
        // 创建一个ArrayList
        ArrayList<node> nodes = new ArrayList<>();
        // 遍历bytes, 统计每一个byte出现的次数->map[key, value]
        Map<Byte, Integer> counts = new HashMap<>();
        for (byte b : bytes) {
            counts.put(b, counts.getOrDefault(b, 0) + 1);
        }

        // 把每一个键值对转成一个node对象，并加入到nodes集合
        // 遍历map
        for(Map.Entry<Byte, Integer> entry: counts.entrySet()) {
            nodes.add(new node(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }
    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();
        for (byte b : contentBytes)
            System.out.print(b + " ");
        System.out.println(contentBytes.length); //40
        byte[] huffmanCodesBytes= huffmanZip(contentBytes);
        System.out.println(" 压 缩 后 的 结 果 是 :" + Arrays.toString(huffmanCodesBytes) + " 长 度 = " +
                huffmanCodesBytes.length);
        //测试一把 byteToBitString 方法
        //System.out.println(byteToBitString((byte)1));
        byte[] sourceBytes = decode(huffmanCodes, huffmanCodesBytes);
        System.out.println("原来的字符串=" + new String(sourceBytes)); // "i like like like java do you like a java"
    }

}

