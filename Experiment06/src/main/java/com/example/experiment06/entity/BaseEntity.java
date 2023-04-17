package com.example.experiment06.entity;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

/**
 * @author Owem
 * @date 2023/4/17 15:50
 * @description TODO
 **/
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
    /*
     * 创建时间
     */
    @CreatedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Long createTime;

    /*
     * 最后修改时间
     */
    @LastModifiedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Long updateTime;

    /*
     * 创建人
     */
    @Column(name = "create_by")
    @CreatedBy
    private Long createBy;

    /*
     * 修改人
     */
    @Column(name = "last-modified_by")
    @LastModifiedBy
    private String lastModifiedBy;

    //省略 getterx setter 方法
}
