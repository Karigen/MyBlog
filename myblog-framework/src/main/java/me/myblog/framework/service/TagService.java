package me.myblog.framework.service;

import com.baomidou.mybatisplus.extension.service.IService;
import me.myblog.framework.domain.entity.Tag;

import java.util.List;

/**
 * 标签(Tag)表服务接口
 *
 * @author makejava
 * @since 2022-10-29 18:26:30
 */
public interface TagService extends IService<Tag> {

    List<Tag> pageTagList(Integer pageNumber, Integer pageSize, String name, String remark);
}

