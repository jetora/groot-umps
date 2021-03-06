package org.flow.utils.common.utils;

import org.flow.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TreeUtil {
    /**
     * 两层循环实现建树
     *
     * @param treeNodes 传入的树节点列表
     * @return
     */
    public static <T extends TreeNode> List<T> bulid(List<T> treeNodes, Object root) {
        List<T> trees = new ArrayList<T>();

        for (T treeNode : treeNodes) {
            if (root.equals(treeNode.getParentId())){
                trees.add(treeNode);
            }
            for (T t : treeNodes){
                if (t.getParentId().equals(treeNode.getId())){
                    if (treeNode.getChildren()==null){
                        treeNode.setChildren(new ArrayList<TreeNode>());
                    }
                    treeNode.add(t);
                }
            }
        }
        return trees;
    }

    /**
     * 使用递归方法建树
     *
     * @param treeNodes
     * @return
     */
    public static <T extends TreeNode> List<T> buildByRecursive(List<T> treeNodes, Object root) {

        List<T> trees = new ArrayList<>();
        for (T treeNode : treeNodes){
            if (root.equals(treeNode.getParentId())){
                trees.add(findChildren(treeNode, treeNodes));
            }
        }
        return trees;
    }

    /**
     * 递归查找子节点
     *
     * @param treeNodes
     * @return
     */
    public static <T extends TreeNode> T findChildren(T treeNode, List<T> treeNodes) {
        for (T it : treeNodes) {
            if (treeNode.getId().equals(it.getParentId())){
                if (treeNode.getChildren() == null){
                    treeNode.setChildren(new ArrayList<TreeNode>());
                }
                treeNode.add(findChildren(it,treeNodes));
            }
        }
        return treeNode;
    }
}
