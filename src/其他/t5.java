package 其他;

import java.util.HashMap;

public class t5 {
}

class UnionFind {
    HashMap<Integer, Integer> map = new HashMap<>();

    void add(int x) {
        // 添加：将x加入到并查集中（孤立状态，父节点为空）
        if (!map.containsKey(x)) {
            map.put(x, null);
        }
    }

    boolean contains(int x) {
        // 查找：查找x是否在并查集中
        return map.containsKey(x);
    }

    void merge(int x, int y) {
        // 合并：将并查集中的两个节点所在的连通子集合并（意味着两个节点所在的连通子集变成连通状态）
        int rootX = find(x);
        int rootY = find(y);
        // 如果x和y的根节点不同，说明两者不连通，将rootX设置为rootY的父节点（或者反过来也行），就连通了
        if (rootX != rootY) {
            map.put(rootX, rootY);
        }
    }

    boolean isConnected(int x, int y) {
        // 判断两个节点是否连通
        return find(x) == find(y);
    }

    int find(int x) {
        // 找到x的根节点，如果在查找过程中树的深度大于2，则进行路径压缩
        int root = x;
        while (map.get(root) != null) {
            root = map.get(root);
        }
        // 路径压缩
        while (map.get(x) != root) {
            int tmp = map.get(x);
            map.put(x, root);
            x = tmp;
        }
        return root;
    }
}