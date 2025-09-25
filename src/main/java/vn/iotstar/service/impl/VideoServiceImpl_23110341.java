package vn.iotstar.service.impl;

import vn.iotstar.dao.VideoDao_23110341;
import vn.iotstar.dao.impl.VideoDaoImpl_23110341;
import vn.iotstar.entity.Videos_23110341;
import vn.iotstar.service.VideoService_23110341;
import java.util.List;

public class VideoServiceImpl_23110341 implements VideoService_23110341 {
    private final VideoDao_23110341 dao = new VideoDaoImpl_23110341();

    @Override public List<Videos_23110341> findPage(int page, int size){ return dao.findPage(page,size);}
    @Override public long countAll(){ return dao.countAll(); }
    @Override public Videos_23110341 findById(String id){ return dao.findById(id); }
    @Override public void create(Videos_23110341 v){ dao.create(v); }
    @Override public void update(Videos_23110341 v){ dao.update(v); }
    @Override public void delete(String id){ dao.delete(id); }
}
