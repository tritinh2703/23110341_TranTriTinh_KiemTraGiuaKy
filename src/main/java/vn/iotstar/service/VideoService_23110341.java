package vn.iotstar.service;

import vn.iotstar.entity.Videos_23110341;
import java.util.List;

public interface VideoService_23110341 {
    List<Videos_23110341> findPage(int page, int size);
    long countAll();
    Videos_23110341 findById(String id);
    void create(Videos_23110341 v);
    void update(Videos_23110341 v);
    void delete(String id);
    List<Videos_23110341> findAll();
}
