package me.myblog.framework.domain.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 评论表(Comment)表实体类
 *
 * @author makejava
 * @since 2022-10-29 18:26:30
 */
@Data
@ApiModel(description = "评论实体类")
@TableName("comment")
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    @TableId(type = IdType.AUTO)
    private Long id;
    //评论类型(0代表文章评论,1代表链接评论)
    private String type;
    //文章id
    private Long articleId;
    //根评论id
    private Long rootId;
    //评论内容
    private String content;
    //所回复的目标评论的userid
    private Long toCommentUserId;
    //回复目标评论id
    private Long toCommentId;
    @TableField(fill = FieldFill.INSERT)
    private Long createBy;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateBy;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    //删除标志(0代表未删除,1代表已删除)
    @TableLogic
    private Integer deleteFlag;

}
