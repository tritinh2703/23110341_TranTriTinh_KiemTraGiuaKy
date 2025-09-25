package vn.iotstar.dao;

import vn.iotstar.entity.Videos_23110341;
import java.util.List;

public interface VideoDao_23110341 {
    void create(Videos_23110341 v);
    void update(Videos_23110341 v);
    void delete(String videoId);
    Videos_23110341 findById(String id);
    long countAll();
    List<Videos_23110341> findPage(int page, int size);
}
