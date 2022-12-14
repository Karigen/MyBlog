package me.myblog.framework.service;

import com.baomidou.mybatisplus.extension.service.IService;
import me.myblog.framework.domain.entity.Category;

import java.util.List;

/**
 * 分类表(Category)表服务接口
 *
 * @author makejava
 * @since 2022-10-29 18:26:30
 */
public interface CategoryService extends IService<Category> {

    List<Category> categoryList();
}

