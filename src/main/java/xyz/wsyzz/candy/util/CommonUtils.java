package xyz.wsyzz.candy.util;

import xyz.wsyzz.candy.entity.VO.MenuTreeDataVO;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by xucan on 2022/3/28.
 */
public class CommonUtils {

    public static <T,R> List<T> buildTreeData(Collection<T> collection,
                                              Function<T,R> idFunction,
                                              Function<T,R> parentIdFunction,
                                              Function<T,Consumer<List<T>>> setChildren,
                                              R rootId) {
        Map<R, T> collect = collection.stream().collect(Collectors.toMap(item -> idFunction.apply(item), item -> item, (v, val) -> v));
        List<T> children = new ArrayList<>();
        Iterator<T> iterator = collection.iterator();
        while (iterator.hasNext()){
            T next = iterator.next();
            if (rootId.equals(parentIdFunction.apply(next))) {
                children.add(next);
                 // iterator.remove();
                setChildren.apply(next).accept(buildTreeData(collection, idFunction, parentIdFunction, setChildren, idFunction.apply(next)));
            }
        }
        return children;
    }

    public static void main(String[] args) {
        ArrayList<MenuTreeDataVO> menuTreeDataVOS = new ArrayList<MenuTreeDataVO>() {
            {
                add(new MenuTreeDataVO() {
                    {
                        setId(1L);
                        setPid(0L);
                    }
                });
                add(new MenuTreeDataVO() {
                    {
                        setId(2L);
                        setPid(1L);
                    }
                });
                add(new MenuTreeDataVO() {
                    {
                        setId(3L);
                        setPid(1L);
                    }
                });
                add(new MenuTreeDataVO() {
                    {
                        setId(4L);
                        setPid(2L);
                    }
                });
                add(new MenuTreeDataVO() {
                    {
                        setId(5L);
                        setPid(2L);
                    }
                });
                add(new MenuTreeDataVO() {
                    {
                        setId(6L);
                        setPid(3L);
                    }
                });
                add(new MenuTreeDataVO() {
                    {
                        setId(7L);
                        setPid(4L);
                    }
                });
            }
        };
        CopyOnWriteArrayList<Object> objects = new CopyOnWriteArrayList<>();
        objects.add("");
        List<MenuTreeDataVO> menuTreeDataVOS1 = buildTreeData(menuTreeDataVOS, MenuTreeDataVO::getParamId , MenuTreeDataVO::getParamPid, item -> item::setChildren, 0L);
        System.out.println(menuTreeDataVOS1);
    }
}
