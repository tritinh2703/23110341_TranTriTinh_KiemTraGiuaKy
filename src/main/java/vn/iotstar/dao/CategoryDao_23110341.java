package vn.iotstar.dao;

import vn.iotstar.entity.Category_23110341;
import java.util.List;

public interface CategoryDao_23110341 {
    List<Category_23110341> findAll();
    List<Object[]> countVideosPerCategory(); // [Category, count]
}
